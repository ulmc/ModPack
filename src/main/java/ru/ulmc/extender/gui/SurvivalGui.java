/**
 * Copyright (C) 2014 ulmc.ru (Alex K.)
 *
 * This file part of ulmc.ru ModPack
 *
 * ulmc.ru ModPack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ulmc.ru ModPack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/].
 *
 */
package ru.ulmc.extender.gui;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.Reference;

/**
 * Created by 45 on 25.01.14.
 */
@SideOnly(Side.CLIENT)
public class SurvivalGui extends Gui {
    private static ResourceLocation textureFrost = new ResourceLocation(Reference.RES_NAME_C, "textures/misc/frost.png");
    private static ResourceLocation textureHeat = new ResourceLocation(Reference.RES_NAME_C, "textures/misc/heat.png");
    private static Minecraft mc = Minecraft.getMinecraft();
    private static float power = 1.0f;
    private static boolean doRenderFrost = false;
    private static boolean doRenderHeat = false;

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void renderFrostBlur(RenderGameOverlayEvent event) {
        if((!doRenderFrost && !doRenderHeat)
                || event.isCancelable()
                || event.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        if(doRenderFrost) {
            doRenderWork(textureFrost);
        } else {
            doRenderWork(textureHeat);
        }

    }

    private void doRenderWork(ResourceLocation action) {
        ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        int xPos = scaledresolution.getScaledWidth();
        int yPos = scaledresolution.getScaledHeight();
        Minecraft.getMinecraft().renderEngine.bindTexture(action);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, power);
        // GL11.glDisable(GL11.GL_ALPHA_TEST);

        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, (double) yPos, -90.0D, 0.0D, 1.0D);
        tessellator.addVertexWithUV((double) xPos, (double) yPos, -90.0D, 1.0D, 1.0D);
        tessellator.addVertexWithUV((double) xPos, 0.0D, -90.0D, 1.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        // GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public static float getPower() {
        return power;
    }

    public static void setPower(float power) {
        SurvivalGui.power = power;
    }

    public static boolean isDoRenderFrost() {
        return doRenderFrost;
    }

    public static void setDoRenderFrost(boolean doRender) {
        SurvivalGui.doRenderFrost = doRender;
    }

    public static boolean isDoRenderHeat() {
        return doRenderHeat;
    }

    public static void setDoRenderHeat(boolean doRenderHeat) {
        SurvivalGui.doRenderHeat = doRenderHeat;
    }
}
