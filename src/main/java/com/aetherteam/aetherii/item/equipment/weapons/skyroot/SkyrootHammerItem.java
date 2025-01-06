package com.aetherteam.aetherii.item.equipment.weapons.skyroot;

import com.aetherteam.aetherii.AetherIIDamageStats;
import com.aetherteam.aetherii.item.equipment.AetherIIItemTiers;
import com.aetherteam.aetherii.item.equipment.weapons.TieredHammerItem;
import com.aetherteam.aetherii.item.equipment.weapons.abilities.SkyrootWeapon;

public class SkyrootHammerItem extends TieredHammerItem implements SkyrootWeapon {
    public SkyrootHammerItem(Properties properties) {
        super(properties.attributes(AetherIIDamageStats.merge(TieredHammerItem.createAttributes(AetherIIItemTiers.SKYROOT, 3, -2.4F), AetherIIDamageStats.SKYROOT_HAMMER)));
    }
}
