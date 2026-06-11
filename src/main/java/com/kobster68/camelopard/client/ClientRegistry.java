package com.kobster68.camelopard.client;

import com.kobster68.camelopard.Camelopard;
import com.kobster68.camelopard.init.ItemsCamelopard;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Camelopard.MODID, value = Side.CLIENT)
public class ClientRegistry {

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		registerItemModel(ItemsCamelopard.MIXED_SEEDS);
		registerItemModel(ItemsCamelopard.IRON_SCISSORS);
	}
	
	private static void registerItemModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(
				item, 
				0, 
				new ModelResourceLocation(item.getRegistryName(), "inventory")
				);
	}
	
}
