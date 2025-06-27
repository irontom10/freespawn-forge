package com.irontom10.freespawn.entity.Bee;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

public class BeeEntity extends Monster {
    private int stuckCount = 0;
    private int lastX = 0;
    private int lastZ = 0;
    private int attacking = 0;
    private LivingEntity currentTarget = null;
    private Vec3 flightTarget = null;
    private float moveForward;

    public BeeEntity(EntityType<? extends Monster> type, Level world) {
        super(type, world);
        this.moveControl = new FlyingMoveControl(this, 10, true);
        this.xpReward = 25;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new BeeRandomFlyGoal());
        this.goalSelector.addGoal(1, new BeeAttackGoal());
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 80.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ATTACK_DAMAGE, 12.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D)
                .add(Attributes.FLYING_SPEED, 0.35D);
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
        return false;
    }
    
    public boolean isFlying() {
        return !this.onGround();
    }

    @Override
    public boolean canBeLeashed(Player player) {
        return false;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return !this.isNoAi();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.lastX == (int) this.getX() && this.lastZ == (int) this.getZ()) {
            ++this.stuckCount;
        } else {
            this.stuckCount = 0;
            this.lastX = (int) this.getX();
            this.lastZ = (int) this.getZ();
        }
        // Poison water attackers
        if (this.isInWater() && this.level().random.nextInt(4) == 1 && this.getTarget() != null) {
            this.doHurtTarget(this.getTarget());
        }
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean result = super.doHurtTarget(target);
        if (target instanceof LivingEntity) {
            ((LivingEntity) target).addEffect(new MobEffectInstance(MobEffects.POISON, 50, 0));
        }
        return result;
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHit) {
        // Example drops, adjust as needed
        this.spawnAtLocation(new ItemStack(net.minecraft.world.item.Items.GOLD_NUGGET, 4 + this.random.nextInt(6)));
        this.spawnAtLocation(new ItemStack(net.minecraft.world.item.Items.SUGAR, 4 + this.random.nextInt(6)));
    }

    // Sound stubs (replace with your own sounds if needed)
    @Override
    protected SoundEvent getAmbientSound() { return null; }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) { return null; }
    @Override
    protected SoundEvent getDeathSound() { return null; }

    // Attacking state
    public int getAttacking() { return this.attacking; }
    public void setAttacking(int value) { this.attacking = value; }

    public boolean isAttacking() {
        return this.attacking != 0;
    }

    // Custom flying and attack AI
    class BeeRandomFlyGoal extends Goal {
        public BeeRandomFlyGoal() { this.setFlags(EnumSet.of(Goal.Flag.MOVE)); }
        @Override
        public boolean canUse() { return BeeEntity.this.getTarget() == null && !BeeEntity.this.isAttacking(); }
        @Override
        public void start() { setRandomFlightTarget(); }
        @Override
        public void tick() {
            if (flightTarget == null || stuckCount > 50 || BeeEntity.this.distanceToSqr(flightTarget) < 2.1F) {
                setRandomFlightTarget();
                stuckCount = 0;
            }
            Vec3 dir = flightTarget.subtract(BeeEntity.this.position());
            BeeEntity.this.setDeltaMovement(BeeEntity.this.getDeltaMovement().add(
                    (Math.signum(dir.x) * 0.5 - BeeEntity.this.getDeltaMovement().x) * 0.3,
                    (Math.signum(dir.y) * 0.7 - BeeEntity.this.getDeltaMovement().y) * 0.2,
                    (Math.signum(dir.z) * 0.5 - BeeEntity.this.getDeltaMovement().z) * 0.3));
            // Only set yaw if not attacking
            if (!BeeEntity.this.isAttacking()) {
                float yaw = (float)(Math.atan2(dir.z, dir.x) * (180F / Math.PI)) - 90.0F;
                BeeEntity.this.setYRot(yaw);
                BeeEntity.this.yBodyRot = yaw;
            }
            BeeEntity.this.moveForward = 1.0f;
        }
        private void setRandomFlightTarget() {
            double x = BeeEntity.this.getX() + BeeEntity.this.getRandom().nextInt(18) - 9;
            double y = BeeEntity.this.getY() + BeeEntity.this.getRandom().nextInt(6) - 3;
            double z = BeeEntity.this.getZ() + BeeEntity.this.getRandom().nextInt(18) - 9;
            flightTarget = new Vec3(x, y, z);
        }
    }

    class BeeAttackGoal extends Goal {
        public BeeAttackGoal() { this.setFlags(EnumSet.of(Goal.Flag.TARGET, Goal.Flag.LOOK)); }
        @Override
        public boolean canUse() {
            LivingEntity target = findTarget();
            if (target != null) {
                BeeEntity.this.currentTarget = target;
                return true;
            }
            return false;
        }
        @Override
        public void start() {
            BeeEntity.this.setAttacking(1);
        }
        @Override
        public void stop() {
            BeeEntity.this.setAttacking(0);
            BeeEntity.this.currentTarget = null;
        }
        @Override
        public void tick() {
            LivingEntity target = BeeEntity.this.currentTarget;
            if (target == null || !target.isAlive() || !canAttackTarget(target)) {
                this.stop();
                return;
            }
            BeeEntity.this.getLookControl().setLookAt(target, 30.0F, 30.0F);
            BeeEntity.this.getNavigation().moveTo(target, 1.2D);
            // Set yaw to face the target
            Vec3 dir = target.position().subtract(BeeEntity.this.position());
            float yaw = (float)(Math.atan2(dir.z, dir.x) * (180F / Math.PI)) - 90.0F;
            BeeEntity.this.setYRot(yaw);
            BeeEntity.this.yBodyRot = yaw;
            if (BeeEntity.this.distanceToSqr(target) < 4.0D) {
                BeeEntity.this.doHurtTarget(target);
            }
        }
        private LivingEntity findTarget() {
            List<LivingEntity> list = BeeEntity.this.level().getEntitiesOfClass(LivingEntity.class, BeeEntity.this.getBoundingBox().inflate(10.0, 6.0, 10.0),
                    e -> canAttackTarget(e));
            return list.isEmpty() ? null : list.get(0);
        }
        private boolean canAttackTarget(LivingEntity entity) {
            if (entity == null || entity == BeeEntity.this || !entity.isAlive()) return false;
            if (entity instanceof Player && ((Player)entity).isCreative()) return false;
            return true;
        }
    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        return new FlyingPathNavigation(this, world);
    }
}
