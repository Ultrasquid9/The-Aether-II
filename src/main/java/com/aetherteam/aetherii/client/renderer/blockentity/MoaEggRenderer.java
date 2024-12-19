package com.aetherteam.aetherii.client.renderer.blockentity;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.block.miscellaneous.MoaEggBlock;
import com.aetherteam.aetherii.blockentity.MoaEggBlockEntity;
import com.aetherteam.aetherii.client.renderer.AetherIIModelLayers;
import com.aetherteam.aetherii.client.renderer.entity.MoaRenderer;
import com.aetherteam.aetherii.client.renderer.entity.model.MoaEggModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;

public class MoaEggRenderer implements BlockEntityRenderer<MoaEggBlockEntity> {
//    public static ResourceLocation KERATIN_LOCATION = ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "textures/entity/tiles/moa_egg/moa_egg_keratin.png");
//    public static ResourceLocation EYES_LOCATION = ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "textures/entity/tiles/moa_egg/moa_egg_eyes.png");
//    public static ResourceLocation FEATHERS_LOCATION = ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "textures/entity/tiles/moa_egg/moa_egg_feathers.png");

    private final MoaEggModel moaEggModel;
    private final TextureAtlas moaFeathersAtlas;
    private final TextureAtlas moaKeratinAtlas;
    private final TextureAtlas moaEyesAtlas;

    public MoaEggRenderer(BlockEntityRendererProvider.Context pContext) {
        this.moaEggModel = new MoaEggModel(pContext.getModelSet().bakeLayer(AetherIIModelLayers.MOA_EGG));
        this.moaFeathersAtlas = Minecraft.getInstance().getModelManager().getAtlas(MoaRenderer.MOA_FEATHER_SHEET);
        this.moaKeratinAtlas = Minecraft.getInstance().getModelManager().getAtlas(MoaRenderer.MOA_KERATIN_SHEET);
        this.moaEyesAtlas = Minecraft.getInstance().getModelManager().getAtlas(MoaRenderer.MOA_EYES_SHEET);
    }

    @Override
    public void render(MoaEggBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (pBlockEntity.getBlockState().getBlock() instanceof MoaEggBlock moaEggBlock) {
            pPoseStack.translate(0.5F, 1.5F, 0.5F);
            pPoseStack.mulPose(Axis.XN.rotationDegrees(180F));
            if (pBlockEntity.getBlockState().getValue(MoaEggBlock.HATCH) > 0) {
                pPoseStack.mulPose(Axis.YP.rotationDegrees((float) (Math.cos((double) pBlockEntity.tickCount * 3.25) * Math.PI * 0.4F * pBlockEntity.getBlockState().getValue(MoaEggBlock.HATCH))));
            }

            TextureAtlasSprite feathersSprite = this.moaFeathersAtlas.getSprite(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "entity/tiles/moa_egg/moa_egg_feather_" + pBlockEntity.getBlockState().getValue(MoaEggBlock.FEATHER_SHAPE).getSerializedName() + "_" + pBlockEntity.getBlockState().getValue(MoaEggBlock.FEATHERS).getSerializedName()));
            VertexConsumer feathersConsumer = feathersSprite.wrap(pBuffer.getBuffer(RenderType.entityCutoutNoCull(MoaRenderer.MOA_FEATHER_SHEET)));
            this.moaEggModel.renderToBuffer(pPoseStack, feathersConsumer, pPackedLight, pPackedOverlay);

            TextureAtlasSprite eyesSprite = this.moaEyesAtlas.getSprite(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "entity/tiles/moa_egg/moa_egg_eyes_" + pBlockEntity.getBlockState().getValue(MoaEggBlock.EYES).getSerializedName()));
            VertexConsumer eyesConsumer = eyesSprite.wrap(pBuffer.getBuffer(RenderType.entityCutoutNoCull(MoaRenderer.MOA_EYES_SHEET)));
            this.moaEggModel.renderToBuffer(pPoseStack, eyesConsumer, pPackedLight, pPackedOverlay);

            TextureAtlasSprite keratinSprite = this.moaKeratinAtlas.getSprite(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "entity/tiles/moa_egg/moa_egg_keratin_" + pBlockEntity.getBlockState().getValue(MoaEggBlock.KERATIN).getSerializedName()));
            VertexConsumer keratinConsumer = keratinSprite.wrap(pBuffer.getBuffer(RenderType.entityCutoutNoCull(MoaRenderer.MOA_KERATIN_SHEET)));
            this.moaEggModel.renderToBuffer(pPoseStack, keratinConsumer, pPackedLight, pPackedOverlay);
        }
    }
}
