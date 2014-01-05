package ru.ulmc.extender.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import ru.ulmc.extender.Reference;
import ru.ulmc.extender.block.BlockFlag;
import ru.ulmc.extender.render.model.ModelFlag;
import ru.ulmc.extender.tileentity.TileEntityFlag;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class RenderFlags extends TileEntitySpecialRenderer {
	private ModelFlag modelFlag = new ModelFlag();
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2,
			double var4, double var6, float var8) {
		renderFlag((TileEntityFlag)tileEntity, var2, var4, var6, var8);
	}

	public void renderFlag(TileEntityFlag flagEntity, double d, double d1,
			double d2, float f) {

		float deg = flagEntity.getAngle() * 22.5F;
		
		int i = ((BlockFlag)flagEntity.blockType).getBlockType();
		int s = flagEntity.getSkin();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F,
				(float) d2 + 0.5F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		bindTexture(new ResourceLocation(Reference.RES_NAME_C,
				"/textures/blocks/" + getPath(i, s)
						+ flagEntity.blockType.getUnlocalizedName() + ".png"));
		
		modelFlag.render(0.0625F);
		GL11.glPopMatrix();
	}
	private String getPath(int type, int id) {
		if (type == 0) {
			return "flags/neutral/" + id;
		} else if (type == 1) {
			return "flags/medival/" + id;
		} else {
			return "flags/techno/" + id;
		}
	}
	
}
