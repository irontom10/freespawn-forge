package com.irontom10.freespawn.item.armor.tigerseye;


import com.irontom10.freespawn.item.armor.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class TigerseyeHelmet extends ArmorItem {
    public TigerseyeHelmet() {
        super(
                ModArmorMaterials.TIGERSEYE,  // material
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

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}