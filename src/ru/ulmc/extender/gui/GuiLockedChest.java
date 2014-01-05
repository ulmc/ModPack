package ru.ulmc.extender.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import ru.ulmc.extender.Reference;
import ru.ulmc.extender.container.ContainerLockedChest;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;

public class GuiLockedChest extends GuiContainer {

	public static final int GUI_ID = 1;
	
	private int inventoryLabelOffset = 94;
	
	protected static final ResourceLocation textureSingle = new ResourceLocation(
			Reference.RES_NAME_C, "textures/gui/lockedChestGuiSingle.png");
	
	protected static final ResourceLocation textureDouble = new ResourceLocation(
			Reference.RES_NAME_C, "textures/gui/lockedChestGuiDouble.png");
	
	protected TileEntityLockedChest tileEntity;

	public GuiLockedChest(InventoryPlayer inventoryPlayer, TileEntityLockedChest tileEntity) {	
		super(new ContainerLockedChest(inventoryPlayer, tileEntity));
		ySize = 194;
		xSize = 176;
		this.tileEntity = tileEntity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {

		String title;
		if(tileEntity.getOwnerName() != null && !"".equals(tileEntity.getOwnerName())) {
			title = "Owner: " + tileEntity.getOwnerName();
		} else {
			title = "Unlocked chest";
		}
		fontRenderer.drawString(title, 8, 10, 4210752);
		// draws "Inventory" or your regional equivalent
		fontRenderer.drawString(
				StatCollector.translateToLocal("container.inventory"), 8,
				ySize - inventoryLabelOffset, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
			int par3) {
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureSingle);
/*
		if (tileEntity.adjacentChestXPos == null && tileEntity.adjacentChestZPosition == null) {
			Minecraft.getMinecraft().getTextureManager().bindTexture(textureSingle);
		} else {
			Minecraft.getMinecraft().getTextureManager().bindTexture(textureDouble);
		}
		*/
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}