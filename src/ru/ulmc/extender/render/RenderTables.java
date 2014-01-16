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

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.render.model.ModelTable;
import ru.ulmc.extender.render.model.ModelTableCabinet;
import ru.ulmc.extender.render.model.ModelTableDinner;
import ru.ulmc.extender.render.model.SimpleUlmcModel;
import ru.ulmc.extender.tileentity.TileEntityTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTables extends TileEntitySpecialRenderer {
	private static ModelTable modelTable = new ModelTable();
	private static ModelTableCabinet modelCabinetTable = new ModelTableCabinet();
	private static ModelTableDinner modelTableDinner = new ModelTableDinner();
	private static Map<String, ResourceLocation> resources = new HashMap<String, ResourceLocation>();

	public static void registerResource(String name) {
		ResourceLocation resource = new ResourceLocation(Reference.RES_NAME_C, "textures/models/" + name + ".png");
		resources.put(name, resource);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2,
			double var4, double var6, float var8) {
		TileEntityTable tableTE = (TileEntityTable) tileEntity;
		
		SimpleUlmcModel model = null;
		switch (tableTE.getModel()) {
			case TileEntityTable.MODEL_TABLE: {
				model = modelTable;
				break;
			}
			case TileEntityTable.MODEL_CABINET: {
				model = modelCabinetTable;
				break;
			}
			case TileEntityTable.MODEL_DINNER: {
				model = modelTableDinner;
				break;
			}
			default: {
				break;
			}
		}
		
		if(model != null) {
			doRender(tableTE, var2, var4, var6, var8, model);
		}
	}

	public void doRender(TileEntityTable tileEntity, double d, double d1,
			double d2, float f, SimpleUlmcModel model) {

		int i = tileEntity.getBlockMetadata();
		float deg = 0f;
		if (i == 3) {
			deg = 90f;
		} else if (i == 2) {
			deg = 180f;
		} else if (i == 1) {
			deg = 270f;
		} else if (i == 0) {
			deg = 0f;
		}
         
        GL11.glPushMatrix();
        
        try {
        	if(resources.containsKey(tileEntity.blockType.getUnlocalizedName())) {
        		bindTexture(resources.get(tileEntity.blockType.getUnlocalizedName()));
        	}
		} catch (Exception e) {
			UltimateExtender.logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
        model.render(0.0625F);
        GL11.glPopMatrix();		
	}
}
