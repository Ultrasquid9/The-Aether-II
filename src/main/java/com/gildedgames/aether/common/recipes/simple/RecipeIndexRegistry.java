package com.gildedgames.aether.common.recipes.simple;

import com.gildedgames.aether.api.registry.recipes.IIndexableRecipe;
import com.gildedgames.aether.api.registry.recipes.IRecipeIndexRegistry;
import com.gildedgames.aether.api.registry.recipes.ItemMetaPair;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.Validate;

import java.util.*;
import java.util.function.Function;

public class RecipeIndexRegistry implements IRecipeIndexRegistry
{
	private static final Collection<IIndexableRecipe> EMPTY = Collections.emptyList();

	private final Map<ItemMetaPair, Collection<IIndexableRecipe>> cache = new HashMap<>();

	@Override
	public void addIndex(IIndexableRecipe recipe)
	{
		Validate.notNull(recipe);

		for (ItemMetaPair item : recipe.getRecipeItems())
		{
			Collection<IIndexableRecipe> group = this.cache.computeIfAbsent(item, k -> new ArrayList<>());
			group.add(recipe);
		}
	}

	@Override
	public void dropAllIndexes()
	{
		this.cache.clear();
	}

	@Override
	public int getIndexSize()
	{
		return this.cache.size();
	}

	@Override
	public Collection<IIndexableRecipe> getRecipesContainingItem(ItemStack stack)
	{
		return this.cache.getOrDefault(new ItemMetaPair(stack), RecipeIndexRegistry.EMPTY);
	}
}
