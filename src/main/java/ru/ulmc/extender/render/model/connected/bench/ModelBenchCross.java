package ru.ulmc.extender.render.model.connected.bench;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ru.ulmc.extender.render.model.SimpleUlmcModel;

/**
 * Created by 45 on 15.10.2014.
 */
public class ModelBenchCross extends ModelBase implements SimpleUlmcModel {
	ModelRenderer sitting;
	ModelRenderer leg2;
	ModelRenderer leg4;
	ModelRenderer support2;
	ModelRenderer support1;
	ModelRenderer overlay;
	ModelRenderer sittingAddon;
	ModelRenderer overlayAddon;
	ModelRenderer support11;
	ModelRenderer support22;
	ModelRenderer sittingAddon2;
	ModelRenderer overlayAddon2;
	ModelRenderer support112;
	ModelRenderer leg1;
	ModelRenderer sittingAddon3;
	ModelRenderer overlayAddon3;
	ModelRenderer leg3;

	public ModelBenchCross() {
		textureWidth = 128;
		textureHeight = 128;
		sitting = new ModelRenderer(this, 0, 45);
		sitting.addBox(-6F, -1F, -6F, 12, 2, 14);
		sitting.setRotationPoint(0F, 16F, 0F);
		sitting.setTextureSize(128, 128);
		sitting.mirror = true;
		setRotation(sitting, 0F, 1.570796F, 0F);
		leg2 = new ModelRenderer(this, 0, 19);
		leg2.addBox(-1F, 0F, -1F, 2, 9, 2);
		leg2.setRotationPoint(-1.5F, 15.5F, -1.5F);
		leg2.setTextureSize(128, 128);
		leg2.mirror = true;
		setRotation(leg2, 0F, -0.7853982F, 0.2617994F);
		leg4 = new ModelRenderer(this, 18, 19);
		leg4.addBox(-1F, 0F, -1F, 2, 9, 2);
		leg4.setRotationPoint(-1.5F, 15.5F, 1.5F);
		leg4.setTextureSize(128, 128);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0.7853982F, 0.2617994F);
		support2 = new ModelRenderer(this, 0, 0);
		support2.addBox(0F, 0F, 0F, 1, 16, 1);
		support2.setRotationPoint(-8F, 21F, 3F);
		support2.setTextureSize(128, 128);
		support2.mirror = true;
		setRotation(support2, 1.570796F, 1.570796F, 0F);
		support1 = new ModelRenderer(this, 0, 0);
		support1.addBox(0F, 0F, 0F, 1, 16, 1);
		support1.setRotationPoint(-8F, 21F, -2F);
		support1.setTextureSize(128, 128);
		support1.mirror = true;
		setRotation(support1, 1.570796F, 1.570796F, 0F);
		overlay = new ModelRenderer(this, 46, 33);
		overlay.addBox(-5F, 0F, -5F, 13, 1, 10);
		overlay.setRotationPoint(0F, 14.5F, 0F);
		overlay.setTextureSize(128, 128);
		overlay.mirror = true;
		setRotation(overlay, 0F, 0F, 0F);
		sittingAddon = new ModelRenderer(this, 56, 0);
		sittingAddon.addBox(-1F, 0F, -6F, 2, 2, 12);
		sittingAddon.setRotationPoint(0F, 15F, 7F);
		sittingAddon.setTextureSize(128, 128);
		sittingAddon.mirror = true;
		setRotation(sittingAddon, 0F, 1.570796F, 0F);
		overlayAddon = new ModelRenderer(this, 46, 27);
		overlayAddon.addBox(-5F, 0F, -1F, 10, 1, 3);
		overlayAddon.setRotationPoint(0F, 14.5F, 6F);
		overlayAddon.setTextureSize(128, 128);
		overlayAddon.mirror = true;
		setRotation(overlayAddon, 0F, 0F, 0F);
		support22 = new ModelRenderer(this, 0, 0);
		support22.addBox(0F, 0F, 0F, 1, 16, 1);
		support22.setRotationPoint(2F, 21F, -8F);
		support22.setTextureSize(128, 128);
		support22.mirror = true;
		setRotation(support22, 1.570796F, 0F, 0F);
		sittingAddon2 = new ModelRenderer(this, 56, 0);
		sittingAddon2.addBox(0F, 0F, 0F, 2, 2, 12);
		sittingAddon2.setRotationPoint(-6F, 15F, -6F);
		sittingAddon2.setTextureSize(128, 128);
		sittingAddon2.mirror = true;
		setRotation(sittingAddon2, 0F, 1.570796F, 0F);
		overlayAddon2 = new ModelRenderer(this, 46, 27);
		overlayAddon2.addBox(0F, 0F, 0F, 10, 1, 3);
		overlayAddon2.setRotationPoint(-5F, 14.5F, -8F);
		overlayAddon2.setTextureSize(128, 128);
		overlayAddon2.mirror = true;
		setRotation(overlayAddon2, 0F, 0F, 0F);
		support112 = new ModelRenderer(this, 0, 0);
		support112.addBox(-3F, -8F, 0F, 1, 16, 1);
		support112.setRotationPoint(0F, 21F, 0F);
		support112.setTextureSize(128, 128);
		support112.mirror = true;
		setRotation(support112, 1.570796F, 0F, 0F);
		leg1 = new ModelRenderer(this, 0, 19);
		leg1.addBox(0F, 0F, 0F, 2, 9, 2);
		leg1.setRotationPoint(1.5F, 15.53333F, 2.5F);
		leg1.setTextureSize(128, 128);
		leg1.mirror = true;
		setRotation(leg1, 0F, 2.356194F, 0.2617994F);
		sittingAddon3 = new ModelRenderer(this, 56, 0);
		sittingAddon3.addBox(0F, 0F, 0F, 2, 2, 12);
		sittingAddon3.setRotationPoint(-8F, 15F, -6F);
		sittingAddon3.setTextureSize(128, 128);
		sittingAddon3.mirror = true;
		setRotation(sittingAddon3, 0F, 0F, 0F);
		overlayAddon3 = new ModelRenderer(this, 46, 27);
		overlayAddon3.addBox(0F, 0F, 0F, 10, 1, 3);
		overlayAddon3.setRotationPoint(-8F, 14.5F, 4.733333F);
		overlayAddon3.setTextureSize(128, 128);
		overlayAddon3.mirror = true;
		setRotation(overlayAddon3, 0F, 1.570796F, 0F);
		leg3 = new ModelRenderer(this, 0, 19);
		leg3.addBox(-1F, 0F, -1F, 2, 9, 2);
		leg3.setRotationPoint(1.5F, 15.5F, -2.5F);
		leg3.setTextureSize(128, 128);
		leg3.mirror = true;
		setRotation(leg3, 0F, -2.356194F, 0.2617994F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		render(f5);
	}

	public void render(float f5) {
		leg2.renderWithRotation(f5);
		leg4.renderWithRotation(f5);
		leg1.renderWithRotation(f5);
		leg3.renderWithRotation(f5);
		sitting.render(f5);
		support2.render(f5);
		support1.render(f5);
		overlay.render(f5);
		sittingAddon.render(f5);
		overlayAddon.render(f5);
		support22.render(f5);
		sittingAddon2.render(f5);
		overlayAddon2.render(f5);
		support112.render(f5);
		sittingAddon3.render(f5);
		overlayAddon3.render(f5);
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
