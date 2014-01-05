package ru.ulmc.extender.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBonesM extends ModelBase implements SimpleUlmcModel {
	// fields
	ModelRenderer bone;
	ModelRenderer chest;
	ModelRenderer bone4;
	ModelRenderer bone6;
	ModelRenderer bone9;
	ModelRenderer skull;

	public ModelBonesM() {
		textureWidth = 41;
		textureHeight = 45;

		bone = new ModelRenderer(this, 0, 13);
		bone.addBox(-4F, 0F, 0F, 8, 2, 2);
		bone.setRotationPoint(4F, 23F, -4F);
		bone.setTextureSize(41, 45);
		bone.mirror = true;
		setRotation(bone, 0F, -1.07818F, -0.2974289F);
		chest = new ModelRenderer(this, 0, 16);
		chest.addBox(-4F, -8F, -2F, 7, 9, 3);
		chest.setRotationPoint(0.8666667F, 23F, 2.666667F);
		chest.setTextureSize(41, 45);
		chest.mirror = true;
		setRotation(chest, -0.3717861F, 0.4461433F, 0F);
		bone4 = new ModelRenderer(this, 0, 13);
		bone4.addBox(-5F, -1F, 0F, 9, 2, 2);
		bone4.setRotationPoint(-4.6F, 19.8F, 4.333333F);
		bone4.setTextureSize(41, 45);
		bone4.mirror = true;
		setRotation(bone4, -0.3531968F, 0.1673038F, -1.449966F);
		bone6 = new ModelRenderer(this, 0, 13);
		bone6.addBox(-5F, 0F, 0F, 10, 2, 2);
		bone6.setRotationPoint(-6.2F, 23F, -2.6F);
		bone6.setTextureSize(41, 45);
		bone6.mirror = true;
		setRotation(bone6, 0F, 1.487144F, 0.2056184F);
		bone9 = new ModelRenderer(this, 0, 13);
		bone9.addBox(-4F, -1F, -1F, 8, 2, 2);
		bone9.setRotationPoint(6F, 20F, 3F);
		bone9.setTextureSize(41, 45);
		bone9.mirror = true;
		setRotation(bone9, 0F, -0.0743572F, 1.394198F);
		skull = new ModelRenderer(this, 0, 0);
		skull.addBox(-3F, -3F, -3F, 6, 5, 6);
		skull.setRotationPoint(2F, 13F, 5F);
		skull.setTextureSize(41, 45);
		skull.mirror = true;
		setRotation(skull, -0.2602503F, 0.2974289F, 0.1115358F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		bone.render(f5);
		chest.render(f5);
		bone4.render(f5);
		bone6.render(f5);
		bone9.render(f5);
		skull.render(f5);
	}

	public void render(float f5) {
		bone.render(f5);
		chest.render(f5);
		bone4.render(f5);
		bone6.render(f5);
		bone9.render(f5);
		skull.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
