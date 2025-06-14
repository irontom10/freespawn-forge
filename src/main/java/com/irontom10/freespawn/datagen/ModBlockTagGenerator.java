package com.irontom10.freespawn.datagen;

import com.irontom10.freespawn.block.ModBlocks;
import com.irontom10.freespawn.main;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, main.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.STONE_AMETHYST_ORE.get(),
                        ModBlocks.DEEPSLATE_AMETHYST_ORE.get(),
                        ModBlocks.STONE_RUBY_ORE.get(),
                        ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                        ModBlocks.STONE_URANIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_URANIUM_ORE.get(),
                        ModBlocks.STONE_TITANIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_TITANIUM_ORE.get(),
                        ModBlocks.STONE_SALT_ORE.get(),
                        ModBlocks.DEEPSLATE_SALT_ORE.get(),

                        ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.AMETHYST_BLOCK.get(),
                        ModBlocks.URANIUM_BLOCK.get(),
                        ModBlocks.TITANIUM_BLOCK.get(),
                        ModBlocks.CRYSTAL_STONE.get(),
                        ModBlocks.PINK_TOURMALINE_BLOCK.get(),
                        ModBlocks.TIGERSEYE_BLOCK.get()


                );
        this.tag(BlockTags.NEEDS_IRON_TOOL);


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

    }
}
