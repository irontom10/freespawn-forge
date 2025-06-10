package com.irontom10.freespawn.datagen;

import com.irontom10.freespawn.block.ModBlocks;
import com.irontom10.freespawn.item.ModItems;
import com.irontom10.freespawn.main;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE.get());
    private Consumer<FinishedRecipe> pWriter;
    private ItemLike block;
    private ItemLike ingot;
    private ItemLike nugget;

    public ModRecipeProvider(PackOutput pOutput){
        super(pOutput);
    }

    private void blockWithIngot(Consumer<FinishedRecipe> pWriter,
                                ItemLike block, ItemLike ingot) {
        // 3×3 ingots → block
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pWriter, main.MOD_ID + ":" + "ingot_to_" + getItemName(block));

        // block → 9 ingots
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingot, 9)
                .requires(block)
                .unlockedBy(getHasName(block), has(block))
                .save(pWriter, main.MOD_ID + ":" + "block_to_" + getItemName(ingot));
    }

    private void blockWithNugget(Consumer<FinishedRecipe> pWriter,
                                 ItemLike block, ItemLike ingot, ItemLike nugget) {
        blockWithIngot(pWriter, block, ingot);

        // 3×3 nuggets → ingot
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingot)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', nugget)
                .unlockedBy(getHasName(nugget), has(nugget))
                .save(pWriter, main.MOD_ID + ":" + "nuggets_to_" + getItemName(ingot));

        // ingot → 9 nuggets
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nugget, 9)
                .requires(ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(pWriter, main.MOD_ID + ":" + "ingot_to_" + getItemName(nugget));
    }
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter){
        blockWithNugget(pWriter, ModBlocks.URANIUM_BLOCK.get(), ModItems.URANIUM_INGOT.get(), ModItems.URANIUM_NUGGET.get());
        blockWithNugget(pWriter, ModBlocks.TITANIUM_BLOCK.get(), ModItems.TITANIUM_INGOT.get(), ModItems.TITANIUM_NUGGET.get());

        blockWithIngot(pWriter, ModBlocks.AMETHYST_BLOCK.get(), ModItems.AMETHYST.get());
        blockWithIngot(pWriter, ModBlocks.RUBY_BLOCK.get(), ModItems.RUBY.get());
        blockWithIngot(pWriter, ModBlocks.ENDER_PEARL_BLOCK.get(), Items.ENDER_PEARL);
        blockWithIngot(pWriter, ModBlocks.ENDER_EYE_BLOCK.get(), Items.ENDER_EYE);
        blockWithIngot(pWriter, ModBlocks.PINK_TOURMALINE_BLOCK.get(), ModItems.PINK_TOURMALINE_INGOT.get());
        blockWithIngot(pWriter, ModBlocks.TIGERSEYE_BLOCK.get(), ModItems.TIGERSEYE_INGOT.get());




        oreSmelting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 200, "ruby");
        oreBlasting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 100, "ruby");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
                .save(pWriter);
    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, main.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }


}
