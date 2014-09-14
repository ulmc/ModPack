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
package ru.ulmc.extender.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import ru.ulmc.extender.Reference;

public class ItemGrind extends Item {

	public IIcon placeholder;
	private float chanceToBuff = 0.0F;
	private float bufflevel = 0.0F;

	public ItemGrind(String unlocalizedName, int durability, float chanceToBuff, float bufflevel) {
		super();
		setUnlocalizedName(unlocalizedName);
		setTextureName(Reference.RES_NAME + unlocalizedName);
		setCreativeTab(CreativeTabs.tabTools);
        if("woodenGrindstoneBlank".equals(unlocalizedName) || "ironGrindstoneBlank".equals(unlocalizedName)) {
            this.setMaxStackSize(32);
        } else {
		    this.setMaxStackSize(1);
        }
		this.setMaxDamage(durability);
		this.chanceToBuff = chanceToBuff;
		this.bufflevel = bufflevel;
	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister) {
		super.registerIcons(par1IconRegister);
		this.placeholder = par1IconRegister.registerIcon(Reference.RES_NAME + "placeholderGrind");
	}

	public float getChanceToBuff() {
		return chanceToBuff;
	}
	
	public boolean isGoodEnoughForRenaming() {
		if(bufflevel > 0.5) {
			return true;
		} 
		return false;
	}

	public float getRandomBuff() {
		float buff = bufflevel;
		double chance = Math.random();
		if(chance < chanceToBuff / 10) {
			buff += bufflevel * 2 + Math.random();
		} else if(chance < chanceToBuff / 5) {
			buff += bufflevel + Math.random();
		}	else if(chance < chanceToBuff / 5) {
			buff += bufflevel + Math.random();
		} else if(chance < chanceToBuff / 2) {
			buff += bufflevel / 4 + Math.random();
		}
		return buff;
	}
	
	
}
