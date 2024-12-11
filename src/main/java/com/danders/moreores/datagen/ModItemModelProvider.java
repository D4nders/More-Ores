package com.danders.moreores.datagen;

import com.danders.moreores.MoreOres;
import com.danders.moreores.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
    }
}
