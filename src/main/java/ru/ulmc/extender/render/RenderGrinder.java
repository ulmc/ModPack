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
import ru.ulmc.extender.item.ItemGrind;
import ru.ulmc.extender.render.model.ModelBarrel;
import ru.ulmc.extender.render.model.ModelGrinder;
import ru.ulmc.extender.tileentity.TileEntityGrinder;

@SideOnly(Side.CLIENT)
public class RenderGrinder extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {
	private static ResourceLocation resource;
	private ModelGrinder model = new ModelGrinder();

	public RenderGrinder() {
		resource = new ResourceLocation(Reference.RES_NAME_C, "textures/models/furniture/tile.blockGrinder.png");
	}

	public void renderModel(TileEntity tileEntity, double d, double d1,
	                        double d2, float f) {
		render(tileEntity, d, d1, d2, f);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2,
	                               double var4, double var6, float var8) {
		this.renderModel(tileEntity, var2, var4, var6, var8);
	}

	public void render(TileEntity tileEntity, double d, double d1, double d2, float f) {
		float deg = tileEntity.getBlockMetadata() * 90F +90F;
		int type = -1;
		/*float degHandle = 0F;
		float degDisc = 0F;
		int impulse = 0;*/
		if(tileEntity instanceof TileEntityGrinder) {
			type = ((TileEntityGrinder) tileEntity).getGrinderType();
			//impulse = ((TileEntityGrinder) tileEntity).getImpulse();
		}
	/*	if(impulse > 0) {
			degHandle = 2.5F;
			degDisc = 5F;
		}
*/
		GL11.glPushMatrix();

		try {
			bindTexture(resource);
		} catch (Exception e) {
			UltimateExtender.logger.error(e.getMessage());
			e.printStackTrace();
		}
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,
				(float) d2 + 0.5F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		model.render(0.0625F, type/*, degHandle, degDisc*/);
		GL11.glPopMatrix();
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		bindTexture(resource);

		//GL11.glPushMatrix();
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glTranslatef(0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		//GL11.gl
		model.render(0.0625F, ItemGrind.ID_COARSE);
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
		return BlockManager.blockGrinder.getRenderType();
	}
}