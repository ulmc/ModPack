package ru.ulmc.extender.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.tileentity.FillerTileEntity;

public class FillerBlock extends BlockContainer {

	public FillerBlock(int id, Material material) {
		super(id, material);
		setUnlocalizedName(Reference.RES_NAME + "fillerBlock");
		setTextureName(Reference.RES_NAME + "fillerBlock");
		setStepSound(new StepSound("NONE", 0.0f, 0.0f));
	}

	@Override
	public void breakBlock(World world, int i, int j, int k, int par5, int par6) {
		FillerTileEntity tileEntity = (FillerTileEntity) world.getBlockTileEntity(i,
				j, k);
		if (tileEntity != null) {
			world.destroyBlock(tileEntity.getPrimaryX(), tileEntity.getPrimaryY(),
					tileEntity.getPrimaryZ(), false);
			world.removeBlockTileEntity(tileEntity.getPrimaryX(),
					tileEntity.getPrimaryY(), tileEntity.getPrimaryZ());
		}
		world.removeBlockTileEntity(i, j, k);
	}

	@Override
	public void onNeighborBlockChange(World world, int i, int j, int k, int par5) {
		FillerTileEntity tileEntity = (FillerTileEntity) world.getBlockTileEntity(i, j, k);
		if (tileEntity != null) {
			if (world.getBlockId(tileEntity.getPrimaryX(), tileEntity.getPrimaryY(),
					tileEntity.getPrimaryZ()) < 1) {
				world.destroyBlock(i, j, k, false);
				world.removeBlockTileEntity(i, j, k);
			}
		}
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i,
			int j, int k, int l) {
		return false;
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new FillerTileEntity();
	}
}
