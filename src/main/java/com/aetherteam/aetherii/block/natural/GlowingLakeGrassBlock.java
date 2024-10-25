package com.aetherteam.aetherii.block.natural;

import com.aetherteam.aetherii.block.AetherIIBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.KelpBlock;

public class GlowingLakeGrassBlock extends KelpBlock {
    public GlowingLakeGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getBodyBlock() {
        return AetherIIBlocks.GLOWING_LAKE_GRASS_PLANT.get();
    }
}
