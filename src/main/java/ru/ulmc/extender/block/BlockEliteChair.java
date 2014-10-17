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
package ru.ulmc.extender.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ru.ulmc.extender.tileentity.TileEntityEliteChair;

public class BlockEliteChair extends BlockChair {
	private Class anEntityClass;

	public BlockEliteChair(Class class1, String aBlockName) {
		super(class1, aBlockName, false);
		setHardness(1.5F);
		setResistance(3.5F);
		anEntityClass = class1;
	}

	@Override
	public TileEntity getBlockEntity() {
		try {
			return (TileEntity) anEntityClass.newInstance();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int meta) {
		TileEntityEliteChair tileEntityEliteChair = new TileEntityEliteChair();
		/*tileEntityEliteChair.setType(itemDrop.getType());*/
		return tileEntityEliteChair;
	}
}
