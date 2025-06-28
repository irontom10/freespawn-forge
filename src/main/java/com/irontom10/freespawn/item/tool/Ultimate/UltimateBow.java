package com.irontom10.freespawn.item.tool.Ultimate;

import com.irontom10.freespawn.item.ModToolMaterials;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class UltimateBow extends BowItem {

    public UltimateBow() {
        super(new Properties()
            .fireResistant()
            .durability(ModToolMaterials.ULTIMATE.getUses())
        );
    }

    public float getDamage() {
        // Lowered damage
        return 7.5F; // Set to a reasonable value for a custom bow
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            float velocity = 4F; // Lowered velocity for more arrow drop
            if (!world.isClientSide) {
                // Always create and shoot an arrow, even if the player has no ammo
                AbstractArrow arrow = new net.minecraft.world.entity.projectile.Arrow(world, player);
                arrow.setBaseDamage(this.getDamage());
                arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity, 2.0F); // Increased inaccuracy for more drop
                arrow.pickup = player.getAbilities().instabuild ? AbstractArrow.Pickup.CREATIVE_ONLY : AbstractArrow.Pickup.DISALLOWED;
                world.addFreshEntity(arrow);
                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));
            }
        } else {
            super.releaseUsing(stack, world, entity, timeLeft);
        }
    }

    @Override
    public void onUseTick(Level world, LivingEntity entity, ItemStack stack, int count) {
        // Instantly release after 1 tick
        if (entity instanceof Player player && player.isUsingItem() && player.getUseItem() == stack) {
            player.releaseUsingItem();
        }
    }
    @Override
    public void inventoryTick(
            ItemStack stack,
            Level world,
            net.minecraft.world.entity.Entity entity,
            int slot,
            boolean selected) {
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack) <= 0) {
            stack.enchant(Enchantments.POWER_ARROWS, 5);
        }
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack) <= 0) {
            stack.enchant(Enchantments.PUNCH_ARROWS, 2);
        }
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) <= 0) {
            stack.enchant(Enchantments.FLAMING_ARROWS, 3);
        }
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) <= 0) {
            stack.enchant(Enchantments.INFINITY_ARROWS, 5);
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
