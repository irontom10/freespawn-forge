package com.irontom10.freespawn.world.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class WindTree {

    public static void generate(Level level, BlockPos origin, int dir, Random random) {
        if (dir < 0 || dir > 3) return;

        // Direction mapping (0=NORTH, 1=SOUTH, 2=WEST, 3=EAST)
        Direction direction = switch (dir) {
            case 0 -> Direction.EAST;
            case 1 -> Direction.WEST;
            case 2 -> Direction.SOUTH;
            case 3 -> Direction.NORTH;
            default -> Direction.NORTH;
        };

        BlockState ground = level.getBlockState(origin.below());
        if (!ground.is(Blocks.GRASS_BLOCK) && !ground.is(Blocks.DIRT)) return;

        BlockState log = Blocks.OAK_LOG.defaultBlockState();
        BlockState leaves = Blocks.OAK_LEAVES.defaultBlockState();

        int height = 40 + random.nextInt(8);   // 40–47 tall
        int branchLength = 8 + random.nextInt(4); // 8–11 block long branches

        // Trunk generation
        for (int y = 0; y < height; y++) {
            BlockPos pos = origin.above(y);
            placeBlock(level, pos, log);

            // Side leaf puff starts after bottom 1/5
            if (y > height / 5) {
                BlockPos sideLeaf = pos.relative(direction);
                placeBlock(level, sideLeaf, leaves);
            }

            // Generate branch every 4 levels after 1/4th height
            if (y > height / 4 && y % 4 == 0) {
                generateBranch(level, pos, direction, branchLength, leaves, log, random);
            }
        }

        // Top cap
        placeBlock(level, origin.above(height), leaves);
    }

    private static void generateBranch(Level level, BlockPos start, Direction dir, int length,
                                       BlockState leaves, BlockState log, Random random) {
        BlockPos pos = start;

        for (int i = 1; i <= length; i++) {
            pos = pos.relative(dir);
            placeBlock(level, pos, log);

            // Optional vertical leafing
            if (level.getBlockState(pos.above()).isAir()) {
                placeBlock(level, pos.above(), leaves);
            }

            if (i < length / 3 && level.getBlockState(pos.above(2)).isAir()) {
                placeBlock(level, pos.above(2), leaves);
            }

            // Side flares in last 2/3 of branch
            if (i > length / 3) {
                Direction side1 = dir.getClockWise();
                Direction side2 = dir.getCounterClockWise();

                BlockPos sideLeaf1 = pos.relative(side1);
                BlockPos sideLeaf2 = pos.relative(side2);

                if (level.getBlockState(sideLeaf1).isAir()) placeBlock(level, sideLeaf1, leaves);
                if (level.getBlockState(sideLeaf2).isAir()) placeBlock(level, sideLeaf2, leaves);
            }
        }

        // Branch tips
        BlockPos tip1 = pos.relative(dir);
        BlockPos tip2 = tip1.relative(dir);

        if (level.getBlockState(tip1).isAir()) placeBlock(level, tip1, leaves);
        if (level.getBlockState(tip2).isAir()) placeBlock(level, tip2, leaves);
    }

    private static void placeBlock(Level level, BlockPos pos, BlockState state) {
        if (level.isEmptyBlock(pos)) {
            level.setBlock(pos, state, Block.UPDATE_ALL);
        }
    }
}
