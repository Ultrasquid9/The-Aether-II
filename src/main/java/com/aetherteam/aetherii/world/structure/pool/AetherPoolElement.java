package com.aetherteam.aetherii.world.structure.pool;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.properties.StructureMode;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Based on {@link net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement}
 * Used primarily for deleting Structure Templates that end up in generating in some rare circumstances
 * Also used for Datagen
 */
public class AetherPoolElement extends StructurePoolElement {
    private static final Comparator<StructureTemplate.JigsawBlockInfo> HIGHEST_SELECTION_PRIORITY_FIRST = Comparator.comparingInt(StructureTemplate.JigsawBlockInfo::selectionPriority).reversed();
    private static final Codec<Either<ResourceLocation, StructureTemplate>> TEMPLATE_CODEC = Codec.of(
            AetherPoolElement::encodeTemplate, ResourceLocation.CODEC.map(Either::left)
    );
    public static final MapCodec<AetherPoolElement> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(templateCodec(), processorsCodec(), projectionCodec(), overrideLiquidSettingsCodec()).apply(instance, AetherPoolElement::new)
    );
    protected final Either<ResourceLocation, StructureTemplate> template;
    protected final Holder<StructureProcessorList> processors;
    protected final Optional<LiquidSettings> overrideLiquidSettings;

    private static <T> DataResult<T> encodeTemplate(Either<ResourceLocation, StructureTemplate> p_210425_, DynamicOps<T> p_210426_, T p_210427_) {
        Optional<ResourceLocation> optional = p_210425_.left();
        return optional.isEmpty()
                ? DataResult.error(() -> "Can not serialize a runtime pool element")
                : ResourceLocation.CODEC.encode(optional.get(), p_210426_, p_210427_);
    }

    protected static <E extends AetherPoolElement> RecordCodecBuilder<E, Holder<StructureProcessorList>> processorsCodec() {
        return StructureProcessorType.LIST_CODEC.fieldOf("processors").forGetter(codec -> codec.processors);
    }

    protected static <E extends AetherPoolElement> RecordCodecBuilder<E, Optional<LiquidSettings>> overrideLiquidSettingsCodec() {
        return LiquidSettings.CODEC.optionalFieldOf("override_liquid_settings").forGetter((codec) -> codec.overrideLiquidSettings);
    }

    protected static <E extends AetherPoolElement> RecordCodecBuilder<E, Either<ResourceLocation, StructureTemplate>> templateCodec() {
        return TEMPLATE_CODEC.fieldOf("location").forGetter(codec -> codec.template);
    }

    public AetherPoolElement(Either<ResourceLocation, StructureTemplate> template, Holder<StructureProcessorList> processors, StructureTemplatePool.Projection projection, Optional<LiquidSettings> overrideLiquidSettings) {
        super(projection);
        this.template = template;
        this.processors = processors;
        this.overrideLiquidSettings = overrideLiquidSettings;
    }

    @Override
    public Vec3i getSize(StructureTemplateManager templateManager, Rotation rotation) {
        StructureTemplate template = this.getTemplate(templateManager);
        return template.getSize(rotation);
    }

    private StructureTemplate getTemplate(StructureTemplateManager templateManager) {
        return this.template.map(templateManager::getOrCreate, Function.identity());
    }

    public List<StructureTemplate.StructureBlockInfo> getDataMarkers(StructureTemplateManager templateManager, BlockPos pos, Rotation rotation, boolean relativePosition) {
        StructureTemplate structuretemplate = this.getTemplate(templateManager);
        List<StructureTemplate.StructureBlockInfo> listFilter = structuretemplate.filterBlocks(
                pos, new StructurePlaceSettings().setRotation(rotation), Blocks.STRUCTURE_BLOCK, relativePosition
        );
        List<StructureTemplate.StructureBlockInfo> listInfo = Lists.newArrayList();

        for(StructureTemplate.StructureBlockInfo structureBlockInfo : listFilter) {
            CompoundTag compoundtag = structureBlockInfo.nbt();
            if (compoundtag != null) {
                StructureMode mode = StructureMode.valueOf(compoundtag.getString("mode"));
                if (mode == StructureMode.DATA) {
                    listInfo.add(structureBlockInfo);
                }
            }
        }

        return listInfo;
    }

    @Override
    public List<StructureTemplate.JigsawBlockInfo> getShuffledJigsawBlocks(StructureTemplateManager structureTemplateManager, BlockPos pos, Rotation rotation, RandomSource random) {
        List<StructureTemplate.JigsawBlockInfo> list = this.getTemplate(structureTemplateManager).getJigsaws(pos, rotation);
        Util.shuffle(list, random);
        sortBySelectionPriority(list);
        return list;
    }

    @VisibleForTesting
    static void sortBySelectionPriority(List<StructureTemplate.JigsawBlockInfo> structureBlockInfos) {
        structureBlockInfos.sort(HIGHEST_SELECTION_PRIORITY_FIRST);
    }

    @Override
    public BoundingBox getBoundingBox(StructureTemplateManager templateManager, BlockPos pos, Rotation rotation) {
        StructureTemplate structuretemplate = this.getTemplate(templateManager);
        return structuretemplate.getBoundingBox(new StructurePlaceSettings().setRotation(rotation), pos);
    }

    @Override
    public boolean place(StructureTemplateManager templateManager, WorldGenLevel level, StructureManager structureManager, ChunkGenerator generator, BlockPos offset, BlockPos pos, Rotation rotation, BoundingBox box, RandomSource random, LiquidSettings liquidSettings, boolean keepJigsaws) {
        StructureTemplate template = this.getTemplate(templateManager);
        StructurePlaceSettings settings = this.getSettings(rotation, box, liquidSettings, keepJigsaws);
        if (pos.getY() > 96) { // Deletes templates that generated below the cloudbed
            if (!template.placeInWorld(level, offset, pos, settings, random, 18)) {
                return false;
            } else {
                for (StructureTemplate.StructureBlockInfo structureBlockInfo : StructureTemplate.processBlockInfos(
                        level, offset, pos, settings, this.getDataMarkers(templateManager, offset, rotation, false)
                )) {
                    this.handleDataMarker(level, structureBlockInfo, offset, rotation, random, box);
                }

                return true;
            }
        }
        return false;
    }

    /**
     * Uses processors of {@link net.minecraft.world.level.levelgen.structure.pools.LegacySinglePoolElement}
     * Might have a coded to determine if it should use processors of Single or Legacy Pool Elements in the future
     * */
    protected StructurePlaceSettings getSettings(Rotation rotation, BoundingBox boundingBox, LiquidSettings liquidSettings, boolean offset) {
        StructurePlaceSettings settings = new StructurePlaceSettings();
        settings.setBoundingBox(boundingBox);
        settings.setRotation(rotation);
        settings.setKnownShape(true);
        settings.setIgnoreEntities(false);
        settings.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
        settings.addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
        settings.setLiquidSettings(this.overrideLiquidSettings.orElse(liquidSettings));
        settings.setFinalizeEntities(true);
        if (!offset) {
            settings.addProcessor(JigsawReplacementProcessor.INSTANCE);
        }

        this.processors.value().list().forEach(settings::addProcessor);
        this.getProjection().getProcessors().forEach(settings::addProcessor);
        return settings;
    }

    @Override
    public StructurePoolElementType<?> getType() {
        return AetherIIPoolElementTypes.AETHER.get();
    }

    @Override
    public String toString() {
        return "Single[" + this.template + "]";
    }
}