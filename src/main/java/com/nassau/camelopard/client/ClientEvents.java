package com.nassau.camelopard.client;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;

public class ClientEvents {

	@SubscribeEvent
	public void onPlayerPreRender(RenderLivingEvent.Pre event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;

			GL11.glScalef(0.5f, 0.5f, 0.5f);

			// event.setCanceled(true);
		}
	}
}
