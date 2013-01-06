package ru.ulmc.ulex;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemExplosiveStick extends Item
{
    public ItemExplosiveStick(int i)
    {
        super(i);
    }
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
            if (!par3EntityPlayer.capabilities.isCreativeMode)
            {
                    --par1ItemStack.stackSize;
            }
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if (!par2World.isRemote)
            {
                    par2World.spawnEntityInWorld(new EntityExplosiveStick(par2World, par3EntityPlayer));
            }
            return par1ItemStack;
    }
}
