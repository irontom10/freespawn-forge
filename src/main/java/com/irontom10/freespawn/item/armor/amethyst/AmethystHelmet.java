package com.irontom10.freespawn.item.armor.amethyst;


import com.irontom10.freespawn.item.armor.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;

public class AmethystHelmet extends ArmorItem {
    public AmethystHelmet() {
        super(
                ModArmorMaterials.AMETHYST,  // material
                Type.HELMET,               // armor type
                new Properties()
        );
    }
}