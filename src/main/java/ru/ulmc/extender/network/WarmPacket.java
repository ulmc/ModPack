package ru.ulmc.extender.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.gui.SurvivalGui;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 45 on 13.09.2014.
 */
public class WarmPacket implements IMessage {
	public static float renderMultiplier;
	private int deltaMultiplied;
	private int delta;
	private boolean isCold;
	private static final float percent = 100.0f;


	public WarmPacket() {
	}

	public WarmPacket(int deltaMultiplied, int delta, boolean isCold) {
		this.deltaMultiplied = Math.abs(deltaMultiplied);
		this.delta = Math.abs(delta);
		this.isCold = isCold;
	}

	public int getDelta() {
		return delta;
	}

	public int getDeltaMultiplied() {
		return deltaMultiplied;
	}

	public boolean isCold() {
		return isCold;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.deltaMultiplied = Integer.parseInt(ByteBufUtils.readUTF8String(buf));
		this.delta = Integer.parseInt(ByteBufUtils.readUTF8String(buf));
		this.isCold = ByteBufUtils.readVarShort(buf) == 1;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, deltaMultiplied + "");
		ByteBufUtils.writeUTF8String(buf, delta + "");
		ByteBufUtils.writeVarShort(buf, isCold ? 1 : 0);
	}

	@Override
	public String toString() {
		return "WarmPacket{" +
				"deltaMultiplied=" + deltaMultiplied +
				", delta=" + delta +
				", isCold=" + isCold +
				'}';
	}

	public static class Handler implements IMessageHandler<WarmPacket, IMessage> {

		@Override
		public IMessage onMessage(WarmPacket message, MessageContext ctx) {
			if(message.getDelta() == -1000 || (SurvivalGui.getPower() == 0.0f && message.getDelta() == 0 && message.getDeltaMultiplied() == 0)) {
				SurvivalGui.setDoRenderHeat(false);
				SurvivalGui.setDoRenderFrost(false);
				SurvivalGui.setPower(0);
				SurvivalGui.setCurrentMaxPower(0);
				return null;
			}
			//UltimateExtender.logger.error(message);
			SurvivalGui.setCurrentMaxPower((message.getDelta() / percent) * renderMultiplier);
			float newPower = (message.getDeltaMultiplied() != 0 ?
					(message.getDeltaMultiplied() / percent * renderMultiplier) : renderMultiplier);
			if (SurvivalGui.getPower() >= SurvivalGui.getCurrentMaxPower()) {
				if (SurvivalGui.getPower() - SurvivalGui.getCurrentMaxPower() > newPower) {
					SurvivalGui.increasePower(newPower * -1);
				} else {
					SurvivalGui.setPower(SurvivalGui.getCurrentMaxPower());
				}
				//UltimateExtender.logger.error("setting power1: " + SurvivalGui.getPower());
			} else {
				SurvivalGui.increasePower(newPower);
			}
			if (message.isCold()) {
				SurvivalGui.setDoRenderFrost(true);
			} else {
				SurvivalGui.setDoRenderHeat(true);
			}
			return null;
		}
	}
}
