/**
 * Copyright (C) 2014 ulmc.ru (Alex K.)
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

	public void setAngle(int i) {
		this.angle = i;
	}

	public void setValues(byte i, byte j) {
		this.type = i;
		this.angle = j;
	}

	public int getSkin() {
		return this.skin;
	}

	public void setSkin(int i) {
		this.skin = i;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int i) {
		this.type = i;
	}
}
