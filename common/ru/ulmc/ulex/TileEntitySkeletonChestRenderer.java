package ru.ulmc.ulex;


import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.ModelChest;
import net.minecraft.src.ModelLargeChest;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntitySkeletonChestRenderer extends TileEntitySpecialRenderer
{
    /** The normal small chest model. */
    private ModelChest chestModel = new ModelChest();

    /** The large double chest model. */
    private ModelChest largeChestModel = new ModelLargeChest();

    /**
     * Renders the TileEntity for the chest at a position.
     */
    public void renderTileEntityChestAt(TileEntitySkeletonChest TileEntitySkeletonChest, double par2, double par4, double par6, float par8)
    {
        int var9;

        if (!TileEntitySkeletonChest.func_70309_m())
        {
            var9 = 0;
        }
        else
        {
            Block var10 = TileEntitySkeletonChest.getBlockType();
            var9 = TileEntitySkeletonChest.getBlockMetadata();

            if (var10 != null && var9 == 0)
            {
                ((BlockSkeletonChest)var10).unifyAdjacentChests(TileEntitySkeletonChest.func_70314_l(), TileEntitySkeletonChest.xCoord, TileEntitySkeletonChest.yCoord, TileEntitySkeletonChest.zCoord);
                var9 = TileEntitySkeletonChest.getBlockMetadata();
            }

            TileEntitySkeletonChest.checkForAdjacentChests();
        }

        if (TileEntitySkeletonChest.adjacentChestZNeg == null && TileEntitySkeletonChest.adjacentChestXNeg == null)
        {
            ModelChest var14;

            if (TileEntitySkeletonChest.adjacentChestXPos == null && TileEntitySkeletonChest.adjacentChestZPosition == null)
            {
                var14 = this.chestModel;
                this.bindTextureByName("/ru/ulmc/png/chest.png");
            }
            else
            {
                var14 = this.largeChestModel;
                this.bindTextureByName("/ru/ulmc/png/largechest.png");
            }

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6 + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short var11 = 0;

            if (var9 == 2)
            {
                var11 = 180;
            }

            if (var9 == 3)
            {
                var11 = 0;
            }

            if (var9 == 4)
            {
                var11 = 90;
            }

            if (var9 == 5)
            {
                var11 = -90;
            }

            if (var9 == 2 && TileEntitySkeletonChest.adjacentChestXPos != null)
            {
                GL11.glTranslatef(1.0F, 0.0F, 0.0F);
            }

            if (var9 == 5 && TileEntitySkeletonChest.adjacentChestZPosition != null)
            {
                GL11.glTranslatef(0.0F, 0.0F, -1.0F);
            }

            GL11.glRotatef((float)var11, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float var12 = TileEntitySkeletonChest.prevLidAngle + (TileEntitySkeletonChest.lidAngle - TileEntitySkeletonChest.prevLidAngle) * par8;
            float var13;

            if (TileEntitySkeletonChest.adjacentChestZNeg != null)
            {
                var13 = TileEntitySkeletonChest.adjacentChestZNeg.prevLidAngle + (TileEntitySkeletonChest.adjacentChestZNeg.lidAngle - TileEntitySkeletonChest.adjacentChestZNeg.prevLidAngle) * par8;

                if (var13 > var12)
                {
                    var12 = var13;
                }
            }

            if (TileEntitySkeletonChest.adjacentChestXNeg != null)
            {
                var13 = TileEntitySkeletonChest.adjacentChestXNeg.prevLidAngle + (TileEntitySkeletonChest.adjacentChestXNeg.lidAngle - TileEntitySkeletonChest.adjacentChestXNeg.prevLidAngle) * par8;

                if (var13 > var12)
                {
                    var12 = var13;
                }
            }

            var12 = 1.0F - var12;
            var12 = 1.0F - var12 * var12 * var12;
            var14.chestLid.rotateAngleX = -(var12 * (float)Math.PI / 2.0F);
            var14.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityChestAt((TileEntitySkeletonChest)par1TileEntity, par2, par4, par6, par8);
    }
}
