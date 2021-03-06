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
package ru.ulmc.extender.render.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ModelLockedChest extends ModelBase {
	/**
	 * The chest lid in the chest's model.
	 */
	public ModelRenderer chestLid = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);

	/**
	 * The model of the bottom of the chest.
	 */
	public ModelRenderer chestBelow;

	/**
	 * The chest's knob in the chest model.
	 */
	public ModelRenderer chestKnob;

	public ModelLockedChest() {
		this.chestLid.addBox(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
		this.chestLid.rotationPointX = 1.0F;
		this.chestLid.rotationPointY = 7.0F;
		this.chestLid.rotationPointZ = 15.0F;
		this.chestKnob = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		this.chestKnob.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
		this.chestKnob.rotationPointX = 8.0F;
		this.chestKnob.rotationPointY = 7.0F;
		this.chestKnob.rotationPointZ = 15.0F;
		this.chestBelow = (new ModelRenderer(this, 0, 19)).setTextureSize(64, 64);
		this.chestBelow.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
		this.chestBelow.rotationPointX = 1.0F;
		this.chestBelow.rotationPointY = 6.0F;
		this.chestBelow.rotationPointZ = 1.0F;
	}

	/**
	 * This method renders out all parts of the chest model.
	 */
	public void renderAll() {
		this.chestKnob.rotateAngleX = this.chestLid.rotateAngleX;
		this.chestLid.render(0.0625F);
		this.chestKnob.render(0.0625F);
		this.chestBelow.render(0.0625F);
	}
}
