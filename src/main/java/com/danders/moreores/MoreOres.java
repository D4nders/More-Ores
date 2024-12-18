package com.danders.moreores;

import com.danders.moreores.block.ModBlockEntityTypes;
import com.danders.moreores.block.ModBlocks;
import com.danders.moreores.block.entity.AlloyFurnaceBlockEntity;
import com.danders.moreores.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MoreOres.MODID)
public class MoreOres
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "moreores";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public MoreOres(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntityTypes.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_LUMEN);
            event.accept(ModItems.RAW_INFERNIUM);
            event.accept(ModItems.RAW_MITHRIL);
            event.accept(ModItems.RAW_NECROTHITE);
            event.accept(ModItems.RAW_INANIS);
            event.accept(ModItems.RAW_CINDERITE);
            event.accept(ModItems.LUMEN_INGOT);
            event.accept(ModItems.INFERNIUM_INGOT);
            event.accept(ModItems.MITHRIL_INGOT);
            event.accept(ModItems.NECROTHITE_INGOT);
            event.accept(ModItems.INANIS_INGOT);
            event.accept(ModItems.CINDERITE_INGOT);
            event.accept(ModItems.SOULIUM);
            event.accept(ModItems.RUBY);
            event.accept(ModItems.SAPPHIRE);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.LUMEN_ORE);
            event.accept(ModBlocks.INFERNIUM_ORE);
            event.accept(ModBlocks.MITHRIL_ORE);
            event.accept(ModBlocks.NECROTHITE_ORE);
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.SAPPHIRE_ORE);

            event.accept(ModBlocks.DEEPSLATE_LUMEN_ORE);
            event.accept(ModBlocks.DEEPSLATE_INFERNIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_MITHRIL_ORE);
            event.accept(ModBlocks.DEEPSLATE_NECROTHITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

            event.accept(ModBlocks.INANIS_ORE);

            event.accept(ModBlocks.NETHER_INFERNIUM_ORE);
            event.accept(ModBlocks.SOULIUM_ORE);
            event.accept(ModBlocks.CINDERITE_ORE);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.LUMEN_SWORD);

            event.accept(ModItems.LUMEN_HELMET);
            event.accept(ModItems.LUMEN_CHESTPLATE);
            event.accept(ModItems.LUMEN_LEGGINGS);
            event.accept(ModItems.LUMEN_BOOTS);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.LUMEN_PICKAXE);
            event.accept(ModItems.LUMEN_AXE);
            event.accept(ModItems.LUMEN_SHOVEL);
            event.accept(ModItems.LUMEN_HOE);
        }

        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.ALLOY_FURNACE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
