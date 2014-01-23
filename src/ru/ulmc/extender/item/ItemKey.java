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

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;

public class ItemKey extends Item implements Grindable {

	private int securityLevel = 0;
	public Icon placeholder;

	public ItemKey(int i, String unlocalizedName, int securityLevel, int maxDamage) {
		super(i);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.RES_NAME + unlocalizedName);
		setCreativeTab(CreativeTabs.tabTools);
		this.securityLevel = securityLevel;
		maxStackSize = 1;
		this.setMaxDamage(maxDamage);
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		super.registerIcons(par1IconRegister);
		this.placeholder = par1IconRegister.registerIcon(Reference.RES_NAME + "placeholderKey");
	}

	public static void setRandomCipher(ItemStack stack) {
		NBTTagCompound tag = stack.getTagCompound();
		if (tag != null) {
			int randomCipher = (int) (Math.random() * 10000);
			tag.setInteger("cipher", randomCipher);
		}
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

	public static void cloneCipher(ItemStack source, ItemStack target) {
		NBTTagCompound tag = target.getTagCompound();
		if (tag == null) {
			target.setTagCompound(new NBTTagCompound());
			tag = target.getTagCompound();
		}
		tag.setInteger("cipher", source.stackTagCompound.getInteger("cipher"));		
	}

	/*
	 * @SideOnly(Side.CLIENT)
	 * 
	 * @Override public int getColorFromItemStack(ItemStack stack, int par2) {
	 * NBTTagCompound tag = stack.getTagCompound(); if(tag == null) { return
	 * 1454545; } return tag.getInteger("cipher"); }
	 */
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		itemStack.stackTagCompound = new NBTTagCompound();
		itemStack.stackTagCompound.setInteger("cipher", -1);
		itemStack.stackTagCompound.setFloat("bonus", 0.0F);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (itemStack.stackTagCompound == null) {
			createNBT(itemStack);
		}
		int cipher = itemStack.stackTagCompound.getInteger("cipher");
		float bonus = itemStack.stackTagCompound.getFloat("bonus");
		if (cipher > 0) {
			list.add(EnumChatFormatting.DARK_GREEN + "Encrypted");
		} else {
			list.add(EnumChatFormatting.RED + "Blank");
		}	
		if (bonus == 0) {
			list.add(EnumChatFormatting.DARK_GREEN + "Common");
		} else if(bonus < 1) {
			list.add(EnumChatFormatting.DARK_GREEN + "Simple");
		} else if(bonus < 2) {
			list.add(EnumChatFormatting.GREEN + "Good");
		} else if(bonus > 2) {
			list.add(EnumChatFormatting.GREEN + "Epic");
		}

	}

	public static void createNBT(ItemStack itemStack) {
		itemStack.stackTagCompound = new NBTTagCompound();
		itemStack.stackTagCompound.setInteger("cipher", -1);
		itemStack.stackTagCompound.setFloat("bonus", 0.0F);
	}

	/*
	 * protected static void setLore(ItemStack itemStack, String string) { if
	 * (itemStack.stackTagCompound != null) { String owner =
	 * itemStack.stackTagCompound.getString("owner"); int code =
	 * itemStack.stackTagCompound.getInteger("code"); list.add("owner: " +
	 * owner); if (owner.equals(player.username)) {
	 * list.add(EnumChatFormatting.GREEN + "code: " + code); } else {
	 * list.add(EnumChatFormatting.RED + "code: " +
	 * EnumChatFormatting.OBFUSCATED + code); } } }
	 */
	public static int getCipher(ItemStack hold) {
		if (hold.stackTagCompound == null) {
			return -1;
		}
		return hold.stackTagCompound.getInteger("cipher");
	}

	/*
	 * @SideOnly(Side.CLIENT)
	 * 
	 * @Override public boolean requiresMultipleRenderPasses() { return true; }
	 */
	public int getSecurityLevel() {
		return securityLevel;
	}

	@Override
	public boolean grindItem(EntityPlayer player, ItemStack grinder, ItemStack hold, ItemStack example) {
		ItemGrind grindStone = (ItemGrind) grinder.getItem();
		boolean damageGinder = false;
		if (example != null && example.getItem() instanceof ItemKey) {
			ItemKey.cloneCipher(example, hold);
			if(grindStone.isGoodEnoughForRenaming()) {
				hold.setItemName(example.getDisplayName());
			}
			damageGinder = true;
		} else if (example == null) {
			ItemKey.setRandomCipher(hold);
			damageGinder = true;
			if(grindStone.isGoodEnoughForRenaming()) {
				hold.setItemName(UltimateExtender.concat(
						StatCollector.translateToLocal(hold.getItem().getUnlocalizedName().concat(".name")),
						" (", player.getDisplayName(), ")"
						));
			}
		}
		ItemKey.setBonus(hold, grindStone.getRandomBuff());
		return damageGinder;
	}

}
