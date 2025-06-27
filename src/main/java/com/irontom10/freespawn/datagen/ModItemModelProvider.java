package com.irontom10.freespawn.datagen;

import com.irontom10.freespawn.item.ModItems;
import com.irontom10.freespawn.main;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ModItemModelProvider extends ItemModelProvider {
  public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, main.MOD_ID, existingFileHelper);
  }

  private final Set<ResourceLocation> modelledItems = new HashSet<>();

  @Override
  protected void registerModels() {

    // FOOD ITEMS
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
    simpleItem(ModItems.SALT);
    // MISC ITEMS
    simpleItem(ModItems.MINERS_DREAM);
    simpleItem(ModItems.OMG_NO_DONT_DO_IT);
    simpleItem(ModItems.APPLE_TREE_SEED);

    // INGREDIENTS
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

    // Armor
    simpleItem(ModItems.AMETHYST_HELMET);
    simpleItem(ModItems.AMETHYST_CHESTPLATE);
    simpleItem(ModItems.AMETHYST_LEGGINGS);
    simpleItem(ModItems.AMETHYST_BOOTS);
    simpleItem(ModItems.EMERALD_HELMET);
    simpleItem(ModItems.EMERALD_CHESTPLATE);
    simpleItem(ModItems.EMERALD_LEGGINGS);
    simpleItem(ModItems.EMERALD_BOOTS);
    simpleItem(ModItems.RUBY_HELMET);
    simpleItem(ModItems.RUBY_CHESTPLATE);
    simpleItem(ModItems.RUBY_LEGGINGS);
    simpleItem(ModItems.RUBY_BOOTS);
    simpleItem(ModItems.PINK_TOURMALINE_HELMET);
    simpleItem(ModItems.PINK_TOURMALINE_CHESTPLATE);
    simpleItem(ModItems.PINK_TOURMALINE_LEGGINGS);
    simpleItem(ModItems.PINK_TOURMALINE_BOOTS);
    simpleItem(ModItems.TIGERSEYE_HELMET);
    simpleItem(ModItems.TIGERSEYE_CHESTPLATE);
    simpleItem(ModItems.TIGERSEYE_LEGGINGS);
    simpleItem(ModItems.TIGERSEYE_BOOTS);
    simpleItem(ModItems.MOTHSCALE_HELMET);
    simpleItem(ModItems.MOTHSCALE_CHESTPLATE);
    simpleItem(ModItems.MOTHSCALE_LEGGINGS);
    simpleItem(ModItems.MOTHSCALE_BOOTS);
    simpleItem(ModItems.LAVAEEL_HELMET);
    simpleItem(ModItems.LAVAEEL_CHESTPLATE);
    simpleItem(ModItems.LAVAEEL_LEGGINGS);
    simpleItem(ModItems.LAVAEEL_BOOTS);
    simpleItem(ModItems.PEACOCK_HELMET);
    simpleItem(ModItems.PEACOCK_CHESTPLATE);
    simpleItem(ModItems.PEACOCK_LEGGINGS);
    simpleItem(ModItems.PEACOCK_BOOTS);
    simpleItem(ModItems.MOBZILLA_HELMET);
    simpleItem(ModItems.MOBZILLA_CHESTPLATE);
    simpleItem(ModItems.MOBZILLA_LEGGINGS);
    simpleItem(ModItems.MOBZILLA_BOOTS);
    simpleItem(ModItems.QUEEN_HELMET);
    simpleItem(ModItems.QUEEN_CHESTPLATE);
    simpleItem(ModItems.QUEEN_LEGGINGS);
    simpleItem(ModItems.QUEEN_BOOTS);
    simpleItem(ModItems.LAPIS_HELMET);
    simpleItem(ModItems.LAPIS_CHESTPLATE);
    simpleItem(ModItems.LAPIS_LEGGINGS);
    simpleItem(ModItems.LAPIS_BOOTS);
    simpleItem(ModItems.ROYAL_HELMET);
    simpleItem(ModItems.ROYAL_CHESTPLATE);
    simpleItem(ModItems.ROYAL_LEGGINGS);
    simpleItem(ModItems.ROYAL_BOOTS);
    simpleItem(ModItems.EXPERIENCE_HELMET);
    simpleItem(ModItems.EXPERIENCE_CHESTPLATE);
    simpleItem(ModItems.EXPERIENCE_LEGGINGS);
    simpleItem(ModItems.EXPERIENCE_BOOTS);
    simpleItem(ModItems.RED_HEELS);
    simpleItem(ModItems.BLACK_HEELS);
    simpleItem(ModItems.SLIPPERS);
    simpleItem(ModItems.BOOTS);

    // Weapons and tools
    toolItem(ModItems.AMETHYST_SWORD);
    toolItem(ModItems.AMETHYST_PICKAXE);
    toolItem(ModItems.AMETHYST_AXE);
    toolItem(ModItems.AMETHYST_SHOVEL);
    toolItem(ModItems.AMETHYST_HOE);
    toolItem(ModItems.RUBY_SWORD);
    toolItem(ModItems.RUBY_PICKAXE);
    toolItem(ModItems.RUBY_AXE);
    toolItem(ModItems.RUBY_SHOVEL);
    toolItem(ModItems.RUBY_HOE);
    toolItem(ModItems.PINK_TOURMALINE_SWORD);
    toolItem(ModItems.PINK_TOURMALINE_PICKAXE);
    toolItem(ModItems.PINK_TOURMALINE_AXE);
    toolItem(ModItems.PINK_TOURMALINE_SHOVEL);
    toolItem(ModItems.PINK_TOURMALINE_HOE);
    toolItem(ModItems.TIGERSEYE_SWORD);
    toolItem(ModItems.TIGERSEYE_PICKAXE);
    toolItem(ModItems.TIGERSEYE_AXE);
    toolItem(ModItems.TIGERSEYE_SHOVEL);
    toolItem(ModItems.TIGERSEYE_HOE);
    toolItem(ModItems.ULTIMATE_SWORD);
    toolItem(ModItems.ULTIMATE_PICKAXE);
    toolItem(ModItems.ULTIMATE_AXE);
    toolItem(ModItems.ULTIMATE_SHOVEL);
    toolItem(ModItems.ULTIMATE_HOE);
    toolItem(ModItems.EMERALD_SWORD);
    toolItem(ModItems.EMERALD_PICKAXE);
    toolItem(ModItems.EMERALD_AXE);
    toolItem(ModItems.EMERALD_SHOVEL);
    toolItem(ModItems.EMERALD_HOE);
    toolItem(ModItems.CRYSTAL_STONE_SWORD);
    toolItem(ModItems.CRYSTAL_STONE_PICKAXE);
    toolItem(ModItems.CRYSTAL_STONE_AXE);
    toolItem(ModItems.CRYSTAL_STONE_SHOVEL);
    toolItem(ModItems.CRYSTAL_STONE_HOE);
    toolItem(ModItems.CRYSTAL_WOOD_SWORD);
    toolItem(ModItems.CRYSTAL_WOOD_PICKAXE);
    toolItem(ModItems.CRYSTAL_WOOD_AXE);
    toolItem(ModItems.CRYSTAL_WOOD_SHOVEL);
    toolItem(ModItems.CRYSTAL_WOOD_HOE);
    toolItem(ModItems.NIGHTMARE_SWORD);
    ItemIsModeled(ModItems.BERTHA);


    // Spawn eggs
    spawnEggItem(ModItems.GIRLFRIEND_SPAWN_EGG);
    spawnEggItem(ModItems.APPLE_COW_SPAWN_EGG);

    validateAllItemsHaveModels();
  }

  private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
    modelledItems.add(item.getId());
    return withExistingParent(item.getId().getPath(),
        new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(main.MOD_ID, "item/" + item.getId().getPath()));
  }

  private ItemModelBuilder toolItem(RegistryObject<Item> item) {
    modelledItems.add(item.getId());
    return withExistingParent(item.getId().getPath(),
        new ResourceLocation("item/handheld")).texture("layer0",
            new ResourceLocation(main.MOD_ID, "item/" + item.getId().getPath()));
  }
  private void ItemIsModeled(RegistryObject<? extends Item> item) {
    modelledItems.add(item.getId());
  }


  private ItemModelBuilder spawnEggItem(RegistryObject<SpawnEggItem> item) {
    modelledItems.add(item.getId());
    return withExistingParent(item.getId().getPath(),
        new ResourceLocation("item/template_spawn_egg"));
  }

  private void validateAllItemsHaveModels() {
    List<ResourceLocation> missing = new ArrayList<>();

    for (RegistryObject<Item> item : ModItems.ITEM.getEntries()) {
      // Skip block items
      if (item.get() instanceof net.minecraft.world.item.BlockItem)
        continue;

      ResourceLocation id = item.getId();
      if (!modelledItems.contains(id)) {
        missing.add(id);
      }
    }

    if (!missing.isEmpty()) {
      throw new IllegalStateException("Missing models for items:\n" +
          missing.stream().map(ResourceLocation::toString).collect(Collectors.joining("\n")));
    }
  }

}
