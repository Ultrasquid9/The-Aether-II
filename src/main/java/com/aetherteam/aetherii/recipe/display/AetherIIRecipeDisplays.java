package com.aetherteam.aetherii.recipe.display;

import com.aetherteam.aetherii.AetherII;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SmithingRecipeDisplay;

public class AetherIIRecipeDisplays {
    public static final RecipeDisplay.Type<AltarRecipeDisplay> ALTAR = register("altar", AltarRecipeDisplay.TYPE);

    private static <T extends RecipeDisplay> RecipeDisplay.Type<T> register(String id, RecipeDisplay.Type<T> type) {
        return Registry.register(BuiltInRegistries.RECIPE_DISPLAY, ResourceLocation.fromNamespaceAndPath(AetherII.MODID, id), type);
    }
}
