package ru.ulmc.extender.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.exception.StealingException;

/**
 * Created by 45 on 01.10.2014.
 */
public class IntentStealPacket implements IMessage {
	private String thiefName;
	private int step;
	private boolean isAskingForLoot = false;

	public IntentStealPacket() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		thiefName = ByteBufUtils.readUTF8String(buf);
		step = ByteBufUtils.readVarShort(buf);
		isAskingForLoot = ByteBufUtils.readVarShort(buf) == 1;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, thiefName);
		ByteBufUtils.writeVarShort(buf, step);
		ByteBufUtils.writeVarShort(buf, isAskingForLoot ? 1 : 0);
	}

	public boolean isAskingForLoot() {
		return isAskingForLoot;
	}

	public void setAskingForLoot(boolean isAskingForLoot) {
		this.isAskingForLoot = isAskingForLoot;
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

	public static class Handler implements IMessageHandler<IntentStealPacket, IMessage> {
		@Override
		public IMessage onMessage(IntentStealPacket message, MessageContext ctx) {
			if (!message.isAskingForLoot()) {
				return UltimateExtender.instance.STEAL_PROCESSOR.lookingForLoot(message);
			} else {
				return UltimateExtender.instance.STEAL_PROCESSOR.getLoot(message);
			}
		}
	}
}
