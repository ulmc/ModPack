package ru.ulmc.ulex;

import net.minecraft.src.Block;
import net.minecraft.src.ItemReed;

public class ItemTable extends ItemReed
{
	private int tableType;
    public ItemTable(int i, Block block, int aTableType)
    {
    	super(i, block);
    	tableType = aTableType;
    }
    public int getType()
    {
        return tableType;
    }
    public int maxStackSize()
    {
        return 4;
    }
}
