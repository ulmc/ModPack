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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.render.model.ModelChair;
import ru.ulmc.extender.render.model.ModelEliteChair;
import ru.ulmc.extender.tileentity.TileEntityChair;
import ru.ulmc.extender.tileentity.TileEntityEliteChair;

import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class RenderChairs extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {
	private static Map<String, ResourceLocation> resources = new HashMap<String, ResourceLocation>();
	private ModelChair modelChair;

	public RenderChairs() {
		modelChair = new ModelChair();
	}

	public static void registerResource(String name) {
		if(name.contains("Original")) {
			ResourceLocation resource = new ResourceLocation(Reference.RES_NAME_C, "textures/models/furniture/chairs/" + name + ".png");
			resources.put(name, resource);
		} else {
			for (int i =0; i < 16; i++) {
				ResourceLocation resource = new ResourceLocation(Reference.RES_NAME_C, "textures/models/furniture/chairs/" + name + "_" + i + ".png");
				resources.put(name+"_"+i, resource);
			}
		}
	}

	public void renderModel(TileEntity tileEntity, double d, double d1,
	                        double d2, float f) {
		renderChairs(tileEntity, d, d1, d2, f);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2,
	                               double var4, double var6, float var8) {
		this.renderModel(tileEntity, var2, var4, var6, var8);
	}

	public void renderChairs(TileEntity tileEntity, double d, double d1,
	                         double d2, float f) {
		int i = ((TileEntityChair)tileEntity).getRotation();

		float deg = i * 90F;

		GL11.glPushMatrix();

		try {
			String name = tileEntity.getBlockType().getUnlocalizedName().concat("_"+tileEntity.getBlockMetadata());
			bindTexture(resources.get(name));
		} catch (Exception e) {
			UltimateExtender.logger.error(e.getMessage());
			e.printStackTrace();
		}
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,
				(float) d2 + 0.5F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		modelChair.render(0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		try {
			String name = block.getUnlocalizedName().concat("_"+metadata);
			bindTexture(resources.get(name));
		} catch (Exception e) {
			UltimateExtender.logger.error(e.getMessage());
			e.printStackTrace();
		}
		//GL11.glPushMatrix();
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glTranslatef(0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		//GL11.gl
		//modelSingle.render(0.0625F);
		modelChair.render(0.0625F);
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
		return BlockManager.chairBlocksAcaciaColor.getRenderType();
	}
}