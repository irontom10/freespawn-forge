package com.irontom10.freespawn.item.tool.Emerald;

import com.irontom10.freespawn.item.ModToolMaterials;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class EmeraldPickaxe extends PickaxeItem {
  public EmeraldPickaxe() {
    super(
        ModToolMaterials.EMERALD, // tier
        1, // base attack damage modifier
        -2.8F, // attack speed modifier
        new Properties());
  }

  @Override
  public void inventoryTick(
      ItemStack stack,
      Level world,
      Entity entity,
      int slot,
      boolean selected) {
    if (!world.isClientSide()
        && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) <= 0) {
      stack.enchant(Enchantments.SILK_TOUCH, 1);
    }
    super.inventoryTick(stack, world, entity, slot, selected);
  }

  @Override
  public boolean mineBlock(
      ItemStack stack,
      Level world,
      BlockState state,
      BlockPos pos,
      LivingEntity breaker) {
    // damage durability
    if (!world.isClientSide() && state.getDestroySpeed(world, pos) > 0) {
      stack.hurtAndBreak(1, breaker,
          e -> e.broadcastBreakEvent(breaker.getUsedItemHand()));
    }

    return true;
  }

  @Override
  public boolean isCorrectToolForDrops(BlockState state) {
    return true;
  }

}
