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

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import ru.ulmc.extender.config.Config;
import ru.ulmc.extender.gui.SurvivalGui;
import ru.ulmc.extender.network.WarmPacket;
import ru.ulmc.extender.render.*;
import ru.ulmc.extender.tileentity.*;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit() {
		super.preInit();
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new SurvivalGui());
		WarmPacket.renderMultiplier = Config.getSurvivalFloat("thermal.multiplier.render");
		SurvivalGui.setThermometerRenderPosition(Config.getSurvivalInt("thermal.gui.thermometer.x"),
				Config.getSurvivalInt("thermal.gui.thermometer.y"));
	}

	@Override
	public void registerTileEntitySpecialRenderer() {
		RenderChairs render = new RenderChairs();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChair.class, render);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEliteChair.class, render);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, new RenderTables());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBones.class, new RenderBones());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLockedChest.class, new RenderLockedChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCart.class, new RenderCart());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, new RenderBarrel());

		//RenderingRegistry.registerEntityRenderingHandler(EntityFallingBlock.class, new RenderBonesEntity());

	}

	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}

	@Override
	public void createItem(Item anItem) {
		GameRegistry.registerItem(anItem, anItem.getUnlocalizedName());
	}

	@Override
	public void prepareBlock(Block aBlock) {
		GameRegistry.registerBlock(aBlock, aBlock.getUnlocalizedName());
	}

	@Override
	public int getArmorPrefix(String name) {
		return RenderingRegistry.addNewArmourRendererPrefix(name);
	}
}