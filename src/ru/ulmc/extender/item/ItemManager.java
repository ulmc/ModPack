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
		createPlaceableItem(itemID++, BlockManager.blockBones, "skull", "Череп", "Skull");
		
		createCraftItem(itemID++, "nails", "Гвозди", "Nails");
		createCraftItem(itemID++, "diamondDust", "Алмазная пыль", "DiamondDust");
		createCraftItem(itemID++, "goldDust", "Золотая пыль", "Gold Dust");		
		
		createCraftItem(itemID++, "leatherStrap", "Кожаный лоскут", "Leather Strap");
		createCraftItem(itemID++, "leatherCorset", "Кожаный корсет", "Leather corset");
		createCraftItem(itemID++, "spool", "Моток ниток", "Spool");
		createCraftItem(itemID++, "fabricStrap", "Лоскут ткани", "Fabric Strap");
		createCraftItem(itemID++, "fabricRoll", "Рулон ткани", "Fabric Roll");
		createCraftItem(itemID++, "goldSpool", "Моток золотых ниток", "Gold Spool");
		createCraftItem(itemID++, "diamondSpool", "Моток алмазных ниток", "Diamond Spool");
		createCraftItem(itemID++, "goldFabricStrap", "Лоскут золотой ткани", "Gold Fabric Strap");
		createCraftItem(itemID++, "diamondFabricStrap", "Лоскут алмазной ткани", "Diamond Fabric Strap");
		createCraftItem(itemID++, "goldFabricRoll", "Рулон золотой ткани", "Gold Fabric Roll");
		createCraftItem(itemID++, "diamondFabricRoll", "Рулон алмазной ткани", "Diamond Fabric Roll");
		createCraftItem(itemID++, "chevron", "Нашивка", "Chevron");
		createCraftItem(itemID++, "chevronWithGoldenThread", "Нашивка с золотыми нитками", "Chevron With Golden Thread");
		createCraftItem(itemID++, "chevronWithDiamondThread", "Нашивка с алмазными нитками", "Chevron With Diamond Thread");
		createCraftItem(itemID++, "goldChevronWithGoldThread", "Золотой шеврон с золотыми нитками", "Gold Chevron With Gold Thread");
		createCraftItem(itemID++, "goldChevronWithDiamondThread", "Золотой шеврон с алмазными нитками", "Gold Chevron With Diamond Thread");
		createCraftItem(itemID++, "diamondChevronWithGoldThread", "Алмазный шеврон с золотыми нитками", "Diamond Chevron With Gold Thread");
		createCraftItem(itemID++, "diamondChevronWithDiamondThread", "Алмазный шеврон с алмазными нитками", "Diamond Chevron With Diamond Thread");		
		createCraftItem(itemID++, "medivalSymbol", "Символ Консерваторов", "Medival Symbol");
		createCraftItem(itemID++, "technoSymbol", "Символ Технократов", "Techno Symbol");
		
		createCraftItem(itemID++, "obsidianBrick", "Обсидиановый кирпич", "Obsidian Brick");
		createCraftItem(itemID++, "obsidianAlloyBlank", "Заготовка сплава обсидиана", "Obsidian Alloy Blank");
		createCraftItem(itemID++, "obsidianAlloyIngot", "Слиток обсидианого сплава", "Obsidian Alloy Ingot");
		createCraftItem(itemID++, "saltCrystal", "Солевой кристалл", "Salt Crystal");
		createCraftItem(itemID++, "cementSack", "Мешок цемента", "Cement Sack");
		createCraftItem(itemID++, "cementMix", "Цементная смесь", "Cement Mix");
		createCraftItem(itemID++, "porkBelly", "Свиной жир", "Pork Belly");
		createCraftItem(itemID++, "ironStripe", "Металлическая полоска", "Iron Stripe");
				
		
		createFoodItem(itemID++, "jerkedBeef", 6, 0.6f, false, "Вяленая говядина", "Jerked Beef");
		createFoodItem(itemID++, "jerkedPork",6, 0.6f, false, "Вяленая свинина", "Jerked Pork");
		createFoodItem(itemID++, "lambRawMeat", 4, 0.3f, true, "Сырая баранина", "Lamb Raw Meat");
		createFoodItem(itemID++, "lambFried", 8, 0.7f, true, "Жареная баранина", "Lamb Fried");
		createFoodItem(itemID++, "lambLegFried", 8, 0.9f, true, "Зажаренная баранья нога", "Fried Lamb Leg");
		createFoodItem(itemID++, "salo", 3, 0.6f, true, "Сало", "Salo");
		createFoodItem(itemID++, "jerkedLamb", 6, 0.5f, false, "Вяленая баранина", "Jerked Lamb");
		
		createCraftItem(itemID++, "salt", "Соль", "Salt");
		
		createKey(itemID++, 1, 10, "ironKey", "Железный ключ", "Iron key");
		createKey(itemID++, 3, 6, "goldenKey", "Золотой ключ", "Golden key");
		createKey(itemID++, 6, 25, "diamondKey", "Алмазный ключ", "Diamond key");
		
		createPicklock(itemID++, 1, 40, "ironPicklock", "Железная отмычка", "Iron Picklock");
		createPicklock(itemID++, 3, 30, "goldenPicklock", "Золотая отмычка", "Golden Picklock");
		createPicklock(itemID++, 6, 80, "diamondPicklock", "Алмазная отмычка", "Diamond Picklock");
		
		
		createGrindStone(itemID++, 1, 0.0F, 0.0F, "woodenGrindstoneBlank", "Деревянная основа точильного камня", "Grindstone wooden blank");
		createGrindStone(itemID++, 2, 0.0F, 0.0F, "ironGrindstoneBlank", "Железная основа точильного камня", "Grindstone iron blank");
		createGrindStone(itemID++, 60, 0.5F, 0.3F, "coarseGrindstone", "Грубый точильный камень", "Coarse grindstone");
		createGrindStone(itemID++, 140, 0.6F, 0.5F, "enhancedGrindstone", "Улучшенный точильный камень", "Enhanced grindstone");
		createGrindStone(itemID++, 250, 0.8F, 0.8F, "diamondGrindstone", "Точильный алмаз", "Grind Diamond");
		
		
		createCraftItem(alterItemID++, "boulder", "Валун", "Boulder");
		createCraftItem(alterItemID++, "cakeRaw", "Пирог", "Raw Cake");
		createCraftItem(alterItemID++, "cookieRaw", "Печенье", "Raw Cookie");
		createCraftItem(alterItemID++, "pumpkinPieRaw", "Тыквенный пирог", "Raw Pumpkin Pie");
		createCraftItem(alterItemID++, "flowerPotBlank", "Необожжённый цветочный горшок", "Clay pot blank");
		createCraftItem(alterItemID++, "pastry", "Тесто", "Pastry");
		createCraftItem(alterItemID++, "meal", "Мука", "Meal");
		createCraftItem(alterItemID++, "treatedLeather", "Обработанная кожа", "Treated leather");
		createCraftItem(alterItemID++, "glassCharge", "Стеклянная шихта", "Glass charge");
		createCraftItem(alterItemID++, "ironPowder", "Железный порошок", "Iron powder");
		createCraftItem(alterItemID++, "limestone", "Известняк", "Limestone");
		createCraftItem(alterItemID++, "lime", "Известь", "Lime");
		createCraftItem(alterItemID++, "limeWater", "Известковая вода", "Lime water");
		createCraftItem(alterItemID++, "potash", "Поташ", "Potash");
		createCraftItem(alterItemID++, "pebbles", "Груда камней", "Pebbles");
		createCraftItem(alterItemID++, "resin", "Смола", "Resin");
		createCraftItem(alterItemID++, "rottenWeat", "Гнилая пшеница", "Rotten weat");
		createCraftItem(alterItemID++, "ash", "Пепел", "Ash"); 
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
