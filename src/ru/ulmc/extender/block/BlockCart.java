package ru.ulmc.extender.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.tileentity.TileEntityFiller;
import ru.ulmc.extender.tileentity.TileEntityCart;

public class BlockCart extends BasicStandingBlock {
	
	protected Block fillerBlock;
	protected float[][] bounds = {	{0.0f, 0.0f, 0.0f, 2.0f, 1.0f, 2.0f},
									{0.0f, 0.0f, -1.0f, 2.0f, 1.0f, 1.0f},
									{-1.0f, 0.0f, -1.0f, 1.0f, 1.0f, 1.0f},
									{-1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 2.0f}};

	public BlockCart(int blockID, String aBlockName, Block fillerBlock) {
		super(blockID, Material.wood, TileEntityCart.class, aBlockName);
		this.fillerBlock = fillerBlock;
		setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack par6ItemStack) {
		if (!world.isRemote) {

			boolean canPlace = true;

			int[][] fillers = { { 0, 0, 1 }, { 1, 0, 0 }, { 1, 0, 1 } };
			int[] shift;
			int dir = MathHelper.floor_double((double) ((entityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
			int aByte = 3;
			if (dir == 0) {
				aByte = 0;
			} else if (dir == 3) {
				aByte = 1;
			} else if (dir == 2) {
				aByte = 2;
			}
			world.setBlockMetadataWithNotify(x, y, z, aByte, 4);
			for (int i = 0; i < fillers.length; i++) {
				shift = rotXZByDir(fillers[i][0], y, fillers[i][2], dir);
				if (!world.isAirBlock(x + shift[0], y, z + shift[2])) {
					canPlace = false;
				}
				if (!world.isBlockSolidOnSide(x + shift[0], y-1, z + shift[2], ForgeDirection.UP)) {
					canPlace = false;
				}
			}

			UltimateExtender.logger.info("META: " + aByte);
			if (canPlace) {

				TileEntityCart cartTE = (TileEntityCart) world.getBlockTileEntity(x, y, z);

				for (int i = 0; i < fillers.length; i++) {
					shift = rotXZByDir(fillers[i][0], y, fillers[i][2], dir);
					world.setBlock(x + shift[0], y, z + shift[2], fillerBlock.blockID, dir, 2);
					TileEntityFiller tileFiller = (TileEntityFiller) world.getBlockTileEntity(x + shift[0], y, z + shift[2]);
					if (tileFiller != null) {
						tileFiller.setPrimaryX(x);
						tileFiller.setPrimaryY(y);
						tileFiller.setPrimaryZ(z);
						tileFiller.setPrimaryBlockID(this.blockID);
						tileFiller.setBoxBounds(bounds[aByte][0] - shift[0], bounds[aByte][1] + (y - shift[1]), bounds[aByte][2] - shift[2],
												bounds[aByte][3] - shift[0], bounds[aByte][4] + (y - shift[1]), bounds[aByte][5] - shift[2]);
					}
				}

				cartTE.blockType = this;
			} else {
				world.destroyBlock(x, y, z, true);
				world.removeBlockTileEntity(x, y, z);
			}
		}
	}
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z) {
		int meta = block.getBlockMetadata(x, y, z);		
		this.setBlockBounds(bounds[meta][0], bounds[meta][1], bounds[meta][2],
							bounds[meta][3], bounds[meta][4], bounds[meta][5]);
	}
	
	
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		return true;
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		// nope
	}	
	
	public int[] rotXZByDir(int x, int y, int z, int dir) {
		if (dir == 0) {
			return new int[] { x, y, z };
		} else if (dir == 1) {
			return new int[] { -z, y, x };
		} else if (dir == 2) {
			return new int[] { -x, y, -z };
		} else {
			return new int[] { z, y, -x };
		}
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
}