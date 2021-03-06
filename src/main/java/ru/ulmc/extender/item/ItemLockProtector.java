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
package ru.ulmc.extender.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;

import java.util.List;
import java.util.Random;

public class ItemLockProtector extends Item implements Grindable, UItem {

	private static Random random = new Random();
	public IIcon placeholder;
	private ProtectorType type;
	private String clearItemName;

	public ItemLockProtector(String unlocalizedName, int durability, ProtectorType type) {
		super();
		setUnlocalizedName(unlocalizedName);
		clearItemName = unlocalizedName;
		setTextureName(Reference.RES_NAME + unlocalizedName);
		setCreativeTab(CreativeTabs.tabTools);
		if ("capsuleEmpty".equals(unlocalizedName)) {
			this.setMaxStackSize(32);
		} else {
			this.setMaxStackSize(1);
		}
		this.setMaxDamage(durability);
		this.type = type;

	}

	public static void logThief(ItemStack target, String name) {
		NBTTagCompound tag = target.getTagCompound();
		if (tag == null) {
			target.setTagCompound(new NBTTagCompound());
			tag = target.getTagCompound();
		}
		for (int i = 1; i < 6; i++) {
			if (!tag.getString("thief" + i).isEmpty()) {
				if (tag.getString("thief" + i).equals(name)) {
					tag.setInteger("count" + i, tag.getInteger("count" + i) + 1);
					break;
				}
			} else {
				tag.setString("thief" + i, name);
				tag.setInteger("count" + i, 1);
				break;
			}
		}
	}

	private static void createNBT(ItemStack itemStack) {
		itemStack.stackTagCompound = new NBTTagCompound();
		if (((ItemLockProtector) itemStack.getItem()).getType() == ProtectorType.LOGGER) {
			itemStack.stackTagCompound.setInteger("count1", 0);
			itemStack.stackTagCompound.setInteger("count2", 0);
			itemStack.stackTagCompound.setInteger("count3", 0);
			itemStack.stackTagCompound.setInteger("count4", 0);
			itemStack.stackTagCompound.setInteger("count5", 0);

			itemStack.stackTagCompound.setString("thief1", "");
			itemStack.stackTagCompound.setString("thief2", "");
			itemStack.stackTagCompound.setString("thief3", "");
			itemStack.stackTagCompound.setString("thief4", "");
			itemStack.stackTagCompound.setString("thief5", "");

		}
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		super.registerIcons(par1IconRegister);
		this.placeholder = par1IconRegister.registerIcon(Reference.RES_NAME + "placeholderCapsule");
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (itemStack.stackTagCompound == null) {
			createNBT(itemStack);
		}

		if (type == ProtectorType.LOGGER) {
			for (int i = 1; i < 6; i++) {
				list.add(UltimateExtender.concat(
						EnumChatFormatting.DARK_GREEN.toString(),
						itemStack.stackTagCompound.getString("thief" + i),
						" (",
						String.valueOf(itemStack.stackTagCompound.getInteger("count" + i)),
						")"
				));
			}
		}

	}

	public ProtectorType getType() {
		return type;
	}

