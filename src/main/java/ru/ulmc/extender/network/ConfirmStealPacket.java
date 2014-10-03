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
import ru.ulmc.extender.gui.GuiThief;

/**
 * Created by 45 on 01.10.2014.
 */
public class ConfirmStealPacket implements IMessage {
	private boolean isOk;
	private int delta;

	public ConfirmStealPacket() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		delta = Integer.parseInt(ByteBufUtils.readUTF8String(buf));
		isOk = ByteBufUtils.readVarShort(buf) == 1;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, delta + "");
		ByteBufUtils.writeVarShort(buf, isOk? 1 : 0);
	}


	public int getDelta() {
		return delta;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}

	public static class Handler implements IMessageHandler<ConfirmStealPacket, IMessage> {
		public static GuiThief.LootingUpdater callback;
		@Override
		public IMessage onMessage(ConfirmStealPacket message, MessageContext ctx) {
			callback.run(message);
			return null;
		}
	}
}
