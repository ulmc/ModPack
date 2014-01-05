package ru.ulmc.extender.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.item.ItemGrind;
import ru.ulmc.extender.item.ItemManager;

public class GrinderSlot extends Slot {

	public GrinderSlot(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);		
		setBackgroundIcon(((ItemGrind)ItemManager.getItemByName("coarseGrindstone")).placeholder);
	}
	public boolean isItemValid(ItemStack par1ItemStack)
    {
		if(par1ItemStack.getItem() instanceof ItemGrind) {
			return true;
		} 
        return false;
    }
	
}
