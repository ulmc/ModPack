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
package ru.ulmc.extender.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.render.model.ModelBonesEmpty;
import ru.ulmc.extender.render.model.ModelBonesFull;
import ru.ulmc.extender.render.model.ModelBonesM;
import ru.ulmc.extender.render.model.SimpleUlmcModel;
import ru.ulmc.extender.tileentity.TileEntityBones;

public class RenderBones extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {
	private static final ResourceLocation resource = new ResourceLocation(Reference.RES_NAME_C, "textures/models/bonesFull.png");
	private ModelBonesM modelM = new ModelBonesM();
	private ModelBonesEmpty modelEmpty = new ModelBonesEmpty();
	private ModelBonesFull modelFull = new ModelBonesFull();

	public RenderBones() {
	}

	public void renderModel(TileEntityBones tileEntityBones, double d, double d1, double d2, float f, SimpleUlmcModel aModel) {
		int i = tileEntityBones.getBlockMetadata();
		float deg = 0f;

		if (i == 3) {
			deg = 90f;
		} else if (i == 2) {
			deg = 180f;
		} else if (i == 1) {
			deg = 270f;
		}
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		bindTexture(resource);

		aModel.render(0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2, double var4, double var6, float var8) {
		TileEntityBones bonesTE = (TileEntityBones) tileEntity;
		switch (bonesTE.getState()) {
			case 0:
				renderModel(bonesTE, var2, var4, var6, var8, modelEmpty);
				break;
			case 1:
				renderModel(bonesTE, var2, var4, var6, var8, modelM);
				break;
			case 2:
				renderModel(bonesTE, var2, var4, var6, var8, modelFull);
				break;
		}

	}
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		bindTexture(resource);
		//GL11.glPushMatrix();
		GL11.glScalef(1.25F, 1.25F, 1.25F);
		GL11.glTranslatef(0.1F, 1.2F, 0.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		//GL11.gl
		//modelSingle.render(0.0625F);
		modelEmpty.render(0.0625F);
		//GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return BlockManager.blockBones.getRenderType();
	}

}