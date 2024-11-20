package com.aetherteam.aetherii.block;

import com.aetherteam.aetherii.AetherII;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class AetherIIFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, AetherII.MODID);

    public static final DeferredHolder<FluidType, FluidType> ACID_TYPE = FLUID_TYPES.register("acid", () -> new FluidType(FluidType.Properties.create()
            .descriptionId("block.aether_ii.acid")
            .canExtinguish(true)
            .supportsBoating(false)
            .lightLevel(10)
//            .sound(SoundActions.BUCKET_EMPTY, UGSoundEvents.BUCKET_EMPTY_VIRULENT.get())
//            .sound(SoundActions.BUCKET_FILL, UGSoundEvents.BUCKET_FILL_VIRULENT.get())
//            .addDripstoneDripping(PointedDripstoneBlock.LAVA_TRANSFER_PROBABILITY_PER_RANDOM_TICK, UGParticleTypes.DRIPPING_VIRULENT.get(), UGBlocks.VIRULENT_MIX_CAULDRON.get(), SoundEvents.POINTED_DRIPSTONE_DRIP_LAVA_INTO_CAULDRON)
            )
    );
}
