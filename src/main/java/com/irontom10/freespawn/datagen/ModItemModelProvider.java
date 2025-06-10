package com.irontom10.freespawn.datagen;

import com.irontom10.freespawn.item.ModItems;
import com.irontom10.freespawn.main;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, main.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {


        //FOOD ITEMS
        simpleItem(ModItems.FIRE_FISH);
        simpleItem(ModItems.SUN_FISH);
        simpleItem(ModItems.LAVAEEL);
        simpleItem(ModItems.SPARK_FISH);
        simpleItem(ModItems.POPCORN);
        simpleItem(ModItems.POPCORN_BUTTERED);
        simpleItem(ModItems.POPCORN_BUTTERED_SALTED);
        simpleItem(ModItems.BAG_OF_POPCORN);
        simpleItem(ModItems.COOKED_CORN_DOG);
        simpleItem(ModItems.CHEESE);
        simpleItem(ModItems.COOKED_PEACOCK);
        simpleItem(ModItems.RAW_PEACOCK);
        simpleItem(ModItems.RAW_CORN_DOG);
        simpleItem(ModItems.RAW_BACON);
        simpleItem(ModItems.COOKED_BACON);
        simpleItem(ModItems.RAW_CRAB_MEAT);
        simpleItem(ModItems.COOKED_CRAB_MEAT);
        simpleItem(ModItems.BUTTER_CANDY);
        simpleItem(ModItems.GREEN_FISH);
        simpleItem(ModItems.BLUE_FISH);
        simpleItem(ModItems.PINK_FISH);
        simpleItem(ModItems.JEW_FISH);
        simpleItem(ModItems.WOOD_FISH);
        simpleItem(ModItems.GRAY_FISH);
        simpleItem(ModItems.ROCK_FISH);
        simpleItem(ModItems.GARDEN_SALAD);
        simpleItem(ModItems.BLT_SANDWITCH);
        simpleItem(ModItems.A_CRABBY_PATTY);
        simpleItem(ModItems.STRAWBERRY);
        simpleItem(ModItems.CRYSTAL_APPLE);
        simpleItem(ModItems.LOVE);
        simpleItem(ModItems.CHERRIES);
        simpleItem(ModItems.PEACH);
        simpleItem(ModItems.RADISH);
        simpleItem(ModItems.RICE);
        simpleItem(ModItems.CORN);
        simpleItem(ModItems.QUINOA);
        simpleItem(ModItems.TOMATO);
        simpleItem(ModItems.LETTUCE);
        //MISC ITEMS
        simpleItem(ModItems.MINERS_DREAM);
        simpleItem(ModItems.APPLE_TREE_SEED);

        //INGREDIENTS
        simpleItem(ModItems.AMETHYST);
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.MOTHSCALE);
        simpleItem(ModItems.PINK_TOURMALINE_INGOT);
        simpleItem(ModItems.TIGERSEYE_INGOT);
        simpleItem(ModItems.PEACOCK_FEATHER);
        simpleItem(ModItems.MOBZILLA_SCALE);
        simpleItem(ModItems.QUEEN_SCALE);
        simpleItem(ModItems.URANIUM_INGOT);
        simpleItem(ModItems.TITANIUM_INGOT);
        simpleItem(ModItems.URANIUM_NUGGET);
        simpleItem(ModItems.TITANIUM_NUGGET);


        //Armor
        simpleItem(ModItems.ULTIMATE_HELMET);
        simpleItem(ModItems.ULTIMATE_CHESTPLATE);
        simpleItem(ModItems.ULTIMATE_LEGGINGS);
        simpleItem(ModItems.ULTIMATE_BOOTS);


        //Weapons and tools
        toolItem(ModItems.ULTIMATE_SWORD);
        toolItem(ModItems.ULTIMATE_PICKAXE);
        toolItem(ModItems.ULTIMATE_AXE);
        toolItem(ModItems.ULTIMATE_SHOVEL);
        toolItem(ModItems.ULTIMATE_HOE);



    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(main.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder toolItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(main.MOD_ID,"item/" + item.getId().getPath()));
    }
}
