package com.danders.moreores.datagen;

import com.danders.moreores.MoreOres;
import com.danders.moreores.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, blockTags, MoreOres.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.SWORDS)
                .add(ModItems.LUMEN_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.LUMEN_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.LUMEN_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.LUMEN_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.LUMEN_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.LUMEN_HELMET.get())
                .add(ModItems.LUMEN_CHESTPLATE.get())
                .add(ModItems.LUMEN_LEGGINGS.get())
                .add(ModItems.LUMEN_BOOTS.get());
    }
}
