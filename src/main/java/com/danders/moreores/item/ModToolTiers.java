package com.danders.moreores.item;

import com.danders.moreores.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier LUMEN = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_LUMEN_TOOL,
            300, 7.0F, 3.0F, 14, () -> Ingredient.of(ModItems.LUMEN_INGOT));
}
