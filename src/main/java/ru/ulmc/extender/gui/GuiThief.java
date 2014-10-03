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
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.container.ContainerThief;
import ru.ulmc.extender.network.ConfirmStealPacket;
import ru.ulmc.extender.network.IntentStealPacket;

import java.util.Timer;
import java.util.TimerTask;

public class GuiThief extends GuiContainer {

	public static final int GUI_ID = 3;
	public static final int BTN_STEAL_X_OFFSET = 2;
	public static final int BTN_STEAL_Y_OFFSET = 91;
	protected GuiButton stealStartBtn;
	protected EntityPlayer player;
	protected int step = 1;
	protected int percent = 0;
	protected boolean isInProgress = false;
	protected static final ResourceLocation texture = new ResourceLocation( Reference.RES_NAME_C, "textures/gui/thiefGui.png");

	protected Timer timer = new Timer();


	public GuiThief(EntityPlayer player) {
		super(new ContainerThief(player));
		this.player = player;
		stealStartBtn = new GuiButton(1, (this.height - BTN_STEAL_Y_OFFSET)/2,
				(this.width - BTN_STEAL_X_OFFSET) /2, 35, 20, "steal");

		ConfirmStealPacket.Handler.callback = new LootingUpdater();
		UltimateExtender.STEAL_PROCESSOR.setClientContainer((ContainerThief)this.inventorySlots);
	}

	@Override
	public void updateScreen() {
		super.updateScreen();

		stealStartBtn.yPosition = (this.height - BTN_STEAL_Y_OFFSET) / 2;
		stealStartBtn.xPosition = (this.width - BTN_STEAL_X_OFFSET) / 2;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		fontRendererObj.drawString("loot", 8, 6, 4210752);
		// draws "Inventory" or your regional equivalent
		fontRendererObj.drawString(
				StatCollector.translateToLocal("container.inventory"), 8,
				ySize - 124, 4210752);
		if (isInProgress) {
			drawRect(this.width/2, this.height/2, this.width/2 + percent, this.height/2-10, 0x665588ff);
		}

		//drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if(button.id == 1) {
			IntentStealPacket intent = new IntentStealPacket();
			intent.setThiefName(player.getDisplayName());
			intent.setAskingForLoot(false);
			intent.setStep(step);
			UltimateExtender.networkWrapper.sendToServer(intent);
			stealStartBtn.enabled = false;
		}
	}

	protected void askForLoot() {
		IntentStealPacket intent = new IntentStealPacket();
		intent.setThiefName(player.getDisplayName());
		intent.setAskingForLoot(true);
		intent.setStep(step);
		UltimateExtender.networkWrapper.sendToServer(intent);
		stealStartBtn.enabled = true;
	}

	@Override
	public void initGui() {
		super.initGui();
		buttonList.add(stealStartBtn);
	}

	public class LootingUpdater {
		public void run(final ConfirmStealPacket clp) {
			if (clp.isOk()) {
				isInProgress = true;
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						if (percent <= 100) {
							percent += 100 / (clp.getDelta()/1000);

						} else {
							isInProgress = false;
							timer.cancel();
							askForLoot();
						}
					}
				}, 0, 1000);
			}
		}
	}
}