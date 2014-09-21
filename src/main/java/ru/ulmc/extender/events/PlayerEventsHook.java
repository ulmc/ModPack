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
package ru.ulmc.extender.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.item.ItemManager;
import ru.ulmc.extender.tileentity.TileEntityBones;

import java.util.ArrayList;
import java.util.List;

/**
 * Name and cast of this class are irrelevant
 */
public class PlayerEventsHook {

	@SubscribeEvent
	public void harvestingLockedChest(PlayerEvent.HarvestCheck event) {
		if (!event.entityPlayer.worldObj.isRemote && !event.entityPlayer.capabilities.isCreativeMode) {
			if (Block.isEqualTo(BlockManager.blockLockedChest, event.block)) {
				event.success = false;
				event.setCanceled(true);
			}
		}
	}

/*	@SubscribeEvent
	public void stopAllTimers(cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent event) {
		if(event.player instanceof EntityPlayer) {

		}
	}*/

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void hidePlayerDisplayName(RenderLivingEvent.Specials.Pre event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if (player.getCurrentArmor(3) != null &&
					Item.getIdFromItem(player.getCurrentArmor(3).getItem()) == ItemManager.maskId) {
				if (event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent
	public void setBlockOfBones(PlayerDropsEvent event) {
		if (event.entityPlayer != null && !event.entityPlayer.worldObj.isRemote) {
			int coordX = MathHelper.floor_double(event.entityPlayer.posX);
			int coordY = MathHelper.floor_double(event.entityPlayer.posY);
			int coordZ = MathHelper.floor_double(event.entityPlayer.posZ);
			boolean allowToPlace = false;
			World world = event.entityPlayer.worldObj;
			allowToPlace =  canPlaceOnThatHeight(world, coordX, coordY, coordZ) ||
							canPlaceOnThatHeight(world, coordX, coordY + 1, coordZ) ||
							canPlaceOnThatHeight(world, coordX, coordY - 1, coordZ);
					
			if (allowToPlace) {
				event.entityPlayer.worldObj.setBlock(coordX, coordY, coordZ, BlockManager.blockBones);
				int p = MathHelper.floor_double((event.entityPlayer.rotationYaw * 4F) / 360F + 0.5D) & 3;

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

				TileEntityBones chest = (TileEntityBones) event.entityPlayer.worldObj.getTileEntity(coordX, coordY,
						coordZ);
				chest.setOwnerName(event.entityPlayer.getDisplayName());
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
						chest.setInventorySlotContents(i++, new ItemStack(Items.rotten_flesh, 1));
						slotsLeft--;
					}
					if (slotsLeft > 0 && rand > 0.25D) {
						chest.setInventorySlotContents(i++, new ItemStack(Items.bone));
						slotsLeft--;
					}
				}
				event.drops.clear();
				event.drops.addAll(newDrop);
			}
		}
	}
	
	private boolean canPlaceOnThatHeight(World world, int x, int y, int z) {
		return  checkIfCanPlace(world, x, y, z) ||
				checkIfCanPlace(world, x, y + 1, z) ||
				checkIfCanPlace(world, x, y - 1, z) ||
				checkIfCanPlace(world, x - 1, y, z) ||
				checkIfCanPlace(world, x + 1, y, z) ||
				checkIfCanPlace(world, x, y, z - 1) ||
				checkIfCanPlace(world, x, y, z + 1) ||
				checkIfCanPlace(world, x + 1, y, z + 1) ||
				checkIfCanPlace(world, x - 1, y, z - 1);
	}

	private boolean checkIfCanPlace(World world, int x, int y, int z) {
		return world.isAirBlock(x, y , z) || world.getBlock(x,y,z).isReplaceable(world, x, y, z);
	}
}