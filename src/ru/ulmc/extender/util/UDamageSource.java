/**
 * Copyright (C) 2014 Kolmogorov Alexey
 * 
 * This file part of ulmc.ru ModPack
 * 
 * ulmc.ru ModPack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ulmc.ru ModPack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/].
 * 
 */
package ru.ulmc.extender.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import ru.ulmc.extender.UltimateExtender;

public class UDamageSource extends DamageSource {
	public static DamageSource cold = (new UDamageSource("cold")).setDamageBypassesArmor();
	public static DamageSource hot = (new UDamageSource("hot")).setDamageBypassesArmor();
	protected UDamageSource(String par1Str) {
		super(par1Str);

	}

    public ChatMessageComponent getDeathMessage(EntityLivingBase par1EntityLivingBase)
    {
        EntityLivingBase eLiving = par1EntityLivingBase.func_94060_bK();
        String key = "death.attack." + this.damageType;
        String localizedMessage = UltimateExtender.loc(key);        if(localizedMessage != null) {

            return ChatMessageComponent.createFromText(localizedMessage.replace("{player}", par1EntityLivingBase.getTranslatedEntityName()));
        }
        return ChatMessageComponent.createFromTranslationWithSubstitutions(key);

    }

}
