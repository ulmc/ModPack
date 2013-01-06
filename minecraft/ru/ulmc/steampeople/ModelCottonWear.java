package ru.ulmc.steampeople;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelCottonWear extends ModelBase
{
    public ModelRenderer cottonHead;
    public ModelRenderer cottonHeadwear;
    public ModelRenderer cottonBody;
    public ModelRenderer cottonRightArm;
    public ModelRenderer cottonLeftArm;
    public ModelRenderer cottonRightLeg;
    public ModelRenderer cottonLeftLeg;
    public ModelRenderer cottonEars;
    public ModelRenderer cottonCloak;

    /**
     * Records whether the model should be rendered holding an item in the left hand, and if that item is a block.
     */
    public int heldItemLeft;

    /**
     * Records whether the model should be rendered holding an item in the right hand, and if that item is a block.
     */
    public int heldItemRight;
    public boolean isSneak;

    /** Records whether the model should be rendered aiming a bow. */
    public boolean aimedBow;

    public ModelCottonWear()
    {
        this(0.0F);
    }

    public ModelCottonWear(float par1)
    {
        this(par1, 0.0F);
    }

    public ModelCottonWear(float par1, float par2)
    {
        this.heldItemLeft = 0;
        this.heldItemRight = 0;
        this.isSneak = false;
        this.aimedBow = false;
        this.cottonCloak = new ModelRenderer(this, 0, 0);
        this.cottonCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, par1);
        this.cottonEars = new ModelRenderer(this, 24, 0);
        this.cottonEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, par1);
        this.cottonHead = new ModelRenderer(this, 0, 0);
        this.cottonHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1);
        this.cottonHead.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        this.cottonHeadwear = new ModelRenderer(this, 32, 0);
        this.cottonHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, par1 + 0.5F);
        this.cottonHeadwear.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        this.cottonBody = new ModelRenderer(this, 16, 16);
        this.cottonBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, par1);
        this.cottonBody.setRotationPoint(0.0F, 0.0F + par2, 0.0F);
        this.cottonRightArm = new ModelRenderer(this, 40, 16);
        this.cottonRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, par1);
        this.cottonRightArm.setRotationPoint(-5.0F, 2.0F + par2, 0.0F);
        this.cottonLeftArm = new ModelRenderer(this, 40, 16);
        this.cottonLeftArm.mirror = true;
        this.cottonLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, par1);
        this.cottonLeftArm.setRotationPoint(5.0F, 2.0F + par2, 0.0F);
        this.cottonRightLeg = new ModelRenderer(this, 0, 16);
        this.cottonRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
        this.cottonRightLeg.setRotationPoint(-2.0F, 12.0F + par2, 0.0F);
        this.cottonLeftLeg = new ModelRenderer(this, 0, 16);
        this.cottonLeftLeg.mirror = true;
        this.cottonLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, par1);
        this.cottonLeftLeg.setRotationPoint(2.0F, 12.0F + par2, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7);
        this.cottonHead.render(par7);
        this.cottonBody.render(par7);
        this.cottonRightArm.render(par7);
        this.cottonLeftArm.render(par7);
        this.cottonRightLeg.render(par7);
        this.cottonLeftLeg.render(par7);
        this.cottonHeadwear.render(par7);
    }

    /**
     * Sets the models various rotation angles.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
    {
        this.cottonHead.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.cottonHead.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.cottonHeadwear.rotateAngleY = this.cottonHead.rotateAngleY;
        this.cottonHeadwear.rotateAngleX = this.cottonHead.rotateAngleX;
        this.cottonRightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
        this.cottonLeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
        this.cottonRightArm.rotateAngleZ = 0.0F;
        this.cottonLeftArm.rotateAngleZ = 0.0F;
        this.cottonRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        this.cottonLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.cottonRightLeg.rotateAngleY = 0.0F;
        this.cottonLeftLeg.rotateAngleY = 0.0F;

        if (this.isRiding)
        {
            this.cottonRightArm.rotateAngleX += -((float)Math.PI / 5F);
            this.cottonLeftArm.rotateAngleX += -((float)Math.PI / 5F);
            this.cottonRightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            this.cottonLeftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            this.cottonRightLeg.rotateAngleY = ((float)Math.PI / 10F);
            this.cottonLeftLeg.rotateAngleY = -((float)Math.PI / 10F);
        }

        if (this.heldItemLeft != 0)
        {
            this.cottonLeftArm.rotateAngleX = this.cottonLeftArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemLeft;
        }

        if (this.heldItemRight != 0)
        {
            this.cottonRightArm.rotateAngleX = this.cottonRightArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * (float)this.heldItemRight;
        }

        this.cottonRightArm.rotateAngleY = 0.0F;
        this.cottonLeftArm.rotateAngleY = 0.0F;
        float var7;
        float var8;

        if (this.onGround > -9990.0F)
        {
            var7 = this.onGround;
            this.cottonBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(var7) * (float)Math.PI * 2.0F) * 0.2F;
            this.cottonRightArm.rotationPointZ = MathHelper.sin(this.cottonBody.rotateAngleY) * 5.0F;
            this.cottonRightArm.rotationPointX = -MathHelper.cos(this.cottonBody.rotateAngleY) * 5.0F;
            this.cottonLeftArm.rotationPointZ = -MathHelper.sin(this.cottonBody.rotateAngleY) * 5.0F;
            this.cottonLeftArm.rotationPointX = MathHelper.cos(this.cottonBody.rotateAngleY) * 5.0F;
            this.cottonRightArm.rotateAngleY += this.cottonBody.rotateAngleY;
            this.cottonLeftArm.rotateAngleY += this.cottonBody.rotateAngleY;
            this.cottonLeftArm.rotateAngleX += this.cottonBody.rotateAngleY;
            var7 = 1.0F - this.onGround;
            var7 *= var7;
            var7 *= var7;
            var7 = 1.0F - var7;
            var8 = MathHelper.sin(var7 * (float)Math.PI);
            float var9 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.cottonHead.rotateAngleX - 0.7F) * 0.75F;
            this.cottonRightArm.rotateAngleX = (float)((double)this.cottonRightArm.rotateAngleX - ((double)var8 * 1.2D + (double)var9));
            this.cottonRightArm.rotateAngleY += this.cottonBody.rotateAngleY * 2.0F;
            this.cottonRightArm.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
        }

        if (this.isSneak)
        {
            this.cottonBody.rotateAngleX = 0.5F;
            this.cottonRightArm.rotateAngleX += 0.4F;
            this.cottonLeftArm.rotateAngleX += 0.4F;
            this.cottonRightLeg.rotationPointZ = 4.0F;
            this.cottonLeftLeg.rotationPointZ = 4.0F;
            this.cottonRightLeg.rotationPointY = 9.0F;
            this.cottonLeftLeg.rotationPointY = 9.0F;
            this.cottonHead.rotationPointY = 1.0F;
        }
        else
        {
            this.cottonBody.rotateAngleX = 0.0F;
            this.cottonRightLeg.rotationPointZ = 0.0F;
            this.cottonLeftLeg.rotationPointZ = 0.0F;
            this.cottonRightLeg.rotationPointY = 12.0F;
            this.cottonLeftLeg.rotationPointY = 12.0F;
            this.cottonHead.rotationPointY = 0.0F;
        }

        this.cottonRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.cottonLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
        this.cottonRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        this.cottonLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;

        if (this.aimedBow)
        {
            var7 = 0.0F;
            var8 = 0.0F;
            this.cottonRightArm.rotateAngleZ = 0.0F;
            this.cottonLeftArm.rotateAngleZ = 0.0F;
            this.cottonRightArm.rotateAngleY = -(0.1F - var7 * 0.6F) + this.cottonHead.rotateAngleY;
            this.cottonLeftArm.rotateAngleY = 0.1F - var7 * 0.6F + this.cottonHead.rotateAngleY + 0.4F;
            this.cottonRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.cottonHead.rotateAngleX;
            this.cottonLeftArm.rotateAngleX = -((float)Math.PI / 2F) + this.cottonHead.rotateAngleX;
            this.cottonRightArm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
            this.cottonLeftArm.rotateAngleX -= var7 * 1.2F - var8 * 0.4F;
            this.cottonRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
            this.cottonLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
            this.cottonRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
            this.cottonLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
        }
    }

    /**
     * renders the ears (specifically, deadmau5's)
     */
    public void renderEars(float par1)
    {
        this.cottonEars.rotateAngleY = this.cottonHead.rotateAngleY;
        this.cottonEars.rotateAngleX = this.cottonHead.rotateAngleX;
        this.cottonEars.rotationPointX = 0.0F;
        this.cottonEars.rotationPointY = 0.0F;
        this.cottonEars.render(par1);
    }

    /**
     * Renders the cloak of the current cotton (in most cases, it's a player)
     */
    public void renderCloak(float par1)
    {
        this.cottonCloak.render(par1);
    }
}
