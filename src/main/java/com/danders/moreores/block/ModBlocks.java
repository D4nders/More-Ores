package com.danders.moreores.block;

import com.danders.moreores.MoreOres;
import com.danders.moreores.block.custom.AlloyFurnaceBlock;
import com.danders.moreores.item.ModItems;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MoreOres.MODID);

    public static final DeferredBlock<Block> LUMEN_ORE = registerBlock("lumen_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(5.0F, 6.0F)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> 10)));

    public static final DeferredBlock<Block> DEEPSLATE_LUMEN_ORE = registerBlock("deepslate_lumen_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> 10)));

    public static final DeferredBlock<Block> INFERNIUM_ORE = registerBlock("infernium_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_INFERNIUM_ORE = registerBlock("deepslate_infernium_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MITHRIL_ORE = registerBlock("mithril_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_MITHRIL_ORE = registerBlock("deepslate_mithril_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> NECROTHITE_ORE = registerBlock("necrothite_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_NECROTHITE_ORE = registerBlock("deepslate_necrothite_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ALLOY_FURNACE = registerBlock("alloy_furnace",
            () -> new AlloyFurnaceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .noOcclusion()));

    private static  <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
