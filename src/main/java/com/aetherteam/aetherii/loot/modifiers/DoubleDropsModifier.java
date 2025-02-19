package com.aetherteam.aetherii.loot.modifiers;

import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.item.equipment.EquipmentUtil;
import com.aetherteam.aetherii.item.equipment.tools.abilities.SkyrootTool;
import com.aetherteam.aetherii.item.equipment.weapons.abilities.SkyrootWeapon;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.Set;
import java.util.stream.Collectors;

public class DoubleDropsModifier extends LootModifier {
    public static final MapCodec<DoubleDropsModifier> CODEC = RecordCodecBuilder.mapCodec((instance) -> LootModifier.codecStart(instance).apply(instance, DoubleDropsModifier::new));

    public DoubleDropsModifier(LootItemCondition[] conditions) {
        super(conditions);
    }

    @Override
    public ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> lootStacks, LootContext context) {
        ObjectArrayList<ItemStack> newStacks = new ObjectArrayList<>(lootStacks);

        // Tools
        BlockState targetState = context.getOptionalParameter(LootContextParams.BLOCK_STATE);
        Vec3 targetPos = context.getOptionalParameter(LootContextParams.ORIGIN);
        ItemStack tool = context.getOptionalParameter(LootContextParams.TOOL);

        // Weapons
        Entity targetEntity = context.getOptionalParameter(LootContextParams.THIS_ENTITY);
        Entity attacker = context.getOptionalParameter(LootContextParams.DIRECT_ATTACKING_ENTITY);

        if (targetState != null && targetPos != null) {
            if (tool != null && tool.getItem() instanceof SkyrootTool) {
                if ((targetState.getDestroySpeed(context.getLevel(), BlockPos.containing(targetPos)) > 0 && tool.isCorrectToolForDrops(targetState))) {
                    this.increaseDrops(lootStacks, newStacks, context.getRandom());
                }
            }
        } else if (targetEntity != null) {
            if (attacker instanceof LivingEntity livingEntity && EquipmentUtil.isFullStrength(livingEntity) && livingEntity.getMainHandItem().getItem() instanceof SkyrootWeapon && !targetEntity.getType().is(AetherIITags.Entities.NO_DOUBLE_DROPS)) {
                this.increaseDrops(lootStacks, newStacks, context.getRandom());
            }
        }
        return newStacks;
    }

    private void increaseDrops(ObjectArrayList<ItemStack> lootStacks, ObjectArrayList<ItemStack> newStacks, RandomSource random) {
        Set<Item> distinctItems = lootStacks.stream().map(ItemStack::getItem).collect(Collectors.toSet());
        for (Item item : distinctItems) {
            if (item.getDefaultInstance().is(AetherIITags.Items.DOUBLE_DROPS)) {
                int count = 0;
                double chance = random.nextDouble();
                if (item instanceof BlockItem) {
                    if (chance < 0.1) {
                        count = 2;
                    } else if (chance < 0.5) {
                        count = 1;
                    }
                } else {
                    if (chance < 0.25) {
                        count = 2;
                    } else if (chance < 0.75) {
                        count = 1;
                    }
                }
                if (count > 0) {
                    newStacks.add(new ItemStack(item, count));
                }
            }
        }
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return DoubleDropsModifier.CODEC;
    }
}
