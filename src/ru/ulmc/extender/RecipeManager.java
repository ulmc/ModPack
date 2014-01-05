package ru.ulmc.extender;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.item.ItemManager;
import ru.ulmc.extender.proxy.CommonProxy;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManager {

	public static void init(CommonProxy proxy) {
		/*GameRegistry.addRecipe(new ItemStack(blockReinforcedConcrete, 1), "xxx", "yyy", "xxx", 'x', Block.fenceIron, 'y',
				itemCementSack);*/
		/*
		GameRegistry.addRecipe(new ItemStack(ItemManager.getItemByName("nails"), 4),
								"x",
								'x', 
								Item.ingotIron);
		*/
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("ironKey"), 1), new Object[] { Item.ingotIron });
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("goldenKey"), 1), new Object[] { Item.ingotGold, ItemManager.getItemByName("ironKey") });
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("diamondKey"), 1), new Object[] { Item.diamond, ItemManager.getItemByName("goldenKey") });
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("leatherStrap"), 4), Item.leather);
		
		GameRegistry.addRecipe(new ItemStack(ItemManager.getItemByName("leatherCorset"), 1),
				"x x",
				"xyx",
				"xyx",
				'x', ItemManager.getItemByName("leatherStrap"),
				'y', Item.silk);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("spool"), 1), new Object[] { Item.silk, Item.silk, Item.silk });
		
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("fabricStrap"), 1), 
										new Object[] { 
												ItemManager.getItemByName("spool"), 
												ItemManager.getItemByName("spool"), 
												ItemManager.getItemByName("spool") 
										});
		
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("fabricRoll"), 1),
										new Object[] { 
											ItemManager.getItemByName("fabricStrap"),
											ItemManager.getItemByName("fabricStrap"), 
											ItemManager.getItemByName("fabricStrap"), 
											ItemManager.getItemByName("fabricStrap"), 
											ItemManager.getItemByName("fabricStrap"), 
											ItemManager.getItemByName("fabricStrap") });
		
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("diamondDust"), 2), new Object[] { Item.diamond });
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("goldDust"), 4), new Object[] { Item.ingotGold, Item.ingotGold });
		
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("obsidianAlloyBlank"), 1),
										new Object[] { 
											Item.ingotIron,
											ItemManager.getItemByName("obsidianBrick") });
		
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("obsidianBrick"), 2), new Object[] { Block.obsidian });
		
		
		// Соление/вяление		
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("jerkedBeef"), 1), new Object[] { Item.beefRaw, ItemManager.getItemByName("salt") });
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("jerkedPork"), 1), new Object[] { Item.porkRaw, ItemManager.getItemByName("salt") });
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("jerkedLamb"), 1), 
										new Object[] { 
											ItemManager.getItemByName("lambRawMeat"), 
											ItemManager.getItemByName("salt") 
										});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("salo"), 1), 
										new Object[] { 
											ItemManager.getItemByName("porkBelly"), 
											ItemManager.getItemByName("salt") 
										});
		
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.getItemByName("salt"), 4), new Object[] { ItemManager.getItemByName("saltCrystal") });
		
		GameRegistry.addSmelting(ItemManager.getItemByName("obsidianAlloyBlank").itemID, new ItemStack(ItemManager.getItemByName("obsidianAlloyIngot"), 1), 1);
		
		GameRegistry.addSmelting(ItemManager.getItemByName("lambRawMeat").itemID, new ItemStack(ItemManager.getItemByName("lambFried"), 1), 1);
		GameRegistry.addSmelting(Item.bucketWater.itemID, new ItemStack(ItemManager.getItemByName("salt"), 8), 0);
		
		/*
		// marble and other simple blocks
		GameRegistry.addRecipe(new ItemStack(itemCementMix, 1), "xkx", "kzk", "xkx", 'k', new ItemStack(Item.dyePowder, 3,
				15), 'z', Item.bucketWater, 'x', Block.sand);

		GameRegistry.addRecipe(new ItemStack(itemIronStripe, 6), "xxx", 'x', Item.ingotIron);
		// переплавка
		
		GameRegistry.addSmelting(itemCementMix.shiftedIndex, new ItemStack(itemCementSack, 1), 0);
		GameRegistry.addSmelting(itemObsidianAlloyBlank.shiftedIndex, new ItemStack(itemObsidianAlloyIngot, 1), 0);
		// Крафт фурнитуры
		GameRegistry.addRecipe(new ItemStack(itemWoodChair, 1), "  x", "xxx", "xyx", 'x', itemWoodPlank, 'y', itemNails);
		GameRegistry.addRecipe(new ItemStack(itemWhiteCottonChair, 1), " zx", "xxx", "xyx", 'x', itemWoodPlank, 'y',
				itemNails, 'z', new ItemStack(Block.cloth, 1, 0));
		GameRegistry.addRecipe(new ItemStack(itemBlueCottonChair, 1), " zx", "xxx", "xyx", 'x', itemWoodPlank, 'y',
				itemNails, 'z', new ItemStack(Block.cloth, 1, 11));
		GameRegistry.addRecipe(new ItemStack(itemRedCottonChair, 1), " zx", "xxx", "xyx", 'x', itemWoodPlank, 'y',
				itemNails, 'z', new ItemStack(Block.cloth, 1, 14));
		GameRegistry.addRecipe(new ItemStack(itemBlackCottonChair, 1), " zx", "xxx", "xyx", 'x', itemWoodPlank, 'y',
				itemNails, 'z', new ItemStack(Block.cloth, 1, 15));
		GameRegistry.addRecipe(new ItemStack(itemLeatherChair, 1), " zx", "xxx", "xyx", 'x', itemWoodPlank, 'y', itemNails,
				'z', Item.leather);

		GameRegistry.addShapelessRecipe(new ItemStack(itemGoldSpool, 1), new Object[] { itemGoldDust, itemSpool });
		GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondSpool, 1), new Object[] { itemDiamondDust, itemSpool });

		GameRegistry.addShapelessRecipe(new ItemStack(itemGoldFabricStrap, 1), new Object[] { itemGoldSpool, itemGoldSpool,
				itemGoldSpool });
		GameRegistry.addShapelessRecipe(new ItemStack(itemGoldFabricRoll, 1), new Object[] { itemGoldFabricStrap,
				itemGoldFabricStrap, itemGoldFabricStrap, itemGoldFabricStrap, itemGoldFabricStrap, itemGoldFabricStrap });

		GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondFabricStrap, 1), new Object[] { itemDiamondSpool,
				itemDiamondSpool, itemDiamondSpool });
		GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondFabricRoll, 1), new Object[] { itemDiamondFabricStrap,
				itemDiamondFabricStrap, itemDiamondFabricStrap, itemDiamondFabricStrap, itemDiamondFabricStrap,
				itemDiamondFabricStrap });

		GameRegistry
				.addShapelessRecipe(new ItemStack(itemChevron, 1), new Object[] { itemSpool, itemFabricRoll, itemSpool });
		GameRegistry.addShapelessRecipe(new ItemStack(itemChevronWithGoldThread, 1), new Object[] { itemGoldSpool,
				itemFabricRoll, itemGoldSpool });
		GameRegistry.addShapelessRecipe(new ItemStack(itemChevronWithDiamondThread, 1), new Object[] { itemDiamondDust,
				itemFabricRoll, itemDiamondDust });
		GameRegistry.addShapelessRecipe(new ItemStack(itemGoldChevronWithGoldThread, 1), new Object[] { itemGoldSpool,
				itemGoldFabricRoll, itemGoldSpool });
		GameRegistry.addShapelessRecipe(new ItemStack(itemGoldChevronWithDiamondThread, 1), new Object[] { itemDiamondSpool,
				itemGoldFabricRoll, itemDiamondSpool });
		GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondChevronWithDiamondThread, 1), new Object[] {
				itemDiamondSpool, itemDiamondFabricRoll, itemDiamondSpool });
		GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondChevronWithGoldThread, 1), new Object[] { itemGoldSpool,
				itemDiamondFabricRoll, itemGoldSpool });

		GameRegistry.addShapelessRecipe(new ItemStack(itemMedivalSymbol, 1), new Object[] { itemFabricStrap, itemSpool,
				new ItemStack(Item.dyePowder, 1, 11) });
		GameRegistry.addShapelessRecipe(new ItemStack(itemTechnoSymbol, 1), new Object[] { itemFabricStrap, itemSpool,
				new ItemStack(Item.dyePowder, 1, 1) });

		// крафт нейтральных флагов
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 0), "xxx", "rsr", "p p", 'x', Item.stick, 's', itemChevron, 'p',
				itemSpool, 'r', itemFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 1), "xxx", "rsr", "p p", 'x', Item.stick, 's', itemChevron, 'p',
				itemGoldSpool, 'r', itemFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 2), "xxx", "rsr", "p p", 'x', Item.stick, 's', itemChevron, 'p',
				itemGoldSpool, 'r', itemGoldFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 3), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				itemChevronWithGoldThread, 'p', itemSpool, 'r', itemFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 4), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				itemChevronWithGoldThread, 'p', itemGoldSpool, 'r', itemFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 5), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				itemChevronWithGoldThread, 'p', itemSpool, 'r', itemGoldFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 6), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				itemGoldChevronWithGoldThread, 'p', itemSpool, 'r', itemFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 7), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				itemGoldChevronWithGoldThread, 'p', itemGoldSpool, 'r', itemFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 8), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				itemGoldChevronWithGoldThread, 'p', itemSpool, 'r', itemGoldFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 9), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				itemGoldChevronWithGoldThread, 'p', itemGoldSpool, 'r', itemGoldFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 10), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				itemGoldChevronWithDiamondThread, 'p', itemSpool, 'r', itemFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 11), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				itemGoldChevronWithDiamondThread, 'p', itemGoldSpool, 'r', itemFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 12), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				itemGoldChevronWithDiamondThread, 'p', itemSpool, 'r', itemGoldFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 13), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				itemGoldChevronWithDiamondThread, 'p', itemGoldSpool, 'r', itemGoldFabricRoll);

		// консерваторские флаги
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 0), "xxx", "rsr", "pyp", 'x', Item.stick, 's', itemChevron,
				'p', itemSpool, 'r', itemFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 1), "xxx", "rsr", "pyp", 'x', Item.stick, 's', itemChevron,
				'p', itemDiamondSpool, 'r', itemFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 2), "xxx", "rsr", "pyp", 'x', Item.stick, 's', itemChevron,
				'p', itemDiamondSpool, 'r', itemDiamondFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 3), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemChevronWithDiamondThread, 'p', itemSpool, 'r', itemFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 4), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemChevronWithDiamondThread, 'p', itemDiamondSpool, 'r', itemFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 5), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemChevronWithDiamondThread, 'p', itemSpool, 'r', itemDiamondFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 6), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithGoldThread, 'p', itemSpool, 'r', itemFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 7), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithGoldThread, 'p', itemDiamondSpool, 'r', itemFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 8), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithGoldThread, 'p', itemSpool, 'r', itemDiamondFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 9), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithGoldThread, 'p', itemDiamondSpool, 'r', itemDiamondFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 10), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithDiamondThread, 'p', itemSpool, 'r', itemFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 11), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithDiamondThread, 'p', itemDiamondSpool, 'r', itemFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 12), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithDiamondThread, 'p', itemSpool, 'r', itemDiamondFabricRoll, 'y', itemMedivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 13), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithDiamondThread, 'p', itemDiamondSpool, 'r', itemDiamondFabricRoll, 'y',
				itemMedivalSymbol);
		// Флаги технократов
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 0), "xxx", "rsr", "pyp", 'x', Item.stick, 's', itemChevron,
				'p', itemSpool, 'r', itemFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 1), "xxx", "rsr", "pyp", 'x', Item.stick, 's', itemChevron,
				'p', itemDiamondSpool, 'r', itemFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 2), "xxx", "rsr", "pyp", 'x', Item.stick, 's', itemChevron,
				'p', itemDiamondSpool, 'r', itemDiamondFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 3), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemChevronWithDiamondThread, 'p', itemSpool, 'r', itemFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 4), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemChevronWithDiamondThread, 'p', itemDiamondSpool, 'r', itemFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 5), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemChevronWithDiamondThread, 'p', itemSpool, 'r', itemDiamondFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 6), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithGoldThread, 'p', itemSpool, 'r', itemFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 7), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithGoldThread, 'p', itemDiamondSpool, 'r', itemFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 8), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithGoldThread, 'p', itemSpool, 'r', itemDiamondFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 9), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithGoldThread, 'p', itemDiamondSpool, 'r', itemDiamondFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 10), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithDiamondThread, 'p', itemSpool, 'r', itemFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 11), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithDiamondThread, 'p', itemDiamondSpool, 'r', itemFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 12), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithDiamondThread, 'p', itemSpool, 'r', itemDiamondFabricRoll, 'y', itemTechnoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 13), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				itemDiamondChevronWithDiamondThread, 'p', itemDiamondSpool, 'r', itemDiamondFabricRoll, 'y',
				itemTechnoSymbol);
				
		*/
	}

}
