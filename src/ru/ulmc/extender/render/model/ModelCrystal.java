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
package ru.ulmc.extender.render.model;

// Date: 02.09.2012 16:13:07
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrystal extends ModelBase {
	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;

	public ModelCrystal() {
		textureWidth = 48;
		textureHeight = 24;

		Shape1 = new ModelRenderer(this, 26, 0);
		Shape1.addBox(-2F, 0F, -2F, 4, 16, 4);
		Shape1.setRotationPoint(0F, 8F, 0F);
		Shape1.setTextureSize(48, 24);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 12);
		Shape2.addBox(-2F, -8F, -2F, 3, 7, 3);
		Shape2.setRotationPoint(-2F, 25F, 3F);
		Shape2.setTextureSize(48, 24);
		Shape2.mirror = true;
		setRotation(Shape2, -0.2564291F, 0F, -0.2974289F);
		Shape3 = new ModelRenderer(this, 13, 8);
		Shape3.addBox(-1F, 0F, -1F, 3, 11, 3);
		Shape3.setRotationPoint(6F, 15F, -6F);
		Shape3.setTextureSize(48, 24);
		Shape3.mirror = true;
		setRotation(Shape3, 0.3369828F, 0F, 0.3717861F);
		Shape4 = new ModelRenderer(this, 0, 0);
		Shape4.addBox(0F, 0F, 0F, 3, 8, 3);
		Shape4.setRotationPoint(4F, 16F, 3F);
		Shape4.setTextureSize(48, 24);
		Shape4.mirror = true;
		setRotation(Shape4, -0.3717861F, 0F, 0.2974289F);
		Shape5 = new ModelRenderer(this, 13, 0);
		Shape5.addBox(0F, -6F, 0F, 2, 5, 2);
		Shape5.setRotationPoint(0F, 19F, -2F);
		Shape5.setTextureSize(48, 24);
		Shape5.mirror = true;
		setRotation(Shape5, 0.7853982F, 0F, -0.5235988F);
		Shape6 = new ModelRenderer(this, 0, 0);
		Shape6.addBox(0F, 0F, 0F, 3, 8, 3);
		Shape6.setRotationPoint(-7F, 17F, -5.466667F);
		Shape6.setTextureSize(48, 24);
		Shape6.mirror = true;
		setRotation(Shape6, 0.1858931F, 0F, -0.4089647F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
	}

	public void render(float f5) {
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
