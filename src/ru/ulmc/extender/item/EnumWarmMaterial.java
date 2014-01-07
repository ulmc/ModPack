package ru.ulmc.extender.item;

public enum EnumWarmMaterial {
	// 1 - им€, 2 - ID, 3 - множитель прочности, 4 - массив защиты(шлем, броник,
	// штаны, обувь), 5 - энчантность в уровн€х, 6 - теплота.
	COTTON("COTTON", 10, 10, new int[] { 0, 2, 1, 1 }, 5, 0.5f),
	APPAREL("APPAREL", 11, 20, new int[] { 2, 3, 1, 1 }, 9, 0.6f),
	FUR("FUR", 12, 20, new int[] { 1, 3, 2, 2 }, 10, 1.1f),
    IRONFUR("IRONFUR", 13, 15, new int[]{2, 6, 5, 2}, 9, 1.1f),
    DIAMONDFUR("DIAMONDFUR", 14, 33, new int[]{3, 8, 6, 3}, 10, 1.1f),
	HIDDEN("HIDDEN", 15, 10, new int[] { 0, 1, 1, 0 }, 5, 0.1f);
	
	private int maxDamageFactor;
	private int damageReductionAmountArray[];
	private int enchantability;
	private float warmLevel;
	private static final EnumWarmMaterial allArmorMaterials[] = new EnumWarmMaterial[] { COTTON, FUR, IRONFUR, DIAMONDFUR };

	private EnumWarmMaterial(String s, int i, int j, int ai[], int k, float warmLevel) {
		maxDamageFactor = j;
		damageReductionAmountArray = ai;
		enchantability = k;
		this.warmLevel = warmLevel;
	}

	public float getWarmLevel() {
		return warmLevel;
	}

	public void setWarmLevel(float warmLevel) {
		this.warmLevel = warmLevel;
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