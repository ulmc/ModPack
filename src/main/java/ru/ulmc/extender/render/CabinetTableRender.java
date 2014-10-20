package ru.ulmc.extender.render;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.block.BasicConnectedBlock;
import ru.ulmc.extender.block.BlockTable;
import ru.ulmc.extender.render.model.connected.cabinet.*;
import ru.ulmc.extender.tileentity.TileEntityTable;

/**
 * Created by 45 on 18.10.2014.
 */
public class CabinetTableRender {
	ModelTableCabinetOneSideRight oneSideRight;
	ModelTableCabinetOneSideRightFull oneSideRightFull;
	ModelTableCabinetOneSideLeft oneSideLeft;
	ModelTableCabinet single;
	ModelTableCabinetFullCenter center;
	private RenderTables tables;

	public CabinetTableRender(RenderTables tables) {
		this.tables = tables;
		oneSideRight = new ModelTableCabinetOneSideRight();
		oneSideLeft = new ModelTableCabinetOneSideLeft();
		oneSideRightFull = new ModelTableCabinetOneSideRightFull();
		single = new ModelTableCabinet();
		center = new ModelTableCabinetFullCenter();
	}

	public void renderTileEntityAt(TileEntity te, double d, double d1, double d2, float f) {
		int rotation = ((TileEntityTable) te).getRotation();
		float deg = rotation * 90F;
		String fullname = te.blockType.getUnlocalizedName() + BlockTable.subBlocks[te.getBlockMetadata()%BlockTable.subBlocks.length];
		GL11.glPushMatrix();

		try {
			tables.bindTexture(RenderTables.getResources().get(fullname), false);
		} catch (Exception e) {
			UltimateExtender.logger.error(e.getMessage());
			e.printStackTrace();
		}
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, 1.0F, 1.0F);
		//GL11.glRotatef(deg, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		boolean flagX1 = false;
		boolean flagX2 = false;
		boolean flagZ1 = false;
		boolean flagZ2 = false;
		if (te.getBlockType() instanceof BasicConnectedBlock) {
			BasicConnectedBlock bl = (BasicConnectedBlock) te.getBlockType();
			flagX1 = bl.canConnectTo(te.getWorldObj(), te.xCoord - 1, te.yCoord, te.zCoord);
			flagX2 = bl.canConnectTo(te.getWorldObj(), te.xCoord + 1, te.yCoord, te.zCoord);
			flagZ1 = bl.canConnectTo(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord - 1);
			flagZ2 = bl.canConnectTo(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord + 1);
		}

		if (!flagX1 && !flagX2 && !flagZ1 && !flagZ2) { // Одиночная

		} else if ((flagX1 && flagX2 && !(flagZ1 || flagZ2))) { // сквозная в любую сторону
			if(rotation == 0  || rotation == 2) {
				if (isRotationIdentical(rotation, te.getWorldObj(), te.xCoord - 1, te.yCoord, te.zCoord) &&
						isRotationIdentical(rotation, te.getWorldObj(), te.xCoord + 1, te.yCoord, te.zCoord)) {
					GL11.glRotatef(deg + 180F, 0.0F, 1.0F, 0.0F);
					center.render(0.0625F);
					GL11.glPopMatrix();
					return;
				}
			}
		} else if (flagZ1 && flagZ2 && !(flagX1 || flagX2)) {
			if(rotation == 1  || rotation == 3) {
				if (isRotationIdentical(rotation, te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord - 1) &&
						isRotationIdentical(rotation, te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord + 1)) {
					GL11.glRotatef(deg + 180F, 0.0F, 1.0F, 0.0F);
					center.render(0.0625F);
					GL11.glPopMatrix();
					return;
				}
			}
		} else {
			if (flagX1 && !(flagX2 || flagZ1 || flagZ2)) {
				if(rotation == 0  || rotation == 2) {
					if(isRotationIdentical(rotation, te.getWorldObj(), te.xCoord-1, te.yCoord, te.zCoord)) {
						if(rotation == 0 ) {
							GL11.glRotatef(deg + 180F, 0.0F, 1.0F, 0.0F);
							oneSideLeft.render(0.0625F);
						} else {
							GL11.glRotatef(deg + 180F, 0.0F, 1.0F, 0.0F);
							if (!isInBigConnection(te.getWorldObj(),te.xCoord-1, te.yCoord, te.zCoord, te.xCoord-2, te.yCoord, te.zCoord))
								oneSideRight.render(0.0625F);
							else
								oneSideRightFull.render(0.0625F);
						}
						GL11.glPopMatrix();
						return;
					}
				}
			} else if (flagX2 && !(flagX1 || flagZ1 || flagZ2)) {
				if(rotation == 0  || rotation == 2) {
					if (isRotationIdentical(rotation, te.getWorldObj(), te.xCoord + 1, te.yCoord, te.zCoord)) {
						if (rotation == 2) {
							GL11.glRotatef(deg + 180F, 0.0F, 1.0F, 0.0F);
							oneSideLeft.render(0.0625F);
						} else {
							GL11.glRotatef(deg + 180F, 0.0F, 1.0F, 0.0F);
							if (!isInBigConnection(te.getWorldObj(), te.xCoord + 1, te.yCoord, te.zCoord, te.xCoord + 2, te.yCoord, te.zCoord))
								oneSideRight.render(0.0625F);
							else
								oneSideRightFull.render(0.0625F);
						}
						GL11.glPopMatrix();
						return;
					}
				}
			} else if (flagZ1 && !(flagX1 || flagX2 || flagZ2)) {
				if(rotation == 1  || rotation == 3) {
					if (isRotationIdentical(rotation, te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord - 1)) {
						if (rotation == 1) {
							GL11.glRotatef(deg + 180F, 0.0F, 1.0F, 0.0F);
							oneSideLeft.render(0.0625F);
						} else {
							GL11.glRotatef(deg + 180F, 0.0F, 1.0F, 0.0F);
							if (!isInBigConnection(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord - 1, te.xCoord, te.yCoord, te.zCoord - 2))
								oneSideRight.render(0.0625F);
							else
								oneSideRightFull.render(0.0625F);
						}
						GL11.glPopMatrix();
						return;
					}
				}
			} else if (flagZ2 && !(flagX1 || flagX2 || flagZ1)) {
				if(rotation == 1  || rotation == 3) {
					if (isRotationIdentical(rotation, te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord + 1)) {
						if (rotation == 1) {
							GL11.glRotatef(deg + 180F, 0.0F, 1.0F, 0.0F);
							if (!isInBigConnection(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord + 1, te.xCoord, te.yCoord, te.zCoord + 2))
								oneSideRight.render(0.0625F);
							else
								oneSideRightFull.render(0.0625F);
						} else {
							GL11.glRotatef(deg + 180F, 0.0F, 1.0F, 0.0F);
							oneSideLeft.render(0.0625F);
						}
						GL11.glPopMatrix();
						return;
					}
				}
			} else {
				//triple here
			}
		}
		GL11.glRotatef(deg+180F, 0.0F, 1.0F, 0.0F);
		single.render(0.0625F);
		GL11.glPopMatrix();
	}

	protected boolean isRotationIdentical(int rotation, IBlockAccess world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x,y,z);
		if(te instanceof TileEntityTable) {
			return ((TileEntityTable) te).getRotation() == rotation;
		}
		return false;
	}

	protected boolean isInBigConnection(IBlockAccess world, int x, int y, int z, int x2, int y2, int z2) {
		BasicConnectedBlock bl = (BasicConnectedBlock) world.getBlock(x,y,z);
		return bl.canConnectTo(world,x2, y2, z2);
	}
}
