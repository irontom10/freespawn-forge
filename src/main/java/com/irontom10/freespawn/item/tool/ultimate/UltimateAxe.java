package com.irontom10.freespawn.item.tool.ultimate;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class UltimateAxe extends AxeItem {
    public UltimateAxe() {
        super(
                Tiers.NETHERITE,  // material
                5,                // base damage (vanilla netherite axe is 5)
                -3.0F,            // attack speed (vanilla netherite axe is -3.0)
                new Item.Properties()
                        .fireResistant()
        );
    }

    /** Auto‐enchant when crafted or otherwise first given: Efficiency V */
    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        stack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
    }

    /** Each tick in inventory: re‐apply Efficiency V if somehow lost */
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
            stack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    /** Always counts as a valid tool for any block */
    @Override
    public boolean isCorrectToolForDrops(net.minecraft.world.level.block.state.BlockState state) {
        return true;
    }
}