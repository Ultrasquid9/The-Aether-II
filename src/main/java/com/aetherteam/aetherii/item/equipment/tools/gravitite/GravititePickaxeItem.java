package com.aetherteam.aetherii.item.equipment.tools.gravitite;

import com.aetherteam.aetherii.item.equipment.AetherIIItemTiers;
import com.aetherteam.aetherii.item.equipment.tools.abilities.GravititeTool;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.context.UseOnContext;

public class GravititePickaxeItem extends PickaxeItem implements GravititeTool {
    public GravititePickaxeItem() {
        super(AetherIIItemTiers.GRAVITITE, 1.0F, -2.8F, new Properties());
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
