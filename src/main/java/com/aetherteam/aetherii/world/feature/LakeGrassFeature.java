package com.aetherteam.aetherii.world.feature;

import com.aetherteam.aetherii.world.feature.configuration.LakeGrassConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class LakeGrassFeature extends Feature<LakeGrassConfiguration> {
    public LakeGrassFeature(Codec<LakeGrassConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<LakeGrassConfiguration> context) {
        int i = 0;
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        int height = context.config().height().sample(random);
        int depth = context.config().depth().sample(random);
        int j = level.getHeight(Heightmap.Types.OCEAN_FLOOR, pos.getX(), pos.getZ());
        BlockPos heightPos = new BlockPos(pos.getX(), j, pos.getZ());
        if (level.getBlockState(heightPos).is(Blocks.WATER) && level.getBlockState(heightPos.above(depth)).is(Blocks.WATER)) {
            BlockState endState = context.config().grassProvider().getState(random, heightPos);
            BlockState bodyState = context.config().plantProvider().getState(random, heightPos);
            for (int l = 0; l <= height; l++) {
                if (level.getBlockState(heightPos).is(Blocks.WATER) && bodyState.canSurvive(level, heightPos)) {
                    if (l == height) {
                        level.setBlock(heightPos, endState.setValue(KelpBlock.AGE, random.nextInt(4) + 20), 2);
                        i++;
                    } else {
                        level.setBlock(heightPos, bodyState, 2);
                    }
                } else if (l > 0) {
                    BlockPos belowPos = heightPos.below();
                    if (endState.canSurvive(level, belowPos) && !level.getBlockState(belowPos.below()).is(endState.getBlock())) {
                        level.setBlock(belowPos, endState.setValue(KelpBlock.AGE, random.nextInt(4) + 20), 2);
                        i++;
                    }
                    break;
                }

                heightPos = heightPos.above();
            }
        }

        return i > 0;
    }
}
