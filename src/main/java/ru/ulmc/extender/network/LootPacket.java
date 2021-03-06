/*
 * Copyright (C) 2014. ulmc.ru (Alex K.)
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
 */

package ru.ulmc.extender.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.gui.GuiThief;

/**
 * Created by 45 on 01.10.2014.
 */
public class LootPacket implements IMessage {
	//private ItemStack loot = null;
	private int step = 1;
	private int delta = 1;
	private boolean isSuccess = false;
	private boolean shouldNotify = false;
	private boolean isSnoop = false;
	private boolean isEmptyLoot = false;

	public LootPacket() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		//loot = ByteBufUtils.readItemStack(buf);
		step = ByteBufUtils.readVarShort(buf);
		delta = ByteBufUtils.readVarInt(buf, 4);
		isSuccess = ByteBufUtils.readVarShort(buf) == 1;
		shouldNotify = ByteBufUtils.readVarShort(buf) == 1;
		isSnoop = ByteBufUtils.readVarShort(buf) == 1;
		isEmptyLoot = ByteBufUtils.readVarShort(buf) == 1;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		//ByteBufUtils.writeItemStack(buf, loot);
		ByteBufUtils.writeVarShort(buf, step);
		ByteBufUtils.writeVarInt(buf, delta, 4);
		ByteBufUtils.writeVarShort(buf, isSuccess ? 1 : 0);
		ByteBufUtils.writeVarShort(buf, shouldNotify ? 1 : 0);
		ByteBufUtils.writeVarShort(buf, isSnoop ? 1 : 0);
		ByteBufUtils.writeVarShort(buf, isEmptyLoot ? 1 : 0);
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
/*
	public ItemStack getLoot() {
		return loot;
	}

	public void setLoot(ItemStack loot) {
		this.loot = loot;
	}
*/

	public boolean isEmptyLoot() {
		return isEmptyLoot;
	}

	public void setEmptyLoot(boolean isEmptyLoot) {
		this.isEmptyLoot = isEmptyLoot;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDelta() {
		return delta;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	public boolean isSnoop() {
		return isSnoop;
	}

	public void setSnoop(boolean isSnoop) {
		this.isSnoop = isSnoop;
	}

	public boolean isShouldNotify() {
		return shouldNotify;
	}

	public void setShouldNotify(boolean shouldNotify) {
		this.shouldNotify = shouldNotify;
	}

	public static class Handler implements IMessageHandler<LootPacket, IMessage> {
		public static GuiThief.LootingUpdater callback;
		@Override
		public IMessage onMessage(LootPacket message, MessageContext ctx) {
			if (message.isSnoop()) {
				callback.run(message);
			} else {
				UltimateExtender.STEAL_PROCESSOR.handleLootPacket(message);
			}
			return null;
		}
	}
}