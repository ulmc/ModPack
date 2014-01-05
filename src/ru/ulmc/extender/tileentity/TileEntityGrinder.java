package ru.ulmc.extender.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import ru.ulmc.extender.container.ContainerGrinder;
import ru.ulmc.extender.item.ItemGrind;
import ru.ulmc.extender.item.ItemKey;
import ru.ulmc.extender.item.ItemPicklock;

public class TileEntityGrinder extends ExtendedTileEntity implements IInventory {
	private ItemStack[] inv = new ItemStack[3];

	public TileEntityGrinder() {

	}

	public boolean grindItem(EntityPlayer player) {
		ItemStack grinder = getGrinder();
		ItemStack stack = player.inventory.getCurrentItem();
		if (grinder == null || stack == null || !(grinder.getItem() instanceof ItemGrind)) {
			return false;
		}
		ItemGrind grindStone = (ItemGrind) grinder.getItem();

		boolean damageGinder = false;
		Item item = stack.getItem();

		if (item instanceof ItemKey) {
			if (getExample() != null && getExample().getItem() instanceof ItemKey) {
				ItemKey.cloneCipher(getExample(), stack);
				damageGinder = true;
			} else if (getExample() == null) {
				ItemKey.setRandomCipher(stack);
				damageGinder = true;
			}
			ItemKey.setBonus(stack, grindStone.getRandomBuff());

		}

		if (item instanceof ItemPicklock) {
			ItemPicklock.setBonus(stack, grindStone.getRandomBuff());
		}

		if (damageGinder) {
			damageGrinder(grinder);
		}
		return damageGinder;
	}

	private ItemStack getExample() {
		return inv[ContainerGrinder.ITEM_SLOT_ID];
	}

	private ItemStack getGrinder() {
		return inv[ContainerGrinder.GRIND_SLOT_ID];
	}

	private void damageGrinder(ItemStack grinder) {
		int damageMultiplier = 5;
		grinder.setItemDamage(grinder.getItemDamage() + (int) (Math.random() * damageMultiplier));
		if (grinder.getItemDamage() > grinder.getMaxDamage()) {
			inv[ContainerGrinder.GRIND_SLOT_ID] = null;
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
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this
				&& player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		NBTTagList tagList = tagCompound.getTagList("Inventory");
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
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
	}

	@Override
	public String getInvName() {
		return "tco.tileentitylockedchest";
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
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

	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
	}

	/**
	 * invalidates a tile entity
	 */
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

	@Override
	public void openChest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub

	}

}
