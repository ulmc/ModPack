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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.block.BlockFlag;
import ru.ulmc.extender.render.model.ModelFlag;
import ru.ulmc.extender.tileentity.TileEntityFlag;

@SideOnly(Side.CLIENT)
public class RenderFlags extends TileEntitySpecialRenderer {
	private static ResourceLocation resources[][] = new ResourceLocation[3][16];
	private ModelFlag modelFlag = new ModelFlag();

	public static void registerResource(int type, String name) {

		for (int i = 0; i < 16; i++) {
			resources[type][i] = new ResourceLocation(Reference.RES_NAME_C, "textures/models/" + getPath(type, i) + name + ".png");
			;
		}

	}

	private static String getPath(int type, int id) {
		if (type == 0) {
			return "flags/neutral/" + id;
		} else if (type == 1) {
			return "flags/medival/" + id;
		} else {
			return "flags/techno/" + id;
		}
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2,
	                               double var4, double var6, float var8) {
		renderFlag((TileEntityFlag) tileEntity, var2, var4, var6, var8);
	}

	public void renderFlag(TileEntityFlag flagEntity, double d, double d1,
	                       double d2, float f) {

		float deg = flagEntity.getAngle() * 22.5F;

		int i = ((BlockFlag) flagEntity.blockType).getBlockType();
		int s = flagEntity.getSkin();

		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(0.95F, 0.95F, 0.95F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		try {
			if (resources.length >= i && resources[i].length >= s) {
				bindTexture(resources[i][s]);
			}
		} catch (Exception e) {
			UltimateExtender.logger.error(e.getMessage());
			e.printStackTrace();
		}

		modelFlag.render(0.0625F);
		GL11.glPopMatrix();
	}

}
