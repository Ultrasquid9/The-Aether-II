package com.aetherteam.aetherii.item;

import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;

public class AetherIIConsumables {
    public static Consumable FAST = Consumables.defaultFood().consumeSeconds(0.8F).build();
}
