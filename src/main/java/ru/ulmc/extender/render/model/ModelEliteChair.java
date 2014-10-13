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
	private ModelRenderer back1;
	private ModelRenderer back2;
	private ModelRenderer hand11;
	private ModelRenderer hand12;
	private ModelRenderer hand13;
	private ModelRenderer hand14;
	private ModelRenderer hand21;
	private ModelRenderer hand22;
	private ModelRenderer hand23;
	private ModelRenderer hand24;
	private ModelRenderer seat;
	private ModelRenderer step;

	public ModelEliteChair() {
		textureWidth = 128;
		textureHeight = 64;

		back1 = new ModelRenderer(this, 24, 32);
		back1.addBox(-6.5F, 0F, -1F, 13, 13, 3);
		back1.setRotationPoint(0F, 11F, 6.1F);
		back1.setTextureSize(128, 64);
		back1.mirror = true;
		setRotation(back1, -0.122173F, 0F, 0F);
		back2 = new ModelRenderer(this, 64, 9);
		back2.addBox(-4.5F, 0F, -1F, 9, 20, 2);
		back2.setRotationPoint(0F, 4F, 7.8F);
		back2.setTextureSize(128, 64);
		back2.mirror = true;
		setRotation(back2, -0.0872665F, 0F, 0F);
		hand11 = new ModelRenderer(this, 0, 0);
		hand11.mirror = true;
		hand11.addBox(-7.8F, 9F, -14F, 3, 10, 2);
		hand11.setRotationPoint(0F, 4F, 7.8F);
		hand11.setTextureSize(128, 64);
		hand11.mirror = true;
		setRotation(hand11, 0.0872665F, 0F, 0F);
		hand11.mirror = false;
		hand12 = new ModelRenderer(this, 0, 32);
		hand12.mirror = true;
		hand12.addBox(-0.4666667F, -0.5F, -0.5F, 1, 1, 11);
		hand12.setRotationPoint(-6.2F, 14.8F, -4F);
		hand12.setTextureSize(128, 64);
		hand12.mirror = true;
		setRotation(hand12, -0.0174533F, -0.0959931F, 0F);
		hand12.mirror = false;
		hand13 = new ModelRenderer(this, 22, 20);
		hand13.mirror = true;
		hand13.addBox(-7.8F, 10F, -1F, 2, 10, 2);
		hand13.setRotationPoint(0F, 4F, 7.8F);
		hand13.setTextureSize(128, 64);
		hand13.mirror = true;
		setRotation(hand13, -0.0872665F, 0F, 0F);
		hand13.mirror = false;
		hand14 = new ModelRenderer(this, 0, 14);
		hand14.mirror = true;
		hand14.addBox(1F, 0F, 0F, 2, 9, 9);
		hand14.setRotationPoint(-7F, 16.5F, -3F);
		hand14.setTextureSize(128, 64);
		hand14.mirror = true;
		setRotation(hand14, 0F, 0F, 0F);
		hand14.mirror = false;
		hand21 = new ModelRenderer(this, 0, 0);
		hand21.addBox(4.8F, 9F, -14F, 3, 10, 2);
		hand21.setRotationPoint(0F, 4F, 7.8F);
		hand21.setTextureSize(128, 64);
		hand21.mirror = true;
		setRotation(hand21, 0.0872665F, 0F, 0F);
		hand22 = new ModelRenderer(this, 0, 32);
		hand22.addBox(-0.4666667F, -0.5F, -0.5F, 1, 1, 11);
		hand22.setRotationPoint(6.2F, 14.8F, -4F);
		hand22.setTextureSize(128, 64);
		hand22.mirror = true;
		setRotation(hand22, -0.0174533F, 0.0959931F, 0F);
		hand23 = new ModelRenderer(this, 22, 20);
		hand23.addBox(5.8F, 10F, -1F, 2, 10, 2);
		hand23.setRotationPoint(0F, 4F, 7.8F);
		hand23.setTextureSize(128, 64);
		hand23.mirror = true;
		setRotation(hand23, -0.0872665F, 0F, 0F);
		hand24 = new ModelRenderer(this, 0, 14);
		hand24.addBox(1F, 0F, 0F, 2, 9, 9);
		hand24.setRotationPoint(3F, 16.5F, -3F);
		hand24.setTextureSize(128, 64);
		hand24.mirror = true;
		setRotation(hand24, 0F, 0F, 0F);
		seat = new ModelRenderer(this, 30, 9);
		seat.addBox(1.5F, 0F, 0F, 9, 7, 8);
		seat.setRotationPoint(-6F, 18F, -2.3F);
		seat.setTextureSize(128, 64);
		seat.mirror = true;
		setRotation(seat, 0F, 0F, 0F);
		step = new ModelRenderer(this, 36, 24);
		step.addBox(0F, 0F, 0F, 9, 3, 5);
		step.setRotationPoint(-4.5F, 21F, -7F);
		step.setTextureSize(128, 64);
		step.mirror = true;
		setRotation(step, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
	                   float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		render(f5);
	}

	public void render(float f5) {
		back1.render(f5);
		back2.render(f5);
		hand11.render(f5);
		hand12.render(f5);
		hand13.render(f5);
		hand14.render(f5);
		hand21.render(f5);
		hand22.render(f5);
		hand23.render(f5);
		hand24.render(f5);
		seat.render(f5);
		step.render(f5);
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
