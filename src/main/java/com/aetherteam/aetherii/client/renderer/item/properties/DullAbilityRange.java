package com.aetherteam.aetherii.client.renderer.item.properties;

import com.aetherteam.aetherii.attachment.AetherIIDataAttachments;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class DullAbilityRange implements RangeSelectItemModelProperty {
    public static final MapCodec<DullAbilityRange> MAP_CODEC = MapCodec.unit(new DullAbilityRange());

    @Override
    public float get(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i) {
        return livingEntity == null ? 0.0F : livingEntity instanceof Player player && !player.getData(AetherIIDataAttachments.PLAYER).getCanRefuelAbilities().get(itemStack.getItemHolder()) ? 1.0F : 0.0F;
    }

    @Override
    public MapCodec<? extends RangeSelectItemModelProperty> type() {
        return MAP_CODEC;
    }
}
