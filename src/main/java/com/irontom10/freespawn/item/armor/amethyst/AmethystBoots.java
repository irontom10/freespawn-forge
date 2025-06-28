package com.irontom10.freespawn.item.armor.amethyst;

import com.irontom10.freespawn.item.armor.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;

public class AmethystBoots extends ArmorItem {
    public AmethystBoots() {
        super(
                ModArmorMaterials.AMETHYST,  // material
                Type.BOOTS,               // armor type
                new Properties()
        );
    }
}