package com.danders.moreores.compat;

import com.danders.moreores.MoreOres;
import com.danders.moreores.recipe.AlloySmeltingRecipe;
import com.danders.moreores.recipe.ModRecipes;
import com.danders.moreores.screen.custom.AlloyFurnaceScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIMoreOresPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(MoreOres.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AlloySmeltingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<AlloySmeltingRecipe> alloySmeltingRecipes = recipeManager.getAllRecipesFor(ModRecipes.ALLOY_FURNACE_TYPE.get()).stream().map(RecipeHolder::value).toList();

        registration.addRecipes(AlloySmeltingRecipeCategory.ALLOY_SMELTING_RECIPE_RECIPE_TYPE, alloySmeltingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(AlloyFurnaceScreen.class, 79, 34, 24, 16, AlloySmeltingRecipeCategory.ALLOY_SMELTING_RECIPE_RECIPE_TYPE);
    }
}
