// Date: 28.08.2012 2:30:23
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelNew extends ModelBase
{
  //fields
    ModelRenderer Shape4;
    ModelRenderer Shape1;
    ModelRenderer Shape3;
    ModelRenderer Shape2;
    ModelRenderer Shape2;
    ModelRenderer Shape5;
    ModelRenderer Shape4;
    ModelRenderer Shape6;
    ModelRenderer Shape6;
    ModelRenderer Shape2;
  
  public ModelNew()
  {
    textureWidth = 32;
    textureHeight = 16;
    
      Shape4 = new ModelRenderer(this, 0, 14);
      Shape4.addBox(0F, 0F, 0F, 9, 1, 1);
      Shape4.setRotationPoint(-2F, 23F, -6F);
      Shape4.setTextureSize(32, 16);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, -0.2602503F, 0F);
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, -8F, -3F, 6, 6, 6);
      Shape1.setRotationPoint(-3F, 23F, 0F);
      Shape1.setTextureSize(32, 16);
      Shape1.mirror = true;
      setRotation(Shape1, 0.1858931F, -0.1487144F, -0.2602503F);
      Shape3 = new ModelRenderer(this, 0, 14);
      Shape3.addBox(-5F, 0F, 0F, 10, 1, 1);
      Shape3.setRotationPoint(0F, 23F, 5F);
      Shape3.setTextureSize(32, 16);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0.2602503F, 0F);
      Shape2 = new ModelRenderer(this, 27, 0);
      Shape2.addBox(0F, -7F, 0F, 1, 9, 1);
      Shape2.setRotationPoint(1.866667F, 22.66667F, -1.333333F);
      Shape2.setTextureSize(32, 16);
      Shape2.mirror = true;
      setRotation(Shape2, -1.449966F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 27, 0);
      Shape2.addBox(0F, -9F, 0F, 1, 10, 1);
      Shape2.setRotationPoint(-4F, 22F, 4F);
      Shape2.setTextureSize(32, 16);
      Shape2.mirror = true;
      setRotation(Shape2, -0.2602503F, 0.8551081F, 1.449966F);
      Shape5 = new ModelRenderer(this, 24, 13);
      Shape5.addBox(0F, 0F, 0F, 2, 1, 2);
      Shape5.setRotationPoint(4F, 23F, 3F);
      Shape5.setTextureSize(32, 16);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 1.003822F, 0F);
      Shape4 = new ModelRenderer(this, 0, 14);
      Shape4.addBox(-6F, 0F, 0F, 9, 1, 1);
      Shape4.setRotationPoint(-4.6F, 23.26667F, -4.666667F);
      Shape4.setTextureSize(32, 16);
      Shape4.mirror = true;
      setRotation(Shape4, 1.245484F, 1.189716F, 0F);
      Shape6 = new ModelRenderer(this, 6, 0);
      Shape6.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape6.setRotationPoint(-2.733333F, 20.73333F, -0.6666667F);
      Shape6.setTextureSize(32, 16);
      Shape6.mirror = true;
      setRotation(Shape6, 0.2230717F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 6, 0);
      Shape6.addBox(0F, 0F, 0F, 2, 2, 2);
      Shape6.setRotationPoint(-3F, 22F, 0F);
      Shape6.setTextureSize(32, 16);
      Shape6.mirror = true;
      setRotation(Shape6, 0.2230717F, 0F, 0.3717861F);
      Shape2 = new ModelRenderer(this, 27, 0);
      Shape2.addBox(0F, 0F, 0F, 1, 6, 1);
      Shape2.setRotationPoint(-4.666667F, 18F, 2.866667F);
      Shape2.setTextureSize(32, 16);
      Shape2.mirror = true;
      setRotation(Shape2, -0.0371786F, 0.3346075F, -0.0743572F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape4.render(f5);
    Shape1.render(f5);
    Shape3.render(f5);
    Shape2.render(f5);
    Shape2.render(f5);
    Shape5.render(f5);
    Shape4.render(f5);
    Shape6.render(f5);
    Shape6.render(f5);
    Shape2.render(f5);
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
