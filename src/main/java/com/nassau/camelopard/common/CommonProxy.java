package com.nassau.camelopard.common;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	public void registerEvents() {
		MinecraftForge.EVENT_BUS.register(new GenericEvents());
		FMLCommonHandler.instance().bus().register(new ServerTickEvents());
	}
	
}
