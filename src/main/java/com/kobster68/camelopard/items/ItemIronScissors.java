package com.kobster68.camelopard.items;

import com.kobster68.camelopard.Camelopard;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIronScissors extends Item {

	public ItemIronScissors() {
		setRegistryName(Camelopard.MODID, "iron_scissors");
		setUnlocalizedName(Camelopard.MODID + ".iron_scissors");
		setCreativeTab(CreativeTabs.TOOLS);
	}
	
}
