package ru.ulmc.extender.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import ru.ulmc.extender.Reference;
import ru.ulmc.extender.container.ContainerBones;
import ru.ulmc.extender.tileentity.TileEntityBones;

public class GuiBones extends GuiContainer {

	public static final int GUI_ID = 0;
	
	protected static final ResourceLocation texture = new ResourceLocation(
			Reference.RES_NAME_C, "textures/gui/bonesGui.png");
	
	protected TileEntityBones tileEntity;

	public GuiBones(InventoryPlayer inventoryPlayer, TileEntityBones tileEntity) {
	
		super(new ContainerBones(inventoryPlayer, tileEntity));
		this.tileEntity = tileEntity;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {

		String title;
		if(tileEntity.getOwnerName() != null && !"".equals(tileEntity.getOwnerName())) {
			title = "Bones of " + tileEntity.getOwnerName();
		} else {
			title = "Pile of Bones";
		}
		fontRenderer.drawString(title, 8, 6, 4210752);
		// draws "Inventory" or your regional equivalent
		fontRenderer.drawString(
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