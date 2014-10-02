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
