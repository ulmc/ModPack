package ru.ulmc.steampeople;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonSteamProxy implements IGuiHandler
{
    public void preInit()
    {
    	
    }

    public void registerTileEntitySpecialRenderer()
    {
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z)
    {
        return null;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z)
    {
        return null;
    }

    public World getClientWorld()
    {
        return null;
    }
    public void PrepareBlock(Block aBlock, String ru, String en, Boolean bool)
    {
        GameRegistry.registerBlock(aBlock);
    }
    public void CreateItem(Item anItem, int index, String name, String ru, String en){
    	
    }
    public void CreateItem(Item anItem, int index, String name, String[] metanames, String[] ruNames, String[] enNames, String differentTexturePath){
    	
    }

	public void CreateItem(Item cottonHat, String string2,
			String string3) {
		// TODO Auto-generated method stub
		
	}
	public void CreateItem(Item anItem, int index, String name, String ru,
			String en, boolean toTab) {
		// TODO Auto-generated method stub
		
	}
}