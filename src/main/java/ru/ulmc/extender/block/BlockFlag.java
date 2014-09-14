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

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.tileentity.TileEntityFiller;
import ru.ulmc.extender.tileentity.TileEntityFlag;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFlag extends BasicStandingBlock {

	protected int blockType;
	protected Block fillerBlock;
	public BlockFlag(Class class1, float aHardness, float aResistance,
			String aBlockName, int blockType, Block fillerBlock) {
		super(Material.wood, class1, aBlockName);
		anEntityClass = class1;
		setHardness(aHardness);
		setResistance(aResistance);
		setStepSound(Block.soundTypeWood);
		setCreativeTab(CreativeTabs.tabDecorations);
		this.blockType = blockType;
		this.fillerBlock = fillerBlock;
        setBlockTextureName(Reference.RES_NAME + getUnlocalizedName());
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F);
		
	}
	@Override
	public TileEntity getBlockEntity() {
		UltimateExtender.logger.info("getBlockEntity");
		try {
			return (TileEntity) anEntityClass.newInstance();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
	public int getBlockType() {
		return blockType;
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
    	
    	return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        super.getSubBlocks(p_149666_1_, p_149666_2_, p_149666_3_);
      /*par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
        par3List.add(new ItemStack(par1, 1, 5));
        par3List.add(new ItemStack(par1, 1, 6));
        par3List.add(new ItemStack(par1, 1, 7));
        par3List.add(new ItemStack(par1, 1, 8));
        par3List.add(new ItemStack(par1, 1, 9));
        par3List.add(new ItemStack(par1, 1, 10));
        par3List.add(new ItemStack(par1, 1, 11));
        par3List.add(new ItemStack(par1, 1, 12));
        par3List.add(new ItemStack(par1, 1, 13));
        par3List.add(new ItemStack(par1, 1, 14));
        par3List.add(new ItemStack(par1, 1, 15));*/
    }
	
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        /*super.onBlockAdded(par1World, par2, par3, par4);*/
      /*  UltimateExtender.logger.info("onBlockAdded");*/
             
    }
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, 
			EntityLivingBase entityLiving, ItemStack par6ItemStack)
    {
		if (!world.isRemote) {			
			
			boolean canPlace = true;
			
			
			if (!world.isAirBlock(x , y + 1, z) || !world.isAirBlock(x , y + 2, z)) {
				canPlace = false;
			}
			
			if (canPlace) {				
				int fillerY = y;
				for (int i = 0; i < 2; i++) {
					world.setBlock(x, ++fillerY, z,	fillerBlock, 0, 0x02);
					TileEntityFiller tileFiller = (TileEntityFiller) world.getTileEntity(x, fillerY, z);
					if (tileFiller != null) {
						tileFiller.setPrimaryX(x);
						tileFiller.setPrimaryY(y);
						tileFiller.setPrimaryZ(z);
						tileFiller.setPrimaryBlockID(Block.getIdFromBlock(this));
						tileFiller.setBoxBounds(0, y - fillerY, 0, 1, 3 + (y - fillerY), 1);
					}
				}
				TileEntityFlag flagTE = (TileEntityFlag) world.getTileEntity(x, y, z);
		    	int side = MathHelper.floor_double((entityLiving.rotationYaw + 180.0F) * 16.0F / 360.0F + 0.5D) & 15;  
		    	flagTE.setType(this.blockType);
		    	flagTE.blockType = this;
		    	flagTE.setAngle(side);
		    	flagTE.setSkin(par6ItemStack.getItemDamage());
		    	//UltimateExtender.logger.info("onBlockPlacedBy: Side = " + flagTE.getAngle());
			} else {
				world.setBlockToAir(x, y, z);
				world.removeTileEntity(x, y, z);
			}
		}		    	
    }
}
