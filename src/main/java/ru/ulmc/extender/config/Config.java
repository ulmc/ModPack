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

package ru.ulmc.extender.config;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import ru.ulmc.extender.Reference;

import java.io.File;
import java.util.Map;

public class Config {
	public static final ThievesCraftConfig tcConfig = new ThievesCraftConfig();
	public static final SurvivalSeasonConfig ssConfig = new SurvivalSeasonConfig();
	public static final StringsConfig stringsConfig = new StringsConfig();
	public static Configuration config;

	public static void init() {
		config = new Configuration(new File("config" + File.separator + Reference.MOD_ID + File.separator + "main.cfg"));

		try {
			config.load();
			initThievesCraft();
			initSurvivalSeason();
			initStrings();
		} catch (Exception e) {
			FMLLog.severe(Reference.MOD_ID + "Has a problem loading the config file");
		} finally {
			config.save();
		}
	}

	public static int getSurvivalInt(String key) {
		return ssConfig.intMap.get(key);
	}

	public static float getSurvivalFloat(String key) {
		if(ssConfig.doubleMap.get(key) != null)
			return ssConfig.doubleMap.get(key).floatValue();
		else
			return 0f;
	}

	private static void initThievesCraft() {
		tcConfig.setEnabled(getBoolean(tcConfig.getModuleName(), ThievesCraftConfig.FIELD_ENABLED, true));
	}

	private static void initSurvivalSeason() {
		ssConfig.setEnabled(getBoolean(ssConfig.getModuleName(), SurvivalSeasonConfig.FIELD_ENABLED, true));
		for (String key : ssConfig.intMap.keySet()) {
			getInt(ssConfig.getModuleName(), key, ssConfig.intMap.get(key));
		}
		for (String key : ssConfig.doubleMap.keySet()) {
			getDouble(ssConfig.getModuleName(), key, ssConfig.doubleMap.get(key));
		}
	}

	private static void initStrings() {
		Map<String, String> map = stringsConfig.getMap();
		for (String key : map.keySet()) {
			stringsConfig.setLocale(key, getString(stringsConfig.getModuleName(), key, map.get(key)));
		}
	}


	private static boolean getBoolean(String module, String param, boolean def) {
		try {
			Property prop = config.get(module, param, def);
			return prop.getBoolean(def);
		} catch (Exception e) {
			FMLLog.severe(Reference.MOD_ID + "Has a problem loading the config file");
			return def;
		} finally {
			config.save();
		}
	}

	private static int getInt(String module, String param, int def) {
		try {
			Property prop = config.get(module, param, def);
			return prop.getInt(def);
		} catch (Exception e) {
			FMLLog.severe(Reference.MOD_ID + "Has a problem loading the config file");
			return def;
		} finally {
			config.save();
		}
	}

	private static double getDouble(String module, String param, double def) {
		try {
			Property prop = config.get(module, param, def);
			return prop.getDouble(def);
		} catch (Exception e) {
			FMLLog.severe(Reference.MOD_ID + "Has a problem loading the config file");
			return def;
		} finally {
			config.save();
		}
	}

	private static String getString(String module, String param, String def) {
		try {
			Property prop = config.get(module, param, def);

			return prop.getString();
		} catch (Exception e) {
			FMLLog.severe(Reference.MOD_ID + "Has a problem loading the config file");
			return def;
		} finally {
			config.save();
		}
	}

}
