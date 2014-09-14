/**
 * Copyright (C) 2014 ulmc.ru (Alex K.)
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

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.item.ItemKey;
import ru.ulmc.extender.item.ItemManager;
import ru.ulmc.extender.item.ItemPicklock;

import java.util.Random;
import java.util.logging.Level;

public class MobDropEventsHook {
	private static Random random = new Random();
	private static final float baseDropRawLambMeat = 0.6F;
	private static final float baseDropPigFat = 0.5F;
	private static final float chanseDropEpicKey = 0.01F;
	private static final float chanseDropEpicPicklock = 0.01F;

	@SubscribeEvent
	public void sheepDropFix(LivingDropsEvent event) {
				
		if(event.entityLiving instanceof EntitySheep) {
			int dropCount = getDropCount(event, baseDropRawLambMeat);
			dropItem(event.entityLiving, ItemManager.getItem("lambRawMeat"), dropCount);
			/*UltimateExtender.logger.info(	"event.lootingLevel: " + event.lootingLevel + 
											" | event.specialDropValue: " + event.specialDropValue + 
											" | dropCount: " + dropCount);*/
		}
		
	}
	
	@SubscribeEvent
	public void pigLooseFat(LivingDropsEvent event) {				
		if(event.entityLiving instanceof EntityPig) {
			int dropCount = getDropCount(event, baseDropPigFat);
			dropItem(event.entityLiving, ItemManager.getItem("porkBelly"), dropCount);
		}
		
	}

    @SubscribeEvent
    public void epicLoot(LivingDropsEvent event) {
        if(event.entityLiving instanceof EntitySkeleton) {
            if(random.nextFloat()/(event.specialDropValue*0.5f) < chanseDropEpicKey) {
                dropItemStack(event, ItemManager.getEpicItem(ItemKey.class));
            } else if(random.nextFloat()/(event.specialDropValue*0.5f)  < chanseDropEpicPicklock) {
                dropItemStack(event, ItemManager.getEpicItem(ItemPicklock.class));
            }
        }

    }
	
	private int getDropCount(LivingDropsEvent event, float baseDrop){
		return
		Math.round(event.lootingLevel + baseDrop + (event.specialDropValue * baseDrop / 100));
	}
	
	private void dropItem(EntityLivingBase living, Item item, int count){
		if(item != null) {
			living.dropItem(item, count);
		} else {
			UltimateExtender.logger.error("Can't find item to drop. Look into " + this.getClass().toString());
		}
	}

    private void dropItemStack(LivingDropsEvent event, ItemStack itemStack){
        event.drops.add(new EntityItem( event.entity.worldObj, event.entityLiving.posX,
                                        event.entityLiving.posY, event.entityLiving.posZ,
                                        itemStack));
    }

}
