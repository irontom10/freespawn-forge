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
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.AMETHYST_BLOCK);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.CRYSTAL_STONE);
        blockWithItem(ModBlocks.EXTREME_TORCH);
        blockWithItem(ModBlocks.CRYSTAL_TORCH);
        blockWithItem(ModBlocks.APPLE_LEAVES);
        blockWithItem(ModBlocks.PEACH_LEAVES);
        blockWithItem(ModBlocks.CHERRY_LEAVES);
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
