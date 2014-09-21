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

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.config.Config;
import ru.ulmc.extender.item.ItemLockProtector.ProtectorType;
import ru.ulmc.extender.proxy.CommonProxy;

import java.util.HashMap;
import java.util.Map;

public class ItemManager {

	public static int maskId;

	protected static int itemID = 6000;
	protected static int alterItemID = 5900;
	protected static Map<String, Item> items = new HashMap<String, Item>();
	protected static CommonProxy proxy;

	public static void init(CommonProxy aProxy) {
		proxy = aProxy;
		createPlaceableItem(itemID++, BlockManager.blockBones, "skull");

		createCraftItem(itemID++, "nails");
		createCraftItem(itemID++, "diamondDust");
		createCraftItem(itemID++, "goldDust");

		createCraftItem(itemID++, "leatherStrap");
		createCraftItem(itemID++, "leatherCorset");
		createCraftItem(itemID++, "spool");
		createCraftItem(itemID++, "fabricStrap");
		createCraftItem(itemID++, "fabricRoll");
		createCraftItem(itemID++, "goldSpool");
		createCraftItem(itemID++, "diamondSpool");
		createCraftItem(itemID++, "goldFabricStrap");
		createCraftItem(itemID++, "diamondFabricStrap");
		createCraftItem(itemID++, "goldFabricRoll");
		createCraftItem(itemID++, "diamondFabricRoll");
		createCraftItem(itemID++, "chevron");
		createCraftItem(itemID++, "chevronWithGoldThread");
		createCraftItem(itemID++, "chevronWithDiamondThread");
		createCraftItem(itemID++, "goldChevronWithGoldThread");
		createCraftItem(itemID++, "goldChevronWithDiamondThread");
		createCraftItem(itemID++, "diamondChevronWithGoldThread");
		createCraftItem(itemID++, "diamondChevronWithDiamondThread");
		createCraftItem(itemID++, "medivalSymbol");
		createCraftItem(itemID++, "technoSymbol");

		createCraftItem(itemID++, "obsidianBrick");
		createCraftItem(itemID++, "obsidianAlloyBlank");
		createCraftItem(itemID++, "obsidianAlloyIngot");
		createCraftItem(itemID++, "saltCrystal");
		createCraftItem(itemID++, "cementSack");
		createCraftItem(itemID++, "cementMix");
		createCraftItem(itemID++, "porkBelly");
		createCraftItem(itemID++, "ironStripe");

		createFoodItem(itemID++, "jerkedBeef", 6, 0.6f, false);
		createFoodItem(itemID++, "jerkedPork", 6, 0.6f, false);
		createFoodItem(itemID++, "jerkedLamb", 6, 0.5f, false);
		createFoodItem(itemID++, "lambRawMeat", 4, 0.3f, true);
		createFoodItem(itemID++, "lambFried", 8, 0.7f, true);
		createFoodItem(itemID++, "lambLegFried", 8, 0.9f, true);
		createFoodItem(itemID++, "salo", 3, 0.6f, true);

		createCraftItem(itemID++, "salt");

		createCraftItem(itemID++, "ironBlank");

		createGrindStone(itemID++, 1, 0.0F, 0.0F, "woodenGrindstoneBlank");
		createGrindStone(itemID++, 2, 0.0F, 0.0F, "ironGrindstoneBlank");
		createGrindStone(itemID++, 60, 0.5F, 0.3F, "coarseGrindstone");
		createGrindStone(itemID++, 140, 0.6F, 0.5F, "enhancedGrindstone");
		createGrindStone(itemID++, 250, 0.8F, 0.8F, "diamondGrindstone");

		if (Config.tcConfig.isEnabled()) {
			createKey(itemID++, 1, 10, "ironKey");
			createKey(itemID++, 3, 6, "goldenKey");
			createKey(itemID++, 6, 25, "diamondKey");
			createKey(itemID++, 7, 30, "epicKey");

			createPicklock(itemID++, 1, 40, "ironPicklock");
			createPicklock(itemID++, 3, 30, "goldenPicklock");
			createPicklock(itemID++, 6, 80, "diamondPicklock");
			createPicklock(itemID++, 7, 95, "epicPicklock");

			createLockProbe(itemID++, 3, 40, "lockProbe");

			createLockProtector(itemID++, 1, "capsuleEmpty", ProtectorType.DAMAGE_ABSORBER);
			createLockProtector(itemID++, 20, "capsuleAbsorber", ProtectorType.DAMAGE_ABSORBER);
			createLockProtector(itemID++, 10, "capsuleFirestarter", ProtectorType.FIRESTARTER);
			createLockProtector(itemID++, 200, "capsuleLogger", ProtectorType.LOGGER);
			createLockProtector(itemID++, 200, "capsuleRedstone", ProtectorType.REDSTONE);
			createLockProtector(itemID++, 20, "capsuleShocker", ProtectorType.SHOCKER);
			createLockProtector(itemID++, 200, "capsuleSiren", ProtectorType.SIREN);
			createLockProtector(itemID++, 50, "capsuleAntipicklock", ProtectorType.ANTIPICKLOCK);
			createLockProtector(itemID++, 2, "capsuleTNT", ProtectorType.TNTLOCK);

			createThiefKnife(itemID++, 100, "thiefKnifeDiamond", Item.ToolMaterial.EMERALD);

		}

		createCraftItem(alterItemID++, "boulder");
		createCraftItem(alterItemID++, "cakeRaw");
		createCraftItem(alterItemID++, "cookieRaw");
		createCraftItem(alterItemID++, "pumpkinPieRaw");
		createCraftItem(alterItemID++, "flowerPotBlank");
		createCraftItem(alterItemID++, "pastry");
		createCraftItem(alterItemID++, "meal");
		createCraftItem(alterItemID++, "treatedLeather");
		createCraftItem(alterItemID++, "glassCharge");
		createCraftItem(alterItemID++, "ironPowder");
		createCraftItem(alterItemID++, "limestone");
		createCraftItem(alterItemID++, "lime");
		createCraftItem(alterItemID++, "limeWater");
		createCraftItem(alterItemID++, "potash");
		createCraftItem(alterItemID++, "pebbles");
		createCraftItem(alterItemID++, "resin");
		createCraftItem(alterItemID++, "rottenWeat");
		createCraftItem(alterItemID++, "ash");

		if (Config.ssConfig.isEnabled()) {
			int cottonWearRenderID = proxy.getArmorPrefix("cotton");
			int furWearRenderID = proxy.getArmorPrefix("fur");
			int apparelWearRenderID = proxy.getArmorPrefix("apparel");
			int hiddenWearRenderID = proxy.getArmorPrefix("hidden");

			createArmor(itemID++, EnumThermalMaterial.COTTON, cottonWearRenderID, 0, "cottonHat", false, true, true, false);
			createArmor(itemID++, EnumThermalMaterial.COTTON, cottonWearRenderID, 1, "cottonJacket", false, true, true, false);
			createArmor(itemID++, EnumThermalMaterial.COTTON, cottonWearRenderID, 2, "cottonPants", true, true, true, false);
			createArmor(itemID++, EnumThermalMaterial.COTTON, cottonWearRenderID, 3, "cottonBoots", false, true, true, false);

			createArmor(itemID++, EnumThermalMaterial.FUR, furWearRenderID, 0, "furHat", false, true, false, false);
			createArmor(itemID++, EnumThermalMaterial.FUR, furWearRenderID, 1, "furCoat", false, true, false, false);
			createArmor(itemID++, EnumThermalMaterial.FUR, furWearRenderID, 2, "warmPants", true, true, false, false);
			createArmor(itemID++, EnumThermalMaterial.FUR, furWearRenderID, 3, "furBoots", false, true, false, false);

			createArmor(itemID++, EnumThermalMaterial.APPAREL, apparelWearRenderID, 0, "apparelHelmet", false, true, true, true);
			createArmor(itemID++, EnumThermalMaterial.APPAREL, apparelWearRenderID, 1, "apparelVest", false, true, true, true);
			createArmor(itemID++, EnumThermalMaterial.APPAREL, apparelWearRenderID, 2, "apparelPants", true, true, true, true);
			createArmor(itemID++, EnumThermalMaterial.APPAREL, apparelWearRenderID, 3, "apparelBoots", false, true, true, true);

			createArmor(itemID++, EnumThermalMaterial.HIDDEN, hiddenWearRenderID, 0, "mask", false, true, true, false);
		}
		maskId = Item.getIdFromItem(items.get("mask"));
	}

