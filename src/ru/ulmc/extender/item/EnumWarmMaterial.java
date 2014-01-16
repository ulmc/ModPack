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
package ru.ulmc.extender.item;

public enum EnumWarmMaterial {
	// 1 - имя, 2 - ID, 3 - множитель прочности, 4 - массив защиты(шлем, броник,
	// штаны, обувь), 5 - энчантность в уровнях, 6 - теплота.
	COTTON("COTTON", 10, 10, new int[] { 0, 2, 1, 1 }, 5, 0.3f, 0.7f),
	APPAREL("APPAREL", 11, 20, new int[] { 2, 3, 1, 1 }, 9, 0.4f, 0.7f),
	FUR("FUR", 12, 20, new int[] { 1, 3, 2, 2 }, 10, 1.5f, -0.5f),
    IRONFUR("IRONFUR", 13, 15, new int[]{2, 6, 5, 2}, 9, 1.4f, -0.4f),
    DIAMONDFUR("DIAMONDFUR", 14, 33, new int[]{3, 8, 6, 3}, 10, 1.4f, -0.4f),
	HIDDEN("HIDDEN", 15, 10, new int[] { 0, 1, 1, 0 }, 5, 0.2f, 0.2f);
	
	private int maxDamageFactor;
	private int damageReductionAmountArray[];
	private int enchantability;
	private float warmLevel;
	private float coolLevel;
	private static final EnumWarmMaterial allArmorMaterials[] = new EnumWarmMaterial[] { COTTON, FUR, IRONFUR, DIAMONDFUR };

	private EnumWarmMaterial(String s, int i, int j, int ai[], int k, float warmLevel, float coolLevel) {
		maxDamageFactor = j;
		damageReductionAmountArray = ai;
		enchantability = k;
		this.warmLevel = warmLevel;
		this.coolLevel = coolLevel;
	}

	public float getWarmLevel() {
		return warmLevel;
	}

	public void setWarmLevel(float warmLevel) {
		this.warmLevel = warmLevel;
	}
	

	public float getCoolLevel() {
		return coolLevel;
	}

	public void setCoolLevel(float coolLevel) {
		this.coolLevel = coolLevel;
	}

	public int getDurability(int i) {
		return WarmArmor.getMaxDamageArray()[i] * maxDamageFactor;
	}

	public int getDamageReductionAmount(int i) {
		return damageReductionAmountArray[i];
	}

	public int getEnchantability() {
		return enchantability;
	}
}