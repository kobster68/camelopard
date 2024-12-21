package com.nassau.camelopard.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;

public class ClientTickEvents {

	CamelopardEntityRenderer renderer;

	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event) {
		Minecraft mc = Minecraft.getMinecraft();

		if (mc.thePlayer != null) {

			if (renderer == null) {
				renderer = new CamelopardEntityRenderer(mc);
			}

			if (mc.entityRenderer != renderer) {
				mc.entityRenderer = renderer;
			}
		}
	}
}
