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
package ru.ulmc.extender.logic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.container.ContainerThief;
import ru.ulmc.extender.container.LootInventory;
import ru.ulmc.extender.container.LootSlot;
import ru.ulmc.extender.gui.GuiThief;
import ru.ulmc.extender.logic.model.StealModel;
import ru.ulmc.extender.network.IntentStealPacket;
import ru.ulmc.extender.network.LootPacket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by 45 on 30.09.2014.
 * Отвечает за воровской механизм.
 */
public class StealProcessor {
	
	public static final int ROW_TOP = 1;
	public static final int ROW_MID = 2;
	public static final int ROW_BOTTOM = 3;
	public static final int ROW_BELT = 4;

	//server-side;
	private Map<String, StealModel> thiefMap = new HashMap<String, StealModel>();
	//client-side
	private ContainerThief clientContainer;
	private GuiThief gui;

	public void initStealing(EntityPlayer thief, EntityPlayer victim) {
		int aStr = victim.getTotalArmorValue(); aStr = aStr != 0 ? aStr : 1;
		double chance = MathHelper.getRandomIntegerInRange(victim.worldObj.rand, 10, 40) / aStr;
		thiefMap.put(thief.getDisplayName(), new StealModel(thief, victim));
	}

	public void attachContainer(String thiefName, ContainerThief container) {
		StealModel sm = thiefMap.get(thiefName);
		sm.setContainer(container);
	}

	public LootPacket lookingForLoot(IntentStealPacket message) {
		UltimateExtender.logger.info("Trying to lookingForLoot: " + message.getThiefName() + " " + message.getStep() + " " + message.isAskingForLoot());
		LootPacket clp = new LootPacket();
		clp.setSnoop(true);
		StealModel sm = thiefMap.get(message.getThiefName());
		if (sm == null || sm.getStep() != message.getStep()) {
			clp.setSuccess(false);
			clp.setDelta(9000000);
			UltimateExtender.logger.warn("Logic violation or unknown error (lookingForLoot). ThiefName: " +
					message.getThiefName()+" steps(S:C) " + (sm != null ? sm.getStep() : "null" )+ ":" + message.getStep());
		} else {
			int delta = sm.setupToken();
			clp.setDelta(delta);
			clp.setSuccess(true);
		}
		return clp;
	}

