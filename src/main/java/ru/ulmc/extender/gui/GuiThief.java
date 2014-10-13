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
import ru.ulmc.extender.network.IntentStealPacket;
import ru.ulmc.extender.network.LootPacket;

import java.util.Timer;
import java.util.TimerTask;

public class GuiThief extends GuiContainer {

	public static final int GUI_ID = 3;
	public static final int BTN_STEAL_X_OFFSET = 2;
	public static final int BTN_STEAL_Y_OFFSET = 91;
	public static final int MAX_STEPS = 9;
	public static final int SLOT_SIZE_PX = 16;
	protected GuiButton stealStartBtn;
	protected EntityPlayer player;
	protected int step = 0;
	protected int percent = 0;
	protected int[] failedIds = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
	protected boolean isInProgress = false;
	protected boolean isTotallyFailed = false;
	protected static final ResourceLocation texture = new ResourceLocation( Reference.RES_NAME_C, "textures/gui/thiefGui.png");

	protected Timer timer = new Timer(true);


	public GuiThief(EntityPlayer player) {
		super(new ContainerThief(player));
		this.player = player;
		stealStartBtn = new GuiButton(1, (this.height - BTN_STEAL_Y_OFFSET)/2,
				(this.width - BTN_STEAL_X_OFFSET) /2, 82, 20, "steal");

		LootPacket.Handler.callback = new LootingUpdater();
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
			int x = inventorySlots.getSlot(step).xDisplayPosition;
			int y = inventorySlots.getSlot(step).yDisplayPosition;
			drawRect(x, y, (x + SLOT_SIZE_PX *percent/100), y+SLOT_SIZE_PX, 0x895588ff);
		}

		for(int i = 0; i < failedIds.length; i++) {
			if(failedIds[i] != -1) {
				int x = inventorySlots.getSlot(failedIds[i]).xDisplayPosition;
				int y = inventorySlots.getSlot(failedIds[i]).yDisplayPosition;
				drawRect(x, y, (x + SLOT_SIZE_PX), y + SLOT_SIZE_PX, 0x89e32b2b);
			} else {
				break;
			}
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

	protected void  askForLoot() {
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
		public void run(final LootPacket clp) {
			if (clp.isSuccess()) {
				isInProgress = true;
				percent = 0;
				timer.schedule(new TimerTask() {
					@Override
					public void run() {
						if (percent <= 100) {
							percent += 100 / (clp.getDelta()/200);

						} else {
							percent = 100;
							isInProgress = false;
							//step++;
							askForLoot();
							cancel();
						}
					}
				}, 0, 200);
			}
		}
	}

	public void setStep(int step) {
		this.step = step;
		if (step >= MAX_STEPS) {
			stealStartBtn.enabled = false;
		}
	}

	public EntityPlayer getPlayer() {
		return player;
	}

	public void setTotallyFailed(boolean isTotallyFailed) {
		this.isTotallyFailed = isTotallyFailed;
		if(isTotallyFailed) {
			stealStartBtn.enabled = false;
			stealStartBtn.displayString = "BUSTED";
		}
	}

	public void setFailedID(int id) {
		for(int i = 0; i < failedIds.length; i++) {
			if(failedIds[i] == -1) {
				failedIds[i] = id;
				break;
			}
		}
	}
}