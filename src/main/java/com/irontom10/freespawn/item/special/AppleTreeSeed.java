package com.irontom10.freespawn.item.special;

import com.irontom10.freespawn.block.ModBlocks;
import com.irontom10.freespawn.world.SeedTreeBuilder;
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

public class AppleTreeSeed extends Item {
    public AppleTreeSeed(Properties props) {
        super(props.stacksTo(16)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        Level world  = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        Player player= ctx.getPlayer();
        ItemStack stack = ctx.getItemInHand();

        if (world.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        var ground = world.getBlockState(pos).getBlock();
        if (ground != Blocks.GRASS_BLOCK && ground != Blocks.DIRT && ground != Blocks.FARMLAND) {
            return InteractionResult.FAIL;
        }

        // play a planting sound
        world.playSound(null,
                pos.getX(), pos.getY(), pos.getZ(),
                SoundEvents.GRASS_PLACE,
                SoundSource.PLAYERS,
                1.0F, 1.0F
        );

        // build the apple tree
        SeedTreeBuilder.generateTree(world, pos.above(), ModBlocks.APPLE_LEAVES.get());

        if (!player.isCreative()) {
            stack.shrink(1);
        }
        return InteractionResult.CONSUME;
    }
}