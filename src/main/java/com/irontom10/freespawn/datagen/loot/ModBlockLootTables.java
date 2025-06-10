package com.irontom10.freespawn.datagen.loot;

import com.irontom10.freespawn.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.AMETHYST_BLOCK.get());
        this.dropSelf(ModBlocks.AMETHYST_ORE.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_ORE.get());
        this.dropSelf(ModBlocks.CRYSTAL_STONE.get());
        this.dropSelf(ModBlocks.EXTREME_TORCH.get());
        this.dropSelf(ModBlocks.CRYSTAL_TORCH.get());
    }
    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
