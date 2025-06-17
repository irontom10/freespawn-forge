package com.irontom10.freespawn.util;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.resources.ResourceLocation;

import static com.irontom10.freespawn.main.MOD_ID;

public class ItemBuilderHelper {
    public static Item.Properties withEffect(Item.Properties props, String itemName, MobEffectInstance effect) {
        ItemPropertiesHandler.addItemEffect(new ResourceLocation(MOD_ID, itemName).toString(), effect);
        return props;
    }

    public static Item.Properties withEnchant(Item.Properties props, String itemName, Enchantment ench, int level) {
        ItemPropertiesHandler.addItemEnchant(new ResourceLocation(MOD_ID, itemName).toString(), ench, level);
        return props;
    }

    public static Item.Properties withArmorEffect(Item.Properties props, String itemName, MobEffectInstance effect) {
        ItemPropertiesHandler.addArmorEffect(new ResourceLocation(MOD_ID, itemName).toString(), effect);
        return props;
    }
}
