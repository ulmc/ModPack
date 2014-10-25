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
import net.minecraft.item.ItemBlock;
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
		RenderChairs chairs = new RenderChairs();
		RenderBench bench = new RenderBench();
		RenderTables renderTables = new RenderTables();
		RenderBones bones = new RenderBones();
		RenderLockedChest lockedChest = new RenderLockedChest();
		RenderCart cart = new RenderCart();
		RenderBarrel barrel = new RenderBarrel();
		RenderConnectedTable connectedTable = new RenderConnectedTable();
		RenderGrinder grinder = new RenderGrinder();
		RenderBuildingBlock buildingBlock = new RenderBuildingBlock();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChair.class, chairs);
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEliteChair.class, chairs);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, renderTables);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBones.class, bones);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLockedChest.class, lockedChest);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCart.class, cart);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, barrel);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBench.class, bench);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConnectedTable.class, connectedTable);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrinder.class, grinder);
		ClientRegistry.bindTileEntitySpecialRenderer(BuildingBlockTileEntity.class, buildingBlock);
		//InventoryRender inventoryRender = new InventoryRender();
	//	inventoryRender.add("bench", bench);
		RenderingRegistry.registerBlockHandler(bench);
		RenderingRegistry.registerBlockHandler(chairs);
		RenderingRegistry.registerBlockHandler(bones);
		RenderingRegistry.registerBlockHandler(cart);
		RenderingRegistry.registerBlockHandler(barrel);
		RenderingRegistry.registerBlockHandler(grinder);
		RenderingRegistry.registerBlockHandler(buildingBlock);

		RenderingRegistry.registerBlockHandler(renderTables.barTableInventoryRender);
		RenderingRegistry.registerBlockHandler(renderTables.cabinetTableInventoryRender);
		RenderingRegistry.registerBlockHandler(renderTables.dinnerTableInventoryRender);
		//RenderingRegistry.registerEntityRenderingHandler(EntityFallingBlock.class, new RenderBonesEntity());

	}

	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}

	@Override
	public void createItem(Item anItem) {
		if(anItem instanceof ItemBlock)
			return;
		GameRegistry.registerItem(anItem, anItem.getUnlocalizedName());
	}

	@Override
	public void prepareBlock(Block aBlock) {
		GameRegistry.registerBlock(aBlock, aBlock.getUnlocalizedName());
	}

	@Override
	public void prepareBlock(Block aBlock, Class<? extends ItemBlock> itemBlock) {
		GameRegistry.registerBlock(aBlock, itemBlock, aBlock.getUnlocalizedName());
	}

	@Override
	public int getArmorPrefix(String name) {
		return RenderingRegistry.addNewArmourRendererPrefix(name);
	}
}