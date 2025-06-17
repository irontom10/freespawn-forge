package com.irontom10.freespawn.item.tool.Ultimate;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class UltimateShovel extends ShovelItem {
    public UltimateShovel() {
        super(
                Tiers.NETHERITE,  // material
                35,             // base damage (vanilla netherite shovel is 1.5)
                -3.0F,            // attack speed
                new Properties()
                        .fireResistant()
        );
    }

    // Auto‐enchant when crafted or first created
    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        stack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
    }

    // Keep Efficiency V on it, in case it ever gets removed
    @Override
    public void inventoryTick(
            ItemStack      stack,
            Level          world,
            net.minecraft.world.entity.Entity entity,
            int            slot,
            boolean        selected
    ) {
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, stack) <= 0) {
            stack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    // Always counts as correct tool for any block
    @Override
    public boolean isCorrectToolForDrops(net.minecraft.world.level.block.state.BlockState state) {
        return true;
    }
}