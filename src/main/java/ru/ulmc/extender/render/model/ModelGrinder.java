package ru.ulmc.extender.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ru.ulmc.extender.item.ItemGrind;
import ru.ulmc.extender.render.model.submodels.GrinderDisc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 45 on 25.10.2014.
 */
public class ModelGrinder extends ModelBase {
	private ModelRenderer leg1;
	private ModelRenderer leg2;
	private ModelRenderer leg3;
	private ModelRenderer leg4;
	private ModelRenderer stoneHolder;
	private ModelRenderer base;
	private ModelRenderer handle;
	private ModelRenderer handle1;
	private ModelRenderer hrStick1;
	private ModelRenderer hrStick2;
	private ModelRenderer hrStick3;
	private ModelRenderer hrStick5;

	private Map<Integer, GrinderDisc> discs = new HashMap<Integer, GrinderDisc>();

	public ModelGrinder() {
		textureWidth = 64;
		textureHeight = 64;

		leg1 = new ModelRenderer(this, 0, 0);
		leg1.addBox(-1F, 0F, -1F, 1, 13, 1);
		leg1.setRotationPoint(1F, 11F, 1F);
		leg1.setTextureSize(64, 64);
		leg1.mirror = true;
		setRotation(leg1, 0F, 2.356194F, 0.2617994F);
		leg2 = new ModelRenderer(this, 0, 0);
		leg2.addBox(-1F, 0F, 0F, 1, 13, 1);
		leg2.setRotationPoint(1F, 11F, -1F);
		leg2.setTextureSize(64, 64);
		leg2.mirror = true;
		setRotation(leg2, 0F, -2.356194F, 0.2617994F);
		leg3 = new ModelRenderer(this, 0, 0);
		leg3.addBox(-1F, 0F, 0F, 1, 13, 1);
		leg3.setRotationPoint(-1F, 11F, 1F);
		leg3.setTextureSize(64, 64);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0.7853982F, 0.2617994F);
		leg4 = new ModelRenderer(this, 0, 0);
		leg4.addBox(-1F, 0F, -1F, 1, 13, 1);
		leg4.setRotationPoint(-1F, 11F, -1F);
		leg4.setTextureSize(64, 64);
		leg4.mirror = true;
		setRotation(leg4, 0F, -0.7853982F, 0.2617994F);
		stoneHolder = new ModelRenderer(this, 5, 0);
		stoneHolder.addBox(0F, 0F, 0F, 1, 8, 1);
		stoneHolder.setRotationPoint(-0.7F, 11F, -3F);
		stoneHolder.setTextureSize(64, 64);
		stoneHolder.mirror = true;
		setRotation(stoneHolder, 1.570796F, 0F, 0.7853982F);
		base = new ModelRenderer(this, 8, 0);
		base.addBox(-5F, 0F, -5F, 10, 1, 10);
		base.setRotationPoint(0F, 23F, 0F);
		base.setTextureSize(64, 64);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		handle = new ModelRenderer(this, 0, 0);
		handle.addBox(0F, 0F, 0F, 1, 5, 1);
		handle.setRotationPoint(-0.5F, 11F, 4.1F);
		handle.setTextureSize(64, 64);
		handle.mirror = true;
		setRotation(handle, 0F, 0F, 0F);
		handle1 = new ModelRenderer(this, 10, 6);
		handle1.addBox(0F, 0F, 0F, 1, 1, 2);
		handle1.setRotationPoint(-0.5F, 15F, 5F);
		handle1.setTextureSize(64, 64);
		handle1.mirror = true;
		setRotation(handle1, 0F, 0F, 0F);
		handle.addChild(handle1);

		hrStick1 = new ModelRenderer(this, 0, 23);
		hrStick1.addBox(-2F, 0F, 0F, 4, 1, 1);
		hrStick1.setRotationPoint(0F, 17F, -3.5F);
		hrStick1.setTextureSize(64, 64);
		hrStick1.mirror = true;
		setRotation(hrStick1, 0F, 0F, 0F);
		hrStick2 = new ModelRenderer(this, 0, 23);
		hrStick2.addBox(0F, 0F, 0F, 4, 1, 1);
		hrStick2.setRotationPoint(-2F, 17F, 2.5F);
		hrStick2.setTextureSize(64, 64);
		hrStick2.mirror = true;
		setRotation(hrStick2, 0F, 0F, 0F);
		hrStick3 = new ModelRenderer(this, 0, 15);
		hrStick3.addBox(0F, 0F, -3F, 1, 1, 6);
		hrStick3.setRotationPoint(-3F, 18F, 0F);
		hrStick3.setTextureSize(64, 64);
		hrStick3.mirror = true;
		setRotation(hrStick3, 0F, 0F, 0F);
		hrStick5 = new ModelRenderer(this, 0, 15);
		hrStick5.addBox(0F, 0F, -3F, 1, 1, 6);
		hrStick5.setRotationPoint(2F, 18F, 0F);
		hrStick5.setTextureSize(64, 64);
		hrStick5.mirror = true;
		setRotation(hrStick5, 0F, 0F, 0F);


		setupGrinderStones();
	}

	private void setupGrinderStones() {
		discs.put(ItemGrind.ID_WOODEN,      new GrinderDisc(this, 15, 21, 15, 27));
		discs.put(ItemGrind.ID_COARSE,      new GrinderDisc(this, 15, 12, 15, 18));
		discs.put(ItemGrind.ID_IRON,        new GrinderDisc(this, 15, 30, 15, 36));
		discs.put(ItemGrind.ID_ENHANCED,    new GrinderDisc(this, 28, 21, 28, 27));
		discs.put(ItemGrind.ID_DIAMOND,     new GrinderDisc(this, 28, 12, 28, 18));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		render(f5, 0/*, 0, 0*/);
	}

	public void render(float f5, int type/*, float rotationDegreeHandle, float rotationDegreeDisc*/) {
		leg1.renderWithRotation(f5);
		leg2.renderWithRotation(f5);
		leg3.renderWithRotation(f5);
		leg4.renderWithRotation(f5);
		stoneHolder.render(f5);
		base.render(f5);
	//	setRotation(handle, 0F, 0F, handle.rotateAngleZ + degToRad(rotationDegreeHandle));
		handle.renderWithRotation(f5);
		handle1.render(f5);
		hrStick1.renderWithRotation(f5);
		hrStick2.renderWithRotation(f5);
		hrStick3.renderWithRotation(f5);
		hrStick5.renderWithRotation(f5);
		if(type > 0) {
			GrinderDisc disc = discs.get(type);
			if(disc != null) {
			/*	setRotation(disc, 0F, 0F, disc.rotateAngleZ + degToRad(rotationDegreeDisc));*/
				disc.render(f5);
			}
		}
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	protected float degToRad(float degrees)	{
		return degrees * (float)Math.PI / 180 ;
	}
}
