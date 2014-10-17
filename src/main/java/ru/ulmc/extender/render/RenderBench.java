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
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.block.BlockBench;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.render.model.connected.bench.*;

import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class RenderBench extends ConnectedRender implements ISimpleBlockRenderingHandler {
	private static Map<String, ResourceLocation> resources = new HashMap<String, ResourceLocation>();

	public RenderBench() {
		modelSingle = new ModelBench();
		modelOneConnection = new ModelBenchOneSided();
		modelCorner = new ModelBenchCorner();
		modelPathThrough = new ModelBenchDoubleSided();
		modelTriple = new ModelBenchTriple();
		modelCenter = new ModelBenchCross();
	}

	public static void registerResource(String name) {
		for (int i =0; i < 16; i++) {
			ResourceLocation resource = new ResourceLocation(Reference.RES_NAME_C, "textures/models/furniture/bench/" + name + "_" + i + ".png");
			resources.put(name+"_"+i, resource);
		}
	}

	public void renderModel(TileEntity tileEntity, double d, double d1, double d2, float f) {
		render(tileEntity, d, d1, d2, f);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2,
	                               double var4, double var6, float var8) {
		this.renderModel(tileEntity, var2, var4, var6, var8);
	}

	public void render(TileEntity tileEntity, double d, double d1, double d2, float f) {

		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		try {
			String name = tileEntity.blockType.getUnlocalizedName()+"_"+tileEntity.getBlockMetadata();
			if (resources.containsKey(name)) {
				bindTexture(resources.get(name));
			}
		} catch (Exception e) {
			UltimateExtender.logger.error(e.getMessage());
			e.printStackTrace();
		}
		renderConnectedModel(tileEntity);
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
		GL11.glScalef(1.3F, 1.3F, 1.3F);
		GL11.glTranslatef(0.0F, 1.1F, 0.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		//GL11.gl
		//modelSingle.render(0.0625F);
		modelSingle.render(0.0625F);
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
		return BlockManager.benchBlocksAcacia.getRenderType();
	}
}