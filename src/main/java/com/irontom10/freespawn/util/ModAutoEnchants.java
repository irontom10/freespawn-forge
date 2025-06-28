package com.irontom10.freespawn.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModAutoEnchants {
    private static final Map<Item, List<EnchantEntry>> ENCHANTS = new HashMap<>();

    public static void enchant(Item item, Enchantment enchantment, int level) {
        ENCHANTS.computeIfAbsent(item, i -> new ArrayList<>()).add(new EnchantEntry(enchantment, level));
    }

    public static void apply(ItemStack stack, Level world) {
        if (world.isClientSide()) return;

        List<EnchantEntry> entries = ENCHANTS.get(stack.getItem());
        if (entries != null) {
            for (EnchantEntry entry : entries) {
                if (EnchantmentHelper.getItemEnchantmentLevel(entry.enchant, stack) < entry.level) {
                    stack.enchant(entry.enchant, entry.level);
                }
            }
        }
    }

    private record EnchantEntry(Enchantment enchant, int level) {}
}
