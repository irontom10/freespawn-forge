package com.irontom10.freespawn.world.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class FairyCastleTree {

    public static void generate(Level level, BlockPos origin, Random random) {
        BlockState log = Blocks.OAK_LOG.defaultBlockState();           // Placeholder for MyCrystalTreeLog
        BlockState leaf2 = Blocks.PINK_WOOL.defaultBlockState();       // Placeholder for MyCrystalLeaves2
        BlockState leaf3 = Blocks.MAGENTA_WOOL.defaultBlockState();    // Placeholder for MyCrystalLeaves3
        BlockState torch = Blocks.SOUL_TORCH.defaultBlockState();      // Placeholder for CrystalTorch

        int layers = 6;
        int spread = 0;
        int y = origin.getY();

        if (shouldSkipLayer(1)) layers--;
        if (shouldSkipLayer(2)) layers -= 2;

        for (int iter = 0; iter < layers; iter++) {
            int platformSize = 1 + random.nextInt(3 + iter);
            int offsetY = y + 3 + random.nextInt(3) - 1;

            buildPlatform(level, origin.offset(spread, offsetY, 0), platformSize, log, leaf2, leaf3, torch, random);
            if (iter > 0) buildPlatform(level, origin.offset(-spread, offsetY, 0), platformSize, log, leaf2, leaf3, torch, random);
            if (iter > 0) buildPlatform(level, origin.offset(0, offsetY, spread), platformSize, log, leaf2, leaf3, torch, random);
            if (iter > 0) buildPlatform(level, origin.offset(0, offsetY, -spread), platformSize, log, leaf2, leaf3, torch, random);

            if (iter >= 2) {
                buildPlatform(level, origin.offset(spread, offsetY, spread), platformSize, log, leaf2, leaf3, torch, random);
                buildPlatform(level, origin.offset(-spread, offsetY, -spread), platformSize, log, leaf2, leaf3, torch, random);
                buildPlatform(level, origin.offset(-spread, offsetY, spread), platformSize, log, leaf2, leaf3, torch, random);
                buildPlatform(level, origin.offset(spread, offsetY, -spread), platformSize, log, leaf2, leaf3, torch, random);
            }

            spread += 3 + random.nextInt(3);
            y += 4 + random.nextInt(2);
        }
    }

    private static void buildPlatform(Level level, BlockPos center, int radius,
                                      BlockState log, BlockState leaf2, BlockState leaf3, BlockState torch, Random random) {
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                BlockPos logPos = center.offset(dx, 0, dz);
                place(level, logPos, log);

                boolean isEdge = dx == -radius || dx == radius || dz == -radius || dz == radius;
                if (isEdge) {
                    makeCastleLeaves(level, logPos, leaf2, leaf3);
                }

                // Optional: place torch at outer corners
                if (isEdge && Math.abs(dx) == radius && Math.abs(dz) == radius) {
                    BlockPos top = logPos.above();
                    if (level.getBlockState(top).isAir()) {
                        place(level, top, torch);
                    }
                }
            }
        }
    }

    private static void makeCastleLeaves(Level level, BlockPos center, BlockState leaf2, BlockState leaf3) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                for (int dy = 0; dy <= 1; dy++) {
                    BlockPos pos = center.offset(dx, dy, dz);
                    if (level.getBlockState(pos).isAir()) {
                        BlockState leaf = (dy == 0) ? leaf2 : leaf3;
                        place(level, pos, leaf);
                    }
                }
            }
        }
    }

    private static boolean shouldSkipLayer(int level) {
        return false; // configurable if you want LessLag-like options
    }

    private static void place(Level level, BlockPos pos, BlockState state) {
        if (level.isEmptyBlock(pos)) {
            level.setBlock(pos, state, Block.UPDATE_ALL);
        }
    }
}
