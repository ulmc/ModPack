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
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.tileentity.TileEntityCart;
import ru.ulmc.extender.tileentity.TileEntityFiller;

public class FillerBlock extends BlockContainer implements UlmcBlock {
	private String systemName;

	public FillerBlock(Material material, String systemName, SoundType sound) {
		super(material);
		setBlockName(systemName);
		setBlockTextureName(Reference.RES_NAME + "fillerBlock");
		setStepSound(sound);
		this.systemName = systemName;
	}

	@Override
	public String getSystemName() {
		return systemName;
	}

	@Override
	public void breakBlock(World world, int i, int j, int k, Block p_breakBlock_5_, int p_breakBlock_6_) {
		TileEntityFiller tileEntity = (TileEntityFiller) world.getTileEntity(i, j, k);
		if (tileEntity != null) {
			world.setBlockToAir(tileEntity.getPrimaryX(), tileEntity.getPrimaryY(), tileEntity.getPrimaryZ());
			world.removeTileEntity(tileEntity.getPrimaryX(), tileEntity.getPrimaryY(), tileEntity.getPrimaryZ());
		}
		world.removeTileEntity(i, j, k);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block par5) {
		TileEntityFiller tileEntity = (TileEntityFiller) world.getTileEntity(x, y, z);
		if (tileEntity != null) {
			TileEntity te = world.getTileEntity(
					tileEntity.getPrimaryX(),
					tileEntity.getPrimaryY(),
					tileEntity.getPrimaryZ());
			if (te == null) {
				world.setBlockToAir(x, y, z);
				world.removeTileEntity(x, y, z);
			}
			if (te instanceof TileEntityCart) {
				if (!world.isSideSolid(x, y - 1, z, ForgeDirection.UP)) {
					world.notifyBlocksOfNeighborChange(
							tileEntity.getPrimaryX(),
							tileEntity.getPrimaryY() - 1,
							tileEntity.getPrimaryZ(),
							world.getBlock(tileEntity.getPrimaryX(),
									tileEntity.getPrimaryY() - 1,
									tileEntity.getPrimaryZ()));
				}
			}
		}
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
		TileEntityFiller entity = (TileEntityFiller) block.getTileEntity(x, y, z);
		//UltimateExtender.logger.info(entity.getMinX() + " " + entity.getMinY() + " " + " " + " " + " " + " " + " ");
		this.setBlockBounds(entity.getMinX(), entity.getMinY(), entity.getMinZ(),
				entity.getMaxX(), entity.getMaxY(), entity.getMaxZ());

	}


	@Override
	public boolean isBlockSolid(IBlockAccess p_149747_1_, int p_149747_2_, int p_149747_3_, int p_149747_4_, int p_149747_5_) {
		return false;
	}

	@Override
	public boolean isNormalCube() {
		return false;
	}

	@Override
	public boolean isReplaceable(IBlockAccess world, int x, int y, int z) {
		return false;
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
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityFiller();
	}

    /*
	@Override
	public int idPicked(World par1World, int x, int y, int z) {
		TileEntityFiller entity = (TileEntityFiller) par1World.getTileEntity(x, y, z);
	
		return par1World.getBlockId(entity.getPrimaryX(), entity.getPrimaryY(), entity.getPrimaryZ());
	}
	*/
}
