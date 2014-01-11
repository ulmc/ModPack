package ru.ulmc.extender.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCartBody extends ModelBase implements SimpleUlmcModel {
	// fields
	ModelRenderer Axis1;
	ModelRenderer Axis2;
	ModelRenderer Side1;
	ModelRenderer Side2;
	ModelRenderer Down;
	ModelRenderer Front;
	ModelRenderer Binding1;
	ModelRenderer Binding2;
	ModelRenderer Stick1;
	ModelRenderer Stick2;

	public ModelCartBody() {
		textureWidth = 128;
		textureHeight = 64;

		Axis1 = new ModelRenderer(this, 0, 30);
		Axis1.addBox(0F, 0F, 0F, 23, 1, 1);
		Axis1.setRotationPoint(-0.5F, 15.5F, 19.4F);
		Axis1.setTextureSize(128, 64);
		Axis1.mirror = true;
		setRotation(Axis1, 0F, 1.570796F, 0F);
		Axis2 = new ModelRenderer(this, 0, 30);
		Axis2.addBox(0F, 0F, 0F, 23, 1, 1);
		Axis2.setRotationPoint(-0.7F, 16F, 19.4F);
		Axis2.setTextureSize(128, 64);
		Axis2.mirror = true;
		setRotation(Axis2, 0.7853982F, 1.570796F, 0F);
		Side1 = new ModelRenderer(this, 63, 3);
		Side1.addBox(0F, 0F, 0F, 18, 6, 1);
		Side1.setRotationPoint(-8F, 6F, -0.5F);
		Side1.setTextureSize(128, 64);
		Side1.mirror = true;
		setRotation(Side1, 0F, 0F, 0.3490659F);
		Side2 = new ModelRenderer(this, 63, 3);
		Side2.addBox(0F, 0F, 0F, 18, 6, 1);
		Side2.setRotationPoint(-8F, 6F, 15.5F);
		Side2.setTextureSize(128, 64);
		Side2.mirror = true;
		setRotation(Side2, 0F, 0F, 0.3490659F);
		Down = new ModelRenderer(this, 0, 47);
		Down.addBox(0F, 0F, 0F, 18, 1, 16);
		Down.setRotationPoint(-10F, 11.5F, 0F);
		Down.setTextureSize(128, 64);
		Down.mirror = true;
		setRotation(Down, 0F, 0F, 0.3490659F);
		Front = new ModelRenderer(this, 72, 40);
		Front.addBox(0F, 0F, 0F, 1, 8, 16);
		Front.setRotationPoint(9.1F, 10.1F, 0F);
		Front.setTextureSize(128, 64);
		Front.mirror = true;
		setRotation(Front, 0F, 0F, 0.3490659F);
		Binding1 = new ModelRenderer(this, 27, 0);
		Binding1.addBox(0F, 0F, 0F, 3, 1, 2);
		Binding1.setRotationPoint(-1.2F, 15.7F, 13.7F);
		Binding1.setTextureSize(128, 64);
		Binding1.mirror = true;
		setRotation(Binding1, 0F, 0F, 0.3490659F);
		Binding2 = new ModelRenderer(this, 27, 0);
		Binding2.addBox(0F, 0F, 0F, 3, 1, 2);
		Binding2.setRotationPoint(-1.2F, 15.7F, 0.3F);
		Binding2.setTextureSize(128, 64);
		Binding2.mirror = true;
		setRotation(Binding2, 0F, 0F, 0.3490659F);
		Stick1 = new ModelRenderer(this, 64, 0);
		Stick1.addBox(0F, 0F, 0F, 31, 1, 1);
		Stick1.setRotationPoint(-8F, 13F, 14.7F);
		Stick1.setTextureSize(128, 64);
		Stick1.mirror = true;
		setRotation(Stick1, 0F, 0.0698132F, 0.3490659F);
		Stick2 = new ModelRenderer(this, 64, 0);
		Stick2.addBox(0F, 0F, 0F, 31, 1, 1);
		Stick2.setRotationPoint(-8F, 13F, 0.2F);
		Stick2.setTextureSize(128, 64);
		Stick2.mirror = true;
		setRotation(Stick2, 0F, -0.0698132F, 0.3490659F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Axis1.render(f5);
		Axis2.render(f5);
		Side1.render(f5);
		Side2.render(f5);
		Down.render(f5);
		Front.render(f5);
		Binding1.render(f5);
		Binding2.render(f5);
		Stick1.render(f5);
		Stick2.render(f5);
	}

	public void render(float f5) {
		Axis1.render(f5);
		Axis2.render(f5);
		Side1.render(f5);
		Side2.render(f5);
		Down.render(f5);
		Front.render(f5);
		Binding1.render(f5);
		Binding2.render(f5);
		Stick1.render(f5);
		Stick2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}