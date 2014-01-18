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
package ru.ulmc.extender.item;

import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;

public class ItemLockProtector extends Item {

	public Icon placeholder;
	private ProtectorType type;	
	private static Random random = new Random();

	public ItemLockProtector(int i, String unlocalizedName, int durability, ProtectorType type) {
		super(i);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.RES_NAME + unlocalizedName);
		setCreativeTab(CreativeTabs.tabTools);
		this.setMaxStackSize(1);
		this.setMaxDamage(durability);
		this.type = type;
		
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		super.registerIcons(par1IconRegister);
		this.placeholder = par1IconRegister.registerIcon(Reference.RES_NAME + "placeholderCapsule");
	}
	
	
	
	public static void logThief(ItemStack target, String name) {
		NBTTagCompound tag = target.getTagCompound();
		if (tag == null) {
			target.setTagCompound(new NBTTagCompound());
			tag = target.getTagCompound();
		}
		String thieves = tag.getString("log");
		NBTTagList list = tag.getTagList("access");
		if(list != null) {
			list.appendTag(new NBTTagString(name));
				
		} 
		
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (itemStack.stackTagCompound == null) {
			createNBT(itemStack);
		}
		String log = itemStack.stackTagCompound.getString("log");		
		
		if (log == null || log.isEmpty()) {
			list.add(EnumChatFormatting.DARK_GREEN + "");
		} else {
			list.add(EnumChatFormatting.GREEN + log);
		}

	}

	private static void createNBT(ItemStack itemStack) {
		itemStack.stackTagCompound = new NBTTagCompound();
		if(((ItemLockProtector)itemStack.getItem()).getType() == ProtectorType.LOGGER) {
			itemStack.stackTagCompound.setString("log", "");
		}
	}
	
	public ProtectorType getType() {
		return type;
	}

	public int onEnforce(TileEntityLockedChest tile, EntityPlayer player, ItemStack picklock) {
		switch(type) {
		case DAMAGE_ABSORBER: 
			if(tryToPreventEnforce(type.getOnEnforceChance(), tile)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			} 
			break;
		case SHOCKER: 
			if(tryToHurtThief(type.getOnEnforceChance(), player, tile)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case FIRESTARTER: 
			if(tryToSetThiefOnFire(type.getOnEnforceChance(), player, tile)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case SIREN: 
			if(tryToShoutLoud(type.getOnEnforceChance(), player, tile)){
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case LOGGER: 
			// it have no sense.
			break;		
		case REDSTONE: 
			if(tryToPowerUp(type.getOnEnforceChance(), player, tile)){
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case ANTIPICKLOCK:
			if(tryToBrakePicklock(type.getOnEnforceChance(), player, tile, picklock)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;
		case TNTLOCK:
			if(tryExplodeEverything(type.getOnEnforceChance(), player, tile)){
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;
		}
		return TileEntityLockedChest.PICKLOCKING_SUCCESSED;
	}
	public int onPicklockFail(TileEntityLockedChest tile, EntityPlayer player, ItemStack picklock) {
		switch(type) {
		case DAMAGE_ABSORBER: 
			// nothing to do here;
			break;
		case SHOCKER: 
			if(tryToHurtThief(type.getOnFailChance(), player, tile)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case FIRESTARTER: 
			if(tryToSetThiefOnFire(type.getOnFailChance(), player, tile)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case SIREN: 
			if(tryToShoutLoud(type.getOnFailChance(), player, tile)){
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}	
			break;		
		case LOGGER: 
			if(tryToLogThiefName(type.getOnFailChance(), player, tile)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case REDSTONE: 
			if(tryToPowerUp(type.getOnFailChance(), player, tile)){
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case ANTIPICKLOCK:
			if(tryToBrakePicklock(type.getOnFailChance(), player, tile, picklock)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;
		case TNTLOCK:
			if(tryExplodeEverything(type.getOnFailChance(), player, tile)){
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;
		}		
		return TileEntityLockedChest.PICKLOCKING_FAILED;
	}
	
	public int onKeyDamage(TileEntityLockedChest tile, EntityPlayer player, ItemStack picklock) {
		switch(type) {
		case DAMAGE_ABSORBER: 
			if(tryToAbsorbDamage(type.getOnKeyDamageChance(), tile)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			} 
			return TileEntityLockedChest.PICKLOCKING_KEY_DAMAGED;
		case SHOCKER: 
			if(tryToHurtThief(type.getOnKeyDamageChance(), player, tile)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case FIRESTARTER: 
			if(tryToSetThiefOnFire(type.getOnKeyDamageChance(), player, tile)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case SIREN: 
			if(tryToShoutLoud(type.getOnKeyDamageChance(), player, tile)){
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}			
			break;		
		case LOGGER: 
			if(tryToLogThiefName(type.getOnKeyDamageChance(), player, tile)) {
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case REDSTONE: 
			if(tryToPowerUp(type.getOnKeyDamageChance(), player, tile)){
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;		
		case ANTIPICKLOCK:
			if(tryToBrakePicklock(type.getOnKeyDamageChance(), player, tile, picklock)){
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;
		case TNTLOCK:
			if(tryExplodeEverything(type.getOnKeyDamageChance(), player, tile)){
				return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
			}
			break;
		}
		return TileEntityLockedChest.PICKLOCKING_KEY_DAMAGED;
	}
	
	private boolean tryToPowerUp(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if(chance != 0.0f && random.nextFloat() < chance){
			if(!tile.getWorldObj().isRemote) {
				tile.setProvidingPower(true);
				tile.getWorldObj().notifyBlocksOfNeighborChange(
						tile.xCoord, 
						tile.yCoord,
						tile.zCoord, tile.getBlockType().blockID);
				tile.getWorldObj().scheduleBlockUpdate(tile.xCoord, tile.yCoord, tile.zCoord, BlockManager.blockLockedChest.blockID, 40);
				tile.damageProtector();
			} 
			return true;
		}	
		
		return false;
	}
	
	private boolean tryToShoutLoud(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if(chance != 0.0f && random.nextFloat() < chance){
			if(!tile.getWorldObj().isRemote) {
				EntityPlayer owner = tile.getWorldObj().getPlayerEntityByName(tile.getOwnerName());
				if(owner != null) {
					owner.addChatMessage("Someone trying to unlock your chest");
				}
				tile.damageProtector();
			} 
			return true;
		}	
		
		return false;
	}
	
	private boolean tryExplodeEverything(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if(chance != 0.0f && random.nextFloat() < chance){
			if(!tile.getWorldObj().isRemote) {
				tile.clearAllItems();
				tile.getWorldObj().createExplosion((Entity)null, tile.xCoord, tile.yCoord, tile.zCoord, ProtectorType.TNT_EXPLOSIONSIZE, false);
				tile.getWorldObj().destroyBlock(tile.xCoord, tile.yCoord, tile.zCoord, false);						
			}			
			return true;
		}	
		
		return false;
	}
	
	private boolean tryToBrakePicklock(float chance, EntityPlayer player, TileEntityLockedChest tile, ItemStack picklock) {
		if(chance != 0.0f && random.nextFloat() < chance){
			picklock.damageItem((int)Math.round(random.nextFloat() * ProtectorType.ANTIPICKLOCK_STRENGTH), player);
			tile.damageProtector();
			return true;
		}	
		
		return false;
	}
	
	private boolean tryToLogThiefName(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if(chance != 0.0f && random.nextFloat() < chance){
			ItemLockProtector.logThief(tile.getCurrentProtector(), player.getDisplayName());
			tile.damageProtector();
			return true;
		}	
		
		return false;
	}
	
	private boolean tryToSetThiefOnFire(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if(chance != 0.0f && random.nextFloat() < chance){
			player.setFire(ProtectorType.FIRESTARTER_FIRE_TIME);
			tile.damageProtector();
			return true;
		}	
		
		return false;
	}
	
	private boolean tryToHurtThief(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if(chance != 0.0f && random.nextFloat() < chance){
			player.attackEntityFrom(DamageSource.magic, ProtectorType.SHOCKER_DAMAGE - random.nextFloat());
			tile.damageProtector();
			return true;
		}	
		
		return false;
	}
	
	private boolean tryToPreventEnforce(float chance, TileEntityLockedChest tile) {
		if(chance == 0.0f) {
			return false;
		} else if(random.nextFloat() < chance){
			tile.destroyProtector();
			return true;
		} 	
		return false;
	}	
	
	private boolean tryToAbsorbDamage(float chance, TileEntityLockedChest tile) {
		if(chance == 0.0f) {
			return false;
		} else if(chance == 1.0f) { 
			absorbDamage(tile, true);
			return true;			
		} else if(random.nextFloat() < chance){
			absorbDamage(tile, true);
			return true;
		} else {
			absorbDamage(tile, false);
		}		
		return false;
	}
	
	private void absorbDamage(TileEntityLockedChest tile, boolean really) {
		if(really) {
			tile.damageProtector(); 
		} else {
			tile.damageKey();
		}		
	}	
	
	public enum ProtectorType {
		DAMAGE_ABSORBER(0.2f, 0.0F, 0.95f), 
		SHOCKER(1.0f, 0.10F, 0.6f), 
		FIRESTARTER(0.8f, 0.05F, 0.6f), 
		SIREN(0.9f, 0.15F, 0.8f),
		LOGGER(0.0f, 0.05F, 0.9f),
		REDSTONE(1.0f, 0.15F, 0.9f),
		//REDSTONE(1.0f, 1.15F, 1.0f),
		TNTLOCK(1.0f, 0.5F, 0.9f),
		ANTIPICKLOCK(1.0f, 0.65F, 0.9f);
		
		private float onEnforceChance;
		private float onFailChance;
		private float onKeyDamageChance;
		
		public static final float SHOCKER_DAMAGE		= 5.0f;
		public static final int   FIRESTARTER_FIRE_TIME	= 9; //in seconds
		public static final int   ANTIPICKLOCK_STRENGTH	= 10; 
		public static final float TNT_EXPLOSIONSIZE		= 5.0f; 
		
		private ProtectorType(float onEnforceChance, float onFailChance, float onKeyDamageChance) {
			this.onEnforceChance = onEnforceChance;
			this.onFailChance = onFailChance;
			this.onKeyDamageChance = onKeyDamageChance;
		}

		public float getOnEnforceChance() {
			return onEnforceChance;
		}

		public float getOnFailChance() {
			return onFailChance;
		}

		public float getOnKeyDamageChance() {
			return onKeyDamageChance;
		}
	}
	
}
