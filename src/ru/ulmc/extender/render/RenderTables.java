package ru.ulmc.extender.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import ru.ulmc.extender.Reference;
import ru.ulmc.extender.render.model.ModelTable;
import ru.ulmc.extender.render.model.ModelTableCabinet;
import ru.ulmc.extender.render.model.ModelTableDinner;
import ru.ulmc.extender.render.model.SimpleUlmcModel;
import ru.ulmc.extender.tileentity.TileEntityTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTables extends TileEntitySpecialRenderer {
	private static ModelTable modelTable = new ModelTable();
	private static ModelTableCabinet modelCabinetTable = new ModelTableCabinet();
	private static ModelTableDinner modelTableDinner = new ModelTableDinner();


	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double var2,
			double var4, double var6, float var8) {
		TileEntityTable tableTE = (TileEntityTable) tileEntity;
		
		SimpleUlmcModel model = null;
		switch (tableTE.getModel()) {
			case TileEntityTable.MODEL_TABLE: {
				model = modelTable;
				break;
			}
			case TileEntityTable.MODEL_CABINET: {
				model = modelCabinetTable;
				break;
			}
			case TileEntityTable.MODEL_DINNER: {
				model = modelTableDinner;
				break;
			}
			default: {
				break;
			}
		}
		if(model != null) {
			doRender(tableTE, var2, var4, var6, var8, model);
		}
	}

	public void doRender(TileEntityTable tileEntity, double d, double d1,
			double d2, float f, SimpleUlmcModel model) {

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
        bindTexture(new ResourceLocation(Reference.RES_NAME_C,
				"/textures/blocks/" + tileEntity.blockType.getUnlocalizedName()
						+ ".png"));
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
        model.render(0.0625F);
        GL11.glPopMatrix();		
	}
}
