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
package ru.ulmc.extender.render.model.connected.cabinet;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ru.ulmc.extender.render.model.SimpleUlmcModel;

public class ModelTableCabinetOneSideLeft extends ModelBase implements SimpleUlmcModel {
	// fields

	ModelRenderer surface;
	ModelRenderer back;
	ModelRenderer boxdownFace;
	ModelRenderer boxFrontPanel;
	ModelRenderer angle3;
	ModelRenderer angle4;
	ModelRenderer rim1;
	ModelRenderer rim2;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer rim5;
	ModelRenderer rim6;
	ModelRenderer handle;
	ModelRenderer rim7;
	ModelRenderer side1;
	ModelRenderer leg4;
	ModelRenderer boxFrontPanel1;
	ModelRenderer boxFrontPanel2;
	ModelRenderer handle2;
	ModelRenderer handle3;
	ModelRenderer back2;
	ModelRenderer leg5;
	ModelRenderer angle5;
	ModelRenderer angle6;
	ModelRenderer angle7;
	ModelRenderer angle8;
	ModelRenderer angle9;
	ModelRenderer angle10;

	public ModelTableCabinetOneSideLeft() {
		textureWidth = 128;
		textureHeight = 64;
		surface = new ModelRenderer(this, 0, 0);
		surface.addBox(-8F, -1F, -8F, 16, 1, 16);
		surface.setRotationPoint(0F, 8F, 0F);
		surface.setTextureSize(128, 64);
		surface.mirror = true;
		setRotation(surface, 3.141593F, 0F, 0F);
		back = new ModelRenderer(this, 50, 49);
		back.addBox(0F, 0F, 0F, 14, 9, 1);
		back.setRotationPoint(-8F, 9F, -7.1F);
		back.setTextureSize(128, 64);
		back.mirror = true;
		setRotation(back, 0F, 0F, 0F);
		boxdownFace = new ModelRenderer(this, 33, 18);
		boxdownFace.addBox(0F, 0F, 0F, 12, 14, 1);
		boxdownFace.setRotationPoint(-6F, 23F, -6.6F);
		boxdownFace.setTextureSize(128, 64);
		boxdownFace.mirror = true;
		setRotation(boxdownFace, 1.570796F, 0F, 0F);
		boxFrontPanel = new ModelRenderer(this, -11, 36);
		boxFrontPanel.addBox(-5.5F, -1F, 0F, 11, 4, 0);
		boxFrontPanel.setRotationPoint(0F, 10F, 7.1F);
		boxFrontPanel.setTextureSize(128, 64);
		boxFrontPanel.mirror = true;
		setRotation(boxFrontPanel, 0F, 0F, 0F);
		angle3 = new ModelRenderer(this, 6, 7);
		angle3.addBox(0F, 0F, 0F, 3, 3, 1);
		angle3.setRotationPoint(6F, 21.5F, 5.5F);
		angle3.setTextureSize(128, 64);
		angle3.mirror = true;
		setRotation(angle3, 0.2617994F, 1.570796F, 0F);
		angle4 = new ModelRenderer(this, 6, 7);
		angle4.addBox(-2F, 0F, 0F, 3, 3, 1);
		angle4.setRotationPoint(6F, 21.5F, -4.5F);
		angle4.setTextureSize(128, 64);
		angle4.mirror = true;
		setRotation(angle4, 0.2617994F, 1.570796F, 0F);
		rim1 = new ModelRenderer(this, 0, 0);
		rim1.addBox(0F, 0F, 0F, 1, 11, 1);
		rim1.setRotationPoint(6.5F, 9F, -5.5F);
		rim1.setTextureSize(128, 64);
		rim1.mirror = true;
		setRotation(rim1, 0F, 1.570796F, 1.570796F);
		rim2 = new ModelRenderer(this, 0, 0);
		rim2.addBox(0F, 0F, 0F, 1, 14, 1);
		rim2.setRotationPoint(5.5F, 17F, -7.49F);
		rim2.setTextureSize(128, 64);
		rim2.mirror = true;
		setRotation(rim2, 0F, 0F, 1.570796F);
		leg2 = new ModelRenderer(this, 0, 18);
		leg2.addBox(0F, 0F, 0F, 2, 15, 2);
		leg2.setRotationPoint(5.5F, 9F, -7.5F);
		leg2.setTextureSize(128, 64);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 18);
		leg3.addBox(0F, 0F, 0F, 2, 15, 2);
		leg3.setRotationPoint(5.5F, 9F, 5.5F);
		leg3.setTextureSize(128, 64);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		rim5 = new ModelRenderer(this, 0, 0);
		rim5.addBox(0F, 0F, 0F, 1, 11, 1);
		rim5.setRotationPoint(6.5F, 18F, -5.5F);
		rim5.setTextureSize(128, 64);
		rim5.mirror = true;
		setRotation(rim5, 1.570796F, 0F, 0F);
		rim6 = new ModelRenderer(this, 0, 0);
		rim6.addBox(0F, 0F, 0F, 1, 11, 1);
		rim6.setRotationPoint(3.5F, 9F, -7.5F);
		rim6.setTextureSize(128, 64);
		rim6.mirror = true;
		setRotation(rim6, 0F, 0F, 1.570796F);
		handle = new ModelRenderer(this, 6, 12);
		handle.addBox(-1F, 0F, 0F, 2, 1, 1);
		handle.setRotationPoint(0F, 10.5F, 6.5F);
		handle.setTextureSize(128, 64);
		handle.mirror = true;
		setRotation(handle, 0F, 0F, 0F);
		rim7 = new ModelRenderer(this, 33, 18);
		rim7.addBox(0F, 0F, 0F, 14, 13, 1);
		rim7.setRotationPoint(-7F, 9F, -6.5F);
		rim7.setTextureSize(128, 64);
		rim7.mirror = true;
		setRotation(rim7, 0F, 1.570796F, 1.570796F);
		side1 = new ModelRenderer(this, 33, 18);
		side1.addBox(-7F, 0F, 0F, 14, 14, 1);
		side1.setRotationPoint(6F, 9F, 0F);
		side1.setTextureSize(128, 64);
		side1.mirror = true;
		setRotation(side1, 0F, 1.570796F, 0F);
		leg4 = new ModelRenderer(this, 0, 18);
		leg4.addBox(0F, 0F, 0F, 2, 15, 2);
		leg4.setRotationPoint(-7.5F, 9F, 5.5F);
		leg4.setTextureSize(128, 64);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		boxFrontPanel1 = new ModelRenderer(this, -11, 36);
		boxFrontPanel1.addBox(0F, 0F, 0F, 11, 4, 0);
		boxFrontPanel1.setRotationPoint(-5.5F, 13F, 7.1F);
		boxFrontPanel1.setTextureSize(128, 64);
		boxFrontPanel1.mirror = true;
		setRotation(boxFrontPanel1, 0F, 0F, 0F);
		boxFrontPanel2 = new ModelRenderer(this, -11, 54);
		boxFrontPanel2.addBox(0F, 0F, 0F, 11, 5, 0);
		boxFrontPanel2.setRotationPoint(-5.5F, 17F, 7.1F);
		boxFrontPanel2.setTextureSize(128, 64);
		boxFrontPanel2.mirror = true;
		setRotation(boxFrontPanel2, 0F, 0F, 0F);
		handle2 = new ModelRenderer(this, 6, 12);
		handle2.addBox(-1F, 0F, 0F, 2, 1, 1);
		handle2.setRotationPoint(0F, 14.5F, 6.5F);
		handle2.setTextureSize(128, 64);
		handle2.mirror = true;
		setRotation(handle2, 0F, 0F, 0F);
		handle3 = new ModelRenderer(this, 6, 12);
		handle3.addBox(-1F, 0F, 0F, 2, 1, 1);
		handle3.setRotationPoint(0F, 18F, 6.5F);
		handle3.setTextureSize(128, 64);
		handle3.mirror = true;
		setRotation(handle3, 0F, 0F, 0F);
		back2 = new ModelRenderer(this, 52, -1);
		back2.addBox(0F, 0F, 0F, 12, 7, 1);
		back2.setRotationPoint(-6F, 16F, -7F);
		back2.setTextureSize(128, 64);
		back2.mirror = true;
		setRotation(back2, 0F, 0F, 0F);
		leg5 = new ModelRenderer(this, 0, 18);
		leg5.addBox(0F, 0F, 0F, 2, 15, 2);
		leg5.setRotationPoint(-7.5F, 9F, -7.5F);
		leg5.setTextureSize(128, 64);
		leg5.mirror = true;
		setRotation(leg5, 0F, 0F, 0F);
		angle5 = new ModelRenderer(this, 6, 7);
		angle5.addBox(0F, 0F, 0F, 3, 3, 1);
		angle5.setRotationPoint(-6F, 21.5F, -5.5F);
		angle5.setTextureSize(128, 64);
		angle5.mirror = true;
		setRotation(angle5, 0.2617994F, -1.570796F, 0F);
		angle6 = new ModelRenderer(this, 6, 7);
		angle6.addBox(0F, 0F, 0F, 3, 3, 1);
		angle6.setRotationPoint(-6F, 21.5F, 2.5F);
		angle6.setTextureSize(128, 64);
		angle6.mirror = true;
		setRotation(angle6, 0.2617994F, -1.570796F, 0F);
		angle7 = new ModelRenderer(this, 6, 7);
		angle7.addBox(0F, 0F, 0F, 3, 3, 1);
		angle7.setRotationPoint(5.5F, 21.5F, -6F);
		angle7.setTextureSize(128, 64);
		angle7.mirror = true;
		setRotation(angle7, 0.2617994F, -3.141593F, 0F);
		angle8 = new ModelRenderer(this, 6, 7);
		angle8.addBox(0F, 0F, 0F, 3, 3, 1);
		angle8.setRotationPoint(-2.5F, 21.5F, -6F);
		angle8.setTextureSize(128, 64);
		angle8.mirror = true;
		setRotation(angle8, 0.2617994F, -3.141593F, 0F);
		angle9 = new ModelRenderer(this, 6, 7);
		angle9.addBox(0F, 0F, 0F, 3, 2, 1);
		angle9.setRotationPoint(2.5F, 22.5F, 6.4F);
		angle9.setTextureSize(128, 64);
		angle9.mirror = true;
		setRotation(angle9, 0.2617994F, 0F, 0F);
		angle10 = new ModelRenderer(this, 6, 7);
		angle10.addBox(0F, 0F, 0F, 3, 2, 1);
		angle10.setRotationPoint(-5.5F, 22.5F, 6.4F);
		angle10.setTextureSize(128, 64);
		angle10.mirror = true;
		setRotation(angle10, 0.2617994F, 0F, 0F);
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
		back.render(f5);
		boxdownFace.render(f5);
		boxFrontPanel.render(f5);
		angle3.renderWithRotation(f5);
		angle4.renderWithRotation(f5);
		rim1.renderWithRotation(f5);
		rim2.renderWithRotation(f5);
		leg2.renderWithRotation(f5);
		leg3.renderWithRotation(f5);
		rim5.renderWithRotation(f5);
		rim6.renderWithRotation(f5);
		handle.render(f5);
		rim7.renderWithRotation(f5);
		side1.render(f5);
		leg4.render(f5);
		boxFrontPanel1.render(f5);
		boxFrontPanel2.render(f5);
		handle2.render(f5);
		handle3.render(f5);
		back2.render(f5);
		leg5.render(f5);
		angle5.renderWithRotation(f5);
		angle6.renderWithRotation(f5);
		angle7.renderWithRotation(f5);
		angle8.renderWithRotation(f5);
		angle9.renderWithRotation(f5);
		angle10.renderWithRotation(f5);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
