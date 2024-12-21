package com.aetherteam.aetherii.item.equipment.tools.skyroot;

import com.aetherteam.aetherii.item.equipment.AetherIIItemTiers;
import com.aetherteam.aetherii.item.equipment.tools.abilities.SkyrootTool;
import net.minecraft.world.item.HoeItem;

public class SkyrootTrowelItem extends HoeItem implements SkyrootTool {
    public SkyrootTrowelItem() {
        super(AetherIIItemTiers.SKYROOT, 0.0F, -3.0F, new Properties());
    }
}
