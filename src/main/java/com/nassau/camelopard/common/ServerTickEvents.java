package com.nassau.camelopard.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class ServerTickEvents {

	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		System.out.println("Player Login Event");
		
		ExtendedPlayer ex = ExtendedPlayer.get(event.player);
		ex.sync(event.player);
	}
}
