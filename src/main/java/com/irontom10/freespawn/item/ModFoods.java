package com.irontom10.freespawn.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;



public class ModFoods {
    public  static final FoodProperties FIRE_FISH = new FoodProperties.Builder()
            .nutrition(4)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,1200,0), 1F)
            .build();
    public  static final FoodProperties SUN_FISH = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,6000,0), 1F)
            .nutrition(6)
            .build();
    public  static final FoodProperties LAVAEEL = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,600,0), 1F)
            .nutrition(2)
            .build();
    public  static final FoodProperties SPARK_FISH = new FoodProperties.Builder()
            .nutrition(1)
            .build();
    public  static final FoodProperties POPCORN = new FoodProperties.Builder()
            .nutrition(1)
            .build();
    public  static final FoodProperties POPCORN_BUTTERED = new FoodProperties.Builder()
            .nutrition(2)
            .build();
    public  static final FoodProperties POPCORN_BUTTERED_SALTED = new FoodProperties.Builder()
            .nutrition(3)
            .build();
    public  static final FoodProperties BAG_OF_POPCORN = new FoodProperties.Builder()
            .nutrition(10)
            .build();
    public  static final FoodProperties COOKED_CORN_DOG = new FoodProperties.Builder()
            .nutrition(16)
            .build();
    public  static final FoodProperties CHEESE = new FoodProperties.Builder()
            .nutrition(4)
            .build();
    public  static final FoodProperties RAW_CORN_DOG = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F)
            .nutrition(4)
            .build();
    public  static final FoodProperties COOKED_PEACOCK = new FoodProperties.Builder()
            .nutrition(6)
            .build();
    public  static final FoodProperties RAW_PEACOCK = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F)
            .nutrition(3)
            .build();
    public  static final FoodProperties RAW_BACON = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F)
            .nutrition(8)
            .build();
    public  static final FoodProperties COOKED_BACON = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2000, 0), 1F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 2000, 0), 0.3F)
            .nutrition(14)
            .build();
    public  static final FoodProperties RAW_CRAB_MEAT = new FoodProperties.Builder()
            .nutrition(4)
            .build();
    public  static final FoodProperties COOKED_CRAB_MEAT = new FoodProperties.Builder()
            .nutrition(6)
            .build();
    public static final FoodProperties BUTTER_CANDY = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800,0),1F)
            .effect(new MobEffectInstance(MobEffects.JUMP, 1800, 0), 1F)
            .alwaysEat()
            .fast()
            .nutrition(4)
            .saturationMod(0.3F)
            .build();
    public static final FoodProperties GREEN_FISH = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3F).meat().build();
    public static final FoodProperties BLUE_FISH = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3F).meat().build();
    public static final FoodProperties PINK_FISH = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3F).meat().build();
    public static final FoodProperties JEW_FISH = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3F).meat().build();
    public static final FoodProperties ROCK_FISH = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3F).meat().build();
    public static final FoodProperties WOOD_FISH = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.3F).meat().build();
    public static final FoodProperties GRAY_FISH = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.3F).meat().build();
    public static final FoodProperties GARDEN_SALAD = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(0.3F).build();
    public static final FoodProperties BLT_SANDWITCH = new FoodProperties.Builder()
            .nutrition(12)
            .saturationMod(0.3F).build();
    public static final FoodProperties A_CRABBY_PATTY = new FoodProperties.Builder()
            .nutrition(16)
            .saturationMod(0.3F).build();
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.3F).build();
    public static final FoodProperties CRYSTAL_APPLE = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3000, 0),1F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 3000, 0),1F)
            .nutrition(5)
            .saturationMod(0.3F).build();
    public static final FoodProperties LOVE = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 4800, 0), 1F)
            .effect(new MobEffectInstance(MobEffects.JUMP, 4800,0),1F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 2), 1F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 6000, 3), 1F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000,1), 1F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 2), 1F)
            .nutrition(8)
            .saturationMod(0.3F).meat().build();
    public static final FoodProperties CHERRIES = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3F).build();
    public static final FoodProperties PEACH = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3F).build();
    public static final FoodProperties RADISH = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.3F).build();
    public static final FoodProperties RICE = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.3F).build();
    public static final FoodProperties CORN = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.3F).build();
    public static final FoodProperties QUINOA = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.3F).build();
    public static final FoodProperties TOMATO = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3F).build();
    public static final FoodProperties LETTUCE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3F).build();

}