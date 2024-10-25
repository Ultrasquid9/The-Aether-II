package com.aetherteam.aetherii.block.natural;

import com.aetherteam.aetherii.block.AetherIIBlocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.KelpPlantBlock;

public class GlowingLakeGrassPlantBlock extends KelpPlantBlock {
    public GlowingLakeGrassPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) AetherIIBlocks.GLOWING_LAKE_GRASS.get();
    }
}
