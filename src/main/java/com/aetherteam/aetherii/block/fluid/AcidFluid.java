package com.aetherteam.aetherii.block.fluid;

import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.block.AetherIIFluids;
import com.aetherteam.aetherii.client.particle.AetherIIParticleTypes;
import com.aetherteam.aetherii.item.AetherIIItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.*;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import javax.annotation.Nullable;
import java.util.Optional;

public abstract class AcidFluid extends BaseFlowingFluid implements CanisterFluid {
    public AcidFluid(Properties properties) {
        super(properties);
    }

    @Override
    public void tick(Level level, BlockPos pos, FluidState state) { //todo scheduled ticks from placement or neighbor interactions of block?
        Direction randomDirection = Direction.getRandom(level.getRandom());
        BlockPos offsetPos = pos.offset(randomDirection.getNormal());
        BlockState offsetState = level.getBlockState(offsetPos);
        if (offsetState.is(AetherIIBlocks.UNDERSHALE)) { //todo recipe system
            level.setBlock(offsetPos, AetherIIBlocks.ANGELIC_SHALE.get().defaultBlockState(), 3); //todo fizz particle
        }
        super.tick(level, pos, state);
    }

    @Override
    protected void randomTick(Level level, BlockPos pos, FluidState fluidState, RandomSource random) {
        BlockState blockState = level.getBlockState(pos);
        if (fluidState.isSource() || (fluidState.getType() instanceof Flowing flowing && flowing.getAmount(fluidState) == 8)) {  //todo better ticking
            BlockPos belowPos = pos.below();
            BlockState belowState = level.getBlockState(belowPos);
            if (belowState.isAir() || belowState.is(this.createLegacyBlock(fluidState).getBlock())) {
                if (fluidState.isSource()) {
                    level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                    level.setBlock(belowPos, blockState, 3);
                }
            } else {
                if (!belowState.is(AetherIITags.Blocks.ACID_RESISTANT_BLOCK)) { //todo probably only need one of these in the end
                    if (belowState.is(AetherIITags.Blocks.ACID_DESTROYS_BLOCK)) {
                        level.destroyBlock(belowPos, true);
                        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                    }
                }
            }
        }
        //todo item damaging
        super.randomTick(level, pos, fluidState, random);
    }

    @Override
    public void animateTick(Level level, BlockPos pos, FluidState fluidState, RandomSource random) {
        level.addParticle(AetherIIParticleTypes.ACID.get(), (double) pos.getX() + random.nextDouble(), (double) pos.getY() + random.nextDouble(), (double) pos.getZ() + random.nextDouble(), 0.0, 0.15, 0.0);
    }

    @Override
    public boolean canBeReplacedWith(FluidState fluidState, BlockGetter level, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.is(FluidTags.WATER); //todo
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor level, BlockPos pos, BlockState state) {
        BlockEntity blockentity = state.hasBlockEntity() ? level.getBlockEntity(pos) : null;
        Block.dropResources(state, level, pos, blockentity);
    }

    @Override
    public BlockState createLegacyBlock(FluidState fluidState) {
        return AetherIIBlocks.ACID.get().defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(fluidState));
    }

    @Override
    public boolean isSame(Fluid fluid) {
        return fluid == AetherIIFluids.ACID.get() || fluid == AetherIIFluids.FLOWING_ACID.get();
    }

    @Override
    public Fluid getFlowing() {
        return AetherIIFluids.FLOWING_ACID.get();
    }

    @Override
    public Fluid getSource() {
        return AetherIIFluids.ACID.get();
    }

    @Override
    public Item getBucket() {
        return ItemStack.EMPTY.getItem();
    }

    @Override
    public Item getCanister() {
        return AetherIIItems.ARKENIUM_ACID_CANISTER.get();
    }

    @Nullable
    @Override
    public ParticleOptions getDripParticle() {
        return ParticleTypes.DRIPPING_WATER;
    } //todo

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL);
    } //todo

    @Override
    protected boolean canConvertToSource(Level level) {
        return false;
    }

    @Override
    public int getSlopeFindDistance(LevelReader level) {
        return 4;
    }

    @Override
    public int getDropOff(LevelReader level) {
        return 3;
    }

    @Override
    public int getTickDelay(LevelReader level) {
        return 5;
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    @Override
    protected boolean isRandomlyTicking() {
        return true;
    }

    public static class Source extends AcidFluid {
        public Source(Properties properties) {
            super(properties);
        }

        public int getAmount(FluidState fluidState) {
            return 8;
        }

        public boolean isSource(FluidState fluidState) {
            return true;
        }
    }

    public static class Flowing extends AcidFluid {
        public Flowing(Properties properties) {
            super(properties);
        }

        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState fluidState) {
            return fluidState.getValue(LEVEL);
        }

        public boolean isSource(FluidState fluidState) {
            return false;
        }
    }
}
