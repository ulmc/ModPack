package ru.ulmc.extender.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;

public class ContainerLockedChest extends Container {
	
	public static final int KEY_SLOT_ID = 0;
	public static final int PROTECTOR_SLOT_ID = 1;
	protected TileEntityLockedChest tileEntity;
	protected int linesNum = 2;
	protected int inLine = 9;
	protected int totalItems = 18;
	protected int playerInventoryOffset = 9;
	protected int extraSlotNum = 2;

	private IInventory lowerChestInventory;
	private int numRows;
	
	private int baseOffsetX = 8;
	private int baseOffsetY = 26;
	private int slotSize = 18;
	private int basePlayerInventoryOffset = 112;
	private int quickPlayerInventoryOffset = 170;
	

	public ContainerLockedChest(IInventory par1IInventory, IInventory par2IInventory) {
		this.lowerChestInventory = par2IInventory;
		this.numRows = par2IInventory.getSizeInventory() / 9;
		par2IInventory.openChest();
		int i = (this.numRows - 4) * 18;
		int j;
		int k;
		
		this.addSlotToContainer(new KeySlot(par2IInventory, KEY_SLOT_ID,	134, 6)); // key
		this.addSlotToContainer(new ProtectorSlot(par2IInventory, PROTECTOR_SLOT_ID,	152, 6)); //helper
		
		for (j = 0; j < this.numRows; j++) {
			for (k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(par2IInventory, 
						k + j * 9 + 2, // Index
						baseOffsetX + k * slotSize, // X position
						baseOffsetY + j * slotSize)); //y position
			}
		}
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

			if (par2 < this.numRows * 9) {
				if (!this.mergeItemStack(itemstack1, this.numRows * 9 + extraSlotNum, this.inventorySlots.size(), true)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, extraSlotNum, this.numRows * 9 + extraSlotNum, false)) {
				return null;
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
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);				
		//this.lowerChestInventory.closeChest();
	}

	/**
	 * Return this chest container's lower chest inventory.
	 */
	public IInventory getLowerChestInventory() {
		return this.lowerChestInventory;
	}
	
}
