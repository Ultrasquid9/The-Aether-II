package com.aetherteam.aetherii;

import com.aetherteam.aetherii.attachment.AetherIIDataAttachments;
import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.client.event.hooks.BiomeHooks;
import com.aetherteam.aetherii.data.resources.registries.AetherIIDamageTypes;
import com.aetherteam.aetherii.event.FreezeEvent;
import com.aetherteam.aetherii.event.hooks.BlockHooks;
import com.aetherteam.aetherii.event.hooks.PlayerHooks;
import com.aetherteam.aetherii.item.components.AetherIIDataComponents;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.portal.TeleportTransition;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.EntityMountEvent;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.*;
import net.neoforged.neoforge.event.level.AlterGroundEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.level.SleepFinishedTimeEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.Map;
import java.util.Optional;

public class AetherIIEventListeners {
    public static void listen(IEventBus bus) {
        // Player
        bus.addListener(AetherIIEventListeners::onPlayerLogin);
        bus.addListener(AetherIIEventListeners::onPlayerLogout);
        bus.addListener(AetherIIEventListeners::onPlayerRespawn);
        bus.addListener(AetherIIEventListeners::onPlayerPositionRespawn);
        bus.addListener(AetherIIEventListeners::onPlayerClone);
        bus.addListener(AetherIIEventListeners::onPlayerPostTick);
        bus.addListener(AetherIIEventListeners::onPlayerRightClickBlock);
        bus.addListener(AetherIIEventListeners::onPlayerEntityInteractSpecific);
        bus.addListener(AetherIIEventListeners::onPlayerCriticalHitAttack);
        bus.addListener(AetherIIEventListeners::onPlayerAdvancementProgression);
        bus.addListener(AetherIIEventListeners::onPlayersFinishSleeping);
        bus.addListener(AetherIIEventListeners::onArmorDamaged);
        bus.addListener(AetherIIEventListeners::onPlayerMount);

        // Entity
        bus.addListener(AetherIIEventListeners::onEntityPostTick);

        // Living
        bus.addListener(AetherIIEventListeners::onLivingPreDamaged);
        bus.addListener(AetherIIEventListeners::onLivingBlockAttack);
        bus.addListener(AetherIIEventListeners::onLivingItemUsed);
        bus.addListener(AetherIIEventListeners::onEffectRemove);

        // Block
        bus.addListener(AetherIIEventListeners::onBlockUpdateNeighbor);
        bus.addListener(AetherIIEventListeners::onModifyBlock);
        bus.addListener(AetherIIEventListeners::onAlterGround);
        bus.addListener(AetherIIEventListeners::onBlockFreeze);
        bus.addListener(AetherIIEventListeners::onBreatheInBlock);
    }

    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();

