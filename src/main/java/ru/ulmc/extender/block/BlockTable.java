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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.render.RenderTables;
import ru.ulmc.extender.tileentity.TileEntityTable;

import java.util.List;

public class BlockTable extends BasicConnectedBlock {
	protected IIcon[] icon = new IIcon[6];
	protected int blockModel;
	public static final int MODEL_BAR = 1;
	public static final int MODEL_CABINET = 2;
	public static final int MODEL_DINNER = 3;
	public static final String[] subBlocks = new String[] {"Oak", "Spruce", "Birch", "Jungle", "Acacia", "OldOak"};

	public static final int MODEL_BAR_REG = RenderingRegistry.getNextAvailableRenderId();
	public static final int MODEL_CABINET_REG = RenderingRegistry.getNextAvailableRenderId();
	public static final int MODEL_DINNER_REG = RenderingRegistry.getNextAvailableRenderId();

	public BlockTable(float aHardness, float aResistance, String aBlockName, int tableModel) {
		super(Material.wood, aBlockName);
		setHardness(aHardness);
		setResistance(aResistance);
		setStepSound(Block.soundTypeWood);
		setCreativeTab(UltimateExtender.furnitureTab);
		setBlockTextureName(Reference.RES_NAME + getUnlocalizedName());
		this.blockModel = tableModel;
		SIDE_1 = 0.0F;
		SIDE_2 = 1.0F;
		SIDE_3 = 0.0F;
		SIDE_4 = 1.0F;
	}

	@Override
	public TileEntity getBlockEntity() {
		return new TileEntityTable();
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int i) {
		return new TileEntityTable();
	}

	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		return side.equals(ForgeDirection.UP) ? true : false;
	}
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icon[meta % icon.length];
	}

	@Override
	public void registerBlockIcons(IIconRegister icon) {
		for (int i = 0; i< subBlocks.length; i++)
			this.icon[i] = icon.registerIcon(Reference.RES_NAME + "icons/proto/" + subBlocks[i]);
	}

	public int damageDropped(int meta) {
		return meta;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < subBlocks.length; i++)
			list.add(new ItemStack(item, 1, i));
	}
	@Override
	public int getRenderType() {
		if(blockModel == BlockTable.MODEL_BAR)
			return MODEL_BAR_REG;
		if(blockModel == BlockTable.MODEL_CABINET)
			return MODEL_CABINET_REG;
		if(blockModel == BlockTable.MODEL_DINNER)
			return MODEL_DINNER_REG;
		else return -1;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		if ( !super.canPlaceBlockAt(world, x, y, z) )
			return false;
		if (blockModel == MODEL_CABINET) {
			return canPlaceNear(world, x, y, z);
		}
		return true;
	}


	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
	                            EntityLivingBase entityLiving, ItemStack par6ItemStack) {
		if (!world.isRemote) {
			int p = MathHelper.floor_double((entityLiving.rotationYaw * 4.0F) / 360.0F + 0.5F) & 3;
			TileEntityTable flagTE = (TileEntityTable) world.getTileEntity(x, y, z);
			flagTE.blockType = this;
			flagTE.setRotation(p);
			flagTE.setModel(blockModel);
			world.setBlockMetadataWithNotify(x, y, z, par6ItemStack.getItemDamage(), 2);
		}
	}

	protected boolean canPlaceNear(World world, int x, int y, int z) {
		if (canConnectTo(world, x - 1, y, z)) {
			if( canConnectTo(world, x - 2, y, z) && canConnectTo(world, x - 3, y, z) ||
				canConnectTo(world, x - 1, y, z - 1) || canConnectTo(world, x - 1, y, z + 1))
				return false;
		}
		if (canConnectTo(world, x + 1, y, z)) {
			if( canConnectTo(world, x + 2, y, z) && canConnectTo(world, x + 3, y, z) ||
					canConnectTo(world, x +1, y, z - 1) || canConnectTo(world, x +1, y, z + 1) )
				return false;
		}
		if (canConnectTo(world, x, y, z - 1)) {
			if( canConnectTo(world, x + 1, y, z - 1) || canConnectTo(world, x - 1, y, z - 1) ||
					canConnectTo(world, x , y, z - 2) && canConnectTo(world, x , y, z - 3))
				return false;
		}
		if (canConnectTo(world, x, y, z + 1)) {
			if( canConnectTo(world, x - 1, y, z+1) || canConnectTo(world, x + 1, y, z+1) ||
					canConnectTo(world, x , y, z + 2) && canConnectTo(world, x , y, z + 3))
				return false;
		}
		return true;
	}
}
