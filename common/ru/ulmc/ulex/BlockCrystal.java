package ru.ulmc.ulex;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.UP;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCrystal extends BlockContainer
{
	private Class CrystalEntityClass;
	protected ItemCrystal itemDrop;
	private String path;
    public BlockCrystal(int i, Class class1, float aHardness, float aResistance, String aBlockName, int aBlockIndexInTexture)
    {
            super(i, Material.ice);
            CrystalEntityClass = class1;
        	blockIndexInTexture = aBlockIndexInTexture;
            setHardness(aHardness);
            setResistance(aResistance);
            setBlockName(aBlockName);
            setLightOpacity(3);
            this.setTextureFile(getTextureFile());
            setStepSound(soundGlassFootstep);
    }
    @Override
    public String getTextureFile()
    {
        return Params.TEXTURE_PATH_BLOCKS;
    }
    public TileEntity getBlockEntity()
    {
            try
            {
                    return (TileEntity)CrystalEntityClass.newInstance();
            }
            catch (Exception exception)
            {
                    throw new RuntimeException(exception);
            }
    }
    public TileEntity createNewTileEntity(World var1)
    {
    	TileEntityCrystal tileEntityCrystal= new TileEntityCrystal();
    	tileEntityCrystal.setAngle(MathHelper.getRandomIntegerInRange(new Random(), 0, 16));
        return tileEntityCrystal;
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
    	setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);
    	return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }
    public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
    {
        ForgeDirection dir = ForgeDirection.getOrientation(par5);
        return (dir == DOWN  && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN )) ||
               (dir == UP    && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP   )) ||
               (dir == NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH)) ||
               (dir == SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH)) ||
               (dir == WEST  && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST )) ||
               (dir == EAST  && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ));
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST ) ||
               par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST ) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH) ||
               par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP   ) ||
               par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN );
    }
    private boolean checkIfAttachedToBlock(World par1World, int par2, int par3, int par4)
    {
        if (!this.canPlaceBlockAt(par1World, par2, par3, par4))
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
            return false;
        }
        else
        {
            return true;
        }
    }
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (this.checkIfAttachedToBlock(par1World, par2, par3, par4))
        {
        	TileEntityCrystal myTile = (TileEntityCrystal) par1World.getBlockTileEntity(par2, par3, par4);
            int var6 = myTile.getSide();
            boolean var7 = false;

            if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST) && var6 == 1)
            {
                var7 = true;
            }

            if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST) && var6 == 2)
            {
                var7 = true;
            }

            if (!par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH) && var6 == 3)
            {
                var7 = true;
            }

            if (!par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH) && var6 == 4)
            {
                var7 = true;
            }

            if (!par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP) && var6 == 5)
            {
                var7 = true;
            }
            if (!par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN) && var6 == 0)
            {
                var7 = true;
            }
            if (var7)
            {
                this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
                par1World.setBlockWithNotify(par2, par3, par4, 0);
                
            }
        }
    }
    @SideOnly(Side.CLIENT)

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
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
    public void updateBlockMetadata(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8)
    {
        int var9 = par1World.getBlockMetadata(par2, par3, par4);
        int var10 = var9 & 8;
        var9 &= 7;
        var9 = -1;

        if (par5 == 0 && par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN))
        {
            var9 = 0;
        }

        if (par5 == 1 && par1World.isBlockSolidOnSide(par2, par3 - 1, par4, UP))
        {
            var9 = 5;
        }

        if (par5 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH))
        {
            var9 = 4;
        }

        if (par5 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH))
        {
            var9 = 3;
        }

        if (par5 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST))
        {
            var9 = 2;
        }

        if (par5 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST))
        {
            var9 = 1;
        }

        if (var9 == -1)
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
        }
        else
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, itemDrop.getType());
            TileEntityCrystal myTile = (TileEntityCrystal)(par1World.getBlockTileEntity(par2, par3, par4));
            int side = var9 + var10;
            myTile.setSide(side);
            Minecraft mc = Minecraft.getMinecraft();
	    	mc.thePlayer.sendChatMessage("Angle:" + side);
        }
    }
    public void setIDs(ItemCrystal anItem)
    {
    	itemDrop = anItem;
    }
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }

}
