package com.irontom10.freespawn.item.armor.amethyst;

import com.irontom10.freespawn.item.armor.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;

public class AmethystChestplate extends ArmorItem {

    public AmethystChestplate() {
        super(
                ModArmorMaterials.AMETHYST,  // material
                Type.CHESTPLATE,         // armor type
                new Properties()
        );
    }
}