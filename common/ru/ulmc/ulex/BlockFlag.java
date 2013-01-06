package ru.ulmc.ulex;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockFlag extends Block
{
	private byte flagType;
	private Class flagEntityClass;
	private float angle;
	public BlockFlag(int i, Class class1)
    {
            super(i, Material.cloth);
            flagEntityClass = class1;
            setHardness(1.5F);
            setResistance(1.5F);
            setStepSound(Block.soundWoodFootstep);
            setBlockName("Minecraft Standart");
            this.setTextureFile(getTextureFile());
            blockIndexInTexture = 5;
            this.setRequiresSelfNotify();
            this.isBlockContainer = true;
    }
    public void setValue(Item anItemDrop, byte aFlagType)
    {
    	flagType = aFlagType;
    	//flagMetadata = aFlagMetadata;
    }
    public TileEntity getBlockEntity()
    {
            try
            {
                    return (TileEntity)flagEntityClass.newInstance();
            }
            catch (Exception exception)
            {
                    throw new RuntimeException(exception);
            }
    }
    public TileEntity createTileEntity(World world, int metadata)
    {
    	TileEntityFlag myTile = new TileEntityFlag();
    	myTile.setValues(flagType, (byte)0);
    	myTile.onInventoryChanged();
    	return myTile;
    }   
    public TileEntity createNewTileEntity(World var1)
    {
    	TileEntityFlag tileEntityFlag = new TileEntityFlag();
    	return tileEntityFlag;
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
    	setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.2F, 0.9F);
    	return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }
    private boolean canPlaceFlagOn(World par1World, int par2, int par3, int par4)
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
    protected int damageDropped(int par1)
    {
        return par1;
    }
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return canPlaceFlagOn(par1World, par2, par3 - 1, par4);
    }
    private boolean dropFlagIfCantStay(World par1World, int par2, int par3, int par4)
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
        if (this.dropFlagIfCantStay(par1World, par2, par3, par4))
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);
            if (!this.canPlaceFlagOn(par1World, par2, par3 - 1, par4) && var6 == 5)
            {
            	this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlockWithNotify(par2, par3, par4, 0);
            }

        }
    }
    public int idDropped(int i, Random random, int j)
    {
            return UltimateExtender.itemFlag.shiftedIndex;
    }
    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
        par3List.add(new ItemStack(par1, 1, 5));
        par3List.add(new ItemStack(par1, 1, 6));
        par3List.add(new ItemStack(par1, 1, 7));
        par3List.add(new ItemStack(par1, 1, 8));
        par3List.add(new ItemStack(par1, 1, 9));
        par3List.add(new ItemStack(par1, 1, 10));
        par3List.add(new ItemStack(par1, 1, 11));
        par3List.add(new ItemStack(par1, 1, 12));
        par3List.add(new ItemStack(par1, 1, 13));
        par3List.add(new ItemStack(par1, 1, 14));
        par3List.add(new ItemStack(par1, 1, 15));
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
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        //TileEntityFlag myTile = (TileEntityFlag)this.createTileEntity(par1World, par1World.getBlockMetadata(par2, par3, par4));
        par1World.setBlockTileEntity(par2, par3, par4, this.createTileEntity(par1World, par1World.getBlockMetadata(par2, par3, par4)));        
    }
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
    	TileEntityFlag myTile = (TileEntityFlag)par1World.getBlockTileEntity(par2, par3, par4);
    	byte side = (byte)(MathHelper.floor_double((double)((par5EntityLiving.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15);
    	this.angle = side;
    	myTile.angle = side;
    	myTile.onInventoryChanged();
    }
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
        par1World.removeBlockTileEntity(par2, par3, par4);
    }
    
}
