package com.hrb1658.petsnailmod.proxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

import com.hrb1658.petsnailmod.PetSnailMod;
import com.hrb1658.petsnailmod.entity.EntitySnail;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

public class CommonProxy {
	
	private static int entityID = -1;

	public void registerEntityThings() {
		registerEntityWithEgg(EntitySnail.class, "entitySnail", 80, 3,0xD6877A, 0x6F60C7);
	}

	public void preInit(FMLPreInitializationEvent event) {
		
	}

	public void init(FMLInitializationEvent event) {
		registerEntityThings();
	}

	public void postInit(FMLPostInitializationEvent event) {

	}
	
	private int getUniqueEggID() {
		int id = 300;
		do {
			id++;
		} while (EntityList.getStringFromID(id) != null);
		return id;
	}

	private void registerEntityWithEgg(Class<? extends Entity> cls, String name, int distance, int updateFreq, int eggBackColor, int eggForeColor) {
		entityID++;
		EntityRegistry.registerModEntity(cls, name, entityID, PetSnailMod.instance, distance, updateFreq, true);
		int eggID = getUniqueEggID();
		EntityList.IDtoClassMapping.put(eggID, cls);
		EntityList.entityEggs.put(eggID, new EntityList.EntityEggInfo(eggID, eggBackColor, eggForeColor));
	}
}
