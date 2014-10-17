package ru.ulmc.extender.render.model.connected.table;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ru.ulmc.extender.render.model.SimpleUlmcModel;

/**
 * Created by 45 on 15.10.2014.
 */
public class ModelTableDoubleSided extends ModelBase implements SimpleUlmcModel {
	ModelRenderer main;
	ModelRenderer additional;
	ModelRenderer leg2;
	ModelRenderer leg21;
	ModelRenderer leg4;
	ModelRenderer leg41;
	ModelRenderer base2;
	ModelRenderer stif21;
	ModelRenderer base4;
	ModelRenderer stif41;

	public ModelTableDoubleSided() {
		textureWidth = 64;
		textureHeight = 32;

		main = new ModelRenderer(this, 0, 0);
		main.addBox(-8F, 0F, -8F, 16, 1, 16);
		main.setRotationPoint(0F, 9F, 0F);
		main.setTextureSize(64, 32);
		main.mirror = true;
		setRotation(main, 0F, 0F, 0F);
		additional = new ModelRenderer(this, 3, 0);
		additional.addBox(-6.5F, 1F, -8F, 13, 1, 16);
		additional.setRotationPoint(0F, 9F, 0F);
		additional.setTextureSize(64, 32);
		additional.mirror = true;
		setRotation(additional, 0F, 1.570796F, 0F);
		leg2 = new ModelRenderer(this, 0, 18);
		leg2.addBox(-6F, 2F, -6F, 1, 13, 1);
		leg2.setRotationPoint(5F, 9F, 0F);
		leg2.setTextureSize(64, 32);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg21 = new ModelRenderer(this, 16, 18);
		leg21.addBox(-6.6F, 2F, -5.6F, 2, 13, 1);
		leg21.setRotationPoint(5F, 9F, 0F);
		leg21.setTextureSize(64, 32);
		leg21.mirror = true;
		setRotation(leg21, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 18);
		leg4.addBox(-6F, 2F, 5F, 1, 13, 1);
		leg4.setRotationPoint(5F, 9F, 0F);
		leg4.setTextureSize(64, 32);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		leg41 = new ModelRenderer(this, 16, 18);
		leg41.addBox(-6.6F, 2F, 4.6F, 2, 13, 1);
		leg41.setRotationPoint(5F, 9F, 0F);
		leg41.setTextureSize(64, 32);
		leg41.mirror = true;
		setRotation(leg41, 0F, 0F, 0F);
		base2 = new ModelRenderer(this, 6, 28);
		base2.addBox(-6.5F, 0.5F, -6.8F, 2, 2, 2);
		base2.setRotationPoint(5F, 9F, 0F);
		base2.setTextureSize(64, 32);
		base2.mirror = true;
		setRotation(base2, 0F, 0F, 0F);
		stif21 = new ModelRenderer(this, 6, 24);
		stif21.addBox(-6F, -5F, -6.3F, 1, 2, 1);
		stif21.setRotationPoint(5F, 9F, 0F);
		stif21.setTextureSize(64, 32);
		stif21.mirror = true;
		setRotation(stif21, 0.7853982F, 0F, 0F);
		base4 = new ModelRenderer(this, 6, 28);
		base4.addBox(-6.5F, 0.5F, 4.8F, 2, 2, 2);
		base4.setRotationPoint(5F, 9F, 0F);
		base4.setTextureSize(64, 32);
		base4.mirror = true;
		setRotation(base4, 0F, 0F, 0F);
		stif41 = new ModelRenderer(this, 6, 24);
		stif41.addBox(-6F, -5F, 5.3F, 1, 2, 1);
		stif41.setRotationPoint(5F, 9F, 0F);
		stif41.setTextureSize(64, 32);
		stif41.mirror = true;
		setRotation(stif41, -0.7853982F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		render(f5);
	}

	public void render(float f5) {
		main.render(f5);
		additional.render(f5);
		main.render(f5);
		additional.render(f5);
		leg2.render(f5);
		leg21.render(f5);
		leg4.render(f5);
		leg41.render(f5);
		base2.render(f5);
		stif21.render(f5);
		base4.render(f5);
		stif41.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	protected float degToRad(float degrees)	{
		return degrees * (float)Math.PI / 180 ;
	}
  /*
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }
*/
}
