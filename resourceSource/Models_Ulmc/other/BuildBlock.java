// Date: 25.10.2014 20:00:06
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelBuildBlock extends ModelBase
{
  //fields
    ModelRenderer s16;
    ModelRenderer s14;
    ModelRenderer s14;
    ModelRenderer s13;
    ModelRenderer s12;
    ModelRenderer s11;
    ModelRenderer s10;
    ModelRenderer s9;
    ModelRenderer s8;
    ModelRenderer s7;
    ModelRenderer s6;
    ModelRenderer s5;
    ModelRenderer s4;
    ModelRenderer s3;
    ModelRenderer s2;
    ModelRenderer s1;
    ModelRenderer deck;
  
  public ModelBuildBlock()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      s16 = new ModelRenderer(this, 0, 0);
      s16.addBox(0F, 0F, 0F, 1, 16, 1);
      s16.setRotationPoint(6.9F, 8F, 6.9F);
      s16.setTextureSize(64, 32);
      s16.mirror = true;
      setRotation(s16, 0F, 0F, 0F);
      s14 = new ModelRenderer(this, 0, 0);
      s14.addBox(0F, 0F, 0F, 1, 16, 1);
      s14.setRotationPoint(-7.9F, 8F, 6.9F);
      s14.setTextureSize(64, 32);
      s14.mirror = true;
      setRotation(s14, 0F, 0F, 0F);
      s14 = new ModelRenderer(this, 0, 0);
      s14.addBox(0F, 0F, 0F, 1, 16, 1);
      s14.setRotationPoint(6.9F, 8F, -7.9F);
      s14.setTextureSize(64, 32);
      s14.mirror = true;
      setRotation(s14, 0F, 0F, 0F);
      s13 = new ModelRenderer(this, 0, 0);
      s13.addBox(0F, 0F, 0F, 1, 16, 1);
      s13.setRotationPoint(-7.9F, 8F, -7.9F);
      s13.setTextureSize(64, 32);
      s13.mirror = true;
      setRotation(s13, 0F, 0F, 0F);
      s12 = new ModelRenderer(this, 5, 0);
      s12.addBox(0F, 0F, 0F, 1, 14, 2);
      s12.setRotationPoint(-7F, 25F, 8F);
      s12.setTextureSize(64, 32);
      s12.mirror = true;
      setRotation(s12, 1.570796F, 1.570796F, 0F);
      s11 = new ModelRenderer(this, 5, 0);
      s11.addBox(0F, 0F, 0F, 1, 14, 2);
      s11.setRotationPoint(7F, 23F, -7F);
      s11.setTextureSize(64, 32);
      s11.mirror = true;
      setRotation(s11, -1.570796F, 1.570796F, 0F);
      s10 = new ModelRenderer(this, 5, 0);
      s10.addBox(0F, 0F, 0F, 1, 14, 2);
      s10.setRotationPoint(-8F, 25F, -7F);
      s10.setTextureSize(64, 32);
      s10.mirror = true;
      setRotation(s10, 1.570796F, 0F, 0F);
      s9 = new ModelRenderer(this, 5, 0);
      s9.addBox(0F, 0F, 0F, 1, 14, 2);
      s9.setRotationPoint(7F, 25F, -7F);
      s9.setTextureSize(64, 32);
      s9.mirror = true;
      setRotation(s9, 1.570796F, 0F, 0F);
      s8 = new ModelRenderer(this, 0, 0);
      s8.addBox(0F, 0F, 0F, 1, 20, 1);
      s8.setRotationPoint(7F, 8F, -7.5F);
      s8.setTextureSize(64, 32);
      s8.mirror = true;
      setRotation(s8, 0F, 0F, 0.7853982F);
      s7 = new ModelRenderer(this, 0, 0);
      s7.addBox(0F, 0F, 1F, 1, 21, 1);
      s7.setRotationPoint(-8F, 9F, -8F);
      s7.setTextureSize(64, 32);
      s7.mirror = true;
      setRotation(s7, 0F, 0F, -0.7853982F);
      s6 = new ModelRenderer(this, 0, 0);
      s6.addBox(0F, 0F, 0F, 1, 21, 1);
      s6.setRotationPoint(-7.5F, 9F, -8F);
      s6.setTextureSize(64, 32);
      s6.mirror = true;
      setRotation(s6, 0.7853982F, 0F, 0F);
      s5 = new ModelRenderer(this, 0, 0);
      s5.addBox(0F, 0F, 0F, 1, 20, 1);
      s5.setRotationPoint(-6F, 9F, 7F);
      s5.setTextureSize(64, 32);
      s5.mirror = true;
      setRotation(s5, 0.7853982F, 3.141593F, 0F);
      s4 = new ModelRenderer(this, 0, 0);
      s4.addBox(0F, 0F, 0F, 1, 21, 1);
      s4.setRotationPoint(-8F, 9F, 6F);
      s4.setTextureSize(64, 32);
      s4.mirror = true;
      setRotation(s4, 0F, 0F, -0.7853982F);
      s3 = new ModelRenderer(this, 0, 0);
      s3.addBox(0F, 0F, 0F, 1, 20, 1);
      s3.setRotationPoint(7F, 8F, 6.5F);
      s3.setTextureSize(64, 32);
      s3.mirror = true;
      setRotation(s3, 0F, 0F, 0.7853982F);
      s2 = new ModelRenderer(this, 0, 0);
      s2.addBox(0F, 0F, 0F, 1, 21, 1);
      s2.setRotationPoint(6.5F, 9F, -8F);
      s2.setTextureSize(64, 32);
      s2.mirror = true;
      setRotation(s2, 0.7853982F, 0F, 0F);
      s1 = new ModelRenderer(this, 0, 0);
      s1.addBox(0F, 0F, 0F, 1, 20, 1);
      s1.setRotationPoint(7F, 9F, 7F);
      s1.setTextureSize(64, 32);
      s1.mirror = true;
      setRotation(s1, 0.7853982F, 3.141593F, 0F);
      deck = new ModelRenderer(this, 12, 0);
      deck.addBox(-8F, -8F, 0F, 16, 16, 1);
      deck.setRotationPoint(0F, 8F, 0F);
      deck.setTextureSize(64, 32);
      deck.mirror = true;
      setRotation(deck, 1.570796F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    s16.render(f5);
    s14.render(f5);
    s14.render(f5);
    s13.render(f5);
    s12.render(f5);
    s11.render(f5);
    s10.render(f5);
    s9.render(f5);
    s8.render(f5);
    s7.render(f5);
    s6.render(f5);
    s5.render(f5);
    s4.render(f5);
    s3.render(f5);
    s2.render(f5);
    s1.render(f5);
    deck.render(f5);
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
