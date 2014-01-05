package ru.ulmc.extender.item;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.proxy.CommonProxy;

public class ItemManager {	
	
	protected static int itemID = 6000;
	protected static int alterItemID = 5900;
	protected static Map<String, Item> items = new HashMap<>();
	protected static CommonProxy proxy;
	
	public static void init(CommonProxy aProxy) {
		proxy = aProxy;
		createPlaceableItem(itemID++, BlockManager.blockBones, "skull", "�����", "Skull");
		
		createCraftItem(itemID++, "nails", "������", "Nails");
		createCraftItem(itemID++, "diamondDust", "�������� ����", "DiamondDust");
		createCraftItem(itemID++, "goldDust", "������� ����", "Gold Dust");		
		
		createCraftItem(itemID++, "leatherStrap", "������� ������", "Leather Strap");
		createCraftItem(itemID++, "leatherCorset", "������� ������", "Leather corset");
		createCraftItem(itemID++, "spool", "����� �����", "Spool");
		createCraftItem(itemID++, "fabricStrap", "������ �����", "Fabric Strap");
		createCraftItem(itemID++, "fabricRoll", "����� �����", "Fabric Roll");
		createCraftItem(itemID++, "goldSpool", "����� ������� �����", "Gold Spool");
		createCraftItem(itemID++, "diamondSpool", "����� �������� �����", "Diamond Spool");
		createCraftItem(itemID++, "goldFabricStrap", "������ ������� �����", "Gold Fabric Strap");
		createCraftItem(itemID++, "diamondFabricStrap", "������ �������� �����", "Diamond Fabric Strap");
		createCraftItem(itemID++, "goldFabricRoll", "����� ������� �����", "Gold Fabric Roll");
		createCraftItem(itemID++, "diamondFabricRoll", "����� �������� �����", "Diamond Fabric Roll");
		createCraftItem(itemID++, "chevron", "�������", "Chevron");
		createCraftItem(itemID++, "chevronWithGoldenThread", "������� � �������� �������", "Chevron With Golden Thread");
		createCraftItem(itemID++, "chevronWithDiamondThread", "������� � ��������� �������", "Chevron With Diamond Thread");
		createCraftItem(itemID++, "goldChevronWithGoldThread", "������� ������ � �������� �������", "Gold Chevron With Gold Thread");
		createCraftItem(itemID++, "goldChevronWithDiamondThread", "������� ������ � ��������� �������", "Gold Chevron With Diamond Thread");
		createCraftItem(itemID++, "diamondChevronWithGoldThread", "�������� ������ � �������� �������", "Diamond Chevron With Gold Thread");
		createCraftItem(itemID++, "diamondChevronWithDiamondThread", "�������� ������ � ��������� �������", "Diamond Chevron With Diamond Thread");		
		createCraftItem(itemID++, "medivalSymbol", "������ �������������", "Medival Symbol");
		createCraftItem(itemID++, "technoSymbol", "������ �����������", "Techno Symbol");
		
		createCraftItem(itemID++, "obsidianBrick", "������������ ������", "Obsidian Brick");
		createCraftItem(itemID++, "obsidianAlloyBlank", "��������� ������ ���������", "Obsidian Alloy Blank");
		createCraftItem(itemID++, "obsidianAlloyIngot", "������ ����������� ������", "Obsidian Alloy Ingot");
		createCraftItem(itemID++, "saltCrystal", "������� ��������", "Salt Crystal");
		createCraftItem(itemID++, "cementSack", "����� �������", "Cement Sack");
		createCraftItem(itemID++, "cementMix", "��������� �����", "Cement Mix");
		createCraftItem(itemID++, "porkBelly", "������ ���", "Pork Belly");
		createCraftItem(itemID++, "ironStripe", "������������� �������", "Iron Stripe");
				
		
		createFoodItem(itemID++, "jerkedBeef", 6, 0.6f, false, "������� ��������", "Jerked Beef");
		createFoodItem(itemID++, "jerkedPork",6, 0.6f, false, "������� �������", "Jerked Pork");
		createFoodItem(itemID++, "lambRawMeat", 4, 0.3f, true, "����� ��������", "Lamb Raw Meat");
		createFoodItem(itemID++, "lambFried", 8, 0.7f, true, "������� ��������", "Lamb Fried");
		createFoodItem(itemID++, "lambLegFried", 8, 0.9f, true, "���������� ������� ����", "Fried Lamb Leg");
		createFoodItem(itemID++, "salo", 3, 0.6f, true, "����", "Salo");
		createFoodItem(itemID++, "jerkedLamb", 6, 0.5f, false, "������� ��������", "Jerked Lamb");
		
		createCraftItem(itemID++, "salt", "����", "Salt");
		
		createKey(itemID++, 1, 10, "ironKey", "�������� ����", "Iron key");
		createKey(itemID++, 3, 6, "goldenKey", "������� ����", "Golden key");
		createKey(itemID++, 6, 25, "diamondKey", "�������� ����", "Diamond key");
		
		createPicklock(itemID++, 1, 40, "ironPicklock", "�������� �������", "Iron Picklock");
		createPicklock(itemID++, 3, 30, "goldenPicklock", "������� �������", "Golden Picklock");
		createPicklock(itemID++, 6, 80, "diamondPicklock", "�������� �������", "Diamond Picklock");
		
		
		createGrindStone(itemID++, 1, 0.0F, 0.0F, "woodenGrindstoneBlank", "���������� ������ ���������� �����", "Grindstone wooden blank");
		createGrindStone(itemID++, 2, 0.0F, 0.0F, "ironGrindstoneBlank", "�������� ������ ���������� �����", "Grindstone iron blank");
		createGrindStone(itemID++, 60, 0.5F, 0.3F, "coarseGrindstone", "������ ��������� ������", "Coarse grindstone");
		createGrindStone(itemID++, 140, 0.6F, 0.5F, "enhancedGrindstone", "���������� ��������� ������", "Enhanced grindstone");
		createGrindStone(itemID++, 250, 0.8F, 0.8F, "diamondGrindstone", "��������� �����", "Grind Diamond");
		
		
		createCraftItem(alterItemID++, "boulder", "�����", "Boulder");
		createCraftItem(alterItemID++, "cakeRaw", "�����", "Raw Cake");
		createCraftItem(alterItemID++, "cookieRaw", "�������", "Raw Cookie");
		createCraftItem(alterItemID++, "pumpkinPieRaw", "��������� �����", "Raw Pumpkin Pie");
		createCraftItem(alterItemID++, "flowerPotBlank", "����������� ��������� ������", "Clay pot blank");
		createCraftItem(alterItemID++, "pastry", "�����", "Pastry");
		createCraftItem(alterItemID++, "meal", "����", "Meal");
		createCraftItem(alterItemID++, "treatedLeather", "������������ ����", "Treated leather");
		createCraftItem(alterItemID++, "glassCharge", "���������� �����", "Glass charge");
		createCraftItem(alterItemID++, "ironPowder", "�������� �������", "Iron powder");
		createCraftItem(alterItemID++, "limestone", "���������", "Limestone");
		createCraftItem(alterItemID++, "lime", "�������", "Lime");
		createCraftItem(alterItemID++, "limeWater", "����������� ����", "Lime water");
		createCraftItem(alterItemID++, "potash", "�����", "Potash");
		createCraftItem(alterItemID++, "pebbles", "����� ������", "Pebbles");
		createCraftItem(alterItemID++, "resin", "�����", "Resin");
		createCraftItem(alterItemID++, "rottenWeat", "������ �������", "Rotten weat");
		createCraftItem(alterItemID++, "ash", "�����", "Ash"); 
	}
	
	
	
