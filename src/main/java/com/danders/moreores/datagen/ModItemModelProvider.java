package com.danders.moreores.datagen;

import com.danders.moreores.MoreOres;
import com.danders.moreores.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, MoreOres.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_LUMEN.get());
        basicItem(ModItems.RAW_INFERNIUM.get());
        basicItem(ModItems.LUMEN_INGOT.get());
        basicItem(ModItems.INFERNIUM_INGOT.get());

        handheldItem(ModItems.LUMEN_SWORD);
        handheldItem(ModItems.LUMEN_PICKAXE);
        handheldItem(ModItems.LUMEN_AXE);
        handheldItem(ModItems.LUMEN_SHOVEL);
        handheldItem(ModItems.LUMEN_HOE);
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MoreOres.MODID,"item/" + item.getId().getPath()));
    }
}
