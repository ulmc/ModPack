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

public class ModelWheel extends ModelBase implements SimpleUlmcModel {

	ModelRenderer Diagonal1;
	ModelRenderer Diagonal2;
	ModelRenderer Vertical;
	ModelRenderer Horizontal;
	ModelRenderer Part1;
	ModelRenderer Part2;
	ModelRenderer Part3;
	ModelRenderer Part4;
	ModelRenderer Part5;
	ModelRenderer Part6;
	ModelRenderer Part7;
	ModelRenderer Part8;
	ModelRenderer Part9;
	ModelRenderer Part10;
	ModelRenderer Part11;
	ModelRenderer Part12;

	public ModelWheel(float wheelShift) {
		textureWidth = 128;
		textureHeight = 64;

		Diagonal1 = new ModelRenderer(this, 1, 0);
		Diagonal1.addBox(0F, 0F, 0F, 1, 17, 1);
		Diagonal1.setRotationPoint(5.7F, 9.6F, wheelShift);
		Diagonal1.setTextureSize(128, 64);
		Diagonal1.mirror = true;
		setRotation(Diagonal1, 0F, 0F, 0.7941248F);
		Diagonal2 = new ModelRenderer(this, 0, 27);
		Diagonal2.addBox(0F, 0F, 0F, 17, 1, 1);
		Diagonal2.setRotationPoint(-5.6F, 9.6F, wheelShift);
		Diagonal2.setTextureSize(128, 64);
		Diagonal2.mirror = true;
		setRotation(Diagonal2, 0F, 0F, 0.7941248F);		
		Vertical = new ModelRenderer(this, 6, 0);
		Vertical.addBox(0F, 0F, 0F, 1, 14, 1);
		Vertical.setRotationPoint(-0.5F, 9F, wheelShift);
		Vertical.setTextureSize(128, 64);
		Vertical.mirror = true;
		setRotation(Vertical, 0F, 0F, 0F);
		Horizontal = new ModelRenderer(this, 0, 24);
		Horizontal.addBox(0F, 0F, 0F, 14, 1, 1);
		Horizontal.setRotationPoint(-7F, 15.5F, wheelShift);
		Horizontal.setTextureSize(128, 64);
		Horizontal.mirror = true;
		setRotation(Horizontal, 0F, 0F, 0F);
		Part1 = new ModelRenderer(this, 11, 0);
		Part1.addBox(0F, 0F, 0F, 4, 1, 1);
		Part1.setRotationPoint(-2F, 8F, wheelShift);
		Part1.setTextureSize(128, 64);
		Part1.mirror = true;
		setRotation(Part1, 0F, 0F, 0F);
		Part2 = new ModelRenderer(this, 22, 0);
		Part2.addBox(0F, 0F, 0F, 1, 4, 1);
		Part2.setRotationPoint(-2F, 8F, wheelShift);
		Part2.setTextureSize(128, 64);
		Part2.mirror = true;
		setRotation(Part2, 0F, 0F, 1.134464F);

		Part3 = new ModelRenderer(this, 11, 0);
		Part3.mirror = true;
		Part3.addBox(0F, 0F, 0F, 4, 1, 1);
		Part3.setRotationPoint(-8F, 14F, wheelShift);
		Part3.setTextureSize(128, 64);
		Part3.mirror = true;
		setRotation(Part3, 0F, 0F, -1.134464F);
		Part3.mirror = false;
		Part4 = new ModelRenderer(this, 22, 0);
		Part4.addBox(0F, 0F, 0F, 1, 4, 1);
		Part4.setRotationPoint(-8F, 14F, wheelShift);
		Part4.setTextureSize(128, 64);
		Part4.mirror = true;
		setRotation(Part4, 0F, 0F, 0F);
		Part5 = new ModelRenderer(this, 22, 0);
		Part5.addBox(0F, 0F, 0F, 1, 4, 1);
		Part5.setRotationPoint(-8F, 18F, wheelShift);
		Part5.setTextureSize(128, 64);
		Part5.mirror = true;
		setRotation(Part5, 0F, 0F, -0.4363323F);
		Part6 = new ModelRenderer(this, 11, 0);
		Part6.addBox(0F, 0F, 0F, 4, 1, 1);
		Part6.setRotationPoint(-2F, 24F, wheelShift);
		Part6.setTextureSize(128, 64);
		Part6.mirror = true;
		setRotation(Part6, 0F, 0F, -2.70526F);
		Part7 = new ModelRenderer(this, 11, 0);
		Part7.addBox(0F, 0F, 0F, 4, 1, 1);
		Part7.setRotationPoint(-2F, 23F, wheelShift);
		Part7.setTextureSize(128, 64);
		Part7.mirror = true;
		setRotation(Part7, 0F, 0F, 0F);
		Part8 = new ModelRenderer(this, 22, 0);
		Part8.addBox(0F, 0F, 0F, 1, 4, 1);
		Part8.setRotationPoint(2F, 24F, wheelShift);
		Part8.setTextureSize(128, 64);
		Part8.mirror = true;
		setRotation(Part8, 0F, 0F, -2.007129F);
		Part9 = new ModelRenderer(this, 11, 0);
		Part9.addBox(0F, 0F, 0F, 4, 1, 1);
		Part9.setRotationPoint(8F, 18F, wheelShift);
		Part9.setTextureSize(128, 64);
		Part9.mirror = true;
		setRotation(Part9, 0F, 0F, 2.007129F);
		Part10 = new ModelRenderer(this, 22, 0);
		Part10.addBox(0F, 0F, 0F, 1, 4, 1);
		Part10.setRotationPoint(7F, 14F, wheelShift);
		Part10.setTextureSize(128, 64);
		Part10.mirror = true;
		setRotation(Part10, 0F, 0F, 0F);
		Part11 = new ModelRenderer(this, 22, 0);
		Part11.addBox(0F, 0F, 0F, 1, 4, 1);
		Part11.setRotationPoint(8F, 14F, wheelShift);
		Part11.setTextureSize(128, 64);
		Part11.mirror = true;
		setRotation(Part11, 0F, 0F, 2.70526F);
		Part12 = new ModelRenderer(this, 11, 0);
		Part12.addBox(0F, 0F, 0F, 4, 1, 1);
		Part12.setRotationPoint(2F, 8F, wheelShift);
		Part12.setTextureSize(128, 64);
		Part12.mirror = true;
		setRotation(Part12, 0F, 0F, 0.4363323F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Diagonal1.render(f5);
		Diagonal2.render(f5);
		Vertical.render(f5);
		Horizontal.render(f5);
		Part1.render(f5);
		Part2.render(f5);
		Part3.render(f5);
		Part4.render(f5);
		Part5.render(f5);
		Part6.render(f5);
		Part7.render(f5);
		Part8.render(f5);
		Part9.render(f5);
		Part10.render(f5);
		Part11.render(f5);
		Part12.render(f5);
	}

	@Override
	public void render(float f5) {
		Diagonal1.render(f5);
		Diagonal2.render(f5);
		Vertical.render(f5);
		Horizontal.render(f5);
		Part1.render(f5);
		Part2.render(f5);
		Part3.render(f5);
		Part4.render(f5);
		Part5.render(f5);
		Part6.render(f5);
		Part7.render(f5);
		Part8.render(f5);
		Part9.render(f5);
		Part10.render(f5);
		Part11.render(f5);
		Part12.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
