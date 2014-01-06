package ru.ulmc.extender.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.item.ItemKey;
import ru.ulmc.extender.item.ItemManager;
import ru.ulmc.extender.tileentity.TileEntityBones;

public class ReSlot extends Slot {

	public ReSlot(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
	}

}
