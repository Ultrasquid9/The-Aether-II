package com.aetherteam.aetherii.network.packet.serverbound;

import com.aetherteam.aetherii.AetherII;
import com.aetherteam.aetherii.block.fluid.AcidFluid;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record AcidBreakBlockPacket(BlockPos pos) implements CustomPacketPayload {
    public static final Type<AcidBreakBlockPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(AetherII.MODID, "acid_break_block"));

    public static final StreamCodec<RegistryFriendlyByteBuf, AcidBreakBlockPacket> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC,
            AcidBreakBlockPacket::pos,
            AcidBreakBlockPacket::new);

    @Override
    public Type<AcidBreakBlockPacket> type() {
        return TYPE;
    }

    public static void execute(AcidBreakBlockPacket payload, IPayloadContext context) {
        Player playerEntity = context.player();
        if (playerEntity.getServer() != null) {
            FluidState fluidState = playerEntity.level().getFluidState(payload.pos().above());
            if (fluidState.getType() instanceof AcidFluid acidFluid) {
                acidFluid.fullyDestroyBlock(playerEntity.level(), payload.pos());
            }
        }
    }
}
