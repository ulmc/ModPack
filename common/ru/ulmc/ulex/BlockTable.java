package ru.ulmc.ulex;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityNote;
import net.minecraft.src.World;

public class BlockTable extends BlockContainer
{
	private Class anEntityClass;
	protected ItemTable itemDrop;
	private String path;
    public BlockTable(int i, Class class1, float aHardness, float aResistance, String aBlockName)
    {
            super(i, Material.wood);
            anEntityClass = class1;
            setHardness(aHardness);
            setResistance(aResistance);
            setStepSound(Block.soundWoodFootstep);
            setBlockName(aBlockName);
            /**
             * Sets the bounds of the block.  minX, minY, minZ, maxX, maxY, maxZ
             */
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    public void setIDs(ItemTable anItem)
    {
    	itemDrop = anItem;
    }
    public TileEntity getBlockEntity()
    {
            try
            {
                    return (TileEntity)anEntityClass.newInstance();
            }
            catch (Exception exception)
            {
                    throw new RuntimeException(exception);
            }
    }
    public TileEntity createNewTileEntity(World var1)
    {
    	TileEntityTable tileEntityTable = new TileEntityTable();
    	tileEntityTable.setType(itemDrop.getType());
        return tileEntityTable;
    }
     private boolean canPlaceTableOn(World par1World, int par2, int par3, int par4)
    {
        if (par1World.doesBlockHaveSolidTopSurface(par2, par3, par4))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return canPlaceTableOn(par1World, par2, par3 - 1, par4);
    }
    private boolean dropTableIfCantStay(World par1World, int par2, int par3, int par4)
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
        if (this.dropTableIfCantStay(par1World, par2, par3, par4))
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);
            if (!this.canPlaceTableOn(par1World, par2, par3 - 1, par4) && var6 == 5)
            {
            	this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlockWithNotify(par2, par3, par4, 0);
            }

        }
    }
    @Override
    public String getTextureFile()
    {
        return path;
    }
    public int idDropped(int i, Random random, int j)
    {
            return itemDrop.shiftedIndex;
    }
    public int quantityDropped(Random random)
    {
            return 1;
    }
    public int getRenderType()
    {
            return -1;
    }
    public boolean isOpaqueCube()
    {
            return false;
    }
    public boolean renderAsNormalBlock()
    {
            return false;
    }
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
    int p = MathHelper.floor_double((double)((par5EntityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3; 
    par1World.setBlockMetadataWithNotify(par2, par3, par4, p);
    }
    public void setTextureAndIndex(String aPath, int i)
    {
    	currentTexture = aPath;
    	blockIndexInTexture = i;
    }
}
