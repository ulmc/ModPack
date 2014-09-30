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
package ru.ulmc.extender.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ru.ulmc.extender.proxy.CommonProxy;
import ru.ulmc.extender.render.RenderChairs;
import ru.ulmc.extender.render.RenderFlags;
import ru.ulmc.extender.render.RenderTables;
import ru.ulmc.extender.tileentity.*;

import java.util.HashMap;
import java.util.Map;

public class BlockManager {

	public static BlockChair blockWoodChair;
	public static BlockChair blockWhiteCottonChair;
	public static BlockChair blockBlueCottonChair;
	public static BlockChair blockRedCottonChair;
	public static BlockChair blockBlackCottonChair;
	public static BlockChair blockLeatherChair;
	public static BlockChair blockIronChair;
	public static BlockEliteChair blockBlackwoodChair;
	public static BlockEliteChair blockRedwoodChair;
	public static BlockEliteChair blockGoldChair;
	public static BlockEliteChair blockDiamondedChair;

	public static BlockTable blockWoodTable;
	public static BlockTable blockIronTable;
	public static BlockTable blockStoneTable;
	public static BlockTable blockBlackwoodTable;
	public static BlockTable blockRedwoodTable;
	public static BlockTable blockCabinetBlackwoodTable;
	public static BlockTable blockCabinetRedwoodTable;
	public static BlockTable blockDinnerWoodTable;

	public static BlockFlag blockFlag;
	public static BlockFlag blockMedivalFlag;
	public static BlockFlag blockTechnoFlag;
	public static FillerBlock flagFillerBlock;
	public static FillerBlock cartFillerBlock;
	public static BlockBarbedWire blockBarbedWire;
	public static BlockLockedChest blockLockedChest;
	public static BlockGrinder blockGrinder;
    public static BlockBarley blockBarley;


    public static BlockBones blockBones;
	public static BlockCart blockCart;
	protected static CommonProxy proxy;
	private static Map<String, Block> blocks = new HashMap<String, Block>();

	public static void init(CommonProxy aProxy) {
		proxy = aProxy;

		blockWoodChair = createBlockChair(0.5F, 3.0F, "blockWoodChair");
		blockWhiteCottonChair = createBlockChair(0.5F, 3.0F, "blockWhiteCottonChair");
		blockBlueCottonChair = createBlockChair(0.5F, 3.0F, "blockBlueCottonChair");
		blockRedCottonChair = createBlockChair(0.5F, 3.0F, "blockRedCottonChair");
		blockBlackCottonChair = createBlockChair(0.5F, 3.0F, "blockBlackCottonChair");
		blockLeatherChair = createBlockChair(0.5F, 5.0F, "blockLeatherChair");
		blockIronChair = createBlockChair(1.5F, 8.0F, "blockIronChair");

		blockBlackwoodChair = createBlockEliteChair(1.0F, 5.0F, "blockBlackwoodChair");
		blockRedwoodChair = createBlockEliteChair(1.0F, 5.0F, "blockRedwoodChair");
		blockGoldChair = createBlockEliteChair(1.0F, 5.0F, "blockGoldChair");
		blockDiamondedChair = createBlockEliteChair(1.5F, 10.0F, "blockDiamondedChair");

		blockWoodTable = createBlockTable(0.5F, 5.0F, "blockWoodTable", TileEntityTable.MODEL_TABLE);
		blockIronTable = createBlockTable(1.5F, 10.0F, "blockIronTable", TileEntityTable.MODEL_TABLE);
		blockStoneTable = createBlockTable(2.0F, 10.0F, "blockStoneTable", TileEntityTable.MODEL_TABLE);
		blockBlackwoodTable = createBlockTable(1.0F, 6.0F, "blockBlackwoodTable", TileEntityTable.MODEL_TABLE);
		blockRedwoodTable = createBlockTable(1.0F, 6.0F, "blockRedwoodTable", TileEntityTable.MODEL_TABLE);

		blockCabinetBlackwoodTable = createBlockTable(1.0F, 6.0F, "blockCabinetBlackwoodTable", TileEntityTable.MODEL_CABINET);
		blockCabinetRedwoodTable = createBlockTable(1.0F, 6.0F, "blockCabinetRedwoodTable", TileEntityTable.MODEL_CABINET);

		blockDinnerWoodTable = createBlockTable(0.5F, 2.0F, "blockDinnerWoodTable", TileEntityTable.MODEL_DINNER);

		flagFillerBlock = createFillerBlock(Material.cloth, "fillerBlockFlag", Block.soundTypeCloth);
		//flagFillerBlock.setBlockBounds(0.1F, 0.0F, 0.1F, 0.1F, 1.0F, 0.1F);

		blockBones = createBlockBones("blockOfBones");

		/*blockFlag = createBlockFlag(0.5f, 1.0f, "blockNeutralFlag", 0, flagFillerBlock);
		blockMedivalFlag = createBlockFlag(0.5f, 1.0f, "blockMedivalFlag", 1, flagFillerBlock);
		blockTechnoFlag = createBlockFlag(0.5f, 1.0f, "blockTechnoFlag", 2, flagFillerBlock);*/

		blockBarbedWire = createBlockBarbedWire("barbedWire");
		blockLockedChest = createBlockLockedChest("blockLockedChest");
		blockGrinder = createBlockGrinder("blockGrinder");

		cartFillerBlock = createFillerBlock(Material.wood, "fillerBlockCart", Block.soundTypeWood);
		cartFillerBlock.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		blockCart = createBlockCart("blockCart", cartFillerBlock);
        blockBarley = new BlockBarley("blockBarley");
        registerBlock(blockBarley);

		GameRegistry.registerTileEntity(TileEntityChair.class, "ulmcTileEntityChair");
		GameRegistry.registerTileEntity(TileEntityEliteChair.class, "ulmcTileEntityEliteChair");
		GameRegistry.registerTileEntity(TileEntityFlag.class, "ulmcTileEntityFlag");
		GameRegistry.registerTileEntity(TileEntityFiller.class, "ulmcFillerTileEntity");
		GameRegistry.registerTileEntity(TileEntityTable.class, "ulmcTileEntityTable");
		GameRegistry.registerTileEntity(TileEntityBones.class, "ulmcTileEntityBones");
		GameRegistry.registerTileEntity(TileEntityLockedChest.class, "ulmcTileEntityLockedChest");
		GameRegistry.registerTileEntity(TileEntityGrinder.class, "ulmcTileEntityGrinder");
		GameRegistry.registerTileEntity(TileEntityCart.class, "ulmcTileEntityCart");
	}