	public int onEnforce(TileEntityLockedChest tile, EntityPlayer player, ItemStack picklock) {
		switch (type) {
			case DAMAGE_ABSORBER:
				if (tryToPreventEnforce(type.getOnEnforceChance(), tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case SHOCKER:
				if (tryToHurtThief(type.getOnEnforceChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case FIRESTARTER:
				if (tryToSetThiefOnFire(type.getOnEnforceChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case SIREN:
				if (tryToShoutLoud(type.getOnEnforceChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case LOGGER:
				// it have no sense.
				break;
			case REDSTONE:
				if (tryToPowerUp(type.getOnEnforceChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case ANTIPICKLOCK:
				if (tryToBrakePicklock(type.getOnEnforceChance(), player, tile, picklock)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case TNTLOCK:
				if (tryExplodeEverything(type.getOnEnforceChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
		}
		return TileEntityLockedChest.PICKLOCKING_SUCCESSED;
	}

	public int onPicklockFail(TileEntityLockedChest tile, EntityPlayer player, ItemStack picklock) {
		switch (type) {
			case DAMAGE_ABSORBER:
				// nothing to do here;
				break;
			case SHOCKER:
				if (tryToHurtThief(type.getOnFailChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case FIRESTARTER:
				if (tryToSetThiefOnFire(type.getOnFailChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case SIREN:
				if (tryToShoutLoud(type.getOnFailChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case LOGGER:
				if (tryToLogThiefName(type.getOnFailChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case REDSTONE:
				if (tryToPowerUp(type.getOnFailChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case ANTIPICKLOCK:
				if (tryToBrakePicklock(type.getOnFailChance(), player, tile, picklock)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case TNTLOCK:
				if (tryExplodeEverything(type.getOnFailChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
		}
		return TileEntityLockedChest.PICKLOCKING_FAILED;
	}

	public int onKeyDamage(TileEntityLockedChest tile, EntityPlayer player, ItemStack picklock) {
		switch (type) {
			case DAMAGE_ABSORBER:
				if (tryToAbsorbDamage(type.getOnKeyDamageChance(), tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				return TileEntityLockedChest.PICKLOCKING_KEY_DAMAGED;
			case SHOCKER:
				if (tryToHurtThief(type.getOnKeyDamageChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case FIRESTARTER:
				if (tryToSetThiefOnFire(type.getOnKeyDamageChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case SIREN:
				if (tryToShoutLoud(type.getOnKeyDamageChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case LOGGER:
				if (tryToLogThiefName(type.getOnKeyDamageChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case REDSTONE:
				if (tryToPowerUp(type.getOnKeyDamageChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case ANTIPICKLOCK:
				if (tryToBrakePicklock(type.getOnKeyDamageChance(), player, tile, picklock)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case TNTLOCK:
				if (tryExplodeEverything(type.getOnKeyDamageChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
		}
		return TileEntityLockedChest.PICKLOCKING_KEY_DAMAGED;
	}

	public int onProbingChance(TileEntityLockedChest tile, EntityPlayer player, ItemStack picklock) {
		switch (type) {
			case DAMAGE_ABSORBER:
				if (tryToAbsorbDamage(type.getOnProbingChance(), tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				return TileEntityLockedChest.PICKLOCKING_KEY_DAMAGED;
			case SHOCKER:
				if (tryToHurtThief(type.getOnProbingChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case FIRESTARTER:
				if (tryToSetThiefOnFire(type.getOnProbingChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case SIREN:
				if (tryToShoutLoud(type.getOnProbingChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case LOGGER:
				if (tryToLogThiefName(type.getOnProbingChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case REDSTONE:
				if (tryToPowerUp(type.getOnProbingChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case ANTIPICKLOCK:
				if (tryToBrakePicklock(type.getOnProbingChance(), player, tile, picklock)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
			case TNTLOCK:
				if (tryExplodeEverything(type.getOnProbingChance(), player, tile)) {
					return TileEntityLockedChest.PICKLOCKING_PROTECTOR;
				}
				break;
		}
		return TileEntityLockedChest.PICKLOCKING_KEY_DAMAGED;
	}

	private boolean tryToPowerUp(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if (chance != 0.0f && random.nextFloat() < chance) {
			if (!tile.getWorldObj().isRemote) {
				tile.setProvidingPower(true);
				tile.getWorldObj().notifyBlocksOfNeighborChange(
						tile.xCoord,
						tile.yCoord,
						tile.zCoord, tile.getBlockType());
				tile.getWorldObj().scheduleBlockUpdate(tile.xCoord, tile.yCoord, tile.zCoord, BlockManager.blockLockedChest, 40);
				tile.damageProtector();
			}
			return true;
		}

		return false;
	}

	private boolean tryToShoutLoud(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if (chance != 0.0f && random.nextFloat() < chance) {
			if (!tile.getWorldObj().isRemote) {
				EntityPlayer owner = tile.getWorldObj().getPlayerEntityByName(tile.getOwnerName());
				if (owner != null) {
					owner.addChatMessage(new ChatComponentText(UltimateExtender.loc("msg.sirenAlarm")));
				}
				tile.damageProtector();
			}
			return true;
		}

		return false;
	}

	private boolean tryExplodeEverything(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if (chance != 0.0f && random.nextFloat() < chance) {
			if (!tile.getWorldObj().isRemote) {
				tile.clearAllItems();
				tile.getWorldObj().createExplosion((Entity) null, tile.xCoord, tile.yCoord, tile.zCoord, ProtectorType.TNT_EXPLOSIONSIZE, false);
				tile.getWorldObj().setBlockToAir(tile.xCoord, tile.yCoord, tile.zCoord);
			}
			return true;
		}

		return false;
	}

	private boolean tryToBrakePicklock(float chance, EntityPlayer player, TileEntityLockedChest tile, ItemStack picklock) {
		if (chance != 0.0f && random.nextFloat() < chance) {
			picklock.damageItem(Math.round(random.nextFloat() * ProtectorType.ANTIPICKLOCK_STRENGTH), player);
			tile.damageProtector();
			return true;
		}

		return false;
	}

	private boolean tryToLogThiefName(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if (chance != 0.0f && random.nextFloat() < chance) {
			ItemLockProtector.logThief(tile.getCurrentProtector(), player.getDisplayName());
			tile.damageProtector();
			return true;
		}

		return false;
	}

	private boolean tryToSetThiefOnFire(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if (chance != 0.0f && random.nextFloat() < chance) {
			player.setFire(ProtectorType.FIRESTARTER_FIRE_TIME);
			tile.damageProtector();
			return true;
		}

		return false;
	}

	private boolean tryToHurtThief(float chance, EntityPlayer player, TileEntityLockedChest tile) {
		if (chance != 0.0f && random.nextFloat() < chance) {
			player.attackEntityFrom(DamageSource.magic, ProtectorType.SHOCKER_DAMAGE - random.nextFloat());
			tile.damageProtector();
			return true;
		}

		return false;
	}

	private boolean tryToPreventEnforce(float chance, TileEntityLockedChest tile) {
		if (chance == 0.0f) {
			return false;
		} else if (random.nextFloat() < chance) {
			tile.destroyProtector();
			return true;
		}
		return false;
	}

	private boolean tryToAbsorbDamage(float chance, TileEntityLockedChest tile) {
		if (chance == 0.0f) {
			return false;
		} else if (chance == 1.0f) {
			absorbDamage(tile, true);
			return true;
		} else if (random.nextFloat() < chance) {
			absorbDamage(tile, true);
			return true;
		} else {
			absorbDamage(tile, false);
		}
		return false;
	}

	private void absorbDamage(TileEntityLockedChest tile, boolean really) {
		if (really) {
			tile.damageProtector();
		} else {
			tile.damageKey();
		}
	}

	@Override
	public String getClearItemName() {
		return clearItemName;
	}

	@Override
	public boolean grindItem(EntityPlayer player, ItemStack grinder, ItemStack hold, ItemStack example) {
		if (this.type == ProtectorType.LOGGER) {
			createNBT(hold);
		}
		return true;
	}

	public enum ProtectorType {
		DAMAGE_ABSORBER(0.2f, 0.0F, 0.95f, 0.0F),
		SHOCKER(1.0f, 0.10F, 0.6f, 0.1F),
		FIRESTARTER(0.8f, 0.05F, 0.6f, 0.1F),
		SIREN(0.9f, 0.15F, 0.8f, 0.1F),
		LOGGER(0.0f, 0.25F, 0.8f, 0.1F),
		REDSTONE(1.0f, 0.15F, 0.9f, 0.1F),
		//REDSTONE(1.0f, 1.15F, 1.0f),
		TNTLOCK(1.0f, 0.5F, 0.9f, 0.6F),
		ANTIPICKLOCK(1.0f, 0.65F, 0.9f, 0.5F);
		public static final float SHOCKER_DAMAGE = 5.0f;
		public static final int FIRESTARTER_FIRE_TIME = 9; //in seconds
		public static final int ANTIPICKLOCK_STRENGTH = 10;
		public static final float TNT_EXPLOSIONSIZE = 5.0f;
		private float onEnforceChance;
		private float onFailChance;
		private float onKeyDamageChance;
		private float onProbingChance;

		private ProtectorType(float onEnforceChance, float onFailChance, float onKeyDamageChance, float onProbingChance) {
			this.onEnforceChance = onEnforceChance;
			this.onFailChance = onFailChance;
			this.onKeyDamageChance = onKeyDamageChance;
			this.onProbingChance = onProbingChance;

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

		public float getOnProbingChance() {
			return onProbingChance;
		}

	}

}
