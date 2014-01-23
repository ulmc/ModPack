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
package ru.ulmc.extender.tileentity;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import ru.ulmc.extender.block.BlockLockedChest;
import ru.ulmc.extender.container.ContainerLockedChest;
import ru.ulmc.extender.item.ItemKey;
import ru.ulmc.extender.item.ItemLockProtector;
import ru.ulmc.extender.item.ItemPicklock;

public class TileEntityLockedChest extends ExtendedTileEntity implements IInventory {
	public static final int PICKLOCKING_FAILED = 0; 
	public static final int PICKLOCKING_SUCCESSED = 1; 
	public static final int PICKLOCKING_KEY_DAMAGED = 2; 
	public static final int PICKLOCKING_PROTECTOR = 3; 
	private ItemStack[] inv = new ItemStack[38];
	private int filledSlots;
	private String ownerName;
	private int chestType;

	/** The current angle of the lid (between 0 and 1) */
	public float lidAngle;

	/** The angle of the lid last tick */
	public float prevLidAngle;

	/** The number of players currently using this chest */
	public int numUsingPlayers;
	
	public int isPowered;

	/** Server sync counter (once per 20 ticks) */
	private int ticksSinceSync;

	public TileEntityLockedChest(int chestType, Block block) {
		this.chestType = chestType;
		this.blockType = block;
	}

	public TileEntityLockedChest() {
		
		
	}

	public boolean isKeyAndCipherMatches(ItemStack cipher) {
		ItemStack key = inv[ContainerLockedChest.KEY_SLOT_ID];

		if (cipher == null || key == null) {
			return false;
		} else if (!(key.getItem() instanceof ItemKey) || !(cipher.getItem() instanceof ItemKey)) {
			return false;
		} else if (ItemKey.getCipher(key) == ItemKey.getCipher(cipher)
				&& ((ItemKey) key.getItem()).getSecurityLevel() == ((ItemKey) cipher.getItem()).getSecurityLevel()) {
			return true;
		}
		return false;
	}

	public int tryToEnforceChest(ItemStack picklock, EntityPlayer player) {
		ItemStack key = inv[ContainerLockedChest.KEY_SLOT_ID];
		ItemStack protectorStack = inv[ContainerLockedChest.PROTECTOR_SLOT_ID];	
		boolean passToProtector;
		ItemLockProtector protector;
		
		if(protectorStack == null || !(protectorStack.getItem() instanceof ItemLockProtector)) {
			passToProtector = false;
			protector = null;
		} else {
			passToProtector = true;
			protector = (ItemLockProtector)protectorStack.getItem();
		}
		
		if (picklock == null) {
			return PICKLOCKING_FAILED;
		}
		
		if (key == null) {
			enforceChest(player.username);
			return PICKLOCKING_SUCCESSED;
		} else if (!(picklock.getItem() instanceof ItemPicklock)) {			
			return PICKLOCKING_FAILED;
		} else {
			int keyLevel = ((ItemKey) key.getItem()).getSecurityLevel();
			float keyBonus = ItemKey.getBonus(key);
			int picklockLevel = ((ItemPicklock) picklock.getItem()).getSecurityLevel();
			float picklockBonus = ItemPicklock.getBonus(picklock);

			double multiplier = ((picklockLevel + picklockBonus) / (keyLevel + keyBonus));
			
			double minRequried = 0.01D * multiplier;
			double damageRequried = 0.06D * multiplier;

			double chance = Math.random();

			/*UltimateExtender.logger.info("minRequried: " + minRequried + " chance:" + chance
					+ "picklockLevel, picklockBonus: " + picklockLevel + " : " + picklockBonus + "keyLevel, keyBonus: "
					+ keyLevel + " : " + keyBonus + " | multiplier = " + multiplier);*/
			if (chance < minRequried) {				
				if(passToProtector) {
					int result = protector.onEnforce(this, player, picklock);
					if(result == PICKLOCKING_SUCCESSED) {
						enforceChest(player.username);
						picklock.damageItem(1, player);						
					} 
					return result;
				}
				enforceChest(player.username);
				return PICKLOCKING_SUCCESSED;
				
			} else {
				chance =  Math.random();
				if (chance < damageRequried) {
					damageKey();
					//UltimateExtender.logger.info("DAMAGE! damageRequried: " + damageRequried + " chance:" + chance + " | multiplier = " + multiplier);
					if(passToProtector) {			
						picklock.damageItem(1, player);
						return protector.onKeyDamage(this, player, picklock);
					}
					picklock.damageItem(1, player);
					return PICKLOCKING_KEY_DAMAGED;
				} else {
					if(passToProtector) {
						picklock.damageItem(1, player);
						return protector.onPicklockFail(this, player, picklock);
					}
				}
				picklock.damageItem(2, player);
				return PICKLOCKING_FAILED;
			}
		}
	}

	public void damageKey() {
		ItemStack key = getCurrentKey();
		key.setItemDamage(key.getItemDamage() + 1);
		if (key.getItemDamage() > key.getMaxDamage()) {
			inv[ContainerLockedChest.KEY_SLOT_ID] = null;
		}
	}
	
	public void damageProtector() {
		ItemStack protector = getCurrentProtector();
		protector.setItemDamage(protector.getItemDamage() + 1);
		if (protector.getItemDamage() > protector.getMaxDamage()) {
			inv[ContainerLockedChest.PROTECTOR_SLOT_ID] = null;
		}
	}
	
