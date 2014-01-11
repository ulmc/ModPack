package ru.ulmc.extender.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import ru.ulmc.extender.Reference;
import ru.ulmc.extender.render.model.ModelCartBody;
import ru.ulmc.extender.render.model.ModelWheel;
import ru.ulmc.extender.tileentity.TileEntityCart;

public class RenderCart extends TileEntitySpecialRenderer {
	private ModelWheel leftWheel = new ModelWheel(-3.0f);
	private ModelWheel rightWheel = new ModelWheel(18.0f);
	private ModelCartBody modelBody = new ModelCartBody();

	public RenderCart() {
	}

	public void renderModel(TileEntityCart tileEntityBones, double d, double d1, double d2, float f) {
		int i = tileEntityBones.getBlockMetadata();
		float deg = 0f;

		GL11.glPushMatrix();
		if (i == 3) {
			deg = 90f;
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 1.35F);
		} else if (i == 2) {
			deg = 180f;
			GL11.glTranslatef((float) d - 0.35F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		} else if (i == 1) {
			deg = 270f;
			GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 - 0.35F);
		} else {
			GL11.glTranslatef((float) d + 1.35F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		}

		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		bindTexture(new ResourceLocation(Reference.RES_NAME_C, "/textures/blocks/woodenCart.png"));

		modelBody.render(0.0625F);
		leftWheel.render(0.0625F);
		rightWheel.render(0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2, double var4, double var6, float var8) {
		TileEntityCart bonesTE = (TileEntityCart) tileEntity;
		renderModel(bonesTE, var2, var4, var6, var8);
	}

}