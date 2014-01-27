/**
 * Copyright (C) 2014 Kolmogorov Alexey
 * 
 * This file part of ulmc.ru ModPack
 * 
 * ulmc.ru ModPack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ulmc.ru ModPack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/].
 * 
 */
package ru.ulmc.extender.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;

import java.util.List;

public class ItemLockProbe extends ItemPicklock {

	private int securityLevel = 0;
	public Icon placeholder;
	private int useTime;

	public ItemLockProbe(int i, String unlocalizedName, int securityLevel, int maxDamage) {
		super(i);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.RES_NAME + unlocalizedName);
		setCreativeTab(CreativeTabs.tabTools);
		this.securityLevel = securityLevel;
		this.setMaxStackSize(999);
		this.setMaxDamage(maxDamage);
		this.useTime = (int)(128 - securityLevel*1.3);
	}

	public int getSecurityLevel() {
		return securityLevel;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return this.useTime;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.none;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		if (par2EntityPlayer.worldObj.isRemote && par2EntityPlayer.isUsingItem()) {
			if (useTime - 2 < par2EntityPlayer.getItemInUseCount()) {
				return false;
			}
		}
		return false;
	}

	@Override
	public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count) {
		super.onUsingItemTick(stack, player, count);
	}

	/**
	 * Этот метод не вызывается автоматически.
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}
	
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		//par2World.playSoundAtEntity(par3EntityPlayer, "random.bowhit", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		return par1ItemStack;
	}
	
	public static void setBonus(ItemStack stack, float bonus) {

		NBTTagCompound tag = stack.getTagCompound();

		if (tag != null) {
			tag.setFloat("bonus", bonus);
		}
	}

	public static float getBonus(ItemStack stack) {
		NBTTagCompound tag = stack.getTagCompound();

		if (tag != null) {
			return tag.getFloat("bonus");
		}
		return 0;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (itemStack.stackTagCompound == null) {
			createNBT(itemStack);
		}
		float bonus = itemStack.stackTagCompound.getFloat("bonus");		
		if (bonus == 0) {
			list.add(EnumChatFormatting.DARK_GREEN + UltimateExtender.loc("tc.itemStatus.common"));
		} else if (bonus < 0.5F) {
			list.add(EnumChatFormatting.DARK_GREEN + UltimateExtender.loc("tc.itemStatus.simple"));
		} else if(bonus > 0.5F && bonus < 1.0F) {
			list.add(EnumChatFormatting.DARK_GREEN + UltimateExtender.loc("tc.itemStatus.sharpen"));
		} else if(bonus < 2) {
			list.add(EnumChatFormatting.GREEN + UltimateExtender.loc("tc.itemStatus.good"));
		} else if(bonus < 3) {
			list.add(EnumChatFormatting.GREEN + UltimateExtender.loc("tc.itemStatus.epic"));
		} else {
			list.add(EnumChatFormatting.GREEN + UltimateExtender.loc("tc.itemStatus.masterpiece"));
		}

	}
	
	public static void createNBT(ItemStack itemStack) {
		itemStack.stackTagCompound = new NBTTagCompound();
		itemStack.stackTagCompound.setFloat("bonus", 0.0F);
	}

	@Override
	public boolean grindItem(EntityPlayer player, ItemStack grinder, ItemStack hold, ItemStack example) {
		ItemLockProbe.setBonus(hold, ((ItemGrind) grinder.getItem()).getRandomBuff());
		return true;
	}

}