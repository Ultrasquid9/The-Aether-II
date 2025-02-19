package com.aetherteam.aetherii.block.construction;

import com.aetherteam.aetherii.AetherIITags;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ScatterglassBlock extends TransparentBlock {
    public ScatterglassBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.is(AetherIITags.Blocks.SCATTERGLASS) || super.skipRendering(state, adjacentBlockState, side);
    }
}
