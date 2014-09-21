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
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.config.StringsConfig;

import java.util.Random;

public class BaseBlock extends Block implements UlmcBlock {
	private String name;

	public BaseBlock(int blockID, Material material, String systemBlockName, float hardness, float resistance,
	                 SoundType stepSound) {
		super(material);
		setBlockTextureName(Reference.RES_NAME.concat(systemBlockName));
		setHardness(hardness);
		setResistance(resistance);
		setStepSound(stepSound);
		setBlockName(systemBlockName);
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
