package ru.ulmc.extender.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by 45 on 15.10.2014.
 */
public abstract class BasicConnectedBlock extends BasicStandingBlock {

	protected float Y_MIN_BOUND = 0.0F;
	protected float Y_MAX_BOUND = 1.0F;
	protected float SIDE_1 = 0.12F;
	protected float SIDE_2 = 0.88F;
	protected float SIDE_3 = 0.12F;
	protected float SIDE_4 = 0.88F;

	public BasicConnectedBlock(Material material, Class class1, String aBlockName) {
		super(material, class1, aBlockName);
	}

	protected BasicConnectedBlock(Material material, String aBlockName) {
		super(material, aBlockName);
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB box, List list, Entity entity) {
		boolean flag = this.canConnectTo(world, x, y, z - 1);
		boolean flag1 = this.canConnectTo(world, x, y, z + 1);
		boolean flag2 = this.canConnectTo(world, x - 1, y, z);
		boolean flag3 = this.canConnectTo(world, x + 1, y, z);
		float f = SIDE_1;
		float f1 = SIDE_2;
		float f2 = SIDE_3;
		float f3 = SIDE_4;

		if (flag) {
			f2 = 0.0F;
		}

		if (flag1) {
			f3 = 1.0F;
		}

		if (flag || flag1) {
			this.setBlockBounds(f, Y_MIN_BOUND, f2, f1, Y_MAX_BOUND, f3);
			super.addCollisionBoxesToList(world, x, y, z, box, list, entity);
		}

		f2 = SIDE_3;
		f3 = SIDE_4;

		if (flag2) {
			f = 0.0F;
		}

		if (flag3) {
			f1 = 1.0F;
		}

		if (flag2 || flag3 || !flag && !flag1) {
			this.setBlockBounds(f, Y_MIN_BOUND, f2, f1, Y_MAX_BOUND, f3);
			super.addCollisionBoxesToList(world, x, y, z, box, list, entity);
		}

		if (flag) {
			f2 = 0.0F;
		}

		if (flag1) {
			f3 = 1.0F;
		}

		this.setBlockBounds(f, Y_MIN_BOUND, f2, f1, Y_MAX_BOUND, f3);
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		boolean flag = this.canConnectTo(world, x, y, z - 1);
		boolean flag1 = this.canConnectTo(world, x, y, z + 1);
		boolean flag2 = this.canConnectTo(world, x - 1, y, z);
		boolean flag3 = this.canConnectTo(world, x + 1, y, z);
		float f = SIDE_1;
		float f1 = SIDE_2;
		float f2 = SIDE_3;
		float f3 = SIDE_4;

		if (flag) {
			f2 = 0.0F;
		}

		if (flag1) {
			f3 = 1.0F;
		}

		if (flag2) {
			f = 0.0F;
		}

		if (flag3) {
			f1 = 1.0F;
		}

		this.setBlockBounds(f, Y_MIN_BOUND, f2, f1, Y_MAX_BOUND, f3);
	}

	public boolean getBlocksMovement(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
		return false;
	}

	public boolean canConnectTo(IBlockAccess world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		boolean isEquals = Block.isEqualTo(block, this);
		return isEquals;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		return true;
	}

}


