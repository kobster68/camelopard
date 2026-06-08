package com.kobster68.camelopard.init;

import com.kobster68.camelopard.Camelopard;
import com.kobster68.camelopard.items.ItemMixedSeeds;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;

@Mod.EventBusSubscriber(modid = Camelopard.MODID)
public class ItemsCamelopard {
	
	public static final Item MIXED_SEEDS = new ItemMixedSeeds();
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(MIXED_SEEDS);
	}
}
