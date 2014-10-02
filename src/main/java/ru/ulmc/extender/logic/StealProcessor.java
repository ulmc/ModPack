package ru.ulmc.extender.logic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.container.ContainerThief;
import ru.ulmc.extender.exception.StealingException;
import ru.ulmc.extender.logic.model.StealModel;
import ru.ulmc.extender.network.ConfirmStealPacket;
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
	
	public static final int ROW_TOP = 4;
	public static final int ROW_MID = 3;
	public static final int ROW_BOTTOM = 2;
	public static final int ROW_BELT = 1;

	private static Map<String, StealModel> thiefMap = new HashMap<String, StealModel>();


	public void initStealing(EntityPlayer thief, EntityPlayer victim) {
		int aStr = victim.getTotalArmorValue(); aStr = aStr != 0 ? aStr : 1;
		double chance = MathHelper.getRandomIntegerInRange(victim.worldObj.rand, 10, 40) / aStr;
		thiefMap.put(thief.getDisplayName(), new StealModel(thief, victim));
	}

	public void attachContainer(String thiefName, ContainerThief container) {
		StealModel sm = thiefMap.get(thiefName);
		sm.setContainer(container);
	}

	public ConfirmStealPacket lookingForLoot(IntentStealPacket message) {
		UltimateExtender.logger.info("Trying to lookingForLoot: " + message.getThiefName() + " " + message.getStep() + " " + message.isAskingForLoot());
		ConfirmStealPacket clp = new ConfirmStealPacket();
		StealModel sm = thiefMap.get(message.getThiefName());
		if (sm == null || sm.getStep() != message.getStep()) {
			clp.setOk(false);
			clp.setDelta(9000000);
			UltimateExtender.logger.warn("Logic violation or unknown error (lookingForLoot). ThiefName: " +
					message.getThiefName()+" steps(S:C) " + (sm != null ? sm.getStep() : "null" )+ ":" + message.getStep());
		} else {
			int delta = sm.setupToken();
			clp.setDelta(delta);
			clp.setOk(true);
		}
		return clp;
	}

	public LootPacket getLoot(IntentStealPacket message) {
		UltimateExtender.logger.info("Trying to getLoot: " + message.getThiefName() + " " + message.getStep());
		StealModel sm = thiefMap.get(message.getThiefName());
		LootPacket lootPacket = new LootPacket();
		lootPacket.setSuccess(false);
		Date now = new Date();
		if (sm == null || sm.getStep() != message.getStep() || !sm.getApprovedTime().before(now)) {
			UltimateExtender.logger.warn("Logic violation or unknown error(getLoot). ThiefName: " +
					message.getThiefName() + " now: " + now + " waiting on: " + sm.getApprovedTime() +
					" steps(S:C) " + sm.getStep() + ":" + message.getStep() );
		}
		if (sm.getThief().getDistanceSqToEntity(sm.getVictim()) >= 5 || sm.getVictim() == null) {
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
		boolean belt = !cut || rand.nextFloat() < 0.1F * (5 - sm.getStep()); // пояс
		int row = cut ? ROW_BOTTOM : ( belt ? ROW_BELT : (sm.getStep() <= 3 ? ROW_TOP :( sm.getStep() <= 6 ? ROW_MID : ROW_BOTTOM)));
		int[] foundStacks = findLoot(row, sm.getVictim().inventory.mainInventory, rand);
		int stackId = foundStacks[MathHelper.getRandomIntegerInRange(rand, 0, 4)];
		Slot slot = sm.getVictim().inventoryContainer.getSlot(stackId + 9); // 4 armor + 4 craft + 1 result
		ItemStack loot = slot.getStack();
		ItemStack realLoot;
		if(loot == null) {
			lootPacket.setLoot(null);
			lootPacket.setSuccess(true);
			UltimateExtender.logger.info("got empty stack");
			return lootPacket;
		}
		/*if(loot.isStackable()) {
			realLoot = loot.splitStack(MathHelper.getRandomIntegerInRange(rand, 1, loot.stackSize));
			slot.putStack(null);
			slot.putStack(loot); // что-то не так с разделением не идет на клиент.
		} else {
			realLoot = loot.copy();
			slot.putStack(null);
		}*/
		realLoot = loot.copy();
		slot.putStack(null);
		sm.getVictim().inventory.markDirty();
		sm.getVictim().inventory.closeInventory();
		sm.getVictim().inventoryContainer.detectAndSendChanges();
		lootPacket.setLoot(realLoot);
		lootPacket.setSuccess(true);
		//Slot lootSlot = sm.getContainer().getSlot(sm.getStep());
		//lootSlot.putStack(realLoot);
		Slot targetSlot = sm.getContainer().getSlot(sm.getStep());
		targetSlot.putStack(realLoot);
		sm.getContainer().getVictimInventory().closeInventory();
		sm.getContainer().detectAndSendChanges();
		sm.setStep(sm.getStep() + 1);
		UltimateExtender.logger.info("Stealing: " + realLoot.getItem().getUnlocalizedName() + " " + realLoot.stackSize);
		return lootPacket;
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
}
