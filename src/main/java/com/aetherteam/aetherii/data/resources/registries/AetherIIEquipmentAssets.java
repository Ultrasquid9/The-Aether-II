package com.aetherteam.aetherii.data.resources.registries;

import com.aetherteam.aetherii.AetherII;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class AetherIIEquipmentAssets {
    public static ResourceKey<EquipmentAsset> TAEGORE_HIDE = create("taegore_hide");
    public static ResourceKey<EquipmentAsset> BURRUKAI_PELT = create("burrukai_pelt");
    public static ResourceKey<EquipmentAsset> ZANITE = create("zanite");
    public static ResourceKey<EquipmentAsset> ARKENIUM = create("arkenium");
    public static ResourceKey<EquipmentAsset> GRAVITITE = create("gravitite");

    private static ResourceKey<EquipmentAsset> create(String name) {
        return ResourceKey.create(ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace("equipment_asset")), ResourceLocation.fromNamespaceAndPath(AetherII.MODID, name));
    }
}
