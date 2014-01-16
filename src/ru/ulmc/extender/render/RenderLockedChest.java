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

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import ru.ulmc.extender.Reference;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLockedChest extends TileEntitySpecialRenderer {
	private static final ResourceLocation RES_NORMAL_LOCKED_SINGLE = new ResourceLocation(Reference.RES_NAME_C, "textures/models/blockLockedChest.png");	

	/** The normal small chest model. */
	private ModelChest chestModel = new ModelChest();

	public RenderLockedChest() {

	}

	/**
	 * Renders the TileEntity for the chest at a position.
	 */
	public void renderTileEntityChestAt(TileEntityLockedChest par1TileEntityChest, double par2, double par4, double par6,
			float par8) {
		int i;

		if (!par1TileEntityChest.hasWorldObj()) {
			i = 0;
		} else {
			i = par1TileEntityChest.getBlockMetadata();

		}
		//ModelChest modelchest = this.chestModel;
		this.bindTexture(RES_NORMAL_LOCKED_SINGLE);

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) par2, (float) par4 + 1.0F, (float) par6 + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		short short1 = 0;

		if (i == 2) {
			short1 = 180;
		} else if (i == 3) {
			short1 = 0;
		} else if (i == 4) {
			short1 = 90;
		} else if (i == 5) {
			short1 = -90;
		}

		GL11.glRotatef((float) short1, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		float f1 = par1TileEntityChest.prevLidAngle + (par1TileEntityChest.lidAngle - par1TileEntityChest.prevLidAngle)
				* par8;

		f1 = 1.0F - f1;
		f1 = 1.0F - f1 * f1 * f1;
		chestModel.chestLid.rotateAngleX = -(f1 * (float) Math.PI / 2.0F);
		chestModel.renderAll();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

	}

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
		this.renderTileEntityChestAt((TileEntityLockedChest) par1TileEntity, par2, par4, par6, par8);
	}
}
