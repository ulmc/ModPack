package ru.ulmc.extender.item;

import ru.ulmc.extender.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicCraftItem extends Item {
	public BasicCraftItem(int i, String unlocalizedName) {
		super(i);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.RES_NAME + unlocalizedName);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
