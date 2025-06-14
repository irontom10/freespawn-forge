package com.irontom10.freespawn.world.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class FairyTree {

    public static void generate(Level level, BlockPos origin, Random random) {
        BlockState log = Blocks.OAK_LOG.defaultBlockState();         // replace with your MyCrystalTreeLog
        BlockState leaves = Blocks.PINK_WOOL.defaultBlockState();    // replace with MyCrystalLeaves3

        // Trunk (2×2 base, 5 tall)
        for (int j = 1; j <= 5; j++) {
            for (int i = 0; i < 2; i++) {
                for (int k = 0; k < 2; k++) {
                    place(level, origin.offset(i, j, k), log);
                }
            }
        }

        // 8 branches at Y+5 and Y+6
        int[][] directions = {
                {0, 1, 1, 1}, {1, 0, 1, -1}, {0, -1, -1, -1}, {-1, 0, -1, 1},
                {0, 1, -1, 1}, {1, 0, 1, 1}, {0, -1, -1, -1}, {-1, 0, -1, -1}
        };

        for (int i = 0; i < 4; i++) {
            growBranch(level, origin.offset(i % 2, 5, i / 2), directions[i][0], directions[i][1], directions[i][2], directions[i][3], -1, log, leaves, random);
        }
        for (int i = 4; i < 8; i++) {
            growBranch(level, origin.offset(i % 2, 6, i / 2 - 2), directions[i][0], directions[i][1], directions[i][2], directions[i][3], -1, log, leaves, random);
        }

        // Final vertical topper
        int top = 6 + random.nextInt(5);
        for (int j = 6; j < top + 6; j++) {
            for (int i = 0; i < 2; i++) {
                for (int k = 0; k < 2; k++) {
                    BlockPos pos = origin.offset(i, j, k);
                    place(level, pos, log);
                    makeLeaves(level, pos, leaves);
                }
            }
        }
    }

    private static void growBranch(Level level, BlockPos origin, int dx, int dz, int ddx, int ddz, int dy,
                                   BlockState log, BlockState leaves, Random random) {
        BlockPos pos = origin;
        int grow = 4 + random.nextInt(4);

        for (int i = 0; i < grow; i++) {
            place(level, pos, log);
            makeLeaves(level, pos, leaves);
            pos = pos.above();
        }

        for (int i = 0; i < 5 + random.nextInt(5); i++) {
            place(level, pos, log);
            makeLeaves(level, pos, leaves);
            pos = pos.offset(dx, 0, dz);
        }

        BlockPos side = origin.offset(dx * grow, grow, dz * grow);
        for (int i = 0; i < 5 + random.nextInt(5); i++) {
            place(level, side, log);
            makeLeaves(level, side, leaves);
            side = side.offset(ddx, 0, ddz);
        }

        for (int i = 0; i < 4 + random.nextInt(4); i++) {
            pos = pos.offset(dx, dy, dz);
            place(level, pos, log);
            makeLeaves(level, pos, leaves);
        }

        for (int i = 0; i < 4 + random.nextInt(4); i++) {
            side = side.offset(ddx, dy, ddz);
            place(level, side, log);
            makeLeaves(level, side, leaves);
        }
    }

    private static void makeLeaves(Level level, BlockPos center, BlockState leaves) {
        for (int dx = -2; dx <= 2; dx++) {
            for (int dz = -2; dz <= 2; dz++) {
                for (int dy = 0; dy <= 1; dy++) {
                    BlockPos leafPos = center.offset(dx, dy, dz);
                    if (level.getBlockState(leafPos).isAir()) {
                        place(level, leafPos, leaves);
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
