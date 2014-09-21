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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.gui.GuiGrinder;
import ru.ulmc.extender.item.ItemGrind;
import ru.ulmc.extender.tileentity.TileEntityGrinder;

import java.util.Random;

public class BlockGrinder extends BlockContainer implements UlmcBlock {

	@SideOnly(Side.CLIENT)
	private IIcon grinderTop;
	@SideOnly(Side.CLIENT)
	private IIcon grinderLeft;
	@SideOnly(Side.CLIENT)
	private IIcon grinderSide;
	@SideOnly(Side.CLIENT)
	private IIcon grinderRight;
	@SideOnly(Side.CLIENT)
	private IIcon grinderBottom;
	private String name;
	private Random random = new Random();

	public BlockGrinder(String name) {
		super(Material.iron);
		setHardness(1.0F);
		setResistance(2.0F);
		setBlockName(name);
		this.name = name;
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.RES_NAME + name);
	}

	@Override
	public String getSystemName() {
		return name;
	}

	@Override
	@SideOnly(Side.CLIENT)

	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public IIcon getIcon(int par1, int par2) {
		if (par1 == par2) {
			return grinderTop;
		} else {
			if (par1 == 0 || par1 == 1) {
				return grinderSide;
			} else {
				return grinderRight;
			}
		}
	}


	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		grinderLeft = par1IconRegister.registerIcon(Reference.RES_NAME + "grinderLeft");
		grinderTop = par1IconRegister.registerIcon(Reference.RES_NAME + "grinderTop");
		grinderSide = par1IconRegister.registerIcon(Reference.RES_NAME + "grinderSide");
		grinderRight = par1IconRegister.registerIcon(Reference.RES_NAME + "grinderRight");
	}

	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase,
	                            ItemStack par6ItemStack) {
		byte b0 = 0;
		int l = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

		if (l == 0) {
			b0 = 2;
		} else if (l == 1) {
			b0 = 5;
		} else if (l == 2) {
			b0 = 3;
		} else if (l == 3) {
			b0 = 4;
		}

		par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
	}

	/*
	 * /** Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer player, int par6, float par7,
	                                float par8, float par9) {

		if (par1World.isRemote) {
			TileEntityGrinder grinder = (TileEntityGrinder) par1World.getTileEntity(x, y, z);
			if (grinder.isGrinderSetup()) {
				par1World.spawnParticle("largesmoke", x + random.nextFloat(), y + 1, z + random.nextFloat(), 0, 0, 0);
				par1World.spawnParticle("smoke", x + random.nextFloat(), y + 1, z + random.nextFloat(), 0, 0, 0);
			} else {
				par1World.spawnParticle("spell", x + random.nextFloat(), y + 1.1, z + random.nextFloat(), 0, 0, 0);
			}
			return true;
		} else {
			boolean isOpenAction = false;

			if (player.inventory.getCurrentItem() == null || player.inventory.getCurrentItem().getItem() instanceof ItemGrind) {
				isOpenAction = true;
			}
			if (isOpenAction) {
				player.openGui(UltimateExtender.instance, GuiGrinder.GUI_ID, par1World, x, y, z);
			} else {
				TileEntityGrinder grinder = (TileEntityGrinder) par1World.getTileEntity(x, y, z);
				if (grinder.grindItem(player)) {
					par1World.playSoundAtEntity(player, Reference.RES_NAME.concat("grinder.random"), 1.3f - random.nextFloat(), 1.0f + random.nextFloat() / 5);
				} else {
					par1World.playSoundAtEntity(player, Reference.RES_NAME.concat("grinder.empty"), 1.3f - random.nextFloat(), 1.0f + random.nextFloat() / 10);

				}


			}
			return true;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityGrinder();
	}
}
