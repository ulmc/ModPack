package ru.ulmc.extender.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.world.IBlockAccess;
import ru.ulmc.extender.block.BlockBench;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 45 on 16.10.2014.
 */
public class InventoryRender implements ISimpleBlockRenderingHandler {
	private Map<String, InventoryRenderable> renders = new HashMap<String, InventoryRenderable>();
	private int id;

	public InventoryRender() {
		id = RenderingRegistry.getNextAvailableRenderId();
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		if(block instanceof BlockBench) {
			renders.get("bench").renderItem(block, metadata);
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return id;
	}

	public void add(String name, InventoryRenderable render) {
		renders.put(name, render);
	}
}
