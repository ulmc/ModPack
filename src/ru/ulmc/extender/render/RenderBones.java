package ru.ulmc.extender.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.render.model.ModelBonesEmpty;
import ru.ulmc.extender.render.model.ModelBonesFull;
import ru.ulmc.extender.render.model.ModelBonesM;
import ru.ulmc.extender.render.model.SimpleUlmcModel;
import ru.ulmc.extender.tileentity.TileEntityBones;

public class RenderBones extends TileEntitySpecialRenderer {
	private ModelBonesM modelM 			= new ModelBonesM();
	private ModelBonesEmpty modelEmpty 	= new ModelBonesEmpty();
	private ModelBonesFull modelFull 	= new ModelBonesFull();

	public RenderBones() {
	}

	public void renderModel(TileEntityBones tileEntityBones, double d,
			double d1, double d2, float f, SimpleUlmcModel aModel) {
		int i = tileEntityBones.getBlockMetadata();
		float deg = 0f;

		if (i == 3) {
			deg = 90f;
		} else if (i == 2) {
			deg = 180f;
		} else if (i == 1) {
			deg = 270f;
		}
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,
				(float) d2 + 0.5F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		bindTexture(new ResourceLocation(Reference.RES_NAME_C,
					"/textures/blocks/bonesFull.png"));	
		
		aModel.render(0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2,
			double var4, double var6, float var8) {
		TileEntityBones bonesTE = (TileEntityBones)tileEntity;
		switch (bonesTE.getState()) {
			case 0:
				renderModel(bonesTE, var2, var4, var6, var8, modelEmpty);
				break;
			case 1:
				renderModel(bonesTE, var2, var4, var6, var8, modelM);
				break;
			case 2:
				renderModel(bonesTE, var2, var4, var6, var8, modelFull);
				break;
		}
		
	}

}