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
package ru.ulmc.extender.render.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import ru.ulmc.extender.Reference;

@SideOnly(Side.CLIENT)
public class EntityTestFX extends EntityFX implements UParticle {
	private static ResourceLocation texture = new ResourceLocation(Reference.RES_NAME_C, "textures/items/capsuleLogger.png");
	float particleScaleOverTime;

	public EntityTestFX(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
		particleMaxAge = 45;
		particleGravity = -1.13f;
		particleScale = 0.7f;
		particleScaleOverTime = 2.0F;
		noClip = true;
		// setRBGColorF(0.5f + rand.nextFloat() / 2, 0.1f + rand.nextFloat() / 2, 0.1f + rand.nextFloat() / 2);
	}

	@Override
	public void renderParticle(Tessellator tess, float partialTicks, float par3, float par4, float par5, float par6,
	                           float par7) {
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);

		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);

		tess.startDrawingQuads();
		tess.setBrightness(getBrightnessForRender(partialTicks));
		float scale = 0.2F * particleScale;
		float x = (float) (prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
		float y = (float) (prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
		float z = (float) (prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
		float f14 = 1.0F;
		//tess.setColorRGBA_F(this.particleRed * f14, this.particleGreen * f14, this.particleBlue * f14, this.particleAlpha);
		tess.addVertexWithUV(x + par3 * scale + par6 * scale, y + par4 * scale, z + par5 * scale + par7 * scale, 0.0, 0.0);
		tess.addVertexWithUV(x + par3 * scale - par6 * scale, y - par4 * scale, z + par5 * scale - par7 * scale, 0.0, 1.0);
		tess.addVertexWithUV(x - par3 * scale - par6 * scale, y - par4 * scale, z - par5 * scale - par7 * scale, 1.0, 1.0);
		tess.addVertexWithUV(x - par3 * scale + par6 * scale, y + par4 * scale, z - par5 * scale + par7 * scale, 1.0, 0.0);
		tess.draw();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
		//UltimateExtender.logger.info("render at:" + partialTicks);
	}

	@Override
	public int getFXLayer() {
		return 3;
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (this.particleAge++ >= this.particleMaxAge) {
			this.setDead();
		}

		particleScale = 1.021f / particleScale * particleScale * particleScale;
		particleGravity = 0.3f / particleGravity * particleGravity * particleGravity;

		this.motionY -= 0.04D * this.particleGravity;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;

		if (this.onGround) {
			this.motionY *= 0.4800000190734863D;
			this.motionX *= 0.399999988079071D;
			this.motionZ *= 0.399999988079071D;
		}
	}

}
