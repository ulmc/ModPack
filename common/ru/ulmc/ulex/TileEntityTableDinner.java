package ru.ulmc.ulex;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;

public class TileEntityTableDinner extends TileEntity
{
	private int tType;
	/**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("t", this.tType);
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.tType = par1NBTTagCompound.getInteger("t");
    }
    public void setType(int i)
    {
        this.tType = i;
        this.onInventoryChanged();
    }
    public int getType()
    {
        return this.tType;
    }
}
