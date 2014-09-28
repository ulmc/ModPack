package ru.ulmc.extender.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 45 on 24.01.14.
 */
public class SurvivalSeasonConfig extends BaseModuleConfig {
	public final Map<String, Integer> intMap = new HashMap<String, Integer>();
	public final Map<String, Double> doubleMap = new HashMap<String, Double>();

	public SurvivalSeasonConfig() {
		this.moduleName = "SurvivalSeason";
		intMap.put("thermal.updateStep", 30);
		intMap.put("thermal.undergroundPosition", 52);
		intMap.put("thermal.gui.thermometer.x", 70);
		intMap.put("thermal.gui.thermometer.y", 52);
		intMap.put("thermal.debug.sendMessageToPlayer", 1);

		doubleMap.put("thermal.multiplier.coldBiome", 1.5d);
		doubleMap.put("thermal.multiplier.hotBiome", 1.1d);
		doubleMap.put("thermal.multiplier.hell", 1.2d);
		doubleMap.put("thermal.neutral.value", 0.6d);
		doubleMap.put("thermal.allowable.deviation", 0.2d);

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
