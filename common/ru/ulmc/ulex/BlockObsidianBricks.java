package ru.ulmc.ulex;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockObsidianBricks extends Block
{
	public static final String[] bricksType = new String[] {"bloody", "mana"};
    public BlockObsidianBricks(int blockID)
    {
        super(blockID, 14, Material.rock);
        setHardness(25.0f);
        setResistance(300.0f);
        setStepSound(soundStoneFootstep);
        setBlockName("Obsidian Bricks");
        setRequiresSelfNotify();
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
	@Override
    public String getTextureFile()
    {
        return Params.TEXTURE_PATH_BLOCKS;
    }
	 public int getBlockTextureFromSideAndMetadata(int par1, int par2)
	    {
	        switch (par2)
	        {
	        	case 1:
	                return 15;
	            default:
	                return 14;
	        }
	    }
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    protected int damageDropped(int par1)
    {
        return par1;
    }
    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
    }
}
