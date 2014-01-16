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

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlag extends ModelBase {
	// fields
	ModelRenderer bottomShape;
	ModelRenderer littleBottomShape;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer flagShape;

	public ModelFlag() {
		textureWidth = 64;
		textureHeight = 56;

		bottomShape = new ModelRenderer(this, 0, 0);
		bottomShape.addBox(-5F, 0F, -5F, 10, 1, 10);
		bottomShape.setRotationPoint(0F, 23F, 0F);
		bottomShape.setTextureSize(64, 56);
		bottomShape.mirror = true;
		setRotation(bottomShape, 0.0151262F, 0.7853982F, 0F);

		littleBottomShape = new ModelRenderer(this, 0, 0);
		littleBottomShape.addBox(-3F, 0F, -3F, 6, 1, 6);
		littleBottomShape.setRotationPoint(0F, 22F, 0F);
		littleBottomShape.setTextureSize(64, 56);
		littleBottomShape.mirror = true;
		setRotation(littleBottomShape, 0F, 0.7853982F, 0F);

		Shape3 = new ModelRenderer(this, 60, 0);
		Shape3.addBox(0.5F, 0F, 0.5F, 1, 47, 1);
		Shape3.setRotationPoint(-1F, -25F, -1F);
		Shape3.setTextureSize(64, 56);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);

		Shape4 = new ModelRenderer(this, 60, 0);
		Shape4.addBox(-0.5F, -9F, -0.5F, 1, 18, 1);
		Shape4.setRotationPoint(0.03333334F, -23F, 0F);
		Shape4.setTextureSize(64, 56);
		Shape4.mirror = true;
		setRotation(Shape4, 1.570796F, 1.570796F, 0F);

		flagShape = new ModelRenderer(this, 0, -7);
		flagShape.addBox(0F, 0F, -8F, 0, 44, 18);
		flagShape.setRotationPoint(-1F, -23F, 0.6F);
		flagShape.setTextureSize(64, 56);
		flagShape.mirror = true;
		setRotation(flagShape, 0F, 1.570796F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		bottomShape.render(f5);
		littleBottomShape.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		flagShape.render(f5);
	}

	public void render(float f5) {
		bottomShape.render(f5);
		littleBottomShape.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		flagShape.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
