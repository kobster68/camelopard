package com.nassau.camelopard.client;

import com.nassau.camelopard.common.ExtendedPlayer;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;

@SideOnly(Side.CLIENT)
public class ClientEvents {

	@SubscribeEvent
	public void onPlayerPreRender(RenderLivingEvent.Pre event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			ExtendedPlayer ex = ExtendedPlayer.get(player);
			
			System.out.println(ex.getKamuiLevel());
			
			if(ex.getKamuiLevel() > 0) {
				Tessellator tessellator = Tessellator.instance;
				
				tessellator.startDrawingQuads();
				
		        double halfSize = 1;
		        tessellator.addVertex(-halfSize, -halfSize, -halfSize);
		        tessellator.addVertex( halfSize, -halfSize, -halfSize);
		        tessellator.addVertex( halfSize,  halfSize, -halfSize);
		        tessellator.addVertex(-halfSize,  halfSize, -halfSize);
		        
		        tessellator.draw();
			}
		}
	}
}
