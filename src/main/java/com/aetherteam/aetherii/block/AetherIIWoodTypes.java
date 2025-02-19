package com.aetherteam.aetherii.block;

import com.aetherteam.aetherii.AetherII;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AetherIIWoodTypes {
    public static final BlockSetType SKYROOT_BLOCK_SET = new BlockSetType(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "skyroot").toString());
    public static final WoodType SKYROOT = new WoodType(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "skyroot").toString(), SKYROOT_BLOCK_SET);

    public static final BlockSetType GREATROOT_BLOCK_SET = new BlockSetType(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "greatroot").toString());
    public static final WoodType GREATROOT = new WoodType(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "greatroot").toString(), GREATROOT_BLOCK_SET);

    public static final BlockSetType WISPROOT_BLOCK_SET = new BlockSetType(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "wisproot").toString());
    public static final WoodType WISPROOT = new WoodType(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "wisproot").toString(), WISPROOT_BLOCK_SET);
}