	private static FillerBlock createFillerBlock(Material material, String systemName, Block.SoundType sound) {
		return (FillerBlock) registerBlock(new FillerBlock(material, systemName, sound));
	}

	private static BlockChair createBlockChair(float hardness, float explosionResistance, String name) {
		BlockChair block = (BlockChair) registerBlock(new BlockChair(TileEntityChair.class, hardness, explosionResistance, name));
		try {
			RenderChairs.registerResource(block.getUnlocalizedName());
		} catch (Throwable e) {
		}
		return block;
	}

	private static BlockEliteChair createBlockEliteChair(float hardness, float explosionResistance, String name) {
		BlockEliteChair block = (BlockEliteChair) registerBlock(new BlockEliteChair(TileEntityEliteChair.class, hardness, explosionResistance, name));
		try {
			RenderChairs.registerResource(block.getUnlocalizedName());
		} catch (Throwable e) {
		}
		return block;
	}

	private static BlockTable createBlockTable(float hardness, float explosionResistance, String name, int model) {
		BlockTable block = (BlockTable) registerBlock(new BlockTable(hardness, explosionResistance, name, model));
		try {
			RenderTables.registerResource(block.getUnlocalizedName());
		} catch (Throwable e) {
		}
		return block;
	}

	private static BlockFlag createBlockFlag(float hardness, float explosionResistance, String name, int blockType,
	                                         FillerBlock filler) {
		BlockFlag block = (BlockFlag) registerBlock(new BlockFlag(TileEntityFlag.class, hardness, explosionResistance, name, blockType, filler));
		try {
			RenderFlags.registerResource(blockType, block.getUnlocalizedName());
		} catch (Throwable e) {
		}

		return block;
	}

	private static BlockBones createBlockBones(String name) {
		return (BlockBones) registerBlock(new BlockBones(name));
	}

	private static BlockBarbedWire createBlockBarbedWire(String name) {
		return (BlockBarbedWire) registerBlock(new BlockBarbedWire(name));
	}

	private static BlockLockedChest createBlockLockedChest(String name) {
		return (BlockLockedChest) registerBlock(new BlockLockedChest(name));
	}

	private static BlockGrinder createBlockGrinder(String name) {
		return (BlockGrinder) registerBlock(new BlockGrinder(name));
	}

	private static BlockCart createBlockCart(String name, Block filler) {
		return (BlockCart) registerBlock(new BlockCart(name, filler));
	}

	private static UlmcBlock registerBlock(UlmcBlock block) {
		proxy.prepareBlock((Block) block);
		blocks.put(block.getSystemName(), (Block) block);
		return block;
	}

   }
