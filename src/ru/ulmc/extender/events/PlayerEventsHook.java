package ru.ulmc.extender.events;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import ru.ulmc.extender.UltimateExtender;
import ru.ulmc.extender.block.BlockManager;
import ru.ulmc.extender.tileentity.TileEntityBones;

/**
 * Name and cast of this class are irrelevant
 */
public class PlayerEventsHook {

	@ForgeSubscribe
	public void setBlockOfBones(PlayerDropsEvent event) {
		int coordX = (int)event.entityPlayer.posX;
		int coordY = (int)event.entityPlayer.posY;
		int coordZ = (int)event.entityPlayer.posZ;
		
		event.entityPlayer.worldObj.setBlock(	coordX, 
												coordY, 
												coordZ, 
												BlockManager.blockBones.blockID);
		int p = MathHelper.floor_double((double) ((event.entityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3; 
		
		int aByte = 3;
		if (p == 0) {
			aByte = 2;
		} else if (p == 3) {
			aByte = 3;
		} else if (p == 2) {
			aByte = 0;
		} else if (p == 1) {
			aByte = 1;
		}
		event.entityPlayer.worldObj.setBlockMetadataWithNotify(	coordX, 
																coordY, 
																coordZ,
																aByte, 2);
		
		TileEntityBones chest = (TileEntityBones) event.entityPlayer.worldObj.getBlockTileEntity(coordX, coordY, coordZ);
		chest.setOwnerName(event.entityPlayer.username);
		int i = 0;
		int searchOffset;
		int slotsLeft = 18;
		boolean isSecondPassNeeded = true;
		
		if(event.drops.size() < 4) {			
			searchOffset = event.drops.size();
			isSecondPassNeeded = false;
		} else {
			searchOffset = 4;
		}		
		
		List<EntityItem> lastElements = event.drops.subList(event.drops.size() - searchOffset, event.drops.size());
		ArrayList<EntityItem> newDrop = new ArrayList<>();
		for (EntityItem item : lastElements) {
			if(!item.getEntityItem().isStackable() && slotsLeft > 0) {
				chest.setInventorySlotContents(i++, item.getEntityItem());
				slotsLeft--;
			}
		}
		if(isSecondPassNeeded) {
			List<EntityItem> firstElements = event.drops.subList(0, event.drops.size() - searchOffset);
			for (EntityItem item : firstElements) {
				if(!item.getEntityItem().isStackable() && slotsLeft > 0) {
					chest.setInventorySlotContents(i++, item.getEntityItem());
					slotsLeft--;
				} else {
					newDrop.add(item);
				}
			}
		}
		if(slotsLeft > 0) {
			double rand = Math.random();
			if(slotsLeft > 0 && rand > 0.10D) {
				chest.setInventorySlotContents(i++, new ItemStack(Item.rottenFlesh, 1));
				slotsLeft--;
			}
			if(slotsLeft > 0 && rand > 0.25D) {
				chest.setInventorySlotContents(i++, new ItemStack(Item.bone));
				slotsLeft--;				
			}
		}
		event.drops.clear();
		event.drops.addAll(newDrop);		
	}
}