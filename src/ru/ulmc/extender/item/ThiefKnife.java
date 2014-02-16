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
package ru.ulmc.extender.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.Reference;

/**
 * Created by 45 on 16.02.14.
 */
public class ThiefKnife extends Item implements Grindable, UItem {
    public ThiefKnife(int i, String unlocalizedName) {
        super(i);
        setUnlocalizedName(unlocalizedName);
        setTextureName(Reference.RES_NAME + unlocalizedName);
        setCreativeTab(CreativeTabs.tabMaterials);
    }
    @Override
    public boolean grindItem(EntityPlayer player, ItemStack grinder, ItemStack hold, ItemStack example) {
        return false;
    }

    @Override
    public String getClearItemName() {
        return null;
    }
}
