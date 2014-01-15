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

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BaseBlock extends Block implements UlmcBlock {
	private String name;
	public BaseBlock(int blockID, Material material, String systemBlockName, float hardness, float resistance,
			StepSound stepSound) {
		super(blockID, material);
		setTextureName("ulex:" + systemBlockName);
		setHardness(hardness);
		setResistance(resistance);
		setStepSound(stepSound);
		setUnlocalizedName(systemBlockName);
		name = systemBlockName;
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}

	@Override
	public String getSystemName() {
		return name;
	}
}
