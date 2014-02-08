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

package ru.ulmc.extender.config;

import java.io.File;
import java.util.Map;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.FMLLog;
import ru.ulmc.extender.Reference;

public class ConfigurationHander {
	public static Configuration config;

    public static final ThievesCraftConfig tcConfig = new ThievesCraftConfig();
    public static final SurvivalSeasonConfig ssConfig = new SurvivalSeasonConfig();
    public static final StringsConfig stringsConfig = new StringsConfig();

	public static void init() {
		config = new Configuration(new File("config" + File.separator + Reference.MOD_ID + File.separator + "main.cfg"));

		try {
			config.load();
            initThievesCraft();
            initSurvivalSeason();
            initStrings();
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
    public static boolean getBoolean(String module, String param, boolean def) {
        try {
            Property prop = config.get(module, param, def);
            return prop.getBoolean(def);
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + "Has a problem loading the config file");
            return def;
        } finally {
            config.save();
        }
    }
    public static String getString(String module, String param, String def) {
        try {
            Property prop = config.get(module, param, def);

            return prop.getString();
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_ID + "Has a problem loading the config file");
            return def;
        } finally {
            config.save();
        }
    }

    private static void initThievesCraft() {
        tcConfig.setEnabled(getBoolean(tcConfig.getModuleName(), ThievesCraftConfig.FIELD_ENABLED, true));
    }

    private static void initSurvivalSeason() {
        ssConfig.setEnabled(getBoolean(ssConfig.getModuleName(), SurvivalSeasonConfig.FIELD_ENABLED, true));
    }

    private static void initStrings() {
        Map<String, String> map = stringsConfig.getMap();
        for(String key : map.keySet()) {
            stringsConfig.setLocale(key, getString(stringsConfig.getModuleName(), key, map.get(key)));
        }
    }

}
