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
package ru.ulmc.extender.events;

import java.util.logging.Level;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.item.ItemManager;

public class MobDropEventsHook {
	
	private static final float baseDropRawLambMeat = 0.6F;
	private static final float baseDropPigFat = 0.5F;
	
	@ForgeSubscribe
	public void sheepDropFix(LivingDropsEvent event) {
				
		if(event.entityLiving instanceof EntitySheep) {
			int dropCount = getDropCount(event, baseDropRawLambMeat);
			dropItem(event.entityLiving, ItemManager.getItem("lambRawMeat"), dropCount);
			/*UltimateExtender.logger.info(	"event.lootingLevel: " + event.lootingLevel + 
											" | event.specialDropValue: " + event.specialDropValue + 
											" | dropCount: " + dropCount);*/
		}
		
	}
	
	@ForgeSubscribe
	public void pigLooseFat(LivingDropsEvent event) {				
		if(event.entityLiving instanceof EntityPig) {
			int dropCount = getDropCount(event, baseDropPigFat);
			dropItem(event.entityLiving, ItemManager.getItem("porkBelly"), dropCount);
		}
		
	}
	
	private int getDropCount(LivingDropsEvent event, float baseDrop){
		return
		Math.round(event.lootingLevel + baseDrop + (event.specialDropValue * baseDrop / 100));
	}
	
	private void dropItem(EntityLivingBase living, Item item, int count){
		if(item != null) {
			living.dropItem(item.itemID, count);
		} else {
			UltimateExtender.logger.log(Level.WARNING, "Can't find item to drop. Look into " + this.getClass().toString());
		}
	}

}
