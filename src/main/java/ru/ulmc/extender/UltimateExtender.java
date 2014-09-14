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


import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Logger;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.config.ConfigurationHander;
import ru.ulmc.extender.events.MobDropEventsHook;
import ru.ulmc.extender.events.PlayerEventsHook;
import ru.ulmc.extender.gui.handler.GuiHandler;
import ru.ulmc.extender.item.ItemManager;
import ru.ulmc.extender.network.WarmPacket;
import ru.ulmc.extender.proxy.CommonProxy;
import ru.ulmc.extender.render.particle.EntityChestContentFX;
import ru.ulmc.extender.render.particle.EntityLockFX;
import ru.ulmc.extender.render.particle.EntityTestFX;
import ru.ulmc.extender.render.particle.UParticle;
import ru.ulmc.extender.events.WarmHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class UltimateExtender {

	@Instance
	public static UltimateExtender instance;
	public static Logger logger;
    public static SimpleNetworkWrapper networkWrapper;
    private static StringBuilder stringBuilder = new StringBuilder();
    private TimerManager timerManager = new TimerManager();


	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
        networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.NETWORK_CHANNEL);
		ConfigurationHander.init();
		logger = FMLLog.getLogger();
		proxy.preInit(); 
		BlockManager.init(proxy);
		ItemManager.init(proxy);
		RecipeManager.init(proxy);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        networkWrapper.registerMessage(WarmPacket.Handler.class, WarmPacket.class, 0, Side.CLIENT);
	}

	@EventHandler
	public void init(FMLInitializationEvent evt) {
		//EntityRegistry.registerModEntity(EntityFallingBlock.class, "fallingBlockOfBones", 6, this, 644, 120, false);
		proxy.registerTileEntitySpecialRenderer();

		registerEventHooks();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent evt) {

	}

	private static void registerEventHooks() {
		MinecraftForge.EVENT_BUS.register(new PlayerEventsHook());
		MinecraftForge.EVENT_BUS.register(new MobDropEventsHook());
		MinecraftForge.EVENT_BUS.register(new WarmHandler());
	}
	
	public static void markSomeBlockForUpdate(World world, int x, int y, int z) {
		if(!world.isRemote) {
			world.markBlockForUpdate(x, y, z);
		}
	}
	
	public static String concat(String... args) {
		stringBuilder.delete(0, stringBuilder.length());
		for (int i = 0; i < args.length; i++) {
			stringBuilder.append(args[i]);
		}
		return stringBuilder.toString();		
	}
	@SideOnly(Side.CLIENT)
	public static void spawnParticle(int particleID, World world, double x, double y, double z) {
		EntityFX particle = null;
		switch(particleID) {
		case UParticle.LOCK:
			particle = new EntityLockFX(world, x, y, z);
			break;
        case UParticle.TEST:
        default:
            particle = new EntityTestFX(world, x, y, z);
            break;
		}
		Minecraft.getMinecraft().effectRenderer.addEffect(particle);
	}

    /**
     * Spawns Special Locked Chest Content Particle
     * @param particleImageName - unlocalizedName without "item."
     * @param world
     * @param x
     * @param y
     * @param z
     */
    @SideOnly(Side.CLIENT)
    public static void spawnParticle(String particleImageName, World world, double x, double y, double z) {
        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityChestContentFX(particleImageName, world, x, y, z));
    }

    /**
     * Returns localized string from file.
     * @param key
     * @return
     */
    public static String loc(String key) {
      // return LanguageRegistry.instance().getStringLocalization(key);
        return ConfigurationHander.stringsConfig.getLocale(key);
    }

    public TimerManager getTimerManager() {
        return timerManager;
    }


}
