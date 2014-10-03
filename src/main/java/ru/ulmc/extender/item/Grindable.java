/*
 * Copyright (C) 2014. ulmc.ru (Alex K.)
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
 */

package ru.ulmc.extender.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface Grindable {
	/**
	 * @param player
	 * @param grinder - GrindStone installed
	 * @param hold    - Item Player holds
	 * @param example - Item placed in second grinders slot
	 * @return
	 */
	boolean grindItem(EntityPlayer player, ItemStack grinder, ItemStack hold, ItemStack example);
}
