package com.aetherteam.aetherii.entity.projectile;

import com.aetherteam.aetherii.attachment.AetherIIDataAttachments;
import com.aetherteam.aetherii.client.particle.AetherIIParticleTypes;
import com.aetherteam.aetherii.effect.buildup.EffectBuildupPresets;
import com.aetherteam.aetherii.entity.AetherIIEntityTypes;
import com.aetherteam.aetherii.mixin.mixins.common.accessor.PlayerAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

public class ZephyrWebbingBall extends Fireball implements ItemSupplier {
    private int ticksInAir;

    public ZephyrWebbingBall(EntityType<? extends ZephyrWebbingBall> type, Level level) {
        super(type, level);
        this.setNoGravity(true);
    }

    public ZephyrWebbingBall(Level level, LivingEntity shooter, double accelX, double accelY, double accelZ) {
        super(AetherIIEntityTypes.ZEPHYR_WEBBING_BALL.get(), shooter, new Vec3(accelX, accelY, accelZ), level);
        this.setNoGravity(true);
    }

    /**
     * [CODE COPY] - {@link AbstractHurtingProjectile#tick()}.<br><br>
     * Remove code for setting the projectile on fire.
     * Warning for "deprecation" is suppressed because vanilla calls {@link Level#hasChunkAt(BlockPos)} just fine.
     */
    @SuppressWarnings("deprecation")
    @Override
    public void tick() {
        if (!this.onGround()) {
            ++this.ticksInAir;
        }
        if (this.ticksInAir > 400) {
            if (!this.level().isClientSide()) {
                this.discard();
            }
        }
        if (this.level().isClientSide() || (this.getOwner() == null || this.getOwner().isAlive()) && this.level().hasChunkAt(this.blockPosition())) {
            HitResult hitResult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
            if (hitResult.getType() != HitResult.Type.MISS && !EventHooks.onProjectileImpact(this, hitResult)) {
                this.onHit(hitResult);
            }

            this.applyEffectsFromBlocks();
            Vec3 vec3 = this.getDeltaMovement();
            double d0 = this.getX() + vec3.x();
            double d1 = this.getY() + vec3.y();
            double d2 = this.getZ() + vec3.z();
            ProjectileUtil.rotateTowardsMovement(this, 0.2F);
            float f = this.getInertia();
            if (this.isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    this.level().addParticle(ParticleTypes.BUBBLE, d0 - vec3.x() * 0.25, d1 - vec3.y() * 0.25, d2 - vec3.z() * 0.25, vec3.x(), vec3.y(), vec3.z());
                }
                f = 0.8F;
            }

            this.setDeltaMovement(vec3.add(vec3.normalize().scale(this.accelerationPower)).scale(f));
            this.level().addParticle(this.getTrailParticle(), d0, d1 + 0.5, d2, 0.0, 0.0, 0.0);
            this.setPos(d0, d1, d2);
        } else {
            this.discard();
        }
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide()) {
            this.discard();
        }
    }

    /**
     * Handles shield damaging and knockback when this projectile hits an entity.
     *
     * @param result The {@link EntityHitResult} of the projectile.
     */
    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        if (entity instanceof LivingEntity livingEntity) {
            if (livingEntity.isBlocking()) {
                if (entity instanceof Player player && player.isBlocking()) {
                    PlayerAccessor playerAccessor = (PlayerAccessor) player;
                    playerAccessor.callHurtCurrentlyUsedShield(3.0F);
                }
            } else {
                livingEntity.getData(AetherIIDataAttachments.EFFECTS_SYSTEM).addBuildup(EffectBuildupPresets.WEBBED, 350);
            }
        }
    }

    /**
     * Prevents this projectile from being on fire.
     */
    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    protected ParticleOptions getTrailParticle() {
        return AetherIIParticleTypes.ZEPHYR_SNOWFLAKE.get();
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(Items.SNOWBALL);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("TicksInAir", this.ticksInAir);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("TicksInAir")) {
            this.ticksInAir = tag.getInt("TicksInAir");
        }
    }
}