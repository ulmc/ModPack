package ru.ulmc.extender.util;

import net.minecraft.util.DamageSource;

public class UDamageSource extends DamageSource {
	public static DamageSource cold = (new UDamageSource("cold")).setDamageBypassesArmor();
	public static DamageSource hot = (new UDamageSource("hot")).setDamageBypassesArmor();
	protected UDamageSource(String par1Str) {
		super(par1Str);
		
	}

}
