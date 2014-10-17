package ru.ulmc.extender.render;

import net.minecraft.block.Block;

/**
 * Created by 45 on 16.10.2014.
 */
public interface InventoryRenderable {
	void renderItem(Block block, int metadata);
}
