package com.aetherteam.aetherii.block.fluid;

import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.block.AetherIIFluids;
import com.aetherteam.aetherii.client.particle.AetherIIParticleTypes;
import com.aetherteam.aetherii.item.AetherIIItems;
import com.aetherteam.aetherii.mixin.mixins.client.accessor.LevelRendererAccessor;
import com.aetherteam.aetherii.network.packet.clientbound.AcidDamageBlockPacket;
import com.aetherteam.aetherii.network.packet.clientbound.AcidFizzPacket;
import com.aetherteam.aetherii.network.packet.serverbound.AcidBreakBlockPacket;
import com.aetherteam.aetherii.recipe.input.SingleRecipeInputWithRandom;
import com.aetherteam.aetherii.recipe.recipes.AetherIIRecipeTypes;
import com.aetherteam.aetherii.recipe.recipes.block.AcidCorrosionRecipe;
import com.aetherteam.aetherii.recipe.recipes.item.IrradiationCleansingRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.BlockDestructionProgress;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.network.PacketDistributor;

import javax.annotation.Nullable;
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
                        if (recipe.value().convert(level, offsetPos, newState, recipe.value().getFunction())) {
                            PacketDistributor.sendToPlayersInDimension((ServerLevel) level, new AcidFizzPacket(pos, direction.getOpposite()));
                        }
                    }
                }
            }
        }
    }

    private void destroyBelow(Level level, BlockPos pos, FluidState fluidState) {
        if (fluidState.isSource()) {
            BlockPos belowPos = pos.below();
            BlockState belowState = level.getBlockState(belowPos);
            if (!belowState.isAir() && !belowState.is(this.createLegacyBlock(fluidState).getBlock()) && !belowState.is(AetherIITags.Blocks.ACID_RESISTANT)) {
                int destroySpeed = 0;
                if (belowState.is(AetherIITags.Blocks.ACID_INSTANTLY_DESTROYS)) {
                    destroySpeed = 9;
                } else if (belowState.is(AetherIITags.Blocks.ACID_QUICKLY_DESTROYS)) {
                    destroySpeed = 3;
                } else if (belowState.is(AetherIITags.Blocks.ACID_SLOWLY_DESTROYS)) {
                    destroySpeed = 1;
                }
                if (destroySpeed != 0) {
                    PacketDistributor.sendToPlayersInDimension((ServerLevel) level, new AcidDamageBlockPacket(belowPos, destroySpeed));
                    level.scheduleTick(pos, this, this.getTickDelay(level) + 10);
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void progressivelyDestroyBlock(Level level, BlockPos belowPos, int speed) {
        int id = belowPos.hashCode();
        BlockDestructionProgress progress = ((LevelRendererAccessor) Minecraft.getInstance().levelRenderer).aether_ii$getDestroyingBlocks().get(id);
        if (progress != null) {
            int destroyProgress = progress.getProgress();
            level.destroyBlockProgress(belowPos.hashCode(), belowPos, destroyProgress + speed);
            if (destroyProgress >= 9) {
                PacketDistributor.sendToServer(new AcidBreakBlockPacket(belowPos));
            }
        } else {
            level.destroyBlockProgress(belowPos.hashCode(), belowPos,  speed);
        }
        ParticleUtils.spawnParticlesOnBlockFace(level, belowPos.above(), ParticleTypes.WHITE_SMOKE, UniformInt.of(10, 20), Direction.DOWN, () -> new Vec3(0, 0.5, 0), 0.5);
    }

    public void fullyDestroyBlock(Level level, BlockPos belowPos) {
        level.setBlock(belowPos.above(), Blocks.AIR.defaultBlockState(), 3);
        level.destroyBlock(belowPos, false);
    }

    @Override
    public void animateTick(Level level, BlockPos pos, FluidState fluidState, RandomSource random) {
        level.addParticle(AetherIIParticleTypes.ACID.get(), (double) pos.getX() + random.nextDouble(), (double) pos.getY() + random.nextDouble(), (double) pos.getZ() + random.nextDouble(), 0.0, 0.15, 0.0);
        if (random.nextInt(50) == 0) {
            BlockPos belowPos = pos.below();
            BlockState belowState = level.getBlockState(belowPos);
            if (belowState.isSolid()) {
                ParticleUtils.spawnParticlesOnBlockFace(level, belowPos.above(), ParticleTypes.WHITE_SMOKE, ConstantInt.of(1), Direction.DOWN, () -> new Vec3(0, 0.5, 0), 0.5);
            }
        }
    }

    public void entityInside(BlockState state, Level level, BlockPos blockPos, Entity entity) {
        RandomSource random = level.getRandom();
        if (entity instanceof ItemEntity itemEntity) {
            ItemStack itemStack = itemEntity.getItem().copy();
            if (!itemStack.is(AetherIITags.Items.ACID_RESISTANT_ITEM)) {
                itemEntity.lifespan -= 15;
                if (entity.level().isClientSide()) {
                    for (int i = 0; i < 2; ++i) {
                        double d0 = random.nextGaussian() * 0.02;
                        double d1 = random.nextGaussian() * 0.02;
                        double d2 = random.nextGaussian() * 0.02;
                        level.addParticle(ParticleTypes.WHITE_SMOKE, itemEntity.getX(), (itemEntity.getY() + itemEntity.getBoundingBox().getYsize()), itemEntity.getZ(), d0, d1, d2);
                    }
                }
                if (itemEntity.lifespan <= 500) {
                    for (RecipeHolder<IrradiationCleansingRecipe> recipe : level.getRecipeManager().getAllRecipesFor(AetherIIRecipeTypes.IRRADIATION_CLEANSING.get())) {
                        if (recipe != null) {
                            SingleRecipeInputWithRandom input = new SingleRecipeInputWithRandom(itemStack, level.getRandom());
                            if (recipe.value().matches(input, level)) {
                                itemEntity.discard();
                                ItemStack result = recipe.value().assemble(input, level.registryAccess());
                                result.setDamageValue((result.getMaxDamage() / 3) + (random.nextInt(8) * (random.nextBoolean() ? 1 : -1)));
                                ItemEntity cleansedItemEntity = new ItemEntity(level, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), result);
                                level.addFreshEntity(cleansedItemEntity);
                            }
                        }
                    }
                }
            }
        } else if (entity instanceof LivingEntity livingEntity) {
            if (entity.tickCount % 50 == 0) {
                for (ItemStack stack : livingEntity.getAllSlots()) {
                    if (!stack.is(AetherIITags.Items.ACID_RESISTANT_ITEM)) {
                        if (!livingEntity.level().isClientSide()) {
                            EquipmentSlot slot = livingEntity.getEquipmentSlotForItem(stack);
                            stack.hurtAndBreak(1, livingEntity, slot);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean canBeReplacedWith(FluidState fluidState, BlockGetter level, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.is(AetherIITags.Fluids.ACID) && !fluid.is(FluidTags.WATER); //todo water interaction
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
