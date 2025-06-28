package com.irontom10.freespawn.entity.girlfriend;

import com.irontom10.freespawn.entity.shoe.ShoeEntity;
import com.irontom10.freespawn.main;
import com.irontom10.freespawn.sound.ModSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

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
        if(!world.isClientSide) {
            this.setWhichGirl(this.random.nextInt(41));    // 0-40 inclusive
            this.setWhichWetGirl(this.random.nextInt(18)); // 0-17 inclusive
        }
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob mate) {
        return null;
    }
    @Override
    public boolean isBaby() {
        return false;
    }
    /** Attribute registration */
    public static AttributeSupplier.Builder createAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 80.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, 8.0)
                .add(Attributes.ARMOR, 8.0);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TYPE, 0);
        this.entityData.define(WET_TYPE, 0);
        this.entityData.define(VOICE, 0);
        this.entityData.define(PRINCESS, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.25, Ingredient.of(Items.POPPY), false));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.4, 12f, 1.5f, false));

        // NEW: melee attack if holding a sword (or unarmed)
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, /*longMemory=*/ true));

        // NEW: ranged attack if holding a bow (will only fire if performRangedAttack is implemented)
        this.goalSelector.addGoal(5, new RangedAttackGoal(this, 1.25D, 20, 10.0F));


        // movement + look
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.75));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        // TARGETING: help the owner if they get hurt…
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        // …and target any hostile monster when tamed:
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<Monster>(
                this,           // our entity
                Monster.class,  // target class
                10,             // targetChance: checks every 10 ticks
                true,           // mustSee
                false,          // onlyNearby
                null            // no extra filter
        ));
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        // She can throw shoes even if not wearing any
        if (!this.level().isClientSide && target != null && this.isAlive()) {
            Item[] shoes = new Item[] {
                com.irontom10.freespawn.item.ModItems.RED_HEELS.get(),
                com.irontom10.freespawn.item.ModItems.BLACK_HEELS.get(),
                com.irontom10.freespawn.item.ModItems.SLIPPERS.get(),
                com.irontom10.freespawn.item.ModItems.BOOTS.get()
            };
            Item shoeToThrow = shoes[this.random.nextInt(shoes.length)];
            ItemStack stack = new ItemStack(shoeToThrow);
            // Use your custom ShoeEntity
            ShoeEntity proj = new ShoeEntity(this.level(), this);
            proj.setItem(stack);
            // Calculate direction
            double dX = target.getX() - this.getX();
            double dY = target.getY(0.333) - proj.getY();
            double dZ = target.getZ() - this.getZ();
            double dist = Math.sqrt(dX * dX + dZ * dZ);
            // Set velocity (replace with your method if needed)
            proj.shoot(dX, dY + dist * 0.2, dZ, 1.2F, 6.0F);
            this.level().addFreshEntity(proj);
        }
    }
    @Override
    public int getAmbientSoundInterval() {
        // If sitting/quiet, don't make noise
        if (this.isOrderedToSit()) {
            return Integer.MAX_VALUE; // Effectively disables ambient sound
        }
        return this.random.nextInt(1200);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        // If sitting/quiet, don't make noise
        if (this.isOrderedToSit()) {
            return null;
        }
        // e.g. water vs rain vs dark vs default
        if (this.isInWater()) {
            return ModSounds.GIRLFIREND_WATER.get();
        }
        if (this.level().isRaining()) {
            return ModSounds.GIRLFIREND_RAIN.get();
        }
        if (!this.level().isDay()) {
            return ModSounds.GIRLFIREND_DARK.get();
        }
        // fallback to a random “happy” if tamed, or null
        return this.isTame()
                ? ModSounds.GIRLFIREND_HAPPY.get()  // or pick randomly HAPPY1–HAPPY7
                : null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource ds) {
        return ModSounds.GIRLFIREND_HURT.get();  // or random HURT1–HURT9
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.isTame()
                ? ModSounds.GIRLFIREND_DEATH.get()
                : ModSounds.GIRLFIREND_DEATH_SINGLE.get();
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
    @Override
    public boolean causeFallDamage(float fallDistance, float damageMultiplier, DamageSource source) {
        return false; // No fall damage
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


    public int getWhichGirl() {
        return this.entityData.get(TYPE);
    }
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // 1. TAME if not tamed yet
        if (!this.isTame() && stack.getItem() == Items.POPPY) {
            if (!player.level().isClientSide) {
                if (this.random.nextInt(3) == 0) {
                    this.tame(player);
                    this.navigation.stop();
                    this.setTarget(null);
                    this.level().broadcastEntityEvent(this, (byte)7); // heart particles
                } else {
                    this.level().broadcastEntityEvent(this, (byte)6); // smoke particles
                }
                stack.shrink(1);
            }
            return InteractionResult.sidedSuccess(player.level().isClientSide);
        }

        // Only owner can equip / unequip
        if (this.isTame() && this.isOwnedBy(player)) {
            // 2. EQUIP ARMOR if holding an armor item
            if (stack.getItem() instanceof ArmorItem) {
                EquipmentSlot slot = ((ArmorItem)stack.getItem()).getEquipmentSlot();
                ItemStack previous = this.getItemBySlot(slot);
                this.setItemSlot(slot, stack.copy());
                // give back the old piece (if any)
                if (!player.getInventory().add(previous)) {
                    player.drop(previous, false);
                }
                stack.shrink(1);
                return InteractionResult.sidedSuccess(player.level().isClientSide);
            }
            // 3. EQUIP WEAPON if holding a sword or bow
            if (stack.getItem() instanceof SwordItem
                    || stack.getItem() instanceof BowItem
                    || stack.getItem() instanceof TridentItem)
            {
                ItemStack prevMain = this.getMainHandItem();
                this.setItemSlot(EquipmentSlot.MAINHAND, stack.copy());
                if (!player.getInventory().add(prevMain)) {
                    player.drop(prevMain, false);
                }
                stack.shrink(1);
                return InteractionResult.sidedSuccess(player.level().isClientSide);
            }
            // 4. UNEQUIP: empty hand + crouch
            if (stack.isEmpty() && player.isShiftKeyDown()) {
                // drop all gear
                for (EquipmentSlot slot : EquipmentSlot.values()) {
                    ItemStack gear = this.getItemBySlot(slot);
                    if (!gear.isEmpty()) {
                        this.setItemSlot(slot, ItemStack.EMPTY);
                        player.getInventory().add(gear);
                    }
                }
                return InteractionResult.sidedSuccess(player.level().isClientSide);
            }
            // 5. Change skin with dandelion
            if (stack.getItem() == Items.DANDELION) {
                if (!player.level().isClientSide) {
                    // Pick a new random skin
                    this.setWhichGirl(this.random.nextInt(41));
                }
                stack.shrink(1);
                return InteractionResult.sidedSuccess(player.level().isClientSide);
            }
            // 6. Heal with food
            if (stack.getItem().isEdible()) {
                if (this.getHealth() < this.getMaxHealth()) {
                    if (!player.level().isClientSide) {
                        int healAmount = stack.getItem().getFoodProperties().getNutrition();
                        this.heal((float)healAmount);
                    }
                    stack.shrink(1);
                    return InteractionResult.sidedSuccess(player.level().isClientSide);
                }
            }
            // 7. Sit/quiet toggle with diamond
            if (stack.getItem() == Items.DIAMOND) {
                if (!player.level().isClientSide) {
                    this.setOrderedToSit(!this.isOrderedToSit());
                }
                return InteractionResult.sidedSuccess(player.level().isClientSide);
            }
            // 8. Allow holding any item (not just weapons/armor)
            if (!(stack.getItem() instanceof ArmorItem) &&
                !(stack.getItem() instanceof SwordItem) &&
                !(stack.getItem() instanceof BowItem) &&
                !(stack.getItem() instanceof TridentItem) &&
                stack.getItem() != Items.DANDELION &&
                !stack.getItem().isEdible() &&
                stack.getItem() != Items.DIAMOND) {
                ItemStack prevMain = this.getMainHandItem();
                this.setItemSlot(EquipmentSlot.MAINHAND, stack.copy());
                if (!player.getInventory().add(prevMain)) {
                    player.drop(prevMain, false);
                }
                stack.shrink(1);
                return InteractionResult.sidedSuccess(player.level().isClientSide);
            }
        }

        // fallback to sitting behaviour
        return super.mobInteract(player, hand);
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

    // Auto-regen fields
    private long lastCombatTick = 0;
    private long lastRegenTick = 0;

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);
        if (!this.level().isClientSide) {
            this.lastCombatTick = this.level().getGameTime();
        }
        return result;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide && this.isAlive()) {
            long now = this.level().getGameTime();
            // Only regen if 30s (600 ticks) since last combat
            if (now - lastCombatTick >= 600 && now - lastRegenTick >= 200 && this.getHealth() < this.getMaxHealth()) {
                this.heal(1.0F);
                this.lastRegenTick = now;
            }
            // Reset regen timer if in combat
            if (now - lastCombatTick < 600) {
                this.lastRegenTick = now;
            }
        }
    }

    @Override
    public boolean fireImmune() {
        return true;
    }



    // … your interact(), getTexture() (in your renderer), spawn conditions, etc. …
}