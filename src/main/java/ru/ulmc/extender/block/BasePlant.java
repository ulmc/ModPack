/*
 * Copyright (C) 2014. ulmc.ru (Alex K.)
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
 */

package ru.ulmc.extender.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

/**
 * Created by Пользователь on 28.09.14.
 */
public class BasePlant extends BlockCrops implements UlmcBlock{
    @SideOnly(Side.CLIENT)
    protected IIcon[] icon;
    protected Item item;
    protected String name;

    public BasePlant(String systemBlockName) {
        super();
        setBlockName(systemBlockName);
        name = systemBlockName;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        if (meta < 7) {
            return this.icon[meta];
        } else {
            return this.icon[7];
        }
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    protected boolean canPlaceBlockOn(Block parBlock)
    {
        return parBlock == Blocks.farmland;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random parRand, int parFortune)
    {
        return Item.getItemFromBlock(this);
    }


    protected Item func_149866_i()
    {
        return item;
    }

    protected Item func_149865_P()
    {
        return item;
    }

    @Override
    public String getSystemName() {
        return name;
    }
}
