package com.nassau.camelopard.common;

import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	public void registerEvents() {
		MinecraftForge.EVENT_BUS.register(new GenericEvents());
	}
	
}
