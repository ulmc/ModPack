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

public class ModelChair extends ModelBase {
	private ModelRenderer back2;
	private ModelRenderer back1;
	private ModelRenderer backStand1;
	private ModelRenderer backStand2;
	private ModelRenderer frontStand1;
	private ModelRenderer frontStand2;
	private ModelRenderer armrest1;
	private ModelRenderer armrest2;
	private ModelRenderer seat;
	private ModelRenderer seat2;

	public ModelChair() {
		textureWidth = 64;
		textureHeight = 32;

		back2 = new ModelRenderer(this, 23, 15);
		back2.addBox(-15F, 0.5F, 0.5F, 14, 3, 1);
		back2.setRotationPoint(8F, 7F, 6.5F);
		back2.setTextureSize(64, 32);
		back2.mirror = true;
		setRotation(back2, -0.1745329F, 0F, 0F);
		back1 = new ModelRenderer(this, 23, 15);
		back1.mirror = true;
		back1.addBox(-15F, 5F, 0.5F, 14, 3, 1);
		back1.setRotationPoint(8F, 7F, 6.5F);
		back1.setTextureSize(64, 32);
		back1.mirror = true;
		setRotation(back1, -0.1745329F, 0F, 0F);
		back1.mirror = false;
		backStand1 = new ModelRenderer(this, 0, 11);
		backStand1.mirror = true;
		backStand1.addBox(-0.5F, 0F, 0F, 2, 19, 2);
		backStand1.setRotationPoint(-7F, 6F, 6.5F);
		backStand1.setTextureSize(64, 32);
		backStand1.mirror = true;
		setRotation(backStand1, -0.1745329F, 0F, 0F);
		backStand1.mirror = false;
		backStand2 = new ModelRenderer(this, 0, 11);
		backStand2.addBox(-1.5F, 0F, 0F, 2, 19, 2);
		backStand2.setRotationPoint(7F, 6F, 6.5F);
		backStand2.setTextureSize(64, 32);
		backStand2.mirror = true;
		setRotation(backStand2, -0.1745329F, 0F, 0F);
		frontStand1 = new ModelRenderer(this, 56, 16);
		frontStand1.mirror = true;
		frontStand1.addBox(-1.5F, 0.5F, -0.5F, 2, 13, 2);
		frontStand1.setRotationPoint(-6F, 11F, -7.5F);
		frontStand1.setTextureSize(64, 32);
		frontStand1.mirror = true;
		setRotation(frontStand1, 0.1745329F, 0F, 0F);
		frontStand1.mirror = false;
		frontStand2 = new ModelRenderer(this, 56, 16);
		frontStand2.addBox(-1.5F, 0.5F, -0.5F, 2, 13, 2);
		frontStand2.setRotationPoint(7F, 11F, -7.5F);
		frontStand2.setTextureSize(64, 32);
		frontStand2.mirror = true;
		setRotation(frontStand2, 0.1745329F, 0F, 0F);
		armrest1 = new ModelRenderer(this, 27, 2);
		armrest1.mirror = true;
		armrest1.addBox(-7F, -4F, -4.5F, 1, 1, 12);
		armrest1.setRotationPoint(0F, 16F, -1.5F);
		armrest1.setTextureSize(64, 32);
		armrest1.mirror = true;
		setRotation(armrest1, 0F, 0F, 0F);
		armrest1.mirror = false;
		armrest2 = new ModelRenderer(this, 27, 2);
		armrest2.addBox(6F, -4F, -4.5F, 1, 1, 12);
		armrest2.setRotationPoint(0F, 16F, -1.5F);
		armrest2.setTextureSize(64, 32);
		armrest2.mirror = true;
		setRotation(armrest2, 0F, 0F, 0F);
		seat = new ModelRenderer(this, 12, 19);
		seat.addBox(-7F, 0F, -5F, 14, 1, 12);
		seat.setRotationPoint(0F, 16F, -1.5F);
		seat.setTextureSize(64, 32);
		seat.mirror = true;
		setRotation(seat, 0F, 0F, 0F);
		seat2 = new ModelRenderer(this, 0, 0);
		seat2.addBox(-5F, 0F, -3F, 10, 1, 9);
		seat2.setRotationPoint(0F, 15.5F, -1.5F);
		seat2.setTextureSize(64, 32);
		seat2.mirror = true;
		setRotation(seat2, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		render(f5);
	}

	public void render(float f5) {
		back2.render(f5);
		back1.render(f5);
		backStand1.render(f5);
		backStand2.render(f5);
		frontStand1.render(f5);
		frontStand2.render(f5);
		armrest1.render(f5);
		armrest2.render(f5);
		seat.render(f5);
		seat2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
  /*
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }
*/
}
