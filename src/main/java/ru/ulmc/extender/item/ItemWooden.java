package ru.ulmc.extender.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by 45 on 16.10.2014.
 */
public class ItemWooden extends ItemBlock {

	public static final String[] subNames = new String[] {"Oak", "Spruce", "Birch", "Jungle", "Acacia", "BigOak"};

	public ItemWooden(Block block) {
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
