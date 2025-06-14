package com.irontom10.freespawn.world.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class SmallTree {

    public static void generate(Level level, BlockPos origin, Random random) {
        BlockState log = Blocks.BIRCH_LOG.defaultBlockState();
        BlockState leaves = Blocks.BIRCH_LEAVES.defaultBlockState();

        BlockPos ground = origin.below();
        BlockState groundBlock = level.getBlockState(ground);
        if (!groundBlock.is(Blocks.GRASS_BLOCK) && !groundBlock.is(Blocks.DIRT) && !groundBlock.is(Blocks.FARMLAND)) {
            // Try up to 2 blocks lower
            for (int i = 2; i <= 3; i++) {
                ground = origin.below(i);
                groundBlock = level.getBlockState(ground);
                if (groundBlock.is(Blocks.GRASS_BLOCK) || groundBlock.is(Blocks.DIRT) || groundBlock.is(Blocks.FARMLAND)) {
                    origin = ground.above(); // update tree base
                    break;
                }
                if (i == 3) return; // ground never found
            }
        }

        int y = origin.getY();

        // Trunk (1–3 blocks)
        for (int i = 0; i < 3; i++) {
            BlockPos pos = new BlockPos(origin.getX(), y + i, origin.getZ());
            if (level.getBlockState(pos).isAir()) {
                place(level, pos, log);
            } else {
                break;
            }
        }

        // Top leaf
        BlockPos topLeaf = new BlockPos(origin.getX(), y + 3, origin.getZ());
        if (level.getBlockState(topLeaf).isAir()) {
            place(level, topLeaf, leaves);
        }

        // Leaf ring
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                if (dx == 0 && dz == 0) continue;
                BlockPos pos = new BlockPos(origin.getX() + dx, y + 2, origin.getZ() + dz);
                if (level.getBlockState(pos).isAir()) {
                    place(level, pos, leaves);
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