	public void setProvidingPower(boolean isIt) {
		if(isIt) {
			isPowered = 15;
		} else {
			isPowered = 0;
		}
		
	}
	public int isPowered() {
		return isPowered;
	}
	
	
	public void destroyProtector() {
		inv[ContainerLockedChest.PROTECTOR_SLOT_ID] = null;
	}
	
	public ItemStack getCurrentKey() {
		return inv[ContainerLockedChest.KEY_SLOT_ID];
	}
	public ItemStack getCurrentProtector() {
		return inv[ContainerLockedChest.PROTECTOR_SLOT_ID];
	}

	public void enforceChest(String username) {
		setOwnerName(username);
		inv[ContainerLockedChest.KEY_SLOT_ID] = null;
		inv[ContainerLockedChest.PROTECTOR_SLOT_ID] = null;
	}

	public boolean isChestProtected() {
		ItemStack key = inv[ContainerLockedChest.KEY_SLOT_ID];

		if (key == null || !(key.getItem() instanceof ItemKey)) {
			return false;
		}
		return true;
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
		this.filledSlots = 0;
		NBTTagList tagList = tagCompound.getTagList("Inventory");
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
		filledSlots = tagCompound.getInteger("filledSlots");
		ownerName = tagCompound.getString("ownerName");
		chestType = tagCompound.getInteger("chestType");
		isPowered = tagCompound.getInteger("isPowered");

		// UltimateExtender.logger.info("filledSlots: " + filledSlots);
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		this.filledSlots = 0;
		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];
			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
				this.filledSlots++;
			}
		}
		tagCompound.setTag("Inventory", itemList);
		tagCompound.setInteger("filledSlots", filledSlots);
		tagCompound.setInteger("chestType", chestType);
		tagCompound.setInteger("isPowered", isPowered);
		if (ownerName != null) {
			tagCompound.setString("ownerName", ownerName);
		}
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

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
	 * Allows the entity to update its state. Overridden in most subclasses,
	 * e.g. the mob spawner uses this to count ticks and creates a new spawn
	 * inside its implementation.
	 */
	@Override
	@SuppressWarnings({ "rawtypes" })
	public void updateEntity() {
		super.updateEntity();
		++this.ticksSinceSync;
		float f;

		if (!this.worldObj.isRemote && this.numUsingPlayers != 0
				&& (this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0) {
			this.numUsingPlayers = 0;
			f = 5.0F;
			List list = this.worldObj.getEntitiesWithinAABB(
					EntityPlayer.class,
					AxisAlignedBB.getAABBPool().getAABB(this.xCoord - f,
							this.yCoord - f, this.zCoord - f,
							this.xCoord + 1 + f, this.yCoord + 1 + f,
							this.zCoord + 1 + f));
			Iterator iterator = list.iterator();

			while (iterator.hasNext()) {
				EntityPlayer entityplayer = (EntityPlayer) iterator.next();

				if (entityplayer.openContainer instanceof ContainerLockedChest) {
					IInventory iinventory = ((ContainerLockedChest) entityplayer.openContainer).getLowerChestInventory();

					if (iinventory == this || iinventory instanceof InventoryLargeChest
							&& ((InventoryLargeChest) iinventory).isPartOfLargeChest(this)) {
						++this.numUsingPlayers;
					}
				}
			}
		}

		this.prevLidAngle = this.lidAngle;
		f = 0.1F;
		double d0;

		if (this.numUsingPlayers > 0 && this.lidAngle == 0.0F) {
			double d1 = this.xCoord + 0.5D;
			d0 = this.zCoord + 0.5D;

			this.worldObj.playSoundEffect(d1, this.yCoord + 0.5D, d0, "random.chestopen", 0.5F,
					this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
		}

		if (this.numUsingPlayers == 0 && this.lidAngle > 0.0F || this.numUsingPlayers > 0 && this.lidAngle < 1.0F) {
			float f1 = this.lidAngle;

			if (this.numUsingPlayers > 0) {
				this.lidAngle += f;
			} else {
				this.lidAngle -= f;
			}

			if (this.lidAngle > 1.0F) {
				this.lidAngle = 1.0F;
			}

			float f2 = 0.5F;

			if (this.lidAngle < f2 && f1 >= f2) {
				d0 = this.xCoord + 0.5D;
				double d2 = this.zCoord + 0.5D;

				this.worldObj.playSoundEffect(d0, this.yCoord + 0.5D, d2, "random.chestclosed", 0.5F,
						this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
			}

			if (this.lidAngle < 0.0F) {
				this.lidAngle = 0.0F;
			}
		}
	}

	/**
	 * Called when a client event is received with the event number and
	 * argument, see World.sendClientEvent
	 */
	@Override
	public boolean receiveClientEvent(int par1, int par2) {
		if (par1 == 1) {
			this.numUsingPlayers = par2;
			return true;
		} else {
			return super.receiveClientEvent(par1, par2);
		}
	}

	@Override
	public void openChest() {
		if (this.numUsingPlayers < 0) {
			this.numUsingPlayers = 0;
		}

		++this.numUsingPlayers;
		this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID, 1,
				this.numUsingPlayers);
	}

	@Override
	public void closeChest() {
		if (this.getBlockType() != null && this.getBlockType() instanceof BlockLockedChest) {
			--this.numUsingPlayers;
			this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID, 1,
					this.numUsingPlayers);
		}
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
	/**
	 * Warning! this method is destroying all content of a chest
	 */
	public void clearAllItems() {
		for (int i = 0; i < inv.length; i++) {
			inv[i] = null;
		}
	}
	
}
