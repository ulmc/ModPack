package ru.ulmc.extender.render.model.submodels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * Created by 45 on 25.10.2014.
 */
public class GrinderDisc extends ModelRenderer {
	private ModelRenderer d1;
	private ModelRenderer d2;
	private ModelRenderer d3;
	private ModelRenderer d4;
	private ModelRenderer d5;

	public GrinderDisc(ModelBase grind, int mainTextureX, int mainTextureY, int subTextureX, int subTextureY) {
		super(grind, 0, 0);
		d1 = new ModelRenderer(grind, mainTextureX, mainTextureY);
		d1.addBox(0F, 0F, 0F, 5, 5, 1);
		d1.setRotationPoint(-2.5F, 8.5F, -0.5F);
		d1.setTextureSize(64, 64);
		d1.mirror = true;
		setRotation(d1, 0F, 0F, 0F);
		d2 = new ModelRenderer(grind, subTextureX, subTextureY);
		d2.addBox(0F, 0F, 0F, 3, 1, 1);
		d2.setRotationPoint(-1.5F, 7.5F, -0.5F);
		d2.setTextureSize(64, 64);
		d2.mirror = true;
		setRotation(d2, 0F, 0F, 0F);
		d3 = new ModelRenderer(grind, subTextureX, subTextureY);
		d3.addBox(0F, 0F, 0F, 3, 1, 1);
		d3.setRotationPoint(-2.5F, 9.5F, -0.5F);
		d3.setTextureSize(64, 64);
		d3.mirror = true;
		setRotation(d3, 0F, 0F, 1.570796F);
		d4 = new ModelRenderer(grind, subTextureX, subTextureY);
		d4.addBox(0F, 0F, 0F, 3, 1, 1);
		d4.setRotationPoint(3.5F, 9.5F, -0.5F);
		d4.setTextureSize(64, 64);
		d4.mirror = true;
		setRotation(d4, 0F, 0F, 1.570796F);
		d5 = new ModelRenderer(grind, subTextureX, subTextureY);
		d5.addBox(0F, 0F, 0F, 3, 1, 1);
		d5.setRotationPoint(-1.5F, 13.5F, -0.5F);
		d5.setTextureSize(64, 64);
		d5.mirror = true;
		setRotation(d5, 0F, 0F, 0F);
		this.addChild(d1);
		this.addChild(d2);
		this.addChild(d3);
		this.addChild(d4);
		this.addChild(d5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