	public static Item getItem(String name) {
		return items.get(name);
	}

	protected static void createArmor(int itemID, EnumThermalMaterial material, int renderIndex, int armorType,
	                                  String itemName, boolean isLegs, boolean itWarms, boolean itCools, boolean isLavaProtected) {
		WarmArmor item = new WarmArmor(material, renderIndex, armorType, itemName, isLegs, itWarms, itCools, isLavaProtected);
		commonRegistrationActions(item, itemName);
	}

	protected static void createPlaceableItem(int itemID, Block block, String itemName) {
		BasicPlaceableItem item = new BasicPlaceableItem(itemName, block);
		commonRegistrationActions(item, itemName);
	}

	protected static void createCraftItem(int itemID, String itemName) {
		BasicCraftItem item = new BasicCraftItem(itemName);
		commonRegistrationActions(item, itemName);
	}

	protected static void createFoodItem(int itemID, String itemName, int healAmount, float saturationModifier,
	                                     boolean isWolfFavorite) {
		BasicFoodItem item = new BasicFoodItem(itemName, healAmount, saturationModifier, isWolfFavorite);
		commonRegistrationActions(item, itemName);
	}

	protected static void createKey(int itemID, int security, int maxDamage, String itemName) {
		ItemKey item = new ItemKey(itemName, security, maxDamage);
		commonRegistrationActions(item, itemName);
	}

