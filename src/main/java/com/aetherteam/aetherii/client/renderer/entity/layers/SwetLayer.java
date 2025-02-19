package com.aetherteam.aetherii.client.renderer.entity.layers;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.entity.monster.Swet;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.context.ContextKey;

import java.util.List;

public class SwetLayer<T extends LivingEntityRenderState, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private final EntityRenderDispatcher dispatcher;

    public static ContextKey<List<Swet>> SWET_KEY = new ContextKey<>(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "swet"));
    public static ContextKey<Integer> SWET_ID_KEY = new ContextKey<>(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "swet_id"));


    public SwetLayer(EntityRendererProvider.Context context, RenderLayerParent<T, M> renderer) {
        super(renderer);
        this.dispatcher = context.getEntityRenderDispatcher();
    }

    public void render(
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight,
            T livingEntity,
            float netHeadYaw,
            float headPitch
    ) {
        if (this.getParentModel() instanceof PlayerModel playerModel) {
            RandomSource randomsource = RandomSource.create((long) livingEntity.getRenderDataOrDefault(SWET_ID_KEY, 0));
            List<Swet> swets =
                    livingEntity.getRenderDataOrDefault(SWET_KEY, List.of());
            for (Swet swet : swets) {
                poseStack.pushPose();
                ModelPart modelpart = playerModel.getRandomBodyPart(randomsource);
                ModelPart.Cube modelpart$cube = modelpart.getRandomCube(randomsource);
                modelpart.translateAndRotate(poseStack);
                float x = randomsource.nextFloat();
                float y = randomsource.nextFloat();
                float z = randomsource.nextFloat();
                float f3 = Mth.lerp(x, modelpart$cube.minX, modelpart$cube.maxX) / 16.0F;
                float f4 = Mth.lerp(y, modelpart$cube.minY, modelpart$cube.maxY) / 16.0F;
                float f5 = Mth.lerp(z, modelpart$cube.minZ, modelpart$cube.maxZ) / 16.0F;
                poseStack.translate(f3, f4, f5);
                x = -1.0F * (x * 2.0F - 1.0F);
                y = -1.0F * (y * 2.0F - 1.0F);
                z = -1.0F * (z * 2.0F - 1.0F);
                float f6 = Mth.sqrt(x * x + z * z);
                swet.setYRot((float) (Math.atan2((double) x, (double) z) * 180.0F / (float) Math.PI));
                swet.setXRot((float) (Math.atan2((double) y, (double) f6) * 180.0F / (float) Math.PI));
                swet.yRotO = swet.getYRot();
                swet.xRotO = swet.getXRot();
                poseStack.scale(-0.5F, -0.5F, 0.5F);
                this.dispatcher.render(swet, 0.0, 0.0, 0.0, livingEntity.partialTick, poseStack, buffer, packedLight);

                poseStack.popPose();
            }
        }
    }
}
