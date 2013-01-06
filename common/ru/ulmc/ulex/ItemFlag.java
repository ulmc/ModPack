package ru.ulmc.ulex;

import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class ItemFlag extends Item
{
	private int blockID;
	public static String[] flagNames = new String[]{"flag1","flag2","flag3","flag4","flag5","flag6","flag7","flag8","flag9","flag10","flag11","flag12","flag13","flag14","flag15","flag16"};
	
    public ItemFlag(int i, Block block)
    {
        super(i);
        blockID = block.blockID;
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }
    public int getIconFromDamage(int par1)
    {
    	int var2 = MathHelper.clamp_int(par1, 0, 15);
        return this.iconIndex + var2;
    }
    public String getItemNameIS(ItemStack par1ItemStack)
    {
        int var2 = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
        return super.getItemName() + "." + flagNames[var2];
    }
    @SideOnly(Side.CLIENT)

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 16; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
    public int getMetadata(int par1)
    {
        return par1;
    }
    public int getBlockID()
    {
        return this.blockID;
    }   
    public boolean tryPlaceIntoWorld(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        int var11 = par3World.getBlockId(par4, par5, par6);

        if (var11 == Block.snow.blockID)
        {
            par7 = 1;
        }
        else if (var11 != Block.vine.blockID && var11 != Block.tallGrass.blockID && var11 != Block.deadBush.blockID
                && (Block.blocksList[var11] == null || !Block.blocksList[var11].isBlockReplaceable(par3World, par4, par5, par6)))
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
        }

        if (par1ItemStack.stackSize == 0)
        {
            return false;
        }
        else if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6))
        {
            return false;
        }
        else if (par5 == 255 && Block.blocksList[this.blockID].blockMaterial.isSolid())
        {
            return false;
        }
        else if (par3World.canPlaceEntityOnSide(this.blockID, par4, par5, par6, false, par7, par2EntityPlayer))
        {
            Block var12 = Block.blocksList[this.blockID];

            if (placeBlockAt(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10))
            {
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var12.stepSound.getStepSound(), (var12.stepSound.getVolume() + 1.0F) / 2.0F, var12.stepSound.getPitch() * 0.8F);
                --par1ItemStack.stackSize;
            }

            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
       if (!world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, this.getMetadata(stack.getItemDamage())))
       {
               return false;
       }

       if (world.getBlockId(x, y, z) == this.blockID)
       {
           Block.blocksList[this.blockID].updateBlockMetadata(world, x, y, z, side, hitX, hitY, hitZ);
           Block.blocksList[this.blockID].onBlockPlacedBy(world, x, y, z, player);
       }

       return true;
    }
}
