package ru.ulmc.ulex;

import java.util.logging.Level;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Configuration;
import ru.ulmc.ulex.CommonProxy;

@Mod(modid = "UltimateExtender", name = "Ultimate Extender", version = "In-Dev 1.3")
@NetworkMod(
        channels = { "UltimateExtender" },
        clientSideRequired = true,
        serverSideRequired = false,
        packetHandler = PacketManager.class)
public class UltimateExtender
{
	// Константы и переменные декларирую в конце файла.
    @Instance
    public static UltimateExtender instance;
    @SidedProxy(clientSide = "ru.ulmc.ulex.ClientProxy", serverSide = "ru.ulmc.ulex.CommonProxy")
    public static CommonProxy proxy;
    
	
    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
        // Loading in Configuration Data
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        proxy.preInit(); //You have to call the methods in your proxy class
        try
        {
            cfg.load();
            // Load Block IDs
            blockBonesID = cfg.getOrCreateBlockIdProperty("Bones", ++blockID).getInt(blockID);
            blockReinforcedConcreteID =  cfg.getOrCreateBlockIdProperty("Reinforced Concrete", ++blockID).getInt(blockID);
            blockSceletonChestID = cfg.getOrCreateBlockIdProperty("SceletonChest", ++blockID).getInt(blockID);
            blockMarbleID = cfg.getOrCreateBlockIdProperty("Marble", ++blockID).getInt(blockID);
            blockWoodChairID = cfg.getOrCreateBlockIdProperty("Chair", ++blockID).getInt(blockID);
        	blockWhiteCottonChairID = cfg.getOrCreateBlockIdProperty("Chair0", ++blockID).getInt(blockID);
        	blockBlueCottonChairID = cfg.getOrCreateBlockIdProperty("Chair1", ++blockID).getInt(blockID);
        	blockBlackCottonChairID = cfg.getOrCreateBlockIdProperty("Chair2", ++blockID).getInt(blockID);
        	blockLeatherChairID = cfg.getOrCreateBlockIdProperty("Chair3", ++blockID).getInt(blockID);
        	blockIronChairID = cfg.getOrCreateBlockIdProperty("Chair5", ++blockID).getInt(blockID);
        	blockRedCottonChairID = cfg.getOrCreateBlockIdProperty("Chair6", ++blockID).getInt(blockID);
        	blockBlackwoodChairID = cfg.getOrCreateBlockIdProperty("Chair7", ++blockID).getInt(blockID);
            blockRedwoodChairID = cfg.getOrCreateBlockIdProperty("Chair8", ++blockID).getInt(blockID);
            blockGoldChairID = cfg.getOrCreateBlockIdProperty("Chair9", ++blockID).getInt(blockID);
            blockDiamondedChairID = cfg.getOrCreateBlockIdProperty("Chair10", ++blockID).getInt(blockID);
            
        	blockWoodTableID = cfg.getOrCreateBlockIdProperty("table1", ++blockID).getInt(blockID);
        	blockIronTableID = cfg.getOrCreateBlockIdProperty("table2", ++blockID).getInt(blockID);
        	blockStoneTableID = cfg.getOrCreateBlockIdProperty("table3", ++blockID).getInt(blockID);
        	blockBlackwoodTableID = cfg.getOrCreateBlockIdProperty("table4", ++blockID).getInt(blockID);
        	blockRedwoodTableID  = cfg.getOrCreateBlockIdProperty("table5", ++blockID).getInt(blockID);
        	blockCabinetBlackwoodTableID = cfg.getOrCreateBlockIdProperty("table6", ++blockID).getInt(blockID);
        	blockCabinetRedwoodTableID = cfg.getOrCreateBlockIdProperty("table7", ++blockID).getInt(blockID);
        	blockDinnerWoodTableID = cfg.getOrCreateBlockIdProperty("table8", ++blockID).getInt(blockID);
        	
        	blockBlackCrystalID = cfg.getOrCreateBlockIdProperty("Crystal0", ++blockID).getInt(blockID);
        	blockWhiteCrystalID = cfg.getOrCreateBlockIdProperty("Crystal2", ++blockID).getInt(blockID);
        	blockElectroCrystalID = cfg.getOrCreateBlockIdProperty("Crystal3", ++blockID).getInt(blockID);
        	blockRedCrystalID = cfg.getOrCreateBlockIdProperty("Crystal4", ++blockID).getInt(blockID);
        	blockBlueCrystalID = cfg.getOrCreateBlockIdProperty("Crystal5", ++blockID).getInt(blockID);
         	blockSaltID = cfg.getOrCreateBlockIdProperty("Saltblock0", ++blockID).getInt(blockID);
         	blockFlagMedivalID = cfg.getOrCreateBlockIdProperty("MedivalFlags", ++blockID).getInt(blockID);
        	blockFlagTechnoID = cfg.getOrCreateBlockIdProperty("Techno Flags", ++blockID).getInt(blockID);
        	blockFlagID = cfg.getOrCreateBlockIdProperty("Neutral Flags", ++blockID).getInt(blockID);
        	
        	blockGreaseID = cfg.getOrCreateBlockIdProperty("ReservedID1", ++blockID).getInt(blockID);
        	blockReservedID02 = cfg.getOrCreateBlockIdProperty("ReservedID2", ++blockID).getInt(blockID);
        	blockReservedID03 = cfg.getOrCreateBlockIdProperty("ReservedID3", ++blockID).getInt(blockID);
        	blockReservedID04 = cfg.getOrCreateBlockIdProperty("ReservedID4", ++blockID).getInt(blockID);
        	blockReservedID05 = cfg.getOrCreateBlockIdProperty("ReservedID5", ++blockID).getInt(blockID);
        	blockReservedID06 = cfg.getOrCreateBlockIdProperty("ReservedID6", ++blockID).getInt(blockID);
        	blockReservedID07 = cfg.getOrCreateBlockIdProperty("ReservedID7", ++blockID).getInt(blockID);
        	blockReservedID08 = cfg.getOrCreateBlockIdProperty("ReservedID8", ++blockID).getInt(blockID);
        	blockReservedID09 = cfg.getOrCreateBlockIdProperty("ReservedID9", ++blockID).getInt(blockID);
        	blockReservedID10 = cfg.getOrCreateBlockIdProperty("ReservedID10", ++blockID).getInt(blockID);
        	blockReservedID11 = cfg.getOrCreateBlockIdProperty("ReservedID11", ++blockID).getInt(blockID);
        	blockReservedID12 = cfg.getOrCreateBlockIdProperty("ReservedID12", ++blockID).getInt(blockID);
        	blockReservedID13 = cfg.getOrCreateBlockIdProperty("ReservedID13", ++blockID).getInt(blockID);
        	blockReservedID14 = cfg.getOrCreateBlockIdProperty("ReservedID14", ++blockID).getInt(blockID);
        	blockReservedID15 = cfg.getOrCreateBlockIdProperty("ReservedID15", ++blockID).getInt(blockID);
        	blockReservedID16 = cfg.getOrCreateBlockIdProperty("ReservedID16", ++blockID).getInt(blockID);
        	blockReservedID17 = cfg.getOrCreateBlockIdProperty("ReservedID17", ++blockID).getInt(blockID);
        	blockReservedID18 = cfg.getOrCreateBlockIdProperty("ReservedID18", ++blockID).getInt(blockID);
        	blockReservedID19 = cfg.getOrCreateBlockIdProperty("ReservedID19", ++blockID).getInt(blockID);
        	blockReservedID20 = cfg.getOrCreateBlockIdProperty("ReservedID20", ++blockID).getInt(blockID);
        	// metablocks
        	blockObsidianBricksID = cfg.getOrCreateBlockIdProperty("ulmc Obsidian Bricks", ++metaBlockID).getInt(metaBlockID);
        	//ItemblocksIDs
            itemObsidianBricksID =  blockObsidianBricksID-256;
        	// Load Item IDs NOT! Or do I?
        	itemSkullID = cfg.getOrCreateIntProperty("Skull-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemNailsID = cfg.getOrCreateIntProperty("Nails-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemLeatherStrapID = cfg.getOrCreateIntProperty("LeatherStrap-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemLeatherCorsetID = cfg.getOrCreateIntProperty("LeatherCorset-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemSpoolID = cfg.getOrCreateIntProperty("Spool-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemFabricStrapID = cfg.getOrCreateIntProperty("FabricStrap-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemFabricRollID = cfg.getOrCreateIntProperty("FabricRoll-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemDiamondDustID = cfg.getOrCreateIntProperty("DiamondDust-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemGoldDustID = cfg.getOrCreateIntProperty("GoldDust-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemObsidianBrickID = cfg.getOrCreateIntProperty("ObsidianBrick-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemObsidianAlloyBlankID = cfg.getOrCreateIntProperty("ObsidianAlloyBlank-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemObsidianAlloyIngotID = cfg.getOrCreateIntProperty("ObsidianAlloyIngot-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemCementSackID = cfg.getOrCreateIntProperty("CementSackID1", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemCementMixID = cfg.getOrCreateIntProperty("CementMix-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemWoodBoxID = cfg.getOrCreateIntProperty("WoodBox-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemExplosiveStickID = cfg.getOrCreateIntProperty("ExplosiveStick-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemJerkedBeefID = cfg.getOrCreateIntProperty("JerkedBeef-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemJerkedPorkID = cfg.getOrCreateIntProperty("JerkedPork-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemLambRawMeatID = cfg.getOrCreateIntProperty("LambRawMeat-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemLambFriedID = cfg.getOrCreateIntProperty("LambFried-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemJerkedLambID = cfg.getOrCreateIntProperty("JerkedLamb-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemPowderMixID = cfg.getOrCreateIntProperty("PowderMix-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemCoalDustID = cfg.getOrCreateIntProperty("CoalDust-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemWoodPlankID = cfg.getOrCreateIntProperty("WoodPlank-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemPorkBellyID = cfg.getOrCreateIntProperty("PorkBelly-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemSaloID = cfg.getOrCreateIntProperty("Salo-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemGreaseID = cfg.getOrCreateIntProperty("Grease-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemOilID = cfg.getOrCreateIntProperty("Oil-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemWoodBarrelID = cfg.getOrCreateIntProperty("WoodBarrel-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemFlourID = cfg.getOrCreateIntProperty("Flour-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemDoughID = cfg.getOrCreateIntProperty("Dough-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemIronStripeID = cfg.getOrCreateIntProperty("IronStripe-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemSaltID = cfg.getOrCreateIntProperty("Salt-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemFlagID = cfg.getOrCreateIntProperty("Flag-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemWoodChairID = cfg.getOrCreateIntProperty("WoodChair-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemWhiteCottonChairID = cfg.getOrCreateIntProperty("WhiteCottonChair-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemRedCottonChairID = cfg.getOrCreateIntProperty("RedCottonChair-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemBlueCottonChairID = cfg.getOrCreateIntProperty("BlueCottonChair-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemBlackCottonChairID = cfg.getOrCreateIntProperty("BlackCottonChair-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
        	itemLeatherChairID = cfg.getOrCreateIntProperty("LeatherChair-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemIronChairID = cfg.getOrCreateIntProperty("IronChair-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemBlackwoodChairID = cfg.getOrCreateIntProperty("BlackwoodChair-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemRedwoodChairID = cfg.getOrCreateIntProperty("RedwoodChair-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID); 
            itemGoldChairID = cfg.getOrCreateIntProperty("GoldChair-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemDiamondedChairID = cfg.getOrCreateIntProperty("DiamondedChair-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemWoodTableID = cfg.getOrCreateIntProperty("WoodTable-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemIronTableID = cfg.getOrCreateIntProperty("IronTable-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemStoneTableID = cfg.getOrCreateIntProperty("StoneTable-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemBlackwoodTableID = cfg.getOrCreateIntProperty("BlackwoodTable-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemRedwoodTableID = cfg.getOrCreateIntProperty("RedwoodTable-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemCabinetBlackwoodTableID = cfg.getOrCreateIntProperty("CabinetBlackwoodTable-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemCabinetRedwoodTableID = cfg.getOrCreateIntProperty("CabinetRedwoodTable-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemDinnerWoodTableID = cfg.getOrCreateIntProperty("DinnerWoodTable-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemBlackCrystalID = cfg.getOrCreateIntProperty("1itemBlackCrystal-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemWhiteCrystalID = cfg.getOrCreateIntProperty("2itemWhiteCrystal-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemElectroCrystalID = cfg.getOrCreateIntProperty("3itemElectroCrystalID1", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemRedCrystalID = cfg.getOrCreateIntProperty("4itemRedCrystal-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemBlueCrystalID = cfg.getOrCreateIntProperty("BlueCrystal-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemFlagMedivalID = cfg.getOrCreateIntProperty("FlagMedival-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemFlagTechnoID = cfg.getOrCreateIntProperty("FlagTechno-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemFlagID = cfg.getOrCreateIntProperty("Flag-ulmc", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            
            itemGoldSpoolID = cfg.getOrCreateIntProperty("itemGoldSpoolID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemDiamondSpoolID = cfg.getOrCreateIntProperty("itemDiamondSpoolID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemGoldFabricStrapID = cfg.getOrCreateIntProperty("itemGoldFabricStrapID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemDiamondFabricStrapID = cfg.getOrCreateIntProperty("itemDiamondFabricStrap", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemGoldFabricRollID = cfg.getOrCreateIntProperty("itemGoldFabricRoll", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemDiamondFabricRollID = cfg.getOrCreateIntProperty("itemDiamondFabricRoll", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemChevronID = cfg.getOrCreateIntProperty("itemChevronID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemChevronWithGoldThreadID = cfg.getOrCreateIntProperty("itemChevronWithGoldThreadID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemChevronWithDiamondThreadID = cfg.getOrCreateIntProperty("itemChevronWithDiamondThreadID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemGoldChevronWithGoldThreadID = cfg.getOrCreateIntProperty("itemGoldChevronWithGoldThreadID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemDiamondChevronWithDiamondThreadID = cfg.getOrCreateIntProperty("itemDiamondChevronWithDiamondThreadID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemDiamondChevronWithGoldThreadID = cfg.getOrCreateIntProperty("itemDiamondChevronWithGoldThreadID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemGoldChevronWithDiamondThreadID = cfg.getOrCreateIntProperty("itemGoldChevronWithDiamondThreadID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemMedivalSymbolID = cfg.getOrCreateIntProperty("itemMedivalSymbolID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemTechnoSymbolID = cfg.getOrCreateIntProperty("itemTechnoSymbolID", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID16 = cfg.getOrCreateIntProperty("itemReservedID17", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID17 = cfg.getOrCreateIntProperty("itemReservedID18", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID18 = cfg.getOrCreateIntProperty("itemReservedID19", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID19 = cfg.getOrCreateIntProperty("itemReservedID20", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID20 = cfg.getOrCreateIntProperty("itemReservedID21", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID21 = cfg.getOrCreateIntProperty("itemReservedID22", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID22 = cfg.getOrCreateIntProperty("itemReservedID23", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID23 = cfg.getOrCreateIntProperty("itemReservedID24", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID24 = cfg.getOrCreateIntProperty("itemReservedID25", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID25 = cfg.getOrCreateIntProperty("itemReservedID26", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID26 = cfg.getOrCreateIntProperty("itemReservedID27", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID27 = cfg.getOrCreateIntProperty("itemReservedID28", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID28 = cfg.getOrCreateIntProperty("itemReservedID29", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID29 = cfg.getOrCreateIntProperty("itemReservedID30", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID30 = cfg.getOrCreateIntProperty("itemReservedID31", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID31 = cfg.getOrCreateIntProperty("itemReservedID32", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID32 = cfg.getOrCreateIntProperty("itemReservedID33", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID33 = cfg.getOrCreateIntProperty("itemReservedID34", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID34 = cfg.getOrCreateIntProperty("itemReservedID35", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID35 = cfg.getOrCreateIntProperty("itemReservedID36", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID36 = cfg.getOrCreateIntProperty("itemReservedID37", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID37 = cfg.getOrCreateIntProperty("itemReservedID38", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID38 = cfg.getOrCreateIntProperty("itemReservedID39", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID39 = cfg.getOrCreateIntProperty("itemReservedID40", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            itemReservedID40 = cfg.getOrCreateIntProperty("itemReservedID41", Configuration.CATEGORY_ITEM, ++itemID).getInt(itemID);
            
        
        }
        catch (Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "UltimateExtender's configuration failed to load.");
        }
        finally
        {
            cfg.save();
        }
    }

    @Init
    public void init(FMLInitializationEvent evt)
    {
       /*
        *  План действий по созданию блока:
        * 0. Объявляем блок внизу страницы вместе с другими.  
        * 1. Объявляем переменную ID блока и получем её в методе preInit();
        * 2. Инициируем и вызываем необходимые методы в методе blockForge()
        * 3. При необходимости регистрировать TileEntity в конце этого метода.
        * 4. регистрировать рецепты вметоде recipeForge();
        * План действий по созданию предмета:
        * 0. Объявляем блок внизу страницы вместе с другими.
        * 1. Объявляем переменную ID предмета и получем её в методе preInit();
        * 2. Инициируем и вызываем необходимые методы в методе itemForge()
        * 3. При необходимости регистрировать TileEntity в конце этого метода.
        * 4. регистрировать рецепты вметоде recipeForge();
        * 
        * При регистрировании модели не забыть сопоставить с рендером в клиентском прокси!
        * В этом методе ничего менять и добавлять не нужно!
        * 
        */
       // финализируем регистрацией блоков и локализацией
    	blockForge();        
       //регистрируем итемы нашим методом.
    	itemForge();  
       //ну и наконец регистрируем рецептыши
    	postBlock();
    	recipeForge();
        
        // Register Rendering Information
    	setUpRegestry();
       
       proxy.registerTileEntitySpecialRenderer();

    }

    @PostInit
    public void postInit(FMLPostInitializationEvent evt)
    {
        // TODO: Add Post-Initialization code such as mod hooks
    }
 // Пусть не вводит в заблужение имя метода, но к Forge он не имеет отношения. 
    private void blockForge()
    {
        // Initialize Blocks !
    	//Simple blocks here
        blockReinforcedConcrete = new BlockReinforcedConcrete(blockReinforcedConcreteID);
        blockSkeletonChest = new BlockSkeletonChest(blockSceletonChestID);
        blockMarble = new BlockMarble(blockMarbleID);
        blockSalt = new BlockSalt(blockSaltID, 13);
        //Blocks with models!!!!11
        blockBones = new BlockBones(blockBonesID, TileEntityBones.class);
        blockFlag = new BlockFlag(blockFlagID, TileEntityFlag.class);
        blockMedivalFlag = new BlockFlag(blockFlagMedivalID, TileEntityFlag.class);
        blockTechnoFlag = new BlockFlag(blockFlagTechnoID, TileEntityFlag.class);
        
        //Furniture Blocks
        blockWoodChair = new BlockChair(blockWoodChairID, TileEntityChair.class, 0.5F, 3.0F, "BlockWoodChair");
        blockWiteCottonChair = new BlockChair(blockWhiteCottonChairID, TileEntityChair.class, 0.5F, 3.0F, "blockWiteCottonChair");
        blockBlueCottonChair = new BlockChair(blockBlueCottonChairID, TileEntityChair.class,  0.5F, 3.0F, "blockBlueCottonChair");
        blockRedCottonChair = new BlockChair(blockRedCottonChairID, TileEntityChair.class, 0.5F, 3.0F, "blockRedCottonChair");
        blockBlackCottonChair = new BlockChair(blockBlackCottonChairID, TileEntityChair.class, 0.5F, 3.0F, "blockBlackCottonChair");
        blockLeatherChair = new BlockChair(blockLeatherChairID, TileEntityChair.class, 1.5F, 5.0F, "blockLeatherChair");
        blockIronChair = new BlockChair(blockIronChairID, TileEntityChair.class, 1.5F, 8.0F, "blockIronChair");
        blockBlackwoodChair = new BlockEliteChair(blockBlackwoodChairID, TileEntityEliteChair.class,  1.0F, 5.0F, "blockBlackwoodChair");
        blockRedwoodChair = new BlockEliteChair(blockRedwoodChairID, TileEntityEliteChair.class, 1.0F, 5.0F, "blockRedwoodChair");
        blockGoldChair = new BlockEliteChair(blockGoldChairID, TileEntityEliteChair.class, 1.0F, 5.0F, "blockGoldChair");
        blockDiamondedChair = new BlockEliteChair(blockDiamondedChairID, TileEntityEliteChair.class, 1.5F, 10.0F, "blockDiamondedChair");
        
        blockWoodTable = new BlockTable(blockWoodTableID, TileEntityTable.class, 0.5F, 5.0F, "blockWoodTable");
        blockIronTable = new BlockTable(blockIronTableID, TileEntityTable.class, 1.5F, 10.0F, "blockIronTable");
        blockStoneTable = new BlockTable(blockStoneTableID, TileEntityTable.class, 2.0F, 10.0F, "blockStoneTable");
        blockBlackwoodTable = new BlockTable(blockBlackwoodTableID, TileEntityTable.class, 1.0F, 6.0F, "blockBlackwoodTable");
        blockRedwoodTable = new BlockTable(blockRedwoodTableID, TileEntityTable.class, 1.0F, 6.0F, "blockRedwoodTable") ;
        blockCabinetBlackwoodTable = new BlockTableCabinet(blockCabinetBlackwoodTableID, TileEntityTableCabinet.class, 1.0F, 6.0F, "blockCabinetBlackwoodTable");
        blockCabinetRedwoodTable = new BlockTableCabinet(blockCabinetRedwoodTableID, TileEntityTableCabinet.class, 1.0F, 6.0F, "blockCabinetRedwoodTable");
        blockDinnerWoodTable = new BlockTableDinner(blockDinnerWoodTableID, TileEntityTableDinner.class, 0.5F, 2.0F, "blockDinnerWoodTable");
        
        blockBlackCrystal = new BlockCrystal(blockBlackCrystalID,TileEntityCrystal.class, 1.5F, 30.0F, "blockBlackCrystal",8);
        blockWhiteCrystal = new BlockCrystal(blockWhiteCrystalID,TileEntityCrystal.class, 1.5F, 20.0F, "blockWhiteCrystal",9);
        blockElectroCrystal = new BlockCrystal(blockElectroCrystalID,TileEntityCrystal.class, 2.5F, 10.0F, "blockElectroCrystal",10);
        blockRedCrystal = new BlockCrystal(blockRedCrystalID,TileEntityCrystal.class, 1.5F, 20.0F, "blockRedCrystal",11);
        blockBlueCrystal = new BlockCrystal(blockBlueCrystalID,TileEntityCrystal.class, 1.5F, 20.0F, "blockBlueCrystal",12);
        
        blockObsidianBricks = new BlockObsidianBricks(blockObsidianBricksID);
        blockGrease = new BlockGrease(blockGreaseID);
        blockReserved02 = new BlockReserved(blockReservedID02, 1.5F, 20.0F, "Reserved2",12);
        blockReserved03 = new BlockReserved(blockReservedID03, 1.5F, 20.0F, "Reserved3",12);
        blockReserved04 = new BlockReserved(blockReservedID04, 1.5F, 20.0F, "Reserved4",12);
        blockReserved05 = new BlockReserved(blockReservedID05, 1.5F, 20.0F, "Reserved5",12);
        blockReserved06 = new BlockReserved(blockReservedID06, 1.5F, 20.0F, "Reserved6",12);
        blockReserved07 = new BlockReserved(blockReservedID07, 1.5F, 20.0F, "Reserved7",12);
        blockReserved08 = new BlockReserved(blockReservedID08, 1.5F, 20.0F, "Reserved8",12);
        blockReserved09 = new BlockReserved(blockReservedID09, 1.5F, 20.0F, "Reserved9",12);
        blockReserved10 = new BlockReserved(blockReservedID10, 1.5F, 20.0F, "Reserved10",12);
        blockReserved11 = new BlockReserved(blockReservedID11, 1.5F, 20.0F, "Reserved11",12);
        blockReserved12 = new BlockReserved(blockReservedID12, 1.5F, 20.0F, "Reserved12",12);
        blockReserved13 = new BlockReserved(blockReservedID13, 1.5F, 20.0F, "Reserved13",12);
        blockReserved14 = new BlockReserved(blockReservedID14, 1.5F, 20.0F, "Reserved14",12);
        blockReserved15 = new BlockReserved(blockReservedID15, 1.5F, 20.0F, "Reserved15",12);
        blockReserved16 = new BlockReserved(blockReservedID16, 1.5F, 20.0F, "Reserved16",12);
        blockReserved17 = new BlockReserved(blockReservedID17, 1.5F, 20.0F, "Reserved17",12);
        blockReserved18 = new BlockReserved(blockReservedID18, 1.5F, 20.0F, "Reserved18",12);
        blockReserved19 = new BlockReserved(blockReservedID19, 1.5F, 20.0F, "Reserved19",12);
        blockReserved20 = new BlockReserved(blockReservedID20, 1.5F, 20.0F, "Reserved20",12);


        //Add Localization Data
       	proxy.PrepareBlock(blockBones, "Груда костей", "Pile of bones", false);
       	proxy.PrepareBlock(blockReinforcedConcrete,"Железобетон", "Reinforced Concrete", true);
       	proxy.PrepareBlock(blockSkeletonChest,"Сундук Скелета", "Skeleton Chest", true);
       	proxy.PrepareBlock(blockMarble,"Белый Мрамор", "White Marble", true);
       	proxy.PrepareBlock(blockSalt,"Соль", "Salt", true);
       	
       	proxy.PrepareBlock(blockWoodChair,"Простой деревянный стул", "Plain Wood Chair", false);
       	proxy.PrepareBlock(blockWiteCottonChair,"Простой деревянный стул с белой сидушкой", "Plain Wood Chair with white", false);
       	proxy.PrepareBlock(blockBlueCottonChair,"Простой деревянный стул с синей сидушкой", "Plain Wood Chair with blue", false);
       	proxy.PrepareBlock(blockRedCottonChair,"Простой деревянный стул с красной сидушкой", "Plain Wood Chair with red", false);
       	proxy.PrepareBlock(blockBlackCottonChair,"Простой деревянный стул с чёрной сидушкой", "Plain Wood Chair with black", false);
    	proxy.PrepareBlock(blockLeatherChair,"Простой деревянный стул, обтянутый кожей", "Plain Wood Chair with leather", false);
    	proxy.PrepareBlock(blockIronChair,"Простой железный стул", "Plain Iron Chair", false);
    	proxy.PrepareBlock(blockBlackwoodChair,"Простой железный стул", "Plain Iron Chair", false);
    	proxy.PrepareBlock(blockRedwoodChair,"Простой железный стул", "Plain Iron Chair", false);
    	proxy.PrepareBlock(blockGoldChair,"Простой железный стул", "Plain Iron Chair", false);
    	proxy.PrepareBlock(blockDiamondedChair,"Простой железный стул", "Plain Iron Chair", false);

    	proxy.PrepareBlock(blockBlackCrystal,"Чёрный кристалл", "Black Crystal", false);
    	proxy.PrepareBlock(blockWhiteCrystal,"Белый кристалл", "White Crystal", false);
    	proxy.PrepareBlock(blockElectroCrystal,"Солевой кристалл", "Salt Crystal", false);
    	proxy.PrepareBlock(blockRedCrystal,"Красный кристалл", "Red Crystal", false);
    	proxy.PrepareBlock(blockBlueCrystal,"Синий кристалл", "Blue Crystal", false);
    	
    	proxy.PrepareBlock(blockTechnoFlag,"Флаг технократов", "Blue Crystal", false);
    	proxy.PrepareBlock(blockFlag,"Флаг медивалов", "Blue Crystal", false);
    	proxy.PrepareBlock(blockMedivalFlag,"Флаг нейтралов", "Blue Crystal", false);
    	
    	proxy.PrepareBlock(blockObsidianBricks,"Обсидиановая кладка", "Obsidian Bricks", true);
    	proxy.PrepareBlock(blockGrease,"Разлитый жир", "Spoiled Grease", false);
    	proxy.PrepareBlock(blockReserved02,"blockReservedRu2", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved03,"blockReservedRu3", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved04,"blockReservedRu4", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved05,"blockReservedRu5", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved06,"blockReservedRu6", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved07,"blockReservedRu7", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved08,"blockReservedRu8", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved09,"blockReservedRu9", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved10,"blockReservedRu10", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved11,"blockReservedRu11", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved12,"blockReservedRu12", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved13,"blockReservedRu13", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved14,"blockReservedRu14", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved15,"blockReservedRu14", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved16,"blockReservedRu16", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved17,"blockReservedRu", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved18,"blockReservedRu", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved19,"blockReservedRu", "blockEnReserved", false);
    	proxy.PrepareBlock(blockReserved20,"blockReservedRu", "blockEnReserved", false);
    	
    }
    // метод для передачи данных блокам, после индентификации предметов. Необязательно реализовывать так. Это мой подход.
    private void postBlock()
    {
        // Специфический метод для передачи данных об итеме, который мы будем дропать
        blockWoodChair.setIDs(itemWoodChair);
        blockWiteCottonChair.setIDs(itemWhiteCottonChair);
        blockBlueCottonChair.setIDs(itemBlueCottonChair);
        blockRedCottonChair.setIDs(itemRedCottonChair);
        blockBlackCottonChair.setIDs(itemBlackCottonChair);
        blockLeatherChair.setIDs(itemLeatherChair);
        blockIronChair.setIDs(itemIronChair);
        blockBlackwoodChair.setIDs(itemBlackwoodChair);
        blockRedwoodChair.setIDs(itemRedwoodChair);
        blockGoldChair.setIDs(itemGoldChair);
        blockDiamondedChair.setIDs(itemDiamondedChair);
        
        blockWoodTable.setIDs(itemWoodTable);
        blockIronTable.setIDs(itemIronTable);
        blockStoneTable.setIDs(itemStoneTable);
        blockBlackwoodTable.setIDs(itemBlackwoodTable);
        blockRedwoodTable.setIDs(itemRedwoodTable);
        blockCabinetBlackwoodTable.setIDs(itemCabinetBlackwoodTable);
        blockCabinetRedwoodTable.setIDs(itemCabinetRedwoodTable);
        blockDinnerWoodTable.setIDs(itemDinnerWoodTable);
        
        blockBlackCrystal.setIDs(itemBlackCrystal);
        blockWhiteCrystal.setIDs(itemWhiteCrystal);
        blockElectroCrystal.setIDs(itemElectroCrystal);
        blockRedCrystal.setIDs(itemRedCrystal);
        blockBlueCrystal.setIDs(itemBlueCrystal);
        
        blockMedivalFlag.setValue(itemMedivalFlag, (byte) 1);
        blockFlag.setValue(itemFlag, (byte) 0);
        blockTechnoFlag.setValue(itemTechnoFlag, (byte) 2);
        
        blockWoodTable.setTextureAndIndex("/texture.png", 4);
        blockIronTable.setTextureAndIndex("/texture.png", 22);
        blockStoneTable.setTextureAndIndex("/texture.png", 6);
        blockBlackwoodTable.setTextureAndIndex(Params.TEXTURE_PATH_BLOCKS, 6);
        blockRedwoodTable.setTextureAndIndex(Params.TEXTURE_PATH_BLOCKS, 7);
        blockCabinetBlackwoodTable.setTextureAndIndex(Params.TEXTURE_PATH_BLOCKS, 6);
        blockCabinetRedwoodTable.setTextureAndIndex(Params.TEXTURE_PATH_BLOCKS, 7);
        blockDinnerWoodTable.setTextureAndIndex("/texture.png", 4);
        
    }
    private void itemForge()
    {
        //Initialize Items part 1
        itemSkull = new ItemSkull(itemSkullID, blockBones);
        	proxy.CreateItem(itemSkull, textureID, "Skull", "Череп", "Skull", true);
        itemNails = new ItemNails(itemNailsID);        
        	proxy.CreateItem(itemNails, ++textureID, "Nails", "Гвозди", "Nails", true);
        itemLeatherStrap = new ItemLeatherStrap(itemLeatherStrapID);
        	proxy.CreateItem(itemLeatherStrap, ++textureID, "Leather Straps", "Кожаные лоскуты", "Leather Straps", true);
        itemLeatherCorset = new ItemLeatherCorset(itemLeatherCorsetID); 
        	proxy.CreateItem(itemLeatherCorset, ++textureID, "Leather corset", "Кожаный корсет", "Leather corset", true);
        itemSpool = new ItemSpool(itemSpoolID);
        	proxy.CreateItem(itemSpool, ++textureID, "Spool", "Моток ниток", "Spool", true);
        itemFabricStrap = new ItemFabricStrap(itemFabricStrapID);
        	proxy.CreateItem(itemFabricStrap, ++textureID, "FabricStrap", "Лоскут ткани", "Fabric Strap", true);
        itemFabricRoll = new ItemFabricRoll(itemFabricRollID);
        	proxy.CreateItem(itemFabricRoll, ++textureID, "FabricRoll", "Рулон ткани", "Fabric Roll", true);
        itemDiamondDust = new ItemDiamondDust(itemDiamondDustID);
        	proxy.CreateItem(itemDiamondDust, ++textureID, "DiamondDust", "Алмазная пыль", "Diamond Dust", true);
        itemGoldDust = new ItemGoldDust(itemGoldDustID);
        	proxy.CreateItem(itemGoldDust, ++textureID, "GoldDust", "Золотая пыль", "Gold Dust", true);
        itemObsidianBrick = new ItemObsidianBrick(itemObsidianBrickID);
        	proxy.CreateItem(itemObsidianBrick, ++textureID, "ObsidianBrick", "Обсидиановый кирпич", "Obsidian Brick", true);
        itemObsidianAlloyBlank = new ItemObsidianAlloyBlank(itemObsidianAlloyBlankID);
        	proxy.CreateItem(itemObsidianAlloyBlank, ++textureID, "ObsidianAlloyBlank", "Заготовка сплава обсидиана", "Obsidian Alloy Blank", true);
        itemObsidianAlloyIngot = new ItemObsidianAlloyIngot(itemObsidianAlloyIngotID);
        	proxy.CreateItem(itemObsidianAlloyIngot, ++textureID, "ObsidianAlloyIngot", "Слиток обсидианого сплава", "Obsidian Alloy Ingot", true);
        itemElectroCrystal = new ItemCrystal(itemElectroCrystalID, blockElectroCrystal, 3);
        	proxy.CreateItem(itemElectroCrystal, ++textureID, "ElectroCrystal", "Солевой кристалл", "Salt Crystal", true);
        itemCementSack = new ItemCementSack(itemCementSackID);
        	proxy.CreateItem(itemCementSack, ++textureID, "CementSack", "Мешок цемента", "Cement Sack", true);
        itemCementMix = new ItemCementMix(itemCementMixID);
        	proxy.CreateItem(itemCementMix, ++textureID, "CementMix", "Цементная смесь", "Cement Mix", true);
        //part 2
        itemWoodBox = new ItemWoodBox(itemWoodBoxID);
        	proxy.CreateItem(itemWoodBox, ++textureID, "WoodBox", "Деревянный ящик", "Wood Box", true);
        itemExplosiveStick = new ItemExplosiveStick(itemExplosiveStickID);
        	proxy.CreateItem(itemExplosiveStick, ++textureID, "ExplosiveStick", "Шашка динамита", "Explosive Stick", true);
        itemJerkedBeef = new ItemJerkedBeef(itemJerkedBeefID, 6, 0.7F, true); 
        	proxy.CreateItem(itemJerkedBeef, ++textureID, "JerkedBeef", "Вяленая говядина", "Jerked Beef", true);
        itemJerkedPork = new ItemJerkedPork(itemJerkedPorkID, 6, 0.7F, true); 
        	proxy.CreateItem(itemJerkedPork, ++textureID, "JerkedPork", "Вяленая свинина", "Jerked Pork", true);
        itemLambRawMeat = new ItemLambRawMeat(itemLambRawMeatID, 3, 0.3F, true); 
       		proxy.CreateItem(itemLambRawMeat, ++textureID, "LambRawMeat", "Сырая баранина", "Lamb Raw Meat", true);
        itemLambFried = new ItemLambFried(itemLambFriedID, 8, 0.8F, true); 
        	proxy.CreateItem(itemLambFried, ++textureID, "LambFried", "Жареная баранина", "Lamb Fried", true);
        itemJerkedLamb = new ItemJerkedLamb(itemJerkedLambID, 6, 0.7F, true);
        	proxy.CreateItem(itemJerkedLamb, ++textureID, "JerkedLamb", "Вяленая баранина", "Jerked Lamb", true);
        itemPowderMix = new ItemPowderMix(itemPowderMixID);
        	proxy.CreateItem(itemPowderMix, ++textureID, "PowderMix", "Пороховая смесь", "Powder Mix", true);
        itemCoalDust = new ItemCoalDust(itemCoalDustID); 
        	proxy.CreateItem(itemCoalDust, ++textureID, "CoalDust", "Угольная пыль", "Coal Dust", true);
        itemWoodPlank = new ItemWoodPlank(itemWoodPlankID);
        	proxy.CreateItem(itemWoodPlank, ++textureID, "WoodPlank", "Деревянная доска", "Wood Plank", true);
        itemPorkBelly = new ItemPorkBelly(itemPorkBellyID, 1, 0.3F, true);
        	proxy.CreateItem(itemPorkBelly, ++textureID, "PorkBelly", "Свинной жир", "Pork Belly", true);
        itemSalo = new ItemSalo(itemSaloID, 4, 0.7F, true);
        	proxy.CreateItem(itemSalo, ++textureID, "Salo", "Сало", "Salo", true);
        itemGrease = new ItemGrease(itemGreaseID);
        	proxy.CreateItem(itemGrease, ++textureID, "Grease", "Жир", "Grease", true);
        itemOil = new ItemOil(itemOilID);
        	proxy.CreateItem(itemOil, ++textureID, "Oil", "Масло", "Oil", true);
        itemWoodBarrel = new ItemWoodBarrel(itemWoodBarrelID);
        	proxy.CreateItem(itemWoodBarrel, ++textureID, "WoodBarrel", "Деревянная бочка", "Wood Barrel", true);
        itemFlour = new ItemFlour(itemFlourID); 
       		proxy.CreateItem(itemFlour, ++textureID, "Flour", "Мука", "Flour", true);
        itemDough = new ItemDough(itemDoughID);
        	proxy.CreateItem(itemDough, ++textureID, "Dough", "Тесто", "Dough", true);
        itemIronStripe = new ItemIronStripe(itemIronStripeID);
        	proxy.CreateItem(itemIronStripe, ++textureID, "IronStripe", "Металлическая полоска", "Iron Stripe", true);
        itemSalt = new ItemSalt(itemSaltID);
        	proxy.CreateItem(itemSalt, ++textureID, "Salt", "Соль", "Salt", true);
        //part 3 furniture and other 3d model items
        itemWoodChair = new ItemChair(itemWoodChairID, blockWoodChair, 6);
        	proxy.CreateItem(itemWoodChair, ++textureID, "WoodChair", "Деревянный стул", "Wood Chair", true);
        itemWhiteCottonChair = new ItemChair(itemWhiteCottonChairID, blockWiteCottonChair, 1);
        	proxy.CreateItem(itemWhiteCottonChair, ++textureID, "whiteChair", "Деревянный стул с мягкой белой сидушкой", "Wood White Chair", true);
        itemBlueCottonChair = new ItemChair(itemRedCottonChairID, blockBlueCottonChair, 2);
        	proxy.CreateItem(itemBlueCottonChair, ++textureID, "blueChair", "Деревянный стул с мягкой синей сидушкой", "Wood Blue Chair", true);
        itemRedCottonChair = new ItemChair(itemBlueCottonChairID, blockRedCottonChair, 3);
        	proxy.CreateItem(itemRedCottonChair, ++textureID, "redChair", "Деревянный стул с мягкой красной сидушкой", "Wood Red Chair", true);
        itemBlackCottonChair = new ItemChair(itemBlackCottonChairID, blockBlackCottonChair, 4);
        	proxy.CreateItem(itemBlackCottonChair, ++textureID, "blackChair", "Деревянный стул с мягкой чёрной сидушкой", "Wood Black Chair", true);
        itemLeatherChair = new ItemChair(itemLeatherChairID, blockLeatherChair, 5);
        	proxy.CreateItem(itemLeatherChair, ++textureID, "leatherChair", "Обтянутый кожей деревянный стул", "Wood Leather Chair", true);
        itemIronChair = new ItemChair(itemIronChairID, blockIronChair, 7);
        	proxy.CreateItem(itemIronChair, ++textureID, "ironChair", "Металлический стул", "Iron Chair", true);
        itemBlackwoodChair = new ItemChair(itemBlackwoodChairID, blockBlackwoodChair, 1);
        	proxy.CreateItem(itemBlackwoodChair, ++textureID, "blackwoodChair", "Стул из черного дерева", "Blackwood Chair", true);
        itemRedwoodChair = new ItemChair(itemRedwoodChairID, blockRedwoodChair, 2);
        	proxy.CreateItem(itemRedwoodChair, ++textureID, "redwoodChair", "Стул из красного дерева", "Redwood Chair", true);
        itemGoldChair = new ItemChair(itemGoldChairID, blockGoldChair, 3);
        	proxy.CreateItem(itemGoldChair, ++textureID, "goldChair", "Золотой стул", "Gold Chair", true);
        itemDiamondedChair = new ItemChair(itemDiamondedChairID, blockDiamondedChair, 4);
        	proxy.CreateItem(itemDiamondedChair, ++textureID, "diamondedChair", "Инкрустированный алмазами стул", "Diamonded Chair", true);
        
        itemWoodTable = new ItemTable(itemWoodTableID, blockWoodTable, 1);
        	proxy.CreateItem(itemWoodTable, ++textureID, "WoodTable", "Барный столик", "Wood Table", true);
        itemIronTable = new ItemTable(itemIronTableID, blockIronTable, 2);
         	proxy.CreateItem(itemIronTable, ++textureID, "IronTable", "Железный столик", "Iron Table", true);
        itemStoneTable = new ItemTable(itemStoneTableID, blockStoneTable, 3);
         	proxy.CreateItem(itemStoneTable, ++textureID, "StoneTable", "Каменный стол", "Stone Table", true);
        itemBlackwoodTable = new ItemTable(itemBlackwoodTableID, blockBlackwoodTable, 4);
         	proxy.CreateItem(itemBlackwoodTable, ++textureID, "BlackwoodTable", "Стол из черного дерева", "Blackwood Table", true);
        itemRedwoodTable = new ItemTable(itemRedwoodTableID, blockRedwoodTable, 5);
         	proxy.CreateItem(itemRedwoodTable, ++textureID, "RedwoodTable", "ИСтол из красного дерева", "Redwood Table", true);
        itemCabinetBlackwoodTable = new ItemTable(itemCabinetBlackwoodTableID, blockCabinetBlackwoodTable, 1);
         	proxy.CreateItem(itemCabinetBlackwoodTable, ++textureID, "CabinetBlackwoodTable", "Кабинетный стол из черного дерева", "Cabinet blackwood Table", true);
        itemCabinetRedwoodTable = new ItemTable(itemCabinetRedwoodTableID, blockCabinetRedwoodTable, 2);
         	proxy.CreateItem(itemCabinetRedwoodTable, ++textureID, "CabinetRedwoodTable", "Кабинетный стол из красного дерева", "Cabinet redwood Table", true);
       	itemDinnerWoodTable = new ItemTable(itemDinnerWoodTableID, blockDinnerWoodTable, 1);
         	proxy.CreateItem(itemDinnerWoodTable, ++textureID, "DinnerWoodTable", "Обеденный стол", "Dinner Table", true);
         itemBlackCrystal = new ItemCrystal(itemBlackCrystalID, blockBlackCrystal, 1);
         	proxy.CreateItem(itemBlackCrystal, ++textureID, "itemBlackCrystal", "Черный Кристалл", "Black Crystal", true);
         itemWhiteCrystal= new ItemCrystal(itemWhiteCrystalID, blockWhiteCrystal, 2);
         	proxy.CreateItem(itemWhiteCrystal, ++textureID, "itemWhiteCrystal", "Белый Кристалл", "White Crystal", true);
         itemRedCrystal= new ItemCrystal(itemRedCrystalID, blockRedCrystal, 4);
         	proxy.CreateItem(itemRedCrystal, ++textureID, "itemRedCrystal", "Красный Кристалл", "Red Crystal", true);
         itemBlueCrystal= new ItemCrystal(itemBlueCrystalID, blockBlueCrystal, 5);
         	proxy.CreateItem(itemBlueCrystal, ++textureID, "itemBlueCrystal", "Синий Кристалл", "Blue Crystal", true);
			itemGoldSpool= new ItemFlagElement(itemGoldSpoolID);
         	proxy.CreateItem(itemGoldSpool, ++textureID, "GoldSpool", "Моток золотых ниток", "Golden Thread Spool", true);
			itemDiamondSpool= new ItemFlagElement(itemDiamondSpoolID);
         	proxy.CreateItem(itemDiamondSpool, ++textureID, "DiamondSpool", "Моток алмазных ниток", "Diamond Thread Spool", true);
			itemGoldFabricStrap= new ItemFlagElement(itemGoldFabricStrapID);
         	proxy.CreateItem(itemGoldFabricStrap, ++textureID, "GoldFabricStrap", "Лоскут золотой ткани", "Gold Fabric Strap", true);
			itemDiamondFabricStrap= new ItemFlagElement(itemDiamondFabricStrapID);
         	proxy.CreateItem(itemDiamondFabricStrap, ++textureID, "DiamondFabricStrap", "Лоскут алмазной ткани", "Diamond Fabric Strap", true);
			itemGoldFabricRoll= new ItemFlagElement(itemGoldFabricRollID);
         	proxy.CreateItem(itemGoldFabricRoll, ++textureID, "GoldFabricRoll", "Рулон золотой ткани", "Gold Fabric Roll", true);
			itemDiamondFabricRoll= new ItemFlagElement(itemDiamondFabricRollID);
         	proxy.CreateItem(itemDiamondFabricRoll, ++textureID, "DiamondFabricRoll", "Рулон алмазной ткани", "DiamondFabricRoll", true);
			itemChevron= new ItemFlagElement(itemChevronID);
         	proxy.CreateItem(itemChevron, ++textureID, "Chevron", "Нашивка", "Chevron", true);
			itemChevronWithGoldThread= new ItemFlagElement(itemChevronWithGoldThreadID);
         	proxy.CreateItem(itemChevronWithGoldThread, ++textureID, "ChevronWithGoldThread", "Нашивка с золотыми нитками", "Chevron With Gold Thread", true);
			itemChevronWithDiamondThread= new ItemFlagElement(itemChevronWithDiamondThreadID);
         	proxy.CreateItem(itemChevronWithDiamondThread, ++textureID, "ChevronWithDiamondThread", "Нашивка с алмазными нитками", "Сhevron With Diamond Thread", true);
			itemGoldChevronWithGoldThread= new ItemFlagElement(itemGoldChevronWithGoldThreadID);
         	proxy.CreateItem(itemGoldChevronWithGoldThread, ++textureID, "GoldChevronWithGoldThread", "Золотой шеврон с золотыми нитками", "Gold Chevron With Gold Thread", true);
			itemDiamondChevronWithDiamondThread= new ItemFlagElement(itemDiamondChevronWithDiamondThreadID);
         	proxy.CreateItem(itemDiamondChevronWithDiamondThread, ++textureID, "DiamondChevronWithDiamondThread", "Алмазный шеврон с алмазными нитками", "Diamond Chevron With Diamond Thread", true);
			itemDiamondChevronWithGoldThread= new ItemFlagElement(itemDiamondChevronWithGoldThreadID);
         	proxy.CreateItem(itemDiamondChevronWithGoldThread, ++textureID, "DiamondChevronWithGoldThread", "Алмазный шеврон с золотыми нитками", "Diamond Chevron With Gold Thread", true);
			itemGoldChevronWithDiamondThread= new ItemFlagElement(itemGoldChevronWithDiamondThreadID);
         	proxy.CreateItem(itemGoldChevronWithDiamondThread, ++textureID, "GoldChevronWithDiamondThread", "Золотой шеврон с алмазными нитками", "Gold Chevron With Diamond Thread", true);
			itemMedivalSymbol= new ItemFlagElement(itemMedivalSymbolID);
         	proxy.CreateItem(itemMedivalSymbol, ++textureID, "MedivalSymbol", "Символ Консерваторов", "Medival Symbol", true);
			itemTechnoSymbol= new ItemFlagElement(itemTechnoSymbolID);
         	proxy.CreateItem(itemTechnoSymbol, ++textureID, "TechnoSymbol", "Символ Технократов", "Techno Symbol", true);
			itemReserved16= new ItemReserved(itemReservedID16);
         	proxy.CreateItem(itemReserved16, ++textureID, "itemReserved16", "Резерв", "Reserved", false);
			itemReserved17= new ItemReserved(itemReservedID17);
         	proxy.CreateItem(itemReserved17, ++textureID, "itemReserved17", "Резерв", "Reserved", false);
			itemReserved18= new ItemReserved(itemReservedID18);
         	proxy.CreateItem(itemReserved18, ++textureID, "itemReserved18", "Резерв", "Reserved", false);
			itemReserved19= new ItemReserved(itemReservedID19);
         	proxy.CreateItem(itemReserved19, ++textureID, "itemReserved19", "Резерв", "Reserved", false);
			itemReserved20= new ItemReserved(itemReservedID20);
         	proxy.CreateItem(itemReserved20, ++textureID, "itemReserved20", "Резерв", "Reserved", false);
			itemReserved21= new ItemReserved(itemReservedID21);
         	proxy.CreateItem(itemReserved21, ++textureID, "itemReserved21", "Резерв", "Reserved", false);
			itemReserved22= new ItemReserved(itemReservedID22);
         	proxy.CreateItem(itemReserved22, ++textureID, "itemReserved22", "Резерв", "Reserved", false);
			itemReserved23= new ItemReserved(itemReservedID23);
         	proxy.CreateItem(itemReserved23, ++textureID, "itemReserved23", "Резерв", "Reserved", false);
			itemReserved24= new ItemReserved(itemReservedID24);
         	proxy.CreateItem(itemReserved24, ++textureID, "itemReserved24", "Резерв", "Reserved", false);
			itemReserved25= new ItemReserved(itemReservedID25);
         	proxy.CreateItem(itemReserved25, ++textureID, "itemReserved25", "Резерв", "Reserved", false);
			itemReserved26= new ItemReserved(itemReservedID26);
         	proxy.CreateItem(itemReserved26, ++textureID, "itemReserved26", "Резерв", "Reserved", false);
			itemReserved27= new ItemReserved(itemReservedID27);
         	proxy.CreateItem(itemReserved27, ++textureID, "itemReserved27", "Резерв", "Reserved", false);
			itemReserved28= new ItemReserved(itemReservedID28);
         	proxy.CreateItem(itemReserved28, ++textureID, "itemReserved28", "Резерв", "Reserved", false);
			itemReserved29= new ItemReserved(itemReservedID29);
         	proxy.CreateItem(itemReserved29, ++textureID, "itemReserved29", "Резерв", "Reserved", false);
			itemReserved30= new ItemReserved(itemReservedID30);
         	proxy.CreateItem(itemReserved30, ++textureID, "itemReserved30", "Резерв", "Reserved", false);
			itemReserved31= new ItemReserved(itemReservedID31);
         	proxy.CreateItem(itemReserved31, ++textureID, "itemReserved31", "Резерв", "Reserved", false);
			itemReserved32= new ItemReserved(itemReservedID32);
         	proxy.CreateItem(itemReserved32, ++textureID, "itemReserved32", "Резерв", "Reserved", false);
			itemReserved33= new ItemReserved(itemReservedID33);
         	proxy.CreateItem(itemReserved33, ++textureID, "itemReserved33", "Резерв", "Reserved", false);
			itemReserved34= new ItemReserved(itemReservedID34);
         	proxy.CreateItem(itemReserved34, ++textureID, "itemReserved34", "Резерв", "Reserved", false);
			itemReserved35= new ItemReserved(itemReservedID35);
         	proxy.CreateItem(itemReserved35, ++textureID, "itemReserved35", "Резерв", "Reserved", false);
			itemReserved36= new ItemReserved(itemReservedID36);
         	proxy.CreateItem(itemReserved36, ++textureID, "itemReserved36", "Резерв", "Reserved", false);
			itemReserved37= new ItemReserved(itemReservedID37);
         	proxy.CreateItem(itemReserved37, ++textureID, "itemReserved37", "Резерв", "Reserved", false);
			itemReserved38= new ItemReserved(itemReservedID38);
         	proxy.CreateItem(itemReserved38, ++textureID, "itemReserved38", "Резерв", "Reserved", false);
			itemReserved39= new ItemReserved(itemReservedID39);
         	proxy.CreateItem(itemReserved39, ++textureID, "itemReserved39", "Резерв", "Reserved", false);
			itemReserved40= new ItemReserved(itemReservedID40);
         	proxy.CreateItem(itemReserved40, ++textureID, "itemReserved40", "Резерв", "Reserved", false);
         //Флаги...
         String[] flagTechnoRu = UltimateHelper.getMetaItemNamesArray("Техно флаг ", 16);
         String[] flagTechnoEn = UltimateHelper.getMetaItemNamesArray("Technoflag ", 16);
         String[] flagMedivalRu = UltimateHelper.getMetaItemNamesArray("Медивал флаг ", 16);
         String[] flagMedivalEn = UltimateHelper.getMetaItemNamesArray("Medivalflag ", 16);
         String[] flagNeutralRu = UltimateHelper.getMetaItemNamesArray("Нейтральный флаг ", 16);
         String[] flagNeutralEn = UltimateHelper.getMetaItemNamesArray("Neutral Flag ", 16);
         itemFlag = new ItemFlag(itemFlagID, blockFlag);
        	proxy.CreateItem(itemFlag, metaTexturesID, "Flag", ItemFlag.flagNames,flagNeutralRu, flagNeutralEn, Params.TEXTURE_PATH_META_ITEMS);
        itemMedivalFlag = new ItemFlag(itemFlagMedivalID, blockMedivalFlag);
        metaTexturesID = metaTexturesID + 16;
        	proxy.CreateItem(itemMedivalFlag, metaTexturesID, "FlagM", ItemFlag.flagNames,flagMedivalRu, flagMedivalEn, Params.TEXTURE_PATH_META_ITEMS);
        itemTechnoFlag = new ItemFlag(itemFlagTechnoID, blockTechnoFlag);
        metaTexturesID = metaTexturesID + 16;
        	proxy.CreateItem(itemTechnoFlag, metaTexturesID, "FlagT", ItemFlag.flagNames,flagTechnoRu, flagTechnoEn, Params.TEXTURE_PATH_META_ITEMS);
        String[] ObsidianBricksRu = {"Обсидиановая кладка скреплённая кровью","Обсидиановая кладка скреплённая маслью"};
        String[] ObsidianBricksEn = {"Obsidian Bricks powered by blood","Obsidian Bricks Powered by mind"};
		itemObsidianBricks= new ItemObsidianBricks(itemObsidianBricksID, blockObsidianBricks);
         	proxy.CreateItem(itemObsidianBricks, 0, "ObsidianBricksi", BlockObsidianBricks.bricksType,ObsidianBricksRu, ObsidianBricksEn, Params.TEXTURE_PATH_BLOCKS);
    }	
    
    private void recipeForge()
    {
    	// Register Blocks Recipes
        GameRegistry.addRecipe(new ItemStack(blockBones, 1),
                " x ",
                "xyx",
                " x ",
                'x', Block.dirt, 'y', Block.wood
                              );
        GameRegistry.addRecipe(new ItemStack(blockReinforcedConcrete, 1),
                "xxx",
                "yyy",
                "xxx",
                'x', Block.fenceIron,
                'y', itemCementSack
                              );
        //Register Item's recipes
        GameRegistry.addRecipe(new ItemStack(itemSkull, 1),
                "xxx",
                'x', Item.bone
                              );
        GameRegistry.addRecipe(new ItemStack(itemNails, 4),
                "x",
                'x', Item.ingotIron
                              );
        GameRegistry.addRecipe(new ItemStack(itemLeatherStrap, 4),
                "x",
                'x', Item.leather
                              );
        GameRegistry.addRecipe(new ItemStack(itemLeatherCorset, 1),
                "x x",
                "xyx",
                "xyx",
                'x', itemLeatherStrap,
                'y', Item.silk
                              );
        GameRegistry.addShapelessRecipe(new ItemStack(itemSpool, 1),new Object[] { Item.silk,Item.silk,Item.silk});
        GameRegistry.addShapelessRecipe(new ItemStack(itemFabricStrap, 1), new Object[] {itemSpool,itemSpool,itemSpool});
        GameRegistry.addShapelessRecipe(new ItemStack(itemFabricRoll, 1), new Object[] { itemFabricStrap,itemFabricStrap,itemFabricStrap,itemFabricStrap,itemFabricStrap,itemFabricStrap});
        GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondDust, 2), new Object[] { Item.diamond});
        GameRegistry.addShapelessRecipe(new ItemStack(itemGoldDust, 4), new Object[] {Item.ingotGold,Item.ingotGold});
        GameRegistry.addShapelessRecipe(new ItemStack(itemObsidianAlloyBlank, 1), new Object[] {Item.ingotIron, itemObsidianBrick});
        GameRegistry.addShapelessRecipe(new ItemStack(itemObsidianBrick, 2),new Object[] {Block.obsidian});
        GameRegistry.addShapelessRecipe(new ItemStack(itemCoalDust, 4),new Object[] {Item.coal,Item.coal});
        //Соление.вяление
        GameRegistry.addShapelessRecipe(new ItemStack(itemJerkedBeef, 1), new Object[] {Item.beefRaw, itemSalt});
        GameRegistry.addShapelessRecipe(new ItemStack(itemJerkedPork, 1), new Object[] {Item.porkRaw, itemSalt});
        GameRegistry.addShapelessRecipe(new ItemStack(itemJerkedLamb, 1), new Object[] {itemLambRawMeat, itemSalt});
        GameRegistry.addShapelessRecipe(new ItemStack(itemSalo, 1), new Object[] {itemPorkBelly, itemSalt});
        GameRegistry.addShapelessRecipe(new ItemStack(itemSalt, 2), new Object[] {itemElectroCrystal});
        
        GameRegistry.addShapelessRecipe(new ItemStack(itemWoodPlank, 8), new Object[] {Block.wood});
        GameRegistry.addShapelessRecipe(new ItemStack(itemFlour, 1), new Object[] {Item.wheat,Item.wheat,Item.wheat,Item.wheat,Item.wheat,Item.wheat,Item.wheat,Item.wheat,Item.wheat});
        GameRegistry.addShapelessRecipe(new ItemStack(itemDough, 3), new Object[] {itemFlour, Item.bucketWater});
        GameRegistry.addShapelessRecipe(new ItemStack(itemPowderMix, 1), new Object[] {itemCoalDust, Item.gunpowder});
        // marble and other simple blocks
        GameRegistry.addShapelessRecipe(new ItemStack(blockMarble, 1), new Object[] {itemElectroCrystal, Block.stone});
        GameRegistry.addRecipe(new ItemStack(itemCementMix, 1),
                "xkx",
                "kzk",
                "xkx",
                'k', new ItemStack(Item.dyePowder, 3, 15),
                'z', Item.bucketWater,
                'x', Block.sand);
        GameRegistry.addRecipe(new ItemStack(itemWoodBox, 1),
                "xyx",
                "xxx",
                'x', itemWoodPlank,
                'y', itemNails);
        GameRegistry.addRecipe(new ItemStack(Block.planks, 2),
                "xxy",
                "xxy",
                'x', itemWoodPlank,
                'y', itemNails);
        GameRegistry.addRecipe(new ItemStack(Block.tnt, 1),
                "xxx",
                "xxx",
                " y ",
                'x', itemExplosiveStick,
                'y', itemWoodBox);
        GameRegistry.addRecipe(new ItemStack(itemExplosiveStick, 1),
                "xyz",
                'x', Item.paper,
                'y', itemPowderMix,
                'z', Item.silk);
        
        GameRegistry.addRecipe(new ItemStack(itemWoodBarrel, 1),
                "yxy",
                "xxx",
                "yxy",
                'x', itemWoodPlank,
                'y', itemIronStripe);
        GameRegistry.addRecipe(new ItemStack(itemIronStripe, 6),
                "xxx",
                'x', Item.ingotIron);
        //переплавка
        GameRegistry.addSmelting(itemCementMix.shiftedIndex, new ItemStack(itemCementSack, 1), 0);
        GameRegistry.addSmelting(itemObsidianAlloyBlank.shiftedIndex, new ItemStack(itemObsidianAlloyIngot, 1), 0);
        GameRegistry.addSmelting(itemDough.shiftedIndex, new ItemStack(Item.bread, 1), 0);
        GameRegistry.addRecipe(new ItemStack(Item.stick, 2), new Object[] {"#", "#", '#', itemWoodPlank});
        //Крафт фурнитуры
        GameRegistry.addRecipe(new ItemStack(itemWoodChair, 1),
                "  x",
                "xxx",
                "xyx",
                'x', itemWoodPlank,
                'y', itemNails);
        GameRegistry.addRecipe(new ItemStack(itemWhiteCottonChair, 1)," zx","xxx","xyx",'x', itemWoodPlank,'y', itemNails,'z', new ItemStack(Block.cloth, 1, 0));
        GameRegistry.addRecipe(new ItemStack(itemBlueCottonChair, 1)," zx","xxx","xyx",'x', itemWoodPlank,'y', itemNails,'z', new ItemStack(Block.cloth, 1, 11));
        GameRegistry.addRecipe(new ItemStack(itemRedCottonChair, 1)," zx","xxx","xyx",'x', itemWoodPlank,'y', itemNails,'z', new ItemStack(Block.cloth, 1, 14));
        GameRegistry.addRecipe(new ItemStack(itemBlackCottonChair, 1)," zx","xxx","xyx",'x', itemWoodPlank,'y', itemNails,'z', new ItemStack(Block.cloth, 1, 15));
        GameRegistry.addRecipe(new ItemStack(itemLeatherChair, 1)," zx","xxx","xyx",'x', itemWoodPlank,'y', itemNails,'z', Item.leather);
        
        GameRegistry.addShapelessRecipe(new ItemStack(itemGoldSpool, 1), new Object[] {itemGoldDust, itemSpool});
        GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondSpool, 1), new Object[] {itemDiamondDust, itemSpool});
        
        GameRegistry.addShapelessRecipe(new ItemStack(itemGoldFabricStrap, 1), new Object[] {itemGoldSpool,itemGoldSpool,itemGoldSpool});
        GameRegistry.addShapelessRecipe(new ItemStack(itemGoldFabricRoll, 1), new Object[] { itemGoldFabricStrap,itemGoldFabricStrap,itemGoldFabricStrap,itemGoldFabricStrap,itemGoldFabricStrap,itemGoldFabricStrap});
        
        GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondFabricStrap, 1), new Object[] {itemDiamondSpool,itemDiamondSpool,itemDiamondSpool});
        GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondFabricRoll, 1), new Object[] { itemDiamondFabricStrap,itemDiamondFabricStrap,itemDiamondFabricStrap,itemDiamondFabricStrap,itemDiamondFabricStrap,itemDiamondFabricStrap});
    
        GameRegistry.addShapelessRecipe(new ItemStack(itemChevron, 1), new Object[] {itemSpool, itemFabricRoll, itemSpool});
        GameRegistry.addShapelessRecipe(new ItemStack(itemChevronWithGoldThread, 1), new Object[] {itemGoldSpool, itemFabricRoll, itemGoldSpool});
        GameRegistry.addShapelessRecipe(new ItemStack(itemChevronWithDiamondThread, 1), new Object[] {itemDiamondDust, itemFabricRoll, itemDiamondDust});
        GameRegistry.addShapelessRecipe(new ItemStack(itemGoldChevronWithGoldThread, 1), new Object[] {itemGoldSpool, itemGoldFabricRoll, itemGoldSpool});
        GameRegistry.addShapelessRecipe(new ItemStack(itemGoldChevronWithDiamondThread, 1), new Object[] {itemDiamondSpool, itemGoldFabricRoll, itemDiamondSpool});
        GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondChevronWithDiamondThread, 1), new Object[] {itemDiamondSpool, itemDiamondFabricRoll, itemDiamondSpool});
        GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondChevronWithGoldThread, 1), new Object[] {itemGoldSpool, itemDiamondFabricRoll, itemGoldSpool});
        
        GameRegistry.addShapelessRecipe(new ItemStack(itemMedivalSymbol, 1), new Object[] {itemFabricStrap, itemSpool, new ItemStack(Item.dyePowder, 1, 11)});
        GameRegistry.addShapelessRecipe(new ItemStack(itemTechnoSymbol, 1), new Object[] {itemFabricStrap, itemSpool, new ItemStack(Item.dyePowder, 1, 1)});
        

        // крафт нейтральных флагов
        GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 0),
     		   "xxx",
     		   "rsr",
     		   "p p",
     		   'x', Item.stick,
     		   's', itemChevron,
     		   'p', itemSpool,
     		   'r', itemFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 1),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemChevron,
         	       'p', itemGoldSpool,
         	       'r', itemFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 2),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemChevron,
         	       'p', itemGoldSpool,
         	       'r', itemGoldFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 3),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemChevronWithGoldThread,
         	       'p', itemSpool,
         	       'r', itemFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 4),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemChevronWithGoldThread,
         	       'p', itemGoldSpool,
         	       'r', itemFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 5),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemChevronWithGoldThread,
         	       'p', itemSpool,
         	       'r', itemGoldFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 6),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemGoldChevronWithGoldThread,
         	       'p', itemSpool,
         	       'r', itemFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 7),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemGoldChevronWithGoldThread,
         	       'p', itemGoldSpool,
         	       'r', itemFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 8),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemGoldChevronWithGoldThread,
         	       'p', itemSpool,
         	       'r', itemGoldFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 9),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemGoldChevronWithGoldThread,
         	       'p', itemGoldSpool,
         	       'r', itemGoldFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 10),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemGoldChevronWithDiamondThread,
         	       'p', itemSpool,
         	       'r', itemFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 11),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemGoldChevronWithDiamondThread,
         	       'p', itemGoldSpool,
         	       'r', itemFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 12),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemGoldChevronWithDiamondThread,
         	       'p', itemSpool,
         	       'r', itemGoldFabricRoll);
         GameRegistry.addRecipe(new ItemStack(itemFlag, 1, 13),
         	       "xxx",
         	       "rsr",
         	       "p p",
         	       'x', Item.stick,
         	       's', itemGoldChevronWithDiamondThread,
         	       'p', itemGoldSpool,
         	       'r', itemGoldFabricRoll);
        		
        // консерваторские флаги
        GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 0),
     		   "xxx",
     		   "rsr",
     		   "pyp",
     		   'x', Item.stick,
     		   's', itemChevron,
     		   'p', itemSpool,
     		   'r', itemFabricRoll,
     		   'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 1),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemChevron,
         	       'p', itemDiamondSpool,
         	       'r', itemFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 2),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemChevron,
         	       'p', itemDiamondSpool,
         	       'r', itemDiamondFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 3),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemChevronWithDiamondThread,
         	       'p', itemSpool,
         	       'r', itemFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 4),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemChevronWithDiamondThread,
         	       'p', itemDiamondSpool,
         	       'r', itemFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 5),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemChevronWithDiamondThread,
         	       'p', itemSpool,
         	       'r', itemDiamondFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 6),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemDiamondChevronWithGoldThread,
         	       'p', itemSpool,
         	       'r', itemFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 7),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemDiamondChevronWithGoldThread,
         	       'p', itemDiamondSpool,
         	       'r', itemFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 8),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemDiamondChevronWithGoldThread,
         	       'p', itemSpool,
         	       'r', itemDiamondFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 9),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemDiamondChevronWithGoldThread,
         	       'p', itemDiamondSpool,
         	       'r', itemDiamondFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 10),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemDiamondChevronWithDiamondThread,
         	       'p', itemSpool,
         	       'r', itemFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 11),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemDiamondChevronWithDiamondThread,
         	       'p', itemDiamondSpool,
         	       'r', itemFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 12),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemDiamondChevronWithDiamondThread,
         	       'p', itemSpool,
         	       'r', itemDiamondFabricRoll,
         	       'y', itemMedivalSymbol);
         GameRegistry.addRecipe(new ItemStack(itemMedivalFlag, 1, 13),
         	       "xxx",
         	       "rsr",
         	       "pyp",
         	       'x', Item.stick,
         	       's', itemDiamondChevronWithDiamondThread,
         	       'p', itemDiamondSpool,
         	       'r', itemDiamondFabricRoll,
         	       'y', itemMedivalSymbol);
         // Флаги технократов
         GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 0),
       		   "xxx",
       		   "rsr",
       		   "pyp",
       		   'x', Item.stick,
       		   's', itemChevron,
       		   'p', itemSpool,
       		   'r', itemFabricRoll,
       		   'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 1),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemChevron,
           	       'p', itemDiamondSpool,
           	       'r', itemFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 2),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemChevron,
           	       'p', itemDiamondSpool,
           	       'r', itemDiamondFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 3),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemChevronWithDiamondThread,
           	       'p', itemSpool,
           	       'r', itemFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 4),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemChevronWithDiamondThread,
           	       'p', itemDiamondSpool,
           	       'r', itemFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 5),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemChevronWithDiamondThread,
           	       'p', itemSpool,
           	       'r', itemDiamondFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 6),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemDiamondChevronWithGoldThread,
           	       'p', itemSpool,
           	       'r', itemFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 7),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemDiamondChevronWithGoldThread,
           	       'p', itemDiamondSpool,
           	       'r', itemFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 8),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemDiamondChevronWithGoldThread,
           	       'p', itemSpool,
           	       'r', itemDiamondFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 9),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemDiamondChevronWithGoldThread,
           	       'p', itemDiamondSpool,
           	       'r', itemDiamondFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 10),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemDiamondChevronWithDiamondThread,
           	       'p', itemSpool,
           	       'r', itemFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 11),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemDiamondChevronWithDiamondThread,
           	       'p', itemDiamondSpool,
           	       'r', itemFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 12),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemDiamondChevronWithDiamondThread,
           	       'p', itemSpool,
           	       'r', itemDiamondFabricRoll,
           	       'y', itemTechnoSymbol);
           GameRegistry.addRecipe(new ItemStack(itemTechnoFlag, 1, 13),
           	       "xxx",
           	       "rsr",
           	       "pyp",
           	       'x', Item.stick,
           	       's', itemDiamondChevronWithDiamondThread,
           	       'p', itemDiamondSpool,
           	       'r', itemDiamondFabricRoll,
           	       'y', itemTechnoSymbol);
    }
    
    private void setUpRegestry()
    {
    	GameRegistry.registerWorldGenerator(new WorldGeneratorCrystals());
    	GameRegistry.registerTileEntity(TileEntityBones.class, "TileEntityBones");
        GameRegistry.registerTileEntity(TileEntityFlag.class, "TileEntityFlag");
        GameRegistry.registerTileEntity(TileEntityChair.class, "TileEntityChair");
        GameRegistry.registerTileEntity(TileEntityEliteChair.class, "TileEntityEliteChair");
        GameRegistry.registerTileEntity(TileEntityTable.class, "TileEntityTable");
        GameRegistry.registerTileEntity(TileEntityTableCabinet.class, "TileEntityTableCabinet");
        GameRegistry.registerTileEntity(TileEntityTableDinner.class, "TileEntityTableDinner");
        GameRegistry.registerTileEntity(TileEntityCrystal.class, "TileEntityCrystal");
        EntityRegistry.registerModEntity(EntityExplosiveStick.class, "EntityExplosiveStick", EntityRegistry.findGlobalUniqueEntityId(), this, 200, 30, true);
    }
    
    //Поехали, объявление наших переменных:
    // Blocks here
    public static BlockBones blockBones;
    public static BlockReinforcedConcrete blockReinforcedConcrete; // Это бетоооооон!
    public static BlockMarble blockMarble; // Это Мрамооор!
    public static BlockSkeletonChest blockSkeletonChest;
    public static BlockChair blockWoodChair;
    public static BlockChair blockWiteCottonChair;
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
    public static BlockTableCabinet blockCabinetBlackwoodTable;
    public static BlockTableCabinet blockCabinetRedwoodTable;
    public static BlockTableDinner blockDinnerWoodTable;
    public static BlockCrystal blockBlackCrystal;
    public static BlockCrystal blockWhiteCrystal;
    public static BlockCrystal blockElectroCrystal;
    public static BlockCrystal blockRedCrystal;
    public static BlockCrystal blockBlueCrystal;
    
    public static BlockSalt blockSalt; 
    
    public static BlockFlag blockMedivalFlag;
    public static BlockFlag blockTechnoFlag;
    public static BlockFlag blockFlag;
    
    public static BlockObsidianBricks blockObsidianBricks;
    public static BlockGrease blockGrease;
    public static BlockReserved blockReserved02;
    public static BlockReserved blockReserved03;
    public static BlockReserved blockReserved04;
    public static BlockReserved blockReserved05;
    public static BlockReserved blockReserved06;
    public static BlockReserved blockReserved07;
    public static BlockReserved blockReserved08;
    public static BlockReserved blockReserved09;
    public static BlockReserved blockReserved10;
    public static BlockReserved blockReserved11;
    public static BlockReserved blockReserved12;
	public static BlockReserved blockReserved13;
	public static BlockReserved blockReserved14;
	public static BlockReserved blockReserved15;
	public static BlockReserved blockReserved16;
	public static BlockReserved blockReserved17;
	public static BlockReserved blockReserved18;
	public static BlockReserved blockReserved19;
	public static BlockReserved blockReserved20;

    // Items here
    public static ItemSkull itemSkull; // Череп
    public static ItemNails itemNails; // гвозди
    public static ItemLeatherStrap itemLeatherStrap; // Кожаный лоскут
    public static ItemLeatherCorset itemLeatherCorset; // корсет
    public static ItemSpool itemSpool; // Моток ниток
    public static ItemFabricStrap itemFabricStrap; // Кусок ткани
    public static ItemFabricRoll itemFabricRoll; // рулон ткани
    public static ItemDiamondDust itemDiamondDust; // Алмазная пыль
    public static ItemGoldDust itemGoldDust; // Золотая пыль
    public static ItemObsidianBrick itemObsidianBrick; // Обсидиановый кирпич
    public static ItemObsidianAlloyBlank itemObsidianAlloyBlank; // Заготовка обсидианового сплава
    public static ItemObsidianAlloyIngot itemObsidianAlloyIngot; // обс. сплав
    public static ItemCrystal itemElectroCrystal; // солевой кристалл
    public static ItemCementSack itemCementSack; // мешок цемента
    public static ItemCementMix itemCementMix; // Цементная смесь
    public static ItemWoodBox itemWoodBox; // Деревянный ящик - контейнер
    public static ItemExplosiveStick itemExplosiveStick; // Шашка динамита
    public static ItemJerkedBeef itemJerkedBeef; // Вяленая говядина
    public static ItemJerkedPork itemJerkedPork; // Вяленая свинина
    public static ItemLambRawMeat itemLambRawMeat; // сырая баранина
    public static ItemLambFried itemLambFried; // Жареная баранина
    public static ItemJerkedLamb itemJerkedLamb; // Вяленая баранина
    public static ItemPowderMix itemPowderMix; // Пороховая смесь
    public static ItemCoalDust itemCoalDust; // Угольная пыль
    public static ItemWoodPlank itemWoodPlank; // Доска
    public static ItemPorkBelly itemPorkBelly; // Свинной жир
    public static ItemSalo itemSalo; // Сало
    public static ItemGrease itemGrease; // Жир
    public static ItemOil itemOil; // Масло
    public static ItemWoodBarrel itemWoodBarrel; // деревянная бочка
    public static ItemFlour itemFlour; // Мука
    public static ItemDough itemDough; // Тесто
    public static ItemIronStripe itemIronStripe; // металлическая полоска
    public static ItemSalt itemSalt; // солевой кристалл
    public static ItemChair itemWoodChair;
    public static ItemChair itemWhiteCottonChair; // Стулья
    public static ItemChair itemRedCottonChair;
    public static ItemChair itemBlueCottonChair;
    public static ItemChair itemBlackCottonChair;
    public static ItemChair itemLeatherChair;
    public static ItemChair itemIronChair;
    //Элитные Стулья
    public static ItemChair itemBlackwoodChair;
    public static ItemChair itemRedwoodChair; 
    public static ItemChair itemGoldChair;
    public static ItemChair itemDiamondedChair;
    
    public static ItemTable itemWoodTable;
    public static ItemTable itemIronTable;
    public static ItemTable itemStoneTable;
    public static ItemTable itemBlackwoodTable;
    public static ItemTable itemRedwoodTable;
    public static ItemTable itemCabinetBlackwoodTable;
    public static ItemTable itemCabinetRedwoodTable;
    public static ItemTable itemDinnerWoodTable;
    
    public static ItemCrystal itemBlackCrystal;
    public static ItemCrystal itemWhiteCrystal;
    public static ItemCrystal itemRedCrystal;
    public static ItemCrystal itemBlueCrystal;
    
    public static ItemFlag itemMedivalFlag;
    public static ItemFlag itemTechnoFlag;
    public static ItemFlag itemFlag;
    
    public static ItemObsidianBricks itemObsidianBricks;
    public static Item itemGoldSpool;
    public static Item itemDiamondSpool;
    public static Item itemGoldFabricStrap;
    public static Item itemDiamondFabricStrap;
    public static Item itemGoldFabricRoll;
    public static Item itemDiamondFabricRoll;
    public static Item itemChevron;
    public static Item itemChevronWithGoldThread;
    public static Item itemChevronWithDiamondThread;
    public static Item itemGoldChevronWithGoldThread;
    public static Item itemDiamondChevronWithDiamondThread;
    public static Item itemDiamondChevronWithGoldThread;
    public static Item itemGoldChevronWithDiamondThread;
    public static Item itemMedivalSymbol;
    public static Item itemTechnoSymbol;
    public static Item itemReserved16;
    public static Item itemReserved17;
    public static Item itemReserved18;
    public static Item itemReserved19;
    public static Item itemReserved20;
    public static Item itemReserved21;
    public static Item itemReserved22;
    public static Item itemReserved23;
    public static Item itemReserved24;
    public static Item itemReserved25;
    public static Item itemReserved26;
    public static Item itemReserved27;
    public static Item itemReserved28;
    public static Item itemReserved29;
    public static Item itemReserved30;
    public static Item itemReserved31;
    public static Item itemReserved32;
    public static Item itemReserved33;
    public static Item itemReserved34;
    public static Item itemReserved35;
    public static Item itemReserved36;
    public static Item itemReserved37;
    public static Item itemReserved38;
    public static Item itemReserved39;
    public static Item itemReserved40;
    
    private int itemID = 5599;
    private int metaBlockID = 1656;
    private int blockID = 600;
    private int textureID = 0;
    private int metaTexturesID = 0;
    // Configuration Values
    private static int blockBonesID;
    private static int blockReinforcedConcreteID;
	private static int blockSceletonChestID;
	private static int blockMarbleID;
	private static int blockSaltID;
	private static int blockWoodChairID;
	private static int blockWhiteCottonChairID;
	private static int blockBlueCottonChairID;
	private static int blockBlackCottonChairID;
	private static int blockRedCottonChairID;
	private static int blockLeatherChairID;
	private static int blockIronChairID;
	private static int blockBlackwoodChairID;
	private static int blockRedwoodChairID;
	private static int blockGoldChairID;
	private static int blockDiamondedChairID;
	
	private static int blockWoodTableID;
	private static int blockIronTableID;
	private static int blockStoneTableID;
	private static int blockBlackwoodTableID;
	private static int blockRedwoodTableID ;
	private static int blockCabinetBlackwoodTableID;
	private static int blockCabinetRedwoodTableID;
	private static int blockDinnerWoodTableID;
	
	private static int blockBlackCrystalID;
	private static int blockWhiteCrystalID;
	private static int blockElectroCrystalID;
	private static int blockRedCrystalID;
	private static int blockBlueCrystalID;
	
	private static int blockFlagMedivalID;
    private static int blockFlagTechnoID;
    private static int blockFlagID;
	
    private int blockObsidianBricksID;
    private int blockGreaseID;
    private int blockReservedID02;
    private int blockReservedID03;
    private int blockReservedID04;
    private int blockReservedID05;
    private int blockReservedID06;
    private int blockReservedID07;
    private int blockReservedID08;
    private int blockReservedID09;
    private int blockReservedID10;
    private int blockReservedID11;
    private int blockReservedID12;
    private int blockReservedID13;
    private int blockReservedID14;
    private int blockReservedID15;
    private int blockReservedID16;
    private int blockReservedID17;
    private int blockReservedID18;
    private int blockReservedID19;
    private int blockReservedID20;
	//ID итемов.
    private static int itemSkullID;
    private static int itemNailsID;
    private static int itemLeatherStrapID;
    private static int itemLeatherCorsetID;
    private static int itemSpoolID;
    private static int itemFabricStrapID;
    private static int itemFabricRollID;
    private static int itemDiamondDustID;
    private static int itemGoldDustID;
    private static int itemObsidianBrickID;
    private static int itemObsidianAlloyBlankID;
    private static int itemObsidianAlloyIngotID;
    private static int itemElectroCrystalID;
    private static int itemCementSackID;
    private static int itemCementMixID;
    private static int itemWoodBoxID;
    private static int itemExplosiveStickID;
    private static int itemJerkedBeefID;
    private static int itemJerkedPorkID;
    private static int itemLambRawMeatID;
    private static int itemLambFriedID;
    private static int itemJerkedLambID;
    private static int itemPowderMixID;
    private static int itemCoalDustID;
    private static int itemWoodPlankID;
    private static int itemPorkBellyID;
    private static int itemSaloID;
    private static int itemGreaseID;
    private static int itemOilID;
    private static int itemWoodBarrelID;
    private static int itemFlourID;
    private static int itemDoughID;
    private static int itemIronStripeID;
    private static int itemSaltID;
    private static int itemWoodChairID;
    private static int itemWhiteCottonChairID;
    private static int itemRedCottonChairID;
    private static int itemBlueCottonChairID;
    private static int itemBlackCottonChairID;
    private static int itemLeatherChairID;
    private static int itemIronChairID;
    private static int itemBlackwoodChairID;
    private static int itemRedwoodChairID; 
    private static int itemGoldChairID;
    private static int itemDiamondedChairID;
    
    private static int itemWoodTableID;
    private static int itemIronTableID;
    private static int itemStoneTableID;
    private static int itemBlackwoodTableID;
    private static int itemRedwoodTableID;
    private static int itemCabinetBlackwoodTableID;
    private static int itemCabinetRedwoodTableID;
    private static int itemDinnerWoodTableID;

    private static int itemBlackCrystalID;
    private static int itemWhiteCrystalID;
    private static int itemBlueCrystalID;
    private static int itemRedCrystalID;
    
    private static int itemFlagMedivalID;
    private static int itemFlagTechnoID;
    private static int itemFlagID;
    
    private static int itemObsidianBricksID;
    private static int itemGoldSpoolID;
    private static int itemDiamondSpoolID;
    private static int itemGoldFabricStrapID;
    private static int itemDiamondFabricStrapID;
    private static int itemGoldFabricRollID;
    private static int itemDiamondFabricRollID;
    private static int itemChevronID;
    private static int itemChevronWithGoldThreadID;
    private static int itemChevronWithDiamondThreadID;
    private static int itemGoldChevronWithGoldThreadID;
    private static int itemDiamondChevronWithDiamondThreadID;
    private static int itemDiamondChevronWithGoldThreadID;
    private static int itemGoldChevronWithDiamondThreadID;
    private static int itemMedivalSymbolID;
    private static int itemTechnoSymbolID;
    private static int itemReservedID16;
    private static int itemReservedID17;
    private static int itemReservedID18;
    private static int itemReservedID19;
    private static int itemReservedID20;
    private static int itemReservedID21;
    private static int itemReservedID22;
    private static int itemReservedID23;
    private static int itemReservedID24;
    private static int itemReservedID25;
    private static int itemReservedID26;
    private static int itemReservedID27;
    private static int itemReservedID28;
    private static int itemReservedID29;
    private static int itemReservedID30;
    private static int itemReservedID31;
    private static int itemReservedID32;
    private static int itemReservedID33;
    private static int itemReservedID34;
    private static int itemReservedID35;
    private static int itemReservedID36;
    private static int itemReservedID37;
    private static int itemReservedID38;
    private static int itemReservedID39;
    private static int itemReservedID40;
    }

