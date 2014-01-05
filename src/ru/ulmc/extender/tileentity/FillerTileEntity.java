package ru.ulmc.extender.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class FillerTileEntity extends TileEntity {
	protected int primaryX;
	protected int primaryY;
	protected int primaryZ;

	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("px", primaryX);
		par1NBTTagCompound.setInteger("py", primaryY);
		par1NBTTagCompound.setInteger("pz", primaryZ);
	}

	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.primaryX = par1NBTTagCompound.getInteger("px");
		this.primaryY = par1NBTTagCompound.getInteger("py");
		this.primaryZ = par1NBTTagCompound.getInteger("pz");
	}

	public int getPrimaryX() {
		return primaryX;
	}

	public void setPrimaryX(int primaryX) {
		this.primaryX = primaryX;
	}

	public int getPrimaryY() {
		return primaryY;
	}

	public void setPrimaryY(int primaryY) {
		this.primaryY = primaryY;
	}

	public int getPrimaryZ() {
		return primaryZ;
	}

	public void setPrimaryZ(int primaryZ) {
		this.primaryZ = primaryZ;
	}
	
}
