package com.danders.moreores.datagen;

import com.danders.moreores.block.ModBlocks;
import com.danders.moreores.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.LUMEN_ORE.get(),
                block -> createOreDrop(ModBlocks.LUMEN_ORE.get(), ModItems.RAW_LUMEN.get()));

        this.add(ModBlocks.DEEPSLATE_LUMEN_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_LUMEN_ORE.get(), ModItems.RAW_LUMEN.get()));

        this.add(ModBlocks.INFERNIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.INFERNIUM_ORE.get(), ModItems.RAW_INFERNIUM.get(), 2f, 3f));

        this.add(ModBlocks.DEEPSLATE_INFERNIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_INFERNIUM_ORE.get(), ModItems.RAW_INFERNIUM.get(), 2f, 3f));

        this.add(ModBlocks.MITHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.MITHRIL_ORE.get(), ModItems.RAW_MITHRIL.get()));

        this.add(ModBlocks.DEEPSLATE_MITHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_MITHRIL_ORE.get(), ModItems.RAW_MITHRIL.get()));

        this.add(ModBlocks.NECROTHITE_ORE.get(),
                block -> createOreDrop(ModBlocks.NECROTHITE_ORE.get(), ModItems.RAW_NECROTHITE.get()));

        this.add(ModBlocks.DEEPSLATE_NECROTHITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_NECROTHITE_ORE.get(), ModItems.RAW_NECROTHITE.get()));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
