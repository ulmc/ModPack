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
import ru.ulmc.extender.render.RenderBarrel;
import ru.ulmc.extender.render.RenderChairs;
import ru.ulmc.extender.render.RenderFlags;
import ru.ulmc.extender.render.RenderTables;
import ru.ulmc.extender.tileentity.*;

import java.util.HashMap;
import java.util.Map;

public class BlockManager {

	public static BlockEliteChair blockGoldenThrone;

	public static BlockTable blockSpruceWoodTable;
	public static BlockTable blockBirchWoodTable;
	public static BlockTable blockOakWoodTable;
	public static BlockTable blockJungleWoodTable;
	public static BlockTable blockAcaciaWoodTable;

	public static BlockTable blockCabinetBlackwoodTable;
	public static BlockTable blockCabinetRedwoodTable;
	public static BlockTable blockDinnerWoodTable;

	public static BlockBarrel blockBarrel;

	public static BlockFlag blockFlag;
	public static BlockFlag blockMedivalFlag;
	public static BlockFlag blockTechnoFlag;
	public static FillerBlock flagFillerBlock;
	public static FillerBlock cartFillerBlock;
	public static BlockBarbedWire blockBarbedWire;
	public static BlockLockedChest blockLockedChest;
	public static BlockGrinder blockGrinder;
    public static BlockBarley blockBarley;
	public static BlockChair[] chairBlocksBirch = new BlockChair[16];
	public static BlockChair[] chairBlocksOak = new BlockChair[16];
	public static BlockChair[] chairBlocksJungle = new BlockChair[16];
	public static BlockChair[] chairBlocksSpruce = new BlockChair[16];
	public static BlockChair[] chairBlocksAcacia = new BlockChair[16];


    public static BlockBones blockBones;
	public static BlockCart blockCart;
	protected static CommonProxy proxy;
	private static Map<String, Block> blocks = new HashMap<String, Block>();

	public static void init(CommonProxy aProxy) {
		proxy = aProxy;

		chairBlocksBirch[0] = createBlockChair("blockBirchChair_Original");
		for(int i = 1; i < 16; i++) {
			chairBlocksBirch[i] = createBlockChair("blockBirchChair_" + i);
		}
		chairBlocksOak[0] = createBlockChair("blockOakChair_Original");
		for(int i = 1; i < 16; i++) {
			chairBlocksOak[i] = createBlockChair("blockOakChair_" + i);
		}
		chairBlocksJungle[0] = createBlockChair("blockJungleChair_Original");
		for(int i = 1; i < 16; i++) {
			chairBlocksJungle[i] = createBlockChair("blockJungleChair_" + i);
		}
		chairBlocksSpruce[0] = createBlockChair("blockSpruceChair_Original");
		for(int i = 1; i < 16; i++) {
			chairBlocksSpruce[i] = createBlockChair("blockSpruceChair_" + i);
		}
		chairBlocksAcacia[0] = createBlockChair("blockAcaciaChair_Original");
		for(int i = 1; i < 16; i++) {
			chairBlocksAcacia[i] = createBlockChair("blockAcaciaChair_" + i);
		}

		blockGoldenThrone = createBlockEliteChair("blockGoldenThrone");

		blockBarrel = createBlockBarrel("blockSpruceBarrel");

		blockSpruceWoodTable = createBlockTable(0.5F, 5.0F, "blockSpruceBarTable", TileEntityTable.MODEL_TABLE);
		blockBirchWoodTable = createBlockTable(0.5F, 5.0F, "blockBirchBarTable", TileEntityTable.MODEL_TABLE);
		blockOakWoodTable = createBlockTable(0.5F, 5.0F, "blockOakBarTable", TileEntityTable.MODEL_TABLE);
		blockJungleWoodTable = createBlockTable(0.5F, 5.0F, "blockJungleBarTable", TileEntityTable.MODEL_TABLE);
		blockAcaciaWoodTable = createBlockTable(0.5F, 5.0F, "blockAcaciaBarTable", TileEntityTable.MODEL_TABLE);

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

	private static BlockChair createBlockChair(String name) {
		BlockChair block = (BlockChair) registerBlock(new BlockChair(TileEntityChair.class, name));
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

	private static BlockEliteChair createBlockEliteChair(String name) {
		BlockEliteChair block = (BlockEliteChair) registerBlock(new BlockEliteChair(TileEntityEliteChair.class, name));
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
