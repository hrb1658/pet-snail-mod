package com.hrb1658.petsnailmod.proxy;

import com.hrb1658.petsnailmod.entity.EntitySnail;
import com.hrb1658.petsnailmod.render.entity.ModelSnail;
import com.hrb1658.petsnailmod.render.entity.RenderSnail;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public void registerRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySnail.class, new RenderSnail(new ModelSnail(), 0.5F));
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		registerRenders();
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	
}
