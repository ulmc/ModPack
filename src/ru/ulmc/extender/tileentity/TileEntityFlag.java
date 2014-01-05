package ru.ulmc.extender.tileentity;

import net.minecraft.nbt.NBTTagCompound;

public class TileEntityFlag extends ExtendedTileEntity {
	protected int angle;
	protected int type;
	protected int skin;

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("type", this.type);
		par1NBTTagCompound.setInteger("ang", this.angle);
		par1NBTTagCompound.setInteger("skin", this.skin);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.type = par1NBTTagCompound.getInteger("type");
		this.angle = par1NBTTagCompound.getInteger("ang");
		this.skin = par1NBTTagCompound.getInteger("skin");
	}

	public int getAngle() {
		return this.angle;
	}

	public void setValues(byte i, byte j) {
		this.type = i;
		this.angle = j;
	}

	public void setAngle(int i) {
		this.angle = i;
	}

	public void setType(int i) {
		this.type = i;
	}

	public void setSkin(int i) {
		this.skin = i;
	}

	public int getSkin() {
		return this.skin;
	}

	public int getType() {
		return this.type;
	}
}
