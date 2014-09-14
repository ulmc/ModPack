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

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;

public class BasicStandingBlock extends BlockContainer implements UlmcBlock {

    protected Class anEntityClass;
    private String name;

    public BasicStandingBlock(Material material, Class class1, String aBlockName) {
        super(material);
        anEntityClass = class1;
        setBlockName(aBlockName);
        name = aBlockName;
        setBlockTextureName(Reference.RES_NAME + getUnlocalizedName());
    }

    public BasicStandingBlock(Material material, String aBlockName) {
        super(material);
        setBlockName(aBlockName);
        setBlockTextureName(Reference.RES_NAME + getUnlocalizedName());
    }

    @Override
    public String getSystemName() {
        return name;
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
    public TileEntity createNewTileEntity(World var1, int meta) {
        try {
            return (TileEntity) anEntityClass.newInstance();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private boolean canPlaceStandingBlockOn(World par1World, int par2, int par3, int par4) {
        if (World.doesBlockHaveSolidTopSurface(par1World, par2, par3, par4)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        return canPlaceStandingBlockOn(par1World, par2, par3 - 1, par4);
    }

    private boolean dropBlockIfCantStay(World par1World, int par2, int par3, int par4) {
        if (!this.canPlaceBlockAt(par1World, par2, par3, par4)) {
            if (this.equals(par1World.getBlock(par2, par3, par4))) {
                this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlock(par2, par3, par4, Blocks.air);
            }

            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
        if (this.dropBlockIfCantStay(par1World, par2, par3, par4)) {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);
            if (!this.canPlaceStandingBlockOn(par1World, par2, par3 - 1, par4) && var6 == 5) {
                this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlock(par2, par3, par4, Blocks.air);
            }

        }
    }

    @Override
    public Item getItemDropped(int i, Random random, int j) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public void registerBlockIcons(IIconRegister icon) {
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
        int p = MathHelper.floor_double((par5EntityLivingBase.rotationYaw * 4F) / 360F + 0.5D) & 3;

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
