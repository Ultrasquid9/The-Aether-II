package com.aetherteam.aetherii.network.packet.clientbound;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.block.fluid.AcidFluid;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record AcidDamageBlockPacket(BlockPos pos, int destroySpeed) implements CustomPacketPayload {
    public static final Type<AcidDamageBlockPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "acid_damage_block"));

    public static final StreamCodec<RegistryFriendlyByteBuf, AcidDamageBlockPacket> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC,
            AcidDamageBlockPacket::pos,
            ByteBufCodecs.INT,
            AcidDamageBlockPacket::destroySpeed,
            AcidDamageBlockPacket::new);

    @Override
    public Type<AcidDamageBlockPacket> type() {
        return TYPE;
    }

    public static void execute(AcidDamageBlockPacket payload, IPayloadContext context) {
        if (Minecraft.getInstance().player != null && Minecraft.getInstance().level != null) {
            FluidState fluidState = Minecraft.getInstance().level.getFluidState(payload.pos().above());
            if (fluidState.getType() instanceof AcidFluid acidFluid) {
                acidFluid.progressivelyDestroyBlock(Minecraft.getInstance().level, payload.pos(), payload.destroySpeed());
            }
        }
    }
}
