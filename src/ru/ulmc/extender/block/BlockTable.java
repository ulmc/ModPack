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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.tileentity.TileEntityTable;

public class BlockTable extends BasicStandingBlock {
	protected int tableModel;

	public BlockTable(int i, float aHardness, float aResistance,
			String aBlockName, int tableModel) {
		super(i, Material.wood, aBlockName);
		setHardness(aHardness);
		setResistance(aResistance);
		setStepSound(Block.soundWoodFootstep);
		setCreativeTab(CreativeTabs.tabDecorations);
		setTextureName(Reference.RES_NAME + getUnlocalizedName());
		this.tableModel = tableModel;
	}
	@Override
	public TileEntity getBlockEntity() {
		return new TileEntityTable();
	}
	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityTable();
	}
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase entityLiving, ItemStack par6ItemStack) {
		if (!world.isRemote) {
			
			TileEntityTable flagTE = (TileEntityTable) world.getBlockTileEntity(x, y, z);
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
