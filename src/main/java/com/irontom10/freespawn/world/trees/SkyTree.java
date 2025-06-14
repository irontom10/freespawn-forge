package com.irontom10.freespawn.world.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class SkyTree {

    public static void generate(Level level, BlockPos origin, int i, Random random) {
        BlockState base = level.getBlockState(origin.below());
        if (!base.is(Blocks.GRASS_BLOCK) && !base.is(Blocks.DIRT)) return;

        int height = random.nextInt(15) + 190;
        if (height - origin.getY() < 20) return;

        int width = random.nextInt(10) + 25;

        for (int j = origin.getY(); j <= height; j++) {
            placeBlock(level, new BlockPos(origin.getX(), j, origin.getZ()), Blocks.BIRCH_LOG.defaultBlockState());
        }

        placeBlock(level, new BlockPos(origin.getX(), height + 1, origin.getZ()), Blocks.BIRCH_LEAVES.defaultBlockState());

        generateBranch(level, new BlockPos(origin.getX(), height, origin.getZ()), width, 1, 0);
        generateBranch(level, new BlockPos(origin.getX(), height, origin.getZ()), width, -1, 0);
        generateBranch(level, new BlockPos(origin.getX(), height, origin.getZ()), width, 0, 1);
        generateBranch(level, new BlockPos(origin.getX(), height, origin.getZ()), width, 0, -1);

        height -= 5;
        height -= random.nextInt(4);
        width /= 3;

        generateBranch(level, new BlockPos(origin.getX(), height, origin.getZ()), width, 1, 0);
        generateBranch(level, new BlockPos(origin.getX(), height, origin.getZ()), width, -1, 0);
        generateBranch(level, new BlockPos(origin.getX(), height, origin.getZ()), width, 0, 1);
        generateBranch(level, new BlockPos(origin.getX(), height, origin.getZ()), width, 0, -1);
    }

    private static void generateBranch(Level level, BlockPos base, int length, int dirX, int dirZ) {
        for (int i = 1; i < length; i++) {
            BlockPos pos = base.offset(i * dirX, 0, i * dirZ);
            placeBlock(level, pos, Blocks.BIRCH_LOG.defaultBlockState());

            if (level.getBlockState(pos.above()).isAir()) {
                placeBlock(level, pos.above(), Blocks.BIRCH_LEAVES.defaultBlockState());
            }

            BlockPos side1 = pos.offset(dirZ, 0, dirX);
            if (level.getBlockState(side1).isAir()) {
                placeBlock(level, side1, Blocks.BIRCH_LEAVES.defaultBlockState());
            }

            BlockPos side2 = pos.offset(-dirZ, 0, -dirX);
            if (level.getBlockState(side2).isAir()) {
                placeBlock(level, side2, Blocks.BIRCH_LEAVES.defaultBlockState());
            }
        }

        BlockPos tip = base.offset(length * dirX, 0, length * dirZ);
        if (level.getBlockState(tip).isAir()) {
            placeBlock(level, tip, Blocks.BIRCH_LEAVES.defaultBlockState());
        }
    }

    private static void placeBlock(Level level, BlockPos pos, BlockState state) {
        if (level.isEmptyBlock(pos)) {
            level.setBlock(pos, state, Block.UPDATE_ALL);
        }
    }
}