package ru.ulmc.ulex;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;

public class TileEntityEliteChair extends TileEntity
{
	private int cType;
	/**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("t", this.cType);
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.cType = par1NBTTagCompound.getInteger("t");
    }
    public void setType(int i)
    {
        this.cType = i;
        this.onInventoryChanged();
    }
    public int getType()
    {
        return this.cType;
    }
	
}
