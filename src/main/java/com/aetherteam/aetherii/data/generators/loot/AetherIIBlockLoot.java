package com.aetherteam.aetherii.data.generators.loot;

import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.data.providers.AetherIIBlockLootSubProvider;
import com.aetherteam.aetherii.item.AetherIIItems;
import com.aetherteam.aetherii.mixin.mixins.common.accessor.BlockLootAccessor;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AetherIIBlockLoot extends AetherIIBlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Set.of();

    public AetherIIBlockLoot(HolderLookup.Provider registries) {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    public void generate() {
        HolderGetter<Item> getter = this.registries.lookupOrThrow(Registries.ITEM);

        // Dirt
        this.add(AetherIIBlocks.AETHER_GRASS_BLOCK.get(), block -> this.createSingleItemTableWithSilkTouch(block, AetherIIBlocks.AETHER_DIRT.get()));
        this.add(AetherIIBlocks.ENCHANTED_AETHER_GRASS_BLOCK.get(), block -> this.createSingleItemTableWithSilkTouch(block, AetherIIBlocks.AETHER_DIRT.get()));
        this.dropOther(AetherIIBlocks.AETHER_DIRT_PATH.get(), AetherIIBlocks.AETHER_DIRT.get());
        this.dropSelf(AetherIIBlocks.AETHER_DIRT.get());
        this.dropSelf(AetherIIBlocks.COARSE_AETHER_DIRT.get());
        this.dropOther(AetherIIBlocks.AETHER_FARMLAND.get(), AetherIIBlocks.AETHER_DIRT.get());
        this.dropSelf(AetherIIBlocks.SHIMMERING_SILT.get());

        // Underground
        this.dropSelf(AetherIIBlocks.HOLYSTONE.get());
        this.dropWhenSilkTouch(AetherIIBlocks.UNSTABLE_HOLYSTONE.get());
        this.dropSelf(AetherIIBlocks.UNDERSHALE.get());
        this.dropWhenSilkTouch(AetherIIBlocks.UNSTABLE_UNDERSHALE.get());
        this.dropSelf(AetherIIBlocks.AGIOSITE.get());
        this.add(AetherIIBlocks.CRUDE_SCATTERGLASS.get(), block -> this.createSingleItemTableWithSilkTouch(block, AetherIIItems.SCATTERGLASS_SHARD, UniformGenerator.between(1.0F, 3.0F)));
        this.add(AetherIIBlocks.SKY_ROOTS.get(), this::createSkyRootsDrops);
        this.dropSelf(AetherIIBlocks.ICHORITE.get());
        this.dropSelf(AetherIIBlocks.POINTED_HOLYSTONE.get());
        this.dropSelf(AetherIIBlocks.POINTED_ICHORITE.get());

        // Highfields
        this.dropSelf(AetherIIBlocks.QUICKSOIL.get());
        this.dropSelf(AetherIIBlocks.MOSSY_HOLYSTONE.get());
        this.dropSelf(AetherIIBlocks.BRYALINN_MOSS_BLOCK.get());
        this.dropSelf(AetherIIBlocks.BRYALINN_MOSS_CARPET.get());
        this.add(AetherIIBlocks.BRYALINN_MOSS_VINES.get(), this::createShearsOnlyDrop);
        this.add(AetherIIBlocks.BRYALINN_MOSS_FLOWERS.get(), this.createPetalsDrops(AetherIIBlocks.BRYALINN_MOSS_FLOWERS.get()));
        this.dropSelf(AetherIIBlocks.TANGLED_BRANCHES.get());

        // Magnetic
        this.dropSelf(AetherIIBlocks.FERROSITE_SAND.get());
        this.dropSelf(AetherIIBlocks.FERROSITE_MUD.get());
        this.dropSelf(AetherIIBlocks.FERROSITE.get());
        this.dropSelf(AetherIIBlocks.RUSTED_FERROSITE.get());
        this.dropSelf(AetherIIBlocks.MAGNETIC_SHROOM.get());

        // Arctic
        this.add(AetherIIBlocks.ARCTIC_SNOW_BLOCK.get(), block -> this.createSingleItemTableWithSilkTouch(block, AetherIIItems.ARCTIC_SNOWBALL, ConstantValue.exactly(4.0F)));
        this.add(AetherIIBlocks.ARCTIC_SNOW.get(), this::droppingSnowLayer);
        this.dropWhenSilkTouch(AetherIIBlocks.ARCTIC_ICE.get());
        this.dropWhenSilkTouch(AetherIIBlocks.ARCTIC_PACKED_ICE.get());
        this.dropSelf(AetherIIBlocks.ICESTONE.get());
        this.dropWhenSilkTouch(AetherIIBlocks.LARGE_ARCTIC_ICE_CRYSTAL.get());
        this.dropWhenSilkTouch(AetherIIBlocks.MEDIUM_ARCTIC_ICE_CRYSTAL.get());
        this.dropWhenSilkTouch(AetherIIBlocks.SMALL_ARCTIC_ICE_CRYSTAL.get());
        this.dropSelf(AetherIIBlocks.SHAYELINN_MOSS_BLOCK.get());
        this.dropSelf(AetherIIBlocks.SHAYELINN_MOSS_CARPET.get());
        this.add(AetherIIBlocks.SHAYELINN_MOSS_VINES.get(), this::createShearsOnlyDrop);

        // Irradiated
        this.dropSelf(AetherIIBlocks.IRRADIATED_HOLYSTONE.get());
        this.add(AetherIIBlocks.IRRADIATED_DUST_BLOCK.get(), this::droppingIrradiatedDustLoot);
        this.dropSelf(AetherIIBlocks.AMBRELINN_MOSS_BLOCK.get());
        this.dropSelf(AetherIIBlocks.AMBRELINN_MOSS_CARPET.get());
        this.add(AetherIIBlocks.AMBRELINN_MOSS_VINES.get(), this::createShearsOnlyDrop);
        this.add(AetherIIBlocks.TARAHESP_FLOWERS.get(), this.createPetalsDrops(AetherIIBlocks.TARAHESP_FLOWERS.get()));

        // Ores
        this.add(AetherIIBlocks.HOLYSTONE_QUARTZ_ORE.get(), this::createQuartzOreDrops);
        this.dropWithFortune(AetherIIBlocks.AMBROSIUM_ORE.get(), AetherIIItems.AMBROSIUM_SHARD.get());
        this.dropWithFortune(AetherIIBlocks.ZANITE_ORE.get(), AetherIIItems.ZANITE_GEMSTONE.get());
        this.dropWithFortune(AetherIIBlocks.GLINT_ORE.get(), AetherIIItems.GLINT_GEMSTONE.get());
        this.dropWithFortune(AetherIIBlocks.ARKENIUM_ORE.get(), AetherIIItems.INERT_ARKENIUM.get());
        this.dropWithFortune(AetherIIBlocks.GRAVITITE_ORE.get(), AetherIIItems.INERT_GRAVITITE.get());
        this.dropWithFortune(AetherIIBlocks.UNDERSHALE_AMBROSIUM_ORE.get(), AetherIIItems.AMBROSIUM_SHARD.get());
        this.dropWithFortune(AetherIIBlocks.UNDERSHALE_ZANITE_ORE.get(), AetherIIItems.ZANITE_GEMSTONE.get());
        this.dropWithFortune(AetherIIBlocks.UNDERSHALE_GLINT_ORE.get(), AetherIIItems.GLINT_GEMSTONE.get());
        this.dropWithFortune(AetherIIBlocks.UNDERSHALE_ARKENIUM_ORE.get(), AetherIIItems.INERT_ARKENIUM.get());
        this.dropWithFortune(AetherIIBlocks.UNDERSHALE_GRAVITITE_ORE.get(), AetherIIItems.INERT_GRAVITITE.get());
        this.dropWithFortune(AetherIIBlocks.CORROBONITE_ORE.get(), AetherIIItems.CORROBONITE_CRYSTAL.get());
        this.dropWhenSilkTouch(AetherIIBlocks.CORROBONITE_CLUSTER.get());

        // Aerclouds
        this.dropSelf(AetherIIBlocks.COLD_AERCLOUD.get());
        this.dropSelf(AetherIIBlocks.BLUE_AERCLOUD.get());
        this.dropSelf(AetherIIBlocks.GOLDEN_AERCLOUD.get());
        this.dropSelf(AetherIIBlocks.GREEN_AERCLOUD.get());
        this.dropSelf(AetherIIBlocks.PURPLE_AERCLOUD.get());
        this.dropSelf(AetherIIBlocks.STORM_AERCLOUD.get());

        // Moa Nest
        this.dropSelf(AetherIIBlocks.WOVEN_SKYROOT_STICKS.get());
        this.add(AetherIIBlocks.MOA_EGG.get(), this::droppingMoaEgg);

        // Logs
        this.dropSelf(AetherIIBlocks.SKYROOT_LOG.get());
        this.dropSelf(AetherIIBlocks.STRIPPED_SKYROOT_LOG.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_LOG.get());
        this.dropSelf(AetherIIBlocks.STRIPPED_GREATROOT_LOG.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_LOG.get());
        this.dropSelf(AetherIIBlocks.STRIPPED_WISPROOT_LOG.get());
        this.add(AetherIIBlocks.MOSSY_WISPROOT_LOG.get(), block -> this.createSingleItemTableWithSilkTouch(block, AetherIIBlocks.WISPROOT_LOG.get()));
        this.add(AetherIIBlocks.MOSSY_WISPROOT_LOG_END.get(), block -> this.createSingleItemTableWithSilkTouch(block, AetherIIBlocks.WISPROOT_LOG.get()));
        this.add(AetherIIBlocks.MOSSY_WISPROOT_WOOD.get(), block -> this.createSingleItemTableWithSilkTouch(block, AetherIIBlocks.WISPROOT_WOOD.get()));
        this.add(AetherIIBlocks.AMBEROOT_LOG.get(), (wood) -> this.droppingAmberoot(getter, wood, AetherIIBlocks.SKYROOT_LOG.get(), AetherIIItems.GOLDEN_AMBER.get()));
        this.dropSelf(AetherIIBlocks.SKYROOT_WOOD.get());
        this.dropSelf(AetherIIBlocks.STRIPPED_SKYROOT_WOOD.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_WOOD.get());
        this.dropSelf(AetherIIBlocks.STRIPPED_GREATROOT_WOOD.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_WOOD.get());
        this.dropSelf(AetherIIBlocks.STRIPPED_WISPROOT_WOOD.get());
        this.add(AetherIIBlocks.AMBEROOT_WOOD.get(), (wood) -> this.droppingAmberoot(getter, wood, AetherIIBlocks.SKYROOT_WOOD.get(), AetherIIItems.GOLDEN_AMBER.get()));

        // Leaf Pile
        this.add(AetherIIBlocks.SKYROOT_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.SKYROOT_LEAVES.get()));
        this.add(AetherIIBlocks.SKYPLANE_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.SKYPLANE_LEAVES.get()));
        this.add(AetherIIBlocks.SKYBIRCH_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.SKYBIRCH_LEAVES.get()));
        this.add(AetherIIBlocks.SKYPINE_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.SKYPINE_LEAVES.get()));
        this.add(AetherIIBlocks.WISPROOT_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.WISPROOT_LEAVES.get()));
        this.add(AetherIIBlocks.WISPTOP_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.WISPTOP_LEAVES.get()));
        this.add(AetherIIBlocks.GREATROOT_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.GREATROOT_LEAVES.get()));
        this.add(AetherIIBlocks.GREATOAK_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.GREATOAK_LEAVES.get()));
        this.add(AetherIIBlocks.GREATBOA_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.GREATBOA_LEAVES.get()));
        this.add(AetherIIBlocks.AMBEROOT_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.AMBEROOT_LEAVES.get()));
        this.add(AetherIIBlocks.IRRADIATED_SKYROOT_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.IRRADIATED_SKYROOT_LEAVES.get()));
        this.add(AetherIIBlocks.IRRADIATED_SKYPLANE_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.IRRADIATED_SKYPLANE_LEAVES.get()));
        this.add(AetherIIBlocks.IRRADIATED_SKYBIRCH_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.IRRADIATED_SKYBIRCH_LEAVES.get()));
        this.add(AetherIIBlocks.IRRADIATED_SKYPINE_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.IRRADIATED_SKYPINE_LEAVES.get()));
        this.add(AetherIIBlocks.IRRADIATED_WISPROOT_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.IRRADIATED_WISPROOT_LEAVES.get()));
        this.add(AetherIIBlocks.IRRADIATED_WISPTOP_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.IRRADIATED_WISPTOP_LEAVES.get()));
        this.add(AetherIIBlocks.IRRADIATED_GREATROOT_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.IRRADIATED_GREATROOT_LEAVES.get()));
        this.add(AetherIIBlocks.IRRADIATED_GREATOAK_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.IRRADIATED_GREATOAK_LEAVES.get()));
        this.add(AetherIIBlocks.IRRADIATED_GREATBOA_LEAF_PILE.get(), (block) -> this.droppingLeafPile(block, AetherIIBlocks.IRRADIATED_GREATBOA_LEAVES.get()));

        // Leaves
        this.add(AetherIIBlocks.SKYROOT_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.SKYROOT_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.SKYPLANE_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.SKYPLANE_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.SKYBIRCH_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.SKYBIRCH_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.SKYPINE_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.SKYPINE_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.WISPROOT_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.WISPROOT_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.WISPTOP_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.WISPTOP_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.GREATROOT_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.GREATROOT_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.GREATOAK_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.GREATOAK_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.GREATBOA_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.GREATBOA_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.AMBEROOT_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.AMBEROOT_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.IRRADIATED_SKYROOT_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.SKYROOT_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances())); //TODO
        this.add(AetherIIBlocks.IRRADIATED_SKYPLANE_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.SKYPLANE_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.IRRADIATED_SKYBIRCH_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.SKYBIRCH_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.IRRADIATED_SKYPINE_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.SKYPINE_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.IRRADIATED_WISPROOT_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.WISPROOT_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.IRRADIATED_WISPTOP_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.WISPTOP_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.IRRADIATED_GREATROOT_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.GREATROOT_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.IRRADIATED_GREATOAK_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.GREATOAK_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));
        this.add(AetherIIBlocks.IRRADIATED_GREATBOA_LEAVES.get(), (leaves) -> this.droppingWithChancesAndSkyrootSticks(leaves, AetherIIBlocks.GREATBOA_SAPLING.get(), BlockLootAccessor.aether_ii$getNormalLeavesSaplingChances()));

        // Saplings
        this.dropSelf(AetherIIBlocks.SKYROOT_SAPLING.get());
        this.dropSelf(AetherIIBlocks.SKYPLANE_SAPLING.get());
        this.dropSelf(AetherIIBlocks.SKYBIRCH_SAPLING.get());
        this.dropSelf(AetherIIBlocks.SKYPINE_SAPLING.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_SAPLING.get());
        this.dropSelf(AetherIIBlocks.WISPTOP_SAPLING.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_SAPLING.get());
        this.dropSelf(AetherIIBlocks.GREATOAK_SAPLING.get());
        this.dropSelf(AetherIIBlocks.GREATBOA_SAPLING.get());
        this.dropSelf(AetherIIBlocks.AMBEROOT_SAPLING.get());

        // Potted Saplings
        this.dropPottedContents(AetherIIBlocks.POTTED_SKYROOT_SAPLING.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_SKYPLANE_SAPLING.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_SKYBIRCH_SAPLING.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_SKYPINE_SAPLING.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_WISPROOT_SAPLING.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_WISPTOP_SAPLING.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_GREATROOT_SAPLING.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_GREATOAK_SAPLING.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_GREATBOA_SAPLING.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_AMBEROOT_SAPLING.get());

        // Grasses
        this.add(AetherIIBlocks.AETHER_SHORT_GRASS.get(), this::createShearsOnlyDrop);
        this.add(AetherIIBlocks.AETHER_MEDIUM_GRASS.get(), this::createShearsOnlyDrop);
        this.add(AetherIIBlocks.AETHER_LONG_GRASS.get(), this::createShearsOnlyDrop);
        this.add(AetherIIBlocks.HIGHLAND_FERN.get(), this::createShearsOnlyDrop);
        this.add(AetherIIBlocks.SHIELD_FERN.get(), this::createShearsOnlyDrop);

        // Flowers
        this.dropSelf(AetherIIBlocks.HESPEROSE.get());
        this.dropSelf(AetherIIBlocks.TARABLOOM.get());
        this.dropSelf(AetherIIBlocks.POASPROUT.get());
        this.dropSelf(AetherIIBlocks.LILICHIME.get());
        this.dropSelf(AetherIIBlocks.PLURACIAN.get());
        this.add(AetherIIBlocks.SATIVAL_SHOOT.get(), (shoot) -> this.droppingSativalShoot(getter, shoot, AetherIIItems.SATIVAL_BULB.get()));
        this.add(AetherIIBlocks.HOLPUPEA.get(), this.createPetalsDrops(AetherIIBlocks.HOLPUPEA.get()));
        this.add(AetherIIBlocks.BLADE_POA.get(), this::createShearsOnlyDrop);
        this.dropSelf(AetherIIBlocks.AECHOR_CUTTING.get());

        // Potted Flowers
        this.dropPottedContents(AetherIIBlocks.POTTED_MAGNETIC_SHROOM.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_HIGHLAND_FERN.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_SHIELD_FERN.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_HESPEROSE.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_TARABLOOM.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_POASPROUT.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_SATIVAL_SHOOT.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_LILICHIME.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_PLURACIAN.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_BLADE_POA.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_AECHOR_CUTTING.get());

        // Bushes
        this.dropSelf(AetherIIBlocks.HIGHLANDS_BUSH.get());
        this.add(AetherIIBlocks.BLUEBERRY_BUSH.get(), (bush) -> this.droppingBerryBush(getter, bush, AetherIIBlocks.BLUEBERRY_BUSH_STEM.get(), AetherIIItems.BLUEBERRY.get()));
        this.dropSelf(AetherIIBlocks.BLUEBERRY_BUSH_STEM.get());

        // Potted Bushes
        this.dropPottedContents(AetherIIBlocks.POTTED_HIGHLANDS_BUSH.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_BLUEBERRY_BUSH.get());
        this.dropPottedContents(AetherIIBlocks.POTTED_BLUEBERRY_BUSH_STEM.get());

        // Orange Tree
        this.add(AetherIIBlocks.ORANGE_TREE.get(), (tree) -> this.droppingOrangeTree(getter, tree, AetherIIItems.ORANGE.get()));

        // Potted Orange Tree
        this.dropPottedContents(AetherIIBlocks.POTTED_ORANGE_TREE.get());

        // Valkyrie Sprout
        this.add(AetherIIBlocks.VALKYRIE_SPROUT.get(), (sprout) -> this.droppingValkyrieSprout(getter, sprout, AetherIIItems.VALKYRIE_WINGS.get()));

        // Brettl
        this.add(AetherIIBlocks.BRETTL_PLANT.get(), (brettl) -> this.droppingBrettlPlant(brettl, AetherIIItems.BRETTL_CANE.get(), AetherIIItems.BRETTL_GRASS.get()));
        this.add(AetherIIBlocks.BRETTL_PLANT_TIP.get(), (brettl) -> this.droppingBrettlPlantTip(brettl, AetherIIItems.BRETTL_CANE.get(), AetherIIItems.BRETTL_FLOWER.get()));

        // Lake
        this.dropOther(AetherIIBlocks.ARILUM_SHOOT.get(), AetherIIItems.ARILUM_BULBS.get());
        this.add(AetherIIBlocks.ARILUM.get(), this::createSilkTouchOrShearsTable);
        this.add(AetherIIBlocks.ARILUM_PLANT.get(), (plant) -> this.createSilkTouchOrShearsTable(AetherIIBlocks.ARILUM.get()));
        this.add(AetherIIBlocks.BLOOMING_ARILUM.get(), (plant) -> this.droppingArilumBulbs(getter, plant, AetherIIItems.ARILUM_BULBS.get()));
        this.add(AetherIIBlocks.BLOOMING_ARILUM_PLANT.get(), (plant) -> this.droppingArilumBulbs(getter, AetherIIBlocks.BLOOMING_ARILUM.get(), AetherIIItems.ARILUM_BULBS.get()));

        // Ground Decoration
        this.add(AetherIIBlocks.SKYROOT_TWIG.get(), this::dropTwigs);
        this.add(AetherIIBlocks.HOLYSTONE_ROCK.get(), this::dropRocks);

        // Skyroot Planks
        this.dropSelf(AetherIIBlocks.SKYROOT_PLANKS.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_STAIRS.get());
        this.add(AetherIIBlocks.SKYROOT_SLAB.get(), this::createSlabItemTable);
        this.add(AetherIIBlocks.SKYROOT_DOOR.get(), createDoorTable(AetherIIBlocks.SKYROOT_DOOR.get()));
        this.dropSelf(AetherIIBlocks.SKYROOT_TRAPDOOR.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_FENCE.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_FENCE_GATE.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_BUTTON.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_PRESSURE_PLATE.get());

        // Skyroot Decorative Blocks
        this.dropSelf(AetherIIBlocks.SKYROOT_FLOORBOARDS.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_HIGHLIGHT.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_SHINGLES.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_SMALL_SHINGLES.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_BASE_PLANKS.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_TOP_PLANKS.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_BASE_BEAM.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_TOP_BEAM.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_BEAM.get());
        this.add(AetherIIBlocks.SECRET_SKYROOT_DOOR.get(), createDoorTable(AetherIIBlocks.SECRET_SKYROOT_DOOR.get()));
        this.dropSelf(AetherIIBlocks.SECRET_SKYROOT_TRAPDOOR.get());

        // Greatroot Planks
        this.dropSelf(AetherIIBlocks.GREATROOT_PLANKS.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_STAIRS.get());
        this.add(AetherIIBlocks.GREATROOT_SLAB.get(), this::createSlabItemTable);
        this.add(AetherIIBlocks.GREATROOT_DOOR.get(), createDoorTable(AetherIIBlocks.GREATROOT_DOOR.get()));
        this.dropSelf(AetherIIBlocks.GREATROOT_TRAPDOOR.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_FENCE.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_FENCE_GATE.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_BUTTON.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_PRESSURE_PLATE.get());

        // Greatroot Decorative Blocks
        this.dropSelf(AetherIIBlocks.GREATROOT_FLOORBOARDS.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_HIGHLIGHT.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_SHINGLES.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_SMALL_SHINGLES.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_BASE_PLANKS.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_TOP_PLANKS.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_BASE_BEAM.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_TOP_BEAM.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_BEAM.get());
        this.add(AetherIIBlocks.SECRET_GREATROOT_DOOR.get(), createDoorTable(AetherIIBlocks.SECRET_GREATROOT_DOOR.get()));
        this.dropSelf(AetherIIBlocks.SECRET_GREATROOT_TRAPDOOR.get());

        // Wisproot Planks
        this.dropSelf(AetherIIBlocks.WISPROOT_PLANKS.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_STAIRS.get());
        this.add(AetherIIBlocks.WISPROOT_SLAB.get(), this::createSlabItemTable);
        this.add(AetherIIBlocks.WISPROOT_DOOR.get(), createDoorTable(AetherIIBlocks.WISPROOT_DOOR.get()));
        this.dropSelf(AetherIIBlocks.WISPROOT_TRAPDOOR.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_FENCE.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_FENCE_GATE.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_BUTTON.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_PRESSURE_PLATE.get());

        // Wisproot Decorative Blocks
        this.dropSelf(AetherIIBlocks.WISPROOT_FLOORBOARDS.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_HIGHLIGHT.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_SHINGLES.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_SMALL_SHINGLES.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_BASE_PLANKS.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_TOP_PLANKS.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_BASE_BEAM.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_TOP_BEAM.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_BEAM.get());
        this.add(AetherIIBlocks.SECRET_WISPROOT_DOOR.get(), createDoorTable(AetherIIBlocks.SECRET_WISPROOT_DOOR.get()));
        this.dropSelf(AetherIIBlocks.SECRET_WISPROOT_TRAPDOOR.get());

        // Holystone
        this.dropSelf(AetherIIBlocks.HOLYSTONE_STAIRS.get());
        this.add(AetherIIBlocks.HOLYSTONE_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(AetherIIBlocks.HOLYSTONE_WALL.get());
        this.dropSelf(AetherIIBlocks.HOLYSTONE_BUTTON.get());
        this.dropSelf(AetherIIBlocks.HOLYSTONE_PRESSURE_PLATE.get());

        // Mossy Holystone
        this.dropSelf(AetherIIBlocks.MOSSY_HOLYSTONE_STAIRS.get());
        this.add(AetherIIBlocks.MOSSY_HOLYSTONE_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(AetherIIBlocks.MOSSY_HOLYSTONE_WALL.get());

        // Irradiated Holystone
        this.dropSelf(AetherIIBlocks.IRRADIATED_HOLYSTONE_STAIRS.get());
        this.add(AetherIIBlocks.IRRADIATED_HOLYSTONE_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(AetherIIBlocks.IRRADIATED_HOLYSTONE_WALL.get());

        // Holystone Bricks
        this.dropSelf(AetherIIBlocks.HOLYSTONE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.HOLYSTONE_BRICK_STAIRS.get());
        this.add(AetherIIBlocks.HOLYSTONE_BRICK_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(AetherIIBlocks.HOLYSTONE_BRICK_WALL.get());

        // Holystone Decorative Blocks
        this.dropSelf(AetherIIBlocks.HOLYSTONE_FLAGSTONES.get());
        this.dropSelf(AetherIIBlocks.HOLYSTONE_HEADSTONE.get());
        this.dropSelf(AetherIIBlocks.HOLYSTONE_KEYSTONE.get());
        this.dropSelf(AetherIIBlocks.HOLYSTONE_BASE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.HOLYSTONE_CAPSTONE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.HOLYSTONE_BASE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.HOLYSTONE_CAPSTONE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.HOLYSTONE_PILLAR.get());

        // Faded Holystone Bricks
        this.dropSelf(AetherIIBlocks.FADED_HOLYSTONE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.FADED_HOLYSTONE_BRICK_STAIRS.get());
        this.add(AetherIIBlocks.FADED_HOLYSTONE_BRICK_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(AetherIIBlocks.FADED_HOLYSTONE_BRICK_WALL.get());

        // Faded Holystone Decorative Blocks
        this.dropSelf(AetherIIBlocks.FADED_HOLYSTONE_FLAGSTONES.get());
        this.dropSelf(AetherIIBlocks.FADED_HOLYSTONE_HEADSTONE.get());
        this.dropSelf(AetherIIBlocks.FADED_HOLYSTONE_KEYSTONE.get());
        this.dropSelf(AetherIIBlocks.FADED_HOLYSTONE_BASE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.FADED_HOLYSTONE_CAPSTONE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.FADED_HOLYSTONE_BASE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.FADED_HOLYSTONE_CAPSTONE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.FADED_HOLYSTONE_PILLAR.get());

        // Undershale
        this.dropSelf(AetherIIBlocks.UNDERSHALE_STAIRS.get());
        this.add(AetherIIBlocks.UNDERSHALE_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(AetherIIBlocks.UNDERSHALE_WALL.get());

        // Undershale Bricks
        this.dropSelf(AetherIIBlocks.UNDERSHALE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.UNDERSHALE_BRICK_STAIRS.get());
        this.add(AetherIIBlocks.UNDERSHALE_BRICK_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(AetherIIBlocks.UNDERSHALE_BRICK_WALL.get());

        // Ichorite
        this.dropSelf(AetherIIBlocks.ICHORITE.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_STAIRS.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_SLAB.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_WALL.get());

        // Smooth Ichorite
        this.dropSelf(AetherIIBlocks.SMOOTH_ICHORITE.get());
        this.dropSelf(AetherIIBlocks.SMOOTH_ICHORITE_STAIRS.get());
        this.dropSelf(AetherIIBlocks.SMOOTH_ICHORITE_SLAB.get());
        this.dropSelf(AetherIIBlocks.SMOOTH_ICHORITE_WALL.get());

        // Ichorite Bricks
        this.dropSelf(AetherIIBlocks.ICHORITE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_BRICK_STAIRS.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_BRICK_SLAB.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_BRICK_WALL.get());

        // Ichorite Decorative Blocks
        this.dropSelf(AetherIIBlocks.ICHORITE_FLAGSTONES.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_RUNESTONE.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_KEYSTONE.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_BASE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_CAPSTONE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_BASE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_CAPSTONE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.ICHORITE_PILLAR.get());

        // Marbled Ichorite
        this.dropSelf(AetherIIBlocks.MARBLED_ICHORITE.get());
        this.dropSelf(AetherIIBlocks.MARBLED_ICHORITE_STAIRS.get());
        this.dropSelf(AetherIIBlocks.MARBLED_ICHORITE_SLAB.get());
        this.dropSelf(AetherIIBlocks.MARBLED_ICHORITE_WALL.get());

        // Marbled Bricks
        this.dropSelf(AetherIIBlocks.MARBLED_BRICKS.get());
        this.dropSelf(AetherIIBlocks.MARBLED_BRICK_STAIRS.get());
        this.dropSelf(AetherIIBlocks.MARBLED_BRICK_SLAB.get());
        this.dropSelf(AetherIIBlocks.MARBLED_BRICK_WALL.get());

        // Marbled Ichorite Decorative Blocks
        this.dropSelf(AetherIIBlocks.MARBLED_FLAGSTONES.get());
        this.dropSelf(AetherIIBlocks.MARBLED_KEYSTONE.get());
        this.dropSelf(AetherIIBlocks.MARBLED_BASE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.MARBLED_CAPSTONE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.MARBLED_BASE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.MARBLED_CAPSTONE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.MARBLED_PILLAR.get());

        // Agiosite
        this.dropSelf(AetherIIBlocks.AGIOSITE_STAIRS.get());
        this.add(AetherIIBlocks.AGIOSITE_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(AetherIIBlocks.AGIOSITE_WALL.get());

        // Agiosite Bricks
        this.dropSelf(AetherIIBlocks.AGIOSITE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.AGIOSITE_BRICK_STAIRS.get());
        this.add(AetherIIBlocks.AGIOSITE_BRICK_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(AetherIIBlocks.AGIOSITE_BRICK_WALL.get());

        // Agiosite Decorative Blocks
        this.dropSelf(AetherIIBlocks.AGIOSITE_FLAGSTONES.get());
        this.dropSelf(AetherIIBlocks.AGIOSITE_KEYSTONE.get());
        this.dropSelf(AetherIIBlocks.AGIOSITE_BASE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.AGIOSITE_CAPSTONE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.AGIOSITE_BASE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.AGIOSITE_CAPSTONE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.AGIOSITE_PILLAR.get());

        // Icestone
        this.dropSelf(AetherIIBlocks.ICESTONE_STAIRS.get());
        this.add(AetherIIBlocks.ICESTONE_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(AetherIIBlocks.ICESTONE_WALL.get());

        // Icestone Bricks
        this.dropSelf(AetherIIBlocks.ICESTONE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.ICESTONE_BRICK_STAIRS.get());
        this.add(AetherIIBlocks.ICESTONE_BRICK_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(AetherIIBlocks.ICESTONE_BRICK_WALL.get());

        // Icestone Decorative Blocks
        this.dropSelf(AetherIIBlocks.ICESTONE_FLAGSTONES.get());
        this.dropSelf(AetherIIBlocks.ICESTONE_KEYSTONE.get());
        this.dropSelf(AetherIIBlocks.ICESTONE_BASE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.ICESTONE_CAPSTONE_BRICKS.get());
        this.dropSelf(AetherIIBlocks.ICESTONE_BASE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.ICESTONE_CAPSTONE_PILLAR.get());
        this.dropSelf(AetherIIBlocks.ICESTONE_PILLAR.get());

        // Glass
        this.dropWhenSilkTouch(AetherIIBlocks.QUICKSOIL_GLASS.get());
        this.dropWhenSilkTouch(AetherIIBlocks.TILED_QUICKSOIL_GLASS.get());
        this.dropWhenSilkTouch(AetherIIBlocks.GRIDDED_QUICKSOIL_GLASS.get());
        this.dropWhenSilkTouch(AetherIIBlocks.SKYROOT_FRAMED_CRUDE_SCATTERGLASS.get());
        this.dropWhenSilkTouch(AetherIIBlocks.ARKENIUM_FRAMED_CRUDE_SCATTERGLASS.get());
        this.dropSelf(AetherIIBlocks.SCATTERGLASS.get());
        this.dropWhenSilkTouch(AetherIIBlocks.SKYROOT_FRAMED_SCATTERGLASS.get());
        this.dropWhenSilkTouch(AetherIIBlocks.ARKENIUM_FRAMED_SCATTERGLASS.get());

        // Glass Panes
        this.dropWhenSilkTouch(AetherIIBlocks.QUICKSOIL_GLASS_PANE.get());
        this.dropWhenSilkTouch(AetherIIBlocks.TILED_QUICKSOIL_GLASS_PANE.get());
        this.dropWhenSilkTouch(AetherIIBlocks.GRIDDED_QUICKSOIL_GLASS_PANE.get());
        this.dropSelf(AetherIIBlocks.CRUDE_SCATTERGLASS_PANE.get());
        this.dropWhenSilkTouch(AetherIIBlocks.SKYROOT_FRAMED_CRUDE_SCATTERGLASS_PANE.get());
        this.dropWhenSilkTouch(AetherIIBlocks.ARKENIUM_FRAMED_CRUDE_SCATTERGLASS_PANE.get());
        this.dropSelf(AetherIIBlocks.SCATTERGLASS_PANE.get());
        this.dropWhenSilkTouch(AetherIIBlocks.SKYROOT_FRAMED_SCATTERGLASS_PANE.get());
        this.dropWhenSilkTouch(AetherIIBlocks.ARKENIUM_FRAMED_SCATTERGLASS_PANE.get());

        // Wool
        this.dropSelf(AetherIIBlocks.CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.WHITE_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.ORANGE_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.MAGENTA_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.LIGHT_BLUE_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.YELLOW_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.LIME_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.PINK_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.GRAY_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.LIGHT_GRAY_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.CYAN_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.PURPLE_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.BLUE_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.BROWN_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.GREEN_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.RED_CLOUDWOOL.get());
        this.dropSelf(AetherIIBlocks.BLACK_CLOUDWOOL.get());

        // Carpet
        this.dropSelf(AetherIIBlocks.CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.WHITE_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.ORANGE_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.MAGENTA_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.LIGHT_BLUE_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.YELLOW_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.LIME_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.PINK_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.GRAY_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.LIGHT_GRAY_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.CYAN_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.PURPLE_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.BLUE_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.BROWN_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.GREEN_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.RED_CLOUDWOOL_CARPET.get());
        this.dropSelf(AetherIIBlocks.BLACK_CLOUDWOOL_CARPET.get());

        // Arkenium Blocks
        this.add(AetherIIBlocks.ARKENIUM_DOOR.get(), createDoorTable(AetherIIBlocks.ARKENIUM_DOOR.get()));
        this.dropSelf(AetherIIBlocks.ARKENIUM_TRAPDOOR.get());

        // Mineral Blocks
        this.dropSelf(AetherIIBlocks.AMBROSIUM_BLOCK.get());
        this.dropSelf(AetherIIBlocks.ZANITE_BLOCK.get());
        this.dropSelf(AetherIIBlocks.ARKENIUM_BLOCK.get());
        this.dropSelf(AetherIIBlocks.GRAVITITE_BLOCK.get());

        // Arilum Lantern
        this.dropSelf(AetherIIBlocks.GREEN_ARILUM_LANTERN.get());
        this.dropSelf(AetherIIBlocks.BLUE_ARILUM_LANTERN.get());
        this.dropSelf(AetherIIBlocks.PURPLE_ARILUM_LANTERN.get());
        this.dropSelf(AetherIIBlocks.GOLDEN_ARILUM_LANTERN.get());

        // Utility
        this.dropSelf(AetherIIBlocks.AMBROSIUM_TORCH.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_CRAFTING_TABLE.get());
        this.dropSelf(AetherIIBlocks.HOLYSTONE_FURNACE.get());
        this.dropSelf(AetherIIBlocks.ALTAR.get());
        this.dropSelf(AetherIIBlocks.ARKENIUM_FORGE.get());
        this.dropSelf(AetherIIBlocks.ARTISANS_BENCH.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_CHEST.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_LADDER.get());
        this.add(AetherIIBlocks.SKYROOT_BED.get(), (bed) -> createSinglePropConditionTable(bed, BedBlock.PART, BedPart.HEAD));

        this.dropOther(AetherIIBlocks.SKYROOT_WALL_SIGN.get(), AetherIIBlocks.SKYROOT_SIGN.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_SIGN.get());

        this.dropOther(AetherIIBlocks.SKYROOT_WALL_HANGING_SIGN.get(), AetherIIBlocks.SKYROOT_HANGING_SIGN.get());
        this.dropSelf(AetherIIBlocks.SKYROOT_HANGING_SIGN.get());

        this.dropOther(AetherIIBlocks.GREATROOT_WALL_SIGN.get(), AetherIIBlocks.GREATROOT_SIGN.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_SIGN.get());

        this.dropOther(AetherIIBlocks.GREATROOT_WALL_HANGING_SIGN.get(), AetherIIBlocks.GREATROOT_HANGING_SIGN.get());
        this.dropSelf(AetherIIBlocks.GREATROOT_HANGING_SIGN.get());

        this.dropOther(AetherIIBlocks.WISPROOT_WALL_SIGN.get(), AetherIIBlocks.WISPROOT_SIGN.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_SIGN.get());

        this.dropOther(AetherIIBlocks.WISPROOT_WALL_HANGING_SIGN.get(), AetherIIBlocks.WISPROOT_HANGING_SIGN.get());
        this.dropSelf(AetherIIBlocks.WISPROOT_HANGING_SIGN.get());

        // Bookshelves
        this.add(AetherIIBlocks.SKYROOT_BOOKSHELF.get(), (bookshelf) -> this.createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));
        this.add(AetherIIBlocks.HOLYSTONE_BOOKSHELF.get(), (bookshelf) -> this.createSingleItemTableWithSilkTouch(bookshelf, Items.BOOK, ConstantValue.exactly(3)));

        // Furniture
        this.dropNone(AetherIIBlocks.OUTPOST_CAMPFIRE.get());
    }

    @Override
    public Iterable<Block> getKnownBlocks() {
        return AetherIIBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
    }
}