package com.danders.moreores.compat;

import com.danders.moreores.MoreOres;
import com.danders.moreores.block.ModBlocks;
import com.danders.moreores.recipe.AlloySmeltingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class AlloySmeltingRecipeCategory implements IRecipeCategory<AlloySmeltingRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(MoreOres.MODID, "alloy_smelting");
    public static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(MoreOres.MODID, "textures/gui/alloy_furnace/alloy_furnace_gui_jei.png");

    public static final RecipeType<AlloySmeltingRecipe> ALLOY_SMELTING_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, AlloySmeltingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public AlloySmeltingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(GUI_TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ALLOY_FURNACE.get()));
    }

    @Override
    public RecipeType<AlloySmeltingRecipe> getRecipeType() {
        return ALLOY_SMELTING_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.moreores.alloy_furnace");
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, AlloySmeltingRecipe recipe, IFocusGroup focuses) {
        builder.addInputSlot(45, 17).addIngredients(recipe.input_1());
        builder.addInputSlot(67, 17).addIngredients(recipe.input_2());
        builder.addOutputSlot(116, 35).addItemStack(recipe.output());
    }
}
