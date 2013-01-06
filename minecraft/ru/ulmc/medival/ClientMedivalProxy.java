package ru.ulmc.medival;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientMedivalProxy extends CommonMedivalProxy
{
	@Override
    public void preInit()
    {
		//MinecraftForgeClient.preloadTexture(SteamPref.TEXTURE_PATH_BLOCKS);
		
    	MinecraftForge.EVENT_BUS.register(this); // Just in case. I don't know what it is.
    }
    @Override
    public void registerTileEntitySpecialRenderer()
    {
    	
    }

    @Override
    public World getClientWorld()
    {
        return FMLClientHandler.instance().getClient().theWorld;
    }
    @Override
    public void CreateItem(Item anItem, int index, String name, String ru, String en, boolean toTab)
    {
    	if(toTab)
    		anItem.setTabToDisplayOn(CreativeTabs.tabTransport);
    	anItem.setIconIndex(index);
    	anItem.setItemName(name);
    	anItem.setTextureFile(MedivalPref.TEXTURE_PATH_ITEMS);
    	LanguageRegistry.instance().addStringLocalization(anItem.getItemName() + ".name", "ru_RU", ru);
    	LanguageRegistry.instance().addStringLocalization(anItem.getItemName() + ".name", "en_US", en);
    	
    }
    public void CreateItem(Item anItem, int index, String name, String[] metanames, String[] ruNames, String[] enNames, String differentTexturePath){
    	anItem.setTabToDisplayOn(CreativeTabs.tabTransport);
    	anItem.setIconIndex(index);
    	anItem.setItemName(name);
    	for (int i = 0; i < ruNames.length; i++ )
    	{
    		LanguageRegistry.instance().addNameForObject(new ItemStack(anItem,1,i), "ru_RU", ruNames[i]);
    		LanguageRegistry.instance().addNameForObject(new ItemStack(anItem,1,i), "en_US", enNames[i]);
    	}
    	if (differentTexturePath.isEmpty())
    		anItem.setTextureFile(MedivalPref.TEXTURE_PATH_ITEMS);
    	else
    		anItem.setTextureFile(differentTexturePath);
    }
    @Override
    public void PrepareBlock(Block aBlock, String ru, String en, Boolean bool)
    {
    	// Register Blocks and do some Localization For non meta blocks
    	GameRegistry.registerBlock(aBlock);
    	LanguageRegistry.instance().addStringLocalization(aBlock.getBlockName() + ".name", "ru_RU", ru);
    	LanguageRegistry.instance().addStringLocalization(aBlock.getBlockName() + ".name", "en_US", en);
    	if (bool)
    		aBlock.setCreativeTab(CreativeTabs.tabBlock);
    	
    }
    public void CreateItem(Item anItem, String string2, String string3) {
    	//anItem.setTabToDisplayOn(CreativeTabs.tabTransport);
    	//anItem.setTextureFile(SteamPref.TEXTURE_PATH_ITEMS);
    	LanguageRegistry.instance().addStringLocalization(anItem.getItemName() + ".name", "ru_RU", string2);
    	LanguageRegistry.instance().addStringLocalization(anItem.getItemName() + ".name", "en_US", string3);
	}
}