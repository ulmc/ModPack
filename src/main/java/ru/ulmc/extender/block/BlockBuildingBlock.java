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

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.tileentity.BuildingBlockTileEntity;

public class BlockBuildingBlock extends BasicStandingBlock {

	public static final int renderId = RenderingRegistry.getNextAvailableRenderId();
	private static int IS_ON_THE_GROUND = 1;
	private static int IS_CONNECTED_TO_SOLID = 2;
	private static int IS_NOT_SOLID = 0;
	protected IIcon icon;

	public BlockBuildingBlock(String aBlockName) {
		super(Material.wood, BuildingBlockTileEntity.class, aBlockName);
		setStepSound(Block.soundTypeWood);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockTextureName(Reference.RES_NAME + getUnlocalizedName());
		setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
		this.blockHardness = 0.5F;

	}

	@Override
	public TileEntity getBlockEntity() {
		try {
			return BuildingBlockTileEntity.class.newInstance();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		return side.equals(ForgeDirection.UP) ? true : false;
	}

	@Override
	public void registerBlockIcons(IIconRegister icon) {
		this.icon = icon.registerIcon(Reference.RES_NAME + "icons/proto/Oak");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icon;
	}

	@Override
	public int getRenderType() {
		return renderId;
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		if(player.getHeldItem() != null && Item.getItemFromBlock(this).equals(player.getHeldItem().getItem())) {
			int newZ = lookUp(world, x, y, z);
			if (newZ > 0 && newZ < 256) {
				if (player.getHeldItem().stackSize > 1)
					player.getHeldItem().stackSize--;
				else
					player.destroyCurrentEquippedItem();
				world.setBlock(x,newZ,z,this);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_) {
		return AxisAlignedBB.getBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	protected boolean canPlaceStandingBlockOn(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		return block.isBlockNormalCube() || Block.isEqualTo(block, this);
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		boolean canPlaceOnTheGround = canPlaceStandingBlockOn(world, x, y - 1, z);

		if (!canPlaceOnTheGround) {
			return canAttachToBlock(world, x, y, z, ForgeDirection.EAST) ||
					canAttachToBlock(world, x, y, z, ForgeDirection.NORTH) ||
					canAttachToBlock(world, x, y, z, ForgeDirection.WEST) ||
					canAttachToBlock(world, x, y, z, ForgeDirection.SOUTH);
		}
		return canPlaceOnTheGround;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block par5) {
		int meta = world.getBlockMetadata(x, y, z);
		if (meta == IS_ON_THE_GROUND && !isSolidBlockNear(world, x, y, z)) {
			this.dropBlockAsItem(world, x, y, z, 0, 0);
			world.setBlock(x, y, z, Blocks.air);
			return;
		}
		if (!this.canPlaceBlockAt(world, x, y, z)) {
			this.dropBlockAsItem(world, x, y, z, 0, 0);
			world.setBlock(x, y, z, Blocks.air);
		} else {
			defineIfSolid(world, x, y, z);
		}
	}

	private boolean canAttachToBlock(World world, int x, int y, int z, ForgeDirection direction) {
		x += direction.offsetX;
		y += direction.offsetY;
		z += direction.offsetZ;
		if (!Block.isEqualTo(this, world.getBlock(x, y, z)))
			return false;

		if (world.getBlockMetadata(x, y, z) == IS_NOT_SOLID) {
			return false;
		}
		return true;
	}

	private int lookUp(World world, int x, int y, int z) {
		int meta = 0;
		while (meta != -2) {
			meta = getNeighbourMeta(world,x,y++,z,ForgeDirection.UP);
			if (meta == -1) {
				return -1;
			}
		}
		return y;
	}

	private int getNeighbourMeta(World world, int x, int y, int z, ForgeDirection direction) {
		Block nextBlock = world.getBlock(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
		if (Block.isEqualTo(this, nextBlock)) {
			int meta = world.getBlockMetadata(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
			return meta;
		} else if(Block.isEqualTo(Blocks.air, nextBlock)) {
			return -2;
		}
		return -1;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
	                            EntityLivingBase entityLiving, ItemStack par6ItemStack) {

		defineIfSolid(world, x, y, z);
	}

	private void defineIfSolid(World world, int x, int y, int z) {
		Block underBlock = world.getBlock(x, y - 1, z);
		boolean isSolid = underBlock.isBlockNormalCube();
		if (underBlock instanceof BlockBuildingBlock) {
			isSolid = isSolid || world.getBlockMetadata(x, y - 1, z) == IS_ON_THE_GROUND;
		}
		if (isSolid) {
			world.setBlockMetadataWithNotify(x, y, z, IS_ON_THE_GROUND, 2);
			return;
		}
		if (isSolidBlockNear(world, x, y, z)) {
			world.setBlockMetadataWithNotify(x, y, z, IS_CONNECTED_TO_SOLID, 2);
		} else {
			world.setBlockMetadataWithNotify(x, y, z, IS_NOT_SOLID, 2);
		}
	}

	private boolean isSolidBlockNear(World world, int x, int y, int z) {
		return getNeighbourMeta(world, x, y, z, ForgeDirection.EAST) == IS_ON_THE_GROUND ||
				getNeighbourMeta(world, x, y, z, ForgeDirection.WEST) == IS_ON_THE_GROUND ||
				getNeighbourMeta(world, x, y, z, ForgeDirection.NORTH) == IS_ON_THE_GROUND ||
				getNeighbourMeta(world, x, y, z, ForgeDirection.SOUTH) == IS_ON_THE_GROUND ||
				getNeighbourMeta(world, x, y, z, ForgeDirection.DOWN) == IS_ON_THE_GROUND ||
				canPlaceStandingBlockOn(world, x, y - 1, z);
	}

	@Override
	public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity) {
		return true;
	}
}
