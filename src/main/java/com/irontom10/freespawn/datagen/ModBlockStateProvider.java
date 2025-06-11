package com.irontom10.freespawn.datagen;

import com.irontom10.freespawn.block.ModBlocks;
import com.irontom10.freespawn.main;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output,  ExistingFileHelper exFileHelper) {
        super(output, main.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AMETHYST_ORE);
        blockWithItem(ModBlocks.AMETHYST_BLOCK);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.URANIUM_ORE);
        blockWithItem(ModBlocks.URANIUM_BLOCK);
        blockWithItem(ModBlocks.TITANIUM_ORE);
        blockWithItem(ModBlocks.TITANIUM_BLOCK);
        blockWithItem(ModBlocks.CRYSTAL_STONE);
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
        blockWithItem(ModBlocks.ANCIENT_DRIED_GIRLFRIEND);
        
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
