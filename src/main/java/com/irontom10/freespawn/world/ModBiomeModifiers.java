package com.irontom10.freespawn.world;

import com.irontom10.freespawn.main;
import com.irontom10.freespawn.world.ModPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.data.worldgen.BootstapContext;


public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_URANIUM_ORE = registryKey("add_uranium_ore");
    public static final ResourceKey<BiomeModifier> ADD_TITANIUM_ORE = registryKey("add_titanium_ore");
    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE = registryKey("add_ruby_ore");
    public static final ResourceKey<BiomeModifier> ADD_AMETHYST_ORE = registryKey("add_amethyst_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes  = context.lookup(Registries.BIOME);

        context.register(ADD_URANIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
            biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.URANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }


    private static ResourceKey<BiomeModifier> registryKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(main.MOD_ID, name));
    }
}
