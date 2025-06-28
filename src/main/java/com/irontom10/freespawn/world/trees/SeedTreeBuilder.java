package com.irontom10.freespawn.world.trees;

import com.irontom10.freespawn.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class SeedTreeBuilder {

    /**
     * Carves out trunk, branches and leafy canopy based on which leaf block is used.
     */
    public static void generateTree(Level world, BlockPos rootPos, Block leafBlock) {
        int h1 = 12, h2 = 6, h3 = 9, h4 = 6, h5 = 14, w1 = 5, w2 = 3;

        // cherry is smaller
        if (leafBlock == ModBlocks.CHERRY_LEAVES.get()) {
            h1 = 8;  h2 = 3;  h3 = 5;  h4 = 3;  h5 = 10;  w1 = 3;  w2 = 1;
        }
        // peach is medium
        else if (leafBlock == ModBlocks.PEACH_LEAVES.get()) {
            h1 = 10; h2 = 5;  h3 = 7;  h4 = 5;  h5 = 12;  w1 = 4;  w2 = 2;
        }

        // 1) Trunk
        for (int dy = 0; dy < h1; dy++) {
            world.setBlockAndUpdate(rootPos.above(dy), Blocks.OAK_LOG.defaultBlockState());
        }

        // 2) Lower cross‐branches at height h2
        for (int dx = -w1 + 1; dx < w1; dx++) {
            world.setBlockAndUpdate(rootPos.offset(dx, h2, 0), Blocks.OAK_LOG.defaultBlockState());
            world.setBlockAndUpdate(rootPos.offset(0, h2, dx), Blocks.OAK_LOG.defaultBlockState());
        }

        // 3) Upper cross‐branches at height h3
        for (int dx = -w2 + 1; dx < w2; dx++) {
            world.setBlockAndUpdate(rootPos.offset(dx, h3, 0), Blocks.OAK_LOG.defaultBlockState());
            world.setBlockAndUpdate(rootPos.offset(0, h3, dx), Blocks.OAK_LOG.defaultBlockState());
        }

        // 4) Leafy canopy from y=h4 to y=h5
        for (int dy = h4; dy <= h5; dy++) {
            int radius = 6;
            if (dy > 8)  radius = 5;
            if (dy > 10) radius = 4;
            // cherry & peach get a slightly smaller radius
            if (leafBlock != ModBlocks.APPLE_LEAVES.get()) {
                radius--;
            }
            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    BlockPos p = rootPos.offset(dx, dy, dz);
                    if (world.isEmptyBlock(p)) {
                        world.setBlockAndUpdate(p, leafBlock.defaultBlockState());
                    }
                }
            }
        }
    }
}