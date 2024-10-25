package com.aetherteam.aetherii.block.natural;

import com.aetherteam.aetherii.block.AetherIIBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.KelpBlock;

public class LakeGrassBlock extends KelpBlock {
    public LakeGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getBodyBlock() {
        return AetherIIBlocks.LAKE_GRASS_PLANT.get();
    }
}
