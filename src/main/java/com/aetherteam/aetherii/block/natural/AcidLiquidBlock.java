package com.aetherteam.aetherii.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class AcidLiquidBlock extends VolatileLiquidBlock {
    public AcidLiquidBlock(FlowingFluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        level.scheduleTick(pos, state.getFluidState().getType(), this.fluid.getTickDelay(level));
    }

    //todo item damaging; use entityInside in the block method and call the fluid code
}
