package com.irontom10.freespawn.world;

import com.irontom10.freespawn.main;
import com.irontom10.freespawn.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?,?>> URANIUM_ORE_KEY = registerKey("urainium_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> TITANIUM_ORE_KEY = registerKey("titanium_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> AMETHYST_ORE_KEY = registerKey("amethyst_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> SALT_ORE_KEY = registerKey("salt_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> BLOCK_RUBY_ORE_KEY = registerKey("block_ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> BLOCK_DIAMOND_ORE_KEY = registerKey("block_diamond_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> BLOCK_EMERALD_ORE_KEY = registerKey("block_emerald_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> BLOCK_GOLD_ORE_KEY = registerKey("block_gold_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>>  context) {
        RuleTest stoneReplacable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> uraniumOres = List.of(
                OreConfiguration.target(stoneReplacable, ModBlocks.STONE_URANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, ModBlocks.DEEPSLATE_URANIUM_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> titaniumOres = List.of(
                OreConfiguration.target(stoneReplacable, ModBlocks.STONE_TITANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, ModBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> rubyOres = List.of(
                OreConfiguration.target(stoneReplacable, ModBlocks.STONE_RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> amethystOres = List.of(
                OreConfiguration.target(stoneReplacable, ModBlocks.STONE_AMETHYST_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, ModBlocks.DEEPSLATE_AMETHYST_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> saltOres = List.of(
                OreConfiguration.target(stoneReplacable, ModBlocks.STONE_SALT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, ModBlocks.DEEPSLATE_SALT_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> blockRubyOres = List.of(
                OreConfiguration.target(stoneReplacable, ModBlocks.RUBY_BLOCK.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, ModBlocks.RUBY_BLOCK.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> blockDiamondOres = List.of(
                OreConfiguration.target(stoneReplacable, Blocks.DIAMOND_BLOCK.defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, Blocks.DIAMOND_BLOCK.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> blockEmeraldOres = List.of(
                OreConfiguration.target(stoneReplacable, Blocks.EMERALD_BLOCK.defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, Blocks.EMERALD_BLOCK.defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> blockGoldOres = List.of(
                OreConfiguration.target(stoneReplacable, Blocks.GOLD_BLOCK.defaultBlockState()),
                OreConfiguration.target(deepslateReplacable, Blocks.GOLD_BLOCK.defaultBlockState())
        );

        register(context, URANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(uraniumOres, 9));
        register(context, TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(titaniumOres, 4));
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(rubyOres, 1));
        register(context, AMETHYST_ORE_KEY, Feature.ORE, new OreConfiguration(amethystOres, 6));
        register(context, SALT_ORE_KEY, Feature.ORE, new OreConfiguration(saltOres, 12));
        register(context, BLOCK_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(blockRubyOres, 2));
        register(context, BLOCK_DIAMOND_ORE_KEY, Feature.ORE, new OreConfiguration(blockDiamondOres, 4));
        register(context, BLOCK_EMERALD_ORE_KEY, Feature.ORE, new OreConfiguration(blockEmeraldOres, 4));
        register(context, BLOCK_GOLD_ORE_KEY, Feature.ORE, new OreConfiguration(blockGoldOres, 4));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(main.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
