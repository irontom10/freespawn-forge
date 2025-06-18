package com.irontom10.freespawn.item.armor.peacock;

import com.irontom10.freespawn.item.armor.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class PeacockBoots extends ArmorItem {
    public PeacockBoots() {
        super(
                ModArmorMaterials.PEACOCK,  // material
                Type.BOOTS,               // armor type
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
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FALL_PROTECTION, stack) <= 0) {
            stack.enchant(Enchantments.FALL_PROTECTION, 10);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}