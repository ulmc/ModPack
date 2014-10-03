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

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.util.ForgeDirection;
import ru.ulmc.extender.Reference;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import ru.ulmc.extender.item.ItemManager;

import java.rmi.registry.Registry;
import java.util.Random;

/**
 * Created by Пользователь on 28.09.14.
 */
public class BlockBarley extends BasePlant {

    public BlockBarley(String systemBlockName) {
        super(systemBlockName);
        setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return item;
    }

    @Override
    public int quantityDropped(int parMetadata, int parFortune, Random parRand) {
        if (parMetadata >= 7) {
            return MathHelper.getRandomIntegerInRange(parRand, 1, 3);
        } else {
            return 0;
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        icon = new IIcon[8];
        int stg = 0;
        for (int i = 0; i < icon.length; i += 2) {
            icon[i] = register.registerIcon(Reference.RES_NAME + "barley_stage_" + stg);
            icon[i + 1] = register.registerIcon(Reference.RES_NAME + "barley_stage_" + stg++);
        }
    }
}
