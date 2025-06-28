package com.irontom10.freespawn.item.armor.amethyst;

import com.irontom10.freespawn.item.armor.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;

public class AmethystLeggings extends ArmorItem {
    public AmethystLeggings() {
        super(
                ModArmorMaterials.AMETHYST,  // material
                Type.LEGGINGS,               // armor type
                new Properties()
        );
    }
}