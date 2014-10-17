package ru.ulmc.extender.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by 45 on 16.10.2014.
 */
public class ItemColoredFurniture extends ItemBlock {

	private final static String[] subNames = {
			"white", "orange",  "magenta", "lightBlue", "yellow", "lightGreen",
			"pink", "darkGrey", "lightGrey", "cyan", "purple", "blue", "brown",
			"green", "red", "black"
	};

	public ItemColoredFurniture(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName() + "." + subNames[itemstack.getItemDamage()];
	}
}
