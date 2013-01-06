package ru.ulmc.ulex;

import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockGrease extends Block
{
    public BlockGrease(int blockID)
    {
        super(blockID, Material.cloth);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.01F, 1.0F);
        setHardness(1.5F);
        setStepSound(soundGrassFootstep);
        //this.slipperiness = 0.98F;
        blockIndexInTexture = 1;
        setBlockName("SpoiledGrease");
    }
    @Override
    public String getTextureFile()
    {
        return Params.TEXTURE_PATH_BLOCKS;
    }
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
    	
    	return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    public boolean isOpaqueCube()
    {
        return false;
    }
    public int getRenderType()
    {
        return 0;
    }
    private boolean canPlaceGreaseOn(World par1World, int par2, int par3, int par4)
    {
        return par1World.doesBlockHaveSolidTopSurface(par2, par3, par4);

    }
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return canPlaceGreaseOn(par1World, par2, par3 - 1, par4);
    }
    private boolean dropGreaseIfCantStay(World par1World, int par2, int par3, int par4)
    {
        if (!this.canPlaceBlockAt(par1World, par2, par3, par4))
        {
            if (par1World.getBlockId(par2, par3, par4) == this.blockID)
            {
                this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlockWithNotify(par2, par3, par4, 0);
            }

            return false;
        }
        else
        {
            return true;
        }
    }
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (this.dropGreaseIfCantStay(par1World, par2, par3, par4))
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);
            if (!this.canPlaceGreaseOn(par1World, par2, par3 - 1, par4) && var6 == 5)
            {
            	this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlockWithNotify(par2, par3, par4, 0);
            }

        }
    }
    public int tickRate()
    {
        return 100;
    }
}
