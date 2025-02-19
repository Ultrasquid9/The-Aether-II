package com.aetherteam.aetherii.client.renderer.entity;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.entity.projectile.VenomousDart;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.ResourceLocation;

public class VenomousDartRenderer extends ArrowRenderer<VenomousDart, ArrowRenderState> {
    private static final ResourceLocation VENOMOUS_DART_TEXTURE = ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "textures/entity/projectile/toxic_dart.png");  //todo

    public VenomousDartRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    public ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(ArrowRenderState renderState) {
        return VENOMOUS_DART_TEXTURE;
    }
}
