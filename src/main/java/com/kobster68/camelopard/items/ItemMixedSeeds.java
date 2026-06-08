package com.kobster68.camelopard.items;

import com.kobster68.camelopard.Camelopard;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMixedSeeds extends Item {

	public ItemMixedSeeds() {
		setRegistryName(Camelopard.MODID, "mixed_seeds");
		setUnlocalizedName(Camelopard.MODID + ".mixed_seeds");
		setCreativeTab(CreativeTabs.MATERIALS);
	}
	
}
