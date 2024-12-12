package com.aetherteam.aetherii.world.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record AcidPoolConfiguration(int value) implements FeatureConfiguration {
    public static final Codec<AcidPoolConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            Codec.INT.fieldOf("value").forGetter(AcidPoolConfiguration::value)
    ).apply(instance, AcidPoolConfiguration::new));
}
