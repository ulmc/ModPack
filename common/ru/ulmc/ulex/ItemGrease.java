package ru.ulmc.ulex;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemGrease extends Item
{
    public ItemGrease(int i)
    {
        super(i);
    }
    public boolean tryPlaceIntoWorld(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par3World.getBlockId(par4, par5, par6) != Block.snow.blockID)
        {
            if (par7 == 0)
            {
                --par5;
            }

            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }

            if (!par3World.isAirBlock(par4, par5, par6))
            {
                return false;
            }
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6))
        {
            return false;
        }
        else
        {
            if (UltimateExtender.blockGrease.canPlaceBlockAt(par3World, par4, par5, par6))
            {
                --par1ItemStack.stackSize;
                par3World.setBlockWithNotify(par4, par5, par6, UltimateExtender.blockGrease.blockID);
            }

            return true;
        }
    }
}
