package com.irontom10.freespawn.item.armor.mothscale;

import com.irontom10.freespawn.item.armor.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class UltimateChestplate extends ArmorItem {

    public UltimateChestplate() {
        super(
                ModArmorMaterials.ULTIMATE,  // material
                Type.CHESTPLATE,         // armor type
                new Properties()
                        .fireResistant()  // properties
        );
    }
    @Override
    public void inventoryTick(
            ItemStack stack,
            Level    world,
            net.minecraft.world.entity.Entity entity,
            int      slot,
            boolean  selected
    ) {
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.ALL_DAMAGE_PROTECTION, stack) <= 0) {
            stack.enchant(Enchantments.ALL_DAMAGE_PROTECTION, 5);
        }
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_PROTECTION, stack) <= 0) {
            stack.enchant(Enchantments.FIRE_PROTECTION, 5);
        }
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLAST_PROTECTION, stack) <= 0) {
            stack.enchant(Enchantments.BLAST_PROTECTION, 5);
        }
        if( !world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PROJECTILE_PROTECTION, stack) <= 0) {
            stack.enchant(Enchantments.PROJECTILE_PROTECTION, 5);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}