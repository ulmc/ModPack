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

	protected static Map<String, Item> items = new HashMap<String, Item>();
	protected static CommonProxy proxy;

	public static void init(CommonProxy aProxy) {
		proxy = aProxy;
		createPlaceableItem(BlockManager.blockBones, "skull");

		createCraftItem("nails");
		createCraftItem("diamondDust");
		createCraftItem("goldDust");

		createCraftItem("leatherStrap");
		createCraftItem("leatherCorset");
		createCraftItem("spool");
		createCraftItem("fabricStrap");
		createCraftItem("fabricRoll");
		createCraftItem("goldSpool");
		createCraftItem("diamondSpool");
		createCraftItem("goldFabricStrap");
		createCraftItem("diamondFabricStrap");
		createCraftItem("goldFabricRoll");
		createCraftItem("diamondFabricRoll");
		createCraftItem("chevron");
		createCraftItem("chevronWithGoldThread");
		createCraftItem("chevronWithDiamondThread");
		createCraftItem("goldChevronWithGoldThread");
		createCraftItem("goldChevronWithDiamondThread");
		createCraftItem("diamondChevronWithGoldThread");
		createCraftItem("diamondChevronWithDiamondThread");
		createCraftItem("medivalSymbol");
		createCraftItem("technoSymbol");

		createCraftItem("obsidianBrick");
		createCraftItem("obsidianAlloyBlank");
		createCraftItem("obsidianAlloyIngot");
		createCraftItem("saltCrystal");
		createCraftItem("cementSack");
		createCraftItem("cementMix");
		createCraftItem("porkBelly");
		createCraftItem("ironStripe");

		createFoodItem("jerkedBeef", 6, 0.6f, false);
		createFoodItem("jerkedPork", 6, 0.6f, false);
		createFoodItem("jerkedLamb", 6, 0.5f, false);
		createFoodItem("lambRawMeat", 4, 0.3f, true);
		createFoodItem("lambFried", 8, 0.7f, true);
		createFoodItem("lambLegFried", 8, 0.9f, true);
		createFoodItem("salo", 3, 0.6f, true);

		createCraftItem("salt");

		createCraftItem("ironBlank");

		createGrindStone(1, 0.0F, 0.0F, "woodenGrindstoneBlank", ItemGrind.ID_WOODEN);
		createGrindStone(2, 0.0F, 0.0F, "ironGrindstoneBlank", ItemGrind.ID_IRON);
		createGrindStone(60, 0.5F, 0.3F, "coarseGrindstone", ItemGrind.ID_COARSE);
		createGrindStone(140, 0.6F, 0.5F, "enhancedGrindstone", ItemGrind.ID_ENHANCED);
		createGrindStone(250, 0.8F, 0.8F, "diamondGrindstone", ItemGrind.ID_DIAMOND);

		if (Config.tcConfig.isEnabled()) {
			createKey(1, 10, "ironKey");
			createKey(3, 6, "goldenKey");
			createKey(6, 25, "diamondKey");
			createKey(7, 30, "epicKey");

			createPicklock(1, 40, "ironPicklock");
			createPicklock(3, 30, "goldenPicklock");
			createPicklock(6, 80, "diamondPicklock");
			createPicklock(7, 95, "epicPicklock");

			createLockProbe(3, 40, "lockProbe");

			createLockProtector(1, "capsuleEmpty", ProtectorType.DAMAGE_ABSORBER);
			createLockProtector(20, "capsuleAbsorber", ProtectorType.DAMAGE_ABSORBER);
			createLockProtector(10, "capsuleFirestarter", ProtectorType.FIRESTARTER);
			createLockProtector(200, "capsuleLogger", ProtectorType.LOGGER);
			createLockProtector(200, "capsuleRedstone", ProtectorType.REDSTONE);
			createLockProtector(20, "capsuleShocker", ProtectorType.SHOCKER);
			createLockProtector(200, "capsuleSiren", ProtectorType.SIREN);
			createLockProtector(50, "capsuleAntipicklock", ProtectorType.ANTIPICKLOCK);
			createLockProtector(2, "capsuleTNT", ProtectorType.TNTLOCK);

			createThiefKnife(100, "thiefKnifeDiamond", Item.ToolMaterial.EMERALD);
		}

		createColoredFurnitureItem("acaciaBench", BlockManager.benchBlocksAcacia);
		createColoredFurnitureItem("birchBench", BlockManager.benchBlocksBirch);
		createColoredFurnitureItem("jungleBench", BlockManager.benchBlocksJungle);
		createColoredFurnitureItem("oakBench", BlockManager.benchBlocksOak);
		createColoredFurnitureItem("spruceBench", BlockManager.benchBlocksSpruce);
		createColoredFurnitureItem("oldOakBench", BlockManager.benchBlocksOldOak);

		createColoredFurnitureItem("acaciaChair", BlockManager.chairBlocksAcaciaColor);
		createColoredFurnitureItem("birchChair", BlockManager.chairBlocksBirchColor);
		createColoredFurnitureItem("jungleChair", BlockManager.chairBlocksJungleColor);
		createColoredFurnitureItem("oakChair", BlockManager.chairBlocksOakColor);
		createColoredFurnitureItem("spruceChair", BlockManager.chairBlocksSpruceColor);
		createColoredFurnitureItem("oldOakChair", BlockManager.chairBlocksOldOakColor);

		createWoodenItem("barTable", BlockManager.blockBarTable);
		createWoodenItem("dinnerTable", BlockManager.blockDinnerTable);
		createWoodenItem("cabinetTable", BlockManager.blockCabinetTable);

		/*createCraftItem("boulder");
		createCraftItem("cakeRaw");
		createCraftItem("cookieRaw");
		createCraftItem("pumpkinPieRaw");
		createCraftItem("flowerPotBlank");
		createCraftItem("pastry");
		createCraftItem("meal");
		createCraftItem("treatedLeather");
		createCraftItem("glassCharge");
		createCraftItem("ironPowder");
		createCraftItem("limestone");
		createCraftItem("lime");
		createCraftItem("limeWater");
		createCraftItem("potash");
		createCraftItem("pebbles");
		createCraftItem("resin");
		createCraftItem("ash");*/

		createCraftItem("rottenWeat");

		if (Config.ssConfig.isEnabled()) {
			int cottonWearRenderID = proxy.getArmorPrefix("cotton");
			int furWearRenderID = proxy.getArmorPrefix("fur");
			int apparelWearRenderID = proxy.getArmorPrefix("apparel");
			int hiddenWearRenderID = proxy.getArmorPrefix("hidden");
            int trashWearRenderID = proxy.getArmorPrefix("trash");

			createArmor(EnumThermalMaterial.COTTON, cottonWearRenderID, 0, "cottonHat", false, true, true, false);
			createArmor(EnumThermalMaterial.COTTON, cottonWearRenderID, 1, "cottonJacket", false, true, true, false);
			createArmor(EnumThermalMaterial.COTTON, cottonWearRenderID, 2, "cottonPants", true, true, true, false);
			createArmor(EnumThermalMaterial.COTTON, cottonWearRenderID, 3, "cottonBoots", false, true, true, false);

			createArmor(EnumThermalMaterial.FUR, furWearRenderID, 0, "furHat", false, true, false, false);
			createArmor(EnumThermalMaterial.FUR, furWearRenderID, 1, "furCoat", false, true, false, false);
			createArmor(EnumThermalMaterial.FUR, furWearRenderID, 2, "warmPants", true, true, false, false);
			createArmor(EnumThermalMaterial.FUR, furWearRenderID, 3, "furBoots", false, true, false, false);

			createArmor(EnumThermalMaterial.APPAREL, apparelWearRenderID, 0, "apparelHelmet", false, true, true, true);
			createArmor(EnumThermalMaterial.APPAREL, apparelWearRenderID, 1, "apparelVest", false, true, true, true);
			createArmor(EnumThermalMaterial.APPAREL, apparelWearRenderID, 2, "apparelPants", true, true, true, true);
			createArmor(EnumThermalMaterial.APPAREL, apparelWearRenderID, 3, "apparelBoots", false, true, true, true);

			createArmor(EnumThermalMaterial.HIDDEN, hiddenWearRenderID, 0, "mask", false, true, true, false);

            createArmor(EnumThermalMaterial.TRASH, trashWearRenderID, 0, "trashHat", false, true, true, false);
            createArmor(EnumThermalMaterial.TRASH, trashWearRenderID, 1, "trashVest", false, true, true, false);
            createArmor(EnumThermalMaterial.TRASH, trashWearRenderID, 2, "trashPants", true, true, true, false);
            createArmor(EnumThermalMaterial.TRASH, trashWearRenderID, 3, "trashBoots", false, true, true, false);
            createPlants();
		}
		maskId = Item.getIdFromItem(items.get("mask"));
	}

	public static Item getItem(String name) {
		return items.get(name);
	}

	protected static void createArmor(EnumThermalMaterial material, int renderIndex, int armorType,
	                                  String itemName, boolean isLegs, boolean itWarms, boolean itCools, boolean isLavaProtected) {
		WarmArmor item = new WarmArmor(material, renderIndex, armorType, itemName, isLegs, itWarms, itCools, isLavaProtected);
		commonRegistrationActions(item, itemName);
	}

	protected static void createPlaceableItem(Block block, String itemName) {
		BasicPlaceableItem item = new BasicPlaceableItem(itemName, block);
		commonRegistrationActions(item, itemName);
	}

	protected static void createCraftItem(String itemName) {
		BasicCraftItem item = new BasicCraftItem(itemName);
		commonRegistrationActions(item, itemName);
	}

	protected static void createColoredFurnitureItem(String itemName, Block block) {
		ItemColoredFurniture item = new ItemColoredFurniture(block);
		commonRegistrationActions(item, itemName);
	}

	protected static void createWoodenItem(String itemName, Block block) {
		ItemWooden item = new ItemWooden(block);
		commonRegistrationActions(item, itemName);
	}

	protected static void createFoodItem(String itemName, int healAmount, float saturationModifier,
	                                     boolean isWolfFavorite) {
		BasicFoodItem item = new BasicFoodItem(itemName, healAmount, saturationModifier, isWolfFavorite);
		commonRegistrationActions(item, itemName);
	}

    protected static void createPlants() {
        BarleySeeds item = new BarleySeeds("barleySeeds", BlockManager.blockBarley);
        BlockManager.blockBarley.setItem(item);
        commonRegistrationActions(item, "barleySeeds");
    }

    protected static void createKey(int security, int maxDamage, String itemName) {
		ItemKey item = new ItemKey(itemName, security, maxDamage);
		commonRegistrationActions(item, itemName);
	}

	protected static void createLockProtector(int maxDamage, String itemName, ProtectorType type) {
		ItemLockProtector item = new ItemLockProtector(itemName, maxDamage, type);
		commonRegistrationActions(item, itemName);
	}

	protected static void createPicklock(int security, int maxDamage, String itemName) {
		ItemPicklock item = new ItemPicklock(itemName, security, maxDamage);
		commonRegistrationActions(item, itemName);
	}

	protected static void createLockProbe(int security, int maxDamage, String itemName) {
		ItemLockProbe item = new ItemLockProbe(itemName, security, maxDamage);
		commonRegistrationActions(item, itemName);
	}

	protected static void createGrindStone(int durability, float bChance, float bPower, String itemName, int type) {
		ItemGrind item = new ItemGrind(itemName, durability, bChance, bPower, type);
		commonRegistrationActions(item, itemName);
	}

	protected static void createThiefKnife(int durability, String itemName, Item.ToolMaterial toolMaterial) {
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
