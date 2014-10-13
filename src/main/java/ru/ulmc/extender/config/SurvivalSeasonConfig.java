/*
 * Copyright (C) 2014. ulmc.ru (Alex K.)
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
 */

package ru.ulmc.extender.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 45 on 24.01.14.
 */
public class SurvivalSeasonConfig extends BaseModuleConfig {
	public final Map<String, Integer> intMap = new HashMap<String, Integer>();
	public final Map<String, Double> doubleMap = new HashMap<String, Double>();
	public final Map<String, Boolean> booleanMap = new HashMap<String, Boolean>();

	public SurvivalSeasonConfig() {
		this.moduleName = "SurvivalSeason";
		booleanMap.put("thermal.event.enabled", true);
		booleanMap.put("client.debug", true);
		intMap.put("thermal.updateStep", 30);
		intMap.put("thermal.undergroundPosition", 52);
		intMap.put("thermal.gui.thermometer.x", 70);
		intMap.put("thermal.gui.thermometer.y", 52);
		intMap.put("thermal.debug.sendMessageToPlayer", 1);

		doubleMap.put("thermal.multiplier.coldBiome", 0.8d);
		doubleMap.put("thermal.multiplier.hotBiome", 0.5d);
		doubleMap.put("thermal.multiplier.hell", 1.2d);
		doubleMap.put("thermal.neutral.value", 0.60d);
		doubleMap.put("thermal.neutral.deviation", 0.2d);

		doubleMap.put("thermal.underGroundBonus", 0.3d);
		doubleMap.put("thermal.underGroundCoolBonus", 0.4d);
		doubleMap.put("thermal.defaultArmorWarmness", 0.5d);
		doubleMap.put("thermal.defaultArmorCoolness", 0.3d);
		doubleMap.put("thermal.defaultNoneArmorCoolness", 0.5d);
		doubleMap.put("thermal.defaultArmorLavaProtection", 0.5d);
		doubleMap.put("thermal.defaultNoneArmorLavaProtection", 0.5d);
		doubleMap.put("thermal.inWaterPenalty", 0.4d);
		doubleMap.put("thermal.inSnowPenalty", 0.2d);
		doubleMap.put("thermal.waterNearBonus", 0.3d);
		doubleMap.put("thermal.fireResistanceBonus", 0.5d);
		doubleMap.put("thermal.nightPenalty", 0.2d);
		doubleMap.put("thermal.dayPenalty", 0.3d);
		doubleMap.put("thermal.stormPenalty", 0.3d);
		doubleMap.put("thermal.rainPenalty", 0.15d);
		doubleMap.put("thermal.torchBonus", 0.2d);
		doubleMap.put("thermal.lavaPenalty", 0.8d);
		doubleMap.put("thermal.coldItemBonus", 0.2d);

		doubleMap.put("thermal.multiplier.packet", 0.07d);
		doubleMap.put("thermal.multiplier.normalization", 0.7d);
		doubleMap.put("thermal.multiplier.render", 0.2d);
		doubleMap.put("thermal.damageSize", 5.0d);
	}
}
