package ru.ulmc.extender.item;

import ru.ulmc.extender.Reference;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemReed;

public class BasicPlaceableItem extends ItemReed {
	public BasicPlaceableItem(int i, String unlocalizedName, Block block) {
		super(i, block);
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.RES_NAME + unlocalizedName);
		 setCreativeTab(CreativeTabs.tabBlock);
	}
}
