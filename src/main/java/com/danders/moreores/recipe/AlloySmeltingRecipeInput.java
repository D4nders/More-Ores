package com.danders.moreores.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record AlloySmeltingRecipeInput(ItemStack input_1, ItemStack input_2) implements RecipeInput {

    public ItemStack getItem(int index) {
        return switch (index) {
            case 0 -> input_1;
            case 1 -> input_2;
            default -> throw new IndexOutOfBoundsException("Invalid index: " + index);
        };
    }

    public int size() {
        return 2;
    }
}