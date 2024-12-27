package com.danders.moreores.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.stream.IntStream;

public record AlloySmeltingRecipe(Ingredient input_1, Ingredient input_2, ItemStack output) implements Recipe<AlloySmeltingRecipeInput> {
    @Override
    public boolean matches(AlloySmeltingRecipeInput recipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }
        if (getIngredients().size() != recipeInput.size()) {
            return false;
        }

        return IntStream.range(0, getIngredients().size())
                .allMatch(i -> getIngredients().get(i).test(recipeInput.getItem(i)));
    }

    @Override
    public ItemStack assemble(AlloySmeltingRecipeInput alloySmeltingRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ALLOY_FURNACE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.ALLOY_FURNACE_TYPE.get();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(input_1);
        ingredients.add(input_2);
        return ingredients;
    }

    public static class Serializer implements RecipeSerializer<AlloySmeltingRecipe> {

        public static final MapCodec<AlloySmeltingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                        Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(AlloySmeltingRecipe::input_1),
                        Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(AlloySmeltingRecipe::input_2),
                        ItemStack.CODEC.fieldOf("result").forGetter(AlloySmeltingRecipe::output))
                .apply(instance, AlloySmeltingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, AlloySmeltingRecipe> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, AlloySmeltingRecipe::input_1,
                Ingredient.CONTENTS_STREAM_CODEC, AlloySmeltingRecipe::input_2,
                ItemStack.STREAM_CODEC, AlloySmeltingRecipe::output, AlloySmeltingRecipe::new);

        @Override
        public MapCodec<AlloySmeltingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, AlloySmeltingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}