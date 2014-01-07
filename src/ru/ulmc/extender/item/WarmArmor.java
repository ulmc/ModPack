package ru.ulmc.extender.item;

import ru.ulmc.extender.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class WarmArmor extends ItemArmor implements IWarmArmor {
	private static final int maxDamageArray[] = {11, 16, 15, 13};
	public final int damageReduceAmount;
	private final EnumWarmMaterial material;
	private String textureNameTop;
	private String textureNameBottom;
	private boolean isLegs;

	public WarmArmor(int itemID, EnumWarmMaterial material, 
			int renderIndex, int armorType, String aName, boolean isLegs) {
		super(itemID, EnumArmorMaterial.IRON, renderIndex, armorType);
		this.material = material;
		damageReduceAmount = material.getDamageReductionAmount(armorType);
		setMaxDamage(material.getDurability(armorType));
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName(aName);
		setTextureName(Reference.RES_NAME + aName);
		this.isLegs = isLegs;
		textureNameTop = Reference.RES_NAME + "textures/armor/" + material.name().toLowerCase() + "-top.png";
		textureNameBottom = Reference.RES_NAME + "textures/armor/" + material.name().toLowerCase() + "-bottom.png";
	}

	public int getItemEnchantability() {
		return material.getEnchantability();
	}

	static int[] getMaxDamageArray() {
		return maxDamageArray;
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		if (!isLegs) {
			return textureNameTop;
		} else {
			return textureNameBottom;
		} 
	}

	@Override
	public float getWarmLevel() {		
		return material.getWarmLevel();
	}

}
