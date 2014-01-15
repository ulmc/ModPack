/**
 * Copyright (C) 2014 Kolmogorov Alexey
 * 
 * This file part of ulmc.ru ModPack
 * 
 * ulmc.ru ModPack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ulmc.ru ModPack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/].
 * 
 */
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
