/**
 * Copyright (C) 2014 Kolmogorov Alexey
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
package ru.ulmc.extender.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.render.model.ModelBonesEmpty;
import ru.ulmc.extender.render.model.ModelBonesFull;
import ru.ulmc.extender.render.model.ModelBonesM;
import ru.ulmc.extender.render.model.SimpleUlmcModel;

public class RenderBonesEntity extends Render {
	private ModelBonesM modelM = new ModelBonesM();
	private ModelBonesEmpty modelEmpty = new ModelBonesEmpty();
	private ModelBonesFull modelFull = new ModelBonesFull();

	private ResourceLocation resourceLocation = new ResourceLocation(Reference.RES_NAME_C, "textures/models/bonesFull.png");

	public RenderBonesEntity() {
	}

	public void renderModel(Entity tileEntityBones, double d, double d1, double d2, float f, float f1, SimpleUlmcModel aModel) {
		float deg = f1;
		UltimateExtender.logger.info("render:" + d + " " + d1 + " " + d2 + " " + f + " " + f1);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d, (float) d1, (float) d2);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		bindTexture(resourceLocation);

		//aModel.render(0.0625F);
		aModel.render(tileEntityBones, (float)d, (float)d1, (float)d2, f, f1, 0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		renderModel(entity, d0, d1, d2, f, f1, modelEmpty);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return resourceLocation;
	}

}