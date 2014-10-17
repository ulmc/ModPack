package ru.ulmc.extender.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.tileentity.TileEntityBench;
import ru.ulmc.extender.tileentity.TileEntityConnectedTable;

/**
 * Created by 45 on 15.10.2014.
 */
public class BlockConnectedTable extends BasicConnectedBlock {
	public BlockConnectedTable(Material material, String aBlockName) {
		super(material, TileEntityConnectedTable.class, aBlockName);
		setCreativeTab(UltimateExtender.furnitureTab);
		Y_MAX_BOUND = 1.0F;
		SIDE_1 = 0.0F;
		SIDE_2 = 1.0F;
		SIDE_3 = 0.0F;
		SIDE_4 = 1.0F;
	}
	public boolean canConnectTo(IBlockAccess world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		return block instanceof BlockConnectedTable;
	}

}
