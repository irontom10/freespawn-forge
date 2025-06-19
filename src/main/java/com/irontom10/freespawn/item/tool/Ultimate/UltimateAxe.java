package com.irontom10.freespawn.item.tool.Ultimate;

import com.irontom10.freespawn.item.ModToolMaterials;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class UltimateAxe extends AxeItem {
  public UltimateAxe() {
    super(
        ModToolMaterials.ULTIMATE, // material
        5, // base damage (vanilla netherite axe is 5)
        -3.0F, // attack speed (vanilla netherite axe is -3.0)
        new Properties());
  }

  @Override
  public void inventoryTick(
      ItemStack stack,
      Level world,
      net.minecraft.world.entity.Entity entity,
      int slot,
      boolean selected) {
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
