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

public class ModelTableDinner extends ModelBase implements SimpleUlmcModel {
	// fields
	ModelRenderer main;
	ModelRenderer additional;
	ModelRenderer leg1;
	ModelRenderer leg11;
	ModelRenderer leg2;
	ModelRenderer leg21;
	ModelRenderer leg3;
	ModelRenderer leg31;
	ModelRenderer leg4;
	ModelRenderer leg41;
	ModelRenderer base1;
	ModelRenderer stif1;
	ModelRenderer stif11;
	ModelRenderer base2;
	ModelRenderer stif2;
	ModelRenderer stif21;
	ModelRenderer base3;
	ModelRenderer stif31;
	ModelRenderer stif32;
	ModelRenderer base4;
	ModelRenderer stif41;
	ModelRenderer stif42;

	public ModelTableDinner() {
		textureWidth = 64;
		textureHeight = 32;

		main = new ModelRenderer(this, 0, 0);
		main.addBox(-8F, 0F, -8F, 16, 2, 16);
		main.setRotationPoint(0F, 8F, 0F);
		main.setTextureSize(64, 32);
		main.mirror = true;
		setRotation(main, 0F, 0F, 0F);
		additional = new ModelRenderer(this, 6, 3);
		additional.addBox(-6.5F, 1F, -6.5F, 13, 1, 13);
		additional.setRotationPoint(0F, 9F, 0F);
		additional.setTextureSize(64, 32);
		additional.mirror = true;
		setRotation(additional, 0F, 1.570796F, 0F);
		leg1 = new ModelRenderer(this, 0, 18);
		leg1.addBox(5F, 2F, 5F, 1, 13, 1);
		leg1.setRotationPoint(0F, 9F, 0F);
		leg1.setTextureSize(64, 32);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg11 = new ModelRenderer(this, 2, 18);
		leg11.addBox(4.6F, 2F, 4.6F, 1, 13, 1);
		leg11.setRotationPoint(0F, 9F, 0F);
		leg11.setTextureSize(64, 32);
		leg11.mirror = true;
		setRotation(leg11, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 18);
		leg2.addBox(-6F, 2F, -6F, 1, 13, 1);
		leg2.setRotationPoint(0F, 9F, 0F);
		leg2.setTextureSize(64, 32);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg21 = new ModelRenderer(this, 2, 18);
		leg21.addBox(-5.6F, 2F, -5.6F, 1, 13, 1);
		leg21.setRotationPoint(0F, 9F, 0F);
		leg21.setTextureSize(64, 32);
		leg21.mirror = true;
		setRotation(leg21, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 18);
		leg3.addBox(5F, 2F, -6F, 1, 13, 1);
		leg3.setRotationPoint(0F, 9F, 0F);
		leg3.setTextureSize(64, 32);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		leg31 = new ModelRenderer(this, 2, 18);
		leg31.addBox(4.6F, 2F, -5.6F, 1, 13, 1);
		leg31.setRotationPoint(0F, 9F, 0F);
		leg31.setTextureSize(64, 32);
		leg31.mirror = true;
		setRotation(leg31, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 18);
		leg4.addBox(-6F, 2F, 5F, 1, 13, 1);
		leg4.setRotationPoint(0F, 9F, 0F);
		leg4.setTextureSize(64, 32);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		leg41 = new ModelRenderer(this, 2, 18);
		leg41.addBox(-5.6F, 2F, 4.6F, 1, 13, 1);
		leg41.setRotationPoint(0F, 9F, 0F);
		leg41.setTextureSize(64, 32);
		leg41.mirror = true;
		setRotation(leg41, 0F, 0F, 0F);
		base1 = new ModelRenderer(this, 6, 28);
		base1.addBox(4.8F, 0.5F, 4.8F, 2, 2, 2);
		base1.setRotationPoint(0F, 9F, 0F);
		base1.setTextureSize(64, 32);
		base1.mirror = true;
		setRotation(base1, 0F, 0F, 0F);
		stif1 = new ModelRenderer(this, 6, 24);
		stif1.addBox(5.3F, -5F, 5.3F, 1, 2, 1);
		stif1.setRotationPoint(0F, 9F, 0F);
		stif1.setTextureSize(64, 32);
		stif1.mirror = true;
		setRotation(stif1, -0.7853982F, 0F, 0F);
		stif11 = new ModelRenderer(this, 6, 24);
		stif11.addBox(-6.3F, -5F, 5.2F, 1, 2, 1);
		stif11.setRotationPoint(0F, 9.1F, 0F);
		stif11.setTextureSize(64, 32);
		stif11.mirror = true;
		setRotation(stif11, -0.7853982F, 1.570796F, 0F);
		base2 = new ModelRenderer(this, 6, 28);
		base2.addBox(-6.8F, 0.5F, -6.8F, 2, 2, 2);
		base2.setRotationPoint(0F, 9F, 0F);
		base2.setTextureSize(64, 32);
		base2.mirror = true;
		setRotation(base2, 0F, 0F, 0F);
		stif2 = new ModelRenderer(this, 6, 24);
		stif2.addBox(5.3F, -5F, -6.2F, 1, 2, 1);
		stif2.setRotationPoint(0F, 9.1F, 0F);
		stif2.setTextureSize(64, 32);
		stif2.mirror = true;
		setRotation(stif2, 0.7853982F, 1.570796F, 0F);
		stif21 = new ModelRenderer(this, 6, 24);
		stif21.addBox(-6.3F, -5F, -6.3F, 1, 2, 1);
		stif21.setRotationPoint(0F, 9F, 0F);
		stif21.setTextureSize(64, 32);
		stif21.mirror = true;
		setRotation(stif21, 0.7853982F, 0F, 0F);
		base3 = new ModelRenderer(this, 6, 28);
		base3.addBox(4.8F, 0.5F, -6.8F, 2, 2, 2);
		base3.setRotationPoint(0F, 9F, 0F);
		base3.setTextureSize(64, 32);
		base3.mirror = true;
		setRotation(base3, 0F, 0F, 0F);
		stif31 = new ModelRenderer(this, 6, 24);
		stif31.addBox(5.3F, -5F, 5.2F, 1, 2, 1);
		stif31.setRotationPoint(0F, 9.1F, 0F);
		stif31.setTextureSize(64, 32);
		stif31.mirror = true;
		setRotation(stif31, -0.7853982F, 1.570796F, 0F);
		stif32 = new ModelRenderer(this, 6, 24);
		stif32.addBox(5.3F, -5F, -6.3F, 1, 2, 1);
		stif32.setRotationPoint(0F, 9F, 0F);
		stif32.setTextureSize(64, 32);
		stif32.mirror = true;
		setRotation(stif32, 0.7853982F, 0F, 0F);
		base4 = new ModelRenderer(this, 6, 28);
		base4.addBox(-6.8F, 0.5F, 4.8F, 2, 2, 2);
		base4.setRotationPoint(0F, 9F, 0F);
		base4.setTextureSize(64, 32);
		base4.mirror = true;
		setRotation(base4, 0F, 0F, 0F);
		stif41 = new ModelRenderer(this, 6, 24);
		stif41.addBox(-6.3F, -5F, 5.3F, 1, 2, 1);
		stif41.setRotationPoint(0F, 9F, 0F);
		stif41.setTextureSize(64, 32);
		stif41.mirror = true;
		setRotation(stif41, -0.7853982F, 0F, 0F);
		stif42 = new ModelRenderer(this, 6, 24);
		stif42.addBox(-6.3F, -5F, -6.2F, 1, 2, 1);
		stif42.setRotationPoint(0F, 9.1F, 0F);
		stif42.setTextureSize(64, 32);
		stif42.mirror = true;
		setRotation(stif42, 0.7853982F, 1.570796F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
	                   float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public void render(float f5) {
		main.render(f5);
		additional.render(f5);
		leg1.render(f5);
		leg11.render(f5);
		leg2.render(f5);
		leg21.render(f5);
		leg3.render(f5);
		leg31.render(f5);
		leg4.render(f5);
		leg41.render(f5);
		base1.render(f5);
		stif1.render(f5);
		stif11.render(f5);
		base2.render(f5);
		stif2.render(f5);
		stif21.render(f5);
		base3.render(f5);
		stif31.render(f5);
		stif32.render(f5);
		base4.render(f5);
		stif41.render(f5);
		stif42.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
