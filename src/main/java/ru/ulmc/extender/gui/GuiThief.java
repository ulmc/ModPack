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

package ru.ulmc.extender.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.container.ContainerThief;

public class GuiThief extends GuiContainer {

	public static final int GUI_ID = 3;

	protected static final ResourceLocation texture = new ResourceLocation(
			Reference.RES_NAME_C, "textures/gui/thiefGui.png");

	protected InventoryPlayer victim;

	public GuiThief(InventoryPlayer inventoryPlayer, InventoryPlayer victim) {

		super(new ContainerThief(inventoryPlayer, victim));
		this.victim = victim;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {

		String title = victim.getInventoryName();

		fontRendererObj.drawString(title, 8, 6, 4210752);
		// draws "Inventory" or your regional equivalent
		fontRendererObj.drawString(
				StatCollector.translateToLocal("container.inventory"), 8,
				ySize - 110, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
	                                               int par3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}