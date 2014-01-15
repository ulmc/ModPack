/**
 * Copyright (C) 2014 Kolmogorov Alexey
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
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
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
	public BlockFlag(int i, Class class1, float aHardness, float aResistance,
			String aBlockName, int blockType, Block fillerBlock) {
		super(i, Material.wood, class1, aBlockName);
		anEntityClass = class1;
		setHardness(aHardness);
		setResistance(aResistance);
		setStepSound(Block.soundWoodFootstep);		
		setCreativeTab(CreativeTabs.tabDecorations);
		this.blockType = blockType;
		this.fillerBlock = fillerBlock;
		setTextureName(Reference.RES_NAME + getUnlocalizedName());
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 3.0F, 0.9F);
		
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
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
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
        par3List.add(new ItemStack(par1, 1, 15));
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
					world.setBlock(x, ++fillerY, z,	fillerBlock.blockID, 0, 0x02);
					TileEntityFiller tileFiller = (TileEntityFiller) world.getBlockTileEntity(x, fillerY, z);
					if (tileFiller != null) {
						tileFiller.setPrimaryX(x);
						tileFiller.setPrimaryY(y);
						tileFiller.setPrimaryZ(z);
					}
				}
				TileEntityFlag flagTE = (TileEntityFlag) world.getBlockTileEntity(x, y, z);
		    	int side = (int)(MathHelper.floor_double((double)((entityLiving.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15);  
		    	flagTE.setType(this.blockType);
		    	flagTE.blockType = this;
		    	flagTE.setAngle(side);
		    	flagTE.setSkin(par6ItemStack.getItemDamage());
		    	//UltimateExtender.logger.info("onBlockPlacedBy: Side = " + flagTE.getAngle());
			} else {
				world.destroyBlock(x, y, z, true);
				world.removeBlockTileEntity(x, y, z);
			}
		}		    	
    }
}