	protected static void createLockProtector(int itemID, int maxDamage, String itemName, ProtectorType type) {
		ItemLockProtector item = new ItemLockProtector(itemName, maxDamage, type);
		commonRegistrationActions(item, itemName);
	}

	protected static void createPicklock(int itemID, int security, int maxDamage, String itemName) {
		ItemPicklock item = new ItemPicklock(itemName, security, maxDamage);
		commonRegistrationActions(item, itemName);
	}

	protected static void createLockProbe(int itemID, int security, int maxDamage, String itemName) {
		ItemLockProbe item = new ItemLockProbe(itemName, security, maxDamage);
		commonRegistrationActions(item, itemName);
	}

	protected static void createGrindStone(int itemID, int durability, float bChance, float bPower, String itemName) {
		ItemGrind item = new ItemGrind(itemName, durability, bChance,
				bPower);
		commonRegistrationActions(item, itemName);
	}

	protected static void createThiefKnife(int itemID, int durability, String itemName, Item.ToolMaterial toolMaterial) {
		ItemThiefKnife item = new ItemThiefKnife(itemName, durability, toolMaterial);
		commonRegistrationActions(item, itemName);
	}

	protected static void commonRegistrationActions(Item item, String itemName) {
		proxy.createItem(item);
		items.put(itemName, item);
	}

	public static ItemStack getEpicItem(Class iClass) {

		ItemStack is = null;
		if (iClass == ItemPicklock.class) {
			is = new ItemStack(ItemManager.getItem("epicPicklock"));
			is.setStackDisplayName(getRandomItemName("picklock"));
		} else if (iClass == ItemKey.class) {
			is = new ItemStack(ItemManager.getItem("epicKey"));
			is.setStackDisplayName(getRandomItemName("key"));
		} else {
			UltimateExtender.logger.error("This is not supposed to happen, check ItemManager.generateEpicItem");
			return null;
		}
		ItemPicklock.setBonus(is, (float) Math.random());
		return is;
	}

	public static String getRandomItemName(String type) {
		int randomNum = (int) (Math.random() * (11));
		UltimateExtender.logger.info(UltimateExtender.loc("epic.".concat(type).concat(".name") + randomNum));
		return UltimateExtender.loc("epic.".concat(type).concat(".name") + randomNum);
	}
}