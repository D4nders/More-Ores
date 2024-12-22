package com.danders.moreores.worldgen;

import com.danders.moreores.MoreOres;
import com.danders.moreores.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_LUMEN_ORE_KEY = registerKey("lumen_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_INFERNIUM_ORE_KEY = registerKey("infernium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_INFERNIUM_ORE_KEY = registerKey("nether_infernium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MITHRIL_ORE_KEY = registerKey("mithril_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NECROTHITE_ORE_KEY = registerKey("necrothite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_INANIS_ORE_KEY = registerKey("inanis_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SOULIUM_ORE_KEY = registerKey("soulium_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldLumenOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.LUMEN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_LUMEN_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> overworldInferniumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.INFERNIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_INFERNIUM_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> netherInferniumOres = List.of(
                OreConfiguration.target(netherrackReplaceables, ModBlocks.NETHER_INFERNIUM_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> overworldMithrilOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.MITHRIL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_MITHRIL_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> overworldNecrothiteOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.NECROTHITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_NECROTHITE_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> endInanisOres = List.of(
                OreConfiguration.target(endstoneReplaceables, ModBlocks.INANIS_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> netherSouliumOres = List.of(
                OreConfiguration.target(netherrackReplaceables, ModBlocks.SOULIUM_ORE.get().defaultBlockState())
        );

        register(context, OVERWORLD_LUMEN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldLumenOres, 9));
        register(context, OVERWORLD_INFERNIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldInferniumOres, 10));
        register(context, NETHER_INFERNIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherInferniumOres, 10));
        register(context, OVERWORLD_MITHRIL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMithrilOres, 5));
        register(context, OVERWORLD_NECROTHITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNecrothiteOres, 9));
        register(context, END_INANIS_ORE_KEY, Feature.ORE, new OreConfiguration(endInanisOres, 9));
        register(context, NETHER_SOULIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherSouliumOres, 10));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MoreOres.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
