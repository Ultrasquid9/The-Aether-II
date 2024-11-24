package com.aetherteam.aetherii.block.fluid;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.block.AetherIIFluids;
import com.aetherteam.aetherii.client.particle.AetherIIParticleTypes;
import com.aetherteam.aetherii.item.AetherIIItems;
import com.aetherteam.aetherii.recipe.recipes.AetherIIRecipeTypes;
import com.aetherteam.aetherii.recipe.recipes.block.AcidCorrosionRecipe;
import com.aetherteam.aetherii.recipe.recipes.block.IcestoneFreezableRecipe;
import com.aetherteam.nitrogen.recipe.BlockPropertyPair;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.*;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Optional;

public abstract class AcidFluid extends BaseFlowingFluid implements CanisterFluid {
    public AcidFluid(Properties properties) {
        super(properties);
    }

    @Override
    public void tick(Level level, BlockPos pos, FluidState fluidState) {
        super.tick(level, pos, fluidState);
        this.applyGravity(level, pos, fluidState);
        this.corrodeNeighbors(level, pos);
        this.destroyBelow(level, pos, fluidState);
    }

    private void applyGravity(Level level, BlockPos pos, FluidState fluidState) {
        BlockState blockState = level.getBlockState(pos);
        if (fluidState.isSource()) {
            BlockPos belowPos = pos.below();
            BlockState belowState = level.getBlockState(belowPos);
            FluidState belowFluid = level.getFluidState(belowPos);
            if (belowState.isAir() || (belowState.is(this.createLegacyBlock(fluidState).getBlock()) && !belowFluid.isSource())) {
                level.setBlock(belowPos, blockState, 3);
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            }
        }
    }

    private void corrodeNeighbors(Level level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            BlockPos offsetPos = pos.offset(direction.getNormal());
            BlockState offsetState = level.getBlockState(offsetPos);
            for (RecipeHolder<AcidCorrosionRecipe> recipe : level.getRecipeManager().getAllRecipesFor(AetherIIRecipeTypes.ACID_CORROSION.get())) {
                if (recipe != null) {
                    BlockState newState = recipe.value().getResultState(offsetState);
                    if (recipe.value().matches(null, level, offsetPos, null, offsetState, newState, AetherIIRecipeTypes.ACID_CORROSION.get())) {
                        if (!level.isClientSide()) {
                            recipe.value().convert(level, offsetPos, newState, recipe.value().getFunction());  //todo fizz particle packet
                        }
                    }
                }
            }
        }
    }

    private void destroyBelow(Level level, BlockPos pos, FluidState fluidState) {
        if (fluidState.isSource()) {   //todo better ticking
            BlockPos belowPos = pos.below();
            BlockState belowState = level.getBlockState(belowPos);
            if (!belowState.isAir() && !belowState.is(this.createLegacyBlock(fluidState).getBlock())) {
                int destroySpeed = 0;
                if (belowState.is(AetherIITags.Blocks.ACID_INSTANTLY_DESTROYS)) {
                    destroySpeed = 10;
                } else if (belowState.is(AetherIITags.Blocks.ACID_QUICKLY_DESTROYS)) {
                    destroySpeed = 5;
                } else if (belowState.is(AetherIITags.Blocks.ACID_SLOWLY_DESTROYS)) {
                    destroySpeed = 1;
                }
                if (destroySpeed != 0) {
                    AetherII.LOGGER.info("1");
                    level.destroyBlockProgress(belowPos.hashCode(), belowPos, destroySpeed);
                    level.scheduleTick(pos, this, this.getTickDelay(level));
                }
            }
        }
    }

    @Override
    protected void randomTick(Level level, BlockPos pos, FluidState fluidState, RandomSource random) {
        //todo item damaging; use entityInside in the block method and call the fluid code
        super.randomTick(level, pos, fluidState, random);
    }

    @Override
    public void animateTick(Level level, BlockPos pos, FluidState fluidState, RandomSource random) { //todo occasional lava-like fizzing
        level.addParticle(AetherIIParticleTypes.ACID.get(), (double) pos.getX() + random.nextDouble(), (double) pos.getY() + random.nextDouble(), (double) pos.getZ() + random.nextDouble(), 0.0, 0.15, 0.0);
    }

    @Override
    public boolean canBeReplacedWith(FluidState fluidState, BlockGetter level, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.is(AetherIITags.Fluids.ACID) && !fluid.is(FluidTags.WATER);
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
        return 3;
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
