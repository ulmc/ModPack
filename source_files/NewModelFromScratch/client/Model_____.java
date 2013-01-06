package ru.ulmc.ulex;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelBones extends ModelBase
{
	//fields
    ModelRenderer bone1;
    ModelRenderer skull;
    ModelRenderer bone2;
    ModelRenderer bone3;
    ModelRenderer bone5;
    ModelRenderer goldcoin;
    ModelRenderer backbone1;
    ModelRenderer verticalbone;
  
  public ModelBones()
  {
    textureWidth = 32;
    textureHeight = 16;
    
      bone1 = new ModelRenderer(this, 0, 14);
      bone1.addBox(0F, 0F, 0F, 9, 1, 1);
      bone1.setRotationPoint(-2F, 23F, -6F);
      bone1.setTextureSize(32, 16);
      bone1.mirror = true;
      setRotation(bone1, 0F, -0.2602503F, 0F);
      skull = new ModelRenderer(this, 0, 0);
      skull.addBox(0F, -6F, -3F, 6, 6, 6);
      skull.setRotationPoint(-3F, 23F, 0F);
      skull.setTextureSize(32, 16);
      skull.mirror = true;
      setRotation(skull, 0.1115358F, -0.2602503F, -0.3346075F);
      bone2 = new ModelRenderer(this, 0, 14);
      bone2.addBox(-5F, 0F, 0F, 10, 1, 1);
      bone2.setRotationPoint(0F, 23F, 5F);
      bone2.setTextureSize(32, 16);
      bone2.mirror = true;
      setRotation(bone2, 0F, 0.2602503F, 0F);
      bone3 = new ModelRenderer(this, 27, 0);
      bone3.addBox(0F, -7F, 0F, 1, 9, 1);
      bone3.setRotationPoint(1.866667F, 22.66667F, -1.333333F);
      bone3.setTextureSize(32, 16);
      bone3.mirror = true;
      setRotation(bone3, -1.449966F, 0F, 0F);
      bone5 = new ModelRenderer(this, 27, 0);
      bone5.addBox(0F, -10F, 0F, 1, 10, 1);
      bone5.setRotationPoint(-2F, 22F, 5F);
      bone5.setTextureSize(32, 16);
      bone5.mirror = true;
      setRotation(bone5, 0.1858931F, 1.115358F, 1.635859F);
      goldcoin = new ModelRenderer(this, 24, 13);
      goldcoin.addBox(0F, 0F, 0F, 2, 1, 2);
      goldcoin.setRotationPoint(4F, 23F, 3F);
      goldcoin.setTextureSize(32, 16);
      goldcoin.mirror = true;
      setRotation(goldcoin, 0F, 1.003822F, 0F);
      backbone1 = new ModelRenderer(this, 0, 14);
      backbone1.addBox(-6F, 0F, 0F, 9, 1, 1);
      backbone1.setRotationPoint(-4.6F, 23.26667F, -4.666667F);
      backbone1.setTextureSize(32, 16);
      backbone1.mirror = true;
      setRotation(backbone1, 1.245484F, 1.189716F, 0F);
      verticalbone = new ModelRenderer(this, 27, 0);
      verticalbone.addBox(0F, 0F, 0F, 1, 6, 1);
      verticalbone.setRotationPoint(-4.666667F, 18F, 3.866667F);
      verticalbone.setTextureSize(32, 16);
      verticalbone.mirror = true;
      setRotation(verticalbone, -0.0743572F, 0.4089647F, 0.1858931F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    bone1.render(f5);
    skull.render(f5);
    bone2.render(f5);
    bone3.render(f5);
    bone5.render(f5);
    goldcoin.render(f5);
    backbone1.render(f5);
    verticalbone.render(f5);
  }
  public void render(float f5)
  {

    bone1.render(f5);
    skull.render(f5);
    bone2.render(f5);
    bone3.render(f5);
    bone5.render(f5);
    goldcoin.render(f5);
    backbone1.render(f5);
    verticalbone.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }
  }


