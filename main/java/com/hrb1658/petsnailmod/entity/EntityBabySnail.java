package com.hrb1658.petsnailmod.entity;

import com.hrb1658.petsnailmod.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityBabySnail extends EntityAnimal {

	public EntityBabySnail(World world) {
		super(world);
		
		setSize(0.31F, 0.31F);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return new EntityBabySnail(worldObj);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
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
	public boolean interact(EntityPlayer player) {
		ItemStack held = player.inventory.getCurrentItem();
		if (held.getItem() == ModItems.itemSnailNet && held.getItemDamage() == 0) {
			if (!worldObj.isRemote) {
				player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				EntityItem ei = new EntityItem(worldObj, posX, posY + 0.5D, posZ, new ItemStack(ModItems.itemSnailNet, 1, 1));
				double vx = (rand.nextDouble() - 0.5D) * 0.5D;
				double vz = (rand.nextDouble() - 0.5D) * 0.5D;
				ei.setVelocity(vx, 0, vz);
				worldObj.spawnEntityInWorld(ei);
				setDead();
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected boolean isAIEnabled() {
		return true;
	}
}
