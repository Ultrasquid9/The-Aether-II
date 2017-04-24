package com.gildedgames.aether.api;

import com.gildedgames.aether.api.dialog.IDialogManager;
import com.gildedgames.aether.api.registry.IEquipmentRegistry;
import com.gildedgames.aether.api.registry.IItemPropertiesRegistry;
import com.gildedgames.aether.api.registry.altar.IAltarRecipeRegistry;
import com.gildedgames.aether.api.registry.recipes.IRecipeIndexRegistry;
import com.gildedgames.aether.api.registry.tab.ITabRegistry;

public class AetherAPI
{
	private static IAetherServiceLocator services;

	public static IAltarRecipeRegistry altar()
	{
		return AetherAPI.services().getAltarRecipeRegistry();
	}

	public static ITabRegistry tabs()
	{
		return AetherAPI.services().getTabRegistry();
	}

	public static IItemPropertiesRegistry items()
	{
		return AetherAPI.services().getItemPropertiesRegistry();
	}

	public static IEquipmentRegistry equipment()
	{
		return AetherAPI.services().getEquipmentRegistry();
	}

	public static IDialogManager dialog()
	{
		return AetherAPI.services().getDialogManager();
	}

	public static void registerProvider(IAetherServiceLocator services)
	{
		if (AetherAPI.services != null)
		{
			throw new IllegalStateException("The Aether API provider is already initialized");
		}

		AetherAPI.services = services;
	}

	public static IAetherServiceLocator services()
	{
		return AetherAPI.services;
	}
}
