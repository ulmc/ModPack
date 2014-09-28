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
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.entity.living.LivingEvent;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.config.Config;
import ru.ulmc.extender.item.IWarmArmor;
import ru.ulmc.extender.network.WarmPacket;
import ru.ulmc.extender.util.UDamageSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarmHandler {

	public static final float DAYLIGHT = 0.78F;
	private static final float percent = 100.0f;
	private static Map<EntityPlayer, Integer> playersTicks = new HashMap<EntityPlayer, Integer>();
	private static Map<EntityPlayer, Float> playersThermalLevel = new HashMap<EntityPlayer, Float>();
	public final int BOOTS = 0;
	public final int PANTS = 1;
	public final int BODY = 2;
	public final int HAT = 3;
	private int tickStepBasic;
	private int underGroundPosition;
	private float underGroundBonus;
	private float underGroundCoolBonus;
	private float defaultArmorWarmness;
	private float defaultArmorCoolness;
	private float defaultNoneArmorCoolness;
	private float defaultNoneArmorLavaProtection;
	private float defaultArmorLavaProtection;
	private float inWaterPenalty;
	private float waterNearBonus;
	private float fireResistanceBonus;
	private float nightPenalty;
	private float dayPenalty;
	private float stormPenalty;
	private float rainPenalty;
	private float torchBonus;
	private float lavaPenalty;
	private float inSnowPenalty;
	private float coldItemBonus;
	private float normalization;
	private float coldMultiplier;
	private float hotMultiplier;
	private float neutralValue;
	private float allowableDeviation;

	private float multiplierPacket;
	private float damageSize;
	private boolean sendMessageToPlayer;

	private List<Block> lavaBlocks = new ArrayList<Block>();
	private List<Block> coolBlocks = new ArrayList<Block>();
	private List<Block> hotBlocks = new ArrayList<Block>();
	private List<Block> coldBlocks = new ArrayList<Block>();

	private String handlerLabel = "ulmc SurviveSeason SheduledHandler";


	public WarmHandler() {
		super();
		tickStepBasic = Config.getSurvivalInt("thermal.updateStep");
		underGroundPosition = Config.getSurvivalInt("thermal.undergroundPosition");

		underGroundBonus = Config.getSurvivalFloat("thermal.underGroundBonus");
		underGroundCoolBonus = Config.getSurvivalFloat("thermal.underGroundCoolBonus");
		defaultArmorWarmness = Config.getSurvivalFloat("thermal.defaultArmorWarmness");
		defaultArmorCoolness = Config.getSurvivalFloat("thermal.defaultArmorCoolness");
		defaultNoneArmorCoolness = Config.getSurvivalFloat("thermal.defaultNoneArmorCoolness");
		defaultArmorLavaProtection = Config.getSurvivalFloat("thermal.defaultArmorLavaProtection");
		defaultNoneArmorLavaProtection = Config.getSurvivalFloat("thermal.defaultNoneArmorLavaProtection");
		inWaterPenalty = Config.getSurvivalFloat("thermal.inWaterPenalty");
		waterNearBonus = Config.getSurvivalFloat("thermal.waterNearBonus");
		fireResistanceBonus = Config.getSurvivalFloat("thermal.fireResistanceBonus");
		nightPenalty = Config.getSurvivalFloat("thermal.nightPenalty");
		dayPenalty = Config.getSurvivalFloat("thermal.dayPenalty");
		stormPenalty = Config.getSurvivalFloat("thermal.stormPenalty");
		rainPenalty = Config.getSurvivalFloat("thermal.rainPenalty");
		torchBonus = Config.getSurvivalFloat("thermal.torchBonus");
		multiplierPacket = Config.getSurvivalFloat("thermal.multiplier.packet");
		normalization = Config.getSurvivalFloat("thermal.multiplier.normalization");
		damageSize = Config.getSurvivalFloat("thermal.damageSize");
		lavaPenalty = Config.getSurvivalFloat("thermal.lavaPenalty");
		inSnowPenalty = Config.getSurvivalFloat("thermal.inSnowPenalty");
		coldMultiplier = Config.getSurvivalFloat("thermal.multiplier.coldBiome");
		hotMultiplier = Config.getSurvivalFloat("thermal.multiplier.hotBiome");
		neutralValue = Config.getSurvivalFloat("thermal.neutral.value");
		allowableDeviation = Config.getSurvivalFloat("thermal.allowable.deviation");

		sendMessageToPlayer = Config.getSurvivalInt("thermal.debug.sendMessageToPlayer") == 1;

		lavaBlocks.add(Blocks.lava);
		lavaBlocks.add(Blocks.flowing_lava);

		hotBlocks.add(Blocks.lava);
		hotBlocks.add(Blocks.flowing_lava);
		hotBlocks.add(Blocks.fire);

		coolBlocks.add(Blocks.flowing_water);
		coolBlocks.add(Blocks.water);
		coolBlocks.add(Blocks.ice);
		coolBlocks.add(Blocks.packed_ice);
		coolBlocks.add(Blocks.snow);
		coolBlocks.add(Blocks.snow_layer);

		coldBlocks.add(Blocks.snow_layer);
		coldBlocks.add(Blocks.snow);
		coldBlocks.add(Blocks.packed_ice);
		coldBlocks.add(Blocks.ice);
	}

	@SubscribeEvent
	public void clearMap(PlayerEvent.PlayerLoggedOutEvent event) {
		playersTicks.remove(event.player);
		//playersThermalLevel.remove(event.player); будем сохранять температу игрока... чтобы не спасались логаутами
	}

	@SubscribeEvent
	public void clearMap(PlayerEvent.PlayerRespawnEvent event) {
		playersTicks.remove(event.player);
		//playersThermalLevel.remove(event.player); будем сохранять температу игрока... чтобы не спасались логаутами
	}

	@SubscribeEvent
	public void doTheWork(LivingEvent.LivingUpdateEvent event) {
		if (!(event.entityLiving instanceof EntityPlayerMP)) {
			return;
		}
		EntityPlayerMP player = (EntityPlayerMP) event.entityLiving;
		if (player == null)
			return;
		if (player.capabilities.isCreativeMode || player.isBurning()) {
			if (playersThermalLevel.get(player) != null && playersThermalLevel.get(player) != 0) {
				playersThermalLevel.put(player, null);
				UltimateExtender.networkWrapper.sendTo(new WarmPacket(-1000, -1000, false), player);
			}
			return;
		}
		if (playersTicks.get(player) != null && (playersTicks.get(player) - tickStepBasic != 0)) {
			playersTicks.put(player, playersTicks.get(player) + 1);
			return;
		} else {
			playersTicks.put(player, 1);
		}

		World world = player.worldObj;
		int currentX = MathHelper.floor_double(player.posX);
		int currentZ = MathHelper.floor_double(player.posZ);
		int currentY = MathHelper.floor_double(player.posY);
		BiomeGenBase biome = world.getBiomeGenForCoords(currentX, currentZ);
		float temp = biome.getFloatTemperature(currentX, currentZ, currentY);
		Float warmnessDelta;
		if (Math.abs(temp - neutralValue) < allowableDeviation) {
			if (isLavaNear(world, currentX - 2, currentY - 2, currentZ - 2,
					currentX + 2, currentY + 2, currentZ + 2)) {
				warmnessDelta = lavaPenalty;
				warmnessDelta += calculateHeatPower(warmnessDelta, player, currentX, currentZ, currentY, true, false);
				if (warmnessDelta > 0) {
					checkThermalLevel(player, warmnessDelta);
				} else {
					returnPlayerToNormal(player);
				}
			} else {
				returnPlayerToNormal(player);
			}
		} else {
			float tempStr = temp > neutralValue ? temp * hotMultiplier : temp * coldMultiplier * ( temp > 0 ? -1 : 1);
			if (tempStr < 0) {
				float coldStrength = Math.abs(tempStr);
				boolean noWarmNear = !isBoxWarm(world,
						currentX - 5, currentY - 4, currentZ - 5,
						currentX + 5, currentY + 3, currentZ + 5);
				if (noWarmNear) {
					if (player.posY < underGroundPosition || haveRoofOrSo(world, currentX, currentY, currentZ)) {
						coldStrength -= underGroundBonus;
					} else {
						if (world.getLightBrightness(currentX, currentY, currentZ) < DAYLIGHT) {
							coldStrength += nightPenalty;
						}
						if (world.isThundering()) {
							coldStrength += stormPenalty;
						} else if (world.isRaining()) {
							coldStrength += rainPenalty;
						}
						if (isInSnow(player, currentX, currentY, currentZ)) {
							coldStrength += inSnowPenalty;
						}
					}
					if (player.getCurrentEquippedItem() != null) {
						int equippedID = Item.getIdFromItem(player.getCurrentEquippedItem().getItem());
						if ((equippedID == Item.getIdFromItem(Items.lava_bucket) ||
								equippedID == Block.getIdFromBlock(Blocks.torch))) {
							coldStrength -= torchBonus;
						}
					}
					if (player.isInWater()) {
						coldStrength += inWaterPenalty;
						warmnessDelta = -1 * coldStrength * 4;
					} else {
						warmnessDelta = getWarmness(player, coldStrength, HAT, true);
						warmnessDelta += getWarmness(player, coldStrength, BODY, true);
						warmnessDelta += getWarmness(player, coldStrength, PANTS, true);
						warmnessDelta += getWarmness(player, coldStrength, BOOTS, true);
						warmnessDelta = (float) Math.rint(warmnessDelta * percent) / 100;
					}
					if (warmnessDelta < 0) {
						checkThermalLevel(player, warmnessDelta);
					} else {
						returnPlayerToNormal(player);
					}
				} else {
					returnPlayerToNormal(player);
				}
			} else {
				float hotStrength = Math.abs(tempStr);
				if (player.isImmuneToFire()) {
					return;
				}
				if (!biome.equals(BiomeGenBase.hell)) {
					if (player.posY < underGroundPosition) {
						hotStrength -= underGroundCoolBonus - nightPenalty;
					} else {
						if (world.isThundering()) {
							hotStrength -= stormPenalty;
						} else if (world.isRaining()) {
							hotStrength -= rainPenalty;
						}
						if (!world.isDaytime()) {
							hotStrength -= nightPenalty;
						} else if (world.getLightBrightness(currentX, currentY, currentZ) > DAYLIGHT) {
							hotStrength += dayPenalty;
						}
					}
				}
				warmnessDelta = calculateHeatPower(hotStrength, player, currentX, currentZ, currentY, false, true); //hell

				if (warmnessDelta > 0) {
					checkThermalLevel(player, warmnessDelta);
				} else {
					returnPlayerToNormal(player);
				}
			}
		}
	}

	private boolean isInSnow(EntityPlayer player, int curX, int curY, int curZ) {
		for (Block block : coldBlocks) {
			if (Block.isEqualTo(block, player.worldObj.getBlock(curX, curY, curZ)) ||
					Block.isEqualTo(block, player.worldObj.getBlock(curX - 1, curY, curZ)) ||
					Block.isEqualTo(block, player.worldObj.getBlock(curX + 1, curY, curZ)) ||
					Block.isEqualTo(block, player.worldObj.getBlock(curX, curY, curZ - 1)) ||
					Block.isEqualTo(block, player.worldObj.getBlock(curX, curY, curZ + 1)) ||
					Block.isEqualTo(block, player.worldObj.getBlock(curX - 1, curY, curZ - 1)) ||
					Block.isEqualTo(block, player.worldObj.getBlock(curX + 1, curY, curZ + 1))) {
				return true;
			}
		}
		return false;
	}

	private void returnPlayerToNormal(EntityPlayerMP player) {
		if (playersThermalLevel.get(player) != null && playersThermalLevel.get(player) != 0.0f) {
			boolean isCold = playersThermalLevel.get(player) < 0;
			float deltaMultiplied = normalization * playersThermalLevel.get(player) * (-1);
			playersThermalLevel.put(player, playersThermalLevel.get(player) + deltaMultiplied);
			if (isCold && playersThermalLevel.get(player) +0.2 > 0 || !isCold && playersThermalLevel.get(player) -0.2 < 0) {
				playersThermalLevel.put(player, null);
				deltaMultiplied = 0;
			}
			sendPacket(player, (int) (deltaMultiplied * percent), 0, isCold);
		} else {
			sendPacket(player, 0, 0, false);
		}
	}

	/**
	 * Проверяет термический уровень игрока. Идет по возрастающей
	 * 0 - норма, отклонение в обе стороны ведёт к нанесению урона.
	 *
	 * @param player
	 * @param delta
	 */
	private void checkThermalLevel(EntityPlayerMP player, Float delta) {
		if (playersThermalLevel.get(player) == null) {
			playersThermalLevel.put(player, 0f);
		}

		float deltaMultiplied = delta * multiplierPacket;
		playersThermalLevel.put(player, playersThermalLevel.get(player) + deltaMultiplied);
		boolean isCold = playersThermalLevel.get(player) < 0;
		float absMax = Math.abs(playersThermalLevel.get(player));
		if (absMax >= damageSize) {
			if (sendMessageToPlayer)
				UltimateExtender.debug(player, "THERMAL HIT: " + deltaMultiplied + ", " + delta);
			if (playersThermalLevel.get(player) < 0) {
				player.attackEntityFrom(UDamageSource.cold, absMax);
			} else {
				player.attackEntityFrom(UDamageSource.hot, absMax);
			}
			playersThermalLevel.put(player, 0.0f);
		}
		sendPacket(player, Math.round(deltaMultiplied * percent), Math.round(delta * percent), isCold);
	}

	private float getWarmnessNearLava(EntityPlayer player, float heat, int armorType) {
		ItemStack armor = player.getCurrentArmor(armorType);

		if (armor != null && armor.getItem() instanceof IWarmArmor) {
			if (((IWarmArmor) armor.getItem()).itLavaProtected()) {
				return heat - ((IWarmArmor) armor.getItem()).getLavaProtectionLevel();
			} else if (((IWarmArmor) armor.getItem()).itCools()) {
				return heat - ((IWarmArmor) armor.getItem()).getCoolLevel();
			} else {
				return heat + ((IWarmArmor) armor.getItem()).getWarmLevel();
			}
		} else if (armor != null) {
			return heat - defaultArmorLavaProtection;
		}
		return heat - defaultNoneArmorLavaProtection;
	}


	private float calculateHeatPower(float currentHeat, EntityPlayer player,
	                                 int currentX, int currentZ, int currentY, boolean isLavaDefinitelyNear, boolean isHell) {
		if (player.isInWater()) {
			currentHeat -= inWaterPenalty;
		}

		if (player.isPotionActive(Potion.fireResistance)) {
			currentHeat -= fireResistanceBonus;
		}

		if (player.getCurrentEquippedItem() != null) {
			int equippedID = Item.getIdFromItem(player.getCurrentEquippedItem().getItem());
			if ((equippedID == Item.getIdFromItem(Items.water_bucket) ||
					equippedID == Item.getIdFromItem(Items.snowball))) {
				currentHeat -= coldItemBonus;
			}
		}
		float warmnessDelta;
		boolean isLavaNear = isLavaDefinitelyNear || isLavaNear(player.worldObj, currentX - 2, currentY - 1, currentZ - 2,
				currentX + 2, currentY + 2, currentZ + 2);
		if (isLavaNear) {
			currentHeat += lavaPenalty;
		}

		if (isLavaNear || isHell) {
			warmnessDelta = getWarmnessNearLava(player, currentHeat, HAT);
			warmnessDelta += getWarmnessNearLava(player, currentHeat, BODY);
			warmnessDelta += getWarmnessNearLava(player, currentHeat, PANTS);
			warmnessDelta += getWarmnessNearLava(player, currentHeat, BOOTS);
		} else {
			if (isBoxHaveWater(player.worldObj,
					currentX - 3, currentY - 3, currentZ - 3,
					currentX + 3, currentY + 2, currentZ + 3)) {
				currentHeat -= waterNearBonus;
			}
			warmnessDelta = getWarmness(player, currentHeat, HAT, false);
			warmnessDelta += getWarmness(player, currentHeat, BODY, false);
			warmnessDelta += getWarmness(player, currentHeat, PANTS, false);
			warmnessDelta += getWarmness(player, currentHeat, BOOTS, false);
		}
		warmnessDelta = (float) Math.rint(warmnessDelta * percent) / 100;
		return warmnessDelta;
	}

	private float getWarmness(EntityPlayer player, float tempOutside, int armorType, boolean isWinter) {
		ItemStack armor = player.getCurrentArmor(armorType);

		if (armor != null && armor.getItem() instanceof IWarmArmor) {

			if (isWinter) {
				if (((IWarmArmor) armor.getItem()).itWarms()) {
					return ((IWarmArmor) armor.getItem()).getWarmLevel() - tempOutside;
				} else {
					return tempOutside - ((IWarmArmor) armor.getItem()).getCoolLevel();
				}
			} else {
				if (((IWarmArmor) armor.getItem()).itCools()) {
					return tempOutside - ((IWarmArmor) armor.getItem()).getCoolLevel();
				} else {
					return tempOutside + ((IWarmArmor) armor.getItem()).getWarmLevel();
				}
			}

		} else if (armor != null) {
			if (isWinter) {
				return defaultArmorWarmness - tempOutside;
			} else {
				return tempOutside - defaultArmorCoolness;
			}
		}
		if (isWinter) {
			return -tempOutside;
		} else {
			if (armorType != HAT) {
				return defaultNoneArmorCoolness - tempOutside;
			} else {
				return tempOutside - defaultNoneArmorCoolness;
			}
		}
	}

	private void sendPacket(EntityPlayerMP player, int x, int y, boolean z) {
		UltimateExtender.networkWrapper.sendTo(new WarmPacket(x, y, z), player);
	}

	private boolean haveRoofOrSo(World world, int curX, int curY, int curZ) {

		int minY = curY + 2;
		int maxY = curY + 6;

		for (int i = minY; i < maxY; i++) {
			if (!world.isAirBlock(curX, i, curZ) &&
					!world.isAirBlock(curX + 1, i, curZ) &&
					!world.isAirBlock(curX - 1, i, curZ) &&
					!world.isAirBlock(curX, i, curZ + 1) &&
					!world.isAirBlock(curX, i, curZ - 1)) {
				return true;
			}
		}
		return false;
	}

	private boolean isLavaNear(World world, int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
		return isBlocksNear(world, minX, minY, minZ, maxX, maxY, maxZ, lavaBlocks);
	}

	private boolean isBoxWarm(World world, int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
		return isBlocksNear(world, minX, minY, minZ, maxX, maxY, maxZ, hotBlocks);
	}

	private boolean isBoxHaveWater(World world, int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
		return isBlocksNear(world, minX, minY, minZ, maxX, maxY, maxZ, coolBlocks);
	}

	private boolean isBlocksNear(World world, int minX, int minY, int minZ, int maxX, int maxY, int maxZ, List<Block> blocks) {
		if (world.checkChunksExist(minX, minY, minZ, maxX, maxY, maxZ)) {
			for (int k1 = minX; k1 < maxX; ++k1) {
				for (int l1 = minY; l1 < maxY; ++l1) {
					for (int i2 = minZ; i2 < maxZ; ++i2) {
						Block j2 = world.getBlock(k1, l1, i2);
						if (j2 == null)
							continue;

						for (Block b : blocks) {
							if (Block.isEqualTo(j2, b)) {
								return true;
							}
						}
						if (blocks.equals(hotBlocks)) {
							if (j2.isBurning(world, k1, l1, i2)) {
								return true;
							}
						}
					}
				}
			}
		} else {
			UltimateExtender.logger.error("Chunk doesn't exist! ");
		}
		return false;
	}

}
