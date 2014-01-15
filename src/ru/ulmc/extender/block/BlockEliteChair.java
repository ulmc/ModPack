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
package ru.ulmc.extender.block;

import ru.ulmc.extender.tileentity.TileEntityEliteChair;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEliteChair extends BlockChair
{
	private Class anEntityClass;
    public BlockEliteChair(int i, Class class1, float aHardness, float aResistance, String aBlockName)
    {
            super(i, class1, aHardness, aResistance, aBlockName);
            anEntityClass = class1;
    }
    public TileEntity getBlockEntity()
    {
            try {
            	return (TileEntity)anEntityClass.newInstance();
            } catch (Exception exception) {
            	throw new RuntimeException(exception);
            }
    }
    public TileEntity createNewTileEntity(World var1)
    {
    	TileEntityEliteChair tileEntityEliteChair = new TileEntityEliteChair();
    	/*tileEntityEliteChair.setType(itemDrop.getType());*/
        return tileEntityEliteChair;
    }
}
