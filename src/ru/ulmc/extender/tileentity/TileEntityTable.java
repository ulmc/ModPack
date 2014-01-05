package ru.ulmc.extender.tileentity;

import net.minecraft.nbt.NBTTagCompound;

public class TileEntityTable extends ExtendedTileEntity {
	
	public static final int MODEL_TABLE = 1;
	public static final int MODEL_CABINET = 2;
	public static final int MODEL_DINNER = 3;	
	
	protected int model;

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("model", this.model);
//		UltimateExtender.logger.info("writeToNBT: " + this.model);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		this.model = par1NBTTagCompound.getInteger("model");
//		UltimateExtender.logger.info("readFromNBT: " + this.model);
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

}
