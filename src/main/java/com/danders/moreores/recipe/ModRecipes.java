package com.danders.moreores.recipe;

import com.danders.moreores.MoreOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, MoreOres.MODID);
    public static final  DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, MoreOres.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<AlloySmeltingRecipe>> ALLOY_FURNACE_SERIALIZER =
            SERIALIZERS.register("alloy_smelting", AlloySmeltingRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<AlloySmeltingRecipe>> ALLOY_FURNACE_TYPE =
            RECIPE_TYPES.register("alloy_smelting", () -> new RecipeType<AlloySmeltingRecipe>() {
                @Override
                public String toString() {
                    return "alloy_smelting";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        RECIPE_TYPES.register(eventBus);
    }
}
