package ru.ulmc.ulex;

import net.minecraft.src.Block;
import net.minecraft.src.ItemReed;

public class ItemChair extends ItemReed
{
	private int chairType;
    public ItemChair(int i, Block block, int aChairType)
    {
    	super(i, block);
    	chairType = aChairType;
    }
    public int getType()
    {
        return chairType;
    }
    public int maxStackSize()
    {
        return 4;
    }
}
