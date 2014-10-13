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

public class ModelBonesEmpty extends ModelBase implements SimpleUlmcModel {
	// fields
	private ModelRenderer head;
	private ModelRenderer hand1;
	private ModelRenderer hand2;
	private ModelRenderer fin1;
	private ModelRenderer fin2;
	private ModelRenderer fin3;

	public ModelBonesEmpty() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -4F, -3.4F, 8, 8, 8);
		head.setRotationPoint(-1.7F, 21F, 2F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0743572F, -0.3346075F, 0F);
		hand1 = new ModelRenderer(this, 0, 16);
		hand1.addBox(0F, 0F, 0F, 2, 7, 2);
		hand1.setRotationPoint(-1F, 23.5F, -7.5F);
		hand1.setTextureSize(64, 32);
		hand1.mirror = true;
		setRotation(hand1, 0.1487144F, 0.4078287F, 1.747395F);
		hand2 = new ModelRenderer(this, 0, 16);
		hand2.mirror = true;
		hand2.addBox(0F, 0F, 0F, 2, 7, 2);
		hand2.setRotationPoint(6F, 24F, -1F);
		hand2.setTextureSize(64, 32);
		hand2.mirror = true;
		setRotation(hand2, -1.970466F, 0.7993401F, 0F);
		hand2.mirror = false;
		fin1 = new ModelRenderer(this, 8, 17);
		fin1.addBox(0F, 0F, 0F, 1, 1, 3);
		fin1.setRotationPoint(2F, 24.5F, 7F);
		fin1.setTextureSize(64, 32);
		fin1.mirror = true;
		setRotation(fin1, 0.669215F, 2.41661F, -0.4833219F);
		fin2 = new ModelRenderer(this, 8, 21);
		fin2.addBox(0F, 0F, 0F, 1, 1, 3);
		fin2.setRotationPoint(4F, 24.3F, 1F);
		fin2.setTextureSize(64, 32);
		fin2.mirror = true;
		setRotation(fin2, 0.4833219F, 0.0371786F, -0.1115358F);
		fin3 = new ModelRenderer(this, 8, 21);
		fin3.mirror = true;
		fin3.addBox(0F, 0F, 0F, 1, 1, 3);
		fin3.setRotationPoint(6.5F, 24.4F, 7.5F);
		fin3.setTextureSize(64, 32);
		fin3.mirror = true;
		setRotation(fin3, 0.5948578F, -2.583914F, -0.5576792F);
		fin3.mirror = false;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
	                   float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void render(float f5) {
		head.render(f5);
		hand1.render(f5);
		hand2.render(f5);
		fin1.render(f5);
		fin2.render(f5);
		fin3.render(f5);
	}

}
