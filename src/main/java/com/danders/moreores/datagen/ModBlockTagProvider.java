package com.danders.moreores.datagen;

import com.danders.moreores.MoreOres;
import com.danders.moreores.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, MoreOres.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LUMEN_ORE.get())
                .add(ModBlocks.DEEPSLATE_LUMEN_ORE.get())
                .add(ModBlocks.INFERNIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_INFERNIUM_ORE.get())
                .add(ModBlocks.NETHER_INFERNIUM_ORE.get())
                .add(ModBlocks.MITHRIL_ORE.get())
                .add(ModBlocks.DEEPSLATE_MITHRIL_ORE.get())
                .add(ModBlocks.NECROTHITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_NECROTHITE_ORE.get())
                .add(ModBlocks.INANIS_ORE.get())
                .add(ModBlocks.SOARSTONE_ORE.get())
                .add(ModBlocks.SOULIUM_ORE.get())
                .add(ModBlocks.CINDERITE_ORE.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.ADAMANTIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.LUMEN_ORE.get())
                .add(ModBlocks.SOULIUM_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_LUMEN_ORE.get())
                .add(ModBlocks.INFERNIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_INFERNIUM_ORE.get())
                .add(ModBlocks.NETHER_INFERNIUM_ORE.get())
                .add(ModBlocks.NECROTHITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_NECROTHITE_ORE.get())
                .add(ModBlocks.INANIS_ORE.get())
                .add(ModBlocks.SOARSTONE_ORE.get())
                .add(ModBlocks.CINDERITE_ORE.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_ORE.get())
                .add(ModBlocks.DEEPSLATE_MITHRIL_ORE.get())
                .add(ModBlocks.ADAMANTIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get());
    }
}
