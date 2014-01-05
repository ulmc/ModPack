package ru.ulmc.extender.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.entity.item.EntityFallingBlock;

public class BasicFallingBlock extends BlockContainer {

	protected Class anEntityClass;
	public static boolean fallInstantly = true;

	public BasicFallingBlock(int i, Material material, Class class1, String aBlockName) {
		super(i, material);
		anEntityClass = class1;
		setUnlocalizedName(aBlockName);
		setTextureName(Reference.RES_NAME + getUnlocalizedName());
	}

	public BasicFallingBlock(int i, Material material, String aBlockName) {
		super(i, material);
		setUnlocalizedName(aBlockName);
		setTextureName(Reference.RES_NAME + getUnlocalizedName());
	}

	public TileEntity getBlockEntity() {
		try {
			return (TileEntity) anEntityClass.newInstance();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException(exception);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		try {
			return (TileEntity) anEntityClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (!par1World.isRemote) {
			this.tryToFall(par1World, par2, par3, par4);
		}
	}

	/**
	 * If there is space to fall below will start this block falling
	 */
	protected void tryToFall(World par1World, int x, int y, int z) {
		if (canFallBelow(par1World, x, y - 1, z) && y >= 0) {
			byte b0 = 32;

			if (par1World.checkChunksExist(x - b0, y - b0, z - b0, x + b0, y + b0, z + b0)) {
				if (!par1World.isRemote) {
					EntityFallingBlock entityfallingsand = new EntityFallingBlock(par1World, (double) ((float) x + 0.5F),
							(double) ((float) y + 0.5F), (double) ((float) z + 0.5F), this.blockID,
							par1World.getBlockMetadata(x, y, z));
					this.onStartFalling(entityfallingsand);
					par1World.spawnEntityInWorld(entityfallingsand);
				}
			} else {
				int originY = y;
				TileEntity te = par1World.getBlockTileEntity(x, y, z);

				while (canFallBelow(par1World, x, y - 1, z) && y > 0) {
					--y;
				}

				if (y > 0) {
					par1World.setBlock(x, y, z, this.blockID);
				}
				
				par1World.setBlockToAir(x, originY, z);
				
			}
		}
	}

	/**
	 * Called when the falling block entity for this block is created
	 */
	protected void onStartFalling(EntityFallingBlock par1EntityFallingSand) {
		
	}

	/**
	 * How many world ticks before ticking
	 */
	public int tickRate(World par1World) {
		return 2;
	}

	/**
	 * Checks to see if the sand can fall into the block below it
	 */
	public static boolean canFallBelow(World par0World, int par1, int par2, int par3) {
		int l = par0World.getBlockId(par1, par2, par3);

		if (par0World.isAirBlock(par1, par2, par3)) {
			return true;
		} else if (l == Block.fire.blockID) {
			return true;
		} else {
			Material material = Block.blocksList[l].blockMaterial;
			return material == Material.water ? true : material == Material.lava;
		}
	}

	/**
	 * Called when the falling block entity for this block hits the ground and
	 * turns back into a block
	 */
	public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {
	}

	@Override
	public int idDropped(int i, Random random, int j) {
		return this.blockID;
	}

	@Override
	public void registerIcons(IconRegister icon) {
		this.blockIcon = icon.registerIcon(Reference.RES_NAME + "icons/" + this.getUnlocalizedName());
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
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

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase,
			ItemStack par6ItemStack) {
		int p = MathHelper.floor_double((double) ((par5EntityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;

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
		par1World.setBlockMetadataWithNotify(par2, par3, par4, aByte, 2);
	}
}
