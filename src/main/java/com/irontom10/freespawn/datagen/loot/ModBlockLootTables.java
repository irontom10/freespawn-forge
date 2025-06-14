package com.irontom10.freespawn.datagen.loot;

import com.irontom10.freespawn.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //ORE BLOCKS
        this.dropSelf(ModBlocks.STONE_URANIUM_ORE.get());
        this.dropSelf(ModBlocks.DEEPSLATE_URANIUM_ORE.get());

        this.dropSelf(ModBlocks.STONE_TITANIUM_ORE.get());
        this.dropSelf(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());

        this.dropSelf(ModBlocks.STONE_SALT_ORE.get());
        this.dropSelf(ModBlocks.DEEPSLATE_SALT_ORE.get());

        this.dropSelf(ModBlocks.STONE_AMETHYST_ORE.get());
        this.dropSelf(ModBlocks.DEEPSLATE_AMETHYST_ORE.get());

        this.dropSelf(ModBlocks.STONE_RUBY_ORE.get());
        this.dropSelf(ModBlocks.DEEPSLATE_RUBY_ORE.get());


        //ORE SPAWN EGGS

        this.dropSelf(ModBlocks.STONE_ANCIENT_DRIED_GIRLFRIEND.get());
        this.dropSelf(ModBlocks.DEEPSLATE_ANCIENT_DRIED_GIRLFRIEND.get());








        //OTHER SHIT
        this.dropSelf(ModBlocks.AMETHYST_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.CRYSTAL_STONE.get());
        this.dropSelf(ModBlocks.EXTREME_TORCH.get());
        this.dropSelf(ModBlocks.CRYSTAL_TORCH.get());
        this.dropSelf(ModBlocks.URANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.ENDER_PEARL_BLOCK.get());
        this.dropSelf(ModBlocks.ENDER_EYE_BLOCK.get());
        this.dropSelf(ModBlocks.PINK_TOURMALINE_BLOCK.get());
        this.dropSelf(ModBlocks.TIGERSEYE_BLOCK.get());
        this.dropSelf(ModBlocks.MOBZILLA_SCALE_BLOCK.get());
        this.dropSelf(ModBlocks.CRYSTAL_WOOD_PLANKS.get());


    }
    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

}
