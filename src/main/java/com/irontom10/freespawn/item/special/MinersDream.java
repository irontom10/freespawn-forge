package com.irontom10.freespawn.item.special;


import com.irontom10.freespawn.block.ModBlocks;
import com.irontom10.freespawn.item.ModCreativeTabs;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class MinersDream extends Item {
    private static final int HEIGHT         = 5;
    private static final int WIDTH          = 5;
    private static final int LENGTH         = 64;
    private static final int TORCH_INTERVAL = 5;

    public MinersDream(Properties properties) {
        super(new Item.Properties()
                .stacksTo(16)
                .fireResistant()
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        Level world   = ctx.getLevel();
        BlockPos hit  = ctx.getClickedPos();
        Player player = ctx.getPlayer();
        ItemStack stack = ctx.getItemInHand();

        // must dig purely along X or Z
        BlockPos ppos = player.blockPosition();
        int dx = Integer.signum(hit.getX() - ppos.getX());
        int dz = Integer.signum(hit.getZ() - ppos.getZ());
        if ((dx == 0) == (dz == 0)) {
            return InteractionResult.PASS;
        }

        // play sound
        world.playSound(null, hit, SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.5F);

        if (world.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        int baseX = hit.getX();
        int baseY = ppos.getY();
        int baseZ = hit.getZ();

        // carve tunnel
        for (int yOff = 0; yOff < HEIGHT; yOff++) {
            for (int k = 0; k < LENGTH; k++) {
                int solidCount = 0;
                for (int j = -WIDTH; j <= WIDTH; j++) {
                    int x = baseX + k * dx + j * dz;
                    int y = baseY + yOff;
                    int z = baseZ + k * dz + j * dx;
                    BlockPos pos = new BlockPos(x, y, z);
                    var state = world.getBlockState(pos);
                    var block = state.getBlock();

                    // remove basic blocks
                    if (block == Blocks.STONE
                            || block == Blocks.ANDESITE
                            || block == Blocks.DIORITE
                            || block == Blocks.GRANITE
                            || block == Blocks.DEEPSLATE
                            || block == Blocks.COBBLED_DEEPSLATE
                            || block == Blocks.POLISHED_DEEPSLATE
                            || block == Blocks.DEEPSLATE_BRICKS
                            || block == Blocks.DEEPSLATE_TILES
                            || block == Blocks.CRACKED_DEEPSLATE_BRICKS
                            || block == Blocks.TUFF
                            || block == Blocks.CALCITE
                            || block == Blocks.DIRT
                            || block == Blocks.GRAVEL
                            || block == Blocks.WATER
                            || block == Blocks.LAVA
                            || block == Blocks.NETHERRACK
                            || block == Blocks.END_STONE
                            || block == ModBlocks.CRYSTAL_STONE.get()
                            || block == Blocks.DRIPSTONE_BLOCK) {
                        world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                    }

                    // on ceiling row, count solids & replace loose blocks
                    if (yOff == HEIGHT - 1) {
                        BlockPos above = pos.above();
                        var aboveState = world.getBlockState(above);
                        var aboveBlock = aboveState.getBlock();
                        if (aboveBlock != Blocks.AIR) solidCount++;
                        if (aboveBlock == Blocks.AIR
                                || aboveBlock == Blocks.GRAVEL
                                || aboveBlock == Blocks.SAND
                                || aboveBlock == Blocks.WATER
                                || aboveBlock == Blocks.LAVA) {
                            if (world.dimension() == Level.OVERWORLD) {
                                world.setBlockAndUpdate(above, Blocks.COBBLESTONE.defaultBlockState());
                            } else {
                                world.setBlockAndUpdate(above, ModBlocks.CRYSTAL_STONE.get().defaultBlockState());
                            }
                        }
                    }
                }

                // if no solids in ceiling, clear above
                if (yOff == HEIGHT - 1 && solidCount == 0) {
                    for (int j = -WIDTH; j <= WIDTH; j++) {
                        BlockPos airPos = new BlockPos(
                                baseX + k * dx + j * dz,
                                baseY + yOff + 1,
                                baseZ + k * dz + j * dx
                        );
                        world.setBlockAndUpdate(airPos, Blocks.AIR.defaultBlockState());
                    }
                }
            }
        }

        // place torches
        for (int k = 0; k < LENGTH; k += TORCH_INTERVAL) {
            int x = baseX + k * dx, y = baseY - 1, z = baseZ + k * dz;
            BlockPos floor = new BlockPos(x, y, z);
            var b = world.getBlockState(floor).getBlock();
            BlockPos torchPos = floor.above();

            if ((b == Blocks.STONE
                    || b == Blocks.ANDESITE
                    || b == Blocks.DIORITE
                    || b == Blocks.GRANITE
                    || b == Blocks.DEEPSLATE
                    || b == Blocks.COBBLED_DEEPSLATE
                    || b == Blocks.POLISHED_DEEPSLATE
                    || b == Blocks.DEEPSLATE_BRICKS
                    || b == Blocks.DEEPSLATE_TILES
                    || b == Blocks.CRACKED_DEEPSLATE_BRICKS
                    || b == Blocks.TUFF
                    || b == Blocks.CALCITE
                    || b == Blocks.DIRT
                    || b == Blocks.GRAVEL
                    || b == Blocks.WATER
                    || b == Blocks.LAVA
                    || b == Blocks.NETHERRACK
                    || b == Blocks.END_STONE
                    || b == ModBlocks.CRYSTAL_STONE.get()
                    || b == Blocks.DRIPSTONE_BLOCK)
                    && world.isEmptyBlock(torchPos)) {
                world.setBlockAndUpdate(torchPos, ModBlocks.EXTREME_TORCH.get().defaultBlockState());
            }
            if (b == ModBlocks.CRYSTAL_STONE.get() && world.isEmptyBlock(torchPos)) {
                world.setBlockAndUpdate(torchPos, ModBlocks.CRYSTAL_TORCH.get().defaultBlockState());
            }
        }

        // consume one (unless in Creative)
        if (!player.isCreative()) {
            stack.shrink(1);
        }

        return InteractionResult.SUCCESS;
    }
}
