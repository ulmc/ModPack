package ru.ulmc.extender.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface Grindable {
	/**
	 * 
	 * @param player
	 * @param grinder - GrindStone installed
	 * @param hold - Item Player holds
	 * @param example - Item placed in second grinders slot
	 * @return
	 */
	boolean grindItem(EntityPlayer player, ItemStack grinder, ItemStack hold, ItemStack example);
}