        player.getData(AetherIIDataAttachments.PLAYER).login(player);
        player.getData(AetherIIDataAttachments.CURRENCY).login(player); //todo verify
        player.getData(AetherIIDataAttachments.GUIDEBOOK_DISCOVERY).login(player);
        player.getData(AetherIIDataAttachments.OUTPOST_TRACKER).login(player); //todo verify
        BiomeHooks.sendColors(player);
    }

    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        Player player = event.getEntity();

        player.getData(AetherIIDataAttachments.PLAYER).logout(player);
    }

    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();

        player.getData(AetherIIDataAttachments.OUTPOST_TRACKER).respawn(player);
    }

    public static void onPlayerPositionRespawn(PlayerRespawnPositionEvent event) {
        Player player = event.getEntity();
        TeleportTransition transition;

        transition = player.getData(AetherIIDataAttachments.OUTPOST_TRACKER).findOutpostRespawnLocation(player);

        if (transition != null) {
            event.setTeleportTransition(transition);
        }
    }

    public static void onPlayerClone(PlayerEvent.Clone event) {
        Player player = event.getEntity();

        player.getData(AetherIIDataAttachments.GUIDEBOOK_DISCOVERY).clone(player);
    }

    public static void onPlayerPostTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        player.getData(AetherIIDataAttachments.PLAYER).postTickUpdate(player);
        player.getData(AetherIIDataAttachments.CURRENCY).postTickUpdate(player);
        player.getData(AetherIIDataAttachments.GUIDEBOOK_DISCOVERY).postTickUpdate(player);
        player.getData(AetherIIDataAttachments.OUTPOST_TRACKER).postTickUpdate(player);
        player.getData(AetherIIDataAttachments.SWET).postTickUpdate(player);
    }

    public static void onPlayerRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        InteractionHand hand = event.getHand();
        ItemStack itemStack = event.getItemStack();
        BlockPos pos = event.getPos();
        Direction face = event.getFace();
        boolean cancelled = false;

        cancelled = PlayerHooks.playerActivatePortal(player, level, pos, face, itemStack, hand, cancelled);
        cancelled = PlayerHooks.snowlogBlock(player, level, pos, itemStack, hand, cancelled);
        cancelled = PlayerHooks.ferrositeMudBottleConversion(player, level, pos, itemStack, hand, face, cancelled);

        if (cancelled) {
            event.setCanceled(true);
        }
    }

    public static void onPlayerEntityInteractSpecific(PlayerInteractEvent.EntityInteractSpecific event) {
        Player player = event.getEntity();
        InteractionHand interactionHand = event.getHand();
        Entity targetEntity = event.getTarget();
        Optional<InteractionResult> result = Optional.empty();

        PlayerHooks.milkWithSkyrootBucket(targetEntity, player, interactionHand);

        result = PlayerHooks.pickupBucketableTarget(targetEntity, player, interactionHand, result);

        if (result.isPresent()) {
            event.setCancellationResult(result.get());
            event.setCanceled(true);
        }
    }

    public static void onPlayerCriticalHitAttack(CriticalHitEvent event) {
        Player player = event.getEntity();
        float modifier = event.getDamageMultiplier();

        player.getData(AetherIIDataAttachments.DAMAGE_SYSTEM.get()).setCriticalDamageModifier(modifier);
    }

    public static void onPlayerAdvancementProgression(AdvancementEvent.AdvancementProgressEvent event) {
        Player player = event.getEntity();
        AdvancementHolder advancementHolder = event.getAdvancement();

        player.getData(AetherIIDataAttachments.GUIDEBOOK_DISCOVERY).progressAdvancement(player, advancementHolder);
    }

    public static void onPlayersFinishSleeping(SleepFinishedTimeEvent event) {
        LevelAccessor level = event.getLevel();
        long newTime = event.getNewTime();

        PlayerHooks.resetAetherDayAndWeather(level, newTime);
    }

    public static void onArmorDamaged(ArmorHurtEvent event) {
        LivingEntity livingEntity = event.getEntity();
        Map<EquipmentSlot, ArmorHurtEvent.ArmorEntry> armorEntries = event.getArmorMap();

        if (livingEntity.getLastDamageSource() != null && livingEntity.getLastDamageSource().is(AetherIIDamageTypes.ACID)) {
            for (Map.Entry<EquipmentSlot, ArmorHurtEvent.ArmorEntry> entry : armorEntries.entrySet()) {
                ArmorHurtEvent.ArmorEntry armor = entry.getValue();
                if (armor.armorItemStack.has(AetherIIDataComponents.REINFORCEMENT_TIER)) {
                    event.setNewDamage(entry.getKey(), 0.0F);
                }
            }
        }
    }

    public static void onPlayerMount(EntityMountEvent event) {
        Entity riderEntity = event.getEntityMounting();
        Entity mountEntity = event.getEntityBeingMounted();
        boolean isDismounting = event.isDismounting();
        event.setCanceled(PlayerHooks.dismountPrevention(riderEntity, mountEntity, isDismounting));
    }

    public static void onEntityPostTick(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.getData(AetherIIDataAttachments.DAMAGE_SYSTEM).postTickUpdate(livingEntity);
            livingEntity.getData(AetherIIDataAttachments.EFFECTS_SYSTEM).postTickUpdate(livingEntity);
        }
    }

    public static void onLivingPreDamaged(LivingDamageEvent.Pre event) {
        LivingEntity target = event.getEntity();
        DamageSource source = event.getContainer().getSource();
        float damage = event.getContainer().getNewDamage();

        damage = target.getData(AetherIIDataAttachments.DAMAGE_SYSTEM).getDamageTypeModifiedValue(target, source, damage);

        event.getContainer().setNewDamage(damage);
    }

    public static void onLivingBlockAttack(LivingShieldBlockEvent event) {
        LivingEntity livingEntity = event.getEntity();
        DamageSource source = event.getDamageSource();

        livingEntity.getData(AetherIIDataAttachments.DAMAGE_SYSTEM).buildUpShieldStun(livingEntity, source);
    }

    public static void onLivingItemUsed(LivingEntityUseItemEvent event) {
        if (event.getEntity() instanceof Player player) {
            PlayerHooks.valkyrieTeaAbility(player);
        }
    }

    public static void onBlockUpdateNeighbor(BlockEvent.NeighborNotifyEvent event) {
        LevelAccessor levelAccessor = event.getLevel();
        BlockPos blockPos = event.getPos();
        boolean cancelled = false;

        BlockHooks.sendIcestoneFreezableUpdateEvent(levelAccessor, blockPos);

        cancelled = BlockHooks.activatePortalFromBlockUpdate(levelAccessor, blockPos, cancelled);

        if (cancelled) {
            event.setCanceled(true);
        }
    }

    public static void onModifyBlock(BlockEvent.BlockToolModificationEvent event) {
        LevelAccessor levelAccessor = event.getLevel();
        UseOnContext context = event.getContext();
        ItemAbility toolAction = event.getItemAbility();
        ItemStack itemStack = event.getHeldItemStack();
        BlockPos blockPos = event.getPos();
        BlockState oldState = event.getState();
        BlockState newState = oldState;

        if (!event.isSimulated() && !event.isCanceled()) {
            BlockHooks.stripMossyWisproot(levelAccessor, oldState, itemStack, toolAction, context);
            BlockHooks.stripAmberoot(levelAccessor, oldState, itemStack, toolAction, context);

            newState = AetherIIBlocks.registerBlockModifications(levelAccessor, toolAction, blockPos, oldState, newState);

            if (newState != oldState) {
                event.setFinalState(newState);
            }
        }
    }

    public static void onAlterGround(AlterGroundEvent event) {
        TreeDecorator.Context context = event.getContext();
        AlterGroundEvent.StateProvider provider = event.getStateProvider();

        event.setStateProvider(BlockHooks.modifyPodzolAlterGroundStateProvider(context, provider));
    }

    public static void onBlockFreeze(FreezeEvent.FreezeFromBlock event) {
        LevelAccessor level = event.getLevel();
        BlockPos sourcePos = event.getSourcePos();
        BlockPos pos = event.getPos();
        boolean cancelled = false;

        cancelled = BlockHooks.preventBlockFreezing(level, sourcePos, pos, cancelled);

        if (cancelled) {
            event.setCanceled(true);
        }
    }

    public static void onBreatheInBlock(LivingBreatheEvent event) {
        LivingEntity entity = event.getEntity();
        if (!BlockHooks.canBreathe(entity)) {
            event.setCanBreathe(false);
        }
    }

    public static void onEffectRemove(MobEffectEvent.Remove event) {
        LivingEntity livingEntity = event.getEntity();
        Holder<MobEffect> effect = event.getEffect();
        if (effect.is(AetherIITags.MobEffects.MILK_DOESNT_CLEAR) && livingEntity.getUseItem().is(Tags.Items.BUCKETS_MILK)) {
            event.setCanceled(true);
        }
    }
}
