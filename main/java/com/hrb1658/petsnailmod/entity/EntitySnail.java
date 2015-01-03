package com.hrb1658.petsnailmod.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntitySnail extends EntityAnimal {

	public EntitySnail(World world) {
		super(world);
		setSize(0.8F, 0.8F);
		
		this.tasks.addTask(0, new EntityAIWander(this, 0.2D));
		this.tasks.addTask(1, new EntityAIPanic(this, 0.4D));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return new EntitySnail(worldObj);
	}
	
	@Override
	protected boolean isAIEnabled() {
		return true;
	}
}
