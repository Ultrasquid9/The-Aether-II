package com.aetherteam.aetherii.data.generators;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.data.providers.AetherIILanguageProvider;
import com.aetherteam.aetherii.data.resources.registries.AetherIIDimensions;
import com.aetherteam.aetherii.data.resources.registries.AetherIIStructures;
import com.aetherteam.aetherii.data.resources.registries.highlands.HighlandsBiomes;
import com.aetherteam.aetherii.effect.AetherIIEffects;
import com.aetherteam.aetherii.entity.attributes.AetherIIAttributes;
import com.aetherteam.aetherii.entity.AetherIIEntityTypes;
import com.aetherteam.aetherii.entity.passive.Moa;
import com.aetherteam.aetherii.inventory.menu.AetherIIMenuTypes;
import com.aetherteam.aetherii.item.AetherIICreativeTabs;
import com.aetherteam.aetherii.item.AetherIIItems;
import net.minecraft.data.PackOutput;

public class AetherIILanguageData extends AetherIILanguageProvider {
    public AetherIILanguageData(PackOutput output) {
        super(output, AetherII.MODID);
    }

    @Override
    protected void addTranslations() {
        // Blocks
        // Portal
        this.addBlock(AetherIIBlocks.AETHER_PORTAL, "Aether Portal");

        // Dirt
        this.addBlock(AetherIIBlocks.AETHER_GRASS_BLOCK, "Aether Grass Block");
        this.addBlock(AetherIIBlocks.ENCHANTED_AETHER_GRASS_BLOCK, "Enchanted Aether Grass Block");
        this.addBlock(AetherIIBlocks.AETHER_DIRT_PATH, "Aether Dirt Path");
        this.addBlock(AetherIIBlocks.AETHER_DIRT, "Aether Dirt");
        this.addBlock(AetherIIBlocks.COARSE_AETHER_DIRT, "Coarse Aether Dirt");
        this.addBlock(AetherIIBlocks.AETHER_FARMLAND, "Aether Farmland");
        this.addBlock(AetherIIBlocks.SHIMMERING_SILT, "Shimmering Silt");

        // Underground
        this.addBlock(AetherIIBlocks.HOLYSTONE, "Holystone");
        this.addBlock(AetherIIBlocks.UNSTABLE_HOLYSTONE, "Unstable Holystone");
        this.addBlock(AetherIIBlocks.UNDERSHALE, "Undershale");
        this.addBlock(AetherIIBlocks.UNSTABLE_UNDERSHALE, "Unstable Undershale");
        this.addBlock(AetherIIBlocks.AGIOSITE, "Agiosite");
        this.addBlock(AetherIIBlocks.CRUDE_SCATTERGLASS, "Crude Scatterglass");
        this.addBlock(AetherIIBlocks.SKY_ROOTS, "Sky Roots");
        this.addBlock(AetherIIBlocks.POINTED_HOLYSTONE, "Pointed Holystone");
        this.addBlock(AetherIIBlocks.POINTED_ICHORITE, "Pointed Ichorite");

        // Highfields
        this.addBlock(AetherIIBlocks.QUICKSOIL, "Quicksoil");
        this.addBlock(AetherIIBlocks.MOSSY_HOLYSTONE, "Mossy Holystone");
        this.addBlock(AetherIIBlocks.BRYALINN_MOSS_BLOCK, "Bryalinn Moss Block");
        this.addBlock(AetherIIBlocks.BRYALINN_MOSS_CARPET, "Bryalinn Moss Carpet");
        this.addBlock(AetherIIBlocks.BRYALINN_MOSS_VINES, "Bryalinn Moss Vines");
        this.addBlock(AetherIIBlocks.BRYALINN_MOSS_FLOWERS, "Bryalinn Moss Flowers");
        this.addBlock(AetherIIBlocks.TANGLED_BRANCHES, "Tangled Branches");

        // Magnetic
        this.addBlock(AetherIIBlocks.FERROSITE_SAND, "Ferrosite Sand");
        this.addBlock(AetherIIBlocks.FERROSITE_MUD, "Ferrosite Mud");
        this.addBlock(AetherIIBlocks.FERROSITE, "Ferrosite");
        this.addBlock(AetherIIBlocks.RUSTED_FERROSITE, "Rusted Ferrosite");
        this.addBlock(AetherIIBlocks.MAGNETIC_SHROOM, "Magnetic Shroom");

        // Arctic
        this.addBlock(AetherIIBlocks.ARCTIC_SNOW_BLOCK, "Arctic Snow Block");
        this.addBlock(AetherIIBlocks.ARCTIC_SNOW, "Arctic Snow");
        this.addBlock(AetherIIBlocks.ARCTIC_ICE, "Arctic Ice");
        this.addBlock(AetherIIBlocks.ARCTIC_PACKED_ICE, "Arctic Packed Ice");
        this.addBlock(AetherIIBlocks.ICESTONE, "Icestone");
        this.addBlock(AetherIIBlocks.LARGE_ARCTIC_ICE_CRYSTAL, "Large Arctic Ice Crystal");
        this.addBlock(AetherIIBlocks.MEDIUM_ARCTIC_ICE_CRYSTAL, "Medium Arctic Ice Crystal");
        this.addBlock(AetherIIBlocks.SMALL_ARCTIC_ICE_CRYSTAL, "Small Arctic Ice Crystal");
        this.addBlock(AetherIIBlocks.SHAYELINN_MOSS_BLOCK, "Shayelinn Moss Block");
        this.addBlock(AetherIIBlocks.SHAYELINN_MOSS_CARPET, "Shayelinn Moss Carpet");
        this.addBlock(AetherIIBlocks.SHAYELINN_MOSS_VINES, "Shayelinn Moss Vines");

        // Irradiated
        this.addBlock(AetherIIBlocks.IRRADIATED_HOLYSTONE, "Irradiated Holystone");
        this.addBlock(AetherIIBlocks.IRRADIATED_DUST_BLOCK, "Irradiated Dust Block");
        this.addBlock(AetherIIBlocks.AMBRELINN_MOSS_BLOCK, "Ambrelinn Moss Block");
        this.addBlock(AetherIIBlocks.AMBRELINN_MOSS_CARPET, "Ambrelinn Moss Carpet");
        this.addBlock(AetherIIBlocks.AMBRELINN_MOSS_VINES, "Ambrelinn Moss Vines");
        this.addBlock(AetherIIBlocks.TARAHESP_FLOWERS, "Tarahesp Flowers");

        // Ores
        this.addBlock(AetherIIBlocks.HOLYSTONE_QUARTZ_ORE, "Holystone Quartz Ore");
        this.addBlock(AetherIIBlocks.AMBROSIUM_ORE, "Ambrosium Ore");
        this.addBlock(AetherIIBlocks.ZANITE_ORE, "Zanite Ore");
        this.addBlock(AetherIIBlocks.GLINT_ORE, "Glint Ore");
        this.addBlock(AetherIIBlocks.ARKENIUM_ORE, "Arkenium Ore");
        this.addBlock(AetherIIBlocks.GRAVITITE_ORE, "Gravitite Ore");
        this.addBlock(AetherIIBlocks.UNDERSHALE_AMBROSIUM_ORE, "Undershale Ambrosium Ore");
        this.addBlock(AetherIIBlocks.UNDERSHALE_ZANITE_ORE, "Undershale Zanite Ore");
        this.addBlock(AetherIIBlocks.UNDERSHALE_GLINT_ORE, "Undershale Glint Ore");
        this.addBlock(AetherIIBlocks.UNDERSHALE_ARKENIUM_ORE, "Undershale Arkenium Ore");
        this.addBlock(AetherIIBlocks.UNDERSHALE_GRAVITITE_ORE, "Undershale Gravitite Ore");
        this.addBlock(AetherIIBlocks.CORROBONITE_ORE, "Corrobonite Ore");
        this.addBlock(AetherIIBlocks.CORROBONITE_CLUSTER, "Corrobonite Cluster");

        // Aerclouds
        this.addBlock(AetherIIBlocks.COLD_AERCLOUD, "Cold Aercloud");
        this.addBlock(AetherIIBlocks.BLUE_AERCLOUD, "Blue Aercloud");
        this.addBlock(AetherIIBlocks.GOLDEN_AERCLOUD, "Golden Aercloud");
        this.addBlock(AetherIIBlocks.GREEN_AERCLOUD, "Green Aercloud");
        this.addBlock(AetherIIBlocks.PURPLE_AERCLOUD, "Purple Aercloud");
        this.addBlock(AetherIIBlocks.STORM_AERCLOUD, "Storm Aercloud");

        // Moa Nest
        this.addBlock(AetherIIBlocks.WOVEN_SKYROOT_STICKS, "Woven Skyroot Sticks");

        // Logs
        this.addBlock(AetherIIBlocks.SKYROOT_LOG, "Skyroot Log");
        this.addBlock(AetherIIBlocks.STRIPPED_SKYROOT_LOG, "Stripped Skyroot Log");
        this.addBlock(AetherIIBlocks.GREATROOT_LOG, "Greatroot Log");
        this.addBlock(AetherIIBlocks.STRIPPED_GREATROOT_LOG, "Stripped Greatroot Log");
        this.addBlock(AetherIIBlocks.WISPROOT_LOG, "Wisproot Log");
        this.addBlock(AetherIIBlocks.MOSSY_WISPROOT_LOG, "Mossy Wisproot Log");
        this.addBlock(AetherIIBlocks.MOSSY_WISPROOT_LOG_END, "Mossy Wisproot Log End");
        this.addBlock(AetherIIBlocks.STRIPPED_WISPROOT_LOG, "Stripped Wisproot Log");
        this.addBlock(AetherIIBlocks.AMBEROOT_LOG, "Amberoot Log");
        this.addBlock(AetherIIBlocks.SKYROOT_WOOD, "Skyroot Wood");
        this.addBlock(AetherIIBlocks.STRIPPED_SKYROOT_WOOD, "Stripped Skyroot Wood");
        this.addBlock(AetherIIBlocks.GREATROOT_WOOD, "Greatroot Wood");
        this.addBlock(AetherIIBlocks.STRIPPED_GREATROOT_WOOD, "Stripped Greatroot Wood");
        this.addBlock(AetherIIBlocks.WISPROOT_WOOD, "Wisproot Wood");
        this.addBlock(AetherIIBlocks.MOSSY_WISPROOT_WOOD, "Mossy Wisproot Wood");
        this.addBlock(AetherIIBlocks.STRIPPED_WISPROOT_WOOD, "Stripped Wisproot Wood");
        this.addBlock(AetherIIBlocks.AMBEROOT_WOOD, "Amberoot Wood");

        // Leaf Pile
        this.addBlock(AetherIIBlocks.SKYROOT_LEAF_PILE, "Skyroot Leaf Pile");
        this.addBlock(AetherIIBlocks.SKYPLANE_LEAF_PILE, "Skyplane Leaf Pile");
        this.addBlock(AetherIIBlocks.SKYBIRCH_LEAF_PILE, "Skybirch Leaf Pile");
        this.addBlock(AetherIIBlocks.SKYPINE_LEAF_PILE, "Skypine Leaf Pile");
        this.addBlock(AetherIIBlocks.WISPROOT_LEAF_PILE, "Wisproot Leaf Pile");
        this.addBlock(AetherIIBlocks.WISPTOP_LEAF_PILE, "Wisptop Leaf Pile");
        this.addBlock(AetherIIBlocks.GREATROOT_LEAF_PILE, "Greatroot Leaf Pile");
        this.addBlock(AetherIIBlocks.GREATOAK_LEAF_PILE, "Greatoak Leaf Pile");
        this.addBlock(AetherIIBlocks.GREATBOA_LEAF_PILE, "Greatboa Leaf Pile");
        this.addBlock(AetherIIBlocks.AMBEROOT_LEAF_PILE, "Amberoot Leaf Pile");
        this.addBlock(AetherIIBlocks.IRRADIATED_SKYROOT_LEAF_PILE, "Irradiated Skyroot Leaf Pile");
        this.addBlock(AetherIIBlocks.IRRADIATED_SKYPLANE_LEAF_PILE, "Irradiated Skyplane Leaf Pile");
        this.addBlock(AetherIIBlocks.IRRADIATED_SKYBIRCH_LEAF_PILE, "Irradiated Skybirch Leaf Pile");
        this.addBlock(AetherIIBlocks.IRRADIATED_SKYPINE_LEAF_PILE, "Irradiated Skypine Leaf Pile");
        this.addBlock(AetherIIBlocks.IRRADIATED_WISPROOT_LEAF_PILE, "Irradiated Wisproot Leaf Pile");
        this.addBlock(AetherIIBlocks.IRRADIATED_WISPTOP_LEAF_PILE, "Irradiated Wisptop Leaf Pile");
        this.addBlock(AetherIIBlocks.IRRADIATED_GREATROOT_LEAF_PILE, "Irradiated Greatroot Leaf Pile");
        this.addBlock(AetherIIBlocks.IRRADIATED_GREATOAK_LEAF_PILE, "Irradiated Greatoak Leaf Pile");
        this.addBlock(AetherIIBlocks.IRRADIATED_GREATBOA_LEAF_PILE, "Irradiated Greatboa Leaf Pile");

        // Leaves
        this.addBlock(AetherIIBlocks.SKYROOT_LEAVES, "Skyroot Leaves");
        this.addBlock(AetherIIBlocks.SKYPLANE_LEAVES, "Skyplane Leaves");
        this.addBlock(AetherIIBlocks.SKYBIRCH_LEAVES, "Skybirch Leaves");
        this.addBlock(AetherIIBlocks.SKYPINE_LEAVES, "Skypine Leaves");
        this.addBlock(AetherIIBlocks.WISPROOT_LEAVES, "Wisproot Leaves");
        this.addBlock(AetherIIBlocks.WISPTOP_LEAVES, "Wisptop Leaves");
        this.addBlock(AetherIIBlocks.GREATROOT_LEAVES, "Greatroot Leaves");
        this.addBlock(AetherIIBlocks.GREATOAK_LEAVES, "Greatoak Leaves");
        this.addBlock(AetherIIBlocks.GREATBOA_LEAVES, "Greatboa Leaves");
        this.addBlock(AetherIIBlocks.AMBEROOT_LEAVES, "Amberoot Leaves");
        this.addBlock(AetherIIBlocks.IRRADIATED_SKYROOT_LEAVES, "Irradiated Skyroot Leaves");
        this.addBlock(AetherIIBlocks.IRRADIATED_SKYPLANE_LEAVES, "Irradiated Skyplane Leaves");
        this.addBlock(AetherIIBlocks.IRRADIATED_SKYBIRCH_LEAVES, "Irradiated Skybirch Leaves");
        this.addBlock(AetherIIBlocks.IRRADIATED_SKYPINE_LEAVES, "Irradiated Skypine Leaves");
        this.addBlock(AetherIIBlocks.IRRADIATED_WISPROOT_LEAVES, "Irradiated Wisproot Leaves");
        this.addBlock(AetherIIBlocks.IRRADIATED_WISPTOP_LEAVES, "Irradiated Wisptop Leaves");
        this.addBlock(AetherIIBlocks.IRRADIATED_GREATROOT_LEAVES, "Irradiated Greatroot Leaves");
        this.addBlock(AetherIIBlocks.IRRADIATED_GREATOAK_LEAVES, "Irradiated Greatoak Leaves");
        this.addBlock(AetherIIBlocks.IRRADIATED_GREATBOA_LEAVES, "Irradiated Greatboa Leaves");

        // Saplings
        this.addBlock(AetherIIBlocks.SKYROOT_SAPLING, "Skyroot Sapling");
        this.addBlock(AetherIIBlocks.SKYPLANE_SAPLING, "Skyplane Sapling");
        this.addBlock(AetherIIBlocks.SKYBIRCH_SAPLING, "Skybirch Sapling");
        this.addBlock(AetherIIBlocks.SKYPINE_SAPLING, "Skypine Sapling");
        this.addBlock(AetherIIBlocks.WISPROOT_SAPLING, "Wisproot Sapling");
        this.addBlock(AetherIIBlocks.WISPTOP_SAPLING, "Wisptop Sapling");
        this.addBlock(AetherIIBlocks.GREATROOT_SAPLING, "Greatroot Sapling");
        this.addBlock(AetherIIBlocks.GREATOAK_SAPLING, "Greatoak Sapling");
        this.addBlock(AetherIIBlocks.GREATBOA_SAPLING, "Greatboa Sapling");
        this.addBlock(AetherIIBlocks.AMBEROOT_SAPLING, "Amberoot Sapling");

        // Potted Saplings
        this.addBlock(AetherIIBlocks.POTTED_SKYROOT_SAPLING, "Potted Skyroot Sapling");
        this.addBlock(AetherIIBlocks.POTTED_SKYPLANE_SAPLING, "Potted Skyplane Sapling");
        this.addBlock(AetherIIBlocks.POTTED_SKYBIRCH_SAPLING, "Potted Skybirch Sapling");
        this.addBlock(AetherIIBlocks.POTTED_SKYPINE_SAPLING, "Potted Skypine Sapling");
        this.addBlock(AetherIIBlocks.POTTED_WISPROOT_SAPLING, "Potted Wisproot Sapling");
        this.addBlock(AetherIIBlocks.POTTED_WISPTOP_SAPLING, "Potted Wisptop Sapling");
        this.addBlock(AetherIIBlocks.POTTED_GREATROOT_SAPLING, "Potted Greatroot Sapling");
        this.addBlock(AetherIIBlocks.POTTED_GREATOAK_SAPLING, "Potted Greatoak Sapling");
        this.addBlock(AetherIIBlocks.POTTED_GREATBOA_SAPLING, "Potted Greatboa Sapling");
        this.addBlock(AetherIIBlocks.POTTED_AMBEROOT_SAPLING, "Potted Amberoot Sapling");

        // Grasses
        this.addBlock(AetherIIBlocks.AETHER_SHORT_GRASS, "Aether Short Grass");
        this.addBlock(AetherIIBlocks.AETHER_MEDIUM_GRASS, "Aether Medium Grass");
        this.addBlock(AetherIIBlocks.AETHER_LONG_GRASS, "Aether Long Grass");
        this.addBlock(AetherIIBlocks.HIGHLAND_FERN, "Highland Fern");
        this.addBlock(AetherIIBlocks.SHIELD_FERN, "Shield Fern");

        // Flowers
        this.addBlock(AetherIIBlocks.HESPEROSE, "Hesperose");
        this.addBlock(AetherIIBlocks.TARABLOOM, "Tarabloom");
        this.addBlock(AetherIIBlocks.POASPROUT, "Poasprout");
        this.addBlock(AetherIIBlocks.LILICHIME, "Lilichime");
        this.addBlock(AetherIIBlocks.PLURACIAN, "Pluracian");
        this.addBlock(AetherIIBlocks.SATIVAL_SHOOT, "Satival Shoot");
        this.addBlock(AetherIIBlocks.HOLPUPEA, "Holpupea");
        this.addBlock(AetherIIBlocks.BLADE_POA, "Blade Poa");
        this.addBlock(AetherIIBlocks.AECHOR_CUTTING, "Aechor Cutting");

        // Potted Flowers
        this.addBlock(AetherIIBlocks.POTTED_MAGNETIC_SHROOM, "Potted Magnetic Shroom");
        this.addBlock(AetherIIBlocks.POTTED_HIGHLAND_FERN, "Potted Highland Fern");
        this.addBlock(AetherIIBlocks.POTTED_SHIELD_FERN, "Potted Shield Fern");
        this.addBlock(AetherIIBlocks.POTTED_HESPEROSE, "Potted Hesperose");
        this.addBlock(AetherIIBlocks.POTTED_TARABLOOM, "Potted Tarabloom");
        this.addBlock(AetherIIBlocks.POTTED_POASPROUT, "Potted Poasprout");
        this.addBlock(AetherIIBlocks.POTTED_SATIVAL_SHOOT, "Potted Satival Shoot");
        this.addBlock(AetherIIBlocks.POTTED_LILICHIME, "Potted Lilichime");
        this.addBlock(AetherIIBlocks.POTTED_PLURACIAN, "Potted Pluracian");
        this.addBlock(AetherIIBlocks.POTTED_BLADE_POA, "Potted Blade Poa");
        this.addBlock(AetherIIBlocks.POTTED_AECHOR_CUTTING, "Potted Aechor Cutting");

        // Bushes
        this.addBlock(AetherIIBlocks.HIGHLANDS_BUSH, "Highlands Bush");
        this.addBlock(AetherIIBlocks.BLUEBERRY_BUSH, "Blueberry Bush");
        this.addBlock(AetherIIBlocks.BLUEBERRY_BUSH_STEM, "Blueberry Bush Stem");

        // Orange Tree
        this.addBlock(AetherIIBlocks.ORANGE_TREE, "Orange Tree");

        // Valkyrie Sprout
        this.addBlock(AetherIIBlocks.VALKYRIE_SPROUT, "Valkyrie Sprout");

        // Brettl
        this.addBlock(AetherIIBlocks.BRETTL_PLANT, "Brettl Plant");
        this.addBlock(AetherIIBlocks.BRETTL_PLANT_TIP, "Brettl Plant Tip");

        // Lake
        this.addBlock(AetherIIBlocks.ARILUM_SHOOT, "Arilum");
        this.addBlock(AetherIIBlocks.ARILUM, "Arilum");
        this.addBlock(AetherIIBlocks.ARILUM_PLANT, "Arilum");
        this.addBlock(AetherIIBlocks.BLOOMING_ARILUM, "Blooming Arilum");
        this.addBlock(AetherIIBlocks.BLOOMING_ARILUM_PLANT, "Blooming Arilum");

        // Ground Decoration
        this.addBlock(AetherIIBlocks.SKYROOT_TWIG, "Skyroot Twig");
        this.addBlock(AetherIIBlocks.HOLYSTONE_ROCK, "Holystone Rock");

        // Skyroot Planks
        this.addBlock(AetherIIBlocks.SKYROOT_PLANKS, "Skyroot Planks");
        this.addBlock(AetherIIBlocks.SKYROOT_STAIRS, "Skyroot Stairs");
        this.addBlock(AetherIIBlocks.SKYROOT_SLAB, "Skyroot Slab");
        this.addBlock(AetherIIBlocks.SKYROOT_FENCE, "Skyroot Fence");
        this.addBlock(AetherIIBlocks.SKYROOT_FENCE_GATE, "Skyroot Fence Gate");
        this.addBlock(AetherIIBlocks.SKYROOT_DOOR, "Skyroot Door");
        this.addBlock(AetherIIBlocks.SKYROOT_TRAPDOOR, "Skyroot Trapdoor");
        this.addBlock(AetherIIBlocks.SKYROOT_BUTTON, "Skyroot Button");
        this.addBlock(AetherIIBlocks.SKYROOT_PRESSURE_PLATE, "Skyroot Pressure Plate");

        // Skyroot Decorative Blocks
        this.addBlock(AetherIIBlocks.SKYROOT_FLOORBOARDS, "Skyroot Floorboards");
        this.addBlock(AetherIIBlocks.SKYROOT_HIGHLIGHT, "Skyroot Highlight");
        this.addBlock(AetherIIBlocks.SKYROOT_SHINGLES, "Skyroot Shingles");
        this.addBlock(AetherIIBlocks.SKYROOT_SMALL_SHINGLES, "Skyroot Small Shingles");
        this.addBlock(AetherIIBlocks.SKYROOT_BASE_PLANKS, "Skyroot Base Planks");
        this.addBlock(AetherIIBlocks.SKYROOT_TOP_PLANKS, "Skyroot Top Planks");
        this.addBlock(AetherIIBlocks.SKYROOT_BASE_BEAM, "Skyroot Base Beam");
        this.addBlock(AetherIIBlocks.SKYROOT_TOP_BEAM, "Skyroot Top Beam");
        this.addBlock(AetherIIBlocks.SKYROOT_BEAM, "Skyroot Beam");
        this.addBlock(AetherIIBlocks.SECRET_SKYROOT_DOOR, "Secret Skyroot Door");
        this.addBlock(AetherIIBlocks.SECRET_SKYROOT_TRAPDOOR, "Secret Skyroot Trapdoor");

        // Greatroot Planks
        this.addBlock(AetherIIBlocks.GREATROOT_PLANKS, "Greatroot Planks");
        this.addBlock(AetherIIBlocks.GREATROOT_STAIRS, "Greatroot Stairs");
        this.addBlock(AetherIIBlocks.GREATROOT_SLAB, "Greatroot Slab");
        this.addBlock(AetherIIBlocks.GREATROOT_FENCE, "Greatroot Fence");
        this.addBlock(AetherIIBlocks.GREATROOT_FENCE_GATE, "Greatroot Fence Gate");
        this.addBlock(AetherIIBlocks.GREATROOT_DOOR, "Greatroot Door");
        this.addBlock(AetherIIBlocks.GREATROOT_TRAPDOOR, "Greatroot Trapdoor");
        this.addBlock(AetherIIBlocks.GREATROOT_BUTTON, "Greatroot Button");
        this.addBlock(AetherIIBlocks.GREATROOT_PRESSURE_PLATE, "Greatroot Pressure Plate");

        // Greatroot Decorative Blocks
        this.addBlock(AetherIIBlocks.GREATROOT_FLOORBOARDS, "Greatroot Floorboards");
        this.addBlock(AetherIIBlocks.GREATROOT_HIGHLIGHT, "Greatroot Highlight");
        this.addBlock(AetherIIBlocks.GREATROOT_SHINGLES, "Greatroot Shingles");
        this.addBlock(AetherIIBlocks.GREATROOT_SMALL_SHINGLES, "Greatroot Small Shingles");
        this.addBlock(AetherIIBlocks.GREATROOT_BASE_PLANKS, "Greatroot Base Planks");
        this.addBlock(AetherIIBlocks.GREATROOT_TOP_PLANKS, "Greatroot Top Planks");
        this.addBlock(AetherIIBlocks.GREATROOT_BASE_BEAM, "Greatroot Base Beam");
        this.addBlock(AetherIIBlocks.GREATROOT_TOP_BEAM, "Greatroot Top Beam");
        this.addBlock(AetherIIBlocks.GREATROOT_BEAM, "Greatroot Beam");
        this.addBlock(AetherIIBlocks.SECRET_GREATROOT_DOOR, "Secret Greatroot Door");
        this.addBlock(AetherIIBlocks.SECRET_GREATROOT_TRAPDOOR, "Secret Greatroot Trapdoor");

        // Wisproot Planks
        this.addBlock(AetherIIBlocks.WISPROOT_PLANKS, "Wisproot Planks");
        this.addBlock(AetherIIBlocks.WISPROOT_STAIRS, "Wisproot Stairs");
        this.addBlock(AetherIIBlocks.WISPROOT_SLAB, "Wisproot Slab");
        this.addBlock(AetherIIBlocks.WISPROOT_FENCE, "Wisproot Fence");
        this.addBlock(AetherIIBlocks.WISPROOT_FENCE_GATE, "Wisproot Fence Gate");
        this.addBlock(AetherIIBlocks.WISPROOT_DOOR, "Wisproot Door");
        this.addBlock(AetherIIBlocks.WISPROOT_TRAPDOOR, "Wisproot Trapdoor");
        this.addBlock(AetherIIBlocks.WISPROOT_BUTTON, "Wisproot Button");
        this.addBlock(AetherIIBlocks.WISPROOT_PRESSURE_PLATE, "Wisproot Pressure Plate");

        // Wisproot Decorative Blocks
        this.addBlock(AetherIIBlocks.WISPROOT_FLOORBOARDS, "Wisproot Floorboards");
        this.addBlock(AetherIIBlocks.WISPROOT_HIGHLIGHT, "Wisproot Highlight");
        this.addBlock(AetherIIBlocks.WISPROOT_SHINGLES, "Wisproot Shingles");
        this.addBlock(AetherIIBlocks.WISPROOT_SMALL_SHINGLES, "Wisproot Small Shingles");
        this.addBlock(AetherIIBlocks.WISPROOT_BASE_PLANKS, "Wisproot Base Planks");
        this.addBlock(AetherIIBlocks.WISPROOT_TOP_PLANKS, "Wisproot Top Planks");
        this.addBlock(AetherIIBlocks.WISPROOT_BASE_BEAM, "Wisproot Base Beam");
        this.addBlock(AetherIIBlocks.WISPROOT_TOP_BEAM, "Wisproot Top Beam");
        this.addBlock(AetherIIBlocks.WISPROOT_BEAM, "Wisproot Beam");
        this.addBlock(AetherIIBlocks.SECRET_WISPROOT_DOOR, "Secret Wisproot Door");
        this.addBlock(AetherIIBlocks.SECRET_WISPROOT_TRAPDOOR, "Secret Wisproot Trapdoor");

        // Holystone
        this.addBlock(AetherIIBlocks.HOLYSTONE_STAIRS, "Holystone Stairs");
        this.addBlock(AetherIIBlocks.HOLYSTONE_SLAB, "Holystone Slab");
        this.addBlock(AetherIIBlocks.HOLYSTONE_WALL, "Holystone Wall");
        this.addBlock(AetherIIBlocks.HOLYSTONE_BUTTON, "Holystone Button");
        this.addBlock(AetherIIBlocks.HOLYSTONE_PRESSURE_PLATE, "Holystone Pressure Plate");

        // Mossy Holystone
        this.addBlock(AetherIIBlocks.MOSSY_HOLYSTONE_STAIRS, "Mossy Holystone Stairs");
        this.addBlock(AetherIIBlocks.MOSSY_HOLYSTONE_SLAB, "Mossy Holystone Slab");
        this.addBlock(AetherIIBlocks.MOSSY_HOLYSTONE_WALL, "Mossy Holystone Wall");

        // Irradiated Holystone
        this.addBlock(AetherIIBlocks.IRRADIATED_HOLYSTONE_STAIRS, "Irradiated Holystone Stairs");
        this.addBlock(AetherIIBlocks.IRRADIATED_HOLYSTONE_SLAB, "Irradiated Holystone Slab");
        this.addBlock(AetherIIBlocks.IRRADIATED_HOLYSTONE_WALL, "Irradiated Holystone Wall");

        // Holystone Bricks
        this.addBlock(AetherIIBlocks.HOLYSTONE_BRICKS, "Holystone Bricks");
        this.addBlock(AetherIIBlocks.HOLYSTONE_BRICK_STAIRS, "Holystone Brick Stairs");
        this.addBlock(AetherIIBlocks.HOLYSTONE_BRICK_SLAB, "Holystone Brick Slab");
        this.addBlock(AetherIIBlocks.HOLYSTONE_BRICK_WALL, "Holystone Brick Wall");

        // Holystone Decorative Blocks
        this.addBlock(AetherIIBlocks.HOLYSTONE_FLAGSTONES, "Holystone Flagstones");
        this.addBlock(AetherIIBlocks.HOLYSTONE_HEADSTONE, "Holystone Headstone");
        this.addBlock(AetherIIBlocks.HOLYSTONE_KEYSTONE, "Holystone Keystone");
        this.addBlock(AetherIIBlocks.HOLYSTONE_BASE_BRICKS, "Holystone Base Bricks");
        this.addBlock(AetherIIBlocks.HOLYSTONE_CAPSTONE_BRICKS, "Holystone Capstone Bricks");
        this.addBlock(AetherIIBlocks.HOLYSTONE_BASE_PILLAR, "Holystone Base Pillar");
        this.addBlock(AetherIIBlocks.HOLYSTONE_CAPSTONE_PILLAR, "Holystone Capstone Pillar");
        this.addBlock(AetherIIBlocks.HOLYSTONE_PILLAR, "Holystone Pillar");

        // Faded Holystone Bricks
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_BRICKS, "Faded Holystone Bricks");
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_BRICK_STAIRS, "Faded Holystone Brick Stairs");
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_BRICK_SLAB, "Faded Holystone Brick Slab");
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_BRICK_WALL, "Faded Holystone Brick Wall");

        // Faded Holystone Decorative Blocks
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_FLAGSTONES, "Faded Holystone Flagstones");
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_HEADSTONE, "Faded Holystone Headstone");
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_KEYSTONE, "Faded Holystone Keystone");
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_BASE_BRICKS, "Faded Holystone Base Bricks");
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_CAPSTONE_BRICKS, "Faded Holystone Capstone Bricks");
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_BASE_PILLAR, "Faded Holystone Base Pillar");
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_CAPSTONE_PILLAR, "Faded Holystone Capstone Pillar");
        this.addBlock(AetherIIBlocks.FADED_HOLYSTONE_PILLAR, "Faded Holystone Pillar");

        // Undershale
        this.addBlock(AetherIIBlocks.UNDERSHALE_STAIRS, "Undershale Stairs");
        this.addBlock(AetherIIBlocks.UNDERSHALE_SLAB, "Undershale Slab");
        this.addBlock(AetherIIBlocks.UNDERSHALE_WALL, "Undershale Wall");

        // Undershale Bricks
        this.addBlock(AetherIIBlocks.UNDERSHALE_BRICKS, "Undershale Bricks");
        this.addBlock(AetherIIBlocks.UNDERSHALE_BRICK_STAIRS, "Undershale Brick Stairs");
        this.addBlock(AetherIIBlocks.UNDERSHALE_BRICK_SLAB, "Undershale Brick Slab");
        this.addBlock(AetherIIBlocks.UNDERSHALE_BRICK_WALL, "Undershale Brick Wall");

        // Ichorite
        this.addBlock(AetherIIBlocks.ICHORITE, "Ichorite");
        this.addBlock(AetherIIBlocks.ICHORITE_STAIRS, "Ichorite Stairs");
        this.addBlock(AetherIIBlocks.ICHORITE_SLAB, "Ichorite Slab");
        this.addBlock(AetherIIBlocks.ICHORITE_WALL, "Ichorite Wall");

        // Smooth Ichorite
        this.addBlock(AetherIIBlocks.SMOOTH_ICHORITE, "Smooth Ichorite");
        this.addBlock(AetherIIBlocks.SMOOTH_ICHORITE_STAIRS, "Smooth Ichorite Stairs");
        this.addBlock(AetherIIBlocks.SMOOTH_ICHORITE_SLAB, "Smooth Ichorite Slab");
        this.addBlock(AetherIIBlocks.SMOOTH_ICHORITE_WALL, "Smooth Ichorite Wall");

        // Ichorite Bricks
        this.addBlock(AetherIIBlocks.ICHORITE_BRICKS, "Ichorite Bricks");
        this.addBlock(AetherIIBlocks.ICHORITE_BRICK_STAIRS, "Ichorite Brick Stairs");
        this.addBlock(AetherIIBlocks.ICHORITE_BRICK_SLAB, "Ichorite Brick Slab");
        this.addBlock(AetherIIBlocks.ICHORITE_BRICK_WALL, "Ichorite Brick Wall");

        // Ichorite Decorative Blocks
        this.addBlock(AetherIIBlocks.ICHORITE_FLAGSTONES, "Ichorite Flagstones");
        this.addBlock(AetherIIBlocks.ICHORITE_RUNESTONE, "Ichorite Runestone");
        this.addBlock(AetherIIBlocks.ICHORITE_KEYSTONE, "Ichorite Keystone");
        this.addBlock(AetherIIBlocks.ICHORITE_BASE_BRICKS, "Ichorite Base Bricks");
        this.addBlock(AetherIIBlocks.ICHORITE_CAPSTONE_BRICKS, "Ichorite Capstone Bricks");
        this.addBlock(AetherIIBlocks.ICHORITE_BASE_PILLAR, "Ichorite Base Pillar");
        this.addBlock(AetherIIBlocks.ICHORITE_CAPSTONE_PILLAR, "Ichorite Capstone Pillar");
        this.addBlock(AetherIIBlocks.ICHORITE_PILLAR, "Ichorite Pillar");

        // Marbled Ichorite
        this.addBlock(AetherIIBlocks.MARBLED_ICHORITE, "Marbled Ichorite");
        this.addBlock(AetherIIBlocks.MARBLED_ICHORITE_STAIRS, "Marbled Ichorite Stairs");
        this.addBlock(AetherIIBlocks.MARBLED_ICHORITE_SLAB, "Marbled Ichorite Slab");
        this.addBlock(AetherIIBlocks.MARBLED_ICHORITE_WALL, "Marbled Ichorite Wall");

        // Marbled Bricks
        this.addBlock(AetherIIBlocks.MARBLED_BRICKS, "Marbled Bricks");
        this.addBlock(AetherIIBlocks.MARBLED_BRICK_STAIRS, "Marbled Brick Stairs");
        this.addBlock(AetherIIBlocks.MARBLED_BRICK_SLAB, "Marbled Brick Slab");
        this.addBlock(AetherIIBlocks.MARBLED_BRICK_WALL, "Marbled Brick Wall");

        // Marbled Ichorite Decorative Blocks
        this.addBlock(AetherIIBlocks.MARBLED_FLAGSTONES, "Marbled Flagstones");
        this.addBlock(AetherIIBlocks.MARBLED_KEYSTONE, "Marbled Keystone");
        this.addBlock(AetherIIBlocks.MARBLED_BASE_BRICKS, "Marbled Base Bricks");
        this.addBlock(AetherIIBlocks.MARBLED_CAPSTONE_BRICKS, "Marbled Capstone Bricks");
        this.addBlock(AetherIIBlocks.MARBLED_BASE_PILLAR, "Marbled Base Pillar");
        this.addBlock(AetherIIBlocks.MARBLED_CAPSTONE_PILLAR, "Marbled Capstone Pillar");
        this.addBlock(AetherIIBlocks.MARBLED_PILLAR, "Marbled Pillar");

        // Agiosite
        this.addBlock(AetherIIBlocks.AGIOSITE_STAIRS, "Agiosite Stairs");
        this.addBlock(AetherIIBlocks.AGIOSITE_SLAB, "Agiosite Slab");
        this.addBlock(AetherIIBlocks.AGIOSITE_WALL, "Agiosite Wall");

        // Agiosite Bricks
        this.addBlock(AetherIIBlocks.AGIOSITE_BRICKS, "Agiosite Bricks");
        this.addBlock(AetherIIBlocks.AGIOSITE_BRICK_STAIRS, "Agiosite Brick Stairs");
        this.addBlock(AetherIIBlocks.AGIOSITE_BRICK_SLAB, "Agiosite Brick Slab");
        this.addBlock(AetherIIBlocks.AGIOSITE_BRICK_WALL, "Agiosite Brick Wall");

        // Agiosite Decorative Blocks
        this.addBlock(AetherIIBlocks.AGIOSITE_FLAGSTONES, "Agiosite Flagstones");
        this.addBlock(AetherIIBlocks.AGIOSITE_KEYSTONE, "Agiosite Keystone");
        this.addBlock(AetherIIBlocks.AGIOSITE_BASE_BRICKS, "Agiosite Base Bricks");
        this.addBlock(AetherIIBlocks.AGIOSITE_CAPSTONE_BRICKS, "Agiosite Capstone Bricks");
        this.addBlock(AetherIIBlocks.AGIOSITE_BASE_PILLAR, "Agiosite Base Pillar");
        this.addBlock(AetherIIBlocks.AGIOSITE_CAPSTONE_PILLAR, "Agiosite Capstone Pillar");
        this.addBlock(AetherIIBlocks.AGIOSITE_PILLAR, "Agiosite Pillar");

        // Icestone
        this.addBlock(AetherIIBlocks.ICESTONE_STAIRS, "Icestone Stairs");
        this.addBlock(AetherIIBlocks.ICESTONE_SLAB, "Icestone Slab");
        this.addBlock(AetherIIBlocks.ICESTONE_WALL, "Icestone Wall");

        // Icestone Bricks
        this.addBlock(AetherIIBlocks.ICESTONE_BRICKS, "Icestone Bricks");
        this.addBlock(AetherIIBlocks.ICESTONE_BRICK_STAIRS, "Icestone Brick Stairs");
        this.addBlock(AetherIIBlocks.ICESTONE_BRICK_SLAB, "Icestone Brick Slab");
        this.addBlock(AetherIIBlocks.ICESTONE_BRICK_WALL, "Icestone Brick Wall");

        // Icestone Decorative Blocks
        this.addBlock(AetherIIBlocks.ICESTONE_FLAGSTONES, "Icestone Flagstones");
        this.addBlock(AetherIIBlocks.ICESTONE_KEYSTONE, "Icestone Keystone");
        this.addBlock(AetherIIBlocks.ICESTONE_BASE_BRICKS, "Icestone Base Bricks");
        this.addBlock(AetherIIBlocks.ICESTONE_CAPSTONE_BRICKS, "Icestone Capstone Bricks");
        this.addBlock(AetherIIBlocks.ICESTONE_BASE_PILLAR, "Icestone Base Pillar");
        this.addBlock(AetherIIBlocks.ICESTONE_CAPSTONE_PILLAR, "Icestone Capstone Pillar");
        this.addBlock(AetherIIBlocks.ICESTONE_PILLAR, "Icestone Pillar");

        // Glass
        this.addBlock(AetherIIBlocks.QUICKSOIL_GLASS, "Quicksoil Glass");
        this.addBlock(AetherIIBlocks.TILED_QUICKSOIL_GLASS, "Tiled Quicksoil Glass");
        this.addBlock(AetherIIBlocks.GRIDDED_QUICKSOIL_GLASS, "Gridded Quicksoil Glass");
        this.addBlock(AetherIIBlocks.SKYROOT_FRAMED_CRUDE_SCATTERGLASS, "Skyroot Framed Crude Scatterglass");
        this.addBlock(AetherIIBlocks.ARKENIUM_FRAMED_CRUDE_SCATTERGLASS, "Arkenium Framed Crude Scatterglass");
        this.addBlock(AetherIIBlocks.SCATTERGLASS, "Scatterglass");
        this.addBlock(AetherIIBlocks.SKYROOT_FRAMED_SCATTERGLASS, "Skyroot Framed Scatterglass");
        this.addBlock(AetherIIBlocks.ARKENIUM_FRAMED_SCATTERGLASS, "Arkenium Framed Scatterglass");

        // Glass Panes
        this.addBlock(AetherIIBlocks.QUICKSOIL_GLASS_PANE, "Quicksoil Glass Pane");
        this.addBlock(AetherIIBlocks.TILED_QUICKSOIL_GLASS_PANE, "Tiled Quicksoil Glass Pane");
        this.addBlock(AetherIIBlocks.GRIDDED_QUICKSOIL_GLASS_PANE, "Gridded Quicksoil Glass Pane");
        this.addBlock(AetherIIBlocks.CRUDE_SCATTERGLASS_PANE, "Crude Scatterglass Pane");
        this.addBlock(AetherIIBlocks.SKYROOT_FRAMED_CRUDE_SCATTERGLASS_PANE, "Skyroot Framed Crude Scatterglass Pane");
        this.addBlock(AetherIIBlocks.ARKENIUM_FRAMED_CRUDE_SCATTERGLASS_PANE, "Arkenium Framed Crude Scatterglass Pane");
        this.addBlock(AetherIIBlocks.SCATTERGLASS_PANE, "Scatterglass Pane");
        this.addBlock(AetherIIBlocks.SKYROOT_FRAMED_SCATTERGLASS_PANE, "Skyroot Framed Scatterglass Pane");
        this.addBlock(AetherIIBlocks.ARKENIUM_FRAMED_SCATTERGLASS_PANE, "Arkenium Framed Scatterglass Pane");

        // Wool
        this.addBlock(AetherIIBlocks.CLOUDWOOL, "Cloudwool");
        this.addBlock(AetherIIBlocks.WHITE_CLOUDWOOL, "White Cloudwool");
        this.addBlock(AetherIIBlocks.ORANGE_CLOUDWOOL, "Orange Cloudwool");
        this.addBlock(AetherIIBlocks.MAGENTA_CLOUDWOOL, "Magenta Cloudwool");
        this.addBlock(AetherIIBlocks.LIGHT_BLUE_CLOUDWOOL, "Light Blue Cloudwool");
        this.addBlock(AetherIIBlocks.YELLOW_CLOUDWOOL, "Yellow Cloudwool");
        this.addBlock(AetherIIBlocks.LIME_CLOUDWOOL, "Lime Cloudwool");
        this.addBlock(AetherIIBlocks.PINK_CLOUDWOOL, "Pink Cloudwool");
        this.addBlock(AetherIIBlocks.GRAY_CLOUDWOOL, "Gray Cloudwool");
        this.addBlock(AetherIIBlocks.LIGHT_GRAY_CLOUDWOOL, "Light Gray Cloudwool");
        this.addBlock(AetherIIBlocks.CYAN_CLOUDWOOL, "Cyan Cloudwool");
        this.addBlock(AetherIIBlocks.PURPLE_CLOUDWOOL, "Purple Cloudwool");
        this.addBlock(AetherIIBlocks.BLUE_CLOUDWOOL, "Blue Cloudwool");
        this.addBlock(AetherIIBlocks.BROWN_CLOUDWOOL, "Brown Cloudwool");
        this.addBlock(AetherIIBlocks.GREEN_CLOUDWOOL, "Green Cloudwool");
        this.addBlock(AetherIIBlocks.RED_CLOUDWOOL, "Red Cloudwool");
        this.addBlock(AetherIIBlocks.BLACK_CLOUDWOOL, "Black Cloudwool");

        // Carpet
        this.addBlock(AetherIIBlocks.CLOUDWOOL_CARPET, "Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.WHITE_CLOUDWOOL_CARPET, "White Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.ORANGE_CLOUDWOOL_CARPET, "Orange Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.MAGENTA_CLOUDWOOL_CARPET, "Magenta Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.LIGHT_BLUE_CLOUDWOOL_CARPET, "Light Blue Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.YELLOW_CLOUDWOOL_CARPET, "Yellow Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.LIME_CLOUDWOOL_CARPET, "Lime Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.PINK_CLOUDWOOL_CARPET, "Pink Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.GRAY_CLOUDWOOL_CARPET, "Gray Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.LIGHT_GRAY_CLOUDWOOL_CARPET, "Light Gray Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.CYAN_CLOUDWOOL_CARPET, "Cyan Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.PURPLE_CLOUDWOOL_CARPET, "Purple Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.BLUE_CLOUDWOOL_CARPET, "Blue Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.BROWN_CLOUDWOOL_CARPET, "Brown Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.GREEN_CLOUDWOOL_CARPET, "Green Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.RED_CLOUDWOOL_CARPET, "Red Cloudwool Carpet");
        this.addBlock(AetherIIBlocks.BLACK_CLOUDWOOL_CARPET, "Black Cloudwool Carpet");

        // Arkenium Blocks
        this.addBlock(AetherIIBlocks.ARKENIUM_DOOR, "Arkenium Door");
        this.addBlock(AetherIIBlocks.ARKENIUM_TRAPDOOR, "Arkenium Trapdoor");

        // Mineral Blocks
        this.addBlock(AetherIIBlocks.AMBROSIUM_BLOCK, "Block of Ambrosium");
        this.addBlock(AetherIIBlocks.ZANITE_BLOCK, "Block of Zanite");
        this.addBlock(AetherIIBlocks.ARKENIUM_BLOCK, "Block of Arkenium");
        this.addBlock(AetherIIBlocks.GRAVITITE_BLOCK, "Block of Gravitite");

        // Arilum Lantern
        this.addBlock(AetherIIBlocks.GREEN_ARILUM_LANTERN, "Green Arilum Lantern");
        this.addBlock(AetherIIBlocks.BLUE_ARILUM_LANTERN, "Blue Arilum Lantern");
        this.addBlock(AetherIIBlocks.PURPLE_ARILUM_LANTERN, "Purple Arilum Lantern");
        this.addBlock(AetherIIBlocks.GOLDEN_ARILUM_LANTERN, "Golden Arilum Lantern");

        // Utility
        this.addBlock(AetherIIBlocks.AMBROSIUM_TORCH, "Ambrosium Torch");
        this.addBlock(AetherIIBlocks.SKYROOT_CRAFTING_TABLE, "Skyroot Crafting Table");
        this.addBlock(AetherIIBlocks.HOLYSTONE_FURNACE, "Holystone Furnace");
        this.addBlock(AetherIIBlocks.ALTAR, "Altar");
        this.addBlock(AetherIIBlocks.ARTISANS_BENCH, "Artisan's Bench");
        this.addBlock(AetherIIBlocks.ARKENIUM_FORGE, "Arkenium Forge");
        this.addBlock(AetherIIBlocks.SKYROOT_CHEST, "Skyroot Chest");
        this.addBlock(AetherIIBlocks.SKYROOT_LADDER, "Skyroot Ladder");
        this.addBlock(AetherIIBlocks.SKYROOT_BED, "Skyroot Bed");

        this.addBlock(AetherIIBlocks.SKYROOT_SIGN, "Skyroot Sign");
        this.addBlock(AetherIIBlocks.SKYROOT_HANGING_SIGN, "Skyroot Hanging Sign");

        this.addBlock(AetherIIBlocks.GREATROOT_SIGN, "Greatroot Sign");
        this.addBlock(AetherIIBlocks.GREATROOT_HANGING_SIGN, "Greatroot Hanging Sign");

        this.addBlock(AetherIIBlocks.WISPROOT_SIGN, "Wisproot Sign");
        this.addBlock(AetherIIBlocks.WISPROOT_HANGING_SIGN, "Wisproot Hanging Sign");

        // Bookshelves
        this.addBlock(AetherIIBlocks.SKYROOT_BOOKSHELF, "Skyroot Bookshelf");
        this.addBlock(AetherIIBlocks.HOLYSTONE_BOOKSHELF, "Holystone Bookshelf");

        // Furniture
        this.addBlock(AetherIIBlocks.OUTPOST_CAMPFIRE, "Outpost Campfire");


        // Items
        // Tools
        this.addItem(AetherIIItems.SKYROOT_PICKAXE, "Skyroot Pickaxe");
        this.addItem(AetherIIItems.SKYROOT_AXE, "Skyroot Axe");
        this.addItem(AetherIIItems.SKYROOT_SHOVEL, "Skyroot Shovel");
        this.addItem(AetherIIItems.SKYROOT_TROWEL, "Skyroot Trowel");

        this.addItem(AetherIIItems.HOLYSTONE_PICKAXE, "Holystone Pickaxe");
        this.addItem(AetherIIItems.HOLYSTONE_AXE, "Holystone Axe");
        this.addItem(AetherIIItems.HOLYSTONE_SHOVEL, "Holystone Shovel");
        this.addItem(AetherIIItems.HOLYSTONE_TROWEL, "Holystone Trowel");

        this.addItem(AetherIIItems.ZANITE_PICKAXE, "Zanite Pickaxe");
        this.addItem(AetherIIItems.ZANITE_AXE, "Zanite Axe");
        this.addItem(AetherIIItems.ZANITE_SHOVEL, "Zanite Shovel");
        this.addItem(AetherIIItems.ZANITE_TROWEL, "Zanite Trowel");

        this.addItem(AetherIIItems.ARKENIUM_PICKAXE, "Arkenium Pickaxe");
        this.addItem(AetherIIItems.ARKENIUM_AXE, "Arkenium Axe");
        this.addItem(AetherIIItems.ARKENIUM_SHOVEL, "Arkenium Shovel");
        this.addItem(AetherIIItems.ARKENIUM_TROWEL, "Arkenium Trowel");

        this.addItem(AetherIIItems.GRAVITITE_PICKAXE, "Gravitite Pickaxe");
        this.addItem(AetherIIItems.GRAVITITE_AXE, "Gravitite Axe");
        this.addItem(AetherIIItems.GRAVITITE_SHOVEL, "Gravitite Shovel");
        this.addItem(AetherIIItems.GRAVITITE_TROWEL, "Gravitite Trowel");

        this.addItem(AetherIIItems.ARKENIUM_SHEARS, "Arkenium Shears");

        // Combat
        this.addItem(AetherIIItems.SKYROOT_SHORTSWORD, "Skyroot Shortsword");
        this.addItem(AetherIIItems.SKYROOT_HAMMER, "Skyroot Hammer");
        this.addItem(AetherIIItems.SKYROOT_SPEAR, "Skyroot Spear");
        this.addItem(AetherIIItems.SKYROOT_CROSSBOW, "Skyroot Crossbow");
        this.addItem(AetherIIItems.SKYROOT_SHIELD, "Skyroot Shield");

        this.addItem(AetherIIItems.HOLYSTONE_SHORTSWORD, "Holystone Shortsword");
        this.addItem(AetherIIItems.HOLYSTONE_HAMMER, "Holystone Hammer");
        this.addItem(AetherIIItems.HOLYSTONE_SPEAR, "Holystone Spear");
        this.addItem(AetherIIItems.HOLYSTONE_CROSSBOW, "Holystone Crossbow");
        this.addItem(AetherIIItems.HOLYSTONE_SHIELD, "Holystone Shield");

        this.addItem(AetherIIItems.ZANITE_SHORTSWORD, "Zanite Shortsword");
        this.addItem(AetherIIItems.ZANITE_HAMMER, "Zanite Hammer");
        this.addItem(AetherIIItems.ZANITE_SPEAR, "Zanite Spear");
        this.addItem(AetherIIItems.ZANITE_CROSSBOW, "Zanite Crossbow");
        this.addItem(AetherIIItems.ZANITE_SHIELD, "Zanite Shield");

        this.addItem(AetherIIItems.ARKENIUM_SHORTSWORD, "Arkenium Shortsword");
        this.addItem(AetherIIItems.ARKENIUM_HAMMER, "Arkenium Hammer");
        this.addItem(AetherIIItems.ARKENIUM_SPEAR, "Arkenium Spear");
        this.addItem(AetherIIItems.ARKENIUM_CROSSBOW, "Arkenium Crossbow");
        this.addItem(AetherIIItems.ARKENIUM_SHIELD, "Arkenium Shield");

        this.addItem(AetherIIItems.GRAVITITE_SHORTSWORD, "Gravitite Shortsword");
        this.addItem(AetherIIItems.GRAVITITE_HAMMER, "Gravitite Hammer");
        this.addItem(AetherIIItems.GRAVITITE_SPEAR, "Gravitite Spear");
        this.addItem(AetherIIItems.GRAVITITE_CROSSBOW, "Gravitite Crossbow");
        this.addItem(AetherIIItems.GRAVITITE_SHIELD, "Gravitite Shield");

        this.addItem(AetherIIItems.SCATTERGLASS_BOLT, "Scatterglass Bolt");

        // Armor
        this.addItem(AetherIIItems.TAEGORE_HIDE_HELMET, "Taegore Hide Cap");
        this.addItem(AetherIIItems.TAEGORE_HIDE_CHESTPLATE, "Taegore Hide Tunic");
        this.addItem(AetherIIItems.TAEGORE_HIDE_LEGGINGS, "Taegore Hide Pants");
        this.addItem(AetherIIItems.TAEGORE_HIDE_BOOTS, "Taegore Hide Boots");
        this.addItem(AetherIIItems.TAEGORE_HIDE_GLOVES, "Taegore Hide Gloves");

        this.addItem(AetherIIItems.BURRUKAI_PELT_HELMET, "Burrukai Pelt Cap");
        this.addItem(AetherIIItems.BURRUKAI_PELT_CHESTPLATE, "Burrukai Pelt Tunic");
        this.addItem(AetherIIItems.BURRUKAI_PELT_LEGGINGS, "Burrukai Pelt Pants");
        this.addItem(AetherIIItems.BURRUKAI_PELT_BOOTS, "Burrukai Pelt Boots");
        this.addItem(AetherIIItems.BURRUKAI_PELT_GLOVES, "Burrukai Pelt Gloves");

        this.addItem(AetherIIItems.ZANITE_HELMET, "Zanite Helmet");
        this.addItem(AetherIIItems.ZANITE_CHESTPLATE, "Zanite Chestplate");
        this.addItem(AetherIIItems.ZANITE_LEGGINGS, "Zanite Leggings");
        this.addItem(AetherIIItems.ZANITE_BOOTS, "Zanite Boots");
        this.addItem(AetherIIItems.ZANITE_GLOVES, "Zanite Gauntlets");

        this.addItem(AetherIIItems.ARKENIUM_HELMET, "Arkenium Helmet");
        this.addItem(AetherIIItems.ARKENIUM_CHESTPLATE, "Arkenium Chestplate");
        this.addItem(AetherIIItems.ARKENIUM_LEGGINGS, "Arkenium Leggings");
        this.addItem(AetherIIItems.ARKENIUM_BOOTS, "Arkenium Boots");
        this.addItem(AetherIIItems.ARKENIUM_GLOVES, "Arkenium Gauntlets");

        this.addItem(AetherIIItems.GRAVITITE_HELMET, "Gravitite Helmet");
        this.addItem(AetherIIItems.GRAVITITE_CHESTPLATE, "Gravitite Chestplate");
        this.addItem(AetherIIItems.GRAVITITE_LEGGINGS, "Gravitite Leggings");
        this.addItem(AetherIIItems.GRAVITITE_BOOTS, "Gravitite Boots");
        this.addItem(AetherIIItems.GRAVITITE_GLOVES, "Gravitite Gauntlets");

        // Materials
        this.addItem(AetherIIItems.SKYROOT_STICK, "Skyroot Stick");
        this.addItem(AetherIIItems.SCATTERGLASS_SHARD, "Scatterglass Shard");
        this.addItem(AetherIIItems.AMBROSIUM_SHARD, "Ambrosium Shard");
        this.addItem(AetherIIItems.ZANITE_GEMSTONE, "Zanite Gemstone");
        this.addItem(AetherIIItems.INERT_ARKENIUM, "Inert Arkenium");
        this.addItem(AetherIIItems.ARKENIUM_PLATES, "Arkenium Plates");
        this.addItem(AetherIIItems.INERT_GRAVITITE, "Inert Gravitite");
        this.addItem(AetherIIItems.GRAVITITE_PLATE, "Gravitite Plate");
        this.addItem(AetherIIItems.CORROBONITE_CRYSTAL, "Corrobonite Crystal");
        this.addItem(AetherIIItems.GLINT_GEMSTONE, "Glint Gemstone");
        this.addItem(AetherIIItems.GOLDEN_AMBER, "Golden Amber");
        this.addItem(AetherIIItems.CLOUDTWINE, "Cloudtwine");
        this.addItem(AetherIIItems.TAEGORE_HIDE, "Taegore Hide");
        this.addItem(AetherIIItems.BURRUKAI_PELT, "Burrukai Pelt");
        this.addItem(AetherIIItems.SKYROOT_PINECONE, "Skyroot Pinecone");
        this.addItem(AetherIIItems.VALKYRIE_WINGS, "Valkyrie Wings");
        this.addItem(AetherIIItems.BRETTL_CANE, "Brettl Cane");
        this.addItem(AetherIIItems.BRETTL_GRASS, "Brettl Grass");
        this.addItem(AetherIIItems.BRETTL_ROPE, "Brettl Rope");
        this.addItem(AetherIIItems.BRETTL_FLOWER, "Brettl Flower");
        this.addItem(AetherIIItems.AECHOR_PETAL, "Aechor Petal");
        this.addItem(AetherIIItems.ARILUM_BULBS, "Arilum Bulbs");
        this.addItem(AetherIIItems.ARCTIC_SNOWBALL, "Arctic Snowball");
        this.addItem(AetherIIItems.GREEN_SWET_GEL, "Green Swet Gel");
        this.addItem(AetherIIItems.BLUE_SWET_GEL, "Blue Swet Gel");
        this.addItem(AetherIIItems.PURPLE_SWET_GEL, "Purple Swet Gel");
        this.addItem(AetherIIItems.GOLDEN_SWET_GEL, "Golden Swet Gel");
        this.addItem(AetherIIItems.SWET_SUGAR, "Swet Sugar");
        this.addItem(AetherIIItems.MOA_FEATHER, "Moa Feather");
        this.addItem(AetherIIItems.COCKATRICE_FEATHER, "Cockatrice Feather");
        this.addItem(AetherIIItems.SCATTERGLASS_VIAL, "Scatterglass Vial");
        this.addItem(AetherIIItems.CHARGE_CORE, "Charge Core");

        // Irradiated Items
        this.addItem(AetherIIItems.IRRADIATED_ARMOR, "Irradiated Armor");
        this.addItem(AetherIIItems.IRRADIATED_WEAPON, "Irradiated Weapon");
        this.addItem(AetherIIItems.IRRADIATED_TOOL, "Irradiated Tool");
        this.addItem(AetherIIItems.IRRADIATED_CHUNK, "Irradiated Chunk");
        this.addItem(AetherIIItems.IRRADIATED_DUST, "Irradiated Dust");

        // Food
        this.addItem(AetherIIItems.BLUEBERRY, "Blueberry");
        this.addItem(AetherIIItems.ENCHANTED_BLUEBERRY, "Enchanted Blueberry");
        this.addItem(AetherIIItems.ORANGE, "Orange");
        this.addItem(AetherIIItems.SATIVAL_BULB, "Satival Bulb");
        this.addItem(AetherIIItems.WYNDBERRY, "Wyndberry");
        this.addItem(AetherIIItems.ENCHANTED_WYNDBERRY, "Enchanted Wyndberry");
        this.addItem(AetherIIItems.GREEN_SWET_JELLY, "Green Swet Jelly");
        this.addItem(AetherIIItems.BLUE_SWET_JELLY, "Blue Swet Jelly");
        this.addItem(AetherIIItems.PURPLE_SWET_JELLY, "Purple Swet Jelly");
        this.addItem(AetherIIItems.GOLDEN_SWET_JELLY, "Golden Swet Jelly");
        this.addItem(AetherIIItems.BURRUKAI_RIBS, "Burrukai Ribs");
        this.addItem(AetherIIItems.BURRUKAI_RIB_CUT, "Burrukai Rib Cut");
        this.addItem(AetherIIItems.KIRRID_CUTLET, "Kirrid Cutlet");
        this.addItem(AetherIIItems.KIRRID_LOIN, "Kirrid Loin");
        this.addItem(AetherIIItems.RAW_TAEGORE_MEAT, "Raw Taegore Meat");
        this.addItem(AetherIIItems.TAEGORE_STEAK, "Taegore Steak");
        this.addItem(AetherIIItems.SKYROOT_LIZARD_ON_A_STICK, "Skyroot Lizard on a Stick");
        this.addItem(AetherIIItems.ROASTED_SKYROOT_LIZARD_ON_A_STICK, "Roasted Skyroot Lizard on a Stick");

        // Consumables
        this.addItem(AetherIIItems.WATER_VIAL, "Water Vial");
        this.addItem(AetherIIItems.BANDAGE, "Bandage");
        this.addItem(AetherIIItems.SPLINT, "Splint");
        this.addItem(AetherIIItems.ANTITOXIN_VIAL, "Antitoxin Vial");
        this.addItem(AetherIIItems.ANTIVENOM_VIAL, "Antivenom Vial");
        this.addItem(AetherIIItems.VALKYRIE_TEA, "Valkyrie Tea");
        this.addItem(AetherIIItems.HEALING_STONE, "Healing Stone");

        // Gliders
        this.addItem(AetherIIItems.COLD_AERCLOUD_GLIDER, "Cold Aercloud Glider");
        this.addItem(AetherIIItems.GOLDEN_AERCLOUD_GLIDER, "Golden Aercloud Glider");
        this.addItem(AetherIIItems.BLUE_AERCLOUD_GLIDER, "Blue Aercloud Glider");
        this.addItem(AetherIIItems.PURPLE_AERCLOUD_GLIDER, "Purple Aercloud Glider");

        // Skyroot Buckets
        this.addItem(AetherIIItems.SKYROOT_BUCKET, "Skyroot Bucket");
        this.addItem(AetherIIItems.SKYROOT_WATER_BUCKET, "Skyroot Water Bucket");
        this.addItem(AetherIIItems.SKYROOT_MILK_BUCKET, "Skyroot Milk Bucket");
        this.addItem(AetherIIItems.SKYROOT_POWDER_SNOW_BUCKET, "Skyroot Powder Snow Bucket");
        this.addItem(AetherIIItems.SKYROOT_COD_BUCKET, "Skyroot Bucket of Cod");
        this.addItem(AetherIIItems.SKYROOT_SALMON_BUCKET, "Skyroot Bucket of Salmon");
        this.addItem(AetherIIItems.SKYROOT_PUFFERFISH_BUCKET, "Skyroot Bucket of Pufferfish");
        this.addItem(AetherIIItems.SKYROOT_TROPICAL_FISH_BUCKET, "Skyroot Bucket of Tropical Fish");
        this.addItem(AetherIIItems.SKYROOT_AXOLOTL_BUCKET, "Skyroot Bucket of Axolotl");
        this.addItem(AetherIIItems.SKYROOT_TADPOLE_BUCKET, "Skyroot Bucket of Tadpole");

        // Arkenium Canisters
        this.addItem(AetherIIItems.ARKENIUM_CANISTER, "Arkenium Canister");
        this.addItem(AetherIIItems.ARKENIUM_ACID_CANISTER, "Arkenium Acid Canister");
        this.addItem(AetherIIItems.ARKENIUM_GAS_CANISTER, "Arkenium Gas Canister");

        // Music Discs
        this.addItem(AetherIIItems.MUSIC_DISC_AETHER_TUNE, "Blue Music Disc");
        this.addItem(AetherIIItems.MUSIC_DISC_ASCENDING_DAWN, "Valkyrie Music Disc");
        this.addItem(AetherIIItems.MUSIC_DISC_AERWHALE, "Aerwhale Music Disc");
        this.addItem(AetherIIItems.MUSIC_DISC_APPROACHES, "Moa Music Disc");
        this.addItem(AetherIIItems.MUSIC_DISC_DEMISE, "Labyrinth Music Disc");
        this.addItem(AetherIIItems.RECORDING_892, "Recording #892");

        // Spawn Eggs
        this.addItem(AetherIIItems.AERBUNNY_SPAWN_EGG, "Aerbunny Spawn Egg");
        this.addItem(AetherIIItems.FLYING_COW_SPAWN_EGG, "Flying Cow Spawn Egg");
        this.addItem(AetherIIItems.SHEEPUFF_SPAWN_EGG, "Sheepuff Spawn Egg");
        this.addItem(AetherIIItems.PHYG_SPAWN_EGG, "Phyg Spawn Egg");
        this.addItem(AetherIIItems.HIGHFIELDS_TAEGORE_SPAWN_EGG, "Taegore Spawn Egg");
        this.addItem(AetherIIItems.MAGNETIC_TAEGORE_SPAWN_EGG, "Taegore Spawn Egg");
        this.addItem(AetherIIItems.ARCTIC_TAEGORE_SPAWN_EGG, "Taegore Spawn Egg");
        this.addItem(AetherIIItems.HIGHFIELDS_BURRUKAI_SPAWN_EGG, "Burrukai Spawn Egg");
        this.addItem(AetherIIItems.MAGNETIC_BURRUKAI_SPAWN_EGG, "Burrukai Spawn Egg");
        this.addItem(AetherIIItems.ARCTIC_BURRUKAI_SPAWN_EGG, "Burrukai Spawn Egg");
        this.addItem(AetherIIItems.HIGHFIELDS_KIRRID_SPAWN_EGG, "Kirrid Spawn Egg");
        this.addItem(AetherIIItems.MAGNETIC_KIRRID_SPAWN_EGG, "Kirrid Spawn Egg");
        this.addItem(AetherIIItems.ARCTIC_KIRRID_SPAWN_EGG, "Kirrid Spawn Egg");
        this.addItem(AetherIIItems.MOA_SPAWN_EGG, "Moa Spawn Egg");
        this.addItem(AetherIIItems.SKYROOT_LIZARD_SPAWN_EGG, "Skyroot Lizard Spawn Egg");
        this.addItem(AetherIIItems.AECHOR_PLANT_SPAWN_EGG, "Aechor Plant Spawn Egg");
        this.addItem(AetherIIItems.CARRION_SPROUT_SPAWN_EGG, "Carrion Sprout Spawn Egg");
        this.addItem(AetherIIItems.ZEPHYR_SPAWN_EGG, "Zephyr Spawn Egg");
        this.addItem(AetherIIItems.TEMPEST_SPAWN_EGG, "Tempest Spawn Egg");
        this.addItem(AetherIIItems.COCKATRICE_SPAWN_EGG, "Cockatrice Spawn Egg");
        this.addItem(AetherIIItems.SWET_SPAWN_EGG, "Swet Spawn Egg");
        this.addItem(AetherIIItems.SKEPHID_SPAWN_EGG, "Skephid Spawn Egg");

        // Misc
        this.addItem(AetherIIItems.MOA_EGG, "Moa Egg");
        this.addItem(AetherIIItems.MOA_FEED, "Moa Feed");
        this.addItem(AetherIIItems.BLUEBERRY_MOA_FEED, "Blueberry Moa Feed");
        this.addItem(AetherIIItems.ENCHANTED_MOA_FEED, "Enchanted Moa Feed");
        this.addItem(AetherIIItems.MOA_SADDLE, "Moa Saddle");
        this.addItem(AetherIIItems.GLINT_COIN, "Glint Coin");
        this.addItem(AetherIIItems.AETHER_PORTAL_FRAME, "Aether Portal Frame");

        // Tooltips
        // Abilities
        this.addPerItemAbilityTooltip(AetherIIItems.SKYROOT_PICKAXE.get(), 1, "§9Ability:§r Increases Yield");
        this.addPerItemAbilityTooltip(AetherIIItems.SKYROOT_AXE.get(), 1, "§9Ability:§r Increases Yield");
        this.addPerItemAbilityTooltip(AetherIIItems.SKYROOT_SHOVEL.get(), 1, "§9Ability:§r Increases Yield");
        this.addPerItemAbilityTooltip(AetherIIItems.SKYROOT_TROWEL.get(), 1, "§9Ability:§r Increases Yield");
        this.addPerItemAbilityTooltip(AetherIIItems.SKYROOT_SHORTSWORD.get(), 1, "§9Ability:§r Increases Yield");
        this.addPerItemAbilityTooltip(AetherIIItems.SKYROOT_HAMMER.get(), 1, "§9Ability:§r Increases Yield");
        this.addPerItemAbilityTooltip(AetherIIItems.SKYROOT_SPEAR.get(), 1, "§9Ability:§r Increases Yield");
        this.addPerItemAbilityTooltip(AetherIIItems.SKYROOT_CROSSBOW.get(), 1, "§9Ability:§r Double Shot");
        this.addPerItemAbilityTooltip(AetherIIItems.SKYROOT_CROSSBOW.get(), 2, "§3Use:§r Crouch-Use");

        this.addPerItemAbilityTooltip(AetherIIItems.HOLYSTONE_PICKAXE.get(), 1, "§9Ability:§r Sheds Ambrosium");
        this.addPerItemAbilityTooltip(AetherIIItems.HOLYSTONE_AXE.get(), 1, "§9Ability:§r Sheds Ambrosium");
        this.addPerItemAbilityTooltip(AetherIIItems.HOLYSTONE_SHOVEL.get(), 1, "§9Ability:§r Sheds Ambrosium");
        this.addPerItemAbilityTooltip(AetherIIItems.HOLYSTONE_TROWEL.get(), 1, "§9Ability:§r Sheds Ambrosium");
        this.addPerItemAbilityTooltip(AetherIIItems.HOLYSTONE_SHORTSWORD.get(), 1, "§9Ability:§r Sheds Ambrosium");
        this.addPerItemAbilityTooltip(AetherIIItems.HOLYSTONE_HAMMER.get(), 1, "§9Ability:§r Sheds Ambrosium");
        this.addPerItemAbilityTooltip(AetherIIItems.HOLYSTONE_SPEAR.get(), 1, "§9Ability:§r Sheds Ambrosium");
        this.addPerItemAbilityTooltip(AetherIIItems.HOLYSTONE_CROSSBOW.get(), 1, "§9Ability:§r Spread Shot");
        this.addPerItemAbilityTooltip(AetherIIItems.HOLYSTONE_CROSSBOW.get(), 2, "§3Use:§r Crouch-Use");

        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_PICKAXE.get(), 1, "§9Ability:§r Grows Stronger");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_AXE.get(), 1, "§9Ability:§r Grows Stronger");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_SHOVEL.get(), 1, "§9Ability:§r Grows Stronger");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_TROWEL.get(), 1, "§9Ability:§r Grows Stronger");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_SHORTSWORD.get(), 1, "§9Ability:§r Grows Stronger");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_HAMMER.get(), 1, "§9Ability:§r Grows Stronger");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_SPEAR.get(), 1, "§9Ability:§r Grows Stronger");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_CROSSBOW.get(), 1, "§9Ability:§r Grows Stronger");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_CROSSBOW.get(), 2, "§3Use:§r Crouch-Use");

        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_PICKAXE.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_AXE.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_SHOVEL.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_TROWEL.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_SHORTSWORD.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_HAMMER.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_SPEAR.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_CROSSBOW.get(), 1, "§9Ability:§r Upgrades Further");

        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_PICKAXE.get(), 1, "§9Ability:§r Levitates Block");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_PICKAXE.get(), 2, "§3Use:§r Crouch-Interact");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_AXE.get(), 1, "§9Ability:§r Levitates Block");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_AXE.get(), 2, "§3Use:§r Crouch-Interact");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_SHOVEL.get(), 1, "§9Ability:§r Levitates Block");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_SHOVEL.get(), 2, "§3Use:§r Crouch-Interact");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_TROWEL.get(), 1, "§9Ability:§r Levitates Block");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_TROWEL.get(), 2, "§3Use:§r Crouch-Interact");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_SHORTSWORD.get(), 1, "§9Ability:§r Shifts Gravity");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_HAMMER.get(), 1, "§9Ability:§r Shifts Gravity");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_SPEAR.get(), 1, "§9Ability:§r Shifts Gravity");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_CROSSBOW.get(), 1, "§9Ability:§r Straight Shot");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_CROSSBOW.get(), 2, "§3Use:§r Crouch-Use");

        this.addPerItemAbilityTooltip(AetherIIItems.TAEGORE_HIDE_BOOTS.get(), 1, "§9Ability:§r Calms Animals");
        this.addPerItemAbilityTooltip(AetherIIItems.TAEGORE_HIDE_BOOTS.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.TAEGORE_HIDE_LEGGINGS.get(), 1, "§9Ability:§r Calms Animals");
        this.addPerItemAbilityTooltip(AetherIIItems.TAEGORE_HIDE_LEGGINGS.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.TAEGORE_HIDE_CHESTPLATE.get(), 1, "§9Ability:§r Calms Animals");
        this.addPerItemAbilityTooltip(AetherIIItems.TAEGORE_HIDE_CHESTPLATE.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.TAEGORE_HIDE_HELMET.get(), 1, "§9Ability:§r Calms Animals");
        this.addPerItemAbilityTooltip(AetherIIItems.TAEGORE_HIDE_HELMET.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.TAEGORE_HIDE_GLOVES.get(), 1, "§9Ability:§r Calms Animals");
        this.addPerItemAbilityTooltip(AetherIIItems.TAEGORE_HIDE_GLOVES.get(), 2, "§9Set Pieces:§r %s");

        this.addPerItemAbilityTooltip(AetherIIItems.BURRUKAI_PELT_BOOTS.get(), 1, "§9Ability:§r Stun Resistance");
        this.addPerItemAbilityTooltip(AetherIIItems.BURRUKAI_PELT_BOOTS.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.BURRUKAI_PELT_LEGGINGS.get(), 1, "§9Ability:§r Stun Resistance");
        this.addPerItemAbilityTooltip(AetherIIItems.BURRUKAI_PELT_LEGGINGS.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.BURRUKAI_PELT_CHESTPLATE.get(), 1, "§9Ability:§r Stun Resistance");
        this.addPerItemAbilityTooltip(AetherIIItems.BURRUKAI_PELT_CHESTPLATE.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.BURRUKAI_PELT_HELMET.get(), 1, "§9Ability:§r Stun Resistance");
        this.addPerItemAbilityTooltip(AetherIIItems.BURRUKAI_PELT_HELMET.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.BURRUKAI_PELT_GLOVES.get(), 1, "§9Ability:§r Stun Resistance");
        this.addPerItemAbilityTooltip(AetherIIItems.BURRUKAI_PELT_GLOVES.get(), 2, "§9Set Pieces:§r %s");

        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_BOOTS.get(), 1, "§9Ability:§r Speed Boost");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_BOOTS.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_LEGGINGS.get(), 1, "§9Ability:§r Speed Boost");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_LEGGINGS.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_CHESTPLATE.get(), 1, "§9Ability:§r Speed Boost");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_CHESTPLATE.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_HELMET.get(), 1, "§9Ability:§r Speed Boost");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_HELMET.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_GLOVES.get(), 1, "§9Ability:§r Speed Boost");
        this.addPerItemAbilityTooltip(AetherIIItems.ZANITE_GLOVES.get(), 2, "§9Set Pieces:§r %s");

        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_BOOTS.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_BOOTS.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_LEGGINGS.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_LEGGINGS.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_CHESTPLATE.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_CHESTPLATE.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_HELMET.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_HELMET.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_GLOVES.get(), 1, "§9Ability:§r Upgrades Further");
        this.addPerItemAbilityTooltip(AetherIIItems.ARKENIUM_GLOVES.get(), 2, "§9Set Pieces:§r %s");

        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_BOOTS.get(), 1, "§9Ability:§r Double Jump");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_BOOTS.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_LEGGINGS.get(), 1, "§9Ability:§r Double Jump");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_LEGGINGS.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_CHESTPLATE.get(), 1, "§9Ability:§r Double Jump");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_CHESTPLATE.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_HELMET.get(), 1, "§9Ability:§r Double Jump");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_HELMET.get(), 2, "§9Set Pieces:§r %s");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_GLOVES.get(), 1, "§9Ability:§r Double Jump");
        this.addPerItemAbilityTooltip(AetherIIItems.GRAVITITE_GLOVES.get(), 2, "§9Set Pieces:§r %s");

        this.addPerItemAbilityTooltip(AetherIIItems.COLD_AERCLOUD_GLIDER.get(), 1, "§3Use:§r Hold-Use");
        this.addPerItemAbilityTooltip(AetherIIItems.GOLDEN_AERCLOUD_GLIDER.get(), 1, "§3Use:§r Hold-Use");
        this.addPerItemAbilityTooltip(AetherIIItems.BLUE_AERCLOUD_GLIDER.get(), 1, "§9Ability:§r Upwards Boost");
        this.addPerItemAbilityTooltip(AetherIIItems.BLUE_AERCLOUD_GLIDER.get(), 2, "§3Use:§r Hold-Use");
        this.addPerItemAbilityTooltip(AetherIIItems.PURPLE_AERCLOUD_GLIDER.get(), 1, "§9Ability:§r Forwards Boost");
        this.addPerItemAbilityTooltip(AetherIIItems.PURPLE_AERCLOUD_GLIDER.get(), 2, "§3Use:§r Hold-Use");


        // Miscellaneous Item Tooltips
        this.addItemTooltip("treasure.description", "Treasure Item");
        this.addItemTooltip("currency.description", "Converts to Currency:");
        this.addItemTooltip("currency.amount", "%s Glint");
        this.addItemTooltip("healing_stone.charges", "%s/5 Charges");

        // Moa Egg Tooltips
        this.addItemTooltip("moa_egg.keratin", "%s Keratin");
        this.addItemTooltip("moa_egg.eyes", "%s Eyes");
        this.addItemTooltip("moa_egg.feathers", "%1$s %2$s Feathers");

        this.addKeratinColor(Moa.KeratinColor.BLUE, "Blue");
        this.addKeratinColor(Moa.KeratinColor.BROWN, "Brown");
        this.addKeratinColor(Moa.KeratinColor.GREEN, "Green");
        this.addKeratinColor(Moa.KeratinColor.GRAY, "Gray");
        this.addKeratinColor(Moa.KeratinColor.RED, "Red");

        this.addEyeColor(Moa.EyeColor.BLUE, "Blue");
        this.addEyeColor(Moa.EyeColor.GREEN, "Green");
        this.addEyeColor(Moa.EyeColor.YELLOW, "Yellow");

        this.addFeatherColor(Moa.FeatherColor.BLACK, "Black");
        this.addFeatherColor(Moa.FeatherColor.BLOOMING_RED, "Blooming Red");
        this.addFeatherColor(Moa.FeatherColor.BLUE, "Blue");
        this.addFeatherColor(Moa.FeatherColor.BROWN, "Brown");
        this.addFeatherColor(Moa.FeatherColor.CLASSIC_BLACK, "Classic Black");
        this.addFeatherColor(Moa.FeatherColor.CYAN, "Cyan");
        this.addFeatherColor(Moa.FeatherColor.GRAY, "Gray");
        this.addFeatherColor(Moa.FeatherColor.GREEN, "Green");
        this.addFeatherColor(Moa.FeatherColor.LIGHT_BLUE, "Light Blue");
        this.addFeatherColor(Moa.FeatherColor.LIGHT_GRAY, "Light Gray");
        this.addFeatherColor(Moa.FeatherColor.LIME, "Lime");
        this.addFeatherColor(Moa.FeatherColor.MAGENTA, "Magenta");
        this.addFeatherColor(Moa.FeatherColor.ORANGE, "Orange");
        this.addFeatherColor(Moa.FeatherColor.PINK, "Pink");
        this.addFeatherColor(Moa.FeatherColor.PURPLE, "Purple");
        this.addFeatherColor(Moa.FeatherColor.RED, "Red");
        this.addFeatherColor(Moa.FeatherColor.WHITE, "White");
        this.addFeatherColor(Moa.FeatherColor.YELLOW, "Yellow");

        this.addFeatherShape(Moa.FeatherShape.CURVED, "Curved");
        this.addFeatherShape(Moa.FeatherShape.FLAT, "Flat");
        this.addFeatherShape(Moa.FeatherShape.POINTED, "Pointed");


        // Accessory Slots
        this.addAccessorySlot("relic_slot", "Relic");
        this.addAccessorySlot("handwear_slot", "Handwear");
        this.addAccessorySlot("accessory_slot", "Accessory");


        // Use Action
        this.addTooltip("item.modifiers.blocking", "When blocking:");


        // Entities
        // Passive
        this.addEntityType(AetherIIEntityTypes.AERBUNNY, "Aerbunny");
        this.addEntityType(AetherIIEntityTypes.PHYG, "Phyg");
        this.addEntityType(AetherIIEntityTypes.FLYING_COW, "Flying Cow");
        this.addEntityType(AetherIIEntityTypes.SHEEPUFF, "Sheepuff");
        this.addEntityType(AetherIIEntityTypes.HIGHFIELDS_TAEGORE, "Highfields Taegore");
        this.addEntityType(AetherIIEntityTypes.MAGNETIC_TAEGORE, "Magnetic Taegore");
        this.addEntityType(AetherIIEntityTypes.ARCTIC_TAEGORE, "Arctic Taegore");
        this.addEntityType(AetherIIEntityTypes.HIGHFIELDS_BURRUKAI, "Highfields Burrukai");
        this.addEntityType(AetherIIEntityTypes.MAGNETIC_BURRUKAI, "Magnetic Burrukai");
        this.addEntityType(AetherIIEntityTypes.ARCTIC_BURRUKAI, "Arctic Burrukai");
        this.addEntityType(AetherIIEntityTypes.HIGHFIELDS_KIRRID, "Highfields Kirrid");
        this.addEntityType(AetherIIEntityTypes.MAGNETIC_KIRRID, "Magnetic Kirrid");
        this.addEntityType(AetherIIEntityTypes.ARCTIC_KIRRID, "Arctic Kirrid");
        this.addEntityType(AetherIIEntityTypes.MOA, "Moa");
        this.addEntityType(AetherIIEntityTypes.SKYROOT_LIZARD, "Skyroot Lizard");

        // Hostile
        this.addEntityType(AetherIIEntityTypes.AECHOR_PLANT, "Aechor Plant");
        this.addEntityType(AetherIIEntityTypes.CARRION_SPROUT, "Carrion Sprout");
        this.addEntityType(AetherIIEntityTypes.ZEPHYR, "Zephyr");
        this.addEntityType(AetherIIEntityTypes.TEMPEST, "Tempest");
        this.addEntityType(AetherIIEntityTypes.COCKATRICE, "Cockatrice");
        this.addEntityType(AetherIIEntityTypes.SWET, "Swet");
        this.addEntityType(AetherIIEntityTypes.SKEPHID, "Skephid");

        // Projectile
        this.addEntityType(AetherIIEntityTypes.HOLYSTONE_ROCK, "Holystone Rock");
        this.addEntityType(AetherIIEntityTypes.ARCTIC_SNOWBALL, "Arctic Snowball");
        this.addEntityType(AetherIIEntityTypes.SKYROOT_PINECONE, "Skyroot Pinecone");
        this.addEntityType(AetherIIEntityTypes.SCATTERGLASS_BOLT, "Scatterglass Bolt");
        this.addEntityType(AetherIIEntityTypes.ZEPHYR_WEBBING_BALL, "Zephyr Webbing Ball");
        this.addEntityType(AetherIIEntityTypes.TEMPEST_THUNDERBALL, "Tempest Thunderball");
        this.addEntityType(AetherIIEntityTypes.SKEPHID_WEBBING_BALL, "Skephid Webbing Ball");
        this.addEntityType(AetherIIEntityTypes.TOXIC_DART, "Toxic Dart");
        this.addEntityType(AetherIIEntityTypes.VENOMOUS_DART, "Venomous Dart");

        // Miscellaneous
        this.addEntityType(AetherIIEntityTypes.ELECTRIC_FIELD, "Electric Field");


        // Dimensions
        this.addDimension(AetherIIDimensions.AETHER_HIGHLANDS_LEVEL, "Aether Highlands");


        // Biomes
        // Highfields
        this.addBiome(HighlandsBiomes.FLOURISHING_FIELD, "Flourishing Field");
        this.addBiome(HighlandsBiomes.VERDANT_WOODS, "Verdant Woods");
        this.addBiome(HighlandsBiomes.SHROUDED_FOREST, "Shrouded Forest");
        this.addBiome(HighlandsBiomes.SHIMMERING_BASIN, "Shimmering Basin");

        // Magnetic
        this.addBiome(HighlandsBiomes.MAGNETIC_SCAR, "Magnetic Scar");
        this.addBiome(HighlandsBiomes.TURQUOISE_FOREST, "Turquoise Forest");
        this.addBiome(HighlandsBiomes.VIOLET_HIGHWOODS, "Violet Highwoods");
        this.addBiome(HighlandsBiomes.GLISTENING_SWAMP, "Glistening Swamp");

        // Arctic
        this.addBiome(HighlandsBiomes.FRIGID_SIERRA, "Frigid Sierra");
        this.addBiome(HighlandsBiomes.ENDURING_WOODLAND, "Enduring Woodland");
        this.addBiome(HighlandsBiomes.FROZEN_LAKES, "Frozen Lakes");
        this.addBiome(HighlandsBiomes.SHEER_TUNDRA, "Sheer Tundra");

        // Irradiated
        this.addBiome(HighlandsBiomes.CONTAMINATED_JUNGLE, "Contaminated Jungle");
        this.addBiome(HighlandsBiomes.BATTLEGROUND_WASTES, "Battleground Wastes");

        // Aercloud Sea
        this.addBiome(HighlandsBiomes.EXPANSE, "Expanse");


        // Structures
        this.addStructure(AetherIIStructures.OUTPOST, "Outpost");


        // Attributes
        this.addAttribute(AetherIIAttributes.SLASH_DAMAGE.get(), "§9Slash§r Damage");
        this.addAttribute(AetherIIAttributes.IMPACT_DAMAGE.get(), "§eImpact§r Damage");
        this.addAttribute(AetherIIAttributes.PIERCE_DAMAGE.get(), "§cPierce§r Damage");
        this.addAttribute(AetherIIAttributes.SLASH_RESISTANCE.get(), "§9Slash§r Resistance");
        this.addAttribute(AetherIIAttributes.IMPACT_RESISTANCE.get(), "§eImpact§r Resistance");
        this.addAttribute(AetherIIAttributes.PIERCE_RESISTANCE.get(), "§cPierce§r Resistance");
        this.addAttribute(AetherIIAttributes.SWEEP_RANGE.get(), "Sweep Range");
        this.addAttribute(AetherIIAttributes.SWEEP_KNOCKBACK.get(), "Sweep Knockback");
        this.addAttribute(AetherIIAttributes.SWEEP_DAMAGE.get(), "Sweep Damage");
        this.addAttribute(AetherIIAttributes.SHOCK_RANGE.get(), "Shock Range");
        this.addAttribute(AetherIIAttributes.SHOCK_KNOCKBACK.get(), "Shock Knockback");
        this.addAttribute(AetherIIAttributes.SHOCK_DAMAGE.get(), "Shock Damage");
        this.addAttribute(AetherIIAttributes.STAB_RADIUS.get(), "Stab Radius");
        this.addAttribute(AetherIIAttributes.STAB_DISTANCE.get(), "Stab Distance");
        this.addAttribute(AetherIIAttributes.STAB_KNOCKBACK.get(), "Stab Knockback");
        this.addAttribute(AetherIIAttributes.STAB_DAMAGE.get(), "Stab Damage");
        this.addAttribute(AetherIIAttributes.SHIELD_STAMINA_REDUCTION.get(), "Shield Stamina Used");
        this.addAttribute(AetherIIAttributes.SHIELD_COOLDOWN_REDUCTION.get(), "Shield Cooldown Speed");
        this.addAttribute(AetherIIAttributes.WOUND_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");
        this.addAttribute(AetherIIAttributes.STUN_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");
        this.addAttribute(AetherIIAttributes.FRACTURE_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");
        this.addAttribute(AetherIIAttributes.AMBROSIUM_POISONING_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");
        this.addAttribute(AetherIIAttributes.TOXIN_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");
        this.addAttribute(AetherIIAttributes.VENOM_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");
        this.addAttribute(AetherIIAttributes.CHARGED_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");
        this.addAttribute(AetherIIAttributes.WEBBED_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");
        this.addAttribute(AetherIIAttributes.IMMOLATION_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");
        this.addAttribute(AetherIIAttributes.FROSTBITE_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");
        this.addAttribute(AetherIIAttributes.FUNGAL_ROT_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");
        this.addAttribute(AetherIIAttributes.CRYSTALLIZED_EFFECT_RESISTANCE.get(), "%s Buildup Resistance");


        // Effects
        // Beneficial
        this.addEffect(AetherIIEffects.SATURATION_BOOST, "Saturation Boost");

        // Harmful
        this.addEffect(AetherIIEffects.WOUND, "Wound");
        this.addEffect(AetherIIEffects.STUN, "Stun");
        this.addEffect(AetherIIEffects.FRACTURE, "Fracture");
        this.addEffect(AetherIIEffects.AMBROSIUM_POISONING, "Ambrosium Poisoning");
        this.addEffect(AetherIIEffects.TOXIN, "Toxin");
        this.addEffect(AetherIIEffects.VENOM, "Venom");
        this.addEffect(AetherIIEffects.CHARGED, "Charged");
        this.addEffect(AetherIIEffects.WEBBED, "Webbed");
        this.addEffect(AetherIIEffects.IMMOLATION, "Immolation");
        this.addEffect(AetherIIEffects.FROSTBITE, "Frostbite");
        this.addEffect(AetherIIEffects.FUNGAL_ROT, "Fungal Rot");
        this.addEffect(AetherIIEffects.CRYSTALLIZED, "Crystallized");


        // Creative Tabs
        this.addCreativeTab(AetherIICreativeTabs.AETHER_II_BUILDING_BLOCKS.get(), "Aether II Building Blocks");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_II_DUNGEON_BLOCKS.get(), "Aether II Dungeon Blocks");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_II_NATURAL_BLOCKS.get(), "Aether II Natural Blocks");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_II_FUNCTIONAL_BLOCKS.get(), "Aether II Functional Blocks");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_II_EQUIPMENT_AND_UTILITIES.get(), "Aether II Equipment & Utilities");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_II_ARMOR_AND_ACCESSORIES.get(), "Aether II Armor & Accessories");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_II_CONSUMABLES.get(), "Aether II Consumables");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_II_INGREDIENTS.get(), "Aether II Ingredients");
        this.addCreativeTab(AetherIICreativeTabs.AETHER_II_SPAWN_EGGS.get(), "Aether II Spawn Eggs");


        // Containers
        this.addContainerType(AetherIIMenuTypes.HOLYSTONE_FURNACE, "Holystone Furnace");
        this.addContainerType(AetherIIMenuTypes.ARTISANS_BENCH, "Artisan's Bench");
        this.addContainerType(AetherIIMenuTypes.ALTAR, "Altar");
        this.addContainerType(AetherIIMenuTypes.ARKENIUM_FORGE, "Arkenium Forge");


        // GUIs
        this.addGuiText("arkenium_forge.forge_button.tooltip", "Forge Item");
        this.addGuiText("recipebook.toggleRecipes.enchantable", "Showing Enchantable");
        this.addGuiText("deathScreen.outpost_respawn", "Respawn at Outpost");
        this.addGuiText("guidebook.button.open", "Guidebook");
        this.addGuiText("guidebook.button.close", "Inventory");
        this.addGuiText("guidebook.equipment.title", "Equipment");
        this.addGuiText("guidebook.equipment.pouch.tooltip.title", "Pouch");
        this.addGuiText("guidebook.equipment.pouch.tooltip.description", "%s Glint");
        this.addGuiText("guidebook.status.title", "Status");
        this.addGuiText("guidebook.status.mount.title", "Mount");
        this.addGuiText("guidebook.discovery.title", "Discovery");
        this.addGuiText("guidebook.discovery.bestiary.title", "Bestiary");
        this.addGuiText("guidebook.discovery.effects.title", "Effects");
        this.addGuiText("guidebook.discovery.exploration.title", "Exploration");
        this.addGuiText("guidebook.journal.title", "Journal");
        this.addGuiText("guidebook.rewards.title", "Rewards");
        this.addGuiText("guidebook.discovery.bestiary.entry.unknown", "???");
        this.addGuiText("guidebook.discovery.bestiary.stat.health", "%s Health");
        this.addGuiText("guidebook.discovery.bestiary.stat.damage_weakness", "%1$s Damage from %2$s Attacks");
        this.addGuiText("guidebook.discovery.bestiary.stat.damage_resistance", "%1$s Damage from %2$s Attacks");
        this.addGuiText("guidebook.discovery.bestiary.stat.damage_none", "Standard Damage from %s Attacks");
        this.addGuiText("guidebook.discovery.bestiary.info.eats", "Eats:");
        this.addGuiText("guidebook.discovery.bestiary.info.drops", "Drops:");
        this.addGuiText("toast.guidebook.bestiary", "New Bestiary Entry!");
        this.addGuiText("toast.guidebook.effects", "New Effects Entry!");
        this.addGuiText("toast.guidebook.exploration", "New Exploration Entry!");
        this.addGuiText("toast.guidebook.description", "Check your Guidebook");

        // Bestiary
        this.addBestiaryName(AetherIIEntityTypes.HIGHFIELDS_TAEGORE.get(), "Highfields Taegore");
        this.addBestiaryName(AetherIIEntityTypes.MAGNETIC_TAEGORE.get(), "Magnetic Taegore");
        this.addBestiaryName(AetherIIEntityTypes.ARCTIC_TAEGORE.get(), "Arctic Taegore");
        this.addBestiaryName(AetherIIEntityTypes.HIGHFIELDS_BURRUKAI.get(), "Highfields Burrukai");
        this.addBestiaryName(AetherIIEntityTypes.MAGNETIC_BURRUKAI.get(), "Magnetic Burrukai");
        this.addBestiaryName(AetherIIEntityTypes.ARCTIC_BURRUKAI.get(), "Arctic Burrukai");
        this.addBestiaryName(AetherIIEntityTypes.HIGHFIELDS_KIRRID.get(), "Highfields Kirrid");
        this.addBestiaryName(AetherIIEntityTypes.MAGNETIC_KIRRID.get(), "Magnetic Kirrid");
        this.addBestiaryName(AetherIIEntityTypes.ARCTIC_KIRRID.get(), "Arctic Kirrid");

        this.addBestiarySlotName(AetherIIEntityTypes.HIGHFIELDS_TAEGORE.get(), "Taegore");
        this.addBestiarySlotName(AetherIIEntityTypes.MAGNETIC_TAEGORE.get(), "Taegore");
        this.addBestiarySlotName(AetherIIEntityTypes.ARCTIC_TAEGORE.get(), "Taegore");
        this.addBestiarySlotName(AetherIIEntityTypes.HIGHFIELDS_BURRUKAI.get(), "Burrukai");
        this.addBestiarySlotName(AetherIIEntityTypes.MAGNETIC_BURRUKAI.get(), "Burrukai");
        this.addBestiarySlotName(AetherIIEntityTypes.ARCTIC_BURRUKAI.get(), "Burrukai");
        this.addBestiarySlotName(AetherIIEntityTypes.HIGHFIELDS_KIRRID.get(), "Kirrid");
        this.addBestiarySlotName(AetherIIEntityTypes.MAGNETIC_KIRRID.get(), "Kirrid");
        this.addBestiarySlotName(AetherIIEntityTypes.ARCTIC_KIRRID.get(), "Kirrid");

        this.addBestiarySlotSubtitle(AetherIIEntityTypes.HIGHFIELDS_TAEGORE.get(), "Highfields");
        this.addBestiarySlotSubtitle(AetherIIEntityTypes.MAGNETIC_TAEGORE.get(), "Magnetic");
        this.addBestiarySlotSubtitle(AetherIIEntityTypes.ARCTIC_TAEGORE.get(), "Arctic");
        this.addBestiarySlotSubtitle(AetherIIEntityTypes.HIGHFIELDS_BURRUKAI.get(), "Highfields");
        this.addBestiarySlotSubtitle(AetherIIEntityTypes.MAGNETIC_BURRUKAI.get(), "Magnetic");
        this.addBestiarySlotSubtitle(AetherIIEntityTypes.ARCTIC_BURRUKAI.get(), "Arctic");
        this.addBestiarySlotSubtitle(AetherIIEntityTypes.HIGHFIELDS_KIRRID.get(), "Highfields");
        this.addBestiarySlotSubtitle(AetherIIEntityTypes.MAGNETIC_KIRRID.get(), "Magnetic");
        this.addBestiarySlotSubtitle(AetherIIEntityTypes.ARCTIC_KIRRID.get(), "Arctic");

        this.addBestiaryDescription(AetherIIEntityTypes.FLYING_COW.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.SHEEPUFF.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.PHYG.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.AERBUNNY.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.HIGHFIELDS_TAEGORE.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.MAGNETIC_TAEGORE.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.ARCTIC_TAEGORE.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.HIGHFIELDS_BURRUKAI.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.MAGNETIC_BURRUKAI.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.ARCTIC_BURRUKAI.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.HIGHFIELDS_KIRRID.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.MAGNETIC_KIRRID.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.ARCTIC_KIRRID.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.MOA.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.SKYROOT_LIZARD.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.AECHOR_PLANT.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.CARRION_SPROUT.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.ZEPHYR.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.TEMPEST.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        this.addBestiaryDescription(AetherIIEntityTypes.COCKATRICE.get(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");


        // Jukebox Songs
        this.addJukeboxSong("aether_tune", "Noisestorm - Aether Tune");
        this.addJukeboxSong("ascending_dawn", "Emile van Krieken - Ascending Dawn");
        this.addJukeboxSong("aerwhale", "AetherAudio - Aerwhale");
        this.addJukeboxSong("approaches", "Emile van Krieken - Approaches");
        this.addJukeboxSong("demise", "Moorziey - Demise");
        this.addJukeboxSong("recording_892", "Emile van Krieken - ???");


        // Misc
        this.addGeneric("slash", "§9Slash§r");
        this.addGeneric("impact", "§eImpact§r");
        this.addGeneric("pierce", "§cPierce§r");
        this.addGeneric("highfields", "Highfields");
        this.addGeneric("magnetic", "Magnetic");
        this.addGeneric("arctic", "Arctic");
        this.addGeneric("message.campfire_added", "Outpost campfire respawn point set");
        this.addGeneric("message.campfire_respawn_failed", "Failed to locate a valid outpost campfire");


        // Subtitles
        // Blocks
        this.addSubtitle("block", "aether_portal.ambient", "Aether Portal whooshes");
        this.addSubtitle("block", "aether_portal.trigger", "Aether Portal noise intensifies");
        this.addSubtitle("block", "aercloud.blue_aercloud_bounce", "Blue Aercloud bounces");

        // Entities
        this.addSubtitle("entity", "phyg.ambient", "Phyg oinks");
        this.addSubtitle("entity", "phyg.death", "Phyg dies");
        this.addSubtitle("entity", "phyg.hurt", "Phyg hurts");
        this.addSubtitle("entity", "phyg.saddle", "Saddle equips");
        this.addSubtitle("entity", "phyg.step", "Footsteps");

        this.addSubtitle("entity", "flying_cow.ambient", "Flying Cow moos");
        this.addSubtitle("entity", "flying_cow.death", "Flying Cow dies");
        this.addSubtitle("entity", "flying_cow.hurt", "Flying Cow hurts");
        this.addSubtitle("entity", "flying_cow.saddle", "Saddle equips");
        this.addSubtitle("entity", "flying_cow.milk", "Flying Cow gets milked");
        this.addSubtitle("entity", "flying_cow.step", "Footsteps");

        this.addSubtitle("entity", "sheepuff.ambient", "Sheepuff baahs");
        this.addSubtitle("entity", "sheepuff.death", "Sheepuff dies");
        this.addSubtitle("entity", "sheepuff.hurt", "Sheepuff hurts");
        this.addSubtitle("entity", "sheepuff.step", "Footsteps");

        this.addSubtitle("entity", "moa.ambient", "Moa calls");
        this.addSubtitle("entity", "moa.death", "Moa dies");
        this.addSubtitle("entity", "moa.hurt", "Moa hurts");
        this.addSubtitle("entity", "moa.saddle", "Saddle equips");
        this.addSubtitle("entity", "moa.step", "Footsteps");
        this.addSubtitle("entity", "moa.flap", "Moa flaps");
        this.addSubtitle("entity", "moa.egg", "Moa plops");

        this.addSubtitle("entity", "aerbunny.death", "Aerbunny dies");
        this.addSubtitle("entity", "aerbunny.hurt", "Aerbunny squeals");
        this.addSubtitle("entity", "aerbunny.lift", "Aerbunny squeaks");

        this.addSubtitle("entity", "zephyr.shoot", "Zephyr spits");
        this.addSubtitle("entity", "zephyr.ambient", "Zephyr blows");
        this.addSubtitle("entity", "zephyr.death", "Zephyr dies");
        this.addSubtitle("entity", "zephyr.hurt", "Zephyr hurts");

        this.addSubtitle("entity", "cockatrice.shoot", "Cockatrice shoots");

        this.addSubtitle("entity", "swet.attack", "Swet attacks");
        this.addSubtitle("entity", "swet.death", "Swet dies");
        this.addSubtitle("entity", "swet.hurt", "Swet hurts");
        this.addSubtitle("entity", "swet.jump", "Swet squishes");
        this.addSubtitle("entity", "swet.squish", "Swet squishes");


        this.addDeath("effect.wound", "%1$s was fatally wounded");
        this.addDeath("effect.fracture", "Oof, owie, %1$s's bones");
        this.addDeath("effect.toxin", "%1$s succumbed to toxin");
        this.addDeath("effect.venom", "%1$s succumbed to venom");
        this.addDeath("effect.charged", "%1$s was electrocuted");
        this.addDeath("effect.immolation", "%1$s burned to death");

        // Packs
        this.addPackDescription("mod", "Aether II Resources");
    }
}