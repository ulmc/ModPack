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

import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.tileentity.TileEntityCart;
import ru.ulmc.extender.tileentity.TileEntityFiller;

public class FillerBlock extends BlockContainer implements UlmcBlock {
	private String systemName;

	public FillerBlock(int id, Material material, String systemName, StepSound sound) {
		super(id, material);
		setUnlocalizedName(systemName);
		setTextureName(Reference.RES_NAME + "fillerBlock");
		setStepSound(sound);
		this.systemName = systemName;
	}

	@Override
	public String getSystemName() {
		return systemName;
	}

	@Override
	public void breakBlock(World world, int i, int j, int k, int par5, int par6) {
		TileEntityFiller tileEntity = (TileEntityFiller) world.getBlockTileEntity(i, j, k);
		if (tileEntity != null) {
			world.destroyBlock(tileEntity.getPrimaryX(), tileEntity.getPrimaryY(), tileEntity.getPrimaryZ(), false);
			world.removeBlockTileEntity(tileEntity.getPrimaryX(), tileEntity.getPrimaryY(), tileEntity.getPrimaryZ());
		}
		world.removeBlockTileEntity(i, j, k);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {		
		TileEntityFiller tileEntity = (TileEntityFiller) world.getBlockTileEntity(x, y, z);
		if (tileEntity != null) {
			TileEntity te = world.getBlockTileEntity(
					tileEntity.getPrimaryX(), 
					tileEntity.getPrimaryY(),
					tileEntity.getPrimaryZ());
			if (te == null) {
				world.destroyBlock(x, y, z, false);
				world.removeBlockTileEntity(x, y, z);
			} 
			if(te instanceof TileEntityCart) {
				if(!world.isBlockSolidOnSide(x, y-1, z, ForgeDirection.UP)) {
					world.notifyBlocksOfNeighborChange(
							tileEntity.getPrimaryX(), 
							tileEntity.getPrimaryY()-1,
							tileEntity.getPrimaryZ(), 
							world.getBlockId(	tileEntity.getPrimaryX(), 
												tileEntity.getPrimaryY()-1, 
												tileEntity.getPrimaryZ()));
				}
			}
		}
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
		TileEntityFiller entity = (TileEntityFiller) block.getBlockTileEntity(x, y, z);
			//UltimateExtender.logger.info(entity.getMinX() + " " + entity.getMinY() + " " + " " + " " + " " + " " + " ");
		this.setBlockBounds(entity.getMinX(), entity.getMinY(), entity.getMinZ(), 
							entity.getMaxX(), entity.getMaxY(), entity.getMaxZ());	

	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFiller();
	}

	@Override
	public int idPicked(World par1World, int x, int y, int z) {
		TileEntityFiller entity = (TileEntityFiller) par1World.getBlockTileEntity(x, y, z);
	
		return par1World.getBlockId(entity.getPrimaryX(), entity.getPrimaryY(), entity.getPrimaryZ());
	}
	
}
