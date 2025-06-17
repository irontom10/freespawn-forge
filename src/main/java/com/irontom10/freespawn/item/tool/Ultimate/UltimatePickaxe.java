package com.irontom10.freespawn.item.tool.Ultimate;

import com.irontom10.freespawn.item.ModItems;
import com.irontom10.freespawn.item.ModToolMaterials;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;

public class UltimatePickaxe extends PickaxeItem {
  public UltimatePickaxe() {
    super(
        ModToolMaterials.ULTIMATE, // tier
        32, // base attack damage modifier
        -3.0F, // attack speed modifier
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
        && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY, stack) <= 0) {
      stack.enchant(Enchantments.BLOCK_EFFICIENCY, 5);
      stack.enchant(Enchantments.BLOCK_FORTUNE, 5);
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

    // custom drops
    if (!world.isClientSide()) {
      if (state.is(Blocks.IRON_ORE) && world.random.nextBoolean()) {
        Block.popResource(world, pos, new ItemStack(Blocks.IRON_ORE.asItem(), 1 + world.random.nextInt(2)));
      }
      if (state.is(Blocks.GOLD_ORE) && world.random.nextBoolean()) {
        Block.popResource(world, pos, new ItemStack(Blocks.GOLD_ORE.asItem(), 1 + world.random.nextInt(2)));
      }
      if (state.is(Blocks.STONE) && world.random.nextInt(100) == 2) {
        int i = world.random.nextInt(6);
        switch (i) {
          case 0 -> Block.popResource(world, pos, new ItemStack(Items.DIAMOND.asItem()));
          case 1 -> Block.popResource(world, pos, new ItemStack(Items.EMERALD.asItem()));
          case 2 -> Block.popResource(world, pos, new ItemStack(ModItems.AMETHYST.get().asItem()));
          case 3 -> Block.popResource(world, pos, new ItemStack(ModItems.RUBY.get().asItem()));
        }
      }
    }

    return true;
  }

  @Override
  public boolean isCorrectToolForDrops(BlockState state) {
    return true;
  }

}
