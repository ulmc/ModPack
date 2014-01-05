package ru.ulmc.extender;

import java.util.logging.Logger;

import net.minecraftforge.common.MinecraftForge;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.events.MobDropEventsHook;
import ru.ulmc.extender.events.PlayerEventsHook;
import ru.ulmc.extender.gui.handler.GuiHandler;
import ru.ulmc.extender.item.ItemManager;
import ru.ulmc.extender.proxy.CommonProxy;
import ru.ulmc.extender.proxy.PacketManager;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(	modid = Reference.MOD_ID, 
		name = Reference.MOD_NAME, 
		version =  Reference.MOD_VERSION)
@NetworkMod(channels = { Reference.NETWORK_CHANNEL }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketManager.class)
public class UltimateExtender {
	
	@Instance
	public static UltimateExtender instance;
	public static Logger logger;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = Logger.getLogger(Reference.MOD_ID);
		logger.setParent(FMLLog.getLogger());
		proxy.preInit(); // You have to call the methods in your proxy class
		BlockManager.init(proxy);
		ItemManager.init(proxy);
		RecipeManager.init(proxy);
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent evt) {

		proxy.registerTileEntitySpecialRenderer();
		registerEventHooks();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {
		// TODO: Add Post-Initialization code such as mod hooks
	}
		
	private static void registerEventHooks(){
		MinecraftForge.EVENT_BUS.register(new PlayerEventsHook());
		MinecraftForge.EVENT_BUS.register(new MobDropEventsHook());
	}
	
	
}
