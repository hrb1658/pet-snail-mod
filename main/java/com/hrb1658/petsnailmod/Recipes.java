package com.hrb1658.petsnailmod;

import com.hrb1658.petsnailmod.items.ModItems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void register() {
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemSnailNet, 1, 0), "# #", "# #", "###", '#', Items.string);
	}
}
