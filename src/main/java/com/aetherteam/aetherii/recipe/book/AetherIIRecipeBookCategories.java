package com.aetherteam.aetherii.recipe.book;

import com.aetherteam.aetherii.AetherII;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeBookCategory;

public class AetherIIRecipeBookCategories {
    public static final RecipeBookCategory ALTAR_FOOD = register("altar_food");
    public static final RecipeBookCategory ALTAR_BLOCKS = register("altar_blocks");
    public static final RecipeBookCategory ALTAR_REPAIRING = register("altar_blocks");
    public static final RecipeBookCategory ALTAR_MISC = register("altar_misc");

    private static RecipeBookCategory register(String id) {
        return Registry.register(BuiltInRegistries.RECIPE_BOOK_CATEGORY, ResourceLocation.fromNamespaceAndPath(AetherII.MODID, id), new RecipeBookCategory());
    }
}
