package com.hrb1658.petsnailmod.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.hrb1658.petsnailmod.Reference;
import com.hrb1658.petsnailmod.entity.EntitySnail;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSnail extends RenderLiving {
	
	private ResourceLocation[] textures = new ResourceLocation[] {
		new ResourceLocation(Reference.MOD_ID, "textures/entities/snail_0.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/entities/snail_1.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/entities/snail_2.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/entities/snail_3.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/entities/snail_4.png")
	};

	public RenderSnail(ModelBase model, float shadowSize) {
		super(model, shadowSize);
	}
	
	protected ResourceLocation getEntityTexture(EntitySnail entity) {
		return textures[entity.getSnailType()];
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return getEntityTexture((EntitySnail)entity);
	}
}