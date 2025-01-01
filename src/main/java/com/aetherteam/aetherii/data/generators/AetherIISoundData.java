package com.aetherteam.aetherii.data.generators;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.client.AetherIISoundEvents;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class AetherIISoundData extends SoundDefinitionsProvider {
    public AetherIISoundData(PackOutput output) {
        super(output, AetherII.MODID);
    }

    @Override
    public void registerSounds() {
        // Blocks
        this.add(AetherIISoundEvents.BLOCK_AETHER_PORTAL_AMBIENT,
                definition().with(sound("aether_ii:block/portal/hum").attenuationDistance(10))
                        .subtitle("subtitles.aether_ii.block.aether_portal.ambient")
        );
        this.add(AetherIISoundEvents.BLOCK_AETHER_PORTAL_TRAVEL,
                definition().with(sound("aether_ii:block/portal/travel"))
        );
        this.add(AetherIISoundEvents.BLOCK_AETHER_PORTAL_TRIGGER,
                definition().with(sound("aether_ii:block/portal/trigger"))
                        .subtitle("subtitles.aether_ii.block.aether_portal.trigger")
        );
        this.add(AetherIISoundEvents.BLOCK_BLUE_AERCLOUD_BOUNCE,
                definition().with(sound("aether_ii:block/aercloud/blue_aercloud_bounce"))
                        .subtitle("subtitles.aether_ii.block.aercloud.blue_aercloud_bounce")
        );

        // Items
        this.add(AetherIISoundEvents.ITEM_AMBROSIUM_SHARD,
                definition().with(sound("minecraft:block/amethyst/shimmer"))
                        .subtitle("subtitles.aether.item.ambrosium_shard.use")
        );
        this.add(AetherIISoundEvents.ITEM_SWET_BALL_USE,
                definition().with(
                        sound("minecraft:mob/slime/big1"),
                        sound("minecraft:mob/slime/big2"),
                        sound("minecraft:mob/slime/big3"),
                        sound("minecraft:mob/slime/big4")
                ).subtitle("subtitles.aether.item.swet_ball.use")
        );

        this.add(AetherIISoundEvents.ITEM_MUSIC_DISC_AETHER_TUNE,
                definition().with(sound("aether_ii:item/records/aether_tune").stream())
        );
        this.add(AetherIISoundEvents.ITEM_MUSIC_DISC_ASCENDING_DAWN,
                definition().with(sound("aether_ii:item/records/ascending_dawn").stream())
        );
        this.add(AetherIISoundEvents.ITEM_MUSIC_DISC_AERWHALE,
                definition().with(sound("aether_ii:item/records/aerwhale").stream())
        );
        this.add(AetherIISoundEvents.ITEM_MUSIC_DISC_APPROACHES,
                definition().with(sound("aether_ii:item/records/approaches").stream())
        );
        this.add(AetherIISoundEvents.ITEM_MUSIC_DISC_DEMISE,
                definition().with(sound("aether_ii:item/records/demise").stream())
        );
        this.add(AetherIISoundEvents.ITEM_RECORDING_892,
                definition().with(sound("aether_ii:item/records/chase").stream())
        );

        // Entities
        this.add(AetherIISoundEvents.ENTITY_PHYG_AMBIENT,
                definition().with(
                        sound("minecraft:mob/pig/say1"),
                        sound("minecraft:mob/pig/say2"),
                        sound("minecraft:mob/pig/say3")
                ).subtitle("subtitles.aether.entity.phyg.ambient")
        );
        this.add(AetherIISoundEvents.ENTITY_PHYG_DEATH,
                definition().with(sound("minecraft:mob/pig/death"))
                        .subtitle("subtitles.aether.entity.phyg.death")
        );
        this.add(AetherIISoundEvents.ENTITY_PHYG_HURT,
                definition().with(
                        sound("minecraft:mob/pig/say1"),
                        sound("minecraft:mob/pig/say2"),
                        sound("minecraft:mob/pig/say3")
                ).subtitle("subtitles.aether.entity.phyg.hurt")
        );
        this.add(AetherIISoundEvents.ENTITY_PHYG_SADDLE,
                definition().with(sound("minecraft:mob/horse/leather"))
                        .subtitle("subtitles.aether.entity.phyg.saddle")
        );
        this.add(AetherIISoundEvents.ENTITY_PHYG_STEP,
                definition().with(
                        sound("minecraft:mob/pig/step1"),
                        sound("minecraft:mob/pig/step2"),
                        sound("minecraft:mob/pig/step3"),
                        sound("minecraft:mob/pig/step4"),
                        sound("minecraft:mob/pig/step5")
                ).subtitle("subtitles.block.generic.footsteps")
        );

        this.add(AetherIISoundEvents.ENTITY_FLYING_COW_AMBIENT,
                definition().with(
                        sound("minecraft:mob/cow/say1"),
                        sound("minecraft:mob/cow/say2"),
                        sound("minecraft:mob/cow/say3"),
                        sound("minecraft:mob/cow/say4")
                ).subtitle("subtitles.aether.entity.flying_cow.ambient")
        );
        this.add(AetherIISoundEvents.ENTITY_FLYING_COW_DEATH,
                definition().with(
                        sound("minecraft:mob/cow/hurt1"),
                        sound("minecraft:mob/cow/hurt2"),
                        sound("minecraft:mob/cow/hurt3")
                ).subtitle("subtitles.aether.entity.flying_cow.death")
        );
        this.add(AetherIISoundEvents.ENTITY_FLYING_COW_HURT,
                definition().with(
                        sound("minecraft:mob/cow/hurt1"),
                        sound("minecraft:mob/cow/hurt2"),
                        sound("minecraft:mob/cow/hurt3")
                ).subtitle("subtitles.aether.entity.flying_cow.hurt")
        );
        this.add(AetherIISoundEvents.ENTITY_FLYING_COW_SADDLE,
                definition().with(sound("minecraft:mob/horse/leather"))
                        .subtitle("subtitles.aether.entity.flying_cow.saddle")
        );
        this.add(AetherIISoundEvents.ENTITY_FLYING_COW_MILK,
                definition().with(
                        sound("minecraft:entity/cow/milk1"),
                        sound("minecraft:entity/cow/milk2"),
                        sound("minecraft:entity/cow/milk3")
                ).subtitle("subtitles.aether.entity.flying_cow.milk")
        );
        this.add(AetherIISoundEvents.ENTITY_FLYING_COW_STEP,
                definition().with(
                        sound("minecraft:mob/cow/step1"),
                        sound("minecraft:mob/cow/step2"),
                        sound("minecraft:mob/cow/step3"),
                        sound("minecraft:mob/cow/step4")
                ).subtitle("subtitles.block.generic.footsteps")
        );

        this.add(AetherIISoundEvents.ENTITY_SHEEPUFF_AMBIENT,
                definition().with(
                        sound("minecraft:mob/sheep/say1"),
                        sound("minecraft:mob/sheep/say2"),
                        sound("minecraft:mob/sheep/say3")
                ).subtitle("subtitles.aether.entity.sheepuff.ambient")
        );
        this.add(AetherIISoundEvents.ENTITY_SHEEPUFF_DEATH,
                definition().with(
                        sound("minecraft:mob/sheep/say1"),
                        sound("minecraft:mob/sheep/say2"),
                        sound("minecraft:mob/sheep/say3")
                ).subtitle("subtitles.aether.entity.sheepuff.death")
        );
        this.add(AetherIISoundEvents.ENTITY_SHEEPUFF_HURT,
                definition().with(
                        sound("minecraft:mob/sheep/say1"),
                        sound("minecraft:mob/sheep/say2"),
                        sound("minecraft:mob/sheep/say3")
                ).subtitle("subtitles.aether.entity.sheepuff.hurt")
        );
        this.add(AetherIISoundEvents.ENTITY_SHEEPUFF_SHEAR,
                definition().with(sound("minecraft:mob/sheep/shear"))
                        .subtitle("subtitles.item.shears.shear")
        );
        this.add(AetherIISoundEvents.ENTITY_SHEEPUFF_STEP,
                definition().with(
                        sound("minecraft:mob/sheep/step1"),
                        sound("minecraft:mob/sheep/step2"),
                        sound("minecraft:mob/sheep/step3"),
                        sound("minecraft:mob/sheep/step4"),
                        sound("minecraft:mob/sheep/step5")
                ).subtitle("subtitles.block.generic.footsteps")
        );

        this.add(AetherIISoundEvents.ENTITY_AERBUNNY_DEATH,
                definition().with(sound("aether_ii:entity/aerbunny/death"))
                        .subtitle("subtitles.aether_ii.entity.aerbunny.death")
        );
        this.add(AetherIISoundEvents.ENTITY_AERBUNNY_HURT,
                definition().with(sound("aether_ii:entity/aerbunny/hurt"))
                        .subtitle("subtitles.aether_ii.entity.aerbunny.hurt")
        );
        this.add(AetherIISoundEvents.ENTITY_AERBUNNY_LIFT,
                definition().with(sound("aether_ii:entity/aerbunny/lift"))
                        .subtitle("subtitles.aether_ii.entity.aerbunny.lift")
        );

        this.add(AetherIISoundEvents.ENTITY_MOA_AMBIENT,
                definition().with(sound("aether_ii:entity/moa/say"))
                        .subtitle("subtitles.aether.entity.moa.ambient")
        );
        this.add(AetherIISoundEvents.ENTITY_MOA_DEATH,
                definition().with(sound("aether_ii:entity/moa/say"))
                        .subtitle("subtitles.aether.entity.moa.death")
        );
        this.add(AetherIISoundEvents.ENTITY_MOA_HURT,
                definition().with(sound("aether_ii:entity/moa/say"))
                        .subtitle("subtitles.aether.entity.moa.hurt")
        );
        this.add(AetherIISoundEvents.ENTITY_MOA_SADDLE,
                definition().with(sound("minecraft:mob/horse/leather"))
                        .subtitle("subtitles.aether.entity.moa.saddle")
        );
        this.add(AetherIISoundEvents.ENTITY_MOA_STEP,
                definition().with(
                        sound("minecraft:mob/pig/step1"),
                        sound("minecraft:mob/pig/step2"),
                        sound("minecraft:mob/pig/step3"),
                        sound("minecraft:mob/pig/step4"),
                        sound("minecraft:mob/pig/step5")
                ).subtitle("subtitles.block.generic.footsteps")
        );
        this.add(AetherIISoundEvents.ENTITY_MOA_FLAP,
                definition().with(sound("minecraft:mob/bat/takeoff"))
                        .subtitle("subtitles.aether.entity.moa.flap")
        );
        this.add(AetherIISoundEvents.ENTITY_MOA_EGG,
                definition().with(sound("minecraft:mob/chicken/plop"))
                        .subtitle("subtitles.aether.entity.moa.egg")
        );

        this.add(AetherIISoundEvents.ENTITY_ZEPHYR_SHOOT,
                definition().with(sound("aether_ii:entity/zephyr/shoot"))
                        .subtitle("subtitles.aether_ii.entity.zephyr.shoot")
        );

        this.add(AetherIISoundEvents.COCKATRICE_SHOOT,
                definition().with(sound("aether_ii:entity/projectile/shoot"))
                        .subtitle("subtitles.aether.entity.cockatrice.shoot")
        );

        this.add(AetherIISoundEvents.ENTITY_SWET_ATTACK,
                definition().with(
                        sound("minecraft:mob/slime/attack1"),
                        sound("minecraft:mob/slime/attack2")
                ).subtitle("subtitles.aether.entity.swet.attack")
        );
        this.add(AetherIISoundEvents.ENTITY_SWET_DEATH,
                definition().with(
                        sound("minecraft:mob/slime/big1"),
                        sound("minecraft:mob/slime/big2"),
                        sound("minecraft:mob/slime/big3"),
                        sound("minecraft:mob/slime/big4")
                ).subtitle("subtitles.aether.entity.swet.death")
        );
        this.add(AetherIISoundEvents.ENTITY_SWET_HURT,
                definition().with(
                        sound("minecraft:mob/slime/big1"),
                        sound("minecraft:mob/slime/big2"),
                        sound("minecraft:mob/slime/big3"),
                        sound("minecraft:mob/slime/big4")
                ).subtitle("subtitles.aether.entity.swet.hurt")
        );
        this.add(AetherIISoundEvents.ENTITY_SWET_JUMP,
                definition().with(
                        sound("minecraft:mob/slime/big1"),
                        sound("minecraft:mob/slime/big2"),
                        sound("minecraft:mob/slime/big3"),
                        sound("minecraft:mob/slime/big4")
                ).subtitle("subtitles.aether.entity.swet.squish")
        );
        this.add(AetherIISoundEvents.ENTITY_SWET_SQUISH,
                definition().with(
                        sound("minecraft:mob/slime/big1"),
                        sound("minecraft:mob/slime/big2"),
                        sound("minecraft:mob/slime/big3"),
                        sound("minecraft:mob/slime/big4")
                ).subtitle("subtitles.aether.entity.swet.squish")
        );

        /*this.add(AetherIISoundEvents.ENTITY_ZEPHYR_AMBIENT,
                definition().with(sound("aether:entity/zephyr/call"))
                        .subtitle("subtitles.aether.entity.zephyr.ambient")
        );
        this.add(AetherIISoundEvents.ENTITY_ZEPHYR_DEATH,
                definition().with(sound("aether:entity/zephyr/call"))
                        .subtitle("subtitles.aether.entity.zephyr.death")
        );
        this.add(AetherIISoundEvents.ENTITY_ZEPHYR_HURT,
                definition().with(sound("aether:entity/zephyr/call"))
                        .subtitle("subtitles.aether.entity.zephyr.hurt")
        );*/

        // Music
        this.add(AetherIISoundEvents.MUSIC_AETHER,
                definition().with(
                        sound("aether_ii:music/aether1").stream(),
                        sound("aether_ii:music/aether2").stream(),
                        sound("aether_ii:music/aether3").stream(),
                        sound("aether_ii:music/aether4").stream(),
                        sound("aether_ii:music/aether5").stream(),
                        sound("aether_ii:music/aether6").stream()
                )
        );
        this.add(AetherIISoundEvents.MUSIC_AETHER_NIGHT,
                definition().with(
                        sound("aether_ii:music/aether_night1").stream(),
                        sound("aether_ii:music/aether_night2").stream()
                )
        );
        this.add(AetherIISoundEvents.MUSIC_AETHER_SUNRISE,
                definition().with(
                        sound("aether_ii:music/aether_sunrise").stream()
                )
        );
        this.add(AetherIISoundEvents.MUSIC_AETHER_SUNSET,
                definition().with(
                        sound("aether_ii:music/aether_sunset").stream()
                )
        );
        this.add(AetherIISoundEvents.MUSIC_AETHER_AMBIENCE,
                definition().with(
                        sound("aether_ii:music/aether_ambience1").stream()
                )
        );
    }
}