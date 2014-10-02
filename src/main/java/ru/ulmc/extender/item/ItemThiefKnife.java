/**
 * Copyright (C) 2014 ulmc.ru (Alex K.)
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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.gui.GuiBones;
import ru.ulmc.extender.gui.GuiThief;

import java.util.HashMap;


/**
 * Created by 45 on 16.02.14.
 */
public class ItemThiefKnife extends ItemSword implements Grindable, UItem {

	public ItemThiefKnife(String unlocalizedName, int durability, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		setUnlocalizedName(unlocalizedName);
		setMaxDamage(durability);
		setTextureName(Reference.RES_NAME + unlocalizedName);
		setCreativeTab(CreativeTabs.tabCombat);
	}

	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	@Override
	public boolean grindItem(EntityPlayer player, ItemStack grinder, ItemStack hold, ItemStack example) {
		return false;
	}

	@Override
	public String getClearItemName() {
		return null;
	}



	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity) {
		if (entity instanceof EntityPlayer) {
			EntityPlayer target = (EntityPlayer) entity;
			if (!entity.worldObj.isRemote) {
				UltimateExtender.thiefProcessor.initStealing(player, target);
			}
			player.openGui(UltimateExtender.instance, GuiThief.GUI_ID, entity.worldObj, (int)player.posX,
					(int)player.posY, (int)player.posZ);
			return true;
		}
		return false;
	}
}
