package com.irontom10.freespawn.world.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class ScragglyTree {

    public static void generate(Level level, BlockPos origin, Random random) {
        int trunkLen = 1 + random.nextInt(3);
        int totalHeight = trunkLen + random.nextInt(12);
        int x = origin.getX();
        int y = origin.getY();
        int z = origin.getZ();

        // Initial vertical trunk
        for (int i = 0; i < trunkLen; i++) {
            if (!isReplaceable(level, new BlockPos(x, y + i, z))) return;
            placeBlock(level, new BlockPos(x, y + i, z), Blocks.OAK_LOG.defaultBlockState());
        }

        y += trunkLen - 1;

        // Wandering trunk
        for (int i = trunkLen; i < totalHeight; i++) {
            int dx = random.nextInt(3) - 1;
            int dz = random.nextInt(3) - 1;
            int dy = random.nextInt(4) > 0 ? 1 : 0;
            x += dx;
            z += dz;
            y += dy;

            BlockPos pos = new BlockPos(x, y, z);
            if (!isReplaceable(level, pos)) break;

            placeBlock(level, pos, Blocks.OAK_LOG.defaultBlockState());

            if (random.nextInt(4) == 1) {
                makeBranch(level, pos, random.nextInt(4) + 2, random.nextInt(3) - 1, random.nextInt(3) - 1, random);
            }

            makeLeavesSphere(level, pos, random);
        }
    }

    private static void makeBranch(Level level, BlockPos origin, int len, int biasX, int biasZ, Random random) {
        int x = origin.getX();
        int y = origin.getY();
        int z = origin.getZ();

        for (int i = 0; i < len; i++) {
            int dx = random.nextInt(3) - 1 + biasX;
            int dz = random.nextInt(3) - 1 + biasZ;
            int dy = random.nextInt(3) > 0 ? 1 : 0;

            dx = Math.max(-1, Math.min(1, dx));
            dz = Math.max(-1, Math.min(1, dz));

            x += dx;
            z += dz;
            y += dy;

            BlockPos pos = new BlockPos(x, y, z);
            if (!isReplaceable(level, pos)) return;

            placeBlock(level, pos, Blocks.OAK_LOG.defaultBlockState());
            makeLeavesSphere(level, pos, random);
        }
    }

    private static void makeLeavesSphere(Level level, BlockPos center, Random random) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                BlockPos leafPos = center.offset(dx, 0, dz);
                if (random.nextBoolean() && level.getBlockState(leafPos).isAir()) {
                    placeBlock(level, leafPos, Blocks.OAK_LEAVES.defaultBlockState());
                }
            }
        }
        BlockPos top = center.above();
        if (random.nextBoolean() && level.getBlockState(top).isAir()) {
            placeBlock(level, top, Blocks.OAK_LEAVES.defaultBlockState());
        }
    }

    private static boolean isReplaceable(Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        return state.isAir() || state.getBlock() == Blocks.OAK_LOG || state.getBlock() == Blocks.OAK_LEAVES;
    }

    private static void placeBlock(Level level, BlockPos pos, BlockState state) {
        if (level.isEmptyBlock(pos)) {
            level.setBlock(pos, state, Block.UPDATE_ALL);
        }
    }
}
