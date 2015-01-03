package com.hrb1658.petsnailmod.render.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.hrb1658.petsnailmod.Reference;
import com.hrb1658.petsnailmod.entity.EntityBabySnail;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBabySnail extends RenderLiving {

	private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/entities/baby_snail.png");

	public RenderBabySnail(ModelBase model, float shadowSize) {
		super(model, shadowSize);
	}

	protected ResourceLocation getEntityTexture(EntityBabySnail entity) {
		return texture;
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return getEntityTexture((EntityBabySnail) entity);
	}
}