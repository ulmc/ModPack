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

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEliteChair extends ModelBase {
	// fields
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg4;
	ModelRenderer leg3;
	ModelRenderer sitting;
	ModelRenderer back1;
	ModelRenderer back2;
	ModelRenderer back3;

	public ModelEliteChair() {
		textureWidth = 64;
		textureHeight = 15;

		textureWidth = 64;
		textureHeight = 15;

		leg1 = new ModelRenderer(this, 0, 0);
		leg1.addBox(0F, 0F, 0F, 2, 9, 2);
		leg1.setRotationPoint(-5F, 15F, -5F);
		leg1.setTextureSize(64, 15);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 0);
		leg2.addBox(0F, 0F, 0F, 2, 9, 2);
		leg2.setRotationPoint(3F, 15F, -5F);
		leg2.setTextureSize(64, 15);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 0);
		leg4.addBox(0F, 0F, 0F, 2, 9, 2);
		leg4.setRotationPoint(4F, 15F, 3F);
		leg4.setTextureSize(64, 15);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 0);
		leg3.addBox(0F, 0F, 0F, 2, 9, 2);
		leg3.setRotationPoint(-6F, 15F, 3F);
		leg3.setTextureSize(64, 15);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		sitting = new ModelRenderer(this, 16, 0);
		sitting.addBox(-8F, -2F, -8F, 12, 2, 12);
		sitting.setRotationPoint(2F, 15F, 2F);
		sitting.setTextureSize(64, 15);
		sitting.mirror = true;
		setRotation(sitting, 0F, 0F, 0F);
		back1 = new ModelRenderer(this, 0, 0);
		back1.addBox(0F, 0F, 0F, 1, 13, 2);
		back1.setRotationPoint(-5F, 0F, 4F);
		back1.setTextureSize(64, 15);
		back1.mirror = true;
		setRotation(back1, 0F, 0F, 0F);
		back2 = new ModelRenderer(this, 0, 0);
		back2.addBox(0F, 0F, 0F, 1, 13, 2);
		back2.setRotationPoint(4F, 0F, 4F);
		back2.setTextureSize(64, 15);
		back2.mirror = true;
		setRotation(back2, 0F, 0F, 0F);
		back3 = new ModelRenderer(this, 10, 0);
		back3.addBox(0F, 0F, 0F, 7, 8, 1);
		back3.setRotationPoint(4F, 0F, 5F);
		back3.setTextureSize(64, 15);
		back3.mirror = true;
		setRotation(back3, 0F, 0F, 1.570796F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
	                   float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		leg1.render(f5);
		leg2.render(f5);
		leg4.render(f5);
		leg3.render(f5);
		sitting.render(f5);
		back1.render(f5);
		back2.render(f5);
		back3.render(f5);
	}

	public void render(float f5) {
		leg1.render(f5);
		leg2.render(f5);
		leg4.render(f5);
		leg3.render(f5);
		sitting.render(f5);
		back1.render(f5);
		back2.render(f5);
		back3.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
/*
	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}
*/
}