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

public class BlockChair extends BlockContainer
{
	//Комменты ищи в blockbones
	private Class anEntityClass;
	protected ItemChair itemDrop;
    public BlockChair(int i, Class class1, float aHardness, float aResistance, String aBlockName)
    {
            super(i, Material.wood);
            anEntityClass = class1;
            setHardness(aHardness);
            setResistance(aResistance);
            setStepSound(Block.soundWoodFootstep);
            setBlockName(aBlockName);
            this.setTextureFile(getTextureFile());
            /**
             * Sets the bounds of the block.  minX, minY, minZ, maxX, maxY, maxZ
             */
            setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.7F, 0.9F);
    }
    public void setIDs(ItemChair anItem)
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
    	TileEntityChair tileEntityChair = new TileEntityChair();
    	tileEntityChair.setType(itemDrop.getType());
        return tileEntityChair;
    }
    private boolean canPlaceChairOn(World par1World, int par2, int par3, int par4)
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
        return canPlaceChairOn(par1World, par2, par3 - 1, par4);
    }
    private boolean dropChairIfCantStay(World par1World, int par2, int par3, int par4)
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
        if (this.dropChairIfCantStay(par1World, par2, par3, par4))
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);
            if (!this.canPlaceChairOn(par1World, par2, par3 - 1, par4) && var6 == 5)
            {
            	this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlockWithNotify(par2, par3, par4, 0);
            }

        }
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
    @Override
    public String getTextureFile()
    {
        return Params.TEXTURE_PATH_BLOCKS;
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
    int p = MathHelper.floor_double((double)((par5EntityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3; //������� � ������� ������
    int aByte = 3;
    if (p == 0)
    	aByte = 0 ;
    if (p == 3)
    	aByte = 1 ;
    if (p == 2)
    	aByte = 2 ;
    if (p == 1)
    	aByte = 3 ;
    par1World.setBlockMetadataWithNotify(par2, par3, par4, aByte);
}
}
