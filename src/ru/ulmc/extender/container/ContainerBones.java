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
package ru.ulmc.extender.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.tileentity.TileEntityBones;

public class ContainerBones extends Container {

	protected TileEntityBones tileEntity;
	protected int linesNum = 2;
	protected int inLine = 9;
	protected int totalItems = 18;
	protected int playerInventoryOffset = 9;
	

	public ContainerBones(InventoryPlayer inventoryPlayer, TileEntityBones te) {
		tileEntity = te;

		for (int line = 0; line < linesNum; line++) {
			for (int row = 0; row < inLine; row++) {
				addSlotToContainer(new ReSlot(tileEntity, line * inLine + row, 8 + row * 18,
						18 + line * 18));
			}
		}

		bindPlayerInventory(inventoryPlayer); 
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tileEntity.isUseableByPlayer(player);
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + playerInventoryOffset,
						8 + j * 18, 68 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 126));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		ItemStack stack = null;
		Slot slotObject = (Slot) inventorySlots.get(slot);
		
		// null checks and checks if the item can be stacked (maxStackSize > 1)
		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			// merges the item into player inventory since its in the tileEntity
			if (slot < totalItems) {
				if (!this.mergeItemStack(stackInSlot, totalItems, totalItems + 36, true)) {
					return null;
				}
			} else if (!this.mergeItemStack(stackInSlot, 0, totalItems, true)) {
				return null;
			}

			if (stackInSlot.stackSize == 0) {
				slotObject.putStack(null);
			} else {
				slotObject.onSlotChanged();
			}

			if (stackInSlot.stackSize == stack.stackSize) {
				return null;
			}
			slotObject.onPickupFromSlot(player, stackInSlot);
		}
		return stack;
	}
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		
		UltimateExtender.markSomeBlockForUpdate(player.worldObj, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
		
	}
}
