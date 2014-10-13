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

public class ModelBonesFull extends ModelBase implements SimpleUlmcModel {
	private ModelRenderer head;
	private ModelRenderer hand1;
	private ModelRenderer hand2;
	private ModelRenderer chest;
	private ModelRenderer spin;
	private ModelRenderer leg1;
	private ModelRenderer blade;
	private ModelRenderer cross;
	private ModelRenderer middle;
	private ModelRenderer leg2;
	private ModelRenderer coif;

	public ModelBonesFull() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -4F, -3.4F, 8, 8, 8);
		head.setRotationPoint(-1.7F, 12F, 2F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0743572F, -0.3346075F, 0F);
		hand1 = new ModelRenderer(this, 0, 16);
		hand1.addBox(-1F, -1F, -1F, 2, 8, 2);
		hand1.setRotationPoint(-5F, 17.5F, 1.5F);
		hand1.setTextureSize(64, 32);
		hand1.mirror = true;
		setRotation(hand1, 0F, -0.6320364F, 0.1115358F);
		hand2 = new ModelRenderer(this, 0, 16);
		hand2.mirror = true;
		hand2.addBox(-1F, -1.9F, -1F, 2, 8, 2);
		hand2.setRotationPoint(2.6F, 22.4F, 3F);
		hand2.setTextureSize(64, 32);
		hand2.mirror = true;
		setRotation(hand2, -2.93711F, 1.691627F, 0F);
		hand2.mirror = false;
		chest = new ModelRenderer(this, 32, 0);
		chest.addBox(-2.5F, 2F, -1F, 5, 10, 4);
		chest.setRotationPoint(-1.7F, 12F, 2F);
		chest.setTextureSize(64, 32);
		chest.mirror = true;
		setRotation(chest, -0.1115358F, -0.3316126F, 0F);
		spin = new ModelRenderer(this, 17, 15);
		spin.addBox(-1F, 2F, 2.6F, 2, 10, 1);
		spin.setRotationPoint(-1.7F, 12F, 2F);
		spin.setTextureSize(64, 32);
		spin.mirror = true;
		setRotation(spin, -0.1115358F, -0.3316126F, 0F);
		blade = new ModelRenderer(this, 56, 15);
		blade.addBox(-0.5F, -2.5F, -0.5F, 1, 7, 1);
		blade.setRotationPoint(1F, 20F, -4F);
		blade.setTextureSize(64, 32);
		blade.mirror = true;
		setRotation(blade, -0.3346075F, 1.673038F, -0.1487144F);
		cross = new ModelRenderer(this, 52, 9);
		cross.addBox(-0.5F, 0.5F, -2.5F, 1, 1, 5);
		cross.setRotationPoint(1F, 20F, -4F);
		cross.setTextureSize(64, 32);
		cross.mirror = true;
		setRotation(cross, -0.3346075F, 1.673038F, -0.1487144F);
		middle = new ModelRenderer(this, 55, 5);
		middle.addBox(-0.4F, -0.1F, -1.9F, 1, 2, 2);
		middle.setRotationPoint(1F, 20F, -4F);
		middle.setTextureSize(64, 32);
		middle.mirror = true;
		setRotation(middle, 0.4625123F, 1.623156F, -0.1396263F);
		coif = new ModelRenderer(this, 25, 14);
		coif.addBox(-4.5F, -4.5F, -4.2F, 9, 9, 9);
		coif.setRotationPoint(-1.7F, 12F, 2F);
		coif.setTextureSize(64, 32);
		coif.mirror = true;
		setRotation(coif, 0.0743572F, -0.3346075F, 0F);
		leg1 = new ModelRenderer(this, 0, 16);
		leg1.addBox(0F, 0F, 0F, 2, 8, 2);
		leg1.setRotationPoint(4F, 23F, 1F);
		leg1.setTextureSize(64, 32);
		leg1.mirror = true;
		setRotation(leg1, -1.59868F, 0.2788396F, 0.1487144F);
		leg2 = new ModelRenderer(this, 0, 16);
		leg2.addBox(0F, 0F, 0F, 2, 8, 2);
		leg2.setRotationPoint(-7F, 21F, -2F);
		leg2.setTextureSize(64, 32);
		leg2.mirror = true;
		setRotation(leg2, -1.447694F, -0.8562441F, 0.2321598F);
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
		chest.render(f5);
		spin.render(f5);
		leg1.render(f5);
		blade.render(f5);
		cross.render(f5);
		middle.render(f5);
		leg2.render(f5);
		coif.render(f5);
	}
}
