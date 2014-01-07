package ru.ulmc.extender.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import ru.ulmc.extender.render.RenderBones;
import ru.ulmc.extender.render.RenderFlags;
import ru.ulmc.extender.render.RenderLockedChest;
import ru.ulmc.extender.render.RenderTables;
import ru.ulmc.extender.render.RenderUlmcObjects;
import ru.ulmc.extender.tileentity.TileEntityBones;
import ru.ulmc.extender.tileentity.TileEntityChair;
import ru.ulmc.extender.tileentity.TileEntityEliteChair;
import ru.ulmc.extender.tileentity.TileEntityFlag;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;
import ru.ulmc.extender.tileentity.TileEntityTable;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void registerTileEntitySpecialRenderer() {
		RenderUlmcObjects render = new RenderUlmcObjects();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChair.class, render);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEliteChair.class, render);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlag.class, new RenderFlags());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, new RenderTables());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBones.class, new RenderBones());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLockedChest.class, new RenderLockedChest());

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
}