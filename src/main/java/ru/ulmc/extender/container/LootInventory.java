package ru.ulmc.extender.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

/**
 * Created by 45 on 30.09.2014.
 */
public class LootInventory implements IInventory {
	private static final int INV_SIZE = 9;
	private ItemStack[] inventory = new ItemStack[INV_SIZE];
	private Container eventHandler;

	public LootInventory(Container eventHandler) {
		this.eventHandler = eventHandler;
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory() {
		return INV_SIZE;
	}

	/**
	 * Returns the stack in slot i
	 */
	public ItemStack getStackInSlot(int i) {
		if (i >= INV_SIZE) {
			return null;
		} else {
			return this.inventory[i];
		}
	}

	/**
	 * Returns the name of the inventory
	 */
	public String getInventoryName() {
		return "VictimInventory";
	}

	/**
	 * Returns if the inventory is named
	 */
	public boolean hasCustomInventoryName() {
		return false;
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		if (this.inventory[p_70298_1_] != null) {
			ItemStack itemstack;

			if (this.inventory[p_70298_1_].stackSize <= p_70298_2_) {
				itemstack = this.inventory[p_70298_1_];
				this.inventory[p_70298_1_] = null;
				this.eventHandler.onCraftMatrixChanged(this);
				return itemstack;
			} else {
				itemstack = this.inventory[p_70298_1_].splitStack(p_70298_2_);

				if (this.inventory[p_70298_1_].stackSize == 0) {
					this.inventory[p_70298_1_] = null;
				}

				this.eventHandler.onCraftMatrixChanged(this);
				return itemstack;
			}
		} else {
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot,
	 * then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		if (this.inventory[p_70304_1_] != null) {
			ItemStack itemstack = this.inventory[p_70304_1_];
			this.inventory[p_70304_1_] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	public void setInventorySlotContents(int i, ItemStack p_70299_2_) {
		if (i < INV_SIZE)
			this.inventory[i] = p_70299_2_;
	}

	/**
	 * Returns the maximum stack size for a inventory slot.
	 */
	public int getInventoryStackLimit() {
		return 64;
	}

	/**
	 * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
	 * hasn't changed and skip it.
	 */
	public void markDirty() {
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 */
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return true;
	}

	public void openInventory() {
	}

	public void closeInventory() {
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 */
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return false;
	}
}
