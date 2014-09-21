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
package ru.ulmc.extender;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;

import java.util.HashMap;

/**
 * Created by 45 on 01.02.14.
 */
public class TimerManager {
	private final HashMap<EntityPlayer, Runnable> chestUsers = new HashMap<EntityPlayer, Runnable>();

	public synchronized void markUsingChest(final EntityPlayer player, final ItemStack itemStack, final TileEntityLockedChest chest) {
		chestUsers.put(player, new Runnable() {
			@Override
			public void run() {
				chest.doWork(itemStack, player);
				//UltimateExtender.logger.log(Level.WARNING, "Running Task: " + !player.getEntityWorld().isRemote);
				chestUsers.remove(player);
			}
		});
	}

	public synchronized void runTask(EntityPlayer player) {
		if (chestUsers.containsKey(player)) {
			chestUsers.get(player).run();
		} else {
			UltimateExtender.logger.error("Can't run task. There is no task for this player! at server: " + !player.getEntityWorld().isRemote);
		}

	}

}

