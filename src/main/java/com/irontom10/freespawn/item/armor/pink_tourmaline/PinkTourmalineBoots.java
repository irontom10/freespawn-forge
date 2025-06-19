package com.irontom10.freespawn.item.armor.pink_tourmaline;

import com.irontom10.freespawn.item.armor.ModArmorMaterials;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class PinkTourmalineBoots extends ArmorItem {
    public PinkTourmalineBoots() {
        super(
                ModArmorMaterials.PINK_TOURMALINE,  // material
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
        if (!world.isClientSide() && entity instanceof net.minecraft.world.entity.LivingEntity livingEntity) {
            ItemStack equipped = livingEntity.getItemBySlot(net.minecraft.world.entity.EquipmentSlot.FEET);

            if (equipped == stack) {
                // Add Slow Falling for 5 ticks (0.25 seconds), re-applied every tick to maintain effect
                livingEntity.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                        net.minecraft.world.effect.MobEffects.SLOW_FALLING,
                        5, // duration in ticks
                        0, // amplifier (level 1)
                        true, // ambient
                        false // showParticles
                ));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}