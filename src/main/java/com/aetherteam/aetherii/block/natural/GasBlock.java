package com.aetherteam.aetherii.block.natural;

import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.item.AetherIIItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GasBlock extends Block implements LiquidBlockContainer, CanisterPickup {
    public GasBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        if (level.getBlockState(neighborPos).is(AetherIITags.Blocks.TRIGGERS_GAS)) {
            level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 1.0F, Level.ExplosionInteraction.BLOCK);
            level.destroyBlock(pos, false);
        }
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
    }

    @Override
    public void wasExploded(Level level, BlockPos pos, Explosion explosion) {
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 1.0F, Level.ExplosionInteraction.BLOCK);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return (context.isHoldingItem(AetherIIItems.ARKENIUM_CANISTER.get()) || context.isHoldingItem(AetherIIItems.ARKENIUM_GAS_CANISTER.get())) ? Shapes.block() : Shapes.empty();
    }

    @Override
    protected VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return Shapes.empty();
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 1.0F;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    @Override
    public boolean canPlaceLiquid(@Nullable Player player, BlockGetter level, BlockPos pos, BlockState state, Fluid fluid) {
        return level.getBlockState(pos.above()).is(fluid.defaultFluidState().createLegacyBlock().getBlock());
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
        return false;
    }

    @Override
    public ItemStack pickupBlockWithCanister(@Nullable Player player, LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
        levelAccessor.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 11);
        if (!levelAccessor.isClientSide()) {
            levelAccessor.levelEvent(2001, blockPos, Block.getId(blockState));
        }
        return new ItemStack(AetherIIItems.ARKENIUM_GAS_CANISTER.get());
    }

    @Override
    public Optional<SoundEvent> getCanisterPickupSound(BlockState state) { //todo
        return Optional.empty();
    }
}
