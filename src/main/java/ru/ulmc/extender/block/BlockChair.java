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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import ru.ulmc.extender.Reference;

public class BlockChair extends BasicStandingBlock {

    @SuppressWarnings("rawtypes")
    public BlockChair(Class entity, float aHardness, float aResistance,
                      String aBlockName) {
        super(Material.wood, entity, aBlockName);
        anEntityClass = entity;
        setHardness(aHardness);
        setResistance(aResistance);
        setStepSound(Block.soundTypeWood);
        setCreativeTab(CreativeTabs.tabDecorations);
        setBlockTextureName(Reference.RES_NAME + getUnlocalizedName());
        setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.7F, 0.9F);
    }

    @Override
    public TileEntity getBlockEntity() {
        try {
            return (TileEntity) anEntityClass.newInstance();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
