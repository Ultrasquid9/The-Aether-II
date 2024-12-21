package com.aetherteam.aetherii.item.equipment.weapons;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.entity.AetherIIAttributes;
import com.aetherteam.aetherii.item.equipment.AetherIINeoItemAbilities;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.ItemAbility;

public class TieredShortswordItem extends SwordItem {
    public static final ResourceLocation BASE_SWEEP_RANGE_ID = ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "base_sweep_range");

    public TieredShortswordItem(Item.Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers createAttributes(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        return createAttributes(toolMaterial, (float) attackDamage, attackSpeed);
    }

    public static ItemAttributeModifiers createAttributes(ToolMaterial toolMaterial, float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, attackDamage + toolMaterial.attackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(AetherIIAttributes.SWEEP_RANGE, new AttributeModifier(BASE_SWEEP_RANGE_ID, 2.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility toolAction) {
        return AetherIINeoItemAbilities.DEFAULT_SHORTSWORD_ACTIONS.contains(toolAction);
    }
}
