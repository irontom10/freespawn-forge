package com.irontom10.freespawn.world.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashSet;
import java.util.Set;

public class BigSquareTree {

    // === Adjustable constants ===
    private static final BlockState TRUNK_BLOCK = Blocks.OAK_LOG.defaultBlockState();
    private static final BlockState LEAF_BLOCK = Blocks.OAK_LEAVES.defaultBlockState();
    private static final BlockState STAIR_BLOCK = Blocks.MOSSY_COBBLESTONE.defaultBlockState();
    private static final BlockState[] CAP_BLOCKS = new BlockState[]{
            Blocks.DIAMOND_BLOCK.defaultBlockState(),
            Blocks.EMERALD_BLOCK.defaultBlockState(),
            Blocks.REDSTONE_BLOCK.defaultBlockState(),
            Blocks.IRON_BLOCK.defaultBlockState(),
            Blocks.GOLD_BLOCK.defaultBlockState(),
            Blocks.NETHERITE_BLOCK.defaultBlockState()
    };

    // BASE_RADIUS: Controls the overall size of the tree trunk and branches
    // MIN_BRANCH_HEIGHT: Minimum height above ground before branches start
    // BRANCH_DEPTH_LIMIT: Maximum recursive depth for sub-branches
    // BRANCH_SIZE_LEAF_MAXIMUM: Max width of leaf clusters at branch ends
    // LEAF_SPREAD: Max distance for leaf cluster spread
    // MAX_TOTAL_BRANCHES: Hard cap on total number of branches to prevent runaway generation
    // TRUNK_HEIGHT: Height of the main trunk (calculated from BASE_RADIUS)
    // BRANCH_LENGTH_BASE: Base length for branches (calculated from BASE_RADIUS)
    // BRANCH_LENGTH_VARIANCE: Randomness added to branch length
    // BRANCH_LENGTH_REDUCTION: Amount branch length is reduced for sub-branches
    // BRANCH_EXTRA_CAP: Extra branches allowed for randomness
    // SUB_BRANCH_START_FACTOR: Where along a branch sub-branches can start
    // SUB_BRANCH_LENGTH_MULTIPLIER: Multiplier for sub-branch length
    // SUB_BRANCH_WIDTH_DECREMENT: How much sub-branches shrink in width
    // BRANCH_HEIGHT_RANDOMNESS: Randomness in branch height

    private static final int BASE_RADIUS = 8;
    private static final int MIN_BRANCH_HEIGHT = 27;
    private static final int BRANCH_DEPTH_LIMIT = 2;
    private static final int BRANCH_SIZE_LEAF_MAXIMUM = 4;
    private static final int LEAF_SPREAD = 2;
    private static final float BRANCH_TIP_EXTENSION_FACTOR = 0.1f;
    private static final int MAX_TOTAL_BRANCHES = 1000;
    private static final int TRUNK_HEIGHT = BASE_RADIUS * 22;
    private static final int BRANCH_LENGTH_BASE = BASE_RADIUS* 14;
    private static final int BRANCH_LENGTH_VARIANCE = 25;
    private static final int BRANCH_LENGTH_REDUCTION = 10;
    private static final int BRANCH_EXTRA_CAP = 10;
    private static final float SUB_BRANCH_START_FACTOR = 2.25f;
    private static final int SUB_BRANCH_LENGTH_MULTIPLIER = 5;
    private static final int SUB_BRANCH_WIDTH_DECREMENT = 3;
    private static final int BRANCH_HEIGHT_RANDOMNESS = 3;


    private static int branchCounter = 0;
    private static final Set<BlockPos> branchPositions = new HashSet<>();
    private static final Set<BlockPos> leafExemptPositions = new HashSet<>();

    public static void generate(Level level, BlockPos origin, RandomSource random) {
        branchCounter = 0;
        branchPositions.clear();
        leafExemptPositions.clear();
        System.out.println("[BigSquareTree] Starting tree generation at: " + origin);
        int finalHeight = generateTaperedTrunk(level, origin, random);
        placeLeaves(level);
        placeCap(level, origin.above(finalHeight + BRANCH_EXTRA_CAP + 1), random);
        System.out.println("[BigSquareTree] Tree generation complete.");
    }

    private static int generateTaperedTrunk(Level level, BlockPos origin, RandomSource random) {
        int staircaseStep = 0;
        int lastBranchLength = Integer.MAX_VALUE;

        for (int y = 0; y < TRUNK_HEIGHT + BRANCH_EXTRA_CAP; y++) {
            float taper = 1.0f - (float) y / TRUNK_HEIGHT;
            int radius = Mth.clamp(Math.round(BASE_RADIUS * taper), 1, BASE_RADIUS);
            int stairRadius = radius;

            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    if (dx * dx + dz * dz <= radius * radius) {
                        BlockPos pos = origin.offset(dx, y, dz);
                        setBlock(level, pos, TRUNK_BLOCK);
                        branchPositions.add(pos);
                        leafExemptPositions.add(pos);
                    }
                }
            }

            double angle = staircaseStep * 0.25;
            int stairX = (int) Math.round(stairRadius * Math.cos(angle));
            int stairZ = (int) Math.round(stairRadius * Math.sin(angle));
            BlockPos stairPos = origin.offset(stairX, y, stairZ);
            setBlock(level, stairPos, STAIR_BLOCK);
            staircaseStep++;

