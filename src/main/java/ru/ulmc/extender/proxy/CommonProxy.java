/**
 * Copyright (C) 2014 ulmc.ru (Alex K.)
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
 *
 */
package ru.ulmc.extender.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import ru.ulmc.extender.Reference;
import ru.ulmc.extender.events.MobDropEventsHook;
import ru.ulmc.extender.events.PlayerEventsHook;
import ru.ulmc.extender.events.WarmHandler;

import java.rmi.registry.Registry;

public class CommonProxy implements IGuiHandler {
	public void preInit() {
		MinecraftForge.EVENT_BUS.register(new PlayerEventsHook());
	}

	public void registerTileEntitySpecialRenderer() {
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
	                                  int x, int y, int z) {
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
	                                  int x, int y, int z) {
		return null;
	}

	public World getClientWorld() {
		return null;
	}

	public void prepareBlock(Block aBlock) {
		GameRegistry.registerBlock(aBlock, aBlock.getUnlocalizedName());
	}

	public void prepareBlock(Block aBlock, Class<? extends ItemBlock> itemBlock) {
		GameRegistry.registerBlock(aBlock, itemBlock, aBlock.getUnlocalizedName());
	}

	public void createItem(Item anItem) {
		if(anItem instanceof ItemBlock)
			return;
		GameRegistry.registerItem(anItem, anItem.getUnlocalizedName(), Reference.MOD_ID);
	}

	public int getArmorPrefix(String name) {
		return 0;
	}
}