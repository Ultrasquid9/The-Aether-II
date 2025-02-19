package com.aetherteam.aetherii.client.renderer.block.model.baked;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.DelegateBakedModel;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.common.util.TriState;

public class AmbientOcclusionLightModel extends DelegateBakedModel {
    public AmbientOcclusionLightModel(BakedModel originalModel) {
        super(originalModel);
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true;
    }

    @Override
    public TriState useAmbientOcclusion(BlockState state, ModelData data, RenderType renderType) {
        return TriState.TRUE;
    }
}