            if (y >= MIN_BRANCH_HEIGHT && y % 10 == 0) {
                int yOffset = random.nextInt(11) - 5;
                int actualY = y + yOffset;
                int currentRadius = Mth.clamp(Math.round(BASE_RADIUS * (1.0f - (float) actualY / TRUNK_HEIGHT)), 1, BASE_RADIUS);

                int baseBranchLength = (BRANCH_LENGTH_BASE + random.nextInt(BRANCH_LENGTH_VARIANCE * 2 + 1) - BRANCH_LENGTH_VARIANCE)
                        * currentRadius / BASE_RADIUS - BRANCH_LENGTH_REDUCTION;
                baseBranchLength = Math.min(baseBranchLength, lastBranchLength - 1);
                lastBranchLength = baseBranchLength;

                int baseBranchWidth = currentRadius;
                System.out.println("[BigSquareTree] Generating 4 branches at Y=" + actualY);
                BlockPos branchStart = origin.offset(0, actualY, 0);
                generateBranch(level, origin.offset(0, actualY + random.nextInt(BRANCH_HEIGHT_RANDOMNESS) - 1, 0),  1,  0, baseBranchWidth, baseBranchLength, 0, random);
                generateBranch(level, origin.offset(0, actualY + random.nextInt(BRANCH_HEIGHT_RANDOMNESS) - 1, 0), -1,  0, baseBranchWidth, baseBranchLength, 0, random);
                generateBranch(level, origin.offset(0, actualY + random.nextInt(BRANCH_HEIGHT_RANDOMNESS) - 1, 0),  0,  1, baseBranchWidth, baseBranchLength, 0, random);
                generateBranch(level, origin.offset(0, actualY + random.nextInt(BRANCH_HEIGHT_RANDOMNESS) - 1, 0),  0, -1, baseBranchWidth, baseBranchLength, 0, random);

            }
        }
        return TRUNK_HEIGHT;
    }

    private static void generateBranch(Level level, BlockPos start, int dirX, int dirZ, int width, int length, int depth, RandomSource random) {
        if (depth > BRANCH_DEPTH_LIMIT || branchCounter++ > MAX_TOTAL_BRANCHES) {
            System.out.println("[BigSquareTree] Branch limit hit or depth exceeded. Depth: " + depth + ", Counter: " + branchCounter);
            return;
        }

        int triggerSubBranchAt = (int)(length / SUB_BRANCH_START_FACTOR);
        boolean subBranchCreated = false;

        for (int i = 0; i < length; i++) {
            int x = start.getX() + dirX * i;
            int z = start.getZ() + dirZ * i;
            int y = start.getY();

            float progress = (float) i / length;
            int taperWidth = Math.max(1, Math.round(width * (1.0f - progress)));

            for (int dx = -taperWidth; dx <= taperWidth; dx++) {
                for (int dz = -taperWidth; dz <= taperWidth; dz++) {
                    if (dx * dx + dz * dz <= taperWidth * taperWidth) {
                        BlockPos pos = new BlockPos(x + dx, y, z + dz);
                        setBlock(level, pos, TRUNK_BLOCK);
                        branchPositions.add(pos);
                        if (taperWidth >= BRANCH_SIZE_LEAF_MAXIMUM) {
                            leafExemptPositions.add(pos);
                        } else {
                            leafExemptPositions.remove(pos);
                        }
                    }
                }
            }

            if (!subBranchCreated && i >= triggerSubBranchAt) {
                int subBranchLength = Math.max(5, width * SUB_BRANCH_LENGTH_MULTIPLIER);
                int subBranchWidth = Math.max(1, ((width - SUB_BRANCH_WIDTH_DECREMENT) / 2) * 2 + 1);

                int subBranchCount = 2; // Both left and right
                if (taperWidth < 5) subBranchCount = 1;
                if (taperWidth < 3) subBranchCount = 0;

                if (subBranchCount >= 1) {
                    generateBranch(level, new BlockPos(x, y, z), dirZ, -dirX, subBranchWidth, subBranchLength, depth + 1, random);
                }
                if (subBranchCount >= 2) {
                    generateBranch(level, new BlockPos(x, y, z), -dirZ, dirX, subBranchWidth, subBranchLength, depth + 1, random);
                }

                subBranchCreated = true;
            }


            if (taperWidth == 1 && i == length - 1) {
                int tipExtension = Math.round(length * BRANCH_TIP_EXTENSION_FACTOR);
                for (int j = 1; j <= tipExtension; j++) {
                    int tipX = x + dirX * j;
                    int tipZ = z + dirZ * j;
                    BlockPos pos = new BlockPos(tipX, y, tipZ);
                    setBlock(level, pos, TRUNK_BLOCK);
                    branchPositions.add(pos);
                }
            }
        }
    }


    private static void placeLeaves(Level level) {
        for (BlockPos pos : branchPositions) {
            if (leafExemptPositions.contains(pos)) continue;
            for (int dx = -LEAF_SPREAD; dx <= LEAF_SPREAD; dx++) {
                for (int dy = 0; dy <= LEAF_SPREAD; dy++) {
                    for (int dz = -LEAF_SPREAD; dz <= LEAF_SPREAD; dz++) {
                        BlockPos leafPos = pos.offset(dx, dy, dz);
                        if (dy >= 0 && pos.distManhattan(leafPos) <= LEAF_SPREAD && level.isEmptyBlock(leafPos)) {
                            setBlock(level, leafPos, LEAF_BLOCK);
                        }
                    }
                }
            }
        }
    }

    private static void placeCap(Level level, BlockPos pos, RandomSource random) {
        for (int i = 0; i < 2; i++) {
            BlockState cap = CAP_BLOCKS[random.nextInt(CAP_BLOCKS.length)];
            setBlock(level, pos.above(i), cap);
        }
    }

    private static void setBlock(Level level, BlockPos pos, BlockState state) {
        if (level.isEmptyBlock(pos)) {
            level.setBlock(pos, state, 3);
        }
    }
}