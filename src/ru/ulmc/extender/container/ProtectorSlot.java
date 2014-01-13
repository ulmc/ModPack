package ru.ulmc.extender.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import ru.ulmc.extender.item.ItemKey;
import ru.ulmc.extender.item.ItemLockProtector;
import ru.ulmc.extender.item.ItemManager;

public class ProtectorSlot extends Slot {

	public ProtectorSlot(IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);		
		if(((ItemLockProtector)ItemManager.getItem("capsuleEmpty")) != null) {
			setBackgroundIcon(((ItemLockProtector)ItemManager.getItem("capsuleEmpty")).placeholder);
		}
	}
	public boolean isItemValid(ItemStack par1ItemStack)
    {
		if(par1ItemStack.getItem() instanceof ItemLockProtector) {
			return true;
		} 
        return false;
    }
	
}
