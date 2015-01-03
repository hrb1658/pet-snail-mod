package com.hrb1658.petsnailmod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.hrb1658.petsnailmod.Reference;
import com.hrb1658.petsnailmod.entity.EntityBabySnail;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSnailNet extends Item {
	
	public ItemSnailNet() {
		setHasSubtypes(true);
		setUnlocalizedName("itemSnailNet");
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
	}
	
	private IIcon[] icons;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		icons = new IIcon[2];
		icons[0] = reg.registerIcon(Reference.MOD_ID + ":snail_net_empty");
		icons[1] = reg.registerIcon(Reference.MOD_ID + ":snail_net_full");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float lx, float ly, float lz) {
		if (world.isRemote) {
			return false;
		}
		if (stack.getItemDamage() == 1 && side == 1) {
			stack.setItemDamage(0);
			EntityBabySnail snail = new EntityBabySnail(world);
			snail.setPosition(x + lx, y + 1.0D, z + lz);
			world.spawnEntityInWorld(snail);
			return true;
		}
		return false;
	}
	
	@Override
	public IIcon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getItemDamage()) {
		case 0:
			return getUnlocalizedName() + "Empty";
		case 1:
			return getUnlocalizedName() + "Full";
		default:
			return getUnlocalizedName();
		}
	}
}
