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

public class ModelBarrel extends ModelBase {
	ModelRenderer tap1;
	ModelRenderer tap2;
	ModelRenderer standBackRight;
	ModelRenderer standFrontRight;
	ModelRenderer standFrontLeft;
	ModelRenderer standBackLeft;
	ModelRenderer standDownRight;
	ModelRenderer standUpRight;
	ModelRenderer standFrontDown;
	ModelRenderer standBackDown;
	ModelRenderer standDownLeft;
	ModelRenderer standUpLeft;
	ModelRenderer backMain;
	ModelRenderer backLeft1;
	ModelRenderer backLeft2;
	ModelRenderer backRight1;
	ModelRenderer backRight2;
	ModelRenderer frontMain;
	ModelRenderer frontLeft1;
	ModelRenderer frontLeft2;
	ModelRenderer frontRight1;
	ModelRenderer frontRight2;
	ModelRenderer extRightMiddle;
	ModelRenderer extLeftMiddle;
	ModelRenderer extDownMiddle;
	ModelRenderer extUpMiddle;
	ModelRenderer extDownLeft;
	ModelRenderer extDownRight;
	ModelRenderer extUpRight;
	ModelRenderer extUpLeft;
	ModelRenderer innUpMiddle;
	ModelRenderer innDownMiddle;
	ModelRenderer innRightMiddle;
	ModelRenderer innLeftMiddle;
	ModelRenderer innDownLeft;
	ModelRenderer innDownRight;
	ModelRenderer innUpLeft;
	ModelRenderer innUpRight;

