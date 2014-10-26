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

package ru.ulmc.extender;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.config.Config;
import ru.ulmc.extender.item.ItemManager;
import ru.ulmc.extender.proxy.CommonProxy;

public class RecipeManager {

	private static void addShapeless(Item item, int quantity, Object... combination) {
		GameRegistry.addShapelessRecipe(new ItemStack(item, quantity), combination);
	}

	private static void addSmelting(Item item, int quantity, float xp, Item inputitem) {
		GameRegistry.addSmelting(inputitem, new ItemStack(item, quantity), xp);
	}

	private static void addRecipe(Item item, int quantity, Object... objs) {
		GameRegistry.addRecipe(new ItemStack(item, quantity), objs);
	}

	private static void addRecipe(Item item, int quantity, int meta, Object... objs) {
		GameRegistry.addRecipe(new ItemStack(item, quantity, meta), objs);
	}

	public static void init(CommonProxy proxy) {
		/*GameRegistry.addRecipe(new ItemStack(blockReinforcedConcrete, 1), "xxx", "yyy", "xxx", 'x', Block.fenceIron, 'y',
				itemCementSack);*/
		/*
		
		*/

		Item diamondDust = ItemManager.getItem("diamondDust");
		Item goldDust = ItemManager.getItem("goldDust");

		Item leatherStrap = ItemManager.getItem("leatherStrap");
		Item leatherCorset = ItemManager.getItem("leatherCorset");
		Item spool = ItemManager.getItem("spool");
		Item goldSpool = ItemManager.getItem("goldSpool");
		Item fabricStrap = ItemManager.getItem("fabricStrap");
		Item fabricRoll = ItemManager.getItem("fabricRoll");
		Item obsidianAlloyBlank = ItemManager.getItem("obsidianAlloyBlank");
		Item obsidianBrick = ItemManager.getItem("obsidianBrick");
		Item obsidianAlloyIngot = ItemManager.getItem("obsidianAlloyIngot");
		Item lambFried = ItemManager.getItem("lambFried");

		Item diamondSpool = ItemManager.getItem("diamondSpool");
		Item goldFabricStrap = ItemManager.getItem("goldFabricStrap");
		Item goldFabricRoll = ItemManager.getItem("goldFabricRoll");
		Item diamondFabricStrap = ItemManager.getItem("diamondFabricStrap");
		Item diamondFabricRoll = ItemManager.getItem("diamondFabricRoll");
		Item chevron = ItemManager.getItem("chevron");
		Item chevronWithGoldThread = ItemManager.getItem("chevronWithGoldThread");
		Item chevronWithDiamondThread = ItemManager.getItem("chevronWithDiamondThread");
		Item goldChevronWithGoldThread = ItemManager.getItem("goldChevronWithGoldThread");
		Item goldChevronWithDiamondThread = ItemManager.getItem("goldChevronWithDiamondThread");
		Item diamondChevronWithDiamondThread = ItemManager.getItem("diamondChevronWithDiamondThread");
		Item diamondChevronWithGoldThread = ItemManager.getItem("diamondChevronWithGoldThread");
		Item medivalSymbol = ItemManager.getItem("medivalSymbol");
		Item technoSymbol = ItemManager.getItem("technoSymbol");

		Item jerkedBeef = ItemManager.getItem("jerkedBeef");
		Item jerkedPork = ItemManager.getItem("jerkedPork");
		Item jerkedLamb = ItemManager.getItem("jerkedLamb");
		Item salt = ItemManager.getItem("salt");
		Item lambRawMeat = ItemManager.getItem("lambRawMeat");
		Item porkBelly = ItemManager.getItem("porkBelly");
		Item salo = ItemManager.getItem("salo");
		Item saltCrystal = ItemManager.getItem("saltCrystal");

		Item cementMix = ItemManager.getItem("cementMix");
		Item cementSack = ItemManager.getItem("cementSack");

		Item woodenGrindstoneBlank = ItemManager.getItem("woodenGrindstoneBlank");
		Item ironGrindstoneBlank = ItemManager.getItem("ironGrindstoneBlank");
		Item coarseGrindstone = ItemManager.getItem("coarseGrindstone");
		Item enhancedGrindstone = ItemManager.getItem("enhancedGrindstone");
		Item diamondGrindstone = ItemManager.getItem("diamondGrindstone");
        Item woolfell = ItemManager.getItem("woolfell");

        //броня
        Item diamondFurHat = ItemManager.getItem("diamondFurHat");
        Item diamondFurCoat = ItemManager.getItem("diamondFurCoat");
        Item diamondFurPants = ItemManager.getItem("diamondFurPants");
        Item diamondFurBoots = ItemManager.getItem("diamondFurBoots");

        Item ironFurHat = ItemManager.getItem("ironFurHat");
        Item ironFurCoat = ItemManager.getItem("ironFurCoat");
        Item ironFurPants = ItemManager.getItem("ironFurPants");
        Item ironFurBoots = ItemManager.getItem("ironFurBoots");

        Item furHat = ItemManager.getItem("furHat");
        Item furCoat = ItemManager.getItem("furCoat");
        Item warmPants = ItemManager.getItem("warmPants");
        Item furBoots = ItemManager.getItem("furBoots");

        Item bonesHat = ItemManager.getItem("bonesHat");
        Item bonesCoat = ItemManager.getItem("bonesCoat");
        Item bonesPants = ItemManager.getItem("bonesPants");
        Item bonesBoots = ItemManager.getItem("bonesBoots");

		addRecipe(woodenGrindstoneBlank, 1,
				" x ",
				"xyx",
				" x ",
				'x', Blocks.planks,
				'y', Items.stick);
		addRecipe(ironGrindstoneBlank, 1,
				" x ",
				"xyx",
				" x ",
				'x', Items.iron_ingot,
				'y', Items.stick);
		addRecipe(coarseGrindstone, 1,
				" x ",
				"xyx",
				" x ",
				'x', Blocks.stone,
				'y', woodenGrindstoneBlank);
		addRecipe(enhancedGrindstone, 1,
				" x ",
				"xyx",
				" x ",
				'x', obsidianBrick,
				'y', ironGrindstoneBlank);
		addRecipe(diamondGrindstone, 1,
				" x ",
				"xyx",
				" x ",
				'x', diamondDust,
				'y', ironGrindstoneBlank);

		addRecipe(diamondGrindstone, 1,
				" x ",
				"xyx",
				" x ",
				'x', diamondDust,
				'y', ironGrindstoneBlank);

		addShapeless(diamondDust, 2, Items.diamond);
		addShapeless(goldDust, 1, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget, Items.gold_nugget);

		addShapeless(spool, 1, Items.string, Items.string, Items.string);
		addShapeless(leatherStrap, 4, Items.leather);
		addShapeless(fabricStrap, 1, spool, spool, spool);
		addShapeless(fabricRoll, 1, fabricStrap, fabricStrap, fabricStrap, fabricStrap, fabricStrap, fabricStrap);
		addShapeless(obsidianAlloyBlank, 1, Items.iron_ingot, obsidianBrick);
		addShapeless(obsidianBrick, 2, Blocks.obsidian);

		// Соление/вяление		
		addShapeless(jerkedBeef, 1, salt, Items.beef);
		addShapeless(jerkedPork, 1, salt, Items.porkchop);
		addShapeless(jerkedLamb, 1, salt, lambRawMeat);
		addShapeless(salo, 1, salt, porkBelly);
		addShapeless(salt, 4, saltCrystal);

        addSmelting(obsidianAlloyIngot, 1, 1, obsidianAlloyBlank);
		addSmelting(lambFried, 1, 1, lambRawMeat);
		addSmelting(salt, 8, 0.1F, Items.water_bucket);

		addSmelting(cementSack, 8, 0.3F, cementMix);
		addSmelting(salt, 8, 0.1F, Items.water_bucket);

		addShapeless(goldSpool, 1, goldDust, spool);
		addShapeless(diamondSpool, 1, diamondDust, spool);
		addShapeless(goldFabricStrap, 1, goldSpool, goldSpool, goldSpool);
		addShapeless(goldFabricRoll, 1, goldFabricStrap, goldFabricStrap, goldFabricStrap, goldFabricStrap, goldFabricStrap, goldFabricStrap);
		addShapeless(diamondFabricStrap, 1, diamondSpool, diamondSpool, diamondSpool);
		addShapeless(diamondFabricRoll, 1, diamondFabricStrap, diamondFabricStrap, diamondFabricStrap, diamondFabricStrap, diamondFabricStrap, diamondFabricStrap);
		addShapeless(chevron, 1, spool, fabricRoll, spool);

		addShapeless(chevronWithGoldThread, 1, goldSpool, fabricStrap, goldSpool);
		addShapeless(chevronWithDiamondThread, 1, diamondSpool, fabricStrap, diamondSpool);
		addShapeless(goldChevronWithGoldThread, 1, goldSpool, goldFabricStrap, goldSpool);
		addShapeless(goldChevronWithDiamondThread, 1, diamondSpool, goldFabricStrap, diamondSpool);
		addShapeless(diamondChevronWithDiamondThread, 1, diamondSpool, diamondFabricStrap, diamondSpool);
		addShapeless(diamondChevronWithGoldThread, 1, goldSpool, diamondFabricStrap, goldSpool);

		addShapeless(medivalSymbol, 1, fabricStrap, spool, new ItemStack(Items.dye, 1, 11));
		addShapeless(technoSymbol, 1, fabricStrap, spool, new ItemStack(Items.dye, 1, 1));

        addShapeless(diamondFurHat, 1, woolfell, woolfell, woolfell, Items.diamond_helmet, spool);
        addShapeless(diamondFurCoat, 1, woolfell, woolfell, woolfell, woolfell, woolfell, woolfell, Items.diamond_chestplate, spool);
        addShapeless(diamondFurPants, 1, woolfell, woolfell, woolfell, woolfell, woolfell, Items.diamond_leggings, spool);
        addShapeless(diamondFurBoots, 1, woolfell, woolfell, Items.diamond_boots, spool);

        addShapeless(ironFurHat, 1, woolfell, woolfell, woolfell, Items.iron_helmet, spool);
        addShapeless(ironFurCoat, 1, woolfell, woolfell, woolfell, woolfell, woolfell, woolfell, Items.iron_chestplate, spool);
        addShapeless(ironFurPants, 1, woolfell, woolfell, woolfell, woolfell, woolfell, Items.iron_leggings, spool);
        addShapeless(ironFurBoots, 1, woolfell, woolfell, Items.iron_boots, spool);

        addShapeless(bonesHat, 1, Items.bone, Items.bone, Items.bone, Items.leather_helmet, spool);
        addShapeless(bonesCoat, 1, Items.bone, Items.bone, Items.bone, Items.bone, Items.bone, Items.bone, Items.leather_chestplate, spool);
        addShapeless(bonesPants, 1, Items.bone, Items.bone, Items.bone, Items.bone, Items.bone, Items.leather_leggings, spool);
        addShapeless(bonesBoots, 1, Items.bone, Items.bone, Items.leather_boots, spool);

        addRecipe(furHat, 1,
                "xxx",
                "x x",
                "   ",
                'x', woolfell);

        addRecipe(furCoat, 1,
                "x x",
                "xxx",
                "xxx",
                'x', woolfell);

        addRecipe(warmPants, 1,
                "xxx",
                "x x",
                "x x",
                'x', woolfell);

        addRecipe(furBoots, 1,
                "   ",
                "x x",
                "x x",
                'x', woolfell);


		if (Config.tcConfig.isEnabled()) {
			Item capsuleEmpty = ItemManager.getItem("capsuleEmpty");
			Item capsuleAbsorber = ItemManager.getItem("capsuleAbsorber");
			Item capsuleFirestarter = ItemManager.getItem("capsuleFirestarter");
			Item capsuleLogger = ItemManager.getItem("capsuleLogger");
			Item capsuleRedstone = ItemManager.getItem("capsuleRedstone");
			Item capsuleShocker = ItemManager.getItem("capsuleShocker");
			Item capsuleSiren = ItemManager.getItem("capsuleSiren");
			Item capsuleAntipicklock = ItemManager.getItem("capsuleAntipicklock");
			Item capsuleTNT = ItemManager.getItem("capsuleTNT");

			Item ironBlank = ItemManager.getItem("ironBlank");
			Item ironKey = ItemManager.getItem("ironKey");
			Item goldenKey = ItemManager.getItem("goldenKey");
			Item diamondKey = ItemManager.getItem("diamondKey");
			Item ironPicklock = ItemManager.getItem("ironPicklock");
			Item goldenPicklock = ItemManager.getItem("goldenPicklock");
			Item diamondPicklock = ItemManager.getItem("diamondPicklock");

			addRecipe(capsuleEmpty, 1,
					" y ",
					" x ",
					" y ",
					'x', Blocks.glass,
					'y', ironBlank);

			addRecipe(capsuleAbsorber, 1,
					"zxz",
					"zyz",
					"zzz",
					'x', diamondDust,
					'z', goldDust,
					'y', capsuleEmpty);

			addRecipe(capsuleFirestarter, 1,
					"zyz",
					"xyx",
					"xxx",
					'x', Items.blaze_powder,
					'z', Items.magma_cream,
					'y', capsuleEmpty);

			addRecipe(capsuleLogger, 1,
					"xzx",
					"xyx",
					'x', goldDust,
					'z', Items.book,
					'y', capsuleEmpty);

			addRecipe(capsuleRedstone, 1,
					"xxx",
					"ryr",
					"xxx",
					'x', goldDust,
					'r', Items.redstone,
					'y', capsuleEmpty);

			addRecipe(capsuleShocker, 1,
					"   ",
					"qyq",
					"rrr",
					'q', Items.quartz,
					'x', Items.redstone,
					'y', capsuleEmpty);

			addRecipe(capsuleSiren, 1,
					" n ",
					"nyn",
					" n ",
					'n', Blocks.noteblock,
					'y', capsuleEmpty);

			addRecipe(capsuleAntipicklock, 1,
					"rxr",
					"byb",
					"rxr",
					'x', diamondDust,
					'b', Items.blaze_rod,
					'r', Items.redstone,
					'y', capsuleEmpty);

			addRecipe(capsuleTNT, 1,
					"xxx",
					"ryr",
					"xxx",
					'r', Items.redstone,
					'x', Items.gunpowder,
					'y', capsuleEmpty);

			addShapeless(ironBlank, 4, Items.iron_ingot);
			addShapeless(ironKey, 1, ironBlank);
			addShapeless(goldenKey, 1, ironBlank, goldDust);
			addShapeless(diamondKey, 1, ironBlank, diamondDust);

			addShapeless(ironPicklock, 1, ironBlank, ironBlank);
			addShapeless(goldenPicklock, 1, ironBlank, ironBlank, goldDust, goldDust);
			addShapeless(diamondPicklock, 1, ironBlank, ironBlank, diamondDust, diamondDust);
		}


		
		/*
		// marble and other simple blocks
		GameRegistry.addRecipe(new ItemStack(itemCementMix, 1), "xkx", "kzk", "xkx", 'k', new ItemStack(Item.dyePowder, 3,
				15), 'z', Item.bucketWater, 'x', Block.sand);

		GameRegistry.addRecipe(new ItemStack(itemIronStripe, 6), "xxx", 'x', Item.ingotIron);
		// переплавка
		
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
		GameRegistry.addRecipe(new ItemStack(leatherCorset, 1),
				"x x",
				"xyx",
				"xyx",
				'x', leatherStrap,
				'y', Item.silk);

		// крафт нейтральных флагов
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 0), "xxx", "rsr", "p p", 'x', Item.stick, 's', chevron, 'p',
				spool, 'r', fabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 1), "xxx", "rsr", "p p", 'x', Item.stick, 's', chevron, 'p',
				goldSpool, 'r', fabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 2), "xxx", "rsr", "p p", 'x', Item.stick, 's', chevron, 'p',
				goldSpool, 'r', goldFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 3), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				chevronWithGoldThread, 'p', spool, 'r', fabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 4), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				chevronWithGoldThread, 'p', goldSpool, 'r', fabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 5), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				chevronWithGoldThread, 'p', spool, 'r', goldFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 6), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				goldChevronWithGoldThread, 'p', spool, 'r', fabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 7), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				goldChevronWithGoldThread, 'p', goldSpool, 'r', fabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 8), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				goldChevronWithGoldThread, 'p', spool, 'r', goldFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 9), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				goldChevronWithGoldThread, 'p', goldSpool, 'r', goldFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 10), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				goldChevronWithDiamondThread, 'p', spool, 'r', fabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 11), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				goldChevronWithDiamondThread, 'p', goldSpool, 'r', fabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 12), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				goldChevronWithDiamondThread, 'p', spool, 'r', goldFabricRoll);
		GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 13), "xxx", "rsr", "p p", 'x', Item.stick, 's',
				goldChevronWithDiamondThread, 'p', goldSpool, 'r', goldFabricRoll);

		// консерваторские флаги
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 0), "xxx", "rsr", "pyp", 'x', Item.stick, 's', chevron,
				'p', spool, 'r', fabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 1), "xxx", "rsr", "pyp", 'x', Item.stick, 's', chevron,
				'p', diamondSpool, 'r', fabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 2), "xxx", "rsr", "pyp", 'x', Item.stick, 's', chevron,
				'p', diamondSpool, 'r', diamondFabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 3), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				chevronWithDiamondThread, 'p', spool, 'r', fabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 4), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				chevronWithDiamondThread, 'p', diamondSpool, 'r', fabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 5), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				chevronWithDiamondThread, 'p', spool, 'r', diamondFabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 6), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithGoldThread, 'p', spool, 'r', fabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 7), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithGoldThread, 'p', diamondSpool, 'r', fabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 8), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithGoldThread, 'p', spool, 'r', diamondFabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 9), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithGoldThread, 'p', diamondSpool, 'r', diamondFabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 10), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithDiamondThread, 'p', spool, 'r', fabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 11), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithDiamondThread, 'p', diamondSpool, 'r', fabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 12), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithDiamondThread, 'p', spool, 'r', diamondFabricRoll, 'y', medivalSymbol);
		GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 13), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithDiamondThread, 'p', diamondSpool, 'r', diamondFabricRoll, 'y',
				medivalSymbol);
		// Флаги технократов
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 0), "xxx", "rsr", "pyp", 'x', Item.stick, 's', chevron,
				'p', spool, 'r', fabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 1), "xxx", "rsr", "pyp", 'x', Item.stick, 's', chevron,
				'p', diamondSpool, 'r', fabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 2), "xxx", "rsr", "pyp", 'x', Item.stick, 's', chevron,
				'p', diamondSpool, 'r', diamondFabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 3), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				chevronWithDiamondThread, 'p', spool, 'r', fabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 4), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				chevronWithDiamondThread, 'p', diamondSpool, 'r', fabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 5), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				chevronWithDiamondThread, 'p', spool, 'r', diamondFabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 6), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithGoldThread, 'p', spool, 'r', fabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 7), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithGoldThread, 'p', diamondSpool, 'r', fabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 8), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithGoldThread, 'p', spool, 'r', diamondFabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 9), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 10), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithDiamondThread, 'p', spool, 'r', fabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 11), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithDiamondThread, 'p', diamondSpool, 'r', fabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 12), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithDiamondThread, 'p', spool, 'r', diamondFabricRoll, 'y', technoSymbol);
		GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 13), "xxx", "rsr", "pyp", 'x', Item.stick, 's',
				diamondChevronWithDiamondThread, 'p', diamondSpool, 'r', diamondFabricRoll, 'y',
				technoSymbol);
				
		*/
	}
}
