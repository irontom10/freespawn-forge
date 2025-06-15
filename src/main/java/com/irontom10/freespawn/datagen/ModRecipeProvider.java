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
    private Consumer<FinishedRecipe> pWriter;
    private ItemLike block;
    private ItemLike ingot;
    private ItemLike nugget;

    public ModRecipeProvider(PackOutput pOutput){
        super(pOutput);
    }

    private static final List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.STONE_RUBY_ORE.get(), ModBlocks.DEEPSLATE_RUBY_ORE.get());
    private static final List<ItemLike> AMETHYST_SMELTABLES = List.of(ModBlocks.STONE_AMETHYST_ORE.get(), ModBlocks.DEEPSLATE_AMETHYST_ORE.get());
    private static final List<ItemLike> URANIUM_SMELTABLES = List.of(ModBlocks.STONE_URANIUM_ORE.get(), ModBlocks.DEEPSLATE_URANIUM_ORE.get());
    private static final List<ItemLike> TITANIUM_SMELTABLES = List.of(ModBlocks.STONE_TITANIUM_ORE.get(), ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
    private static final List<ItemLike> SALT_SMELTABLES = List.of(ModBlocks.STONE_SALT_ORE.get(), ModBlocks.DEEPSLATE_SALT_ORE.get());

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

        DriedToEgg(pWriter, ModBlocks.STONE_ANCIENT_DRIED_GIRLFRIEND.get(), ModItems.GIRLFRIEND_SPAWN_EGG.get());
        DriedToEgg(pWriter, ModBlocks.DEEPSLATE_ANCIENT_DRIED_GIRLFRIEND.get(), ModItems.GIRLFRIEND_SPAWN_EGG.get());

        oreSmeltingAndBlasting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 200, 100, "ruby");
        oreSmeltingAndBlasting(pWriter, AMETHYST_SMELTABLES, RecipeCategory.MISC, ModItems.AMETHYST.get(), 0.25f, 200, 100, "amethyst");
        oreSmeltingAndBlasting(pWriter, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM_NUGGET.get(), 0.25f, 200, 100, "uranium");
        oreSmeltingAndBlasting(pWriter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_NUGGET.get(), 0.25f, 200, 100, "titanium");
        oreSmeltingAndBlasting(pWriter, SALT_SMELTABLES, RecipeCategory.MISC, ModItems.SALT.get(), 0.25f, 200, 100, "salt");


        GenArmorSet(pWriter, ModItems.AMETHYST.get(), "amethyst", ModItems.AMETHYST_HELMET.get(), ModItems.AMETHYST_CHESTPLATE.get(), ModItems.AMETHYST_LEGGINGS.get(), ModItems.AMETHYST_BOOTS.get());
        GenArmorSet(pWriter, Items.EMERALD, "emerald", ModItems.EMERALD_HELMET.get(), ModItems.EMERALD_CHESTPLATE.get(), ModItems.EMERALD_LEGGINGS.get(), ModItems.EMERALD_BOOTS.get());
        GenArmorSet(pWriter, ModItems.RUBY.get(), "ruby", ModItems.RUBY_HELMET.get(), ModItems.RUBY_CHESTPLATE.get(), ModItems.RUBY_LEGGINGS.get(), ModItems.RUBY_BOOTS.get());
        GenArmorSet(pWriter, ModItems.PINK_TOURMALINE_INGOT.get(), "pink_tourmailine", ModItems.PINK_TOURMALINE_HELMET.get(), ModItems.PINK_TOURMALINE_CHESTPLATE.get(), ModItems.PINK_TOURMALINE_LEGGINGS.get(), ModItems.PINK_TOURMALINE_BOOTS.get());
        GenArmorSet(pWriter, ModItems.TIGERSEYE_INGOT.get(), "tigerseye", ModItems.TIGERSEYE_HELMET.get(), ModItems.TIGERSEYE_CHESTPLATE.get(), ModItems.TIGERSEYE_LEGGINGS.get(), ModItems.TIGERSEYE_BOOTS.get());
        GenArmorSet(pWriter, ModItems.MOTHSCALE.get(), "mothscale", ModItems.MOTHSCALE_HELMET.get(), ModItems.MOTHSCALE_CHESTPLATE.get(), ModItems.MOTHSCALE_LEGGINGS.get(), ModItems.MOTHSCALE_BOOTS.get());
        GenArmorSet(pWriter, ModItems.LAVAEEL.get(), "lavaeel", ModItems.LAVAEEL_HELMET.get(), ModItems.LAVAEEL_CHESTPLATE.get(), ModItems.LAVAEEL_LEGGINGS.get(), ModItems.LAVAEEL_BOOTS.get());
        GenArmorSet(pWriter, ModItems.PEACOCK_FEATHER.get(), "peacock", ModItems.PEACOCK_HELMET.get(), ModItems.PEACOCK_CHESTPLATE.get(), ModItems.PEACOCK_LEGGINGS.get(), ModItems.PEACOCK_BOOTS.get());
        GenArmorSet(pWriter, ModItems.MOBZILLA_SCALE.get(), "mobzilla", ModItems.MOBZILLA_HELMET.get(), ModItems.MOBZILLA_CHESTPLATE.get(), ModItems.MOBZILLA_LEGGINGS.get(), ModItems.MOBZILLA_BOOTS.get());
        GenArmorSet(pWriter, ModItems.QUEEN_SCALE.get(), "queen", ModItems.QUEEN_HELMET.get(), ModItems.QUEEN_CHESTPLATE.get(), ModItems.QUEEN_LEGGINGS.get(), ModItems.QUEEN_BOOTS.get());

        GenToolSet(pWriter, ModItems.AMETHYST.get(), "amethyst", ModItems.AMETHYST_SWORD.get(), ModItems.AMETHYST_PICKAXE.get(), ModItems.AMETHYST_AXE.get(), ModItems.AMETHYST_SHOVEL.get(), ModItems.AMETHYST_HOE.get());
        GenToolSet(pWriter, Items.EMERALD, "emerald", ModItems.EMERALD_SWORD.get(), ModItems.EMERALD_PICKAXE.get(), ModItems.EMERALD_AXE.get(), ModItems.EMERALD_SHOVEL.get(), ModItems.EMERALD_HOE.get());
        GenToolSet(pWriter, ModItems.RUBY.get(), "ruby", ModItems.RUBY_SWORD.get(), ModItems.RUBY_PICKAXE.get(), ModItems.RUBY_AXE.get(), ModItems.RUBY_SHOVEL.get(), ModItems.RUBY_HOE.get());
        GenToolSet(pWriter, ModItems.PINK_TOURMALINE_INGOT.get(), "pink_tourmailine", ModItems.PINK_TOURMALINE_SWORD.get(), ModItems.PINK_TOURMALINE_PICKAXE.get(), ModItems.PINK_TOURMALINE_AXE.get(), ModItems.PINK_TOURMALINE_SHOVEL.get(), ModItems.PINK_TOURMALINE_HOE.get());
        GenToolSet(pWriter, ModItems.TIGERSEYE_INGOT.get(), "tigerseye", ModItems.TIGERSEYE_SWORD.get(), ModItems.TIGERSEYE_PICKAXE.get(), ModItems.TIGERSEYE_AXE.get(), ModItems.TIGERSEYE_SHOVEL.get(), ModItems.TIGERSEYE_HOE.get());
        GenToolSet(pWriter, ModBlocks.CRYSTAL_STONE.get(), "crystal_stone", ModItems.CRYSTAL_STONE_SWORD.get(), ModItems.CRYSTAL_STONE_PICKAXE.get(), ModItems.CRYSTAL_STONE_AXE.get(), ModItems.CRYSTAL_STONE_SHOVEL.get(), ModItems.CRYSTAL_STONE_HOE.get());
        GenToolSet(pWriter, ModBlocks.CRYSTAL_WOOD_PLANKS.get(), "crystal_wood", ModItems.CRYSTAL_WOOD_SWORD.get(), ModItems.CRYSTAL_WOOD_PICKAXE.get(), ModItems.CRYSTAL_WOOD_AXE.get(), ModItems.CRYSTAL_WOOD_SHOVEL.get(), ModItems.CRYSTAL_WOOD_HOE.get());

    }


    protected static void oreSmeltingAndBlasting(Consumer<FinishedRecipe> consumer, List<ItemLike> ingredients,
                                                 RecipeCategory category, ItemLike result,
                                                 float experience, int smeltTime, int blastTime, String group) {
        oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, ingredients, category, result, experience, smeltTime, group, "_from_smelting");
        oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, ingredients, category, result, experience, blastTime, group, "_from_blasting");
    }


    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, main.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

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
    private void DriedToEgg (Consumer<FinishedRecipe> pWriter, ItemLike block, ItemLike egg) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, egg)
                .requires(Items.WATER_BUCKET)
                .requires(block)
                .unlockedBy(getHasName(block), has(block))
                .save(pWriter, main.MOD_ID + ":" + getItemName(block)+ "_" + getItemName(egg));
    }
    private void GenToolSet(Consumer<FinishedRecipe> pWriter, ItemLike materialItem, String material, ItemLike sword, ItemLike pickaxe, ItemLike axe, ItemLike shovel, ItemLike hoe) {
        String MATERIAL = material.toUpperCase();

        // Sword
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword)
                .pattern("I")
                .pattern("I")
                .pattern("S")
                .define('I', materialItem)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(materialItem), has(materialItem))
                .save(pWriter);

        // Pickaxe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', materialItem)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(materialItem), has(materialItem))
                .save(pWriter);

        // Axe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .pattern("II")
                .pattern("IS")
                .pattern(" S")
                .define('I', materialItem)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(materialItem), has(materialItem))
                .save(pWriter);


        // Shovel
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .define('I', materialItem)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(materialItem), has(materialItem))
                .save(pWriter);


        // Hoe
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .pattern("II")
                .pattern(" S")
                .pattern(" S")
                .define('I', materialItem)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(materialItem), has(materialItem))
                .save(pWriter);

    }

    private void GenArmorSet(Consumer<FinishedRecipe> pWriter, ItemLike item, String material, ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots) {
        String MATERIAL = material.toUpperCase();

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet)
                .pattern("III")
                .pattern("I I")
                .define('I', item)
                .unlockedBy(getHasName(item), has(item))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate)
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .define('I', item)
                .unlockedBy(getHasName(item), has(item))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings)
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .define('I', item)
                .unlockedBy(getHasName(item), has(item))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots)
                .pattern("I I")
                .pattern("I I")
                .define('I', item)
                .unlockedBy(getHasName(item), has(item))
                .save(pWriter);
    }


}
