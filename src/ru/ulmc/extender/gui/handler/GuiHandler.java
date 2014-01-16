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
package ru.ulmc.extender.gui.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ru.ulmc.extender.container.ContainerBones;
import ru.ulmc.extender.container.ContainerGrinder;
import ru.ulmc.extender.container.ContainerLockedChest;
import ru.ulmc.extender.gui.GuiBones;
import ru.ulmc.extender.gui.GuiGrinder;
import ru.ulmc.extender.gui.GuiLockedChest;
import ru.ulmc.extender.tileentity.TileEntityBones;
import ru.ulmc.extender.tileentity.TileEntityGrinder;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {

		TileEntity te = world.getBlockTileEntity(x, y, z);
		
		switch (id) {
		case GuiBones.GUI_ID:
			if(te instanceof TileEntityBones) {
			return new ContainerBones(player.inventory,
					(TileEntityBones) te);
			}
		case GuiLockedChest.GUI_ID:
			if(te instanceof TileEntityLockedChest) {
			return new ContainerLockedChest(player.inventory,
					(TileEntityLockedChest) te);
			}
		case GuiGrinder.GUI_ID:
			if(te instanceof TileEntityGrinder) {
			return new ContainerGrinder(player.inventory,
					(TileEntityGrinder) te);
			}
		default:
			return null;
		}

	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		
		TileEntity te = world.getBlockTileEntity(x, y, z);

		switch (id) {
			case GuiBones.GUI_ID:
				if(te instanceof TileEntityBones) {
					return new GuiBones(player.inventory, (TileEntityBones)te);
				}
			case GuiLockedChest.GUI_ID:
				if(te instanceof TileEntityLockedChest) {
				return new GuiLockedChest(player.inventory,
						(TileEntityLockedChest) te);
				}
			case GuiGrinder.GUI_ID:
				if(te instanceof TileEntityGrinder) {
				return new GuiGrinder(player.inventory,
						(TileEntityGrinder) te);
				}
			default:
				return null;
		}

	}
}