package com.irontom10.freespawn.item;

import com.irontom10.freespawn.block.ModBlocks;
import com.irontom10.freespawn.item.special.MinersDream;
import com.irontom10.freespawn.item.tool.ultimate.UltimatePickaxe;
import com.irontom10.freespawn.item.tool.ultimate.UltimateHoe;
import com.irontom10.freespawn.item.tool.ultimate.UltimateShovel;
import com.irontom10.freespawn.item.tool.ultimate.UltimateAxe;
import com.irontom10.freespawn.item.tool.ultimate.UltimateSword;
import com.irontom10.freespawn.item.armor.ultimate.UltimateHelmet;
import com.irontom10.freespawn.item.armor.ultimate.UltimateChestplate;
import com.irontom10.freespawn.item.armor.ultimate.UltimateLeggings;
import com.irontom10.freespawn.item.armor.ultimate.UltimateBoots;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, com.irontom10.freespawn.main.MOD_ID);


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

    //misc items
    public static final RegistryObject<Item> MINERS_DREAM = ITEM.register("miners_dream",
            () -> new MinersDream(
                    new Item.Properties()
                            .stacksTo(16)
                            .fireResistant()));

    public static final RegistryObject<Item> APPLE_TREE_SEED = ITEM.register("apple_tree_seed",
            () -> new com.irontom10.freespawn.item.special.AppleTreeSeed(new Item.Properties())
    );

    public static final RegistryObject<Item> AMETHYST = ITEM.register("amethyst",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> RUBY = ITEM.register("ruby",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> MOTHSCALE = ITEM.register("mothscale",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> PINK_TOURMALINE_INGOT = ITEM.register("pink_tourmaline_ingot",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> TIGERSEYE_INGOT = ITEM.register("tigerseye_ingot",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> PEACOCK_FEATHER = ITEM.register("peacock_feather",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> MOBZILLA_SCALE = ITEM.register("mobzilla_scale",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> QUEEN_SCALE = ITEM.register("queen_scale",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> URANIUM_INGOT = ITEM.register("uranium_ingot",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEM.register("titanium_ingot",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEM.register("titanium_nugget",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> URANIUM_NUGGET = ITEM.register("uranium_nugget",
            () -> new Item(new Item.Properties())
    );


    //Ultimate items
    public static final RegistryObject<Item> ULTIMATE_SWORD =
            ITEM.register("ultimate_sword", UltimateSword::new);

    public static final RegistryObject<Item> ULTIMATE_PICKAXE =
            ITEM.register("ultimate_pickaxe", UltimatePickaxe::new);

    public static final RegistryObject<Item> ULTIMATE_AXE =
            ITEM.register("ultimate_axe", UltimateAxe::new);

    public static final RegistryObject<Item> ULTIMATE_HOE =
            ITEM.register("ultimate_hoe", UltimateHoe::new);

    public static final RegistryObject<Item> ULTIMATE_SHOVEL =
            ITEM.register("ultimate_shovel", UltimateShovel::new);

    public static final RegistryObject<Item> ULTIMATE_HELMET =
            ITEM.register("ultimate_helmet", UltimateHelmet::new);

    public static final RegistryObject<Item> ULTIMATE_CHESTPLATE =
            ITEM.register("ultimate_chestplate", UltimateChestplate::new);

    public static final RegistryObject<Item> ULTIMATE_LEGGINGS =
            ITEM.register("ultimate_leggings", UltimateLeggings::new);

    public static final RegistryObject<Item> ULTIMATE_BOOTS =
            ITEM.register("ultimate_boots", UltimateBoots::new);




    public static void register(IEventBus eventBus) {
        ITEM.register(eventBus);
    }
}
