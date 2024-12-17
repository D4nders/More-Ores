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
                .add(ModBlocks.DEEPSLATE_INFERNIUM_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.LUMEN_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_LUMEN_ORE.get())
                .add(ModBlocks.INFERNIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_INFERNIUM_ORE.get());
    }
}
