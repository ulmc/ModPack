package ru.ulmc.ulex;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelFlag extends ModelBase {
	//fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
  
  public ModelFlag()
  {
    textureWidth = 64;
    textureHeight = 56;
    
    Shape1 = new ModelRenderer(this, 0, 0);
    Shape1.addBox(-5F, 0F, -5F, 10, 1, 10);
    Shape1.setRotationPoint(0F, 23F, 0F);
    Shape1.setTextureSize(64, 56);
    Shape1.mirror = true;
    setRotation(Shape1, 0.0151262F, 0.7853982F, 0F);
    Shape2 = new ModelRenderer(this, 0, 0);
    Shape2.addBox(-3F, 0F, -3F, 6, 1, 6);
    Shape2.setRotationPoint(0F, 22F, 0F);
    Shape2.setTextureSize(64, 56);
    Shape2.mirror = true;
    setRotation(Shape2, 0F, 0.7853982F, 0F);
    Shape3 = new ModelRenderer(this, 60, 0);
    Shape3.addBox(0.5F, 0F, 0.5F, 1, 47, 1);
    Shape3.setRotationPoint(-1F, -25F, -1F);
    Shape3.setTextureSize(64, 56);
    Shape3.mirror = true;
    setRotation(Shape3, 0F, 0F, 0F);
    Shape4 = new ModelRenderer(this, 60, 0);
    Shape4.addBox(-0.5F, -9F, -0.5F, 1, 18, 1);
    Shape4.setRotationPoint(0.03333334F, -23F, 0F);
    Shape4.setTextureSize(64, 56);
    Shape4.mirror = true;
    setRotation(Shape4, 1.570796F, 1.570796F, 0F);
    Shape5 = new ModelRenderer(this, 0, -7);
    Shape5.addBox(0F, 0F, -8F, 0, 44, 18);
    Shape5.setRotationPoint(-1F, -23F, 0.6F);
    Shape5.setTextureSize(64, 56);
    Shape5.mirror = true;
    setRotation(Shape5, 0F, 1.570796F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
  }
  public void render(float f5)
  {
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
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

