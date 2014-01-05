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
			int p = MathHelper.floor_double((double) ((entityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3; 
			
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
