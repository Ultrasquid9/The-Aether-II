package com.aetherteam.aetherii.client.renderer;

import com.aetherteam.aetherii.AetherII;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class AetherIIRenderTypes {
    public static final ResourceLocation GLINT_ENTITY = ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "textures/misc/irradiated_glint_entity.png");
    public static final ResourceLocation GLINT_ITEM = ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "textures/misc/irradiated_glint_item.png");

    public static final RenderType ENTITY_GLINT_DIRECT = RenderType.create(
            "aether_ii:irradiated_entity_glint_direct",
            DefaultVertexFormat.POSITION_TEX,
            VertexFormat.Mode.QUADS,
            1536,
            RenderType.CompositeState.builder()
                    .setShaderState(RenderType.RENDERTYPE_ENTITY_GLINT_DIRECT_SHADER)
                    .setTextureState(new RenderStateShard.TextureStateShard(GLINT_ENTITY, true, false))
                    .setWriteMaskState(RenderType.COLOR_WRITE)
                    .setCullState(RenderType.NO_CULL)
                    .setDepthTestState(RenderType.EQUAL_DEPTH_TEST)
                    .setTransparencyState(RenderType.GLINT_TRANSPARENCY)
                    .setTexturingState(RenderType.ENTITY_GLINT_TEXTURING)
                    .createCompositeState(false)
    );
    public static final RenderType GLINT = RenderType.create(
            "aether_ii:irradiated_glint",
            DefaultVertexFormat.POSITION_TEX,
            VertexFormat.Mode.QUADS,
            1536,
            RenderType.CompositeState.builder()
                    .setShaderState(RenderType.RENDERTYPE_GLINT_SHADER)
                    .setTextureState(new RenderStateShard.TextureStateShard(GLINT_ITEM, true, false))
                    .setWriteMaskState(RenderType.COLOR_WRITE)
                    .setCullState(RenderType.NO_CULL)
                    .setDepthTestState(RenderType.EQUAL_DEPTH_TEST)
                    .setTransparencyState(RenderType.GLINT_TRANSPARENCY)
                    .setTexturingState(RenderType.GLINT_TEXTURING)
                    .createCompositeState(false)
    );
}
