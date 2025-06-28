package com.irontom10.freespawn.item;

import com.irontom10.freespawn.entity.ModEntities;
import com.irontom10.freespawn.item.armor.amethyst.AmethystBoots;
import com.irontom10.freespawn.item.armor.amethyst.AmethystChestplate;
import com.irontom10.freespawn.item.armor.amethyst.AmethystHelmet;
import com.irontom10.freespawn.item.armor.amethyst.AmethystLeggings;
import com.irontom10.freespawn.item.armor.emerald.EmeraldBoots;
import com.irontom10.freespawn.item.armor.emerald.EmeraldChestplate;
import com.irontom10.freespawn.item.armor.emerald.EmeraldHelmet;
import com.irontom10.freespawn.item.armor.emerald.EmeraldLeggings;
import com.irontom10.freespawn.item.armor.experience.ExperienceBoots;
import com.irontom10.freespawn.item.armor.experience.ExperienceChestplate;
import com.irontom10.freespawn.item.armor.experience.ExperienceHelmet;
import com.irontom10.freespawn.item.armor.experience.ExperienceLeggings;
import com.irontom10.freespawn.item.armor.lapis.LapisBoots;
import com.irontom10.freespawn.item.armor.lapis.LapisChestplate;
import com.irontom10.freespawn.item.armor.lapis.LapisHelmet;
import com.irontom10.freespawn.item.armor.lapis.LapisLeggings;
import com.irontom10.freespawn.item.armor.lavaeel.LavaeelBoots;
import com.irontom10.freespawn.item.armor.lavaeel.LavaeelChestplate;
import com.irontom10.freespawn.item.armor.lavaeel.LavaeelHelmet;
import com.irontom10.freespawn.item.armor.lavaeel.LavaeelLeggings;
import com.irontom10.freespawn.item.armor.mobzilla.MobzillaBoots;
import com.irontom10.freespawn.item.armor.mobzilla.MobzillaChestplate;
import com.irontom10.freespawn.item.armor.mobzilla.MobzillaHelmet;
import com.irontom10.freespawn.item.armor.mobzilla.MobzillaLeggings;
import com.irontom10.freespawn.item.armor.mothscale.MothscaleBoots;
import com.irontom10.freespawn.item.armor.mothscale.MothscaleChestplate;
import com.irontom10.freespawn.item.armor.mothscale.MothscaleHelmet;
import com.irontom10.freespawn.item.armor.mothscale.MothscaleLeggings;
import com.irontom10.freespawn.item.armor.peacock.PeacockBoots;
import com.irontom10.freespawn.item.armor.peacock.PeacockChestplate;
import com.irontom10.freespawn.item.armor.peacock.PeacockHelmet;
import com.irontom10.freespawn.item.armor.peacock.PeacockLeggings;
import com.irontom10.freespawn.item.armor.pink_tourmaline.PinkTourmalineBoots;
import com.irontom10.freespawn.item.armor.pink_tourmaline.PinkTourmalineChestplate;
import com.irontom10.freespawn.item.armor.pink_tourmaline.PinkTourmalineHelmet;
import com.irontom10.freespawn.item.armor.pink_tourmaline.PinkTourmalineLeggings;
import com.irontom10.freespawn.item.armor.queen.QueenBoots;
import com.irontom10.freespawn.item.armor.queen.QueenChestplate;
import com.irontom10.freespawn.item.armor.queen.QueenHelmet;
import com.irontom10.freespawn.item.armor.queen.QueenLeggings;
import com.irontom10.freespawn.item.armor.royal.RoyalBoots;
import com.irontom10.freespawn.item.armor.royal.RoyalChestplate;
import com.irontom10.freespawn.item.armor.royal.RoyalHelmet;
import com.irontom10.freespawn.item.armor.royal.RoyalLeggings;
import com.irontom10.freespawn.item.armor.ruby.RubyBoots;
import com.irontom10.freespawn.item.armor.ruby.RubyChestplate;
import com.irontom10.freespawn.item.armor.ruby.RubyHelmet;
import com.irontom10.freespawn.item.armor.ruby.RubyLeggings;
import com.irontom10.freespawn.item.armor.tigerseye.TigerseyeBoots;
import com.irontom10.freespawn.item.armor.tigerseye.TigerseyeChestplate;
import com.irontom10.freespawn.item.armor.tigerseye.TigerseyeHelmet;
import com.irontom10.freespawn.item.armor.tigerseye.TigerseyeLeggings;
import com.irontom10.freespawn.item.armor.ultimate.UltimateBoots;
import com.irontom10.freespawn.item.armor.ultimate.UltimateChestplate;
import com.irontom10.freespawn.item.armor.ultimate.UltimateHelmet;
import com.irontom10.freespawn.item.armor.ultimate.UltimateLeggings;
import com.irontom10.freespawn.item.special.MinersDream;
import com.irontom10.freespawn.item.special.OmgNoDontDoIt;
import com.irontom10.freespawn.item.throwables.Shoe;
import com.irontom10.freespawn.item.tool.Amethyst.AmethystPickaxe;
import com.irontom10.freespawn.item.tool.Emerald.EmeraldPickaxe;
import com.irontom10.freespawn.item.tool.Ultimate.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
  public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS,
      com.irontom10.freespawn.main.MOD_ID);

  public static final RegistryObject<Item> FIRE_FISH = ITEM.register("fire_fish",
      () -> new Item(new Item.Properties().food(ModFoods.FIRE_FISH)));

  public static final RegistryObject<Item> SUN_FISH = ITEM.register("sun_fish",
      () -> new Item(new Item.Properties().food(ModFoods.SUN_FISH)));

  public static final RegistryObject<Item> LAVAEEL = ITEM.register("lavaeel",
      () -> new Item(new Item.Properties().food(ModFoods.LAVAEEL)));

  public static final RegistryObject<Item> SPARK_FISH = ITEM.register("spark_fish",
      () -> new Item(new Item.Properties().food(ModFoods.SPARK_FISH)));

  public static final RegistryObject<Item> POPCORN = ITEM.register("popcorn",
      () -> new Item(new Item.Properties().food(ModFoods.POPCORN)));

  public static final RegistryObject<Item> POPCORN_BUTTERED = ITEM.register("popcorn_buttered",
      () -> new Item(new Item.Properties().food(ModFoods.POPCORN_BUTTERED)));

  public static final RegistryObject<Item> POPCORN_BUTTERED_SALTED = ITEM.register("popcorn_buttered_salted",
      () -> new Item(new Item.Properties().food(ModFoods.POPCORN_BUTTERED_SALTED)));

  public static final RegistryObject<Item> BAG_OF_POPCORN = ITEM.register("bag_of_popcorn",
      () -> new Item(new Item.Properties().food(ModFoods.BAG_OF_POPCORN)));

  public static final RegistryObject<Item> COOKED_CORN_DOG = ITEM.register("cooked_corn_dog",
      () -> new Item(new Item.Properties().food(ModFoods.COOKED_CORN_DOG)));

  public static final RegistryObject<Item> CHEESE = ITEM.register("cheese",
      () -> new Item(new Item.Properties().food(ModFoods.CHEESE)));

  public static final RegistryObject<Item> RAW_CORN_DOG = ITEM.register("raw_corn_dog",
      () -> new Item(new Item.Properties().food(ModFoods.RAW_CORN_DOG)));

  public static final RegistryObject<Item> COOKED_PEACOCK = ITEM.register("cooked_peacock",
      () -> new Item(new Item.Properties().food(ModFoods.COOKED_PEACOCK)));

  public static final RegistryObject<Item> RAW_PEACOCK = ITEM.register("raw_peacock",
      () -> new Item(new Item.Properties().food(ModFoods.RAW_PEACOCK)));

  public static final RegistryObject<Item> RAW_BACON = ITEM.register("raw_bacon",
      () -> new Item(new Item.Properties().food(ModFoods.RAW_BACON)));

  public static final RegistryObject<Item> COOKED_BACON = ITEM.register("cooked_bacon",
      () -> new Item(new Item.Properties().food(ModFoods.COOKED_BACON)));

  public static final RegistryObject<Item> RAW_CRAB_MEAT = ITEM.register("raw_crab_meat",
      () -> new Item(new Item.Properties().food(ModFoods.RAW_CRAB_MEAT)));

  public static final RegistryObject<Item> COOKED_CRAB_MEAT = ITEM.register("cooked_crab_meat",
      () -> new Item(new Item.Properties().food(ModFoods.COOKED_CRAB_MEAT)));

  public static final RegistryObject<Item> BUTTER_CANDY = ITEM.register("butter_candy",
      () -> new Item(new Item.Properties().food(ModFoods.BUTTER_CANDY)));

  public static final RegistryObject<Item> GREEN_FISH = ITEM.register("green_fish",
      () -> new Item(new Item.Properties().food(ModFoods.GREEN_FISH)));

  public static final RegistryObject<Item> BLUE_FISH = ITEM.register("blue_fish",
      () -> new Item(new Item.Properties().food(ModFoods.BLUE_FISH)));

  public static final RegistryObject<Item> PINK_FISH = ITEM.register("pink_fish",
      () -> new Item(new Item.Properties().food(ModFoods.PINK_FISH)));

  public static final RegistryObject<Item> JEW_FISH = ITEM.register("jew_fish",
      () -> new Item(new Item.Properties().food(ModFoods.JEW_FISH)));

  public static final RegistryObject<Item> ROCK_FISH = ITEM.register("rock_fish",
      () -> new Item(new Item.Properties().food(ModFoods.ROCK_FISH)));

  public static final RegistryObject<Item> WOOD_FISH = ITEM.register("wood_fish",
      () -> new Item(new Item.Properties().food(ModFoods.WOOD_FISH)));

  public static final RegistryObject<Item> GRAY_FISH = ITEM.register("gray_fish",
      () -> new Item(new Item.Properties().food(ModFoods.GRAY_FISH)));

  public static final RegistryObject<Item> GARDEN_SALAD = ITEM.register("garden_salad",
      () -> new Item(new Item.Properties().food(ModFoods.GARDEN_SALAD)));

  public static final RegistryObject<Item> BLT_SANDWITCH = ITEM.register("blt_sandwich",
      () -> new Item(new Item.Properties().food(ModFoods.BLT_SANDWITCH)));

  public static final RegistryObject<Item> A_CRABBY_PATTY = ITEM.register("a_crabby_patty",
      () -> new Item(new Item.Properties().food(ModFoods.A_CRABBY_PATTY)));

  public static final RegistryObject<Item> STRAWBERRY = ITEM.register("strawberry",
      () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

  public static final RegistryObject<Item> CRYSTAL_APPLE = ITEM.register("crystal_apple",
      () -> new Item(new Item.Properties().food(ModFoods.CRYSTAL_APPLE)));

  public static final RegistryObject<Item> LOVE = ITEM.register("love",
      () -> new Item(new Item.Properties().food(ModFoods.LOVE)));

  public static final RegistryObject<Item> CHERRIES = ITEM.register("cherries",
      () -> new Item(new Item.Properties().food(ModFoods.CHERRIES)));

  public static final RegistryObject<Item> PEACH = ITEM.register("peach",
      () -> new Item(new Item.Properties().food(ModFoods.PEACH)));

  public static final RegistryObject<Item> RADISH = ITEM.register("radish",
      () -> new Item(new Item.Properties().food(ModFoods.RADISH)));

  public static final RegistryObject<Item> RICE = ITEM.register("rice",
      () -> new Item(new Item.Properties().food(ModFoods.RICE)));

  public static final RegistryObject<Item> CORN = ITEM.register("corn",
      () -> new Item(new Item.Properties().food(ModFoods.CORN)));

  public static final RegistryObject<Item> QUINOA = ITEM.register("quinoa",
      () -> new Item(new Item.Properties().food(ModFoods.QUINOA)));

  public static final RegistryObject<Item> TOMATO = ITEM.register("tomato",
      () -> new Item(new Item.Properties().food(ModFoods.TOMATO)));

  public static final RegistryObject<Item> LETTUCE = ITEM.register("lettuce",
      () -> new Item(new Item.Properties().food(ModFoods.LETTUCE)));

  public static final RegistryObject<Item> SALT = ITEM.register("salt",
      () -> new Item(new Item.Properties()));

  // misc items
  public static final RegistryObject<Item> MINERS_DREAM = ITEM.register("miners_dream",
      () -> new MinersDream(new Item.Properties().stacksTo(16).fireResistant()));

  public static final RegistryObject<Item> OMG_NO_DONT_DO_IT = ITEM.register("omg_no_dont_do_it",
      () -> new OmgNoDontDoIt(new Item.Properties().stacksTo(1).durability(0).fireResistant()));

  public static final RegistryObject<Item> APPLE_TREE_SEED = ITEM.register("apple_tree_seed",
      () -> new com.irontom10.freespawn.item.special.AppleTreeSeed(new Item.Properties()));

  // Throwables

  public static final RegistryObject<Item> RED_HEELS = ITEM.register("red_heels",
      () -> new Shoe(new Item.Properties()));

  public static final RegistryObject<Item> BLACK_HEELS = ITEM.register("black_heels",
      () -> new Shoe(new Item.Properties()));

  public static final RegistryObject<Item> SLIPPERS = ITEM.register("slippers",
      () -> new Shoe(new Item.Properties()));

  public static final RegistryObject<Item> BOOTS = ITEM.register("boots",
      () -> new Shoe(new Item.Properties()));

  // Materials

  public static final RegistryObject<Item> AMETHYST = ITEM.register("amethyst",
      () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> RUBY = ITEM.register("ruby",
      () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> MOTHSCALE = ITEM.register("mothscale",
      () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> PINK_TOURMALINE_INGOT = ITEM.register("pink_tourmaline_ingot",
      () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> TIGERSEYE_INGOT = ITEM.register("tigerseye_ingot",
      () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> PEACOCK_FEATHER = ITEM.register("peacock_feather",
      () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> MOBZILLA_SCALE = ITEM.register("mobzilla_scale",
      () -> new Item(new Item.Properties()));

  public static final RegistryObject<Item> QUEEN_SCALE = ITEM.register("queen_scale",
      () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> URANIUM_INGOT = ITEM.register("uranium_ingot",
      () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> URANIUM_NUGGET = ITEM.register("uranium_nugget",
      () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> TITANIUM_INGOT = ITEM.register("titanium_ingot",
      () -> new Item(new Item.Properties()));
  public static final RegistryObject<Item> TITANIUM_NUGGET = ITEM.register("titanium_nugget",
      () -> new Item(new Item.Properties()));

  // Armor items

  public static final RegistryObject<Item> AMETHYST_BOOTS = ITEM.register("amethyst_boots", AmethystBoots::new);
  public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEM.register("amethyst_chestplate",
      AmethystChestplate::new);
  public static final RegistryObject<Item> AMETHYST_HELMET = ITEM.register("amethyst_helmet", AmethystHelmet::new);
  public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEM.register("amethyst_leggings",
      AmethystLeggings::new);
  public static final RegistryObject<Item> EMERALD_BOOTS = ITEM.register("emerald_boots", EmeraldBoots::new);
  public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEM.register("emerald_chestplate",
      EmeraldChestplate::new);
  public static final RegistryObject<Item> EMERALD_HELMET = ITEM.register("emerald_helmet", EmeraldHelmet::new);
  public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEM.register("emerald_leggings", EmeraldLeggings::new);
  public static final RegistryObject<Item> EXPERIENCE_BOOTS = ITEM.register("experience_boots", ExperienceBoots::new);
  public static final RegistryObject<Item> EXPERIENCE_CHESTPLATE = ITEM.register("experience_chestplate",
      ExperienceChestplate::new);
  public static final RegistryObject<Item> EXPERIENCE_HELMET = ITEM.register("experience_helmet",
      ExperienceHelmet::new);
  public static final RegistryObject<Item> EXPERIENCE_LEGGINGS = ITEM.register("experience_leggings",
      ExperienceLeggings::new);
  public static final RegistryObject<Item> LAPIS_BOOTS = ITEM.register("lapis_boots", LapisBoots::new);
  public static final RegistryObject<Item> LAPIS_CHESTPLATE = ITEM.register("lapis_chestplate", LapisChestplate::new);
  public static final RegistryObject<Item> LAPIS_HELMET = ITEM.register("lapis_helmet", LapisHelmet::new);
  public static final RegistryObject<Item> LAPIS_LEGGINGS = ITEM.register("lapis_leggings", LapisLeggings::new);
  public static final RegistryObject<Item> LAVAEEL_BOOTS = ITEM.register("lavaeel_boots", LavaeelBoots::new);
  public static final RegistryObject<Item> LAVAEEL_CHESTPLATE = ITEM.register("lavaeel_chestplate",
      LavaeelChestplate::new);
  public static final RegistryObject<Item> LAVAEEL_HELMET = ITEM.register("lavaeel_helmet", LavaeelHelmet::new);
  public static final RegistryObject<Item> LAVAEEL_LEGGINGS = ITEM.register("lavaeel_leggings", LavaeelLeggings::new);
  public static final RegistryObject<Item> MOBZILLA_BOOTS = ITEM.register("mobzilla_boots", MobzillaBoots::new);
  public static final RegistryObject<Item> MOBZILLA_CHESTPLATE = ITEM.register("mobzilla_chestplate",
      MobzillaChestplate::new);
  public static final RegistryObject<Item> MOBZILLA_HELMET = ITEM.register("mobzilla_helmet", MobzillaHelmet::new);
  public static final RegistryObject<Item> MOBZILLA_LEGGINGS = ITEM.register("mobzilla_leggings",
      MobzillaLeggings::new);
  public static final RegistryObject<Item> MOTHSCALE_BOOTS = ITEM.register("mothscale_boots", MothscaleBoots::new);
  public static final RegistryObject<Item> MOTHSCALE_CHESTPLATE = ITEM.register("mothscale_chestplate",
      MothscaleChestplate::new);
  public static final RegistryObject<Item> MOTHSCALE_HELMET = ITEM.register("mothscale_helmet", MothscaleHelmet::new);
  public static final RegistryObject<Item> MOTHSCALE_LEGGINGS = ITEM.register("mothscale_leggings",
      MothscaleLeggings::new);
  public static final RegistryObject<Item> PEACOCK_BOOTS = ITEM.register("peacock_boots", PeacockBoots::new);
  public static final RegistryObject<Item> PEACOCK_CHESTPLATE = ITEM.register("peacock_chestplate",
      PeacockChestplate::new);
  public static final RegistryObject<Item> PEACOCK_HELMET = ITEM.register("peacock_helmet", PeacockHelmet::new);
  public static final RegistryObject<Item> PEACOCK_LEGGINGS = ITEM.register("peacock_leggings", PeacockLeggings::new);
  public static final RegistryObject<Item> PINK_TOURMALINE_BOOTS = ITEM.register("pink_tourmaline_boots",
      PinkTourmalineBoots::new);
  public static final RegistryObject<Item> PINK_TOURMALINE_CHESTPLATE = ITEM.register("pink_tourmaline_chestplate",
      PinkTourmalineChestplate::new);
  public static final RegistryObject<Item> PINK_TOURMALINE_HELMET = ITEM.register("pink_tourmaline_helmet",
      PinkTourmalineHelmet::new);
  public static final RegistryObject<Item> PINK_TOURMALINE_LEGGINGS = ITEM.register("pink_tourmaline_leggings",
      PinkTourmalineLeggings::new);
  public static final RegistryObject<Item> TIGERSEYE_HELMET = ITEM.register("tigerseye_helmet", TigerseyeHelmet::new);
  public static final RegistryObject<Item> TIGERSEYE_CHESTPLATE = ITEM.register("tigerseye_chestplate",
      TigerseyeChestplate::new);
  public static final RegistryObject<Item> TIGERSEYE_LEGGINGS = ITEM.register("tigerseye_leggings",
      TigerseyeLeggings::new);
  public static final RegistryObject<Item> TIGERSEYE_BOOTS = ITEM.register("tigerseye_boots", TigerseyeBoots::new);
  public static final RegistryObject<Item> QUEEN_BOOTS = ITEM.register("queen_boots", QueenBoots::new);
  public static final RegistryObject<Item> QUEEN_CHESTPLATE = ITEM.register("queen_chestplate", QueenChestplate::new);
  public static final RegistryObject<Item> QUEEN_HELMET = ITEM.register("queen_helmet", QueenHelmet::new);
  public static final RegistryObject<Item> QUEEN_LEGGINGS = ITEM.register("queen_leggings", QueenLeggings::new);

  public static final RegistryObject<Item> ROYAL_CHESTPLATE = ITEM.register("royal_chestplate", RoyalChestplate::new);
  public static final RegistryObject<Item> ROYAL_HELMET = ITEM.register("royal_helmet", RoyalHelmet::new);
  public static final RegistryObject<Item> ROYAL_LEGGINGS = ITEM.register("royal_leggings", RoyalLeggings::new);
  public static final RegistryObject<Item> RUBY_BOOTS = ITEM.register("ruby_boots", RubyBoots::new);
  public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEM.register("ruby_chestplate", RubyChestplate::new);
  public static final RegistryObject<Item> RUBY_HELMET = ITEM.register("ruby_helmet", RubyHelmet::new);
  public static final RegistryObject<Item> RUBY_LEGGINGS = ITEM.register("ruby_leggings", RubyLeggings::new);

  public static final RegistryObject<Item> ROYAL_BOOTS = ITEM.register("royal_boots", RoyalBoots::new);
  public static final RegistryObject<Item> ULTIMATE_BOOTS = ITEM.register("ultimate_boots",
      UltimateBoots::new);
    public static final RegistryObject<Item> ULTIMATE_CHESTPLATE = ITEM.register("ultimate_chestplate",
        UltimateChestplate::new);
    public static final RegistryObject<Item> ULTIMATE_HELMET = ITEM.register("ultimate_helmet",
        UltimateHelmet::new);
    public static final RegistryObject<Item> ULTIMATE_LEGGINGS = ITEM.register("ultimate_leggings",
        UltimateLeggings::new);

  // Tool Items

  public static final RegistryObject<Item> AMETHYST_SWORD = ITEM.register("amethyst_sword", () -> new SwordItem(
      ModToolMaterials.AMETHYST, // tool material
      3, // attack damage
      -2.4F, // attack speed
      new Item.Properties()));

  public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEM.register("amethyst_pickaxe",
      () -> new AmethystPickaxe(
          ModToolMaterials.AMETHYST, // tool material
          1, // mining level
          -2.8F, // attack speed
          new Item.Properties()));

  public static final RegistryObject<Item> AMETHYST_AXE = ITEM.register("amethyst_axe", () -> new AxeItem(
      ModToolMaterials.AMETHYST, // tool material
      6, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEM.register("amethyst_shovel", () -> new ShovelItem(
      ModToolMaterials.AMETHYST, // tool material
      1.5F, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> AMETHYST_HOE = ITEM.register("amethyst_hoe", () -> new HoeItem(
      ModToolMaterials.AMETHYST, // tool material
      -1, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> RUBY_SWORD = ITEM.register("ruby_sword", () -> new SwordItem(
      ModToolMaterials.RUBY, // tool material
      3, // attack damage
      -2.4F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> RUBY_PICKAXE = ITEM.register("ruby_pickaxe", () -> new PickaxeItem(
      ModToolMaterials.RUBY, // tool material
      1, // mining level
      -2.8F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> RUBY_AXE = ITEM.register("ruby_axe", () -> new AxeItem(
      ModToolMaterials.RUBY, // tool material
      6, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> RUBY_SHOVEL = ITEM.register("ruby_shovel", () -> new ShovelItem(
      ModToolMaterials.RUBY, // tool material
      1.5F, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> RUBY_HOE = ITEM.register("ruby_hoe", () -> new HoeItem(
      ModToolMaterials.RUBY, // tool material
      -1, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> TIGERSEYE_SWORD = ITEM.register("tigerseye_sword", () -> new SwordItem(
      ModToolMaterials.TIGERS_EYE, // tool material
      3, // attack damage
      -2.4F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> TIGERSEYE_PICKAXE = ITEM.register("tigerseye_pickaxe", () -> new PickaxeItem(
      ModToolMaterials.TIGERS_EYE, // tool material
      1, // mining level
      -2.8F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> TIGERSEYE_AXE = ITEM.register("tigerseye_axe", () -> new AxeItem(
      ModToolMaterials.TIGERS_EYE, // tool material
      6, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> TIGERSEYE_SHOVEL = ITEM.register("tigerseye_shovel", () -> new ShovelItem(
      ModToolMaterials.TIGERS_EYE, // tool material
      1.5F, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> TIGERSEYE_HOE = ITEM.register("tigerseye_hoe", () -> new HoeItem(
      ModToolMaterials.TIGERS_EYE, // tool material
      -1, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> ULTIMATE_SWORD = ITEM.register("ultimate_sword", () -> new UltimateSword());
  public static final RegistryObject<Item> ULTIMATE_PICKAXE = ITEM.register("ultimate_pickaxe",
      () -> new UltimatePickaxe());
  public static final RegistryObject<Item> ULTIMATE_AXE = ITEM.register("ultimate_axe", () -> new UltimateAxe());
  public static final RegistryObject<Item> ULTIMATE_SHOVEL = ITEM.register("ultimate_shovel",
      () -> new UltimateShovel());
  public static final RegistryObject<Item> ULTIMATE_HOE = ITEM.register("ultimate_hoe", () -> new UltimateHoe());
  public static final RegistryObject<Item> EMERALD_SWORD = ITEM.register("emerald_sword", () -> new SwordItem(
      ModToolMaterials.EMERALD, // tool material
      3, // attack damage
      -2.4F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> EMERALD_PICKAXE = ITEM.register("emerald_pickaxe",
      () -> new EmeraldPickaxe());
  public static final RegistryObject<Item> EMERALD_AXE = ITEM.register("emerald_axe", () -> new AxeItem(
      ModToolMaterials.EMERALD, // tool material
      6, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> EMERALD_SHOVEL = ITEM.register("emerald_shovel", () -> new ShovelItem(
      ModToolMaterials.EMERALD, // tool material
      1.5F, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> EMERALD_HOE = ITEM.register("emerald_hoe", () -> new HoeItem(
      ModToolMaterials.EMERALD, // tool material
      -1, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> CRYSTAL_WOOD_SWORD = ITEM.register("crystal_wood_sword", () -> new SwordItem(
      ModToolMaterials.CRYSTAL_WOOD, // tool material
      3, // attack damage
      -2.4F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> CRYSTAL_WOOD_PICKAXE = ITEM.register("crystal_wood_pickaxe",
      () -> new PickaxeItem(
          ModToolMaterials.CRYSTAL_WOOD, // tool material
          1, // mining level
          -2.8F, // attack speed
          new Item.Properties()));
  public static final RegistryObject<Item> CRYSTAL_WOOD_AXE = ITEM.register("crystal_wood_axe", () -> new AxeItem(
      ModToolMaterials.CRYSTAL_WOOD, // tool material
      6, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> CRYSTAL_WOOD_SHOVEL = ITEM.register("crystal_wood_shovel",
      () -> new ShovelItem(
          ModToolMaterials.CRYSTAL_WOOD, // tool material
          1.5F, // attack damage
          -3.0F, // attack speed
          new Item.Properties()));
  public static final RegistryObject<Item> CRYSTAL_WOOD_HOE = ITEM.register("crystal_wood_hoe", () -> new HoeItem(
      ModToolMaterials.CRYSTAL_WOOD, // tool material
      -1, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> PINK_TOURMALINE_SWORD = ITEM.register("pink_tourmaline_sword",
      () -> new SwordItem(
          ModToolMaterials.PINK_TOURMALINE, // tool material
          3, // attack damage
          -2.4F, // attack speed
          new Item.Properties()));
  public static final RegistryObject<Item> PINK_TOURMALINE_PICKAXE = ITEM.register("pink_tourmaline_pickaxe",
      () -> new PickaxeItem(
          ModToolMaterials.PINK_TOURMALINE, // tool material
          1, // mining level
          -2.8F, // attack speed
          new Item.Properties()));
  public static final RegistryObject<Item> PINK_TOURMALINE_AXE = ITEM.register("pink_tourmaline_axe", () -> new AxeItem(
      ModToolMaterials.PINK_TOURMALINE, // tool material
      6, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> PINK_TOURMALINE_SHOVEL = ITEM.register("pink_tourmaline_shovel",
      () -> new ShovelItem(
          ModToolMaterials.PINK_TOURMALINE, // tool material
          1.5F, // attack damage
          -3.0F, // attack speed
          new Item.Properties()));
  public static final RegistryObject<Item> PINK_TOURMALINE_HOE = ITEM.register("pink_tourmaline_hoe", () -> new HoeItem(
      ModToolMaterials.PINK_TOURMALINE, // tool material
      -1, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> CRYSTAL_STONE_SWORD = ITEM.register("crystal_stone_sword",
      () -> new SwordItem(
          ModToolMaterials.CRYSTAL_STONE, // tool material
          3, // attack damage
          -2.4F, // attack speed
          new Item.Properties()));
  public static final RegistryObject<Item> CRYSTAL_STONE_PICKAXE = ITEM.register("crystal_stone_pickaxe",
      () -> new PickaxeItem(
          ModToolMaterials.CRYSTAL_STONE, // tool material
          1, // mining level
          -2.8F, // attack speed
          new Item.Properties()));
  public static final RegistryObject<Item> CRYSTAL_STONE_AXE = ITEM.register("crystal_stone_axe", () -> new AxeItem(
      ModToolMaterials.CRYSTAL_STONE, // tool material
      6, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> CRYSTAL_STONE_SHOVEL = ITEM.register("crystal_stone_shovel",
      () -> new ShovelItem(
          ModToolMaterials.CRYSTAL_STONE, // tool material
          1.5F, // attack damage
          -3.0F, // attack speed
          new Item.Properties()));
  public static final RegistryObject<Item> CRYSTAL_STONE_HOE = ITEM.register("crystal_stone_hoe", () -> new HoeItem(
      ModToolMaterials.CRYSTAL_STONE, // tool material
      -1, // attack damage
      -3.0F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> NIGHTMARE_SWORD = ITEM.register("nightmare_sword", () -> new SwordItem(
      ModToolMaterials.NIGHTMARE, // tool material
      3, // attack damage
      -2.4F, // attack speed
      new Item.Properties()));
  public static final RegistryObject<Item> BERTHA = ITEM.register("bertha", () -> new SwordItem(
          ModToolMaterials.BERTHA, // tool material
          3, // attack damage
          -2.4F, // attack speed
          new Item.Properties()));


  // Spawn eggs
  public static final RegistryObject<SpawnEggItem> GIRLFRIEND_SPAWN_EGG = ITEM.register("girlfriend_spawn_egg",
      () -> new ForgeSpawnEggItem(
          ModEntities.GIRLFRIEND, // entity type
          0xFF99CC, // primary color (pink-ish)
          0x663366, // secondary color (purple-ish)
          new Item.Properties()));
  public static final RegistryObject<SpawnEggItem> APPLE_COW_SPAWN_EGG = ITEM.register("apple_cow_spawn_egg",
          () -> new ForgeSpawnEggItem(
              ModEntities.APPLE_COW,
                  0xC41E3A,
                  0x8DB600,
              new Item.Properties()));
  public static final RegistryObject<SpawnEggItem> GOLDEN_APPLE_COW_SPAWN_EGG = ITEM.register("golden_apple_cow_spawn_egg",
          () -> new ForgeSpawnEggItem(
                  ModEntities.GOLDEN_APPLE_COW,
                  0xFFD700,
                  0x8B4513,
                  new Item.Properties()));
  public static final RegistryObject<SpawnEggItem> ENCHANTED_GOLDEN_APPLE_COW_SPAWN_EGG = ITEM.register("enchanted_golden_apple_cow_spawn_egg",
          () -> new ForgeSpawnEggItem(
                  ModEntities.ENCHANTED_GOLDEN_APPLE_COW,
                  0x8A2BE2,
                  0x00FFFF,
                  new Item.Properties()));
  public static final RegistryObject<SpawnEggItem> BEE_SPAWN_EGG = ITEM.register("bee_spawn_egg",
          () -> new ForgeSpawnEggItem(
                  ModEntities.BEE,
                  0xFCE883,
                  0x000000,
                  new Item.Properties()));


  public static void register(IEventBus eventBus) {
    ITEM.register(eventBus);

  }
}
