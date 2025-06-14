package com.irontom10.freespawn.world.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class BigSquareTree {

    public static void generate(Level level, BlockPos origin, Random rand) {
        if (!(level instanceof ServerLevel)) return;

        BlockState log = Blocks.OAK_LOG.defaultBlockState();
        BlockState leaf = Blocks.OAK_LEAVES.defaultBlockState();
        BlockState stair = Blocks.MOSSY_COBBLESTONE.defaultBlockState();

        int radius = 4 + rand.nextInt(3); // width from center
        int height = 12 + rand.nextInt(6);

        // Build vertical square column
        for (int y = 0; y < height; y++) {
            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    if (Math.abs(dx) == radius || Math.abs(dz) == radius) {
                        BlockPos pos = origin.offset(dx, y, dz);
                        if (level.isEmptyBlock(pos)) {
                            level.setBlock(pos, log, Block.UPDATE_ALL);
                        }
                    }
                }
            }
        }

        // Build top platform floor with leaf blocks
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                BlockPos pos = origin.above(height - 1).offset(dx, 0, dz);
                if (level.isEmptyBlock(pos)) {
                    level.setBlock(pos, leaf, Block.UPDATE_ALL);
                }
            }
        }

        // Add a central column of gold to top
        BlockPos cap1 = origin.above(height);
        BlockPos cap2 = origin.above(height + 1);
        level.setBlock(cap1, Blocks.GOLD_BLOCK.defaultBlockState(), Block.UPDATE_ALL);
        level.setBlock(cap2, Blocks.GOLD_BLOCK.defaultBlockState(), Block.UPDATE_ALL);

        // TODO: Spawn mobs (e.g., The King / Queen) if special tree later
    }
}
