package ru.ulmc.extender.tickhandler;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.item.IWarmArmor;
import ru.ulmc.extender.util.UDamageSource;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class WarmTickSheduler implements IScheduledTickHandler {

	private int tickStep = 200;
	private int underGroundPosition = 52;
	private float underGroundBonus = 0.1f;
	private float defaultArmorWarmness = 0.5f;
	private float inWaterPenalty = 0.5f;
	private float nightPenalty = 0.2f;
	private float stormPenalty = 0.3f;
	private float rainPenalty = 0.15f;
	private float torchBonus = 0.2f;
	private String handlerLabel = "ulmc Wintermod SheduledHandler";
	private EnumSet<TickType> tick = EnumSet.of(TickType.PLAYER);
	private Map<BiomeGenBase, Float> biomeToCold = new HashMap<>();
	private Map<BiomeGenBase, Float> biomeToHot = new HashMap<>();

	public WarmTickSheduler() {
		super();
		// Чем больше, тем холоднее
		biomeToCold.put(BiomeGenBase.frozenOcean, 1.0f);
		biomeToCold.put(BiomeGenBase.frozenRiver, 0.9f);
		biomeToCold.put(BiomeGenBase.icePlains, 0.8f);
		biomeToCold.put(BiomeGenBase.iceMountains, 1.2f);
		biomeToCold.put(BiomeGenBase.taigaHills, 0.7f);
		biomeToCold.put(BiomeGenBase.taiga, 0.7f);
		// Чем меньше, тем жарче
		biomeToHot.put(BiomeGenBase.hell, 0.4f);
		biomeToHot.put(BiomeGenBase.desert, 0.4f);
		biomeToHot.put(BiomeGenBase.desertHills, 0.4f);
		biomeToHot.put(BiomeGenBase.jungle, 0.5f);
		biomeToHot.put(BiomeGenBase.jungleHills, 0.5f);
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if (type.equals(tick)) {
			doTheWork(tickData);
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}

	private void doTheWork(Object... tickData) {
		if (tickData[0] instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) tickData[0];

			if (player.isBurning()) {
				return;
			}

			World world = player.worldObj;
			if (!world.isRemote && player != null && !player.capabilities.isCreativeMode) {
				BiomeGenBase biome = world.getBiomeGenForCoords((int) player.posX, (int) player.posZ);

				Float coldStrength = biomeToCold.get(biome);
				float warmnessDelta;
				//UltimateExtender.logger.info("biome:" + biome.biomeName);
				if (coldStrength != null && coldStrength > 0.0f) {
					if (player.isInWater()) {
						coldStrength += inWaterPenalty;
					}

					
					if (player.posY < underGroundPosition || haveRoofOrSo(player, world)) {
						coldStrength -= underGroundBonus;
					} else {
						if (world.getWorldTime() > 13500 && world.getWorldTime() < 22220) {
							coldStrength += nightPenalty;
						}
						if (world.isThundering()) {
							coldStrength += stormPenalty;
						} else if (world.isRaining()) {
							coldStrength += rainPenalty;
						}
					}
					if (player.getCurrentEquippedItem() != null
							&& (player.getCurrentEquippedItem().itemID == Item.bucketLava.itemID || player
									.getCurrentEquippedItem().itemID == Block.torchWood.blockID)) {
						coldStrength -= torchBonus;
					}
					warmnessDelta  = getWarmness(player, coldStrength, 0);
					warmnessDelta += getWarmness(player, coldStrength, 1);
					warmnessDelta += getWarmness(player, coldStrength, 2);
					warmnessDelta += getWarmness(player, coldStrength, 3);
					if (warmnessDelta < 0) {
						//UltimateExtender.logger.info("You are cold! =( " + warmnessDelta);
						AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(
								player.posX - 5.0D, player.posY - 4.0D, player.posZ - 5.0D, 
								player.posX + 5.0D, player.posY + 3.0D, player.posZ + 5.0D);
						boolean noWarmNear = !isBoundingBoxBurning(aabb, world);
						
						//UltimateExtender.logger.info("noWarmNear: " + noWarmNear);
						
						if (noWarmNear) {
							player.attackEntityFrom(UDamageSource.cold, -warmnessDelta);
						}
					}
				} else {
					Float hotStrength = biomeToHot.get(biome);
					if (hotStrength != null && hotStrength > 0.0f) {
						if (player.isInWater()) {
							hotStrength += inWaterPenalty;
						}
						if (world.isThundering()) {
							hotStrength += stormPenalty;
						} else if (world.isRaining()) {
							hotStrength += rainPenalty;
						}
						if (world.getWorldTime() > 13500 && world.getWorldTime() < 22220) {
							hotStrength += nightPenalty;
						}

						warmnessDelta = getWarmness(player, hotStrength, 0);
						warmnessDelta += getWarmness(player, hotStrength, 1);
						warmnessDelta += getWarmness(player, hotStrength, 2);
						warmnessDelta += getWarmness(player, hotStrength, 3);
						if (warmnessDelta > 0) {
							//UltimateExtender.logger.info("Heat stroke! Boom! " + warmnessDelta);
							player.attackEntityFrom(UDamageSource.hot, warmnessDelta);
						}
					}
				}

			}
		} else {
			UltimateExtender.logger.log(Level.WARNING, "WinterTickSheduler.doTheWork() recived not expected argument!");
		}
	}

	private float getWarmness(EntityPlayer player, float cold, int armorType) {
		ItemStack armor = player.getCurrentArmor(armorType);
		if (armor != null && armor.getItem() instanceof IWarmArmor) {
			return ((IWarmArmor) armor.getItem()).getWarmLevel() - cold;
		} else if (armor != null) {
			return defaultArmorWarmness - cold;
		} else {
			return -cold;
		}
	}

	private boolean haveRoofOrSo(EntityPlayer player, World world) {

		int currentX = MathHelper.floor_double(player.posX);
		int currentZ = MathHelper.floor_double(player.posX);

		int minY = MathHelper.floor_double(player.posY);
		int maxY = MathHelper.floor_double(player.posY + 5.0D);

		/* *
		 * * * *
		 * *
		 */
		for (int i = minY; minY < maxY; minY++) {
			if (!world.isAirBlock(currentX, i, currentZ) && !world.isAirBlock(currentX + 2, i, currentZ)
					&& !world.isAirBlock(currentX - 2, i, currentZ) && !world.isAirBlock(currentX, i, currentZ + 2)
					&& !world.isAirBlock(currentX, i, currentZ - 2)) {
				return true;
			}

		}

		return false;
	}

	/**
	 * Just like World's method, but can insert custom warm bloc id's
	 * 
	 * @param par1AxisAlignedBB
	 * @param world
	 * @return
	 */
	private boolean isBoundingBoxBurning(AxisAlignedBB par1AxisAlignedBB, World world) {
		int i = MathHelper.floor_double(par1AxisAlignedBB.minX);
		int j = MathHelper.floor_double(par1AxisAlignedBB.maxX + 1.0D);
		int k = MathHelper.floor_double(par1AxisAlignedBB.minY);
		int l = MathHelper.floor_double(par1AxisAlignedBB.maxY + 1.0D);
		int i1 = MathHelper.floor_double(par1AxisAlignedBB.minZ);
		int j1 = MathHelper.floor_double(par1AxisAlignedBB.maxZ + 1.0D);

		if (world.checkChunksExist(i, k, i1, j, l, j1)) {
			for (int k1 = i; k1 < j; ++k1) {
				for (int l1 = k; l1 < l; ++l1) {
					for (int i2 = i1; i2 < j1; ++i2) {
						int j2 = world.getBlockId(k1, l1, i2);

						if (j2 == Block.fire.blockID || j2 == Block.lavaMoving.blockID || j2 == Block.lavaStill.blockID) {
							return true;
						} else {
							Block block = Block.blocksList[j2];
							if (block != null && block.isBlockBurning(world, k1, l1, i2)) {
								return true;
							}
						}
					}
				}
			}
		} else {
			UltimateExtender.logger.log(Level.WARNING, "Chunk doesn't exist! ");
		}

		return false;
	}

	@Override
	public EnumSet<TickType> ticks() {
		return tick;
	}

	@Override
	public String getLabel() {

		return handlerLabel;
	}

	@Override
	public int nextTickSpacing() {
		return tickStep;
	}

}
