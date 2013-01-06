package ru.ulmc.ulex;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class Block_____ extends BlockContainer
{
	private Class _____EntityClass;
    public Block_____(int i, Class class1)
    {
            super(i, Material.cloth);
            _____EntityClass = class1;
            setHardness(2.5F);
            setResistance(1.0F);
            setStepSound(Block.soundWoodFootstep);
            setBlockName("BlockBones");
            this.setTextureFile(getTextureFile());
            blockIndexInTexture = 5;
            //this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 3.1F, 1.0F);
    }
    //����� ��������� TileEntity ��� �����, ��� ��������.
    public TileEntity getBlockEntity()
    {
            try
            {
                    return (TileEntity)_____EntityClass.newInstance();
            }
            catch (Exception exception)
            {
                    throw new RuntimeException(exception);
            }
    }
    //TileEntity? ��� ������ �� �����? �� ��, ������ ����� ����� ��� ����� ��������� ���������.
    public TileEntity createNewTileEntity(World var1)
    {
        return new TileEntity_____();
    }
    public void setBlockBounds(IBlockAccess par1IBlockAccess)
    {        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);    }
    //�������� ������ ����
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
    	setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    	return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }
    //��������� �� ��� ����� ���� ��������� ���� ������������ � �����. ����������������, ���� �� ������ �� �����.
    private boolean canPlace_____On(World par1World, int par2, int par3, int par4)
    {
        if (par1World.doesBlockHaveSolidTopSurface(par2, par3, par4))
        {
            return true;
        }
        else
        {
            int var5 = par1World.getBlockId(par2, par3, par4);
            return (Block.blocksList[var5] != null && Block.blocksList[var5].canPlaceTorchOnTop(par1World, par2, par3, par4));
        }
    }
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return canPlace_____On(par1World, par2, par3 - 1, par4);
    }
    //���������������
    private boolean drop_____IfCantStay(World par1World, int par2, int par3, int par4)
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
    // ������������ ��������� ������, ���� ���� ��� ���� ������ - ����������� � ������� ����.
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (this.drop_____IfCantStay(par1World, par2, par3, par4))
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);
            if (!this.canPlace_____On(par1World, par2, par3 - 1, par4) && var6 == 5)
            {
            	this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlockWithNotify(par2, par3, par4, 0);
            }

        }
    }
    //��� ��������� ����, ������� ��������� ��� ����������� �����. ��������� ����-����������!
    public int idDropped(int i, Random random, int j)
    {
            return UltimateExtender.item_____.shiftedIndex;
    }
    //���������� �����
    public int quantityDropped(Random random)
    {
            return 1;
    }
    //��� ������� ��� ����� (������������ ���� ��� �������� �������?)
    public int getRenderType()
    {
            return -1;
    }
    @Override
    public String getTextureFile()
    {
        return Params.TEXTURE_PATH_!_____!;
    }
    //���������� �� ����?
    public boolean isOpaqueCube()
    {
            return false;
    }
    //��������� ��� ���?
    public boolean renderAsNormalBlock()
    {
            return false;
    }
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
    int p = MathHelper.floor_double((double)((par5EntityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3; //������� � ������� ������
    byte aByte = 3;
    if (p == 0)
    	aByte = 0;
    if (p == 1)
    	aByte = 3;
    if (p == 2)
    	aByte = 2;
    if (p == 3)
    	aByte = 1;
    par1World.setBlockMetadataWithNotify(par2, par3, par4, aByte);
}
}
