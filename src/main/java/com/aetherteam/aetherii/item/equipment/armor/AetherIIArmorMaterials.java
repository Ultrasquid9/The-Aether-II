package com.aetherteam.aetherii.item.equipment.armor;

import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.data.resources.registries.AetherIIEquipmentAssets;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public class AetherIIArmorMaterials { //todo sounds
    public static final ArmorMaterial TAEGORE_HIDE = new ArmorMaterial(5, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 1);
        map.put(ArmorType.LEGGINGS, 2);
        map.put(ArmorType.CHESTPLATE, 3);
        map.put(ArmorType.HELMET, 1);
    }), 15, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, AetherIITags.Items.TAEGORE_HIDE_REPAIRING, AetherIIEquipmentAssets.TAEGORE_HIDE);
    public static final ArmorMaterial BURRUKAI_PELT = new ArmorMaterial(5, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 1);
        map.put(ArmorType.LEGGINGS, 4);
        map.put(ArmorType.CHESTPLATE, 5);
        map.put(ArmorType.HELMET, 2);
    }), 15, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, AetherIITags.Items.BURRUKAI_PELT_REPAIRING, AetherIIEquipmentAssets.BURRUKAI_PELT);
    public static final ArmorMaterial ZANITE = new ArmorMaterial(15, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 2);
        map.put(ArmorType.LEGGINGS, 5);
        map.put(ArmorType.CHESTPLATE, 6);
        map.put(ArmorType.HELMET, 2);
    }), 9, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, AetherIITags.Items.ZANITE_REPAIRING, AetherIIEquipmentAssets.ZANITE);
    public static final ArmorMaterial ARKENIUM = new ArmorMaterial(15, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 2);
        map.put(ArmorType.LEGGINGS, 5);
        map.put(ArmorType.CHESTPLATE, 6);
        map.put(ArmorType.HELMET, 2);
    }), 10, SoundEvents.ARMOR_EQUIP_GENERIC, 1.0F, 0.0F, AetherIITags.Items.ARKENIUM_REPAIRING, AetherIIEquipmentAssets.ARKENIUM);
    public static final ArmorMaterial GRAVITITE = new ArmorMaterial(33, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 3);
        map.put(ArmorType.LEGGINGS, 6);
        map.put(ArmorType.CHESTPLATE, 8);
        map.put(ArmorType.HELMET, 3);
    }), 10, SoundEvents.ARMOR_EQUIP_GENERIC, 2.0F, 0.0F, AetherIITags.Items.GRAVITITE_REPAIRING, AetherIIEquipmentAssets.GRAVITITE);
}
