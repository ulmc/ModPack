package ru.ulmc.extender.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 45 on 30.09.2014.
 * Отвечает за воровской механизм.
 */
public class ThiefProcessor {

	private static Map<String, EntityPlayer> thiefMap = new HashMap<String, EntityPlayer>();

	@SideOnly(Side.SERVER)
	public void initStealing(EntityPlayer thief, EntityPlayer victim) {
		int aStr = victim.getTotalArmorValue(); aStr = aStr != 0 ? aStr : 1;
		double chance = MathHelper.getRandomIntegerInRange(victim.worldObj.rand, 10, 40) / aStr;
		thiefMap.put(thief.getDisplayName(), victim);
	}

	public static class StealingHandler implements IMessageHandler<StealingPacket, IMessage> {

		@Override
		public IMessage onMessage(StealingPacket message, MessageContext ctx) {

			return null;
		}
	}

	public static class LootHandler implements IMessageHandler<LootPacket, IMessage> {

		@Override
		public IMessage onMessage(LootPacket message, MessageContext ctx) {

			return null;
		}
	}

	public static class StealingPacket implements IMessage {
		private String victimName;
		private String thiefName;
		private int step;

		public StealingPacket() {
		}

		@Override
		public void fromBytes(ByteBuf buf) {
			thiefName = ByteBufUtils.readUTF8String(buf);
			victimName = ByteBufUtils.readUTF8String(buf);
			step = ByteBufUtils.readVarShort(buf);
		}

		@Override
		public void toBytes(ByteBuf buf) {
			ByteBufUtils.writeUTF8String(buf, thiefName);
			ByteBufUtils.writeUTF8String(buf, victimName);
			ByteBufUtils.writeVarShort(buf, step);
		}

		public String getVictimName() {
			return victimName;
		}

		public void setVictimName(String victimName) {
			this.victimName = victimName;
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
	}

	public static class LootPacket implements IMessage {
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

		public void setSuccess(boolean isSuccessed) {
			this.isSuccess = isSuccessed;
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
	}
}
