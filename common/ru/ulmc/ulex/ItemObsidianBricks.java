package ru.ulmc.ulex;

import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class ItemObsidianBricks extends ItemBlock
{
    public ItemObsidianBricks(int par1, Block par2Block)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    @Override
    public String getTextureFile()
    {
        return Params.TEXTURE_PATH_BLOCKS;
    }
    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return par1;
    }

}
