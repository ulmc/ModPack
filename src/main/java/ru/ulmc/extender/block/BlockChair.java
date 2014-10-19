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
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.tileentity.TileEntityChair;

import java.util.List;

public class BlockChair extends BasicStandingBlock {
	private boolean isColored = false;
	protected IIcon icon;
	public static final int renderId = RenderingRegistry.getNextAvailableRenderId();

	@SuppressWarnings("rawtypes")
	public BlockChair(Class entity, String aBlockName, boolean isColored) {
		super(Material.wood, entity, aBlockName);
		this.isColored = isColored;
		anEntityClass = entity;
		setHardness(0.5F);
		setResistance(3.0F);
		setStepSound(Block.soundTypeWood);
		setCreativeTab(UltimateExtender.furnitureTab);
		setBlockTextureName(Reference.RES_NAME + getUnlocalizedName());
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.6F, 0.9F);
	}

	@Override
	public TileEntity getBlockEntity() {
		try {
			return (TileEntity) anEntityClass.newInstance();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return icon;
	}

	@Override
	public void registerBlockIcons(IIconRegister icon) {
		this.icon = icon.registerIcon(Reference.RES_NAME + "icons/proto/" +
				this.getUnlocalizedName().replace("tile.block","").replace("Chair","").replace("_Original",""));
	}

	public int damageDropped(int meta) {
		return meta;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List list) {
		if(isColored) {
			for (int i = 0; i < 16; i++)
				list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int getRenderType() {
		return renderId;
	}

	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase,
	                            ItemStack par6ItemStack) {
		par1World.setBlockMetadataWithNotify(par2, par3, par4, par6ItemStack.getItemDamage(), 2);
		TileEntity te = par1World.getTileEntity(par2, par3, par4);
		if(te instanceof TileEntityChair) {
			int p = MathHelper.floor_double((par5EntityLivingBase.rotationYaw * 4F) / 360F + 0.5D) & 3;
			((TileEntityChair)te).setRotation(p);
		}
	}
}
