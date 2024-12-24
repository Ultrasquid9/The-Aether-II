package com.aetherteam.aetherii.data.providers;

import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.stream.Stream;

public class AetherIIBlockModelProvider extends ModelProvider {
    public AetherIIBlockModelProvider(PackOutput output, String modId) {
        super(output, modId);
    }

    @Override
    public final Stream<? extends Holder<Item>> getKnownItems() {
        return super.getKnownItems().filter(item -> item instanceof BlockItem);
    }

    @Override
    public String getName() {
        return this.modId + " Block Models";
    }
}
