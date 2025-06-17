package com.irontom10.freespawn.util;

import com.irontom10.freespawn.main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.function.Consumer;

public class ItemBuilder {
  public static Item.Properties build(String id, Consumer<ItemPropertiesBuilder> config) {
    Item.Properties props = new Item.Properties();
    config.accept(new ItemPropertiesBuilder(id));
    return props;
  }

  public static class ItemPropertiesBuilder {
    private final String id;

    public ItemPropertiesBuilder(String id) {
      this.id = new ResourceLocation(main.MOD_ID, id).toString();
    }

    public ItemPropertiesBuilder addEffect(MobEffectInstance effect) {
      ItemPropertiesHandler.addItemEffect(id, effect);
      return this;
    }

    public ItemPropertiesBuilder addEnchant(Enchantment ench, int lvl) {
      ItemPropertiesHandler.addItemEnchant(id, ench, lvl);
      return this;
    }

    public ItemPropertiesBuilder addArmorEffect(MobEffectInstance effect) {
      ItemPropertiesHandler.addArmorEffect(id, effect);
      return this;
    }
  }
}
