package com.aetherteam.aetherii.item.equipment.tools.gravitite;

import com.aetherteam.aetherii.item.equipment.AetherIIItemTiers;
import com.aetherteam.aetherii.item.equipment.tools.abilities.GravititeTool;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.context.UseOnContext;

public class GravititeShovelItem extends ShovelItem implements GravititeTool {
    public GravititeShovelItem(Properties properties) {
        super(AetherIIItemTiers.GRAVITITE, 1.5F, -3.0F, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (this.levitateBlock(context)) {
            return InteractionResult.SUCCESS;
        } else {
            return super.useOn(context);
        }
    }
}
