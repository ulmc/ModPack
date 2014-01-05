package ru.ulmc.extender.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.render.model.ModelChair;
import ru.ulmc.extender.render.model.ModelEliteChair;
import ru.ulmc.extender.tileentity.TileEntityChair;
import ru.ulmc.extender.tileentity.TileEntityEliteChair;

@SideOnly(Side.CLIENT)
public class RenderUlmcObjects extends TileEntitySpecialRenderer {
	private ModelChair modelChair;
	private ModelEliteChair modelEliteChair;

	public RenderUlmcObjects() {
		modelEliteChair = new ModelEliteChair();
		modelChair = new ModelChair();
	}

	public void renderModel(TileEntity tileEntity, double d, double d1,
			double d2, float f) {
		if (tileEntity instanceof TileEntityChair) {
			renderChairs((TileEntityChair) tileEntity, d, d1, d2, f);
		} else if (tileEntity instanceof TileEntityEliteChair) {
			renderEliteChairs((TileEntityEliteChair) tileEntity, d, d1, d2, f);
		}
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2,
			double var4, double var6, float var8) {
		this.renderModel(tileEntity, var2, var4, var6, var8);
	}

	public void renderChairs(TileEntity tileEntity, double d, double d1,
			double d2, float f) {
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
		
		bindTexture(new ResourceLocation(Reference.RES_NAME_C,"/textures/blocks/" + tileEntity.blockType.getUnlocalizedName() + ".png"));
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,
				(float) d2 + 0.5F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		modelChair.render(0.0625F);
		GL11.glPopMatrix();
	}

	public void renderEliteChairs(TileEntity tileEntity, double d, double d1,
			double d2, float f) {
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
		
		bindTexture(new ResourceLocation(Reference.RES_NAME_C,"/textures/blocks/" + tileEntity.blockType.getUnlocalizedName() + ".png"));
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,
				(float) d2 + 0.5F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		modelEliteChair.render(0.0625F);
		GL11.glPopMatrix();
	}

}