package com.nassau.camelopard.network;

import com.nassau.camelopard.common.ExtendedPlayer;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class PacketExtendedPlayerSync implements IMessage {

	private int kamuiLevel;
	
	public PacketExtendedPlayerSync() {}

	public PacketExtendedPlayerSync(ExtendedPlayer ex) {
		this.kamuiLevel = ex.getKamuiLevel();
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.kamuiLevel = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.kamuiLevel);
	}

	public static class Handler implements IMessageHandler<PacketExtendedPlayerSync, IMessage> {

		@Override
		public IMessage onMessage(PacketExtendedPlayerSync message, MessageContext ctx) {
			EntityPlayer player = null;
			if (ctx.side == Side.SERVER)
				player = (EntityPlayer) ctx.getServerHandler().playerEntity;
			if (ctx.side == Side.CLIENT)
				player = (EntityPlayer) Minecraft.getMinecraft().thePlayer;
			if (player == null)
				return null;
			ExtendedPlayer ex = ExtendedPlayer.get(player);
			ex.setKamuiLevel(message.kamuiLevel);
			return null;
		}

	}

}
