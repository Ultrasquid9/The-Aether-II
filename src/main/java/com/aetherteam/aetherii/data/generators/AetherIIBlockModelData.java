package com.aetherteam.aetherii.data.generators;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.block.AetherIIBlocks;
import com.aetherteam.aetherii.data.providers.AetherIIBlockModelProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.data.PackOutput;

public class AetherIIBlockModelData extends AetherIIBlockModelProvider {
    public AetherIIBlockModelData(PackOutput packOutput) {
        super(packOutput, AetherII.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        // Underground
        blockModels.createTrivialCube(AetherIIBlocks.HOLYSTONE.get());
    }
}
