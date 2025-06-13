package com.irontom10.freespawn.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolMaterials {
    public static final Tier ULTIMATE = create("ultimate", 10, 3000, 15.0f, 36.0f, 100);
    public static final Tier NIGHTMARE = create("nightmare", 3, 1800, 12.0f, 26.0f, 60);
    public static final Tier BERTHA = create("bertha", 3, 9000, 15.0f, 496.0f, 100);
    public static final Tier CRYSTAL_WOOD = create("crystal_wood", 2, 300, 3.0f, 2.0f, 15);
    public static final Tier CRYSTAL_STONE = create("crystal_stone", 3, 800, 6.0f, 5.0f, 45);
    public static final Tier PINK_TOURMALINE = create("pink", 4, 1100, 10.0f, 7.0f, 65);
    public static final Tier TIGERS_EYE = create("tiger_seye", 4, 1600, 12.0f, 8.0f, 75);
    public static final Tier RUBY = create("ruby", 5, 1500, 11.0f, 16.0f, 85);
    public static final Tier AMETHYST = create("amethyst", 4, 2000, 11.0f, 11.0f, 70);
    public static final Tier EMERALD = create("emerald", 3, 1300, 10.0f, 6.0f, 75);
    public static final Tier ROYAL = create("royal", 3, 10000, 15.0f, 746.0f, 150);
    public static final Tier HAMMY = create("attitude", 5, 2000, 15.0f, 82.0f, 100);
    public static final Tier BATTLE_AXE = create("battle_axe", 3, 1500, 15.0f, 46.0f, 75);
    public static final Tier CHAIN_SAW = create("chainsaw", 3, 1500, 10.0f, 56.0f, 75);
    public static final Tier QUEEN_BATTLEAXE = create("queen_battleaxe", 3, 2200, 15.0f, 662.0f, 100);

    private static Tier create(String name, int level, int uses, float speed, float damage, int enchant) {
        return TierSortingRegistry.registerTier(
                new ForgeTier(level, uses, speed, damage, enchant,
                        BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.EMPTY),
                ResourceLocation.parse(name),
                List.of(), // after
                List.of()  // before
        );
    }
}
