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
package ru.ulmc.extender.events;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.item.ItemManager;
import ru.ulmc.extender.tileentity.TileEntityBones;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;

/**
 * Name and cast of this class are irrelevant
 */
public class PlayerEventsHook {

	@ForgeSubscribe
	public void harvestingLockedChest(PlayerEvent.HarvestCheck event) {
		if (!event.entityPlayer.worldObj.isRemote) {			
			if (event.block.blockID == BlockManager.blockLockedChest.blockID) {
				event.success = false;
			}
		}
	}
	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void hidePlayerDisplayName(RenderLivingEvent.Specials.Pre event) {
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			if(player.getCurrentArmor(3) != null && player.getCurrentArmor(3).itemID == ItemManager.maskId) {
				if(event.isCancelable()) {
					event.setCanceled(true);
				}	
			}
		}
	}

	@ForgeSubscribe
	public void setBlockOfBones(PlayerDropsEvent event) {
		if (event.entityPlayer != null && !event.entityPlayer.worldObj.isRemote) {
			int coordX = (int) event.entityPlayer.posX;
			int coordY = (int) event.entityPlayer.posY;
			int coordZ = (int) event.entityPlayer.posZ;
			boolean allowToPlace = false;
			if (event.entityPlayer.worldObj.isAirBlock(coordX, coordY, coordZ)) {
				allowToPlace = true;
			} else {
				if (event.entityPlayer.worldObj.isAirBlock(coordX, coordY - 1, coordZ)) {
					allowToPlace = true;
					coordY--;
				} else if (event.entityPlayer.worldObj.isAirBlock(coordX - 1, coordY, coordZ)) {
					allowToPlace = true;
					coordX--;
				} else if (event.entityPlayer.worldObj.isAirBlock(coordX + 1, coordY, coordZ)) {
					allowToPlace = true;
					coordX++;
				} else if (event.entityPlayer.worldObj.isAirBlock(coordX, coordY, coordZ - 1)) {
					allowToPlace = true;
					coordZ--;
				} else if (event.entityPlayer.worldObj.isAirBlock(coordX, coordY, coordZ + 1)) {
					allowToPlace = true;
					coordZ--;
				} else if (event.entityPlayer.worldObj.isAirBlock(coordX, coordY + 1, coordZ)) {
					allowToPlace = true;
					coordY++;
				}
			}
			if (allowToPlace) {
				event.entityPlayer.worldObj.setBlock(coordX, coordY, coordZ, BlockManager.blockBones.blockID);
				int p = MathHelper.floor_double((double) ((event.entityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;

				int aByte = 3;
				if (p == 0) {
					aByte = 2;
				} else if (p == 3) {
					aByte = 3;
				} else if (p == 2) {
					aByte = 0;
				} else if (p == 1) {
					aByte = 1;
				}
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(coordX, coordY, coordZ, aByte, 2);

				TileEntityBones chest = (TileEntityBones) event.entityPlayer.worldObj.getBlockTileEntity(coordX, coordY,
						coordZ);
				chest.setOwnerName(event.entityPlayer.username);
				int i = 0;
				int searchOffset;
				int slotsLeft = 18;
				boolean isSecondPassNeeded = true;

				if (event.drops.size() < 4) {
					searchOffset = event.drops.size();
					isSecondPassNeeded = false;
				} else {
					searchOffset = 4;
				}

				List<EntityItem> lastElements = event.drops.subList(event.drops.size() - searchOffset, event.drops.size());
				ArrayList<EntityItem> newDrop = new ArrayList<EntityItem>();
				for (EntityItem item : lastElements) {
					if (!item.getEntityItem().isStackable() && slotsLeft > 0) {
						chest.setInventorySlotContents(i++, item.getEntityItem());
						slotsLeft--;
					}
				}
				if (isSecondPassNeeded) {
					List<EntityItem> firstElements = event.drops.subList(0, event.drops.size() - searchOffset);
					for (EntityItem item : firstElements) {
						if (!item.getEntityItem().isStackable() && slotsLeft > 0) {
							chest.setInventorySlotContents(i++, item.getEntityItem());
							slotsLeft--;
						} else {
							newDrop.add(item);
						}
					}
				}
				if (slotsLeft > 0) {
					double rand = Math.random();
					if (slotsLeft > 0 && rand > 0.10D) {
						chest.setInventorySlotContents(i++, new ItemStack(Item.rottenFlesh, 1));
						slotsLeft--;
					}
					if (slotsLeft > 0 && rand > 0.25D) {
						chest.setInventorySlotContents(i++, new ItemStack(Item.bone));
						slotsLeft--;
					}
				}
				event.drops.clear();
				event.drops.addAll(newDrop);
			}
		}
	}
}