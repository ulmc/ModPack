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
public class ConfirmLootPacket implements IMessage {
	private int isOk;
	private int delta;

	public ConfirmLootPacket() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		delta = Integer.parseInt(ByteBufUtils.readUTF8String(buf));
		isOk = ByteBufUtils.readVarShort(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, delta + "");
		ByteBufUtils.writeVarShort(buf, isOk);
	}

	public boolean isOk() {
		return isOk == 1;
	}

	public int getDelta() {
		return delta;
	}

	public static class StartHandler implements IMessageHandler<ConfirmLootPacket, IMessage> {
		public static GuiThief.LootingUpdater callback;
		@Override
		public IMessage onMessage(ConfirmLootPacket message, MessageContext ctx) {

			return null;
		}
	}
}
