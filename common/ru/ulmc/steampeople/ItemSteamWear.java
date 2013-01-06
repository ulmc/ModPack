package ru.ulmc.steampeople;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemSteamWear extends ItemArmor implements IArmorTextureProvider
{
		private static final int maxDamageArray[] = {11, 16, 15, 13};
		public final int armorType;
		public final int damageReduceAmount;
		public final int renderIndex;
		private final SteamEnumArmorMaterial material;
		
		public ItemSteamWear(int i, SteamEnumArmorMaterial enumarmormaterial, int j, int k, int l, String aName)
        {
                super(i, EnumArmorMaterial.CLOTH, j, k);
                material = enumarmormaterial;
                armorType = k;
                renderIndex = j;
                damageReduceAmount = material.getDamageReductionAmount(k);
                setMaxDamage(material.getDurability(k));
                maxStackSize = 4;
                super.setIconIndex(l);
                super.setItemName(aName);
        }

        public int getItemEnchantability()
        {
                return material.getEnchantability();
        }

        public static int[] getMaxDamageArray()
        {
                return maxDamageArray;
        }
        public String getTextureFile()
        {
            return SteamPref.TEXTURE_PATH_ARMOR;
        }
      
		@Override
		public String getArmorTextureFile(ItemStack itemstack) {
			//System.out.println(itemstack.itemID);
			//System.out.println(SteamPeople.cottonHat.shiftedIndex);
			 if(itemstack.itemID == SteamPeople.cottonHat.shiftedIndex || 
	            itemstack.itemID == SteamPeople.cottonJacket.shiftedIndex || 
	            itemstack.itemID == SteamPeople.cottonBoots.shiftedIndex)
	           {
				 return SteamPref.TEXTURE_PATH_ARMOR_SKIN0;
	           }
	           if(itemstack.itemID == SteamPeople.cottonPants.shiftedIndex)
	           {
	           return SteamPref.TEXTURE_PATH_ARMOR_SKIN1;
	           }
	           
	           if(itemstack.itemID == SteamPeople.silkHat.shiftedIndex || 
	                   itemstack.itemID == SteamPeople.silkJacket.shiftedIndex || 
	                   itemstack.itemID == SteamPeople.silkBoots.shiftedIndex)
	                {
	                        return SteamPref.TEXTURE_PATH_ARMOR_SKIN2;
	                }
	                if(itemstack.itemID == SteamPeople.silkPants.shiftedIndex)
	                {
	                        return SteamPref.TEXTURE_PATH_ARMOR_SKIN3;
	                }

	           if(itemstack.itemID == SteamPeople.apparelHelmet.shiftedIndex ||
	        		   itemstack.itemID == SteamPeople.apparelVest.shiftedIndex || 
	                   itemstack.itemID == SteamPeople.apparelBoots.shiftedIndex)
	                {
	                        return SteamPref.TEXTURE_PATH_ARMOR_SKIN4;
	                }
	                if(itemstack.itemID == SteamPeople.apparelPants.shiftedIndex)
	                {
	                        return SteamPref.TEXTURE_PATH_ARMOR_SKIN5;
	                }
	            if(itemstack.itemID == SteamPeople.steamsuitHelmet.shiftedIndex ||
	 	        		itemstack.itemID == SteamPeople.steamsuitVest.shiftedIndex || 
	 	                itemstack.itemID == SteamPeople.steamsuitBoots.shiftedIndex)
	 	             {
	 	                     return SteamPref.TEXTURE_PATH_ARMOR_SKIN6;
	 	             }
	 	            if(itemstack.itemID == SteamPeople.steamsuitPants.shiftedIndex)
	 	            {
	 	                 return SteamPref.TEXTURE_PATH_ARMOR_SKIN7;
	 	            }    
	           return  SteamPref.TEXTURE_PATH_ARMOR_SKIN0;
		}
  }
