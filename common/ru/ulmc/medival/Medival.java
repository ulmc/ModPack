package ru.ulmc.medival;

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
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

@Mod(modid = "Medival", name = "Medival", version = "In-Dev 1.0")
@NetworkMod(
        channels = { "Medival" },
        clientSideRequired = true,
        serverSideRequired = false,
        packetHandler = PacketHandler.class)
public class Medival
{
	
    @Instance
    public static Medival instance;
    @SidedProxy(clientSide = "ru.ulmc.medival.ClientMedivalProxy", serverSide = "ru.ulmc.medival.CommonMedivalProxy")
    public static CommonMedivalProxy proxy;
    // Configuration Values
    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
        // Loading in Configuration Data
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        proxy.preInit();
        try
        {        	
            cfg.load();
            
            // Load Block IDs
            blockPikesID = cfg.getOrCreateBlockIdProperty("Pikes", blockMedivalID).getInt(blockMedivalID++);
            blockMedivalID1 = cfg.getOrCreateBlockIdProperty("medulmcBlockID1", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID2 = cfg.getOrCreateBlockIdProperty("medulmcBlockID2", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID3 = cfg.getOrCreateBlockIdProperty("medulmcBlockID3", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID4 = cfg.getOrCreateBlockIdProperty("medulmcBlockID4", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID5 = cfg.getOrCreateBlockIdProperty("medulmcBlockID5", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID6 = cfg.getOrCreateBlockIdProperty("medulmcBlockID6", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID7 = cfg.getOrCreateBlockIdProperty("medulmcBlockID7", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID8 = cfg.getOrCreateBlockIdProperty("medulmcBlockID8", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID9 = cfg.getOrCreateBlockIdProperty("medulmcBlockID9", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID10 = cfg.getOrCreateBlockIdProperty("medulmcBlockID10", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID11 = cfg.getOrCreateBlockIdProperty("medulmcBlockID11", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID12 = cfg.getOrCreateBlockIdProperty("medulmcBlockID12", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID13 = cfg.getOrCreateBlockIdProperty("medulmcBlockID13", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID14 = cfg.getOrCreateBlockIdProperty("medulmcBlockID14", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID15 = cfg.getOrCreateBlockIdProperty("medulmcBlockID15", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID16 = cfg.getOrCreateBlockIdProperty("medulmcBlockID16", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID17 = cfg.getOrCreateBlockIdProperty("medulmcBlockID17", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID18 = cfg.getOrCreateBlockIdProperty("medulmcBlockID18", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID19 = cfg.getOrCreateBlockIdProperty("medulmcBlockID19", blockMedivalID).getInt(blockMedivalID++);
        	blockMedivalID20 = cfg.getOrCreateBlockIdProperty("medulmcBlockID20", blockMedivalID).getInt(blockMedivalID++);
            //Load Item IDs!
        	itemAlkoDrinksID = cfg.getOrCreateIntProperty("medivalReservedID1", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID1 = cfg.getOrCreateIntProperty("medivalReservedID2", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID2 = cfg.getOrCreateIntProperty("medivalReservedID3", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID3 = cfg.getOrCreateIntProperty("medivalReservedID4", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID4 = cfg.getOrCreateIntProperty("medivalReservedID5", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID5 = cfg.getOrCreateIntProperty("medivalReservedID6", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID6 = cfg.getOrCreateIntProperty("medivalReservedID7", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID7 = cfg.getOrCreateIntProperty("medivalReservedID8", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID8 = cfg.getOrCreateIntProperty("medivalReservedID9", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID9 = cfg.getOrCreateIntProperty("medivalReservedID10", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID10 = cfg.getOrCreateIntProperty("medivalReservedID11", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID11 = cfg.getOrCreateIntProperty("medivalReservedID12", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID12 = cfg.getOrCreateIntProperty("medivalReservedID13", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID13 = cfg.getOrCreateIntProperty("medivalReservedID14", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID14 = cfg.getOrCreateIntProperty("medivalReservedID15", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID15 = cfg.getOrCreateIntProperty("medivalReservedID16", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID16 = cfg.getOrCreateIntProperty("medivalReservedID17", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID17 = cfg.getOrCreateIntProperty("medivalReservedID18", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID18 = cfg.getOrCreateIntProperty("medivalReservedID19", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID19 = cfg.getOrCreateIntProperty("medivalReservedID20", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID20 = cfg.getOrCreateIntProperty("medivalReservedID21", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID21 = cfg.getOrCreateIntProperty("medivalReservedID22", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID22 = cfg.getOrCreateIntProperty("medivalReservedID23", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID23 = cfg.getOrCreateIntProperty("medivalReservedID24", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID24 = cfg.getOrCreateIntProperty("medivalReservedID25", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID25 = cfg.getOrCreateIntProperty("medivalReservedID26", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID26 = cfg.getOrCreateIntProperty("medivalReservedID27", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID27 = cfg.getOrCreateIntProperty("medivalReservedID28", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID28 = cfg.getOrCreateIntProperty("medivalReservedID29", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID29 = cfg.getOrCreateIntProperty("medivalReservedID30", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID30 = cfg.getOrCreateIntProperty("medivalReservedID31", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID31 = cfg.getOrCreateIntProperty("medivalReservedID32", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID32 = cfg.getOrCreateIntProperty("medivalReservedID33", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID33 = cfg.getOrCreateIntProperty("medivalReservedID34", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID34 = cfg.getOrCreateIntProperty("medivalReservedID35", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID35 = cfg.getOrCreateIntProperty("medivalReservedID36", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID36 = cfg.getOrCreateIntProperty("medivalReservedID37", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID37 = cfg.getOrCreateIntProperty("medivalReservedID38", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID38 = cfg.getOrCreateIntProperty("medivalReservedID39", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID39 = cfg.getOrCreateIntProperty("medivalReservedID40", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            itemMedivalID40 = cfg.getOrCreateIntProperty("medivalReservedID41", Configuration.CATEGORY_ITEM, ++itemMedivalID).getInt(itemMedivalID);
            
        }
        catch (Exception e)
        {
            FMLLog.log(Level.SEVERE, e, "SteamPeople's configuration failed to load.");
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
    	this.blockForge();        
        //регистрируем итемы нашим методом.
    	this.itemForge(); 
     	//this.itemForge();  
        //ну и наконец регистрируем рецептыши
     	this.postBlock();
     	//Куём рецепты.
     	this.recipeForge();
         // Register Rendering Information
     	this.setUpRegestry();
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent evt)
    {
        // TODO: Add Post-Initialization code such as mod hooks
    }
    
    private void blockForge()
    {

    	blockPikes = new BlockPikes(blockPikesID);
        blockMedivalReserved1 = new BlockMedival(blockMedivalID1, 1.5F, 20.0F, "MedivalReserved1", 12);
        blockMedivalReserved2 = new BlockMedival(blockMedivalID2, 1.5F, 20.0F, "MedivalReserved2", 12);
        blockMedivalReserved3 = new BlockMedival(blockMedivalID3, 1.5F, 20.0F, "MedivalReserved3", 12);
        blockMedivalReserved4 = new BlockMedival(blockMedivalID4, 1.5F, 20.0F, "MedivalReserved4", 12);
        blockMedivalReserved5 = new BlockMedival(blockMedivalID5, 1.5F, 20.0F, "MedivalReserved5", 12);
        blockMedivalReserved6 = new BlockMedival(blockMedivalID6, 1.5F, 20.0F, "MedivalReserved6", 12);
        blockMedivalReserved7 = new BlockMedival(blockMedivalID7, 1.5F, 20.0F, "MedivalReserved7", 12);
        blockMedivalReserved8 = new BlockMedival(blockMedivalID8, 1.5F, 20.0F, "MedivalReserved8", 12);
        blockMedivalReserved9 = new BlockMedival(blockMedivalID9, 1.5F, 20.0F, "MedivalReserved9", 12);
        blockMedivalReserved10 = new BlockMedival(blockMedivalID10, 1.5F, 20.0F, "MedivalReserved10", 12);
        blockMedivalReserved11 = new BlockMedival(blockMedivalID11, 1.5F, 20.0F, "MedivalReserved11", 12);
        blockMedivalReserved12 = new BlockMedival(blockMedivalID12, 1.5F, 20.0F, "MedivalReserved12", 12);
        blockMedivalReserved13 = new BlockMedival(blockMedivalID13, 1.5F, 20.0F, "MedivalReserved13", 12);
        blockMedivalReserved14 = new BlockMedival(blockMedivalID14, 1.5F, 20.0F, "MedivalReserved14", 12);
        blockMedivalReserved15 = new BlockMedival(blockMedivalID15, 1.5F, 20.0F, "MedivalReserved15", 12);
        blockMedivalReserved16 = new BlockMedival(blockMedivalID16, 1.5F, 20.0F, "MedivalReserved16", 12);
        blockMedivalReserved17 = new BlockMedival(blockMedivalID17, 1.5F, 20.0F, "MedivalReserved17", 12);
        blockMedivalReserved18 = new BlockMedival(blockMedivalID18, 1.5F, 20.0F, "MedivalReserved18", 12);
        blockMedivalReserved19 = new BlockMedival(blockMedivalID19, 1.5F, 20.0F, "MedivalReserved19", 12);
        blockMedivalReserved20 = new BlockMedival(blockMedivalID20, 1.5F, 20.0F, "MedivalReserved20", 12);


        //Add Localization Data
        proxy.PrepareBlock(blockPikes,"Острая пика", "Sarp pike", true);
    	proxy.PrepareBlock(blockMedivalReserved1,"blockMedivalReservedRu2", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved2,"blockMedivalReservedRu2", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved3,"blockMedivalReservedRu3", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved4,"blockMedivalReservedRu4", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved5,"blockMedivalReservedRu5", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved6,"blockMedivalReservedRu6", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved7,"blockMedivalReservedRu7", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved8,"blockMedivalReservedRu8", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved9,"blockMedivalReservedRu9", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved10,"blockMedivalReservedRu10", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved11,"blockMedivalReservedRu11", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved12,"blockMedivalReservedRu12", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved13,"blockMedivalReservedRu13", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved14,"blockMedivalReservedRu14", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved15,"blockMedivalReservedRu14", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved16,"blockMedivalReservedRu16", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved17,"blockMedivalReservedRu", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved18,"blockMedivalReservedRu", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved19,"blockMedivalReservedRu", "blockEnMedivalReserved", false);
    	proxy.PrepareBlock(blockMedivalReserved20,"blockMedivalReservedRu", "blockEnMedivalReserved", false);
    	
    }
    // метод для передачи данных блокам, после индентификации предметов. Необязательно реализовывать так. Это мой подход.
    private void postBlock()
    {
        // Специфический метод для передачи данных об итеме, который мы будем дропать    
    }
    private void itemForge()
    {   
       
        //Initialize Items part 1
    		itemAlkoDrinks= new ItemMedival(itemAlkoDrinksID);
    		proxy.CreateItem(itemAlkoDrinks, ++textureID, "Alcohol", "Алкоголь", "Alcohol", true);
			itemMedivalReserved1= new ItemMedival(itemMedivalID1);
         	proxy.CreateItem(itemMedivalReserved1, ++textureID, "itemMedivalReserved1", "Резерв", "MedivalReserved", false);
			itemMedivalReserved2= new ItemMedival(itemMedivalID2);
         	proxy.CreateItem(itemMedivalReserved2, ++textureID, "itemMedivalReserved2", "Резерв", "MedivalReserved", false);
			itemMedivalReserved3= new ItemMedival(itemMedivalID3);
         	proxy.CreateItem(itemMedivalReserved3, ++textureID, "itemMedivalReserved3", "Резерв", "MedivalReserved", false);
			itemMedivalReserved4= new ItemMedival(itemMedivalID4);
         	proxy.CreateItem(itemMedivalReserved4, ++textureID, "itemMedivalReserved4", "Резерв", "MedivalReserved", false);
			itemMedivalReserved5= new ItemMedival(itemMedivalID5);
         	proxy.CreateItem(itemMedivalReserved5, ++textureID, "itemMedivalReserved5", "Резерв", "MedivalReserved", false);
			itemMedivalReserved6= new ItemMedival(itemMedivalID6);
         	proxy.CreateItem(itemMedivalReserved6, ++textureID, "itemMedivalReserved6", "Резерв", "MedivalReserved", false);
			itemMedivalReserved7= new ItemMedival(itemMedivalID7);
         	proxy.CreateItem(itemMedivalReserved7, ++textureID, "itemMedivalReserved7", "Резерв", "MedivalReserved", false);
			itemMedivalReserved8= new ItemMedival(itemMedivalID8);
         	proxy.CreateItem(itemMedivalReserved8, ++textureID, "itemMedivalReserved8", "Резерв", "MedivalReserved", false);
			itemMedivalReserved9= new ItemMedival(itemMedivalID9);
         	proxy.CreateItem(itemMedivalReserved9, ++textureID, "itemMedivalReserved9", "Резерв", "MedivalReserved", false);
			itemMedivalReserved10= new ItemMedival(itemMedivalID10);
         	proxy.CreateItem(itemMedivalReserved10, ++textureID, "itemMedivalReserved10", "Резерв", "MedivalReserved", false);
			itemMedivalReserved11= new ItemMedival(itemMedivalID11);
         	proxy.CreateItem(itemMedivalReserved11, ++textureID, "itemMedivalReserved11", "Резерв", "MedivalReserved", false);
			itemMedivalReserved12= new ItemMedival(itemMedivalID12);
         	proxy.CreateItem(itemMedivalReserved12, ++textureID, "itemMedivalReserved12", "Резерв", "MedivalReserved", false);
			itemMedivalReserved13= new ItemMedival(itemMedivalID13);
         	proxy.CreateItem(itemMedivalReserved13, ++textureID, "itemMedivalReserved13", "Резерв", "MedivalReserved", false);
			itemMedivalReserved14= new ItemMedival(itemMedivalID14);
         	proxy.CreateItem(itemMedivalReserved14, ++textureID, "itemMedivalReserved14", "Резерв", "MedivalReserved", false);
			itemMedivalReserved15= new ItemMedival(itemMedivalID15);
         	proxy.CreateItem(itemMedivalReserved15, ++textureID, "itemMedivalReserved15", "Резерв", "MedivalReserved", false);
			itemMedivalReserved16= new ItemMedival(itemMedivalID16);
         	proxy.CreateItem(itemMedivalReserved16, ++textureID, "itemMedivalReserved16", "Резерв", "MedivalReserved", false);
			itemMedivalReserved17= new ItemMedival(itemMedivalID17);
         	proxy.CreateItem(itemMedivalReserved17, ++textureID, "itemMedivalReserved17", "Резерв", "MedivalReserved", false);
			itemMedivalReserved18= new ItemMedival(itemMedivalID18);
         	proxy.CreateItem(itemMedivalReserved18, ++textureID, "itemMedivalReserved18", "Резерв", "MedivalReserved", false);
			itemMedivalReserved19= new ItemMedival(itemMedivalID19);
         	proxy.CreateItem(itemMedivalReserved19, ++textureID, "itemMedivalReserved19", "Резерв", "MedivalReserved", false);
			itemMedivalReserved20= new ItemMedival(itemMedivalID20);
         	proxy.CreateItem(itemMedivalReserved20, ++textureID, "itemMedivalReserved20", "Резерв", "MedivalReserved", false);
			itemMedivalReserved21= new ItemMedival(itemMedivalID21);
         	proxy.CreateItem(itemMedivalReserved21, ++textureID, "itemMedivalReserved21", "Резерв", "MedivalReserved", false);
			itemMedivalReserved22= new ItemMedival(itemMedivalID22);
         	proxy.CreateItem(itemMedivalReserved22, ++textureID, "itemMedivalReserved22", "Резерв", "MedivalReserved", false);
			itemMedivalReserved23= new ItemMedival(itemMedivalID23);
         	proxy.CreateItem(itemMedivalReserved23, ++textureID, "itemMedivalReserved23", "Резерв", "MedivalReserved", false);
			itemMedivalReserved24= new ItemMedival(itemMedivalID24);
         	proxy.CreateItem(itemMedivalReserved24, ++textureID, "itemMedivalReserved24", "Резерв", "MedivalReserved", false);
			itemMedivalReserved25= new ItemMedival(itemMedivalID25);
         	proxy.CreateItem(itemMedivalReserved25, ++textureID, "itemMedivalReserved25", "Резерв", "MedivalReserved", false);
			itemMedivalReserved26= new ItemMedival(itemMedivalID26);
         	proxy.CreateItem(itemMedivalReserved26, ++textureID, "itemMedivalReserved26", "Резерв", "MedivalReserved", false);
			itemMedivalReserved27= new ItemMedival(itemMedivalID27);
         	proxy.CreateItem(itemMedivalReserved27, ++textureID, "itemMedivalReserved27", "Резерв", "MedivalReserved", false);
			itemMedivalReserved28= new ItemMedival(itemMedivalID28);
         	proxy.CreateItem(itemMedivalReserved28, ++textureID, "itemMedivalReserved28", "Резерв", "MedivalReserved", false);
			itemMedivalReserved29= new ItemMedival(itemMedivalID29);
         	proxy.CreateItem(itemMedivalReserved29, ++textureID, "itemMedivalReserved29", "Резерв", "MedivalReserved", false);
			itemMedivalReserved30= new ItemMedival(itemMedivalID30);
         	proxy.CreateItem(itemMedivalReserved30, ++textureID, "itemMedivalReserved30", "Резерв", "MedivalReserved", false);
			itemMedivalReserved31= new ItemMedival(itemMedivalID31);
         	proxy.CreateItem(itemMedivalReserved31, ++textureID, "itemMedivalReserved31", "Резерв", "MedivalReserved", false);
			itemMedivalReserved32= new ItemMedival(itemMedivalID32);
         	proxy.CreateItem(itemMedivalReserved32, ++textureID, "itemMedivalReserved32", "Резерв", "MedivalReserved", false);
			itemMedivalReserved33= new ItemMedival(itemMedivalID33);
         	proxy.CreateItem(itemMedivalReserved33, ++textureID, "itemMedivalReserved33", "Резерв", "MedivalReserved", false);
			itemMedivalReserved34= new ItemMedival(itemMedivalID34);
         	proxy.CreateItem(itemMedivalReserved34, ++textureID, "itemMedivalReserved34", "Резерв", "MedivalReserved", false);
			itemMedivalReserved35= new ItemMedival(itemMedivalID35);
         	proxy.CreateItem(itemMedivalReserved35, ++textureID, "itemMedivalReserved35", "Резерв", "MedivalReserved", false);
			itemMedivalReserved36= new ItemMedival(itemMedivalID36);
         	proxy.CreateItem(itemMedivalReserved36, ++textureID, "itemMedivalReserved36", "Резерв", "MedivalReserved", false);
			itemMedivalReserved37= new ItemMedival(itemMedivalID37);
         	proxy.CreateItem(itemMedivalReserved37, ++textureID, "itemMedivalReserved37", "Резерв", "MedivalReserved", false);
			itemMedivalReserved38= new ItemMedival(itemMedivalID38);
         	proxy.CreateItem(itemMedivalReserved38, ++textureID, "itemMedivalReserved38", "Резерв", "MedivalReserved", false);
			itemMedivalReserved39= new ItemMedival(itemMedivalID39);
         	proxy.CreateItem(itemMedivalReserved39, ++textureID, "itemMedivalReserved39", "Резерв", "MedivalReserved", false);
			itemMedivalReserved40= new ItemMedival(itemMedivalID40);
         	proxy.CreateItem(itemMedivalReserved40, ++textureID, "itemMedivalReserved40", "Резерв", "MedivalReserved", false);
    }	
    
    private void recipeForge()
    {
    	// Register Blocks Recipes
    }
    
    private void setUpRegestry()
    {

        //регистрируем рендеры.
        proxy.registerTileEntitySpecialRenderer();
    	//GameRegistry.registerWorldGenerator(new WorldGeneratorCrystals());
        //GameRegistry.registerTileEntity(TileEntityCrystal.class, "TileEntityCrystal");
        //EntityRegistry.registerModEntity(EntityExplosiveStick.class, "EntityExplosiveStick", EntityRegistry.findGlobalUniqueEntityId(), this, 200, 30, true);
    }
    public static int getProperArmorIndex(int i, int j)
    {
    	return 16*j + i;
    }
    
    //Armor here
    //reserved items
    public static Item itemAlkoDrinks;
    public static Item itemMedivalReserved1;
    public static Item itemMedivalReserved2;
    public static Item itemMedivalReserved3;
    public static Item itemMedivalReserved4;
    public static Item itemMedivalReserved5;
    public static Item itemMedivalReserved6;
    public static Item itemMedivalReserved7;
    public static Item itemMedivalReserved8;
    public static Item itemMedivalReserved9;
    public static Item itemMedivalReserved10;
    public static Item itemMedivalReserved11;
    public static Item itemMedivalReserved12;
    public static Item itemMedivalReserved13;
    public static Item itemMedivalReserved14;
    public static Item itemMedivalReserved15;
    public static Item itemMedivalReserved16;
    public static Item itemMedivalReserved17;
    public static Item itemMedivalReserved18;
    public static Item itemMedivalReserved19;
    public static Item itemMedivalReserved20;
    public static Item itemMedivalReserved21;
    public static Item itemMedivalReserved22;
    public static Item itemMedivalReserved23;
    public static Item itemMedivalReserved24;
    public static Item itemMedivalReserved25;
    public static Item itemMedivalReserved26;
    public static Item itemMedivalReserved27;
    public static Item itemMedivalReserved28;
    public static Item itemMedivalReserved29;
    public static Item itemMedivalReserved30;
    public static Item itemMedivalReserved31;
    public static Item itemMedivalReserved32;
    public static Item itemMedivalReserved33;
    public static Item itemMedivalReserved34;
    public static Item itemMedivalReserved35;
    public static Item itemMedivalReserved36;
    public static Item itemMedivalReserved37;
    public static Item itemMedivalReserved38;
    public static Item itemMedivalReserved39;
    public static Item itemMedivalReserved40;
    
    //reserved blocks
    
    public static BlockPikes blockPikes;
    public static BlockMedival blockMedivalReserved1;
    public static BlockMedival blockMedivalReserved2;
    public static BlockMedival blockMedivalReserved3;
    public static BlockMedival blockMedivalReserved4;
    public static BlockMedival blockMedivalReserved5;
    public static BlockMedival blockMedivalReserved6;
    public static BlockMedival blockMedivalReserved7;
    public static BlockMedival blockMedivalReserved8;
    public static BlockMedival blockMedivalReserved9;
    public static BlockMedival blockMedivalReserved10;
    public static BlockMedival blockMedivalReserved11;
    public static BlockMedival blockMedivalReserved12;
	public static BlockMedival blockMedivalReserved13;
	public static BlockMedival blockMedivalReserved14;
	public static BlockMedival blockMedivalReserved15;
	public static BlockMedival blockMedivalReserved16;
	public static BlockMedival blockMedivalReserved17;
	public static BlockMedival blockMedivalReserved18;
	public static BlockMedival blockMedivalReserved19;
	public static BlockMedival blockMedivalReserved20;
	
		private int blockMedivalID = 400;
	    private int itemMedivalID = 11000;
	    //private int metaBlockID = 1556;
	    private int textureID = 0;
	    //private int metaTexturesID = 0;
	    //BlockIDs
	    private int blockPikesID;
	    private int blockMedivalID1;
	    private int blockMedivalID2;
	    private int blockMedivalID3;
	    private int blockMedivalID4;
	    private int blockMedivalID5;
	    private int blockMedivalID6;
	    private int blockMedivalID7;
	    private int blockMedivalID8;
	    private int blockMedivalID9;
	    private int blockMedivalID10;
	    private int blockMedivalID11;
	    private int blockMedivalID12;
	    private int blockMedivalID13;
	    private int blockMedivalID14;
	    private int blockMedivalID15;
	    private int blockMedivalID16;
	    private int blockMedivalID17;
	    private int blockMedivalID18;
	    private int blockMedivalID19;
	    private int blockMedivalID20;
	    //MedivalReserved items IDs

	    private static int itemAlkoDrinksID;
	    private static int itemMedivalID1;
	    private static int itemMedivalID2;
	    private static int itemMedivalID3;
	    private static int itemMedivalID4;
	    private static int itemMedivalID5;
	    private static int itemMedivalID6;
	    private static int itemMedivalID7;
	    private static int itemMedivalID8;
	    private static int itemMedivalID9;
	    private static int itemMedivalID10;
	    private static int itemMedivalID11;
	    private static int itemMedivalID12;
	    private static int itemMedivalID13;
	    private static int itemMedivalID14;
	    private static int itemMedivalID15;
	    private static int itemMedivalID16;
	    private static int itemMedivalID17;
	    private static int itemMedivalID18;
	    private static int itemMedivalID19;
	    private static int itemMedivalID20;
	    private static int itemMedivalID21;
	    private static int itemMedivalID22;
	    private static int itemMedivalID23;
	    private static int itemMedivalID24;
	    private static int itemMedivalID25;
	    private static int itemMedivalID26;
	    private static int itemMedivalID27;
	    private static int itemMedivalID28;
	    private static int itemMedivalID29;
	    private static int itemMedivalID30;
	    private static int itemMedivalID31;
	    private static int itemMedivalID32;
	    private static int itemMedivalID33;
	    private static int itemMedivalID34;
	    private static int itemMedivalID35;
	    private static int itemMedivalID36;
	    private static int itemMedivalID37;
	    private static int itemMedivalID38;
	    private static int itemMedivalID39;
	    private static int itemMedivalID40;
	    
}
