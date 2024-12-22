package com.danders.moreores.datagen;

import com.danders.moreores.MoreOres;
import com.danders.moreores.block.ModBlocks;
import com.danders.moreores.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipes.ShapedRecipeBuilder.shaped;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> LUMEN_SMELTABLES = List.of(ModItems.RAW_LUMEN, ModBlocks.LUMEN_ORE, ModBlocks.DEEPSLATE_LUMEN_ORE);
        List<ItemLike> INFERNIUM_SMELTABLES = List.of(ModItems.RAW_INFERNIUM, ModBlocks.INFERNIUM_ORE, ModBlocks.DEEPSLATE_INFERNIUM_ORE, ModBlocks.NETHER_INFERNIUM_ORE);
        List<ItemLike> MITHRIL_SMELTABLES = List.of(ModItems.RAW_MITHRIL, ModBlocks.MITHRIL_ORE, ModBlocks.DEEPSLATE_MITHRIL_ORE);
        List<ItemLike> NECROTHITE_SMELTABLES = List.of(ModItems.RAW_NECROTHITE, ModBlocks.NECROTHITE_ORE, ModBlocks.DEEPSLATE_NECROTHITE_ORE);
        List<ItemLike> INANIS_SMELTABLES = List.of(ModItems.RAW_INANIS, ModBlocks.INANIS_ORE);
        List<ItemLike> SOULIUM_SMELTABLES = List.of(ModBlocks.SOULIUM_ORE);
        List<ItemLike> CINDERITE_SMELTABLES = List.of(ModItems.RAW_CINDERITE, ModBlocks.CINDERITE_ORE);
        List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);
        List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        oreSmelting(recipeOutput, LUMEN_SMELTABLES, RecipeCategory.MISC, ModItems.LUMEN_INGOT, 0.25f, 200, "lumen");
        oreBlasting(recipeOutput, LUMEN_SMELTABLES, RecipeCategory.MISC, ModItems.LUMEN_INGOT, 0.25f, 100, "lumen");

        oreSmelting(recipeOutput, INFERNIUM_SMELTABLES, RecipeCategory.MISC, ModItems.INFERNIUM_INGOT, 0.25f, 200, "infernium");
        oreBlasting(recipeOutput, INFERNIUM_SMELTABLES, RecipeCategory.MISC, ModItems.INFERNIUM_INGOT, 0.25f, 100, "infernium");

        oreSmelting(recipeOutput, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT, 0.25f, 200, "mithril");
        oreBlasting(recipeOutput, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT, 0.25f, 100, "mithril");

        oreSmelting(recipeOutput, NECROTHITE_SMELTABLES, RecipeCategory.MISC, ModItems.NECROTHITE_INGOT, 0.25f, 200, "necrothite");
        oreBlasting(recipeOutput, NECROTHITE_SMELTABLES, RecipeCategory.MISC, ModItems.NECROTHITE_INGOT, 0.25f, 100, "necrothite");

        oreSmelting(recipeOutput, INANIS_SMELTABLES, RecipeCategory.MISC, ModItems.INANIS_INGOT, 0.25f, 200, "inanis");
        oreBlasting(recipeOutput, INANIS_SMELTABLES, RecipeCategory.MISC, ModItems.INANIS_INGOT, 0.25f, 100, "inanis");

        oreSmelting(recipeOutput, SOULIUM_SMELTABLES, RecipeCategory.MISC, ModItems.SOULIUM, 0.25f, 200, "soulium");
        oreBlasting(recipeOutput, SOULIUM_SMELTABLES, RecipeCategory.MISC, ModItems.SOULIUM, 0.25f, 100, "soulium");

        oreSmelting(recipeOutput, CINDERITE_SMELTABLES, RecipeCategory.MISC, ModItems.CINDERITE_INGOT, 0.25f, 200, "cinderite");
        oreBlasting(recipeOutput, CINDERITE_SMELTABLES, RecipeCategory.MISC, ModItems.CINDERITE_INGOT, 0.25f, 100, "cinderite");

        oreSmelting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.25f, 200, "ruby");
        oreBlasting(recipeOutput, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.25f, 100, "ruby");

        oreSmelting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, 0.25f, 200, "sapphire");
        oreBlasting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, 0.25f, 100, "sapphire");

        shaped(RecipeCategory.COMBAT, ModItems.LUMEN_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" I ")
                .define('X', ModItems.LUMEN_INGOT.get())
                .define('I', Items.STICK)
                .unlockedBy(getHasName(ModItems.LUMEN_INGOT.get()), has(ModItems.LUMEN_INGOT.get()))
                .save(recipeOutput);
        shaped(RecipeCategory.TOOLS, ModItems.LUMEN_PICKAXE.get())
                .pattern("XXX")
                .pattern(" I ")
                .pattern(" I ")
                .define('X', ModItems.LUMEN_INGOT.get())
                .define('I', Items.STICK)
                .unlockedBy(getHasName(ModItems.LUMEN_INGOT.get()), has(ModItems.LUMEN_INGOT.get()))
                .save(recipeOutput);
        shaped(RecipeCategory.TOOLS, ModItems.LUMEN_AXE.get())
                .pattern("XX ")
                .pattern("XI ")
                .pattern(" I ")
                .define('X', ModItems.LUMEN_INGOT.get())
                .define('I', Items.STICK)
                .unlockedBy(getHasName(ModItems.LUMEN_INGOT.get()), has(ModItems.LUMEN_INGOT.get()))
                .save(recipeOutput);
        shaped(RecipeCategory.TOOLS, ModItems.LUMEN_SHOVEL.get())
                .pattern(" X ")
                .pattern(" I ")
                .pattern(" I ")
                .define('X', ModItems.LUMEN_INGOT.get())
                .define('I', Items.STICK)
                .unlockedBy(getHasName(ModItems.LUMEN_INGOT.get()), has(ModItems.LUMEN_INGOT.get()))
                .save(recipeOutput);
        shaped(RecipeCategory.TOOLS, ModItems.LUMEN_HOE.get())
                .pattern("XX ")
                .pattern(" I ")
                .pattern(" I ")
                .define('X', ModItems.LUMEN_INGOT.get())
                .define('I', Items.STICK)
                .unlockedBy(getHasName(ModItems.LUMEN_INGOT.get()), has(ModItems.LUMEN_INGOT.get()))
                .save(recipeOutput);

        shaped(RecipeCategory.MISC, Items.SOUL_TORCH)
                .pattern("   ")
                .pattern(" X ")
                .pattern(" I ")
                .define('X', ModItems.SOULIUM.get())
                .define('I', Items.STICK)
                .unlockedBy(getHasName(ModItems.SOULIUM.get()), has(ModItems.SOULIUM.get()))
                .save(recipeOutput, MoreOres.MODID + ":" + "soul_torch");

        shaped(RecipeCategory.MISC, Items.SOUL_LANTERN)
                .pattern("OOO")
                .pattern("OXO")
                .pattern("OOO")
                .define('X', ModItems.SOULIUM.get())
                .define('O', Items.IRON_NUGGET)
                .unlockedBy(getHasName(ModItems.SOULIUM.get()), has(ModItems.SOULIUM.get()))
                .save(recipeOutput, MoreOres.MODID + ":" + "soul_lantern");

        shaped(RecipeCategory.MISC, Items.SOUL_CAMPFIRE)
                .pattern(" I ")
                .pattern("IXI")
                .pattern("OOO")
                .define('X', ModItems.SOULIUM.get())
                .define('I', Items.STICK)
                .define('O', ItemTags.LOGS)
                .unlockedBy(getHasName(ModItems.SOULIUM.get()), has(ModItems.SOULIUM.get()))
                .save(recipeOutput, MoreOres.MODID + ":" + "soul_campfire");

        shaped(RecipeCategory.BUILDING_BLOCKS, Items.SOUL_SAND, 8)
                .pattern("OOO")
                .pattern("OXO")
                .pattern("OOO")
                .define('X', ModItems.SOULIUM.get())
                .define('O', Items.SAND)
                .unlockedBy(getHasName(ModItems.SOULIUM.get()), has(ModItems.SOULIUM.get()))
                .save(recipeOutput, MoreOres.MODID + ":" + "soul_sand");

        shaped(RecipeCategory.BUILDING_BLOCKS, Items.SOUL_SOIL, 8)
                .pattern("OOO")
                .pattern("OXO")
                .pattern("OOO")
                .define('X', ModItems.SOULIUM.get())
                .define('O', Items.DIRT)
                .unlockedBy(getHasName(ModItems.SOULIUM.get()), has(ModItems.SOULIUM.get()))
                .save(recipeOutput, MoreOres.MODID + ":" + "soul_soil");
    }


    // Puts smelting recipes under MoreOres directory
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, MoreOres.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
