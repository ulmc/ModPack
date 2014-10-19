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
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.block.BlockTable;
import ru.ulmc.extender.render.model.ModelTable;
import ru.ulmc.extender.render.model.connected.cabinet.ModelTableCabinet;
import ru.ulmc.extender.render.model.ModelTableDinner;
import ru.ulmc.extender.render.model.SimpleUlmcModel;
import ru.ulmc.extender.tileentity.TileEntityTable;

import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class RenderTables extends TileEntitySpecialRenderer {
	private static ModelTable modelTable = new ModelTable();
	private static ModelTableCabinet modelCabinetTable = new ModelTableCabinet();
	private static ModelTableDinner modelTableDinner = new ModelTableDinner();
	private static Map<String, ResourceLocation> resources = new HashMap<String, ResourceLocation>();
	private CabinetTableRender cabinetRender = new CabinetTableRender(this);

	public static Map<String, ResourceLocation> getResources() {
		return resources;
	}

	public static void registerResource(String name) {
		for( int i = 0; i < BlockTable.subBlocks.length; i++) {
			String fullname = name + BlockTable.subBlocks[i];
			ResourceLocation resource = new ResourceLocation(Reference.RES_NAME_C,
					"textures/models/furniture/" + fullname + ".png");
			resources.put(fullname, resource);
		}
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2, double var4, double var6, float var8) {
		TileEntityTable tableTE = (TileEntityTable) tileEntity;

		if(tableTE.getModel() == BlockTable.MODEL_BAR ) {
			doRender(tableTE, var2, var4, var6, var8, modelTable);
		} else if(tableTE.getModel() == BlockTable.MODEL_CABINET) {
			cabinetRender.renderTileEntityAt(tileEntity, var2, var4, var6, var8);
		} else if(tableTE.getModel() == BlockTable.MODEL_DINNER) {
			doRender(tableTE, var2, var4, var6, var8, modelTableDinner);
		}

	}

	public void bindTexture(ResourceLocation loc, boolean nothingHere) {
		bindTexture(loc);
	}

	public void doRender(TileEntityTable tileEntity, double d, double d1,double d2, float f, SimpleUlmcModel model) {

		float deg = tileEntity.getRotation() * 90F;
		String fullname = tileEntity.blockType.getUnlocalizedName() + BlockTable.subBlocks[tileEntity.getBlockMetadata()%BlockTable.subBlocks.length];
		GL11.glPushMatrix();

		try {
			bindTexture(resources.get(fullname));
		} catch (Exception e) {
			UltimateExtender.logger.error(e.getMessage());
			e.printStackTrace();
		}
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		model.render(0.0625F);
		GL11.glPopMatrix();
	}

	public final ISimpleBlockRenderingHandler barTableInventoryRender = new ISimpleBlockRenderingHandler() {
		@Override
		public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
			String fullname = block.getUnlocalizedName().concat(BlockTable.subBlocks[metadata%BlockTable.subBlocks.length]);
			bindTexture(resources.get(fullname));
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			modelTable.render(0.0625F);
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
			return BlockTable.MODEL_BAR_REG;
		}
	};

	public final ISimpleBlockRenderingHandler cabinetTableInventoryRender = new ISimpleBlockRenderingHandler() {
		@Override
		public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
			String fullname = block.getUnlocalizedName().concat(BlockTable.subBlocks[metadata%BlockTable.subBlocks.length]);
			bindTexture(resources.get(fullname));
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			modelCabinetTable.render(0.0625F);
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
			return BlockTable.MODEL_CABINET_REG;
		}
	};

	public final ISimpleBlockRenderingHandler dinnerTableInventoryRender = new ISimpleBlockRenderingHandler() {
		@Override
		public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
			String fullname = block.getUnlocalizedName().concat(BlockTable.subBlocks[metadata%BlockTable.subBlocks.length]);
			bindTexture(resources.get(fullname));
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			modelTableDinner.render(0.0625F);
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
			return BlockTable.MODEL_DINNER_REG;
		}
	};

}
