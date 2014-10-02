package ru.ulmc.extender.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;

/**
 * Created by 45 on 01.10.2014.
 */
public class LootPacket implements IMessage {
	private boolean isSuccess;
	private ItemStack loot = null;
	private int step;

	public LootPacket() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		loot = ByteBufUtils.readItemStack(buf);
		step = ByteBufUtils.readVarShort(buf);
		isSuccess = ByteBufUtils.readVarShort(buf) == 1;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeItemStack(buf, loot);
		ByteBufUtils.writeVarShort(buf, step);
		ByteBufUtils.writeVarShort(buf, isSuccess ? 1 : 0);
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public ItemStack getLoot() {
		return loot;
	}

	public void setLoot(ItemStack loot) {
		this.loot = loot;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public static class LootHandler implements IMessageHandler<LootPacket, IMessage> {

		@Override
		public IMessage onMessage(LootPacket message, MessageContext ctx) {

			return null;
		}
	}
}