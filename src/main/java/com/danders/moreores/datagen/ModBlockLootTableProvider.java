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

        this.add(ModBlocks.NETHER_INFERNIUM_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.NETHER_INFERNIUM_ORE.get(), ModItems.RAW_INFERNIUM.get(), 2f, 3f));

        this.add(ModBlocks.MITHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.MITHRIL_ORE.get(), ModItems.RAW_MITHRIL.get()));

        this.add(ModBlocks.DEEPSLATE_MITHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_MITHRIL_ORE.get(), ModItems.RAW_MITHRIL.get()));

        this.add(ModBlocks.NECROTHITE_ORE.get(),
                block -> createOreDrop(ModBlocks.NECROTHITE_ORE.get(), ModItems.RAW_NECROTHITE.get()));

        this.add(ModBlocks.DEEPSLATE_NECROTHITE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_NECROTHITE_ORE.get(), ModItems.RAW_NECROTHITE.get()));

        this.add(ModBlocks.INANIS_ORE.get(),
                block -> createOreDrop(ModBlocks.INANIS_ORE.get(), ModItems.RAW_INANIS.get()));

        this.add(ModBlocks.SOARSTONE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.SOARSTONE_ORE.get(), ModItems.SOARSTONE.get(), 2.0F, 5.0F));

        this.add(ModBlocks.SOULIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.SOULIUM_ORE.get(), ModItems.SOULIUM.get()));

        this.add(ModBlocks.CINDERITE_ORE.get(),
                block -> createOreDrop(ModBlocks.CINDERITE_ORE.get(), ModItems.RAW_CINDERITE.get()));

        this.add(ModBlocks.RUBY_ORE.get(),
                block -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));

        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));

        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createOreDrop(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));

        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));

        this.add(ModBlocks.SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));

        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get()));

        this.add(ModBlocks.TIN_ORE.get(),
                block -> createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()));

        this.add(ModBlocks.DEEPSLATE_TIN_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get()));

        this.dropSelf(ModBlocks.ALLOY_FURNACE.get());
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
