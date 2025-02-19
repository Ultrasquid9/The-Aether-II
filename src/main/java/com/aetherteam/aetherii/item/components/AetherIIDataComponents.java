package com.aetherteam.aetherii.item.components;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.entity.passive.Moa;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class AetherIIDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, AetherII.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Moa.FeatherColor>> FEATHER_COLOR = DATA_COMPONENT_TYPES.register("feather_color", () -> DataComponentType.<Moa.FeatherColor>builder().persistent(Moa.FeatherColor.CODEC).networkSynchronized(Moa.FeatherColor.STREAM_CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<MoaEggType>> MOA_EGG_TYPE = DATA_COMPONENT_TYPES.register("moa_egg_type", () -> DataComponentType.<MoaEggType>builder().persistent(MoaEggType.CODEC).networkSynchronized(MoaEggType.STREAM_CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> HEALING_STONE_CHARGES = DATA_COMPONENT_TYPES.register("healing_stone_charges", () -> DataComponentType.<Integer>builder().persistent(ExtraCodecs.intRange(0, 5)).networkSynchronized(ByteBufCodecs.VAR_INT).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ArmorStyle>> ARMOR_STYLE = DATA_COMPONENT_TYPES.register("armor_style", () -> DataComponentType.<ArmorStyle>builder().persistent(ArmorStyle.CODEC).networkSynchronized(ArmorStyle.STREAM_CODEC).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TagKey<Item>>> ARMOR_SET = DATA_COMPONENT_TYPES.register("armor_set", () -> DataComponentType.<TagKey<Item>>builder().persistent(TagKey.codec(Registries.ITEM)).networkSynchronized(TagKey.streamCodec(Registries.ITEM)).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> CROSSBOW_SPECIAL = DATA_COMPONENT_TYPES.register("crossbow_special", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ReinforcementTier>> REINFORCEMENT_TIER = DATA_COMPONENT_TYPES.register("reinforcement_tier", () -> DataComponentType.<ReinforcementTier>builder().persistent(ReinforcementTier.CODEC).networkSynchronized(ReinforcementTier.STREAM_CODEC).cacheEncoding().build());
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<ItemStack>>> CHARMS = DATA_COMPONENT_TYPES.register("charms", () -> DataComponentType.<List<ItemStack>>builder().persistent(ItemStack.OPTIONAL_CODEC.listOf()).networkSynchronized(ItemStack.OPTIONAL_STREAM_CODEC.apply(ByteBufCodecs.list())).cacheEncoding().build());
}