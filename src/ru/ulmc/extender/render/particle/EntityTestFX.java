package ru.ulmc.extender.render.particle;

import org.lwjgl.opengl.GL11;

import ru.ulmc.extender.Reference;
import ru.ulmc.extender.UltimateExtender;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityTestFX extends EntityFX implements UParticle {
	float particleScaleOverTime;
	private static ResourceLocation texture = new ResourceLocation(Reference.RES_NAME_C, "textures/particles/lock.png");

	public EntityTestFX(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
		particleMaxAge = 15;
		particleGravity = 0.10f;
		particleScale = 1.0f;
		particleScaleOverTime = 2.0F;
		noClip = true;
		setRBGColorF(0.5f + rand.nextFloat()/2, 0.1f+ rand.nextFloat()/2, 0.1f+ rand.nextFloat()/2);
	}

	public void renderParticle(Tessellator tess, float partialTicks, float par3, float par4, float par5, float par6,
			float par7) {
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		/*GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
		tess.startDrawingQuads();*/
		//tess.setBrightness(getBrightnessForRender(partialTicks));
		float scale = 0.2F * particleScale;
		float x = (float) (prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
		float y = (float) (prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
		float z = (float) (prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
		float f14 = 1.0F;
		tess.setColorRGBA_F(this.particleRed * f14 , this.particleGreen * f14, this.particleBlue * f14, this.particleAlpha);
		tess.addVertexWithUV(x - par3 * scale - par6 * scale, y - par4 * scale, z - par5 * scale - par7 * scale, 0.0, 0.0);
		tess.addVertexWithUV(x - par3 * scale + par6 * scale, y + par4 * scale, z - par5 * scale + par7 * scale, 1.0, 0.0);
		tess.addVertexWithUV(x + par3 * scale + par6 * scale, y + par4 * scale, z + par5 * scale + par7 * scale, 1.0, 1.0);
		tess.addVertexWithUV(x + par3 * scale - par6 * scale, y - par4 * scale, z + par5 * scale - par7 * scale, 0.0, 1.0);
		/*tess.draw();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);*/
		//UltimateExtender.logger.info("render at:" + partialTicks);
	}

	@Override
	public int getFXLayer() {
		return 0;
	}

	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (this.particleAge++ >= this.particleMaxAge) {
			this.setDead();
		}

		this.motionY -= 0.04D * (double) this.particleGravity;
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