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

public class ModelTable extends ModelBase implements SimpleUlmcModel {
	// fields
	ModelRenderer footStep1;
	ModelRenderer surface;
	ModelRenderer onLeg;
	ModelRenderer leg;
	ModelRenderer onStep;
	ModelRenderer footStep2;
	ModelRenderer footStep3;
	ModelRenderer footStep4;

	public ModelTable() {
		textureWidth = 64;
		textureHeight = 64;

		footStep1.mirror = true;
		footStep1 = new ModelRenderer(this, 0, 19);
		footStep1.addBox(-1F, 0F, -1F, 2, 8, 2);
		footStep1.setRotationPoint(0F, 23F, 1F);
		footStep1.setTextureSize(64, 64);
		footStep1.mirror = true;
		setRotation(footStep1, -1.361357F, 0F, 0F);
		footStep1.mirror = false;
		surface = new ModelRenderer(this, 0, 0);
		surface.addBox(-8F, 0F, -8F, 16, 2, 16);
		surface.setRotationPoint(0F, 8F, 0F);
		surface.setTextureSize(64, 64);
		surface.mirror = true;
		setRotation(surface, 0F, 0F, 0F);
		onLeg = new ModelRenderer(this, 21, 28);
		onLeg.addBox(-3F, 0F, -3F, 6, 1, 6);
		onLeg.setRotationPoint(0F, 10F, 0F);
		onLeg.setTextureSize(64, 64);
		onLeg.mirror = true;
		setRotation(onLeg, 0F, 0F, 0F);
		leg = new ModelRenderer(this, 0, 19);
		leg.addBox(-1F, 0F, -1F, 2, 12, 2);
		leg.setRotationPoint(0F, 11F, 0F);
		leg.setTextureSize(64, 64);
		leg.mirror = true;
		setRotation(leg, 0F, 0F, 0F);
		onStep = new ModelRenderer(this, 23, 36);
		onStep.addBox(-2F, 0F, -2F, 4, 1, 4);
		onStep.setRotationPoint(0F, 22F, 0F);
		onStep.setTextureSize(64, 64);
		onStep.mirror = true;
		setRotation(onStep, 0F, 0F, 0F);
		footStep2 = new ModelRenderer(this, 0, 19);
		footStep2.mirror = true;
		footStep2.addBox(-1F, -1F, -1F, 2, 8, 2);
		footStep2.setRotationPoint(0F, 23F, 0F);
		footStep2.setTextureSize(64, 64);
		setRotation(footStep2, -1.361357F, 3.141593F, 0F);
		footStep3 = new ModelRenderer(this, 0, 19);
		footStep3.addBox(-1F, -1F, -1F, 2, 8, 2);
		footStep3.setRotationPoint(0F, 23F, 0F);
		footStep3.setTextureSize(64, 64);
		footStep3.mirror = true;
		setRotation(footStep3, 1.361357F, -1.570796F, 0F);
		footStep4 = new ModelRenderer(this, 0, 19);
		footStep4.addBox(-1F, -1F, -1F, 2, 8, 2);
		footStep4.setRotationPoint(0F, 23F, 0F);
		footStep4.setTextureSize(64, 64);
		footStep4.mirror = true;
		setRotation(footStep4, 1.361357F, 1.570796F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
	                   float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		render(f5);
	}

	@Override
	public void render(float f5) {
		surface.render(f5);
		onLeg.render(f5);
		leg.render(f5);
		onStep.render(f5);
		footStep1.render(f5);
		footStep2.render(f5);
		footStep3.render(f5);
		footStep4.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
