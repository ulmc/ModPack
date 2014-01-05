package ru.ulmc.extender.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBonesEmpty extends ModelBase implements SimpleUlmcModel {
	// fields
	ModelRenderer boneL0;
	ModelRenderer skull;
	ModelRenderer bone2;
	ModelRenderer bone4;
	ModelRenderer bone6;
	ModelRenderer boneL1;
	ModelRenderer boneL2;

	public ModelBonesEmpty() {
		textureWidth = 41;
		textureHeight = 45;

		boneL0 = new ModelRenderer(this, 0, 14);
		boneL0.addBox(0F, 0F, 0F, 4, 1, 1);
		boneL0.setRotationPoint(6F, 24F, 0F);
		boneL0.setTextureSize(41, 45);
		boneL0.mirror = true;
		setRotation(boneL0, 0F, -1.375609F, -0.2230717F);
		skull = new ModelRenderer(this, 0, 0);
		skull.addBox(-3F, -3F, -3F, 6, 5, 6);
		skull.setRotationPoint(-1F, 21F, 1F);
		skull.setTextureSize(41, 45);
		skull.mirror = true;
		setRotation(skull, 0.2230717F, 0.0174533F, 0F);
		bone2 = new ModelRenderer(this, 0, 13);
		bone2.addBox(-5F, 0F, -1F, 9, 2, 2);
		bone2.setRotationPoint(0F, 22F, 6F);
		bone2.setTextureSize(41, 45);
		bone2.mirror = true;
		setRotation(bone2, 0F, -0.1487144F, -0.3346075F);
		bone4 = new ModelRenderer(this, 0, 13);
		bone4.addBox(-6F, 0F, 0F, 9, 2, 2);
		bone4.setRotationPoint(-6.6F, 22.8F, -3.666667F);
		bone4.setTextureSize(41, 45);
		bone4.mirror = true;
		setRotation(bone4, 0.2788396F, 1.59868F, -0.2602503F);
		bone6 = new ModelRenderer(this, 0, 13);
		bone6.addBox(-4F, 0F, -1F, 8, 2, 2);
		bone6.setRotationPoint(2.8F, 23F, -4.6F);
		bone6.setTextureSize(41, 45);
		bone6.mirror = true;
		setRotation(bone6, 0F, -0.2602503F, 0.1487144F);
		boneL1 = new ModelRenderer(this, 0, 14);
		boneL1.addBox(0F, 0F, 0F, 4, 1, 1);
		boneL1.setRotationPoint(1F, 24F, 0F);
		boneL1.setTextureSize(41, 45);
		boneL1.mirror = true;
		setRotation(boneL1, 0F, -1.152537F, -0.3717861F);
		boneL2 = new ModelRenderer(this, 0, 14);
		boneL2.addBox(0F, 0F, 0F, 4, 1, 1);
		boneL2.setRotationPoint(4F, 24F, 0F);
		boneL2.setTextureSize(41, 45);
		boneL2.mirror = true;
		setRotation(boneL2, 0F, -1.226894F, -0.4833219F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		boneL0.render(f5);
		skull.render(f5);
		bone2.render(f5);
		bone4.render(f5);
		bone6.render(f5);
		boneL1.render(f5);
		boneL2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void render(float f5) {
		boneL0.render(f5);
		skull.render(f5);
		bone2.render(f5);
		bone4.render(f5);
		bone6.render(f5);
		boneL1.render(f5);
		boneL2.render(f5);
	}

}
