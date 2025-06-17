package com.irontom10.freespawn.item.tool.Ultimate;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class UltimateHoe extends HoeItem {
    public UltimateHoe() {
        super(
                Tiers.NETHERITE,     // material
                30,
                -1F,               // hoe attack speed tweak (vanilla netherite hoe is -1.0)
                new Properties()
                        .fireResistant()
        );
    }

    // (1) Auto-enchant on craft/first creation
    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        stack.enchant(Enchantments.BLOCK_EFFICIENCY, 2);
    }

    // (2) Keep Efficiency II in inventory
    @Override
    public void inventoryTick(
            ItemStack stack,
            Level    world,
            net.minecraft.world.entity.Entity entity,
            int      slot,
            boolean  selected
    ) {
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, stack) <= 0) {
            stack.enchant(Enchantments.BLOCK_EFFICIENCY, 2);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    // (3) Till a 3×3 area when right-clicking dirt/grass
    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        Level world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        Player player = ctx.getPlayer();
        ItemStack stack = ctx.getItemInHand();

        // only on server & if facing top
        if (!world.isClientSide() && ctx.getClickedFace().getAxis().isHorizontal()) {
            return InteractionResult.PASS;
        }

        boolean didAny = false;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                BlockPos target = pos.offset(dx, 0, dz);
                BlockState state = world.getBlockState(target);
                BlockPos above = target.above();

                if ((state.is(Blocks.GRASS) || state.is(Blocks.DIRT))
                        && world.isEmptyBlock(above)) {
                    world.setBlock(target, Blocks.FARMLAND.defaultBlockState(), 3);
                    didAny = true;
                }
            }
        }

        if (didAny) {
            // play till sound once
            world.playSound(null, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
            // damage tool
            stack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(ctx.getHand()));
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}