package ru.ulmc.extender.tileentity;

import net.minecraft.nbt.NBTTagCompound;

public class TileEntityFiller extends ExtendedTileEntity {
	protected int primaryX;
	protected int primaryY;
	protected int primaryZ;
	
	protected float minX;
	protected float maxX;
	protected float minY;
	protected float maxY;
	protected float minZ;
	protected float maxZ;
	
	protected int primaryBlockID;

	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("px", primaryX);
		par1NBTTagCompound.setInteger("py", primaryY);
		par1NBTTagCompound.setInteger("pz", primaryZ);
		
		par1NBTTagCompound.setFloat("minX", minX);
		par1NBTTagCompound.setFloat("maxX", maxX);
		par1NBTTagCompound.setFloat("minY", minY);
		par1NBTTagCompound.setFloat("maxY", maxY);
		par1NBTTagCompound.setFloat("minZ", minZ);
		par1NBTTagCompound.setFloat("maxZ", maxZ);
		
		par1NBTTagCompound.setInteger("primaryBlockID", primaryBlockID);
	}

	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.primaryX = par1NBTTagCompound.getInteger("px");
		this.primaryY = par1NBTTagCompound.getInteger("py");
		this.primaryZ = par1NBTTagCompound.getInteger("pz");
		
		this.minX = par1NBTTagCompound.getFloat("minX");
		this.maxX = par1NBTTagCompound.getFloat("maxX");
		this.minY = par1NBTTagCompound.getFloat("minY");
		this.maxY = par1NBTTagCompound.getFloat("maxY");
		this.minZ = par1NBTTagCompound.getFloat("minZ");
		this.maxZ = par1NBTTagCompound.getFloat("maxZ");
		
		this.primaryBlockID = par1NBTTagCompound.getInteger("primaryBlockID");
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

	public int getPrimaryBlockID() {
		return primaryBlockID;
	}

	public void setPrimaryBlockID(int primaryBlockID) {
		this.primaryBlockID = primaryBlockID;
	}
	
	public void setBoxBounds(float minX,  float minY, float minZ, float maxX, float maxY, float maxZ) {
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
		this.minZ = minZ;	
		this.maxZ = maxZ;
	}

	public float getMinX() {
		return minX;
	}

	public float getMaxX() {
		return maxX;
	}

	public float getMinY() {
		return minY;
	}

	public float getMaxY() {
		return maxY;
	}

	public float getMinZ() {
		return minZ;
	}

	public float getMaxZ() {
		return maxZ;
	}
	
	
}
