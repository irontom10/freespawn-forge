package com.irontom10.freespawn.item.armor.mothscale;


import com.irontom10.freespawn.item.armor.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class MothscaleHelmet extends ArmorItem {
    public MothscaleHelmet() {
        super(
                ModArmorMaterials.MOTHSCALE,  // material
                Type.HELMET,               // armor type
                new Properties()
                        .fireResistant()  // properties
        );
    }

    @Override
    public void inventoryTick(
            ItemStack stack,
            Level world,
            net.minecraft.world.entity.Entity entity,
            int      slot,
            boolean  selected
    ) {
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.ALL_DAMAGE_PROTECTION, stack) <= 0) {
            stack.enchant(Enchantments.ALL_DAMAGE_PROTECTION, 3);
        }
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_PROTECTION, stack) <= 0) {
            stack.enchant(Enchantments.FIRE_PROTECTION, 3);
        }
        if (!world.isClientSide()
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLAST_PROTECTION, stack) <= 0) {
            stack.enchant(Enchantments.BLAST_PROTECTION, 3);
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}