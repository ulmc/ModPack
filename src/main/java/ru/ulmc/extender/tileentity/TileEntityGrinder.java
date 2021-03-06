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
package ru.ulmc.extender.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.container.ContainerGrinder;
import ru.ulmc.extender.item.Grindable;
import ru.ulmc.extender.item.ItemGrind;

import java.util.Timer;
import java.util.TimerTask;

public class TileEntityGrinder extends ExtendedTileEntity implements IInventory {
	private ItemStack[] inv = new ItemStack[3];
	private int impulse = 0;
	private Timer timer = new Timer();

	public TileEntityGrinder() {

	}

	public int getImpulse() {
		return impulse;
	}

	public void setImpulse(int impulse) {
		this.impulse = impulse;
	}

	public boolean grindItem(EntityPlayer player) {
		/*impulse = 100;

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				impulse--;
				updateContainingBlockInfo();
				if (impulse == 0) {
					cancel();
				}
			}
		}, 0,  1000);*/
		ItemStack grinder = getGrinder();
		ItemStack hold = player.inventory.getCurrentItem();

		if (grinder == null || hold == null || !(grinder.getItem() instanceof ItemGrind)
				|| !(hold.getItem() instanceof Grindable)) {
			return false;
		}
		Grindable item = (Grindable) hold.getItem();

		if (item.grindItem(player, grinder, hold, getExample())) {
			damageGrinder(grinder);
			return true;

		}
		return false;
	}

	public int getGrinderType() {
		ItemStack grind = getGrinder();
		if(grind == null || grind.getItem() == null || grind.stackSize == 0) {
			return -1;
		}
		Item item = grind.getItem();
		if(item instanceof ItemGrind) {
			return ((ItemGrind) item).getType();
		}
		return -2;
	}

	private ItemStack getExample() {
		return inv[ContainerGrinder.ITEM_SLOT_ID];
	}

	private ItemStack getGrinder() {
		return inv[ContainerGrinder.GRIND_SLOT_ID];
	}

	public boolean isGrinderSetup() {
		return !(inv[ContainerGrinder.GRIND_SLOT_ID] == null);
	}

	private void damageGrinder(ItemStack grinder) {
		int damageMultiplier = 5;
		grinder.setItemDamage(grinder.getItemDamage() + (int) (Math.random() * damageMultiplier));
		if (grinder.getItemDamage() > grinder.getMaxDamage()) {
			inv[ContainerGrinder.GRIND_SLOT_ID] = null;
			UltimateExtender.markSomeBlockForUpdate(this.getWorldObj(), this.xCoord, this.yCoord, this.zCoord);
		}
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= amt) {
				setInventorySlotContents(slot, null);
			} else {
				stack = stack.splitStack(amt);
				if (stack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this
				&& player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		NBTTagList tagList = tagCompound.getTagList("Inventory", Reference.NBT_TAG_LIST_ID);
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
		impulse = tagCompound.getInteger("impulse");
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];
			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
		tagCompound.setInteger("impulse", impulse);
	}

	@Override
	public String getInventoryName() {
		return "tco.tileentitylockedchest";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}


	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
	}

	/**
	 * invalidates a tile entity
	 */
	@Override
	public void invalidate() {
		super.invalidate();
		this.updateContainingBlockInfo();
	}

	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

}
