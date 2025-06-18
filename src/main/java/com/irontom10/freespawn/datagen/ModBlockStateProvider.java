package com.irontom10.freespawn.datagen;

import com.irontom10.freespawn.block.ModBlocks;
import com.irontom10.freespawn.main;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.HashSet;
import net.minecraft.resources.ResourceLocation;

public class ModBlockStateProvider extends BlockStateProvider {
  public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
    super(output, main.MOD_ID, exFileHelper);
  }

  private final Set<ResourceLocation> modelledBlocks = new HashSet<>();

  @Override
  protected void registerStatesAndModels() {
    // ORE ITEMS
    blockWithItem(ModBlocks.STONE_AMETHYST_ORE);
    blockWithItem(ModBlocks.DEEPSLATE_AMETHYST_ORE);

    blockWithItem(ModBlocks.STONE_RUBY_ORE);
    blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);

    blockWithItem(ModBlocks.STONE_URANIUM_ORE);
    blockWithItem(ModBlocks.DEEPSLATE_URANIUM_ORE);

    blockWithItem(ModBlocks.STONE_TITANIUM_ORE);
    blockWithItem(ModBlocks.DEEPSLATE_TITANIUM_ORE);

    blockWithItem(ModBlocks.STONE_SALT_ORE);
    blockWithItem(ModBlocks.DEEPSLATE_SALT_ORE);

    // ORE SPAWN EGGS
    blockWithItem(ModBlocks.STONE_ANCIENT_DRIED_GIRLFRIEND);
    blockWithItem(ModBlocks.DEEPSLATE_ANCIENT_DRIED_GIRLFRIEND);

    // BLOCKS
    blockWithItem(ModBlocks.AMETHYST_BLOCK);
    blockWithItem(ModBlocks.RUBY_BLOCK);
    blockWithItem(ModBlocks.URANIUM_BLOCK);
    blockWithItem(ModBlocks.TITANIUM_BLOCK);
    blockWithItem(ModBlocks.CRYSTAL_STONE);
    blockWithItem(ModBlocks.CRYSTAL_WOOD_PLANKS);
    blockWithItem(ModBlocks.EXTREME_TORCH);
    blockWithItem(ModBlocks.CRYSTAL_TORCH);
    blockWithItem(ModBlocks.APPLE_LEAVES);
    blockWithItem(ModBlocks.PEACH_LEAVES);
    blockWithItem(ModBlocks.CHERRY_LEAVES);
    blockWithItem(ModBlocks.PINK_TOURMALINE_BLOCK);
    blockWithItem(ModBlocks.TIGERSEYE_BLOCK);
    blockWithItem(ModBlocks.MOBZILLA_SCALE_BLOCK);
    blockWithItem(ModBlocks.ENDER_PEARL_BLOCK);
    blockWithItem(ModBlocks.ENDER_EYE_BLOCK);

  }

  private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
    simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    modelledBlocks.add(blockRegistryObject.getId());
  }

  private void torchWithItem() {

  }

  private void validateAllBlocksHaveModels() {
    for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
      ResourceLocation id = block.getId();
      if (!modelledBlocks.contains(id)) {
        throw new IllegalStateException("❌ Missing block model for: " + id);
      }
    }
  }

}
