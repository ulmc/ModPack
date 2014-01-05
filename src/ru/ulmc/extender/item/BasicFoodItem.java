package ru.ulmc.extender.item;

import ru.ulmc.extender.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class BasicFoodItem extends ItemFood {
	
	public BasicFoodItem(	int par1, String unlocalizedName, 
							int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.RES_NAME + unlocalizedName);
		setCreativeTab(CreativeTabs.tabFood);
	}
}
