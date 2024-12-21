package com.nassau.camelopard.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;

public class CamelopardEntityRenderer extends EntityRenderer {

	private final Minecraft mc;
	
	public CamelopardEntityRenderer(Minecraft mc) {
		super(mc, mc.getResourceManager());
		this.mc = mc;
	}
	
	@Override
	public void updateCameraAndRender(float partialTicks) {
		mc.thePlayer.posY -= 0.9f;
		mc.thePlayer.lastTickPosY -= 0.9f;
		mc.thePlayer.prevPosY -= 0.9f;
		//mc.thePlayer.eyeHeight = 0.9f;
		super.updateCameraAndRender(partialTicks);
		mc.thePlayer.posY += 0.9f;
		mc.thePlayer.lastTickPosY += 0.9f;
		mc.thePlayer.prevPosY += 0.9f;
		//mc.thePlayer.eyeHeight = 1.8f;
	}
	
	@Override
	public void getMouseOver(float partialTicks) {
		
		mc.thePlayer.posY -= 0.9f;
		mc.thePlayer.lastTickPosY -= 0.9f;
		mc.thePlayer.prevPosY -= 0.9f;
		
		super.getMouseOver(partialTicks);
		
		mc.thePlayer.posY += 0.9f;
		mc.thePlayer.lastTickPosY += 0.9f;
		mc.thePlayer.prevPosY += 0.9f;
	}


}
