package ru.ulmc.ulex;

import net.minecraft.src.Block;
import net.minecraft.src.ItemReed;

public class ItemCrystal extends ItemReed
{
	private int type;
    public ItemCrystal(int i, Block block, int aType)
    {
    	super(i, block);
    	type = aType;
    }
    public int getType()
    {
        return type;
    }
}
