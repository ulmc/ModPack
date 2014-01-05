package ru.ulmc.extender.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import ru.ulmc.extender.proxy.CommonProxy;
import ru.ulmc.extender.tileentity.FillerTileEntity;
import ru.ulmc.extender.tileentity.TileEntityBones;
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
	public static BlockBarbedWire blockBarbedWire;
	public static BlockLockedChest blockLockedChest;
	public static BlockGrinder blockGrinder;

	public static Block blockBones;
	
	private static int blockID = 850;
	private static int metaBlockID = 1656;

	public static void init(CommonProxy proxy) {
		
		blockWoodChair 			= new BlockChair(++blockID, TileEntityChair.class, 0.5F, 3.0F, "blockWoodChair");
		blockWhiteCottonChair 	= new BlockChair(++blockID, TileEntityChair.class, 0.5F, 3.0F, "blockWhiteCottonChair");
		blockBlueCottonChair 	= new BlockChair(++blockID, TileEntityChair.class, 0.5F, 3.0F, "blockBlueCottonChair");
		blockRedCottonChair 	= new BlockChair(++blockID, TileEntityChair.class, 0.5F, 3.0F, "blockRedCottonChair");
		blockBlackCottonChair 	= new BlockChair(++blockID, TileEntityChair.class, 0.5F, 3.0F, "blockBlackCottonChair");
		blockLeatherChair 		= new BlockChair(++blockID, TileEntityChair.class, 1.5F, 5.0F, "blockLeatherChair");
		blockIronChair			= new BlockChair(++blockID, TileEntityChair.class, 1.5F, 8.0F, "blockIronChair");
		
		blockBlackwoodChair 	= new BlockEliteChair(++blockID, TileEntityEliteChair.class, 1.0F, 5.0F, "blockBlackwoodChair");
		blockRedwoodChair 		= new BlockEliteChair(++blockID, TileEntityEliteChair.class, 1.0F, 5.0F, "blockRedwoodChair");
		blockGoldChair 			= new BlockEliteChair(++blockID, TileEntityEliteChair.class, 1.0F, 5.0F, "blockGoldChair");
		blockDiamondedChair 	= new BlockEliteChair(++blockID, TileEntityEliteChair.class, 1.5F, 10.0F, "blockDiamondedChair");		
		flagFillerBlock 		= new FillerBlock(++blockID, Material.cloth);
		
		blockWoodTable = new BlockTable(++blockID, 0.5F, 5.0F, "blockWoodTable", TileEntityTable.MODEL_TABLE);
        blockIronTable = new BlockTable(++blockID, 1.5F, 10.0F, "blockIronTable", TileEntityTable.MODEL_TABLE);
        blockStoneTable = new BlockTable(++blockID, 2.0F, 10.0F, "blockStoneTable", TileEntityTable.MODEL_TABLE);
        blockBlackwoodTable = new BlockTable(++blockID, 1.0F, 6.0F, "blockBlackwoodTable", TileEntityTable.MODEL_TABLE);
        blockRedwoodTable = new BlockTable(++blockID, 1.0F, 6.0F, "blockRedwoodTable", TileEntityTable.MODEL_TABLE);
        
        blockCabinetBlackwoodTable = new BlockTable(++blockID, 1.0F, 6.0F, "blockCabinetBlackwoodTable", TileEntityTable.MODEL_CABINET);
        blockCabinetRedwoodTable = new BlockTable(++blockID, 1.0F, 6.0F, "blockCabinetRedwoodTable", TileEntityTable.MODEL_CABINET);
        
        blockDinnerWoodTable = new BlockTable(++blockID, 0.5F, 2.0F, "blockDinnerWoodTable", TileEntityTable.MODEL_DINNER);
        
        blockBones = new BlockBones(++blockID);
        
        flagFillerBlock.setBlockBounds(0.1F, 0.0F, 0.1F, 0.1F, 1.0F, 0.1F);
        
        blockFlag 			= new BlockFlag(++blockID, TileEntityFlag.class, 0.5f, 1.0f, "blockNeutralFlag", 0, flagFillerBlock);
		blockMedivalFlag 	= new BlockFlag(++blockID, TileEntityFlag.class, 0.5f, 1.0f, "blockMedivalFlag", 1, flagFillerBlock);
	    blockTechnoFlag 	= new BlockFlag(++blockID, TileEntityFlag.class, 0.5f, 1.0f, "blockTechnoFlag", 2, flagFillerBlock);	
        
        blockBarbedWire = new BlockBarbedWire(++blockID);
        blockLockedChest = new BlockLockedChest(++blockID, "blockLockedChest");
        blockGrinder = new BlockGrinder(++blockID);
        
        proxy.prepareBlock(blockLockedChest, 
				"������ � ������", 
				"Locked chest");
        proxy.prepareBlock(blockBarbedWire, 
				"�����", 
				"Barbed Wire");
        
        proxy.prepareBlock(blockGrinder, 
				"��������", 
				"Grinder");
        
        proxy.prepareBlock(blockBones, 
				"����� ������", 
				"Some bones and Skull");
		
        proxy.prepareBlock(blockWoodTable, 
				"������� ���������� ����", 
				"Wood Table");
        proxy.prepareBlock(blockIronTable, 
        		"������� �������� ����", 
        		"Iron Table");
        proxy.prepareBlock(blockStoneTable, 
        		"������� �������� ����", 
        		"Stone Table");
        proxy.prepareBlock(blockBlackwoodTable, 
        		"���� �� ������� ������� ������", 
        		"Blackwood Table");
        proxy.prepareBlock(blockRedwoodTable, 
        		"���� �� ������� �������� ������", 
        		"Redwood Table");
        proxy.prepareBlock(blockCabinetBlackwoodTable, 
        		"���������� ���� �� ������� ������", 
        		"Cabinet Blackwood Table");
        proxy.prepareBlock(blockCabinetRedwoodTable, 
        		"���������� ���� �� �������� ������", 
        		"Cabinet Redwood Table");
        proxy.prepareBlock(blockDinnerWoodTable, 
        		"������� ��������� ����", 
        		"Dinner Table");
		
		
		
		    
	    
		proxy.prepareBlock(blockWoodChair, 
				"������� ���������� ����", 
				"Plain Wood Chair");
		proxy.prepareBlock(blockWhiteCottonChair, 
				"������� ���������� ���� � ����� ��������",
				"Plain Wood Chair with white");
		proxy.prepareBlock(blockBlueCottonChair,
				"������� ���������� ���� � ����� ��������",
				"Plain Wood Chair with blue");
		proxy.prepareBlock(blockRedCottonChair,
				"������� ���������� ���� � ������� ��������",
				"Plain Wood Chair with red");
		proxy.prepareBlock(blockBlackCottonChair,
				"������� ���������� ���� � ������ ��������",
				"Plain Wood Chair with black");
		proxy.prepareBlock(blockLeatherChair,
				"������� ���������� ����, ��������� �����",
				"Plain Wood Chair with leather");
		proxy.prepareBlock(blockIronChair, 
				"������� �������� ����",
				"Plain Iron Chair");
		proxy.prepareBlock(blockBlackwoodChair, 
				"���� �� ������� ������� ������",
				"Blackwood chair");
		proxy.prepareBlock(blockRedwoodChair, 
				"���� �� ������� �������� ������",
				"Redwood chair");
		proxy.prepareBlock(blockGoldChair, 
				"������� ����",
				"Gold chair");
		proxy.prepareBlock(blockDiamondedChair, 
				"���������������� �������� ����",
				"Diamonded Chair");
		
		proxy.prepareBlock(blockFlag, 
				"����������� ����",
				"Neutral Flag");
		proxy.prepareBlock(blockMedivalFlag, 
				"���� �������",
				"Medival Flag");
		proxy.prepareBlock(blockTechnoFlag, 
				"���� �����������",
				"Technocrat's Flag");
		proxy.prepareBlock(flagFillerBlock, 
				"",
				"");
		
		GameRegistry.registerTileEntity(TileEntityChair.class, "ulmcTileEntityChair");
		GameRegistry.registerTileEntity(TileEntityEliteChair.class, "ulmcTileEntityEliteChair");
		GameRegistry.registerTileEntity(TileEntityFlag.class, "ulmcTileEntityFlag");
		GameRegistry.registerTileEntity(FillerTileEntity.class, "ulmcFillerTileEntity");
		GameRegistry.registerTileEntity(TileEntityTable.class, "ulmcTileEntityTable");
		GameRegistry.registerTileEntity(TileEntityBones.class, "ulmcTileEntityBones");
		GameRegistry.registerTileEntity(TileEntityLockedChest.class, "ulmcTileEntityLockedChest");
		GameRegistry.registerTileEntity(TileEntityGrinder.class, "ulmcTileEntityGrinder");
	}
	
	private static void setHarvestTool(Block block, String tool, int level) {
		MinecraftForge.setBlockHarvestLevel(block, tool, level);
	}
	
}
