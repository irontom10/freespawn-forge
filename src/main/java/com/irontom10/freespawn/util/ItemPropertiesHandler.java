package com.irontom10.freespawn.util;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.*;

public class ItemPropertiesHandler {
    private static final Map<String, List<MobEffectInstance>> itemEffects = new HashMap<>();
    private static final Map<String, Map<Enchantment, Integer>> itemEnchants = new HashMap<>();
    private static final Map<String, List<MobEffectInstance>> armorEffects = new HashMap<>();

    public static void addItemEffect(String id, MobEffectInstance effect) {
        itemEffects.computeIfAbsent(id, k -> new ArrayList<>()).add(effect);
    }

    public static void addItemEnchant(String id, Enchantment enchantment, int level) {
        itemEnchants.computeIfAbsent(id, k -> new HashMap<>()).put(enchantment, level);
    }

    public static void addArmorEffect(String id, MobEffectInstance effect) {
        armorEffects.computeIfAbsent(id, k -> new ArrayList<>()).add(effect);
    }

    public static List<MobEffectInstance> getItemEffects(String id) {
        return itemEffects.getOrDefault(id, Collections.emptyList());
    }

    public static Map<Enchantment, Integer> getItemEnchants(String id) {
        return itemEnchants.getOrDefault(id, Collections.emptyMap());
    }

    public static List<MobEffectInstance> getArmorEffects(String id) {
        return armorEffects.getOrDefault(id, Collections.emptyList());
    }
}
