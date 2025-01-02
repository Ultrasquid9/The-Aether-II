package com.aetherteam.aetherii.data.resources.builders.models;

import com.aetherteam.aetherii.AetherII;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class AetherIIModelTemplates {
    public static final ModelTemplate TEMPLATE_CUTOUT_MIPPED_CUBE_ALL = ModelTemplates.CUBE_ALL.extend().renderType("cutout_mipped").build();
    public static final ModelTemplate TEMPLATE_TRANSLUCENT_CUBE = ModelTemplates.CUBE.extend().renderType("translucent").build();
    public static final ModelTemplate TEMPLATE_TRANSLUCENT_CUBE_ALL = ModelTemplates.CUBE_ALL.extend().renderType("translucent").build();
    public static final ModelTemplate TEMPLATE_CUTOUT_CROSS = ModelTemplates.CROSS.extend().renderType("cutout").build();
    public static final ModelTemplate EMPTY = ModelTemplates.create("block", TextureSlot.PARTICLE);
    public static final ModelTemplate TINTED_GRASS = ModelTemplates.create("block", TextureSlot.BOTTOM, TextureSlot.PARTICLE, TextureSlot.TOP, AetherIITextureSlots.TOP_1, AetherIITextureSlots.TOP_2, AetherIITextureSlots.TOP_3, TextureSlot.SIDE, AetherIITextureSlots.SIDE_OVERLAY_1, AetherIITextureSlots.SIDE_OVERLAY_2, AetherIITextureSlots.SIDE_OVERLAY_3).extend()
            .renderType(ResourceLocation.withDefaultNamespace("cutout"))
            .element((builder) -> builder
                    .from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F)
                    .face(Direction.DOWN, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.BOTTOM).cullface(Direction.DOWN))
                    .face(Direction.UP, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.TOP).tintindex(0).cullface(Direction.UP))
                    .face(Direction.NORTH, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.SIDE).cullface(Direction.NORTH))
                    .face(Direction.SOUTH, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.SIDE).cullface(Direction.SOUTH))
                    .face(Direction.WEST, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.SIDE).cullface(Direction.WEST))
                    .face(Direction.EAST, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.SIDE).cullface(Direction.EAST))
            ).element((builder) -> builder
                    .from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F)
                    .face(Direction.UP, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("top_1")).tintindex(0).cullface(Direction.UP))
                    .face(Direction.NORTH, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_1")).tintindex(0).cullface(Direction.NORTH))
                    .face(Direction.SOUTH, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_1")).tintindex(0).cullface(Direction.SOUTH))
                    .face(Direction.WEST, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_1")).tintindex(0).cullface(Direction.WEST))
                    .face(Direction.EAST, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_1")).tintindex(0).cullface(Direction.EAST))
            ).element((builder) -> builder
                    .from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F)
                    .face(Direction.UP, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("top_1")).tintindex(0).cullface(Direction.UP))
                    .face(Direction.NORTH, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_1")).tintindex(0).cullface(Direction.NORTH))
                    .face(Direction.SOUTH, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_1")).tintindex(0).cullface(Direction.SOUTH))
                    .face(Direction.WEST, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_1")).tintindex(0).cullface(Direction.WEST))
                    .face(Direction.EAST, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_1")).tintindex(0).cullface(Direction.EAST))
            ).element((builder) -> builder
                    .from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F)
                    .face(Direction.UP, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("top_2")).tintindex(1).cullface(Direction.UP))
                    .face(Direction.NORTH, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_2")).tintindex(1).cullface(Direction.NORTH))
                    .face(Direction.SOUTH, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_2")).tintindex(1).cullface(Direction.SOUTH))
                    .face(Direction.WEST, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_2")).tintindex(1).cullface(Direction.WEST))
                    .face(Direction.EAST, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_2")).tintindex(1).cullface(Direction.EAST))
            ).element((builder) -> builder
                    .from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F)
                    .face(Direction.UP, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("top_3")).tintindex(2).cullface(Direction.UP))
                    .face(Direction.NORTH, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_3")).tintindex(2).cullface(Direction.NORTH))
                    .face(Direction.SOUTH, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_3")).tintindex(2).cullface(Direction.SOUTH))
                    .face(Direction.WEST, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_3")).tintindex(2).cullface(Direction.WEST))
                    .face(Direction.EAST, (faceBuilder) -> faceBuilder.uvs(0, 0, 16, 16).texture(TextureSlot.create("side_overlay_3")).tintindex(2).cullface(Direction.EAST))
            ).build();
    public static final ModelTemplate THIN = ModelTemplates.create("thin_block", TextureSlot.ALL);
    public static final ModelTemplate DIRT_PATH = ModelTemplates.create("dirt_path", TextureSlot.BOTTOM, TextureSlot.PARTICLE, TextureSlot.TOP, TextureSlot.SIDE);
    public static final ModelTemplate LEAVES = ModelTemplates.create("leaves", TextureSlot.ALL).extend().renderType(ResourceLocation.withDefaultNamespace("cutout_mipped")).build();
    public static final ModelTemplate TRANSLUCENT_INNER_FACES = ModelTemplates.create("cube", TextureSlot.PARTICLE, TextureSlot.NORTH, TextureSlot.SOUTH, TextureSlot.EAST, TextureSlot.WEST, TextureSlot.UP, TextureSlot.DOWN).extend()
            .renderType(ResourceLocation.withDefaultNamespace("translucent"))
            .element((builder) -> builder
                    .from(0.0F, 15.998F, 0.0F).to(16.0F, 16.0F, 16.0F)
                    .face(Direction.DOWN, (faceBuilder) -> faceBuilder.texture(TextureSlot.UP).uvs(0, 16, 16, 0).cullface(Direction.UP))
                    .face(Direction.UP, (faceBuilder) -> faceBuilder.texture(TextureSlot.UP).uvs(0, 0, 16, 16).cullface(Direction.UP))
            ).element((builder) -> builder
                    .from(0.0F, 0.0F, 0.0F).to(16.0F, 0.002F, 16.0F)
                    .face(Direction.DOWN, (faceBuilder) -> faceBuilder.texture(TextureSlot.DOWN).uvs(0, 0, 16, 16).cullface(Direction.DOWN))
                    .face(Direction.UP, (faceBuilder) -> faceBuilder.texture(TextureSlot.DOWN).uvs(0, 16, 16, 0).cullface(Direction.DOWN))
            ).element((builder) -> builder
                    .from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 0.002F)
                    .face(Direction.NORTH, (faceBuilder) -> faceBuilder.texture(TextureSlot.NORTH).uvs(0, 0, 16, 16).cullface(Direction.NORTH))
                    .face(Direction.SOUTH, (faceBuilder) -> faceBuilder.texture(TextureSlot.NORTH).uvs(16, 0, 0, 16).cullface(Direction.NORTH))
            ).element((builder) -> builder
                    .from(0.0F, 0.0F, 15.998F).to(16.0F, 16.0F, 16.0F)
                    .face(Direction.NORTH, (faceBuilder) -> faceBuilder.texture(TextureSlot.SOUTH).uvs(16, 0, 0, 16).cullface(Direction.SOUTH))
                    .face(Direction.SOUTH, (faceBuilder) -> faceBuilder.texture(TextureSlot.SOUTH).uvs(0, 0, 16, 16).cullface(Direction.SOUTH))
            ).element((builder) -> builder
                    .from(0.0F, 0.0F, 0.0F).to(0.002F, 16.0F, 16.0F)
                    .face(Direction.WEST, (faceBuilder) -> faceBuilder.texture(TextureSlot.WEST).uvs(0, 0, 16, 16).cullface(Direction.WEST))
                    .face(Direction.EAST, (faceBuilder) -> faceBuilder.texture(TextureSlot.WEST).uvs(16, 0, 0, 16).cullface(Direction.WEST))
            ).element((builder) -> builder
                    .from(15.998F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F)
                    .face(Direction.WEST, (faceBuilder) -> faceBuilder.texture(TextureSlot.EAST).uvs(16, 0, 0, 16).cullface(Direction.EAST))
                    .face(Direction.EAST, (faceBuilder) -> faceBuilder.texture(TextureSlot.EAST).uvs(0, 0, 16, 16).cullface(Direction.EAST))
            ).build();
    public static final ModelTemplate LADDER = ModelTemplates.create("ladder", TextureSlot.TEXTURE, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();

    public static final ModelTemplate ASYMMETRICAL_CROSS_EVEN = create("asymmetrical_cross_even", TextureSlot.CROSS, AetherIITextureSlots.CROSS_OTHER, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate ASYMMETRICAL_CROSS_EVEN_MIRRORED = create("asymmetrical_cross_even_mirrored", "_mirrored", TextureSlot.CROSS, AetherIITextureSlots.CROSS_OTHER, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate ASYMMETRICAL_CROSS_ODD = create("asymmetrical_cross_odd", TextureSlot.CROSS, AetherIITextureSlots.CROSS_OTHER, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate ASYMMETRICAL_CROSS_ODD_MIRRORED = create("asymmetrical_cross_odd_mirrored", "_mirrored", TextureSlot.CROSS, AetherIITextureSlots.CROSS_OTHER, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate POTTED_ASYMMETRICAL_CROSS_EVEN = create("flower_pot_asymmetrical_cross_even", TextureSlot.CROSS, AetherIITextureSlots.CROSS_OTHER).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate POTTED_ASYMMETRICAL_CROSS_ODD = create("flower_pot_asymmetrical_cross_odd", TextureSlot.CROSS, AetherIITextureSlots.CROSS_OTHER).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate LILICHIME = create("template_lilichime", TextureSlot.PLANT).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate PLURACIAN = create("template_pluracian", TextureSlot.PLANT).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate POTTED_LILICHIME = create("flower_pot_lilichime", TextureSlot.PLANT).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate POTTED_PLURACIAN = create("flower_pot_pluracian", TextureSlot.PLANT).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate BRYALINN_MOSS_FLOWERS_1 = create("template_bryalinn_moss_flowers_1", "_1", TextureSlot.FLOWERBED, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate BRYALINN_MOSS_FLOWERS_2 = create("template_bryalinn_moss_flowers_2", "_2", TextureSlot.FLOWERBED, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate BRYALINN_MOSS_FLOWERS_3 = create("template_bryalinn_moss_flowers_3", "_3", TextureSlot.FLOWERBED, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate BRYALINN_MOSS_FLOWERS_4 = create("template_bryalinn_moss_flowers_4", "_4", TextureSlot.FLOWERBED, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate HOLPUPEA_1 = create("template_holpupea_1", "_1", TextureSlot.FLOWERBED, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate HOLPUPEA_2 = create("template_holpupea_2", "_2", TextureSlot.FLOWERBED, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate HOLPUPEA_3 = create("template_holpupea_3", "_3", TextureSlot.FLOWERBED, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate HOLPUPEA_4 = create("template_holpupea_4", "_4", TextureSlot.FLOWERBED, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate TARAHESP_FLOWERS_1 = create("template_tarahesp_flowers_1", "_1", AetherIITextureSlots.TARAHESP_FLOWERS_PURPLE, AetherIITextureSlots.TARAHESP_FLOWERS_WHITE, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate TARAHESP_FLOWERS_2 = create("template_tarahesp_flowers_2", "_2", AetherIITextureSlots.TARAHESP_FLOWERS_PURPLE, AetherIITextureSlots.TARAHESP_FLOWERS_WHITE, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate TARAHESP_FLOWERS_3 = create("template_tarahesp_flowers_3", "_3", AetherIITextureSlots.TARAHESP_FLOWERS_PURPLE, AetherIITextureSlots.TARAHESP_FLOWERS_WHITE, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate TARAHESP_FLOWERS_4 = create("template_tarahesp_flowers_4", "_4", AetherIITextureSlots.TARAHESP_FLOWERS_PURPLE, AetherIITextureSlots.TARAHESP_FLOWERS_WHITE, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate DOOR_BOTTOM_LEFT = create("door_bottom_left", "_bottom_left", TextureSlot.ALL, TextureSlot.BOTTOM, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate DOOR_BOTTOM_LEFT_OPEN = create("door_bottom_left_open", "_bottom_left_open", TextureSlot.ALL, TextureSlot.BOTTOM, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate DOOR_BOTTOM_RIGHT = create("door_bottom_right", "_bottom_right", TextureSlot.ALL, TextureSlot.BOTTOM, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate DOOR_BOTTOM_RIGHT_OPEN = create("door_bottom_right_open", "_bottom_right_open", TextureSlot.ALL, TextureSlot.BOTTOM, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate DOOR_TOP_LEFT = create("door_top_left", "_top_left", TextureSlot.TOP, TextureSlot.ALL, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate DOOR_TOP_LEFT_OPEN = create("door_top_left_open", "_top_left_open", TextureSlot.TOP, TextureSlot.ALL, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate DOOR_TOP_RIGHT = create("door_top_right", "_top_right", TextureSlot.TOP, TextureSlot.ALL, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate DOOR_TOP_RIGHT_OPEN = create("door_top_right_open", "_top_right_open", TextureSlot.TOP, TextureSlot.ALL, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate ORIENTABLE_SECRET_TRAPDOOR_TOP = create("template_orientable_secret_trapdoor_top", "_top", TextureSlot.TEXTURE);
    public static final ModelTemplate ORIENTABLE_SECRET_TRAPDOOR_BOTTOM = create("template_orientable_secret_trapdoor_bottom", "_bottom", TextureSlot.TEXTURE);
    public static final ModelTemplate ORIENTABLE_SECRET_TRAPDOOR_OPEN = create("template_orientable_secret_trapdoor_open", "_open", TextureSlot.TEXTURE);
    public static final ModelTemplate TALL_TORCH = create("template_tall_torch", TextureSlot.TORCH);
    public static final ModelTemplate TALL_WALL_TORCH = create("template_tall_wall_torch", TextureSlot.TORCH);
    public static final ModelTemplate ALTAR = create("template_altar", TextureSlot.ALL, TextureSlot.PARTICLE);
    public static final ModelTemplate ARTISANS_BENCH = create("template_artisans_bench", TextureSlot.ALL, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();
    public static final ModelTemplate ARKENIUM_FORGE = create("template_arkenium_forge", TextureSlot.ALL, TextureSlot.PARTICLE).extend().renderType(ResourceLocation.withDefaultNamespace("cutout")).build();

    public static final ModelTemplate TRANSLUCENT_FLAT_ITEM = ModelTemplates.FLAT_ITEM.extend().renderType(ResourceLocation.withDefaultNamespace("translucent")).build();
    public static final ModelTemplate SMALL_CRYSTAL = ModelTemplates.createItem("small_amethyst_bud", TextureSlot.LAYER0);
    public static final ModelTemplate MEDIUM_CRYSTAL = ModelTemplates.createItem("medium_amethyst_bud", TextureSlot.LAYER0);
    public static final ModelTemplate LARGE_CRYSTAL = ModelTemplates.createItem("large_amethyst_bud", TextureSlot.LAYER0);
    public static final ModelTemplate FULL_CRYSTAL = ModelTemplates.createItem("amethyst_cluster", TextureSlot.LAYER0);
    public static final ModelTemplate POINTED_STONE = ModelTemplates.createItem("pointed_dripstone", TextureSlot.LAYER0);

    public static ModelTemplate create(TextureSlot... textureSlot) {
        return new ModelTemplate(Optional.empty(), Optional.empty(), textureSlot);
    }

    public static ModelTemplate create(String path, TextureSlot... textureSlot) {
        return new ModelTemplate(Optional.of(decorateBlockModelLocation(path)), Optional.empty(), textureSlot);
    }

    public static ModelTemplate create(String path, String suffix, TextureSlot... textureSlot) {
        return new ModelTemplate(Optional.of(decorateBlockModelLocation(path)), Optional.of(suffix), textureSlot);
    }

    /**
     * Based on {@link ModelTemplate#getDefaultModelLocation(Block)}
     */
    public static ResourceLocation decorateBlockModelLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath(AetherII.MODID, path).withPrefix("block/");
    }
}