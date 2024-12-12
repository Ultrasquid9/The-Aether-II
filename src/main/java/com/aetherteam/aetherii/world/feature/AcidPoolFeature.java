package com.aetherteam.aetherii.world.feature;

import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.block.natural.GasBlock;
import com.aetherteam.aetherii.world.feature.configuration.AcidPoolConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class AcidPoolFeature extends Feature<AcidPoolConfiguration> {
    public AcidPoolFeature(Codec<AcidPoolConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<AcidPoolConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        AcidPoolConfiguration config = context.config();

        int count = random.nextInt(4) + 1;
        for (int i = 0; i < count; i++) {
            this.placePool(pos.offset(random.nextInt(3) - random.nextInt(5), 0, random.nextInt(3) - random.nextInt(5)), level, random, config);
        }

        return true;
    }

    private void placePool(BlockPos pos, WorldGenLevel level, RandomSource random, AcidPoolConfiguration config) {
        int radius = 4 + random.nextInt(3);
        for (int x = -radius; x < radius; x++) {
            for (int z = -radius; z < radius; z++) {
                for (int y = -radius; y < radius; y++) {
                    int volume = x * x + y * y + z * z;
                    int radiusSquared = (radius - 1) * (radius - 1);
                    int radiusOutlineSquared = radius * radius;
                    if (volume <= radiusOutlineSquared) {
                        BlockPos offsetPos = pos.offset(x, y, z);
                        if (y < 0) {
                            if (volume >= radiusSquared) {
                                if (!level.getBlockState(offsetPos).is(AetherIIBlocks.ACID)) {
                                    level.setBlock(offsetPos, AetherIIBlocks.ANGELIC_SHALE.get().defaultBlockState(), 3); //todo downwards hanging angelic shale with stalagmites
                                }
                            } else {
                                level.setBlock(offsetPos, AetherIIBlocks.ACID.get().defaultBlockState(), 3);
                            }
                        } else {
                            level.setBlock(offsetPos, Blocks.CAVE_AIR.defaultBlockState(), 3);
                        }
                    }
                }
                for (int y = 0; y < GasBlock.MAX_DISTANCE; y++) {
                    BlockPos offsetPos = pos.offset(x, y, z);
                    if (level.getBlockState(offsetPos).isAir()) {
                        BlockState gasState = GasBlock.updateDistance(AetherIIBlocks.GAS.get().defaultBlockState(), level, offsetPos);
                        if (gasState.getValue(GasBlock.DISTANCE) < GasBlock.MAX_DISTANCE) {
                            level.setBlock(offsetPos, GasBlock.updateDistance(gasState, level, offsetPos), 3);
                        }
                        if (!level.getBlockState(offsetPos.above()).isAir()) {
                            level.scheduleTick(offsetPos, AetherIIBlocks.GAS.get(), 1);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
