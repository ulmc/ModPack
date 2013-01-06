package ru.ulmc.steampeople;

import java.util.logging.Level;

import cpw.mods.fml.client.registry.RenderingRegistry;
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
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;

@Mod(modid = "SteamPeople", name = "Steam People", version = "In-Dev 1.0")
@NetworkMod(
        channels = { "SteamPeople" },
        clientSideRequired = true,
        serverSideRequired = false,
        packetHandler = PacketHandler.class)
public class SteamPeople
{
	
    @Instance
    public static SteamPeople instance;
    @SidedProxy(clientSide = "ru.ulmc.steampeople.ClientSteamProxy", serverSide = "ru.ulmc.steampeople.CommonSteamProxy")
    public static CommonSteamProxy proxy;
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
            blockBarbedWireID = cfg.getOrCreateBlockIdProperty("steamBarbedWire", ++blockID).getInt(blockID);
            blockSteamReservedID1 = cfg.getOrCreateBlockIdProperty("steamBlockID1", ++blockID).getInt(blockID);
        	blockSteamReservedID2 = cfg.getOrCreateBlockIdProperty("steamBlockID2", ++blockID).getInt(blockID);
        	blockSteamReservedID3 = cfg.getOrCreateBlockIdProperty("steamBlockID3", ++blockID).getInt(blockID);
        	blockSteamReservedID4 = cfg.getOrCreateBlockIdProperty("steamBlockID4", ++blockID).getInt(blockID);
        	blockSteamReservedID5 = cfg.getOrCreateBlockIdProperty("steamBlockID5", ++blockID).getInt(blockID);
        	blockSteamReservedID6 = cfg.getOrCreateBlockIdProperty("steamBlockID6", ++blockID).getInt(blockID);
        	blockSteamReservedID7 = cfg.getOrCreateBlockIdProperty("steamBlockID7", ++blockID).getInt(blockID);
        	blockSteamReservedID8 = cfg.getOrCreateBlockIdProperty("steamBlockID8", ++blockID).getInt(blockID);
        	blockSteamReservedID9 = cfg.getOrCreateBlockIdProperty("steamBlockID9", ++blockID).getInt(blockID);
        	blockSteamReservedID10 = cfg.getOrCreateBlockIdProperty("steamBlockID10", ++blockID).getInt(blockID);
        	blockSteamReservedID11 = cfg.getOrCreateBlockIdProperty("steamBlockID11", ++blockID).getInt(blockID);
        	blockSteamReservedID12 = cfg.getOrCreateBlockIdProperty("steamBlockID12", ++blockID).getInt(blockID);
        	blockSteamReservedID13 = cfg.getOrCreateBlockIdProperty("steamBlockID13", ++blockID).getInt(blockID);
        	blockSteamReservedID14 = cfg.getOrCreateBlockIdProperty("steamBlockID14", ++blockID).getInt(blockID);
        	blockSteamReservedID15 = cfg.getOrCreateBlockIdProperty("steamBlockID15", ++blockID).getInt(blockID);
        	blockSteamReservedID16 = cfg.getOrCreateBlockIdProperty("steamBlockID16", ++blockID).getInt(blockID);
        	blockSteamReservedID17 = cfg.getOrCreateBlockIdProperty("steamBlockID17", ++blockID).getInt(blockID);
        	blockSteamReservedID18 = cfg.getOrCreateBlockIdProperty("steamBlockID18", ++blockID).getInt(blockID);
        	blockSteamReservedID19 = cfg.getOrCreateBlockIdProperty("steamBlockID19", ++blockID).getInt(blockID);
        	blockSteamReservedID20 = cfg.getOrCreateBlockIdProperty("steamBlockID20", ++blockID).getInt(blockID);
            //Load Item IDs!
        	armorID0 = 3000;
            armorID1 = 3001;
            armorID2 = 3002;
            armorID3 = 3003;
            armorID4 = 3004;
            armorID5 = 3005;
            armorID6 = 3006;
            armorID7 = 3007;
            armorID8 = 3008;
            armorID9 = 3009;
            armorID10 = 3010;
            armorID11 = 3011;
            armorID12 = 3012;
            armorID13 = 3013;
            armorID14 = 3014;
            armorID15 = 3015;
        	itemSteamReservedID0 = cfg.getOrCreateIntProperty("steamReservedID1", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID1 = cfg.getOrCreateIntProperty("steamReservedID2", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID2 = cfg.getOrCreateIntProperty("steamReservedID3", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID3 = cfg.getOrCreateIntProperty("steamReservedID4", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID4 = cfg.getOrCreateIntProperty("steamReservedID5", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID5 = cfg.getOrCreateIntProperty("steamReservedID6", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID6 = cfg.getOrCreateIntProperty("steamReservedID7", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID7 = cfg.getOrCreateIntProperty("steamReservedID8", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID8 = cfg.getOrCreateIntProperty("steamReservedID9", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID9 = cfg.getOrCreateIntProperty("steamReservedID10", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID10 = cfg.getOrCreateIntProperty("steamReservedID11", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID11 = cfg.getOrCreateIntProperty("steamReservedID12", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID12 = cfg.getOrCreateIntProperty("steamReservedID13", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID13 = cfg.getOrCreateIntProperty("steamReservedID14", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID14 = cfg.getOrCreateIntProperty("steamReservedID15", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID15 = cfg.getOrCreateIntProperty("steamReservedID16", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID16 = cfg.getOrCreateIntProperty("steamReservedID17", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID17 = cfg.getOrCreateIntProperty("steamReservedID18", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID18 = cfg.getOrCreateIntProperty("steamReservedID19", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID19 = cfg.getOrCreateIntProperty("steamReservedID20", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID20 = cfg.getOrCreateIntProperty("steamReservedID21", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID21 = cfg.getOrCreateIntProperty("steamReservedID22", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID22 = cfg.getOrCreateIntProperty("steamReservedID23", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID23 = cfg.getOrCreateIntProperty("steamReservedID24", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID24 = cfg.getOrCreateIntProperty("steamReservedID25", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID25 = cfg.getOrCreateIntProperty("steamReservedID26", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID26 = cfg.getOrCreateIntProperty("steamReservedID27", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID27 = cfg.getOrCreateIntProperty("steamReservedID28", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID28 = cfg.getOrCreateIntProperty("steamReservedID29", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID29 = cfg.getOrCreateIntProperty("steamReservedID30", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID30 = cfg.getOrCreateIntProperty("steamReservedID31", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID31 = cfg.getOrCreateIntProperty("steamReservedID32", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID32 = cfg.getOrCreateIntProperty("steamReservedID33", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID33 = cfg.getOrCreateIntProperty("steamReservedID34", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID34 = cfg.getOrCreateIntProperty("steamReservedID35", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID35 = cfg.getOrCreateIntProperty("steamReservedID36", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID36 = cfg.getOrCreateIntProperty("steamReservedID37", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID37 = cfg.getOrCreateIntProperty("steamReservedID38", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID38 = cfg.getOrCreateIntProperty("steamReservedID39", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID39 = cfg.getOrCreateIntProperty("steamReservedID40", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            itemSteamReservedID40 = cfg.getOrCreateIntProperty("steamReservedID41", Configuration.CATEGORY_ITEM, ++itemSteamID).getInt(itemSteamID);
            
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
    	this.itemForge(); 
    	this.blockForge();        
        //регистрируем итемы нашим методом.
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

    	blockBarbedWire = new BlockBarbedWire(blockBarbedWireID);
        blockSteamReserved1 = new BlockReserved(blockSteamReservedID1, 1.5F, 20.0F, "SteamReserved1",12);
        blockSteamReserved2 = new BlockReserved(blockSteamReservedID2, 1.5F, 20.0F, "SteamReserved2",12);
        blockSteamReserved3 = new BlockReserved(blockSteamReservedID3, 1.5F, 20.0F, "SteamReserved3",12);
        blockSteamReserved4 = new BlockReserved(blockSteamReservedID4, 1.5F, 20.0F, "SteamReserved4",12);
        blockSteamReserved5 = new BlockReserved(blockSteamReservedID5, 1.5F, 20.0F, "SteamReserved5",12);
        blockSteamReserved6 = new BlockReserved(blockSteamReservedID6, 1.5F, 20.0F, "SteamReserved6",12);
        blockSteamReserved7 = new BlockReserved(blockSteamReservedID7, 1.5F, 20.0F, "SteamReserved7",12);
        blockSteamReserved8 = new BlockReserved(blockSteamReservedID8, 1.5F, 20.0F, "SteamReserved8",12);
        blockSteamReserved9 = new BlockReserved(blockSteamReservedID9, 1.5F, 20.0F, "SteamReserved9",12);
        blockSteamReserved10 = new BlockReserved(blockSteamReservedID10, 1.5F, 20.0F, "SteamReserved10",12);
        blockSteamReserved11 = new BlockReserved(blockSteamReservedID11, 1.5F, 20.0F, "SteamReserved11",12);
        blockSteamReserved12 = new BlockReserved(blockSteamReservedID12, 1.5F, 20.0F, "SteamReserved12",12);
        blockSteamReserved13 = new BlockReserved(blockSteamReservedID13, 1.5F, 20.0F, "SteamReserved13",12);
        blockSteamReserved14 = new BlockReserved(blockSteamReservedID14, 1.5F, 20.0F, "SteamReserved14",12);
        blockSteamReserved15 = new BlockReserved(blockSteamReservedID15, 1.5F, 20.0F, "SteamReserved15",12);
        blockSteamReserved16 = new BlockReserved(blockSteamReservedID16, 1.5F, 20.0F, "SteamReserved16",12);
        blockSteamReserved17 = new BlockReserved(blockSteamReservedID17, 1.5F, 20.0F, "SteamReserved17",12);
        blockSteamReserved18 = new BlockReserved(blockSteamReservedID18, 1.5F, 20.0F, "SteamReserved18",12);
        blockSteamReserved19 = new BlockReserved(blockSteamReservedID19, 1.5F, 20.0F, "SteamReserved19",12);
        blockSteamReserved20 = new BlockReserved(blockSteamReservedID20, 1.5F, 20.0F, "SteamReserved20",12);


        //Add Localization Data
        proxy.PrepareBlock(blockBarbedWire,"Ягоза", "Barbed Wire", true);
    	proxy.PrepareBlock(blockSteamReserved1,"blockSteamReservedRu2", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved2,"blockSteamReservedRu2", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved3,"blockSteamReservedRu3", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved4,"blockSteamReservedRu4", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved5,"blockSteamReservedRu5", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved6,"blockSteamReservedRu6", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved7,"blockSteamReservedRu7", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved8,"blockSteamReservedRu8", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved9,"blockSteamReservedRu9", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved10,"blockSteamReservedRu10", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved11,"blockSteamReservedRu11", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved12,"blockSteamReservedRu12", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved13,"blockSteamReservedRu13", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved14,"blockSteamReservedRu14", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved15,"blockSteamReservedRu14", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved16,"blockSteamReservedRu16", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved17,"blockSteamReservedRu", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved18,"blockSteamReservedRu", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved19,"blockSteamReservedRu", "blockEnSteamReserved", false);
    	proxy.PrepareBlock(blockSteamReserved20,"blockSteamReservedRu", "blockEnSteamReserved", false);
    	
    }
    // метод для передачи данных блокам, после индентификации предметов. Необязательно реализовывать так. Это мой подход.
    private void postBlock()
    {
        // Специфический метод для передачи данных об итеме, который мы будем дропать    
    }
    private void itemForge()
    {   
        proxy.CreateItem(cottonHat, "Хлопковая кепка", "Cotton hat");
        proxy.CreateItem(cottonJacket, "Хлопковая куртка", "Cotton jacket");
        proxy.CreateItem(cottonPants, "Хлопковые штаны", "Cotton pants");
        proxy.CreateItem(cottonBoots, "Хлопковые туфли", "Cotton Boots");
        proxy.CreateItem(silkHat, "Шелковая шляпа", "Silk hat");
        proxy.CreateItem(silkJacket, "Шелковый пиджак", "Silk jacket");
        proxy.CreateItem(silkPants, "Шелковые брюки", "Silk trouses");
        proxy.CreateItem(silkBoots, "Ботинки с шелковой подкладкой", "Silk boots");
        proxy.CreateItem(apparelHelmet,  "Каска", "Apparel helmet");
        proxy.CreateItem(apparelVest, "Бронежилет", "Apparel vest");
        proxy.CreateItem(apparelPants, "Армейские штаны", "Apparel pants");
        proxy.CreateItem(apparelBoots, "Кирзачи", "Apparel Boots");   
        proxy.CreateItem(steamsuitHelmet,  "Шлем механического костюма", "Steamsuit Helmet");
        proxy.CreateItem(steamsuitVest,  "Защинтный механизм механического костюма", "Steamsuit Vest");
        proxy.CreateItem(steamsuitPants, "Двигательный механизм механического костюма", "Steamsuit Pants");
        proxy.CreateItem(steamsuitBoots,  "Опорный механизм механического костюма", "Steamsuit Boots");
        //Initialize Items part 1
    		itemSteamReserved0= new ItemReserved(itemSteamReservedID0);
    		proxy.CreateItem(itemSteamReserved0, ++textureID, "itemSteamReserved1", "Резерв", "SteamReserved", false);
			itemSteamReserved1= new ItemReserved(itemSteamReservedID1);
         	proxy.CreateItem(itemSteamReserved1, ++textureID, "itemSteamReserved1", "Резерв", "SteamReserved", false);
			itemSteamReserved2= new ItemReserved(itemSteamReservedID2);
         	proxy.CreateItem(itemSteamReserved2, ++textureID, "itemSteamReserved2", "Резерв", "SteamReserved", false);
			itemSteamReserved3= new ItemReserved(itemSteamReservedID3);
         	proxy.CreateItem(itemSteamReserved3, ++textureID, "itemSteamReserved3", "Резерв", "SteamReserved", false);
			itemSteamReserved4= new ItemReserved(itemSteamReservedID4);
         	proxy.CreateItem(itemSteamReserved4, ++textureID, "itemSteamReserved4", "Резерв", "SteamReserved", false);
			itemSteamReserved5= new ItemReserved(itemSteamReservedID5);
         	proxy.CreateItem(itemSteamReserved5, ++textureID, "itemSteamReserved5", "Резерв", "SteamReserved", false);
			itemSteamReserved6= new ItemReserved(itemSteamReservedID6);
         	proxy.CreateItem(itemSteamReserved6, ++textureID, "itemSteamReserved6", "Резерв", "SteamReserved", false);
			itemSteamReserved7= new ItemReserved(itemSteamReservedID7);
         	proxy.CreateItem(itemSteamReserved7, ++textureID, "itemSteamReserved7", "Резерв", "SteamReserved", false);
			itemSteamReserved8= new ItemReserved(itemSteamReservedID8);
         	proxy.CreateItem(itemSteamReserved8, ++textureID, "itemSteamReserved8", "Резерв", "SteamReserved", false);
			itemSteamReserved9= new ItemReserved(itemSteamReservedID9);
         	proxy.CreateItem(itemSteamReserved9, ++textureID, "itemSteamReserved9", "Резерв", "SteamReserved", false);
			itemSteamReserved10= new ItemReserved(itemSteamReservedID10);
         	proxy.CreateItem(itemSteamReserved10, ++textureID, "itemSteamReserved10", "Резерв", "SteamReserved", false);
			itemSteamReserved11= new ItemReserved(itemSteamReservedID11);
         	proxy.CreateItem(itemSteamReserved11, ++textureID, "itemSteamReserved11", "Резерв", "SteamReserved", false);
			itemSteamReserved12= new ItemReserved(itemSteamReservedID12);
         	proxy.CreateItem(itemSteamReserved12, ++textureID, "itemSteamReserved12", "Резерв", "SteamReserved", false);
			itemSteamReserved13= new ItemReserved(itemSteamReservedID13);
         	proxy.CreateItem(itemSteamReserved13, ++textureID, "itemSteamReserved13", "Резерв", "SteamReserved", false);
			itemSteamReserved14= new ItemReserved(itemSteamReservedID14);
         	proxy.CreateItem(itemSteamReserved14, ++textureID, "itemSteamReserved14", "Резерв", "SteamReserved", false);
			itemSteamReserved15= new ItemReserved(itemSteamReservedID15);
         	proxy.CreateItem(itemSteamReserved15, ++textureID, "itemSteamReserved15", "Резерв", "SteamReserved", false);
			itemSteamReserved16= new ItemReserved(itemSteamReservedID16);
         	proxy.CreateItem(itemSteamReserved16, ++textureID, "itemSteamReserved16", "Резерв", "SteamReserved", false);
			itemSteamReserved17= new ItemReserved(itemSteamReservedID17);
         	proxy.CreateItem(itemSteamReserved17, ++textureID, "itemSteamReserved17", "Резерв", "SteamReserved", false);
			itemSteamReserved18= new ItemReserved(itemSteamReservedID18);
         	proxy.CreateItem(itemSteamReserved18, ++textureID, "itemSteamReserved18", "Резерв", "SteamReserved", false);
			itemSteamReserved19= new ItemReserved(itemSteamReservedID19);
         	proxy.CreateItem(itemSteamReserved19, ++textureID, "itemSteamReserved19", "Резерв", "SteamReserved", false);
			itemSteamReserved20= new ItemReserved(itemSteamReservedID20);
         	proxy.CreateItem(itemSteamReserved20, ++textureID, "itemSteamReserved20", "Резерв", "SteamReserved", false);
			itemSteamReserved21= new ItemReserved(itemSteamReservedID21);
         	proxy.CreateItem(itemSteamReserved21, ++textureID, "itemSteamReserved21", "Резерв", "SteamReserved", false);
			itemSteamReserved22= new ItemReserved(itemSteamReservedID22);
         	proxy.CreateItem(itemSteamReserved22, ++textureID, "itemSteamReserved22", "Резерв", "SteamReserved", false);
			itemSteamReserved23= new ItemReserved(itemSteamReservedID23);
         	proxy.CreateItem(itemSteamReserved23, ++textureID, "itemSteamReserved23", "Резерв", "SteamReserved", false);
			itemSteamReserved24= new ItemReserved(itemSteamReservedID24);
         	proxy.CreateItem(itemSteamReserved24, ++textureID, "itemSteamReserved24", "Резерв", "SteamReserved", false);
			itemSteamReserved25= new ItemReserved(itemSteamReservedID25);
         	proxy.CreateItem(itemSteamReserved25, ++textureID, "itemSteamReserved25", "Резерв", "SteamReserved", false);
			itemSteamReserved26= new ItemReserved(itemSteamReservedID26);
         	proxy.CreateItem(itemSteamReserved26, ++textureID, "itemSteamReserved26", "Резерв", "SteamReserved", false);
			itemSteamReserved27= new ItemReserved(itemSteamReservedID27);
         	proxy.CreateItem(itemSteamReserved27, ++textureID, "itemSteamReserved27", "Резерв", "SteamReserved", false);
			itemSteamReserved28= new ItemReserved(itemSteamReservedID28);
         	proxy.CreateItem(itemSteamReserved28, ++textureID, "itemSteamReserved28", "Резерв", "SteamReserved", false);
			itemSteamReserved29= new ItemReserved(itemSteamReservedID29);
         	proxy.CreateItem(itemSteamReserved29, ++textureID, "itemSteamReserved29", "Резерв", "SteamReserved", false);
			itemSteamReserved30= new ItemReserved(itemSteamReservedID30);
         	proxy.CreateItem(itemSteamReserved30, ++textureID, "itemSteamReserved30", "Резерв", "SteamReserved", false);
			itemSteamReserved31= new ItemReserved(itemSteamReservedID31);
         	proxy.CreateItem(itemSteamReserved31, ++textureID, "itemSteamReserved31", "Резерв", "SteamReserved", false);
			itemSteamReserved32= new ItemReserved(itemSteamReservedID32);
         	proxy.CreateItem(itemSteamReserved32, ++textureID, "itemSteamReserved32", "Резерв", "SteamReserved", false);
			itemSteamReserved33= new ItemReserved(itemSteamReservedID33);
         	proxy.CreateItem(itemSteamReserved33, ++textureID, "itemSteamReserved33", "Резерв", "SteamReserved", false);
			itemSteamReserved34= new ItemReserved(itemSteamReservedID34);
         	proxy.CreateItem(itemSteamReserved34, ++textureID, "itemSteamReserved34", "Резерв", "SteamReserved", false);
			itemSteamReserved35= new ItemReserved(itemSteamReservedID35);
         	proxy.CreateItem(itemSteamReserved35, ++textureID, "itemSteamReserved35", "Резерв", "SteamReserved", false);
			itemSteamReserved36= new ItemReserved(itemSteamReservedID36);
         	proxy.CreateItem(itemSteamReserved36, ++textureID, "itemSteamReserved36", "Резерв", "SteamReserved", false);
			itemSteamReserved37= new ItemReserved(itemSteamReservedID37);
         	proxy.CreateItem(itemSteamReserved37, ++textureID, "itemSteamReserved37", "Резерв", "SteamReserved", false);
			itemSteamReserved38= new ItemReserved(itemSteamReservedID38);
         	proxy.CreateItem(itemSteamReserved38, ++textureID, "itemSteamReserved38", "Резерв", "SteamReserved", false);
			itemSteamReserved39= new ItemReserved(itemSteamReservedID39);
         	proxy.CreateItem(itemSteamReserved39, ++textureID, "itemSteamReserved39", "Резерв", "SteamReserved", false);
			itemSteamReserved40= new ItemReserved(itemSteamReservedID40);
         	proxy.CreateItem(itemSteamReserved40, ++textureID, "itemSteamReserved40", "Резерв", "SteamReserved", false);
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
    private static int cottonID = ModLoader.addArmor("cotton");
    private static int silkID = ModLoader.addArmor("silk");
    private static int apparelID = ModLoader.addArmor("apparel");
    private static int steamID = ModLoader.addArmor("steamsuit");

    private static int armorID0= 3001;
    private static int armorID1= 3002;
    private static int armorID2= 3003;
    private static int armorID3= 3004;
    private static int armorID4= 3005;
    private static int armorID5= 3006;
    private static int armorID6= 3007;
    private static int armorID7= 3008;
    private static int armorID8= 3009;
    private static int armorID9= 3010;
    private static int armorID10= 3011;
    private static int armorID11= 3012;
    private static int armorID12= 3013;
    private static int armorID13= 3014;
    private static int armorID14= 3015;
    private static int armorID15= 3016;
    
    public static final ItemSteamWear cottonHat = new ItemSteamWear(armorID0, SteamEnumArmorMaterial.COTTON, cottonID, 0, getProperArmorIndex(0,0), "cottonHat");
    public static final ItemSteamWear cottonJacket = new ItemSteamWear(armorID1, SteamEnumArmorMaterial.COTTON, cottonID, 1, getProperArmorIndex(0,1), "cottonJaket");
    public static final ItemSteamWear cottonPants = new ItemSteamWear(armorID2, SteamEnumArmorMaterial.COTTON, cottonID, 2, getProperArmorIndex(0,2), "cottonPants");
    public static final ItemSteamWear cottonBoots = new ItemSteamWear(armorID3, SteamEnumArmorMaterial.COTTON, cottonID, 3, getProperArmorIndex(0,3), "cottonBoots");

    public static final ItemSteamWear silkHat = new ItemSteamWear(armorID4, SteamEnumArmorMaterial.SILK, silkID, 0, getProperArmorIndex(1,0),"silkHat");
    public static final ItemSteamWear silkJacket = new ItemSteamWear(armorID5, SteamEnumArmorMaterial.SILK, silkID, 1, getProperArmorIndex(1,1), "silkJaket");
    public static final ItemSteamWear silkPants = new ItemSteamWear(armorID6,SteamEnumArmorMaterial.SILK, silkID, 2, getProperArmorIndex(1,2),"silkPants");
    public static final ItemSteamWear silkBoots = new ItemSteamWear(armorID7,SteamEnumArmorMaterial.SILK, silkID, 3, getProperArmorIndex(1,3), "silkBoots");

    public static final ItemSteamWear apparelHelmet = new ItemSteamWear(armorID8, SteamEnumArmorMaterial.APPAREL, apparelID, 0, getProperArmorIndex(2,0),"apparelHelmet");
    public static final ItemSteamWear apparelVest = new ItemSteamWear(armorID9, SteamEnumArmorMaterial.APPAREL, apparelID, 1, getProperArmorIndex(2,1), "apparelVest");
    public static final ItemSteamWear apparelPants = new ItemSteamWear(armorID10, SteamEnumArmorMaterial.APPAREL, apparelID, 2, getProperArmorIndex(2,2), "apparelPants");
    public static final ItemSteamWear apparelBoots = new ItemSteamWear(armorID11, SteamEnumArmorMaterial.APPAREL, apparelID, 3, getProperArmorIndex(2,3), "apparelBoots");
           
    public static final ItemSteamWear steamsuitHelmet = new ItemSteamWear(armorID12, SteamEnumArmorMaterial.STEAMSUIT, steamID, 0, getProperArmorIndex(3,0), "steamsuitHelmet");
    public static final ItemSteamWear steamsuitVest = new ItemSteamWear(armorID13, SteamEnumArmorMaterial.STEAMSUIT, steamID, 1, getProperArmorIndex(3,1), "steamsuitVest");
    public static final ItemSteamWear steamsuitPants = new ItemSteamWear(armorID14, SteamEnumArmorMaterial.STEAMSUIT, steamID, 2, getProperArmorIndex(3,2), "steamsuitPants");
    public static final ItemSteamWear steamsuitBoots = new ItemSteamWear(armorID15, SteamEnumArmorMaterial.STEAMSUIT, steamID, 3, getProperArmorIndex(3,3), "steamsuitBoots");
    
    //reserved items
    public static Item itemSteamReserved0;
    public static Item itemSteamReserved1;
    public static Item itemSteamReserved2;
    public static Item itemSteamReserved3;
    public static Item itemSteamReserved4;
    public static Item itemSteamReserved5;
    public static Item itemSteamReserved6;
    public static Item itemSteamReserved7;
    public static Item itemSteamReserved8;
    public static Item itemSteamReserved9;
    public static Item itemSteamReserved10;
    public static Item itemSteamReserved11;
    public static Item itemSteamReserved12;
    public static Item itemSteamReserved13;
    public static Item itemSteamReserved14;
    public static Item itemSteamReserved15;
    public static Item itemSteamReserved16;
    public static Item itemSteamReserved17;
    public static Item itemSteamReserved18;
    public static Item itemSteamReserved19;
    public static Item itemSteamReserved20;
    public static Item itemSteamReserved21;
    public static Item itemSteamReserved22;
    public static Item itemSteamReserved23;
    public static Item itemSteamReserved24;
    public static Item itemSteamReserved25;
    public static Item itemSteamReserved26;
    public static Item itemSteamReserved27;
    public static Item itemSteamReserved28;
    public static Item itemSteamReserved29;
    public static Item itemSteamReserved30;
    public static Item itemSteamReserved31;
    public static Item itemSteamReserved32;
    public static Item itemSteamReserved33;
    public static Item itemSteamReserved34;
    public static Item itemSteamReserved35;
    public static Item itemSteamReserved36;
    public static Item itemSteamReserved37;
    public static Item itemSteamReserved38;
    public static Item itemSteamReserved39;
    public static Item itemSteamReserved40;
    
    //reserved blocks
    
    public static BlockBarbedWire blockBarbedWire;
    public static BlockReserved blockSteamReserved1;
    public static BlockReserved blockSteamReserved2;
    public static BlockReserved blockSteamReserved3;
    public static BlockReserved blockSteamReserved4;
    public static BlockReserved blockSteamReserved5;
    public static BlockReserved blockSteamReserved6;
    public static BlockReserved blockSteamReserved7;
    public static BlockReserved blockSteamReserved8;
    public static BlockReserved blockSteamReserved9;
    public static BlockReserved blockSteamReserved10;
    public static BlockReserved blockSteamReserved11;
    public static BlockReserved blockSteamReserved12;
	public static BlockReserved blockSteamReserved13;
	public static BlockReserved blockSteamReserved14;
	public static BlockReserved blockSteamReserved15;
	public static BlockReserved blockSteamReserved16;
	public static BlockReserved blockSteamReserved17;
	public static BlockReserved blockSteamReserved18;
	public static BlockReserved blockSteamReserved19;
	public static BlockReserved blockSteamReserved20;
	
		private int blockID = 500;
	    private int itemSteamID = 10000;
	    //private int metaBlockID = 1556;
	    private int textureID = 0;
	    //private int metaTexturesID = 0;
	    //BlockIDs
	    private int blockBarbedWireID;
	    private int blockSteamReservedID1;
	    private int blockSteamReservedID2;
	    private int blockSteamReservedID3;
	    private int blockSteamReservedID4;
	    private int blockSteamReservedID5;
	    private int blockSteamReservedID6;
	    private int blockSteamReservedID7;
	    private int blockSteamReservedID8;
	    private int blockSteamReservedID9;
	    private int blockSteamReservedID10;
	    private int blockSteamReservedID11;
	    private int blockSteamReservedID12;
	    private int blockSteamReservedID13;
	    private int blockSteamReservedID14;
	    private int blockSteamReservedID15;
	    private int blockSteamReservedID16;
	    private int blockSteamReservedID17;
	    private int blockSteamReservedID18;
	    private int blockSteamReservedID19;
	    private int blockSteamReservedID20;
	    //SteamReserved items IDs

	    private static int itemSteamReservedID0;
	    private static int itemSteamReservedID1;
	    private static int itemSteamReservedID2;
	    private static int itemSteamReservedID3;
	    private static int itemSteamReservedID4;
	    private static int itemSteamReservedID5;
	    private static int itemSteamReservedID6;
	    private static int itemSteamReservedID7;
	    private static int itemSteamReservedID8;
	    private static int itemSteamReservedID9;
	    private static int itemSteamReservedID10;
	    private static int itemSteamReservedID11;
	    private static int itemSteamReservedID12;
	    private static int itemSteamReservedID13;
	    private static int itemSteamReservedID14;
	    private static int itemSteamReservedID15;
	    private static int itemSteamReservedID16;
	    private static int itemSteamReservedID17;
	    private static int itemSteamReservedID18;
	    private static int itemSteamReservedID19;
	    private static int itemSteamReservedID20;
	    private static int itemSteamReservedID21;
	    private static int itemSteamReservedID22;
	    private static int itemSteamReservedID23;
	    private static int itemSteamReservedID24;
	    private static int itemSteamReservedID25;
	    private static int itemSteamReservedID26;
	    private static int itemSteamReservedID27;
	    private static int itemSteamReservedID28;
	    private static int itemSteamReservedID29;
	    private static int itemSteamReservedID30;
	    private static int itemSteamReservedID31;
	    private static int itemSteamReservedID32;
	    private static int itemSteamReservedID33;
	    private static int itemSteamReservedID34;
	    private static int itemSteamReservedID35;
	    private static int itemSteamReservedID36;
	    private static int itemSteamReservedID37;
	    private static int itemSteamReservedID38;
	    private static int itemSteamReservedID39;
	    private static int itemSteamReservedID40;
	    
}
