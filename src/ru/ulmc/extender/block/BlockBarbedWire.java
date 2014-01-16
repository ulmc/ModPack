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

import java.util.Random;

import ru.ulmc.extender.Reference;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBarbedWire extends BlockBreakable implements UlmcBlock
{
	private static String name;
    public BlockBarbedWire(int blockID, String name)
    {
        super(blockID, Reference.RES_NAME + name, Material.cactus, false);
        setHardness(2.5f);
        setResistance(10.0f);
        setLightOpacity(0);
        setStepSound(soundMetalFootstep);
        setUnlocalizedName(name);
        this.name = name;
        //setTextureName(Reference.RES_NAME + "barbedWire");
        setCreativeTab(CreativeTabs.tabBlock);
        this.setTickRandomly(true);
    }
    public String getSystemName() {
		return name;
	}
    public int getRenderBlockPass()
    {
        return 1;
    }	
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
    public boolean isOpaqueCube()
    {
            return false;
    }
    public boolean renderAsNormalBlock()
    {
            return false;
    }
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.attackEntityFrom(DamageSource.cactus, 2);
        par5Entity.setInWeb();
    }
}
