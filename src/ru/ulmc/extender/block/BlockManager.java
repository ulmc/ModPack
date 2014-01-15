/**
 * Copyright (C) 2014 Kolmogorov Alexey
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

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import ru.ulmc.extender.ConfigurationHander;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.proxy.CommonProxy;
import ru.ulmc.extender.tileentity.TileEntityFiller;
import ru.ulmc.extender.tileentity.TileEntityBones;
import ru.ulmc.extender.tileentity.TileEntityCart;
import ru.ulmc.extender.tileentity.TileEntityChair;
import ru.ulmc.extender.tileentity.TileEntityEliteChair;
import ru.ulmc.extender.tileentity.TileEntityFlag;
import ru.ulmc.extender.tileentity.TileEntityGrinder;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;
import ru.ulmc.extender.tileentity.TileEntityTable;
import cpw.mods.fml.common.registry.GameRegistry;

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

	public static BlockBones blockBones;
	public static BlockCart blockCart;

	private static int blockID = 850;
	private static int metaBlockID = 1656;
	
	private static Map<String, Block> blocks = new HashMap<>();

	protected static CommonProxy proxy;

	public static void init(CommonProxy aProxy) {
		proxy = aProxy;
		
		blockWoodChair = createBlockChair(++blockID, 0.5F, 3.0F, "blockWoodChair");
		blockWhiteCottonChair = createBlockChair(++blockID, 0.5F, 3.0F, "blockWhiteCottonChair");
		blockBlueCottonChair = createBlockChair(++blockID, 0.5F, 3.0F, "blockBlueCottonChair");
		blockRedCottonChair = createBlockChair(++blockID, 0.5F, 3.0F, "blockRedCottonChair");
		blockBlackCottonChair = createBlockChair(++blockID, 0.5F, 3.0F, "blockBlackCottonChair");
		blockLeatherChair = createBlockChair(++blockID, 0.5F, 5.0F, "blockLeatherChair");
		blockIronChair = createBlockChair(++blockID, 1.5F, 8.0F, "blockIronChair");

		blockBlackwoodChair = createBlockEliteChair(++blockID, 1.0F, 5.0F, "blockBlackwoodChair");
		blockRedwoodChair = createBlockEliteChair(++blockID, 1.0F, 5.0F, "blockRedwoodChair");
		blockGoldChair = createBlockEliteChair(++blockID, 1.0F, 5.0F, "blockGoldChair");
		blockDiamondedChair = createBlockEliteChair(++blockID, 1.5F, 10.0F, "blockDiamondedChair");

		blockWoodTable = createBlockTable(++blockID, 0.5F, 5.0F, "blockWoodTable", TileEntityTable.MODEL_TABLE);
		blockIronTable = createBlockTable(++blockID, 1.5F, 10.0F, "blockIronTable", TileEntityTable.MODEL_TABLE);
		blockStoneTable = createBlockTable(++blockID, 2.0F, 10.0F, "blockStoneTable", TileEntityTable.MODEL_TABLE);
		blockBlackwoodTable = createBlockTable(++blockID, 1.0F, 6.0F, "blockBlackwoodTable", TileEntityTable.MODEL_TABLE);
		blockRedwoodTable = createBlockTable(++blockID, 1.0F, 6.0F, "blockRedwoodTable", TileEntityTable.MODEL_TABLE);

		blockCabinetBlackwoodTable = createBlockTable(++blockID, 1.0F, 6.0F, "blockCabinetBlackwoodTable", TileEntityTable.MODEL_CABINET);
		blockCabinetRedwoodTable = createBlockTable(++blockID, 1.0F, 6.0F, "blockCabinetRedwoodTable", TileEntityTable.MODEL_CABINET);

		blockDinnerWoodTable = createBlockTable(++blockID, 0.5F, 2.0F, "blockDinnerWoodTable", TileEntityTable.MODEL_DINNER);

		flagFillerBlock = createFillerBlock(++blockID, Material.cloth, "fillerBlockFlag", Block.soundClothFootstep);
		flagFillerBlock.setBlockBounds(0.1F, 0.0F, 0.1F, 0.1F, 1.0F, 0.1F);

		blockBones = createBlockBones(++blockID, "blockOfBones");

		blockFlag = createBlockFlag(++blockID, 0.5f, 1.0f, "blockNeutralFlag", 0, flagFillerBlock);
		blockMedivalFlag = createBlockFlag(++blockID, 0.5f, 1.0f, "blockMedivalFlag", 1, flagFillerBlock);
		blockTechnoFlag = createBlockFlag(++blockID, 0.5f, 1.0f, "blockTechnoFlag", 2, flagFillerBlock);

		blockBarbedWire = createBlockBarbedWire(++blockID, "barbedWire");
		blockLockedChest = createBlockLockedChest(++blockID, "blockLockedChest");
		blockGrinder = createBlockGrinder(++blockID, "blockGrinder");
		
		cartFillerBlock = createFillerBlock(++blockID, Material.wood, "fillerBlockCart",  Block.soundWoodFootstep);
		cartFillerBlock.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		blockCart = createBlockCart(++blockID, "blockCart", cartFillerBlock);

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

	@SuppressWarnings("unused")
	private static void setHarvestTool(Block block, String tool, int level) {
		MinecraftForge.setBlockHarvestLevel(block, tool, level);
	}

	private static FillerBlock createFillerBlock(int blockID, Material material, String systemName, StepSound sound) {
		return (FillerBlock) registerBlock(new FillerBlock(ConfigurationHander.getBlockID(systemName, blockID), material, systemName, sound));
	}

	private static BlockChair createBlockChair(int blockID, float hardness, float explosionResistance, String name) {
		return (BlockChair) registerBlock(new BlockChair(ConfigurationHander.getBlockID(name, blockID), TileEntityChair.class, hardness, explosionResistance, name));
	}

	private static BlockEliteChair createBlockEliteChair(int blockID, float hardness, float explosionResistance, String name) {
		return (BlockEliteChair) registerBlock(new BlockEliteChair(ConfigurationHander.getBlockID(name, blockID),
				TileEntityEliteChair.class, hardness, explosionResistance, name));
	}

	private static BlockTable createBlockTable(int blockID, float hardness, float explosionResistance, String name, int model) {
		return (BlockTable) registerBlock(new BlockTable(ConfigurationHander.getBlockID(name, blockID), hardness, explosionResistance, name, model));
	}

	private static BlockFlag createBlockFlag(int blockID, float hardness, float explosionResistance, String name, int i,
			FillerBlock filler) {
		return (BlockFlag) registerBlock(new BlockFlag(ConfigurationHander.getBlockID(name, blockID), TileEntityFlag.class, hardness, explosionResistance, name,
				i, filler));
	}

	private static BlockBones createBlockBones(int blockID, String name) {
		return (BlockBones) registerBlock(new BlockBones(ConfigurationHander.getBlockID(name, blockID), name));
	}

	private static BlockBarbedWire createBlockBarbedWire(int blockID, String name) {
		return (BlockBarbedWire) registerBlock(new BlockBarbedWire(ConfigurationHander.getBlockID(name, blockID), name));
	}

	private static BlockLockedChest createBlockLockedChest(int blockID, String name) {
		return (BlockLockedChest) registerBlock(new BlockLockedChest(ConfigurationHander.getBlockID(name, blockID), name));
	}

	private static BlockGrinder createBlockGrinder(int blockID, String name) {
		return (BlockGrinder) registerBlock(new BlockGrinder(ConfigurationHander.getBlockID(name, blockID), name));
	}

	private static BlockCart createBlockCart(int blockID, String name, Block filler) {
		return (BlockCart) registerBlock(new BlockCart(ConfigurationHander.getBlockID(name, blockID), name, filler));
	}
	private static UlmcBlock registerBlock(UlmcBlock block) {
		proxy.prepareBlock((Block)block);
		blocks.put(block.getSystemName(), (Block)block);
		return block;
	}
	
	

}
