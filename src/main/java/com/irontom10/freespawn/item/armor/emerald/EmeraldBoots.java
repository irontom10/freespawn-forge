package com.irontom10.freespawn.item.armor.emerald;

import com.irontom10.freespawn.item.armor.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EmeraldBoots extends ArmorItem {
  public EmeraldBoots() {
    super(
        ModArmorMaterials.EMERALD, // material
        Type.BOOTS, // armor type
        new Properties());
  }

  @Override
  public void inventoryTick(
      ItemStack stack,
      Level world,
      net.minecraft.world.entity.Entity entity,
      int slot,
      boolean selected) {
    super.inventoryTick(stack, world, entity, slot, selected);
  }
}
