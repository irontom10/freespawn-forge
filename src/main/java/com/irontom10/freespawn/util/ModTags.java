package com.irontom10.freespawn.util;


import com.irontom10.freespawn.main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> NEEDS_ULTIMATE_TOOL =
                tag("needs_ultimate_tool");




        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(main.MOD_ID, name));
        }
    }
    public static class Items {


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(main.MOD_ID, name));
        }
    }

}
