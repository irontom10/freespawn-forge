package com.irontom10.freespawn.world.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class DuplicatorTree {

    public static void generate(Level level, BlockPos origin, Random random) {
        BlockState log = Blocks.OAK_LOG.defaultBlockState();
        BlockState leaves = Blocks.OAK_LEAVES.defaultBlockState();

        // Check for ground
        BlockState ground = level.getBlockState(origin.below());
        if (!ground.is(Blocks.GRASS_BLOCK) && !ground.is(Blocks.DIRT) && !ground.is(Blocks.FARMLAND)) {
            for (int i = 1; i <= 2; i++) {
                ground = level.getBlockState(origin.below(i + 1));
                if (ground.is(Blocks.GRASS_BLOCK) || ground.is(Blocks.DIRT) || ground.is(Blocks.FARMLAND)) {
                    origin = origin.below(i);
                    break;
                }
                if (i == 2) return;
            }
        }

        int height = 3 + random.nextInt(2); // height = 3 or 4 logs
        for (int i = 0; i < height; i++) {
            place(level, origin.above(i), log);
        }

        // Leaf on top
        place(level, origin.above(height), leaves);

        // Leaf ring
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                if (dx == 0 && dz == 0) continue;
                place(level, origin.offset(dx, height - 1, dz), leaves);
            }
        }
    }

    private static void place(Level level, BlockPos pos, BlockState state) {
        if (level.isEmptyBlock(pos)) {
            level.setBlock(pos, state, Block.UPDATE_ALL);
        }
    }
}
