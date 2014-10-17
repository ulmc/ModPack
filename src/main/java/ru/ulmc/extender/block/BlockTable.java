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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.tileentity.TileEntityTable;

public class BlockTable extends BasicStandingBlock {
	protected int tableModel;

	public BlockTable(float aHardness, float aResistance,
	                  String aBlockName, int tableModel) {
		super(Material.wood, aBlockName);
		setHardness(aHardness);
		setResistance(aResistance);
		setStepSound(Block.soundTypeWood);
		setCreativeTab(UltimateExtender.furnitureTab);
		setBlockTextureName(Reference.RES_NAME + getUnlocalizedName());
		this.tableModel = tableModel;
	}

	@Override
	public TileEntity getBlockEntity() {
		return new TileEntityTable();
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int i) {
		return new TileEntityTable();
	}

	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		return side.equals(ForgeDirection.UP) ? true : false;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
	                            EntityLivingBase entityLiving, ItemStack par6ItemStack) {
		if (!world.isRemote) {

			TileEntityTable flagTE = (TileEntityTable) world.getTileEntity(x, y, z);
			flagTE.setModel(tableModel);

			flagTE.blockType = this;
			int p = MathHelper.floor_double((entityLiving.rotationYaw * 4F) / 360F + 0.5D) & 3;

			int aByte = 3;
			if (p == 0) {
				aByte = 0;
			} else if (p == 3) {
				aByte = 1;
			} else if (p == 2) {
				aByte = 2;
			} else if (p == 1) {
				aByte = 3;
			}
			world.setBlockMetadataWithNotify(x, y, z, aByte, 2);
			//UltimateExtender.logger.info("onBlockPlacedBy: tableModel = " + tableModel);
		}
	}
}
