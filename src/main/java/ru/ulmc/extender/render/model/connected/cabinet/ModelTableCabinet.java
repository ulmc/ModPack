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

public class ModelTableCabinet extends ModelBase implements SimpleUlmcModel {
	// fields
	ModelRenderer surface;
	ModelRenderer side1;
	ModelRenderer side2;
	ModelRenderer back;
	ModelRenderer subLeg;
	ModelRenderer subleg1;
	ModelRenderer subleg2;
	ModelRenderer subleg3;
	ModelRenderer boxdownFace;
	ModelRenderer boxFrontPanel;
	ModelRenderer angle1;
	ModelRenderer angle2;
	ModelRenderer angle3;
	ModelRenderer angle4;
	ModelRenderer rim1;
	ModelRenderer rim2;
	ModelRenderer rim3;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer rim4;
	ModelRenderer rim5;
	ModelRenderer rim6;
	ModelRenderer handle;

	public ModelTableCabinet() {
		textureWidth = 128;
		textureHeight = 64;

		surface = new ModelRenderer(this, 0, 0);
		surface.addBox(-8F, 0F, -8F, 16, 1, 16);
		surface.setRotationPoint(0F, 8F, 0F);
		surface.setTextureSize(128, 64);
		surface.mirror = true;
		setRotation(surface, 0F, 0F, 0F);
		side1 = new ModelRenderer(this, 33, 18);
		side1.addBox(-6F, 0F, 0F, 14, 14, 1);
		side1.setRotationPoint(-7F, 9F, 1F);
		side1.setTextureSize(128, 64);
		side1.mirror = true;
		setRotation(side1, 0F, 1.570796F, 0F);
		side2 = new ModelRenderer(this, 33, 18);
		side2.addBox(-7F, 0F, 0F, 14, 14, 1);
		side2.setRotationPoint(6F, 9F, 0F);
		side2.setTextureSize(128, 64);
		side2.mirror = true;
		setRotation(side2, 0F, 1.58825F, 0F);
		back = new ModelRenderer(this, 51, -1);
		back.addBox(0F, 0F, 0F, 12, 9, 1);
		back.setRotationPoint(-6F, 9F, -7.1F);
		back.setTextureSize(128, 64);
		back.mirror = true;
		setRotation(back, 0F, 0F, 0F);
		subLeg = new ModelRenderer(this, 6, 2);
		subLeg.addBox(0F, 0F, 0F, 3, 1, 1);
		subLeg.setRotationPoint(6F, 23F, 6F);
		subLeg.setTextureSize(128, 64);
		subLeg.mirror = true;
		setRotation(subLeg, 0F, 1.570796F, 0F);
		subleg1 = new ModelRenderer(this, 6, 2);
		subleg1.addBox(0F, 0F, 0F, 3, 1, 1);
		subleg1.setRotationPoint(6F, 23F, -3F);
		subleg1.setTextureSize(128, 64);
		subleg1.mirror = true;
		setRotation(subleg1, 0F, 1.570796F, 0F);
		subleg2 = new ModelRenderer(this, 6, 2);
		subleg2.addBox(0F, 0F, 0F, 3, 1, 1);
		subleg2.setRotationPoint(-7F, 23F, 6F);
		subleg2.setTextureSize(128, 64);
		subleg2.mirror = true;
		setRotation(subleg2, 0F, 1.570796F, 0F);
		subleg3 = new ModelRenderer(this, 6, 2);
		subleg3.addBox(0F, 0F, 0F, 3, 1, 1);
		subleg3.setRotationPoint(-7F, 23F, -3F);
		subleg3.setTextureSize(128, 64);
		subleg3.mirror = true;
		setRotation(subleg3, 0F, 1.570796F, 0F);
		boxdownFace = new ModelRenderer(this, 8, 18);
		boxdownFace.addBox(0F, 0F, 0F, 12, 14, 1);
		boxdownFace.setRotationPoint(-6F, 13F, -7F);
		boxdownFace.setTextureSize(128, 64);
		boxdownFace.mirror = true;
		setRotation(boxdownFace, 1.570796F, 0F, 0F);
		boxFrontPanel = new ModelRenderer(this, -11, 36);
		boxFrontPanel.addBox(-5.5F, -1F, 0F, 11, 4, 0);
		boxFrontPanel.setRotationPoint(0F, 10F, 7.1F);
		boxFrontPanel.setTextureSize(128, 64);
		boxFrontPanel.mirror = true;
		setRotation(boxFrontPanel, 0F, 0F, 0F);
		angle1 = new ModelRenderer(this, 6, 7);
		angle1.addBox(0F, 0F, 0F, 3, 3, 1);
		angle1.setRotationPoint(6F, 21.5F, 5.5F);
		angle1.setTextureSize(128, 64);
		angle1.mirror = true;
		setRotation(angle1, 0.2617994F, 1.570796F, 0F);
		angle2 = new ModelRenderer(this, 6, 7);
		angle2.addBox(0F, 0F, 0F, 3, 3, 1);
		angle2.setRotationPoint(6F, 21.5F, -2.5F);
		angle2.setTextureSize(128, 64);
		angle2.mirror = true;
		setRotation(angle2, 0.2617994F, 1.570796F, 0F);
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
		rim2.addBox(0F, 0F, 0F, 1, 11, 1);
		rim2.setRotationPoint(5.5F, 17F, -7.5F);
		rim2.setTextureSize(128, 64);
		rim2.mirror = true;
		setRotation(rim2, 0F, 0F, 1.570796F);
		rim3 = new ModelRenderer(this, 0, 0);
		rim3.addBox(0F, -7F, 0F, 1, 11, 1);
		rim3.setRotationPoint(6.5F, 9F, 1.5F);
		rim3.setTextureSize(128, 64);
		rim3.mirror = true;
		setRotation(rim3, 0F, 1.570796F, 1.570796F);
		leg1 = new ModelRenderer(this, 0, 18);
		leg1.addBox(0F, 0F, 0F, 2, 15, 2);
		leg1.setRotationPoint(5.5F, 9F, -7.5F);
		leg1.setTextureSize(128, 64);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
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
		leg4 = new ModelRenderer(this, 0, 18);
		leg4.addBox(0F, 0F, 0F, 2, 15, 2);
		leg4.setRotationPoint(5.5F, 9F, 5.5F);
		leg4.setTextureSize(128, 64);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		rim4 = new ModelRenderer(this, 0, 0);
		rim4.addBox(0F, 0F, 0F, 1, 11, 1);
		rim4.setRotationPoint(6.5F, 18F, -5.5F);
		rim4.setTextureSize(128, 64);
		rim4.mirror = true;
		setRotation(rim4, 1.570796F, 0F, 0F);
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
		side1.render(f5);
		side2.render(f5);
		back.render(f5);
		subLeg.render(f5);
		subleg1.render(f5);
		subleg2.render(f5);
		subleg3.render(f5);
		boxdownFace.render(f5);
		boxFrontPanel.render(f5);
		angle1.renderWithRotation(f5);
		angle2.renderWithRotation(f5);
		angle3.renderWithRotation(f5);
		angle4.renderWithRotation(f5);
		rim1.renderWithRotation(f5);
		rim2.renderWithRotation(f5);
		rim3.renderWithRotation(f5);
		rim4.renderWithRotation(f5);
		rim5.renderWithRotation(f5);
		rim6.renderWithRotation(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		handle.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
