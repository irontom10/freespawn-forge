package com.irontom10.freespawn.item.armor;

import com.irontom10.freespawn.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

import static com.irontom10.freespawn.main.MOD_ID;

public enum ModArmorMaterials implements ArmorMaterial {
    //ARMOR DEFINITIONS
    AMETHYST("amethyst", 100,   new int[]{ 4,  8,  7,  3},  40, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.AMETHYST.get())),
    EMERALD("emerald",   60,   new int[]{ 3,  8,  6,  3},  40, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(Items.EMERALD)),
    EXPERIENCE("experience",70,new int[]{ 5,  9,  7,  4},  50, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(Items.EMERALD)),
    MOTHSCALE("mothscale",  50,new int[]{ 2,  7,  5,  2},  50, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.MOTHSCALE.get())),
    LAVAEEL("lavaeel",     40, new int[]{ 2,  7,  5,  2},  35, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.LAVAEEL.get())),
    ULTIMATE("ultimate",   200, new int[]{ 6, 12, 10,  6}, 100, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.EMPTY),
    PINK_TOURMAILINE("pink_tourmailine",           50,  new int[]{ 3,  7,  5,  2},  40, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.PINK_TOURMALINE_INGOT.get())),
    TIGERSEYE("tigerseye",  80, new int[]{ 4,  8,  7,  4},  55, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.TIGERSEYE_INGOT.get())),
    PEACOCK("peacock",     40,  new int[]{ 2,  5,  4,  2},  30, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.PEACOCK_FEATHER.get())),
    MOBZILLA("mobzilla",  1000, new int[]{ 7, 13, 11,  7}, 150, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.MOBZILLA_SCALE.get())),
    RUBY("ruby",           90,  new int[]{ 4,  9,  8,  4},  40, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(ModItems.RUBY.get())),
    ROYAL("royal",        2000, new int[]{ 8, 14, 12,  8}, 200, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.EMPTY),
    LAPIS("lapis",         60,  new int[]{ 2,  7,  5,  2},  60, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, () -> Ingredient.of(Items.LAPIS_BLOCK)),
    QUEEN("queen",       1500,  new int[]{ 9, 16, 14,  9}, 150, SoundEvents.ARMOR_EQUIP_TURTLE, 1f,10f,() -> Ingredient.of(ModItems.QUEEN_SCALE.get()));


    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11, 16, 16, 13};

    ModArmorMaterials(String name, int durabilityMulitplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMulitplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}