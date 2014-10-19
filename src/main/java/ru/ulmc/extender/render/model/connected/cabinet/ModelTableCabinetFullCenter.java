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

public class ModelTableCabinetFullCenter extends ModelBase implements SimpleUlmcModel {
	// fields

	ModelRenderer surface;
	ModelRenderer back;
	ModelRenderer rim2;
	ModelRenderer rim6;

	public ModelTableCabinetFullCenter() {
		textureWidth = 128;
		textureHeight = 64;

		surface = new ModelRenderer(this, 0, 47);
		surface.addBox(-8F, -1F, -8F, 16, 1, 16);
		surface.setRotationPoint(0F, 9F, 0F);
		surface.setTextureSize(128, 64);
		surface.mirror = true;
		setRotation(surface, 0F, 0F, 0F);
		back = new ModelRenderer(this, 48, 38);
		back.addBox(0F, 0F, 0F, 16, 9, 1);
		back.setRotationPoint(-8F, 9F, -7.1F);
		back.setTextureSize(128, 64);
		back.mirror = true;
		setRotation(back, 0F, 0F, 0F);
		rim2 = new ModelRenderer(this, 0, 0);
		rim2.addBox(0F, -8F, 0F, 1, 16, 1);
		rim2.setRotationPoint(0F, 17F, -7.5F);
		rim2.setTextureSize(128, 64);
		rim2.mirror = true;
		setRotation(rim2, 0F, 0F, 1.570796F);
		rim6 = new ModelRenderer(this, 0, 0);
		rim6.addBox(0F, -8F, 0F, 1, 16, 1);
		rim6.setRotationPoint(0F, 9F, -7.5F);
		rim6.setTextureSize(128, 64);
		rim6.mirror = true;
		setRotation(rim6, 0F, 0F, 1.570796F);
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
		rim2.render(f5);
		rim6.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
