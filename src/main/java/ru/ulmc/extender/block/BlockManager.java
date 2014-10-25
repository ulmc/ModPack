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
import net.minecraft.item.ItemBlock;
import ru.ulmc.extender.item.ItemColoredFurniture;
import ru.ulmc.extender.item.ItemWooden;
import ru.ulmc.extender.proxy.CommonProxy;
import ru.ulmc.extender.render.*;
import ru.ulmc.extender.tileentity.*;

import java.util.HashMap;
import java.util.Map;

public class BlockManager {

	public static BlockEliteChair blockGoldenThrone;

	public static BlockTable blockBarTable;

	public static BlockTable blockCabinetTable;
	public static BlockTable blockDinnerTable;

	public static BlockBarrel blockBarrel;

	public static FillerBlock flagFillerBlock;
	public static FillerBlock cartFillerBlock;
	public static BlockBarbedWire blockBarbedWire;
	public static BlockLockedChest blockLockedChest;
	public static BlockGrinder blockGrinder;
	public static BlockBarley blockBarley;

	public static BlockChair chairBlocksBirchOrigin;
	public static BlockChair chairBlocksOakOrigin;
	public static BlockChair chairBlocksJungleOrigin;
	public static BlockChair chairBlocksSpruceOrigin;
	public static BlockChair chairBlocksAcaciaOrigin;
	public static BlockChair chairBlocksOldOakOrigin;

	public static BlockChair chairBlocksBirchColor;
	public static BlockChair chairBlocksOakColor;
	public static BlockChair chairBlocksJungleColor;
	public static BlockChair chairBlocksSpruceColor;
	public static BlockChair chairBlocksAcaciaColor;
	public static BlockChair chairBlocksOldOakColor;

	public static BlockBench benchBlocksBirch;
	public static BlockBench benchBlocksOak;
	public static BlockBench benchBlocksOldOak;
	public static BlockBench benchBlocksJungle;
	public static BlockBench benchBlocksSpruce;
	public static BlockBench benchBlocksAcacia;

	public static BlockBuildingBlock buildingBlock;

	public static BlockBones blockBones;
	public static BlockCart blockCart;
	protected static CommonProxy proxy;
	private static Map<String, Block> blocks = new HashMap<String, Block>();

