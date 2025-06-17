package com.irontom10.freespawn.item.armor.amethyst;

import com.irontom10.freespawn.item.armor.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class AmethystChestplate extends ArmorItem {

    public AmethystChestplate() {
        super(
                ModArmorMaterials.AMETHYST,  // material
                Type.CHESTPLATE,         // armor type
                new Properties()
        );
    }
}