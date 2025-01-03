package com.danders.moreores.datagen;

import com.danders.moreores.MoreOres;
import com.danders.moreores.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MoreOres.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.LUMEN_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_LUMEN_ORE);
        blockWithItem(ModBlocks.INFERNIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_INFERNIUM_ORE);
        blockWithItem(ModBlocks.NETHER_INFERNIUM_ORE);
        blockWithItem(ModBlocks.MITHRIL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MITHRIL_ORE);
        blockWithItem(ModBlocks.NECROTHITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_NECROTHITE_ORE);
        blockWithItem(ModBlocks.INANIS_ORE);
        blockWithItem(ModBlocks.SOARSTONE_ORE);
        blockWithItem(ModBlocks.SOULIUM_ORE);
        blockWithItem(ModBlocks.CINDERITE_ORE);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.SILVER_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(ModBlocks.ADAMANTIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
