package ru.ulmc.steampeople;

import net.minecraft.src.ItemArmor;

public enum SteamEnumArmorMaterial {
		// 1 - имя, 2 - ID, 3 - множитель прочности, 4 - массив защиты(шлем, броник, штаны, обувь), 5 - энчантность в уровнях.
	   COTTON("COTTON", 10, 10, new int[] {1, 2, 1, 1}, 5), 
	   SILK("SILK", 11, 15, new int[] {1, 2, 1, 1}, 20), 
	   APPAREL("APPAREL", 12, 25, new int[] {3, 4, 1, 2}, 30), 
	   STEAMSUIT("STEAMSUIT", 13, 33, new int[] {4, 5, 4, 3}, 45);
       private int maxDamageFactor;
       private int damageReductionAmountArray[];
       private int enchantability;
       private static final SteamEnumArmorMaterial allArmorMaterials[];

       private SteamEnumArmorMaterial(String s, int i, int j, int ai[], int k)
       {
               maxDamageFactor = j;
               damageReductionAmountArray = ai;
               enchantability = k;
       }

       public int getDurability(int i)
       {
               return ItemSteamWear.getMaxDamageArray()[i] * maxDamageFactor;
       }

       public int getDamageReductionAmount(int i)
       {
               return damageReductionAmountArray[i];
       }

       public int getEnchantability()
       {
               return enchantability;
       }

       static
       {
               allArmorMaterials = (new SteamEnumArmorMaterial[] {COTTON, SILK, STEAMSUIT, APPAREL});
       }
}