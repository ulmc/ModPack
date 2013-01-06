package ru.ulmc.ulex;

import ru.ulmc.ulex.CommonProxy;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	@Override
    public void preInit()
    {
		String[] paths = Params.getArrayForPreload();
		
		for (int i = 0; i < paths.length; i++)
			MinecraftForgeClient.preloadTexture(paths[i]);

    	MinecraftForge.EVENT_BUS.register(this); // Just in case. I don't know what it is.
    }
    @Override
    public void registerTileEntitySpecialRenderer()
    {
    	RenderUlmcObjects render = new RenderUlmcObjects();
    	RenderFlags renderFlags = new RenderFlags();
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBones.class, render);
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlag.class, renderFlags);
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChair.class, render);
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEliteChair.class, render);
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, render);
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTableCabinet.class, render);
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTableDinner.class, render);
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrystal.class, render);
    	//ClientRegistry.bindTileEntitySpecialRenderer(TileEntity.class, render);
    	RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveStick.class,  new RenderExplosives(UltimateExtender.itemExplosiveStick.getIconFromDamage(0), Params.TEXTURE_PATH_ITEMS));
    	
    }

    @Override
    public World getClientWorld()
    {
        return FMLClientHandler.instance().getClient().theWorld;
    }
    @Override
    public void CreateItem(Item anItem, int index, String name, String ru, String en, boolean bool)
    {
    	if(bool)
    		anItem.setTabToDisplayOn(CreativeTabs.tabTransport);
    	anItem.setIconIndex(index);
    	anItem.setItemName(name);
    	anItem.setTextureFile(Params.TEXTURE_PATH_ITEMS);
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
    		anItem.setTextureFile(Params.TEXTURE_PATH_ITEMS);
    	else
    		anItem.setTextureFile(differentTexturePath);
    }
    @Override
    public void PrepareBlock(Block aBlock, String ru, String en, boolean bool)
    {
    	// Register Blocks and do some Localization For non meta blocks
    	GameRegistry.registerBlock(aBlock);
    	LanguageRegistry.instance().addStringLocalization(aBlock.getBlockName() + ".name", "ru_RU", ru);
    	LanguageRegistry.instance().addStringLocalization(aBlock.getBlockName() + ".name", "en_US", en);
    	if (bool)
    		aBlock.setCreativeTab(CreativeTabs.tabBlock);
    	
    }
}