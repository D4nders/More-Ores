package com.danders.moreores.worldgen;

import com.danders.moreores.MoreOres;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> LUMEN_ORE_PLACED_KEY = registerKey("lumen_ore_placed");
    public static final ResourceKey<PlacedFeature> INFERNIUM_ORE_PLACED_KEY = registerKey("infernium_ore_placed");
    public static final ResourceKey<PlacedFeature> INFERNIUM_ORE_PLACED_NETHER_KEY = registerKey("infernium_ore_nether_placed");
    public static final ResourceKey<PlacedFeature> MITHRIL_ORE_PLACED_KEY = registerKey("mithril_ore_placed");
    public static final ResourceKey<PlacedFeature> NECROTHITE_ORE_PLACED_KEY = registerKey("necrothite_ore_placed");
    public static final ResourceKey<PlacedFeature> INANIS_ORE_PLACED_KEY = registerKey("inanis_ore_placed");
    public static final ResourceKey<PlacedFeature> SOARSTONE_ORE_PLACED_KEY = registerKey("soarstone_ore_placed");
    public static final ResourceKey<PlacedFeature> SOULIUM_ORE_PLACED_KEY = registerKey("soulium_ore_placed");
    public static final ResourceKey<PlacedFeature> CINDERITE_ORE_PLACED_KEY = registerKey("cinderite_ore_placed");
    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final ResourceKey<PlacedFeature> ADAMANTIUM_ORE_PLACED_KEY = registerKey("adamantium_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, LUMEN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_LUMEN_ORE_KEY), ModOrePlacement.commonOrePlacement(20, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.top())));
        register(context, INFERNIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_INFERNIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(15, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));
        register(context, INFERNIUM_ORE_PLACED_NETHER_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_INFERNIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(15, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
        register(context, MITHRIL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MITHRIL_ORE_KEY), ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-30))));
        register(context, NECROTHITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_NECROTHITE_ORE_KEY), ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(40))));
        register(context, INANIS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_INANIS_ORE_KEY), ModOrePlacement.commonOrePlacement(20, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
        register(context, SOARSTONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_SOARSTONE_ORE_KEY), ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
        register(context, SOULIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_SOULIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(20, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
        register(context, CINDERITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_CINDERITE_ORE_KEY), ModOrePlacement.commonOrePlacement(20, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));
        register(context, RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUBY_ORE_KEY), ModOrePlacement.commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SAPPHIRE_ORE_KEY), ModOrePlacement.commonOrePlacement(100, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(480))));
        register(context, SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SILVER_ORE_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));
        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TIN_ORE_KEY), ModOrePlacement.commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112))));
        register(context, ADAMANTIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ADAMANTIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-40))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MoreOres.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}