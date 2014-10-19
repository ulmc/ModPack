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

public class ModelTableCabinetOneSideRightFull extends ModelBase implements SimpleUlmcModel {
	// fields
	ModelRenderer surface;
	ModelRenderer side1;
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
	ModelRenderer middle;
	ModelRenderer boxFrontPanelBottom;
	ModelRenderer handle2;
	ModelRenderer back2;
	ModelRenderer angle5;
	ModelRenderer angle6;
	ModelRenderer leg5;
	ModelRenderer leg6;
	ModelRenderer anglef1;
	ModelRenderer anglef2;


	public ModelTableCabinetOneSideRightFull() {
		textureWidth = 128;
		textureHeight = 64;

		surface = new ModelRenderer(this, 0, 0);
		surface.mirror = true;
		surface.addBox(-8F, -1F, -8F, 16, 1, 16);
		surface.setRotationPoint(0F, 8F, 0F);
		surface.setTextureSize(128, 64);
		setRotation(surface, 3.141593F, 0F, 0F);
		side1 = new ModelRenderer(this, 33, 18);
		side1.addBox(-6F, 0F, 0F, 14, 14, 1);
		side1.setRotationPoint(-7F, 9F, 1F);
		side1.setTextureSize(128, 64);
		side1.mirror = true;
		setRotation(side1, 0F, 1.570796F, 0F);
		back = new ModelRenderer(this, 50, 49);
		back.addBox(0F, 0F, 0F, 14, 9, 1);
		back.setRotationPoint(-6F, 9F, -7.1F);
		back.setTextureSize(128, 64);
		back.mirror = true;
		setRotation(back, 0F, 0F, 0F);
		boxdownFace = new ModelRenderer(this, 33, 18);
		boxdownFace.addBox(0F, 0F, 0F, 12, 14, 1);
		boxdownFace.setRotationPoint(-6F, 23F, -7F);
		boxdownFace.setTextureSize(128, 64);
		boxdownFace.mirror = true;
		setRotation(boxdownFace, 1.570796F, 0F, 0F);
		boxFrontPanel = new ModelRenderer(this, -11, 46);
		boxFrontPanel.addBox(-5.5F, -1F, 0F, 11, 4, 0);
		boxFrontPanel.setRotationPoint(0F, 10F, 7F);
		boxFrontPanel.setTextureSize(128, 64);
		boxFrontPanel.mirror = true;
		setRotation(boxFrontPanel, 0F, 0F, 0F);
		angle3 = new ModelRenderer(this, 6, 7);
		angle3.addBox(0F, 0F, 0F, 3, 3, 1);
		angle3.setRotationPoint(-6F, 21.5F, 2.5F);
		angle3.setTextureSize(128, 64);
		angle3.mirror = true;
		setRotation(angle3, 0.2617994F, -1.570796F, 0F);
		angle4 = new ModelRenderer(this, 6, 7);
		angle4.addBox(0F, 0F, 0F, 3, 3, 1);
		angle4.setRotationPoint(-6F, 21.5F, -5.5F);
		angle4.setTextureSize(128, 64);
		angle4.mirror = true;
		setRotation(angle4, 0.2617994F, -1.570796F, 0F);
		rim1 = new ModelRenderer(this, 0, 0);
		rim1.addBox(0F, 0F, 0F, 1, 11, 1);
		rim1.setRotationPoint(-7.5F, 9F, -5.5F);
		rim1.setTextureSize(128, 64);
		rim1.mirror = true;
		setRotation(rim1, 0F, 1.570796F, 1.570796F);
		rim2 = new ModelRenderer(this, 0, 0);
		rim2.addBox(0F, 0F, 0F, 1, 14, 1);
		rim2.setRotationPoint(8.5F, 17F, -7.49F);
		rim2.setTextureSize(128, 64);
		rim2.mirror = true;
		setRotation(rim2, 0F, 0F, 1.570796F);
		leg2 = new ModelRenderer(this, 0, 18);
		leg2.addBox(0F, 0F, 0F, 2, 15, 2);
		leg2.setRotationPoint(-7.5F, 9F, -7.5F);
		leg2.setTextureSize(128, 64);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 18);
		leg3.addBox(0F, 0F, 0F, 2, 15, 2);
		leg3.setRotationPoint(-7.5F, 9F, 5.5F);
		leg3.setTextureSize(128, 64);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		rim5 = new ModelRenderer(this, 0, 0);
		rim5.addBox(0F, 0F, 0F, 1, 11, 1);
		rim5.setRotationPoint(-7.5F, 18F, -5.5F);
		rim5.setTextureSize(128, 64);
		rim5.mirror = true;
		setRotation(rim5, 1.570796F, 0F, 0F);
		rim6 = new ModelRenderer(this, 0, 0);
		rim6.addBox(0F, 0F, 0F, 1, 11, 1);
		rim6.setRotationPoint(5.5F, 9F, -7.5F);
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
		rim7.setRotationPoint(5.5F, 9F, -6.5F);
		rim7.setTextureSize(128, 64);
		rim7.mirror = true;
		setRotation(rim7, 0F, 1.570796F, 1.570796F);
		middle = new ModelRenderer(this, 33, 18);
		middle.addBox(0F, 0F, 0F, 11, 1, 1);
		middle.setRotationPoint(-5.5F, 14F, 6.5F);
		middle.setTextureSize(128, 64);
		middle.mirror = true;
		setRotation(middle, 1.570796F, 0F, 0F);
		boxFrontPanelBottom = new ModelRenderer(this, -11, 51);
		boxFrontPanelBottom.addBox(-5.5F, 0F, 7F, 11, 8, 0);
		boxFrontPanelBottom.setRotationPoint(0F, 14F, 0F);
		boxFrontPanelBottom.setTextureSize(128, 64);
		boxFrontPanelBottom.mirror = true;
		setRotation(boxFrontPanelBottom, 0F, 0F, 0F);
		handle2 = new ModelRenderer(this, 12, 12);
		handle2.addBox(0F, 0F, 0F, 1, 3, 1);
		handle2.setRotationPoint(2.5F, 16F, 6.7F);
		handle2.setTextureSize(128, 64);
		handle2.mirror = true;
		setRotation(handle2, 0F, 0F, 0F);
		back2 = new ModelRenderer(this, 52, 0);
		back2.addBox(0F, 0F, 0F, 12, 5, 1);
		back2.setRotationPoint(-6F, 17F, -7F);
		back2.setTextureSize(128, 64);
		back2.mirror = true;
		setRotation(back2, 0F, 0F, 0F);
		angle5 = new ModelRenderer(this, 6, 7);
		angle5.addBox(0F, 0F, 0F, 3, 3, 1);
		angle5.setRotationPoint(5.5F, 21.5F, -2.5F);
		angle5.setTextureSize(128, 64);
		angle5.mirror = true;
		setRotation(angle5, 0.2617994F, 1.570796F, 0F);
		angle6 = new ModelRenderer(this, 6, 7);
		angle6.addBox(0F, 0F, 0F, 3, 3, 1);
		angle6.setRotationPoint(5.5F, 21.5F, 5.5F);
		angle6.setTextureSize(128, 64);
		angle6.mirror = true;
		setRotation(angle6, 0.2617994F, 1.570796F, 0F);
		leg5 = new ModelRenderer(this, 0, 18);
		leg5.addBox(0F, 0F, 0F, 2, 15, 2);
		leg5.setRotationPoint(5.5F, 9F, 5.5F);
		leg5.setTextureSize(128, 64);
		leg5.mirror = true;
		setRotation(leg5, 0F, 0F, 0F);
		leg6 = new ModelRenderer(this, 0, 18);
		leg6.addBox(0F, 0F, 0F, 2, 15, 2);
		leg6.setRotationPoint(5.5F, 9F, -7.5F);
		leg6.setTextureSize(128, 64);
		leg6.mirror = true;
		setRotation(leg6, 0F, 0F, 0F);
		anglef1 = new ModelRenderer(this, 6, 7);
		anglef1.addBox(0F, 0F, 0F, 3, 2, 1);
		anglef1.setRotationPoint(-5.5F, 22.5F, 6F);
		anglef1.setTextureSize(128, 64);
		anglef1.mirror = true;
		setRotation(anglef1, 0.2617994F, 0F, 0F);
		anglef2 = new ModelRenderer(this, 6, 7);
		anglef2.addBox(0F, 0F, 0F, 3, 2, 1);
		anglef2.setRotationPoint(2.5F, 22.5F, 6F);
		anglef2.setTextureSize(128, 64);
		anglef2.mirror = true;
		setRotation(anglef2, 0.2617994F, 0F, 0F);
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
		surface.renderWithRotation(f5);
		side1.render(f5);
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
		middle.render(f5);
		boxFrontPanelBottom.render(f5);
		handle2.render(f5);
		back2.render(f5);
		angle5.renderWithRotation(f5);
		angle6.renderWithRotation(f5);
		leg5.render(f5);
		leg6.render(f5);
		anglef1.renderWithRotation(f5);
		anglef2.renderWithRotation(f5);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
