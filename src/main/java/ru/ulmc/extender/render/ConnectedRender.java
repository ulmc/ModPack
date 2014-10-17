package ru.ulmc.extender.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.block.BasicConnectedBlock;
import ru.ulmc.extender.render.model.SimpleUlmcModel;

/**
 * Created by 45 on 16.10.2014.
 */
public abstract class ConnectedRender extends TileEntitySpecialRenderer {
	protected SimpleUlmcModel modelOneConnection = null;
	protected SimpleUlmcModel modelPathThrough = null;
	protected SimpleUlmcModel modelCorner = null;
	protected SimpleUlmcModel modelTriple = null;
	protected SimpleUlmcModel modelCenter = null;
	protected SimpleUlmcModel modelSingle;

	protected void renderConnectedModel(TileEntity tileEntity) {
		Block block = tileEntity.getWorldObj().getBlock(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
		renderConnectedModel(block, tileEntity.getWorldObj(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
	}

	protected void renderConnectedModel(Block block, IBlockAccess world, int x, int y, int z) {
		boolean flagX1 = false;
		boolean flagX2 = false;
		boolean flagZ1 = false;
		boolean flagZ2 = false;
		if (block instanceof BasicConnectedBlock) {
			BasicConnectedBlock bl = (BasicConnectedBlock) block;
			flagX1 = bl.canConnectTo(world, x - 1, y, z);
			flagX2 = bl.canConnectTo(world, x + 1, y, z);
			flagZ1 = bl.canConnectTo(world, x, y, z - 1);
			flagZ2 = bl.canConnectTo(world, x, y, z + 1);
		}
		if (flagX1 && flagX2 && flagZ1 && flagZ2) { // все 4 стороны
			if (modelCenter != null) {
				modelCenter.render(0.0625F);
				return;
			}
		} else if (!flagX1 && !flagX2 && !flagZ1 && !flagZ2) { // Одиночная

		} else if ((flagX1 && flagX2 && !(flagZ1 || flagZ2))) { // сквозная в любую сторону
			if (modelPathThrough != null) {
				modelPathThrough.render(0.0625F);
				return;
			}
		} else if (flagZ1 && flagZ2 && !(flagX1 || flagX2)) {
			if (modelPathThrough != null) {
				GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
				modelPathThrough.render(0.0625F);
				return;
			}
		} else {
			if (flagX1 && flagZ1 && !(flagX2 || flagZ2)) {
				if (modelCorner != null) {
					GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
					modelCorner.render(0.0625F);
					return;
				}
			} else if (flagX2 && flagZ1 && !(flagX1 || flagZ2)) {
				if (modelCorner != null) {
					GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
					modelCorner.render(0.0625F);
					return;
				}
			} else if (flagX1 && flagZ2 && !(flagX2 || flagZ1)) {
				if (modelCorner != null) {
					modelCorner.render(0.0625F);
					return;
				}
			} else if (flagX2 && flagZ2 && !(flagX1 || flagZ1)) {
				if (modelCorner != null) {
					GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
					modelCorner.render(0.0625F);
					return;
				}
			} else if (flagX1 && !(flagX2 || flagZ1 || flagZ2)) {
				if (modelOneConnection != null) {
					modelOneConnection.render(0.0625F);
					return;
				}
			} else if (flagX2 && !(flagX1 || flagZ1 || flagZ2)) {
				if (modelOneConnection != null) {
					GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
					modelOneConnection.render(0.0625F);
					return;
				}
			} else if (flagZ1 && !(flagX1 || flagX2 || flagZ2)) {
				if (modelOneConnection != null) {
					GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
					modelOneConnection.render(0.0625F);
					return;
				}
			} else if (flagZ2 && !(flagX1 || flagX2 || flagZ1)) {
				if (modelOneConnection != null) {
					GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
					modelOneConnection.render(0.0625F);
					return;
				}
			} else {
				if (!flagX1) {
					if (modelTriple != null) {
						GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
						modelTriple.render(0.0625F);
						return;
					}
				} else if (!flagX2) {
					if (modelTriple != null) {
						modelTriple.render(0.0625F);
						return;
					}
				} else if (!flagZ1) {
					if (modelTriple != null) {
						GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
						modelTriple.render(0.0625F);
					}
				} else if (!flagZ2) {
					if (modelTriple != null) {
						GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
						modelTriple.render(0.0625F);
						return;
					}
				}
			}
		}
		modelSingle.render(0.0625F);
		return;
	}
}
