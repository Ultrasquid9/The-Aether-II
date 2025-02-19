package com.aetherteam.aetherii.data.providers;

import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.block.AetherIIBlockStateProperties;
import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.block.natural.*;
import com.aetherteam.aetherii.item.AetherIIItems;
import com.aetherteam.aetherii.item.components.AetherIIDataComponents;
import com.aetherteam.nitrogen.data.providers.NitrogenBlockLootSubProvider;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;
import java.util.stream.IntStream;

public abstract class AetherIIBlockLootSubProvider extends NitrogenBlockLootSubProvider {
    public AetherIIBlockLootSubProvider(Set<Item> items, FeatureFlagSet flags, HolderLookup.Provider registries) {
        super(items, flags, registries);
    }

    public static final BooleanProperty GROWN = AetherIIBlockStateProperties.BRETTL_GROWN;

    protected LootTable.Builder droppingIrradiatedDustLoot(Block block) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(this.hasSilkTouch()).add(LootItem.lootTableItem(block)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(this.hasSilkTouch().invert())
                        .add(LootItem.lootTableItem(AetherIIItems.IRRADIATED_WEAPON.get()))
                        .add(LootItem.lootTableItem(AetherIIItems.IRRADIATED_TOOL.get()))
                        .add(LootItem.lootTableItem(AetherIIItems.IRRADIATED_ARMOR.get()))
                        .add(LootItem.lootTableItem(AetherIIItems.IRRADIATED_CHUNK.get()))
                );
    }

    protected LootTable.Builder createSkyRootsDrops(Block block) {
        return this.createSilkTouchOrShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(AetherIIItems.SKYROOT_STICK.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))))
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(this.hasShears().or(this.hasSilkTouch()).invert())
                                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(AetherIIItems.ARCTIC_SNOWBALL.get())
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AetherHangingRootsBlock.SNOWY, true)))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                )));
    }

    public LootTable.Builder droppingSnowLayer(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool()
                        .when(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS))
                        .add(AlternativesEntry.alternatives(
                                AlternativesEntry.alternatives(
                                        SnowLayerBlock.LAYERS.getPossibleValues(),
                                        layer -> ((LootPoolSingletonContainer.Builder<?>) LootItem.lootTableItem(AetherIIItems.ARCTIC_SNOWBALL)
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, layer))))
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly((float) layer)))).when(this.doesNotHaveSilkTouch()),
                                AlternativesEntry.alternatives(
                                        SnowLayerBlock.LAYERS.getPossibleValues(),
                                        layer -> layer == 8 ? LootItem.lootTableItem(AetherIIBlocks.ARCTIC_SNOW_BLOCK) : LootItem.lootTableItem(AetherIIBlocks.ARCTIC_SNOW)
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly((float) layer)))
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, layer))))
                                )
                        )
        );
    }

    protected LootTable.Builder createQuartzOreDrops(Block block) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(Items.QUARTZ)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    public LootTable.Builder droppingAmberoot(HolderGetter<Item> holderGetter, Block original, Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return LootTable.lootTable()
                .withPool(this.applyExplosionDecay(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(original)
                        .when(this.hasSilkTouch()))))
                .withPool(this.applyExplosionDecay(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(block)
                        .when(this.hasSilkTouch().invert()))))
                .withPool(this.applyExplosionDecay(item, LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(item)
                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(holderGetter, AetherIITags.Items.GOLDEN_AMBER_HARVESTERS)))
                        .when(this.hasSilkTouch().invert())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))));
    }

    public LootTable.Builder createShearsOnlyDrop(ItemLike p_250684_) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(this.hasShears()).add(LootItem.lootTableItem(p_250684_)));
    }

    public LootTable.Builder droppingLeafPile(Block block, Block leaves) {
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .when(this.hasShears())
                .when(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS))
                .add(AlternativesEntry.alternatives(
                        AetherLeafPileBlock.PILES.getPossibleValues(),
                        piles -> piles == 16 ? LootItem.lootTableItem(leaves) : LootItem.lootTableItem(block)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly((float) piles)))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AetherLeafPileBlock.PILES, piles))))

                )
        );
    }

    public LootTable.Builder droppingWithChancesAndSkyrootSticks(Block block, Block sapling, float... chances) {
        HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        HolderLookup.RegistryLookup<Item> itemLookup = this.registries.lookupOrThrow(Registries.ITEM);
        return createForgeSilkTouchOrShearsDispatchTable(itemLookup, block, this.applyExplosionCondition( block, LootItem.lootTableItem(sapling)).when(BonusLevelTableCondition.bonusLevelFlatChance(enchantmentLookup.getOrThrow(Enchantments.FORTUNE), chances)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).when(this.hasShears().or(this.hasSilkTouch()).invert())
                        .add(this.applyExplosionDecay(block,
                                        LootItem.lootTableItem(AetherIIItems.SKYROOT_STICK.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(enchantmentLookup.getOrThrow(Enchantments.FORTUNE), 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(this.hasShears().or(this.hasSilkTouch()).invert())
                                .add(this.applyExplosionCondition(block, LootItem.lootTableItem(AetherIIItems.SKYROOT_PINECONE.get()))
                                        .when(BonusLevelTableCondition.bonusLevelFlatChance(enchantmentLookup.getOrThrow(Enchantments.FORTUNE), 0.01F, 0.011111112F, 0.0125F, 0.0111111125F, 0.05F))));
//                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(this.hasShears().or(this.hasSilkTouch()).invert())
//                        .add(this.applyExplosionCondition(block, LootItem.lootTableItem(Items.AIR).apply(SpawnSkyrootLizard.builder()))
//                                .when(BonusLevelTableCondition.bonusLevelFlatChance(enchantmentLookup.getOrThrow(Enchantments.FORTUNE), 0.001F, 0.0011111112F, 0.00125F, 0.00111111125F, 0.005F))));
    }

    protected LootTable.Builder createSilkTouchOrShearsTable(ItemLike item) {
        return LootTable.lootTable().withPool(LootPool.lootPool().when(this.hasShears().or(this.hasSilkTouch())).setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(item)));
    }

    public LootTable.Builder droppingArilumBulbs(HolderGetter<Item> holderGetter, Block block, Item drop) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))
                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(holderGetter, AetherIITags.Items.TOOLS_TROWELS)).invert()))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))
                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(holderGetter, AetherIITags.Items.TOOLS_TROWELS))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(block)).when(this.hasShears().or(this.hasSilkTouch())));
    }

    public LootTable.Builder droppingSativalShoot(HolderGetter<Item> holderGetter, Block block, Item drop) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        HolderLookup.RegistryLookup<Item> itemLookup = this.registries.lookupOrThrow(Registries.ITEM);
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(holderGetter, AetherIITags.Items.TOOLS_TROWELS)))
        ).withPool(LootPool.lootPool().add(LootItem.lootTableItem(block)).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemLookup, AetherIITags.Items.TOOLS_TROWELS)).invert()));
    }

    public LootTable.Builder droppingBerryBush(HolderGetter<Item> holderGetter, Block block, Block stem, Item drop) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(holderGetter, AetherIITags.Items.TOOLS_TROWELS)).invert())
                .when(this.hasSilkTouch().invert())
        ).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(holderGetter, AetherIITags.Items.TOOLS_TROWELS)))
                .when(this.hasSilkTouch().invert())
        ).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(block))
                .when(this.hasSilkTouch())
        ).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(stem)
                        .when(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS).invert()))
        );
    }

    public LootTable.Builder droppingOrangeTree(HolderGetter<Item> holderGetter, Block block, Item drop) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OrangeTreeBlock.AGE, 4)))
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)))
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(holderGetter, AetherIITags.Items.TOOLS_TROWELS)).invert())
        ).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OrangeTreeBlock.AGE, 4)))
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)))
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(holderGetter, AetherIITags.Items.TOOLS_TROWELS)))
        ).withPool(LootPool.lootPool()
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)))
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OrangeTreeBlock.AGE, 4)).invert())
                .add(LootItem.lootTableItem(block))
        );
    }

    public LootTable.Builder droppingValkyrieSprout(HolderGetter<Item> holderGetter, Block block, Item drop) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ValkyrieSproutBlock.AGE, 2)))
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(holderGetter, AetherIITags.Items.TOOLS_TROWELS)).invert())
        ).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ValkyrieSproutBlock.AGE, 2)))
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(holderGetter, AetherIITags.Items.TOOLS_TROWELS)))
        ).withPool(LootPool.lootPool().add(LootItem.lootTableItem(block)));
    }

    protected LootTable.Builder dropTwigs(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block)
                                                .apply(IntStream.rangeClosed(1, 4).boxed().toList(), count -> SetItemCountFunction.setCount(ConstantValue.exactly((float) count))
                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TwigBlock.AMOUNT, count))))
                                )
                        )
        );
    }

    protected LootTable.Builder dropRocks(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block)
                                .apply(IntStream.rangeClosed(1, 4).boxed().toList(), count -> SetItemCountFunction.setCount(ConstantValue.exactly((float) count))
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RockBlock.AMOUNT, count))))
                        )
                )
        );
    }

    protected LootTable.Builder droppingBrettlPlant(Block block, ItemLike drop, ItemLike dropGrown) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(dropGrown)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GROWN, true)))
                                ))
                        )
                );
    }

    protected LootTable.Builder droppingBrettlPlantTip(Block block, ItemLike drop, ItemLike dropGrown) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(drop).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GROWN, false))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(this.applyExplosionDecay(block, LootItem.lootTableItem(dropGrown).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GROWN, true)))
        );
    }

    protected LootTable.Builder droppingMoaEgg(Block block) {
        return LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(block)
                        .apply(CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY).include(AetherIIDataComponents.MOA_EGG_TYPE.get()))))
        );
    }
}