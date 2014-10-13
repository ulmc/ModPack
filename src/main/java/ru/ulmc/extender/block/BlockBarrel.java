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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import ru.ulmc.extender.Reference;

public class BlockBarrel extends BasicStandingBlock {

	@SuppressWarnings("rawtypes")
	public BlockBarrel(Class entity, String aBlockName) {
		super(Material.wood, entity, aBlockName);
		anEntityClass = entity;
		setHardness(1.0F);
		setResistance(3.0F);
		setStepSound(Block.soundTypeWood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockTextureName(Reference.RES_NAME + getUnlocalizedName());
		setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 1.0F, 0.95F);
	}

	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		return side.equals(ForgeDirection.UP) ? true : false;
	}

	@Override
	public TileEntity getBlockEntity() {
		try {
			return (TileEntity) anEntityClass.newInstance();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
}
