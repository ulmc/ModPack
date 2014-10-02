package ru.ulmc.extender.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

/**
 * Created by 45 on 01.10.2014.
 */
public class LookForLootPacket implements IMessage {
	private String thiefName;
	private int step;

	public LookForLootPacket() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		thiefName = ByteBufUtils.readUTF8String(buf);
		step = ByteBufUtils.readVarShort(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, thiefName);
		ByteBufUtils.writeVarShort(buf, step);
	}

	public String getThiefName() {
		return thiefName;
	}

	public void setThiefName(String thiefName) {
		this.thiefName = thiefName;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public static class LookForLootHandler implements IMessageHandler<LookForLootPacket, ConfirmLootPacket> {
		@Override
		public ConfirmLootPacket onMessage(LookForLootPacket message, MessageContext ctx) {

			return null;
		}
	}
}