	public static Item getItemByName(String name) {
		return items.get(name);
	}



	public static void setItems(Map<String, Item> items) {
		ItemManager.items = items;
	}



	protected static void createPlaceableItem(int itemID, Block block, String itemName, String localizationRu, String localizationEn) {
		BasicPlaceableItem item = new BasicPlaceableItem(itemID, itemName, block);
		commonRegistrationActions(item, itemName, localizationRu, localizationEn);		
	}
	protected static void createCraftItem(int itemID, String itemName, String localizationRu, String localizationEn) {
		BasicCraftItem item = new BasicCraftItem(itemID, itemName);
		commonRegistrationActions(item, itemName, localizationRu, localizationEn);		
	}
	protected static void createFoodItem(int itemID, String itemName, int healAmount, float saturationModifier, boolean isWolfFavorite, String localizationRu, String localizationEn) {
		BasicFoodItem item = new BasicFoodItem(itemID, itemName, healAmount, saturationModifier, isWolfFavorite);
		commonRegistrationActions(item, itemName, localizationRu, localizationEn);		
	}
	protected static void createKey(int itemID, int security, int maxDamage, String itemName, String localizationRu, String localizationEn) {
		ItemKey item = new ItemKey(itemID, itemName, security, maxDamage);
		commonRegistrationActions(item, itemName, localizationRu, localizationEn);		
	}
	protected static void createPicklock(int itemID, int security, int maxDamage, String itemName, String localizationRu, String localizationEn) {
		ItemPicklock item = new ItemPicklock(itemID, itemName, security, maxDamage);
		commonRegistrationActions(item, itemName, localizationRu, localizationEn);			
	}
	protected static void createGrindStone(int itemID, int durability, float bChance, float bPower, String itemName, String localizationRu, String localizationEn) {
		ItemGrind item = new ItemGrind(itemID, itemName, durability, bChance, bPower);
		commonRegistrationActions(item, itemName, localizationRu, localizationEn);
					
	}
	protected static void commonRegistrationActions(Item item, String itemName, String localizationRu, String localizationEn) {
		proxy.createItem(item, localizationRu, localizationEn);
		items.put(itemName, item);	
	}

}
