package com.irontom10.freespawn.world.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class ExperienceTree {

    public static void generate(Level level, BlockPos origin, Random random) {
        BlockState log = Blocks.OAK_LOG.defaultBlockState();
        BlockState leaves = Blocks.OAK_LEAVES.defaultBlockState();

        BlockState ground = level.getBlockState(origin.below());
        if (!ground.is(Blocks.GRASS_BLOCK) && !ground.is(Blocks.DIRT) && !ground.is(Blocks.FARMLAND)) {
            return;
        }

        // Thick trunk base
        for (int j = 1; j < 6; j++) {
            for (int i = 0; i < 2; i++) {
                for (int k = 0; k < 2; k++) {
                    place(level, origin.offset(i, j, k), log);
                }
            }
        }

        // Large branches from Y+6
        growBranch(level, origin.offset(0, 6, 0), 0, 1, 1, 1, log, leaves, random);     // front right
        growBranch(level, origin.offset(1, 6, 0), 1, 0, 1, -1, log, leaves, random);    // back right
        growBranch(level, origin.offset(0, 6, 1), -1, 0, -1, 1, log, leaves, random);   // front left
        growBranch(level, origin.offset(1, 6, 1), 0, -1, -1, -1, log, leaves, random);  // back left

        // Central trunk continuation
        for (int j = 7; j < 19; j++) {
            for (int i = 0; i < 2; i++) {
                for (int k = 0; k < 2; k++) {
                    place(level, origin.offset(i, j, k), log);
                }
            }
        }

        // Smaller upper branches
        growSmallBranch(level, origin.offset(0, 19, 0), 0, 1, -1, 1, log, leaves, random);
        growSmallBranch(level, origin.offset(1, 19, 0), 1, 0, 1, 1, log, leaves, random);
        growSmallBranch(level, origin.offset(0, 19, 1), -1, 0, -1, -1, log, leaves, random);
        growSmallBranch(level, origin.offset(1, 19, 1), 0, -1, 1, -1, log, leaves, random);

        // Top finish
        int grow = 5 + random.nextInt(6);
        for (int j = 19; j < 19 + grow; j++) {
            for (int i = 0; i < 2; i++) {
                for (int k = 0; k < 2; k++) {
                    BlockPos pos = origin.offset(i, j, k);
                    place(level, pos, log);
                    makeLeaves(level, pos, leaves);
                }
            }
        }
    }

    private static void growBranch(Level level, BlockPos start, int dx, int dz, int ddx, int ddz,
                                   BlockState log, BlockState leaves, Random random) {
        BlockPos pos = start;
        int grow = 5 + random.nextInt(4);

        // vertical + primary
        for (int i = 0; i < grow; i++) {
            place(level, pos, log);
            makeLeaves(level, pos, leaves);
            pos = pos.above();
        }

        // horizontal extension 1
        for (int i = 0; i < 6 + random.nextInt(5); i++) {
            place(level, pos, log);
            makeLeaves(level, pos, leaves);
            pos = pos.offset(dx, 0, dz);
        }

        // horizontal extension 2
        BlockPos pos2 = start.offset(dx * grow, grow, dz * grow);
        for (int i = 0; i < 6 + random.nextInt(5); i++) {
            place(level, pos2, log);
            makeLeaves(level, pos2, leaves);
            pos2 = pos2.offset(ddx, 0, ddz);
        }

        // down sweep
        for (int i = 0; i < 4 + random.nextInt(4); i++) {
            pos = pos.offset(dx, -1, dz);
            place(level, pos, log);
            makeLeaves(level, pos, leaves);
        }

        for (int i = 0; i < 4 + random.nextInt(4); i++) {
            pos2 = pos2.offset(ddx, -1, ddz);
            place(level, pos2, log);
            makeLeaves(level, pos2, leaves);
        }
    }

    private static void growSmallBranch(Level level, BlockPos start, int dx, int dz, int ddx, int ddz,
                                        BlockState log, BlockState leaves, Random random) {
        BlockPos pos = start;
        int grow = 4 + random.nextInt(2);

        // vertical
        for (int i = 0; i < grow; i++) {
            place(level, pos, log);
            makeLeaves(level, pos, leaves);
            pos = pos.above();
        }

        // horizontal 1
        for (int i = 0; i < 4 + random.nextInt(3); i++) {
            pos = pos.offset(dx, 0, dz);
            place(level, pos, log);
            makeLeaves(level, pos, leaves);
        }

        // horizontal 2
        BlockPos pos2 = start.offset(dx * grow, grow, dz * grow);
        for (int i = 0; i < 4 + random.nextInt(3); i++) {
            pos2 = pos2.offset(ddx, 0, ddz);
            place(level, pos2, log);
            makeLeaves(level, pos2, leaves);
        }

        // downward sweep
        for (int i = 0; i < 3 + random.nextInt(3); i++) {
            pos = pos.offset(dx, -1, dz);
            place(level, pos, log);
            makeLeaves(level, pos, leaves);
        }

        for (int i = 0; i < 3 + random.nextInt(3); i++) {
            pos2 = pos2.offset(ddx, -1, ddz);
            place(level, pos2, log);
            makeLeaves(level, pos2, leaves);
        }
    }

    private static void makeLeaves(Level level, BlockPos center, BlockState leaves) {
        for (int dx = -3; dx <= 3; dx++) {
            for (int dz = -3; dz <= 3; dz++) {
                for (int dy = 0; dy <= 2; dy++) {
                    BlockPos pos = center.offset(dx, dy, dz);
                    if (level.getBlockState(pos).isAir()) {
                        place(level, pos, leaves);
                    }
                }
            }
        }
    }

    private static void place(Level level, BlockPos pos, BlockState state) {
        if (level.isEmptyBlock(pos)) {
            level.setBlock(pos, state, Block.UPDATE_ALL);
        }
    }
}
