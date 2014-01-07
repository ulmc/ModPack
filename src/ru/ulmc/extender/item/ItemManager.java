package ru.ulmc.extender.item;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
import ru.ulmc.extender.ConfigurationHander;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.proxy.CommonProxy;

public class ItemManager {
	
	public static int maskId;

	protected static int itemID = 6000;
	protected static int alterItemID = 5900;
	protected static Map<String, Item> items = new HashMap<>();
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

		createKey(itemID++, 1, 10, "ironKey");
		createKey(itemID++, 3, 6, "goldenKey");
		createKey(itemID++, 6, 25, "diamondKey");
		createKey(itemID++, 7, 30, "epicKey");

		createPicklock(itemID++, 1, 40, "ironPicklock");
		createPicklock(itemID++, 3, 30, "goldenPicklock");
		createPicklock(itemID++, 6, 80, "diamondPicklock");
		createPicklock(itemID++, 7, 95, "epicPicklock");

		createGrindStone(itemID++, 1, 0.0F, 0.0F, "woodenGrindstoneBlank");
		createGrindStone(itemID++, 2, 0.0F, 0.0F, "ironGrindstoneBlank");
		createGrindStone(itemID++, 60, 0.5F, 0.3F, "coarseGrindstone");
		createGrindStone(itemID++, 140, 0.6F, 0.5F, "enhancedGrindstone");
		createGrindStone(itemID++, 250, 0.8F, 0.8F, "diamondGrindstone");

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
		
		int cottonWearRenderID = proxy.getArmorPrefix("cotton");
		int furWearRenderID = proxy.getArmorPrefix("fur");
		int apparelWearRenderID = proxy.getArmorPrefix("apparel");
		int hiddenWearRenderID = proxy.getArmorPrefix("hidden");
		
		createArmor(itemID++, EnumWarmMaterial.COTTON, cottonWearRenderID, 0, "cottonHat", false);
		createArmor(itemID++, EnumWarmMaterial.COTTON, cottonWearRenderID, 1, "cottonJacket", false);
		createArmor(itemID++, EnumWarmMaterial.COTTON, cottonWearRenderID, 2, "cottonPants", true);
		createArmor(itemID++, EnumWarmMaterial.COTTON, cottonWearRenderID, 3, "cottonBoots", false);
		
		createArmor(itemID++, EnumWarmMaterial.FUR, furWearRenderID, 0, "furHat", false);
		createArmor(itemID++, EnumWarmMaterial.FUR, furWearRenderID, 1, "furCoat", false);
		createArmor(itemID++, EnumWarmMaterial.FUR, furWearRenderID, 2, "warmPants", true);
		createArmor(itemID++, EnumWarmMaterial.FUR, furWearRenderID, 3, "furBoots", false);
		
		createArmor(itemID++, EnumWarmMaterial.APPAREL, apparelWearRenderID, 0, "apparelHelmet", false);
		createArmor(itemID++, EnumWarmMaterial.APPAREL, apparelWearRenderID, 1, "apparelVest", false);
		createArmor(itemID++, EnumWarmMaterial.APPAREL, apparelWearRenderID, 2, "apparelPants", true);
		createArmor(itemID++, EnumWarmMaterial.APPAREL, apparelWearRenderID, 3, "apparelBoots", false);
		
		createArmor(itemID++, EnumWarmMaterial.HIDDEN, hiddenWearRenderID, 0, "mask", false);
		maskId = items.get("mask").itemID;
	}

	public static Item getItem(String name) {
		return items.get(name);
	}
	
	protected static void createArmor(int itemID, EnumWarmMaterial material, int renderIndex, int armorType, String itemName, boolean isLegs) {
		WarmArmor item = new WarmArmor(ConfigurationHander.getItemID(itemName, itemID), material, renderIndex, armorType, itemName, isLegs);
		commonRegistrationActions(item, itemName);
	}
	
	protected static void createPlaceableItem(int itemID, Block block, String itemName) {
		BasicPlaceableItem item = new BasicPlaceableItem(ConfigurationHander.getItemID(itemName, itemID), itemName, block);
		commonRegistrationActions(item, itemName);
	}

	protected static void createCraftItem(int itemID, String itemName) {
		BasicCraftItem item = new BasicCraftItem(ConfigurationHander.getItemID(itemName, itemID), itemName);
		commonRegistrationActions(item, itemName);
	}

	protected static void createFoodItem(int itemID, String itemName, int healAmount, float saturationModifier,
			boolean isWolfFavorite) {
		BasicFoodItem item = new BasicFoodItem(ConfigurationHander.getItemID(itemName, itemID), itemName, healAmount,
				saturationModifier, isWolfFavorite);
		commonRegistrationActions(item, itemName);
	}

	protected static void createKey(int itemID, int security, int maxDamage, String itemName) {
		ItemKey item = new ItemKey(ConfigurationHander.getItemID(itemName, itemID), itemName, security, maxDamage);
		commonRegistrationActions(item, itemName);
	}

	protected static void createPicklock(int itemID, int security, int maxDamage, String itemName) {
		ItemPicklock item = new ItemPicklock(ConfigurationHander.getItemID(itemName, itemID), itemName, security, maxDamage);
		commonRegistrationActions(item, itemName);
	}

	protected static void createGrindStone(int itemID, int durability, float bChance, float bPower, String itemName) {
		ItemGrind item = new ItemGrind(ConfigurationHander.getItemID(itemName, itemID), itemName, durability, bChance,
				bPower);
		commonRegistrationActions(item, itemName);
	}

	protected static void commonRegistrationActions(Item item, String itemName) {
		proxy.createItem(item);
		items.put(itemName, item);
	}

}
