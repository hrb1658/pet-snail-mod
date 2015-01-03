package com.hrb1658.petsnailmod.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySnail extends EntityAnimal {
	
	public EntitySnail(World world) {
		super(world);
		setSize(0.8F, 0.8F);
		
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(3, new EntityAISwimming(this));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return new EntitySnail(worldObj);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		setAir(100);
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		
	}
	
	@Override
	protected void func_145780_a(int x, int y, int z, Block block) {
		worldObj.playSoundEffect(x + 0.5, y + 0.5, z + 0.5, "petsnailmod:slime", 0.05F, 1.5F);
	}
	
	@Override
	protected boolean isAIEnabled() {
		return true;
	}
}
