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

public class BlockBones extends BlockContainer
{
	private Class bonesEntityClass;
    public BlockBones(int i, Class class1)
    {
            super(i, Material.cloth);
            bonesEntityClass = class1;
            setHardness(2.5F);
            setResistance(1.0F);
            setStepSound(Block.soundWoodFootstep);
            setBlockName("BlockBones");
            this.setTextureFile(getTextureFile());
            blockIndexInTexture = 0;
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    }
    //Метод получения TileEntity для блока, что очевидно.
    public TileEntity getBlockEntity()
    {
            try
            {
                    return (TileEntity)bonesEntityClass.newInstance();
            }
            catch (Exception exception)
            {
                    throw new RuntimeException(exception);
            }
    }
    //TileEntity? Это объект на карте? Ну ок, вообще вроде нужен для более серьёзных устройств.
    public TileEntity createNewTileEntity(World var1)
    {
        return new TileEntityBones();
    }
   // public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess)
    {        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);    }
    //проходим сквозь блок
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
    //проверяет на что может быть поставлен блок скопипащщено с торча. Подредактировано, чтоб не лепить на стены.
    private boolean canPlaceBonesOn(World par1World, int par2, int par3, int par4)
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
        return canPlaceBonesOn(par1World, par2, par3 - 1, par4);
    }
    //непосредственно
    private boolean dropBonesIfCantStay(World par1World, int par2, int par3, int par4)
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
    // Прослушиваем изменения вокруг, если блок под нами сломан - разрушаемся и дропаем итем.
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (this.dropBonesIfCantStay(par1World, par2, par3, par4))
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);
            if (!this.canPlaceBonesOn(par1World, par2, par3 - 1, par4) && var6 == 5)
            {
            	this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlockWithNotify(par2, par3, par4, 0);
            }

        }
    }
    //Тут указываем итем, который дропается при уничтожении блока. Указываем итем-заменитель!
    public int idDropped(int i, Random random, int j)
    {
            return UltimateExtender.itemSkull.shiftedIndex;
    }
    //Количество дропа
    public int quantityDropped(Random random)
    {
            return 1;
    }
    //Тип рендера для блока (используется кейс для передачи рендеру?)
    public int getRenderType()
    {
            return -1;
    }
    @Override
    public String getTextureFile()
    {
        return Params.TEXTURE_PATH_BLOCKS;
    }
    //Прозрачный ли блок?
    public boolean isOpaqueCube()
    {
            return false;
    }
    //Рендерить как куб?
    public boolean renderAsNormalBlock()
    {
            return false;
    }
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
    	int p = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 16.0F / 360.0F) - 0.5D) & 15;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, p);
    }
}
