package ru.ulmc.extender.gui.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ru.ulmc.extender.container.ContainerBones;
import ru.ulmc.extender.container.ContainerGrinder;
import ru.ulmc.extender.container.ContainerLockedChest;
import ru.ulmc.extender.gui.GuiBones;
import ru.ulmc.extender.gui.GuiGrinder;
import ru.ulmc.extender.gui.GuiLockedChest;
import ru.ulmc.extender.tileentity.TileEntityBones;
import ru.ulmc.extender.tileentity.TileEntityGrinder;
import ru.ulmc.extender.tileentity.TileEntityLockedChest;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {

		TileEntity te = world.getBlockTileEntity(x, y, z);
		
		switch (id) {
		case GuiBones.GUI_ID:
			if(te instanceof TileEntityBones) {
			return new ContainerBones(player.inventory,
					(TileEntityBones) te);
			}
		case GuiLockedChest.GUI_ID:
			if(te instanceof TileEntityLockedChest) {
			return new ContainerLockedChest(player.inventory,
					(TileEntityLockedChest) te);
			}
		case GuiGrinder.GUI_ID:
			if(te instanceof TileEntityGrinder) {
			return new ContainerGrinder(player.inventory,
					(TileEntityGrinder) te);
			}
		default:
			return null;
		}

	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		
		TileEntity te = world.getBlockTileEntity(x, y, z);

		switch (id) {
			case GuiBones.GUI_ID:
				if(te instanceof TileEntityBones) {
					return new GuiBones(player.inventory, (TileEntityBones)te);
				}
			case GuiLockedChest.GUI_ID:
				if(te instanceof TileEntityLockedChest) {
				return new GuiLockedChest(player.inventory,
						(TileEntityLockedChest) te);
				}
			case GuiGrinder.GUI_ID:
				if(te instanceof TileEntityGrinder) {
				return new GuiGrinder(player.inventory,
						(TileEntityGrinder) te);
				}
			default:
				return null;
		}

	}
}