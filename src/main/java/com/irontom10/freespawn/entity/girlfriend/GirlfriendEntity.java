package com.irontom10.freespawn.entity.girlfriend;

import com.irontom10.freespawn.main;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.RangedAttackMob;


public class GirlfriendEntity extends TamableAnimal implements RangedAttackMob {
    // 1) Data parameters
    private static final EntityDataAccessor<Integer> TYPE = SynchedEntityData.defineId(GirlfriendEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> WET_TYPE = SynchedEntityData.defineId(GirlfriendEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> VOICE = SynchedEntityData.defineId(GirlfriendEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> PRINCESS = SynchedEntityData.defineId(GirlfriendEntity.class, EntityDataSerializers.BOOLEAN);
    // …add more flags as you need…

    public GirlfriendEntity(EntityType<? extends TamableAnimal> type, Level world) {
        super(type, world);
        this.setCanPickUpLoot(true);
        this.xpReward = 0;
    }
    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob mate) {
        // you can return a new GirlfriendEntity if you want them to breed,
        // or just return null to disable breeding entirely:
        return null;
    }
    /** Attribute registration */
    public static AttributeSupplier.Builder createAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 80.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 8.0);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TYPE, 0);
        this.entityData.define(WET_TYPE, 0);
        this.entityData.define(VOICE, 0);
        this.entityData.define(PRINCESS, false);
        // … etc …
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.25, Ingredient.of(Items.POPPY), false));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.4, 12f, 1.5f, false));
        this.goalSelector.addGoal(4, new RangedAttackGoal(this, 1.25, 20, 10f));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.75));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6f));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        //… add your custom AI goals here …
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        //… custom target goals …
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        // your UltimateArrow logic here
    }

    @Override
    public void tick() {
        super.tick();
        // replace onLivingUpdate + onUpdate logic
        if (this.isInWater())
            this.entityData.set(WET_TYPE, 500);
        else if (this.entityData.get(WET_TYPE) > 0)
            this.entityData.set(WET_TYPE, this.entityData.get(WET_TYPE) - 1);

        // auto‐heal
        if (this.tickCount % 100 == 0 && this.getHealth() < this.getMaxHealth()) {
            this.heal(1.0f);
        }
        // sync forced flags, size changes, etc.
    }


    @Override
    public boolean causeFallDamage(float fallDistance, float damageMultiplier, DamageSource source) {
        return super.causeFallDamage(fallDistance, damageMultiplier, source);
    }


    @Override
    public boolean hurt(DamageSource source, float amount) {
        // your custom damage logic
        return super.hurt(source, amount);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("GirlType", this.entityData.get(TYPE));
        tag.putInt("WetType", this.entityData.get(WET_TYPE));
        tag.putInt("Voice", this.entityData.get(VOICE));
        tag.putBoolean("Princess", this.entityData.get(PRINCESS));
        // …
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(TYPE, tag.getInt("GirlType"));
        this.entityData.set(WET_TYPE, tag.getInt("WetType"));
        this.entityData.set(VOICE, tag.getInt("Voice"));
        this.entityData.set(PRINCESS, tag.getBoolean("Princess"));
        // …
    }

    public boolean CanSpawnSprint() {
        return false; // no despawn
    }
    public ResourceLocation getTexture() {
        boolean inWater = this.isInWater();

        // pick prefix and clamp limits
        String prefix = inWater ? "bikini" : "girlfriend";
        int maxIndex = inWater ? 17 : 40;

        // fetch via our getters
        int index = inWater
                ? getWhichWetGirl()
                : getWhichGirl();

        // clamp just in case
        index = Mth.clamp(index, 0, maxIndex);

        return new ResourceLocation(
                main.MOD_ID,
                prefix + index + ".png"
        );
    }

    // in GirlfriendEntity.java, after defineSynchedData()…

    /**
     * @return the dry-land texture index (0–40)
     */
    public int getWhichGirl() {
        return this.entityData.get(TYPE);
    }

    /**
     * Set the dry-land texture index (clamped to 0–40).
     */
    public void setWhichGirl(int value) {
        int v = Mth.clamp(value, 0, 40);
        this.entityData.set(TYPE, v);
    }

    /**
     * @return the water-bikini texture index (0–17)
     */
    public int getWhichWetGirl() {
        return this.entityData.get(WET_TYPE);
    }

    /**
     * Set the water-bikini texture index (clamped to 0–17).
     */
    public void setWhichWetGirl(int value) {
        int v = Mth.clamp(value, 0, 17);
        this.entityData.set(WET_TYPE, v);
    }


    // … your interact(), getTexture() (in your renderer), spawn conditions, etc. …
}