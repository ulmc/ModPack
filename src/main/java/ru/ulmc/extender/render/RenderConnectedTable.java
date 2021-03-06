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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.render.model.connected.bench.*;
import ru.ulmc.extender.render.model.connected.table.ModelTable;
import ru.ulmc.extender.render.model.connected.table.ModelTableDoubleSided;
import ru.ulmc.extender.render.model.connected.table.ModelTableOneSided;

import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class RenderConnectedTable extends ConnectedRender {
	private static Map<String, ResourceLocation> resources = new HashMap<String, ResourceLocation>();

	public RenderConnectedTable() {
		modelSingle = new ModelTable();
		modelOneConnection = new ModelTableOneSided();
		modelPathThrough = new ModelTableDoubleSided();
	}

	public static void registerResource(String name) {
		ResourceLocation resource = new ResourceLocation(Reference.RES_NAME_C, "textures/models/furniture/" + name + ".png");
		resources.put(name, resource);
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
			if (resources.containsKey(tileEntity.blockType.getUnlocalizedName())) {
				bindTexture(resources.get(tileEntity.blockType.getUnlocalizedName()));
			}
		} catch (Exception e) {
			UltimateExtender.logger.error(e.getMessage());
			e.printStackTrace();
		}
		renderConnectedModel(tileEntity);
		GL11.glPopMatrix();
	}
}