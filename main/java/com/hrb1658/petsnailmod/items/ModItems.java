package com.hrb1658.petsnailmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
	
	public static Item itemSnailNet;
	
	public static void register() {
		GameRegistry.registerItem(itemSnailNet = new ItemSnailNet(), "itemSnailNet");
	}
	
}
