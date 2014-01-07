package ru.ulmc.extender.proxy;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler
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
    public void prepareBlock(Block aBlock)
    {
        GameRegistry.registerBlock(aBlock, aBlock.getUnlocalizedName());
    }
    public void createItem(Item anItem){
    	GameRegistry.registerItem(anItem, anItem.getUnlocalizedName());
    }
    public void CreateItem(Item anItem, int index, String name, String[] metanames, String[] ruNames, String[] enNames, String differentTexturePath){
    	
    }
}