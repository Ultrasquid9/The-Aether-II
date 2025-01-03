package com.aetherteam.aetherii.client.renderer.item.properties;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ParachutingRange implements RangeSelectItemModelProperty {
    public static final MapCodec<ParachutingRange> MAP_CODEC = MapCodec.unit(new ParachutingRange());

    @Override
    public float get(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i) {
        return livingEntity == null ? 0.0F : ItemStack.isSameItem(itemStack, livingEntity.getUseItem()) && livingEntity.getUseItemRemainingTicks() > 0 ? 1.0F : 0.0F;
    }

    @Override
    public MapCodec<? extends RangeSelectItemModelProperty> type() {
        return MAP_CODEC;
    }
}
