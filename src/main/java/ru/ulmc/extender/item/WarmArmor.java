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

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.Reference;

public class WarmArmor extends ItemArmor implements IWarmArmor {
	private static final int maxDamageArray[] = {11, 16, 15, 13};
	public final int damageReduceAmount;
	private final EnumThermalMaterial material;
	private String textureNameTop;
	private String textureNameBottom;
	private boolean isLegs;
	private boolean itWarms;
	private boolean itCools;
	private boolean isLavaProtected;

	public WarmArmor(EnumThermalMaterial material, int renderIndex, int armorType, String aName,
	                 boolean isLegs, boolean itWarms, boolean itCools, boolean isLavaProtected) {
		super(ArmorMaterial.IRON, renderIndex, armorType);
		this.material = material;
		damageReduceAmount = material.getDamageReductionAmount(armorType);
		setMaxDamage(material.getDurability(armorType));
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName(aName);
		setTextureName(Reference.RES_NAME + aName);
		this.isLegs = isLegs;
		this.itWarms = itWarms;
		this.itCools = itCools;
		this.isLavaProtected = isLavaProtected;
		textureNameTop = Reference.RES_NAME + "textures/armor/" + material.name().toLowerCase() + "-top.png";
		textureNameBottom = Reference.RES_NAME + "textures/armor/" + material.name().toLowerCase() + "-bottom.png";
	}

	static int[] getMaxDamageArray() {
		return maxDamageArray;
	}

	@Override
	public int getItemEnchantability() {
		return material.getEnchantability();
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (!isLegs) {
			return textureNameTop;
		} else {
			return textureNameBottom;
		}
	}

	@Override
	public float getWarmLevel() {
		return material.getWarmLevel();
	}

	@Override
	public boolean itWarms() {
		return itWarms;
	}

	@Override
	public boolean itCools() {
		return itCools;
	}

	@Override
	public boolean itLavaProtected() {
		return isLavaProtected;
	}

	@Override
	public float getCoolLevel() {
		return material.getCoolLevel();
	}

	@Override
	public float getLavaProtectionLevel() {
		return material.getLavaProtection();
	}

}
