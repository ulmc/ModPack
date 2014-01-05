package ru.ulmc.extender.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import ru.ulmc.extender.Reference;

public class ItemPicklock extends Item {

	private int securityLevel = 0;
	public Icon placeholder;

	public ItemPicklock(int i, String unlocalizedName, int securityLevel, int maxDamage) {
		super(i);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.RES_NAME + unlocalizedName);
		setCreativeTab(CreativeTabs.tabTools);
		this.securityLevel = securityLevel;
		this.setMaxStackSize(1);
		this.setMaxDamage(maxDamage);
	}

	/*
	 * @Override public void registerIcons(IconRegister par1IconRegister) {
	 * super.registerIcons(par1IconRegister); this.placeholder =
	 * par1IconRegister.registerIcon(Reference.RES_NAME +
	 * "placeholderPicklock"); }
	 */

	public int getSecurityLevel() {
		return securityLevel;
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
			list.add(EnumChatFormatting.DARK_GREEN + "Common");
		} else if (bonus < 0.5F) {
			list.add(EnumChatFormatting.DARK_GREEN + "Simple");
		} else if(bonus > 0.5F && bonus < 1.0F) {
			list.add(EnumChatFormatting.DARK_GREEN + "Sharpen");
		} else if(bonus < 2) {
			list.add(EnumChatFormatting.GREEN + "Good");
		} else if(bonus < 3) {
			list.add(EnumChatFormatting.GREEN + "Epic");
		} else {
			list.add(EnumChatFormatting.GREEN + "Masterpiece");
		}

	}
	
	public static void createNBT(ItemStack itemStack) {
		itemStack.stackTagCompound = new NBTTagCompound();
		itemStack.stackTagCompound.setFloat("bonus", 0.0F);
	}

}
