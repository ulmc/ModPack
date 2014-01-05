package ru.ulmc.extender.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.item.ItemGrind;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;

public class ContainerGrinder extends Container {
	
	public static final int GRIND_SLOT_ID = 0;
	public static final int ITEM_SLOT_ID = 1;
	protected TileEntityLockedChest tileEntity;
	protected int playerInventoryOffset = 9;
	protected int extraSlotNum = 2;

	private IInventory lowerChestInventory;
	private int numRows;
	
	private int baseOffsetX = 8;
	private int slotSize = 18;
	private int basePlayerInventoryOffset = 123;
	private int quickPlayerInventoryOffset = 181;
	

	public ContainerGrinder(IInventory par1IInventory, IInventory par2IInventory) {
		this.lowerChestInventory = par2IInventory;
		this.numRows = par2IInventory.getSizeInventory() / 9;
		par2IInventory.openChest();
		int i = (this.numRows - 4) * 18;
		int j;
		int k;
		
		this.addSlotToContainer(new GrinderSlot(par2IInventory, GRIND_SLOT_ID,	62, 19)); // key
		this.addSlotToContainer(new Slot(par2IInventory, ITEM_SLOT_ID,	98, 19)); //helper
		
		for (j = 0; j < 9; j++) {
			this.addSlotToContainer(new Slot(par1IInventory, 
					j, 
					baseOffsetX + j * slotSize, 
					quickPlayerInventoryOffset + i));
		}
		for (j = 0; j < 3; j++) {
			for (k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(par1IInventory, 
						k + j * 9 + 9, 
						baseOffsetX + k * slotSize, 
						basePlayerInventoryOffset + j * slotSize + i));
			}
		}

		
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return this.lowerChestInventory.isUseableByPlayer(par1EntityPlayer);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (par2 < extraSlotNum) {
				if (!this.mergeItemStack(itemstack1, extraSlotNum, this.inventorySlots.size(), true)) {
					return null;
				}
			} else {
				if(itemstack1.getItem() instanceof ItemGrind) {
					if (!this.mergeItemStack(itemstack1, GRIND_SLOT_ID, GRIND_SLOT_ID+1, false)) {
						return null;
					}
				} else {
					if (!this.mergeItemStack(itemstack1, ITEM_SLOT_ID, extraSlotNum, false)) {
						return null;
					}
				}				
			}
			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
		super.onContainerClosed(par1EntityPlayer);
		this.lowerChestInventory.closeChest();
	}

	/**
	 * Return this chest container's lower chest inventory.
	 */
	public IInventory getLowerChestInventory() {
		return this.lowerChestInventory;
	}
}
