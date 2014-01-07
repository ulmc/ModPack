package ru.ulmc.extender;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.FMLLog;

public class ConfigurationHander {
	public static Configuration config;

	public static void init() {
		config = new Configuration(new File("config" + File.separator + Reference.MOD_ID + File.separator + "main.cfg"));

		try {
			config.load();
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + "Has a problem loading the config file");
		} finally {
			config.save();
		}
	}
	
	public static int getBlockID(String name, int id) {
		try {
			Property prop = config.getBlock(name, id);
			return prop.getInt(id);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + "Has a problem loading the config file");
			return id;
		} finally {
			config.save();			
		}		
	}
	
	public static int getItemID(String name, int id) {
		try {
			Property prop = config.getItem(name, id);
			return prop.getInt(id);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + "Has a problem loading the config file");
			return id;
		} finally {
			config.save();			
		}		
	}
}
