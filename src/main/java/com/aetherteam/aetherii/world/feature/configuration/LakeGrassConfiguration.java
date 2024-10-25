package com.aetherteam.aetherii.world.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record LakeGrassConfiguration(BlockStateProvider grassProvider, BlockStateProvider plantProvider, IntProvider height, IntProvider depth) implements FeatureConfiguration {
    public static final Codec<LakeGrassConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            BlockStateProvider.CODEC.fieldOf("grass_provider").forGetter(LakeGrassConfiguration::grassProvider),
            BlockStateProvider.CODEC.fieldOf("plant_provider").forGetter(LakeGrassConfiguration::plantProvider),
            IntProvider.CODEC.fieldOf("height").forGetter(LakeGrassConfiguration::height),
            IntProvider.CODEC.fieldOf("depth").forGetter(LakeGrassConfiguration::depth)
    ).apply(instance, LakeGrassConfiguration::new));
}
