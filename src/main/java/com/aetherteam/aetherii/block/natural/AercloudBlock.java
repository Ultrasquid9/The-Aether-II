package com.aetherteam.aetherii.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class AercloudBlock extends HalfTransparentBlock implements LiquidBlockContainer {
    protected static final VoxelShape COLLISION_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 0.01, 16.0);
    protected static final VoxelShape FALLING_COLLISION_SHAPE = Shapes.box(0.0, 0.0, 0.0, 1.0, 0.9, 1.0);

    public AercloudBlock(Properties properties) {
        super(properties);
    }

    /**
     * Slows an entity's movement and resets their fall damage when inside an Aercloud block.<br><br>
     * Warning for "deprecation" is suppressed because the method is fine to override.
     *
     * @param state  The {@link BlockState} of the block.
     * @param level  The {@link Level} the block is in.
     * @param pos    The {@link BlockPos} of the block.
     * @param entity The {@link Entity} in the block.
     */
    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        entity.resetFallDistance();
        if (entity.getDeltaMovement().y < -0.0784000015258789 && !(entity instanceof Projectile)) {
            entity.makeStuckInBlock(state, new Vec3(1.0, 0.25, 1.0));
        } else {
            entity.setOnGround(entity instanceof LivingEntity livingEntity && (!(livingEntity instanceof Player player) || !player.getAbilities().flying));
        }
    }

    /**
     * This block does not cause fall damage, so this method is overridden from {@link Block#fallOn(Level, BlockState, BlockPos, Entity, float)} to be empty.
     *
     * @param level        The {@link Level} the block is in.
     * @param state        The {@link BlockState} of the block.
     * @param pos          The {@link BlockPos} of the block.
     * @param entity       The {@link Entity} that fell on the block.
     * @param fallDistance The fall distance of the entity as a {@link Float}.
     */
    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
    }

    /**
     * [CODE COPY] - {@link net.minecraft.world.level.block.AbstractGlassBlock#propagatesSkylightDown(BlockState, BlockGetter, BlockPos)}.
     */
    @Override
    public boolean propagatesSkylightDown(BlockState state) {
        return false;
    }

    /**
     * [CODE COPY] - {@link net.minecraft.world.level.block.AbstractGlassBlock#getShadeBrightness(BlockState, BlockGetter, BlockPos)}.<br><br>
     * Warning for "deprecation" is suppressed because the method is fine to override.
     */
    @SuppressWarnings("deprecation")
    @Override
    public float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 0.25F;
    }

    /**
     * [CODE COPY] - {@link net.minecraft.world.level.block.PowderSnowBlock#getCollisionShape(BlockState, BlockGetter, BlockPos, CollisionContext)}.<br><br>
     * Resolves a quirk with fall behavior where an entity will still receive fall damage if falling fast enough into a block with a shape like {@link AercloudBlock#COLLISION_SHAPE},
     * even if the fall damage should be negated.<br><br>
     * Warning for "deprecation" is suppressed because the method is fine to override.
     *
     * @param state   The {@link BlockState} of the block.
     * @param level   The {@link Level} the block is in.
     * @param pos     The {@link BlockPos} of the block.
     * @param context The {@link CollisionContext} of the entity with the block.
     * @return The collision {@link VoxelShape} of the block.
     */
    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (!this.getDefaultCollisionShape(state, level, pos, context).isEmpty() && level.getBlockState(pos.above()).getBlock() instanceof AercloudBlock) {
            return Shapes.block();
        }
        if (context instanceof EntityCollisionContext entityCollisionContext) {
            Entity entity = entityCollisionContext.getEntity();
            if (entity != null) {
                if (entity.fallDistance > 2.5F && (!(entity instanceof LivingEntity livingEntity) || !livingEntity.isFallFlying())) {
                    return FALLING_COLLISION_SHAPE; // Alternate shape when falling fast enough.
                }
            }
        }
        return this.getDefaultCollisionShape(state, level, pos, context); // Default shape.
    }

    protected VoxelShape getDefaultCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return COLLISION_SHAPE;
    }

    /**
     * [CODE COPY] - {@link net.minecraft.world.level.block.AbstractGlassBlock#getVisualShape(BlockState, BlockGetter, BlockPos, CollisionContext)}.<br><br>
     * Warning for "deprecation" is suppressed because the method is fine to override.
     */
    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public boolean canPlaceLiquid(@Nullable Player player, BlockGetter level, BlockPos pos, BlockState state, Fluid fluid) {
        return level.getBlockState(pos.above()).is(fluid.defaultFluidState().createLegacyBlock().getBlock());
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
        return false;
    }
}