	public LootPacket getLoot(IntentStealPacket message) {
		UltimateExtender.logger.info("Trying to getLoot: " + message.getThiefName() + " " + message.getStep());
		StealModel sm = thiefMap.get(message.getThiefName());
		LootPacket lootPacket = new LootPacket();
		lootPacket.setSuccess(false);
		lootPacket.setSnoop(false);
		Date now = new Date();
		if (sm == null || sm.getStep() != message.getStep() || !sm.getApprovedTime().before(now)) {
			UltimateExtender.logger.warn("Logic violation or unknown error(getLoot). ThiefName: " +
					message.getThiefName() + " now: " + now + " waiting on: " + sm.getApprovedTime() +
					" steps(S:C) " + sm.getStep() + ":" + message.getStep() );
			return lootPacket;
		}
		if (sm.getThief().getDistanceSqToEntity(sm.getVictim()) >= 16.0D || sm.getVictim() == null) {
			UltimateExtender.logger.info("Distance");
			return lootPacket;
		}
		double failChance = sm.getVictim().getTotalArmorValue() * 0.005f + 0.01;
		Random rand = sm.getThief().getEntityWorld().rand;
		if (rand.nextDouble() < failChance) {
			lootPacket.setShouldNotify(true);
			thiefMap.remove(sm.getThief().getDisplayName()); // Пока так.
			UltimateExtender.logger.info("fail");
			return lootPacket;
		}
		boolean cut = rand.nextFloat() < 0.1F; // подрезка
		boolean belt = !cut && rand.nextFloat() < 0.1F * (5 - sm.getStep()); // пояс
		int row = cut ? ROW_BOTTOM : ( belt ? ROW_BELT : (sm.getStep() <= 2 ? ROW_TOP :( sm.getStep() <= 5 ? ROW_MID : ROW_BOTTOM)));
		UltimateExtender.logger.info("isCut|belt|row: " + cut + " " + belt + " " + row);
		int[] foundStacks = findLoot(row, sm.getVictim().inventory.mainInventory, rand);
		int stackId = foundStacks[MathHelper.getRandomIntegerInRange(rand, 0, 4)];
		Slot slot = sm.getVictim().inventoryContainer.getSlot(stackId + 9); // 4 armor + 4 craft + 1 result
		ItemStack loot = slot.getStack();
		ItemStack realLoot;
		if(loot == null) {
			lootPacket.setSuccess(true);
			lootPacket.setEmptyLoot(true);
			lootPacket.setStep(sm.getStep()+1);
			UltimateExtender.logger.info("got empty stack");
			return lootPacket;
		}
		if(loot.isStackable()) {
			int startQuantity = loot.getMaxStackSize() < 32? loot.stackSize/2 : loot.stackSize/3;
			startQuantity = startQuantity > 0 ? startQuantity : 1;
			realLoot = loot.splitStack(MathHelper.getRandomIntegerInRange(rand, startQuantity, loot.stackSize));
			slot.putStack(loot); // что-то не так с разделением не идет на клиент.
		} else {
			realLoot = loot.copy();
			slot.putStack(null);
		}
		sm.getVictim().inventoryContainer.detectAndSendChanges();
		Slot targetSlot = sm.getContainer().getSlot(sm.getStep());
		targetSlot.putStack(realLoot);
		sm.getContainer().detectAndSendChanges();
		sm.setStep(sm.getStep() + 1);
		lootPacket.setSuccess(true);
		lootPacket.setStep(sm.getStep());
		UltimateExtender.logger.info("Stealing: " + realLoot.getItem().getUnlocalizedName() + " " + realLoot.stackSize);
		return lootPacket;
	}

	public void handleLootPacket(LootPacket msg) {
		if(msg.isSuccess()) {
			if (gui != null) {
				/*clientContainer.getSlot(msg.getStep()).putStack(msg.getLoot()); // как-то так
				LootInventory li = clientContainer.getLootInventory();
				li.setInventorySlotContents(msg.getStep(), msg.getLoot());
				((LootSlot)clientContainer.getSlot(msg.getStep())).setEmpty(msg.getLoot() == null);
				ItemStack is = li.getStackInSlot(msg.getStep());
				clientContainer.detectAndSendChanges();
				gui.updateScreen();*/
				gui.setStep(msg.getStep());
				if(msg.isEmptyLoot()) {
					gui.setFailedID(msg.getStep());
				}
			} else {
				UltimateExtender.logger.error("Why is clientContainer NULL at handleLootPacket? That's crappy");
			}
		} else {
			//clientContainer.onContainerClosed(gui.getPlayer());
			gui.setTotallyFailed(true);
		}
	}

	private int[] findLoot(int row, ItemStack[] inv, Random rand) {
		int start = (row - 1) * 9; int end = row * 9;
		int[] foundStacksIds = new int[5];
		int foundId = 0;
		boolean allNulls = true;
		for (int i = start; i < end; i++) {
			if(foundId >= foundStacksIds.length-1) {
				if(allNulls && row < 4) {
					return findLoot(row+1, inv, rand);
				} else {
					return foundStacksIds;
				}
			}
			if (rand.nextBoolean()) {
				foundStacksIds[foundId++] = i;
				if(inv[i] != null) {
					allNulls = false;
				}
			}
		}
		if (foundId != foundStacksIds.length-1 && allNulls && row < 4) {
			return findLoot(row+1, inv, rand);
		}
		return foundStacksIds;
	}

	public void setClientContainer(ContainerThief clientContainer) {
		this.clientContainer = clientContainer;
	}

	public void setGui(GuiThief gui) {
		this.gui = gui;
	}
}
