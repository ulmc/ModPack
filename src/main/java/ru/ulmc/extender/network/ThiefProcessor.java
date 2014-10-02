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
import ru.ulmc.extender.network.model.StealingModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 45 on 30.09.2014.
 * Отвечает за воровской механизм.
 */
public class ThiefProcessor {

	private static Map<String, StealingModel> thiefMap = new HashMap<String, StealingModel>();

	@SideOnly(Side.SERVER)
	public void initStealing(EntityPlayer thief, EntityPlayer victim) {
		int aStr = victim.getTotalArmorValue(); aStr = aStr != 0 ? aStr : 1;
		double chance = MathHelper.getRandomIntegerInRange(victim.worldObj.rand, 10, 40) / aStr;
		thiefMap.put(thief.getDisplayName(), new StealingModel(thief, victim));
	}
}