	public static void init(CommonProxy aProxy) {
		proxy = aProxy;

		chairBlocksBirchOrigin = createBlockChair("blockBirchChair_Original", false);
		chairBlocksBirchColor = createBlockChair("blockBirchChair", true);
		chairBlocksOakOrigin = createBlockChair("blockOakChair_Original", false);
		chairBlocksOakColor = createBlockChair("blockOakChair", true);
		chairBlocksJungleOrigin = createBlockChair("blockJungleChair_Original", false);
		chairBlocksJungleColor = createBlockChair("blockJungleChair", true);
		chairBlocksSpruceOrigin = createBlockChair("blockSpruceChair_Original", false);
		chairBlocksSpruceColor = createBlockChair("blockSpruceChair", true);
		chairBlocksAcaciaOrigin = createBlockChair("blockAcaciaChair_Original", false);
		chairBlocksAcaciaColor = createBlockChair("blockAcaciaChair", true);
		chairBlocksOldOakOrigin = createBlockChair("blockOldOakChair_Original", false);
		chairBlocksOldOakColor = createBlockChair("blockOldOakChair", true);

		blockGoldenThrone = createBlockEliteChair("blockGoldenThrone");

		blockBarrel = createBlockBarrel("blockSpruceBarrel");

		blockBarTable = createBlockTable(0.5F,   2.0F, "blockBarTable",  BlockTable.MODEL_BAR);
		blockCabinetTable = createBlockTable(1.0F, 2.5F, "blockCabinetTable", BlockTable.MODEL_CABINET);
		blockDinnerTable = createBlockTable(0.5F, 2.0F, "blockDinnerTable", BlockTable.MODEL_DINNER);

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

		benchBlocksSpruce = createBlockBench(Material.wood, "blockSpruceBench");
		benchBlocksBirch = createBlockBench(Material.wood, "blockBirchBench");
		benchBlocksJungle = createBlockBench(Material.wood, "blockJungleBench");
		benchBlocksOak = createBlockBench(Material.wood, "blockOakBench");
		benchBlocksOldOak = createBlockBench(Material.wood, "blockOldOakBench");
		benchBlocksAcacia = createBlockBench(Material.wood, "blockAcaciaBench");

		//todo: !!!
		//createBlockConnectedTable(Material.wood, "blockWoodenTable");

		blockBarley = new BlockBarley("blockBarley");
		registerBlock(blockBarley);

		buildingBlock = createBuildingBlock("buildingBlock");

		GameRegistry.registerTileEntity(TileEntityChair.class, "ulmcTileEntityChair");
		GameRegistry.registerTileEntity(TileEntityEliteChair.class, "ulmcTileEntityEliteChair");
		GameRegistry.registerTileEntity(TileEntityFlag.class, "ulmcTileEntityFlag");
		GameRegistry.registerTileEntity(TileEntityFiller.class, "ulmcFillerTileEntity");
		GameRegistry.registerTileEntity(TileEntityTable.class, "ulmcTileEntityTable");
		GameRegistry.registerTileEntity(TileEntityBones.class, "ulmcTileEntityBones");
		GameRegistry.registerTileEntity(TileEntityLockedChest.class, "ulmcTileEntityLockedChest");
		GameRegistry.registerTileEntity(TileEntityGrinder.class, "ulmcTileEntityGrinder");
		GameRegistry.registerTileEntity(TileEntityCart.class, "ulmcTileEntityCart");
		GameRegistry.registerTileEntity(TileEntityBench.class, "ulmcTileEntityBench");
		GameRegistry.registerTileEntity(TileEntityConnectedTable.class, "ulmcTileEntityConnectedTable");
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "ulmcTileEntityBarrel");
		GameRegistry.registerTileEntity(BuildingBlockTileEntity.class, "ulmcBuildingBlockTileEntity");
	}

	private static FillerBlock createFillerBlock(Material material, String systemName, Block.SoundType sound) {
		return (FillerBlock) registerBlock(new FillerBlock(material, systemName, sound));
	}

	private static BlockChair createBlockChair(String name, boolean isColored) {
		BlockChair block = (BlockChair) registerBlock(new BlockChair(TileEntityChair.class, name, isColored), ItemColoredFurniture.class);
		try {
			RenderChairs.registerResource(block.getUnlocalizedName());
		} catch (Throwable e) {
		}
		return block;
	}

	private static BlockBarrel createBlockBarrel(String name) {
		BlockBarrel block = (BlockBarrel) registerBlock(new BlockBarrel(TileEntityBarrel.class, name));
		try {
			RenderBarrel.registerResource(block.getUnlocalizedName());
		} catch (Throwable e) {
		}
		return block;
	}

	private static BlockBench createBlockBench(Material mat, String name) {
		BlockBench block = (BlockBench) registerBlock(new BlockBench(mat, name), ItemColoredFurniture.class);
		try {
			RenderBench.registerResource(block.getUnlocalizedName());
		} catch (Throwable e) {
		}
		return block;
	}

	private static BlockConnectedTable createBlockConnectedTable(Material mat, String name) {
		BlockConnectedTable block = (BlockConnectedTable) registerBlock(new BlockConnectedTable(mat, name));
		try {
			RenderConnectedTable.registerResource(block.getUnlocalizedName());
		} catch (Throwable e) {
		}
		return block;
	}

	private static BlockEliteChair createBlockEliteChair(String name) {
		BlockEliteChair block = (BlockEliteChair) registerBlock(new BlockEliteChair(TileEntityEliteChair.class, name));
		try {
			RenderChairs.registerResource(block.getUnlocalizedName());
		} catch (Throwable e) {
		}
		return block;
	}

	private static BlockTable createBlockTable(float hardness, float explosionResistance, String name, int model) {
		BlockTable block = (BlockTable) registerBlock(new BlockTable(hardness, explosionResistance, name, model), ItemWooden.class);
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

	private static BlockBuildingBlock createBuildingBlock(String name) {
		return (BlockBuildingBlock) registerBlock(new BlockBuildingBlock(name));
	}

	private static BlockCart createBlockCart(String name, Block filler) {
		return (BlockCart) registerBlock(new BlockCart(name, filler));
	}

	private static UlmcBlock registerBlock(UlmcBlock block) {
		proxy.prepareBlock((Block) block);
		blocks.put(block.getSystemName(), (Block) block);
		return block;
	}
	private static UlmcBlock registerBlock(UlmcBlock block, Class<? extends ItemBlock> clazz) {
		proxy.prepareBlock((Block) block, clazz);
		blocks.put(block.getSystemName(), (Block) block);
		return block;
	}

}