	public ModelBarrel() {
		textureWidth = 128;
		textureHeight = 64;

		tap1 = new ModelRenderer(this, 98, 46);
		tap1.addBox(-1F, -2.2F, 1F, 2, 2, 1);
		tap1.setRotationPoint(0F, 16.5F, -9F);
		tap1.setTextureSize(128, 64);
		tap1.mirror = true;
		setRotation(tap1, 0F, 0F, 3.141593F);
		tap2 = new ModelRenderer(this, 104, 46);
		tap2.addBox(-0.5F, -1F, 0F, 1, 1, 2);
		tap2.setRotationPoint(0F, 17.5F, -9F);
		tap2.setTextureSize(128, 64);
		tap2.mirror = true;
		setRotation(tap2, 0F, 0F, 3.141593F);
		standBackRight = new ModelRenderer(this, 84, 31);
		standBackRight.addBox(-0.5F, -0.5F, -0.5F, 1, 16, 1);
		standBackRight.setRotationPoint(-7F, 9F, 7F);
		standBackRight.setTextureSize(128, 64);
		standBackRight.mirror = true;
		setRotation(standBackRight, 0F, 0F, 0F);
		standFrontRight = new ModelRenderer(this, 84, 31);
		standFrontRight.addBox(-0.5F, -0.5F, -0.5F, 1, 16, 1);
		standFrontRight.setRotationPoint(-7F, 9F, -7F);
		standFrontRight.setTextureSize(128, 64);
		standFrontRight.mirror = true;
		setRotation(standFrontRight, 0F, 0F, 0F);
		standFrontRight.mirror = false;
		standFrontLeft = new ModelRenderer(this, 84, 31);
		standFrontLeft.addBox(-0.5F, -0.5F, -0.5F, 1, 16, 1);
		standFrontLeft.setRotationPoint(7F, 9F, -7F);
		standFrontLeft.setTextureSize(128, 64);
		standFrontLeft.mirror = true;
		setRotation(standFrontLeft, 0F, 0F, 0F);
		standBackLeft = new ModelRenderer(this, 84, 31);
		standBackLeft.addBox(-0.5F, -0.5F, -0.5F, 1, 16, 1);
		standBackLeft.setRotationPoint(7F, 9F, 7F);
		standBackLeft.setTextureSize(128, 64);
		standBackLeft.mirror = true;
		setRotation(standBackLeft, 0F, 0F, 0F);
		standBackLeft.mirror = false;
		standDownRight = new ModelRenderer(this, 69, 35);
		standDownRight.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 13);
		standDownRight.setRotationPoint(-7F, 19F, -6F);
		standDownRight.setTextureSize(128, 64);
		standDownRight.mirror = true;
		setRotation(standDownRight, 0F, 0F, 0F);
		standUpRight = new ModelRenderer(this, 69, 35);
		standUpRight.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 13);
		standUpRight.setRotationPoint(-7F, 10F, -6F);
		standUpRight.setTextureSize(128, 64);
		standUpRight.mirror = true;
		setRotation(standUpRight, 0F, 0F, 0F);
		standFrontDown = new ModelRenderer(this, 68, 49);
		standFrontDown.addBox(-0.5F, -0.5F, -0.5F, 13, 1, 1);
		standFrontDown.setRotationPoint(-6F, 21F, -7F);
		standFrontDown.setTextureSize(128, 64);
		standFrontDown.mirror = true;
		setRotation(standFrontDown, 0F, 0F, 0F);
		standBackDown = new ModelRenderer(this, 68, 49);
		standBackDown.addBox(-0.5F, -0.5F, -0.5F, 13, 1, 1);
		standBackDown.setRotationPoint(-6F, 21F, 7F);
		standBackDown.setTextureSize(128, 64);
		standBackDown.mirror = true;
		setRotation(standBackDown, 0F, 0F, 0F);
		standBackDown.mirror = false;
		standDownLeft = new ModelRenderer(this, 69, 35);
		standDownLeft.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 13);
		standDownLeft.setRotationPoint(7F, 19F, -6F);
		standDownLeft.setTextureSize(128, 64);
		standDownLeft.mirror = true;
		setRotation(standDownLeft, 0F, 0F, 0F);
		standUpLeft = new ModelRenderer(this, 69, 35);
		standUpLeft.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 13);
		standUpLeft.setRotationPoint(7F, 10F, -6F);
		standUpLeft.setTextureSize(128, 64);
		standUpLeft.mirror = true;
		setRotation(standUpLeft, 0F, 0F, 0F);
		backMain = new ModelRenderer(this, 80, 4);
		backMain.addBox(0F, 0F, 0F, 6, 11, 0);
		backMain.setRotationPoint(-3F, 9F, 7.5F);
		backMain.setTextureSize(128, 64);
		backMain.mirror = true;
		setRotation(backMain, 0F, 0F, 0F);
		backLeft1 = new ModelRenderer(this, 78, 5);
		backLeft1.addBox(0F, 0F, 0F, 1, 9, 0);
		backLeft1.setRotationPoint(3F, 10F, 7.5F);
		backLeft1.setTextureSize(128, 64);
		backLeft1.mirror = true;
		setRotation(backLeft1, 0F, 0F, 0F);
		backLeft2 = new ModelRenderer(this, 76, 6);
		backLeft2.addBox(0F, 0F, 0F, 1, 7, 0);
		backLeft2.setRotationPoint(4F, 11F, 7.5F);
		backLeft2.setTextureSize(128, 64);
		backLeft2.mirror = true;
		setRotation(backLeft2, 0F, 0F, 0F);
		backRight1 = new ModelRenderer(this, 92, 5);
		backRight1.addBox(0F, 0F, 0F, 1, 9, 0);
		backRight1.setRotationPoint(-4F, 10F, 7.5F);
		backRight1.setTextureSize(128, 64);
		backRight1.mirror = true;
		setRotation(backRight1, 0F, 0F, 0F);
		backRight2 = new ModelRenderer(this, 94, 6);
		backRight2.addBox(0F, 0F, 0F, 1, 7, 0);
		backRight2.setRotationPoint(-5F, 11F, 7.5F);
		backRight2.setTextureSize(128, 64);
		backRight2.mirror = true;
		setRotation(backRight2, 0F, 0F, 0F);
		frontMain = new ModelRenderer(this, 80, 4);
		frontMain.addBox(0F, 0F, 0F, 6, 11, 0);
		frontMain.setRotationPoint(-3F, 9F, -7.5F);
		frontMain.setTextureSize(128, 64);
		frontMain.mirror = true;
		setRotation(frontMain, 0F, 0F, 0F);
		frontLeft1 = new ModelRenderer(this, 92, 5);
		frontLeft1.addBox(0F, 0F, 0F, 1, 9, 0);
		frontLeft1.setRotationPoint(3F, 10F, -7.5F);
		frontLeft1.setTextureSize(128, 64);
		frontLeft1.mirror = true;
		setRotation(frontLeft1, 0F, 0F, 0F);
		frontLeft2 = new ModelRenderer(this, 94, 6);
		frontLeft2.addBox(0F, 0F, 0F, 1, 7, 0);
		frontLeft2.setRotationPoint(4F, 11F, -7.5F);
		frontLeft2.setTextureSize(128, 64);
		frontLeft2.mirror = true;
		setRotation(frontLeft2, 0F, 0F, 0F);
		frontRight1 = new ModelRenderer(this, 78, 5);
		frontRight1.addBox(0F, 0F, 0F, 1, 9, 0);
		frontRight1.setRotationPoint(-4F, 10F, -7.5F);
		frontRight1.setTextureSize(128, 64);
		frontRight1.mirror = true;
		setRotation(frontRight1, 0F, 0F, 0F);
		frontRight2 = new ModelRenderer(this, 76, 6);
		frontRight2.addBox(0F, 0F, 0F, 1, 7, 0);
		frontRight2.setRotationPoint(-5F, 11F, -7.5F);
		frontRight2.setTextureSize(128, 64);
		frontRight2.mirror = true;
		setRotation(frontRight2, 0F, 0F, 0F);
		extRightMiddle = new ModelRenderer(this, 97, 31);
		extRightMiddle.addBox(-6.5F, -3F, 4.5F, 1, 6, 9);
		extRightMiddle.setRotationPoint(0F, 14.5F, -9F);
		extRightMiddle.setTextureSize(128, 64);
		extRightMiddle.mirror = true;
		setRotation(extRightMiddle, 0F, 0F, 0F);
		extLeftMiddle = new ModelRenderer(this, 97, 31);
		extLeftMiddle.addBox(-6.5F, -3F, 4.5F, 1, 6, 9);
		extLeftMiddle.setRotationPoint(0F, 14.5F, -9F);
		extLeftMiddle.setTextureSize(128, 64);
		extLeftMiddle.mirror = true;
		setRotation(extLeftMiddle, 0F, 0F, 3.141593F);
		extDownMiddle = new ModelRenderer(this, 50, 17);
		extDownMiddle.addBox(-3F, -6.5F, 4.5F, 6, 1, 9);
		extDownMiddle.setRotationPoint(0F, 14.5F, -9F);
		extDownMiddle.setTextureSize(128, 64);
		extDownMiddle.mirror = true;
		setRotation(extDownMiddle, 0F, 0F, 3.141593F);
		extUpMiddle = new ModelRenderer(this, 50, 17);
		extUpMiddle.addBox(-3F, -6.5F, 4.5F, 6, 1, 9);
		extUpMiddle.setRotationPoint(0F, 14.5F, -9F);
		extUpMiddle.setTextureSize(128, 64);
		extUpMiddle.mirror = true;
		setRotation(extUpMiddle, 0F, 0F, 0F);
		extDownLeft = new ModelRenderer(this, 97, 17);
		extDownLeft.addBox(-6.5F, -2.5F, 4.5F, 1, 5, 9);
		extDownLeft.setRotationPoint(0F, 14.5F, -9F);
		extDownLeft.setTextureSize(128, 64);
		extDownLeft.mirror = true;
		setRotation(extDownLeft, 0F, 0F, -2.356194F);
		extDownRight = new ModelRenderer(this, 97, 17);
		extDownRight.addBox(-6.5F, -2.5F, 4.5F, 1, 5, 9);
		extDownRight.setRotationPoint(0F, 14.5F, -9F);
		extDownRight.setTextureSize(128, 64);
		extDownRight.mirror = true;
		setRotation(extDownRight, 0F, 0F, -0.7853982F);
		extUpRight = new ModelRenderer(this, 97, 17);
		extUpRight.addBox(-6.5F, -2.5F, 4.5F, 1, 5, 9);
		extUpRight.setRotationPoint(0F, 14.5F, -9F);
		extUpRight.setTextureSize(128, 64);
		extUpRight.mirror = true;
		setRotation(extUpRight, 0F, 0F, 0.7853982F);
		extUpLeft = new ModelRenderer(this, 97, 17);
		extUpLeft.addBox(-6.5F, -2.5F, 4.5F, 1, 5, 9);
		extUpLeft.setRotationPoint(0F, 14.5F, -9F);
		extUpLeft.setTextureSize(128, 64);
		extUpLeft.mirror = true;
		setRotation(extUpLeft, 0F, 0F, 2.356194F);
		innUpMiddle = new ModelRenderer(this, 44, 0);
		innUpMiddle.addBox(-2.5F, -6F, 1F, 5, 1, 16);
		innUpMiddle.setRotationPoint(0F, 14.5F, -9F);
		innUpMiddle.setTextureSize(128, 64);
		innUpMiddle.mirror = true;
		setRotation(innUpMiddle, 0F, 0F, 0F);
		innDownMiddle = new ModelRenderer(this, 44, 0);
		innDownMiddle.addBox(-2.5F, -6F, 1F, 5, 1, 16);
		innDownMiddle.setRotationPoint(0F, 14.5F, -9F);
		innDownMiddle.setTextureSize(128, 64);
		innDownMiddle.mirror = true;
		setRotation(innDownMiddle, 0F, 0F, 3.149738F);
		innRightMiddle = new ModelRenderer(this, 48, 27);
		innRightMiddle.addBox(-6F, -2.5F, 1F, 1, 5, 16);
		innRightMiddle.setRotationPoint(0F, 14.5F, -9F);
		innRightMiddle.setTextureSize(128, 64);
		innRightMiddle.mirror = true;
		setRotation(innRightMiddle, 0F, 0F, 0F);
		innLeftMiddle = new ModelRenderer(this, 48, 27);
		innLeftMiddle.addBox(-6F, -2.5F, 1F, 1, 5, 16);
		innLeftMiddle.setRotationPoint(0F, 14.5F, -9F);
		innLeftMiddle.setTextureSize(128, 64);
		innLeftMiddle.mirror = true;
		setRotation(innLeftMiddle, 0F, 0F, 3.141593F);
		innDownLeft = new ModelRenderer(this, 86, 0);
		innDownLeft.addBox(-2.5F, -6.1F, 1F, 5, 1, 16);
		innDownLeft.setRotationPoint(0F, 14.5F, -9F);
		innDownLeft.setTextureSize(128, 64);
		innDownLeft.mirror = true;
		setRotation(innDownLeft, 0F, 0F, 2.356194F);
		innDownRight = new ModelRenderer(this, 86, 0);
		innDownRight.addBox(-2.5F, -6.1F, 1F, 5, 1, 16);
		innDownRight.setRotationPoint(0F, 14.5F, -9F);
		innDownRight.setTextureSize(128, 64);
		innDownRight.mirror = true;
		setRotation(innDownRight, 0F, 0F, -2.373648F);
		innUpLeft = new ModelRenderer(this, 86, 0);
		innUpLeft.addBox(-2.5F, -6.1F, 1F, 5, 1, 16);
		innUpLeft.setRotationPoint(0F, 14.5F, -9F);
		innUpLeft.setTextureSize(128, 64);
		innUpLeft.mirror = true;
		setRotation(innUpLeft, 0F, 0F, 0.7853982F);
		innUpRight = new ModelRenderer(this, 86, 0);
		innUpRight.addBox(-2.5F, -6.1F, 1F, 5, 1, 16);
		innUpRight.setRotationPoint(0F, 14.5F, -9F);
		innUpRight.setTextureSize(128, 64);
		innUpRight.mirror = true;
		setRotation(innUpRight, 0F, 0F, -0.7853982F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		render(f5);
	}

	public void render(float f5) {
		tap1.render(f5);
		tap2.render(f5);
		standBackRight.render(f5);
		standFrontRight.render(f5);
		standFrontLeft.render(f5);
		standBackLeft.render(f5);
		standDownRight.render(f5);
		standUpRight.render(f5);
		standFrontDown.render(f5);
		standBackDown.render(f5);
		standDownLeft.render(f5);
		standUpLeft.render(f5);
		backMain.render(f5);
		backLeft1.render(f5);
		backLeft2.render(f5);
		backRight1.render(f5);
		backRight2.render(f5);
		frontMain.render(f5);
		frontLeft1.render(f5);
		frontLeft2.render(f5);
		frontRight1.render(f5);
		frontRight2.render(f5);
		extRightMiddle.render(f5);
		extLeftMiddle.render(f5);
		extDownMiddle.render(f5);
		extUpMiddle.render(f5);
		extDownLeft.render(f5);
		extDownRight.render(f5);
		extUpRight.render(f5);
		extUpLeft.render(f5);
		innUpMiddle.render(f5);
		innDownMiddle.render(f5);
		innRightMiddle.render(f5);
		innLeftMiddle.render(f5);
		innDownLeft.render(f5);
		innDownRight.render(f5);
		innUpLeft.render(f5);
		innUpRight.render(f5);
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
