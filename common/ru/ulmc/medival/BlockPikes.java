package ru.ulmc.medival;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockPikes extends BlockBreakable
{
    public BlockPikes(int blockID)
    {
        super(blockID, 0, Material.cactus, false);
        blockIndexInTexture = 0;
        setHardness(2.5f);
        setResistance(10.0f);
        setLightOpacity(0);
        setStepSound(soundStoneFootstep);
        setBlockName("SharpSpikes");
        this.setTickRandomly(true);
    }
    public int getRenderBlockPass()
    {
        return 0;
    }
    public int getRenderType()
    {
        return 1;
    }
	@Override
    public String getTextureFile()
    {
        return MedivalPref.TEXTURE_PATH_BLOCKS;
    }
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float var5 = 0.0625F;
        return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(0.0F-var5, 0.0F-var5, 0.0F-var5, 1.0F+var5, 1.0F+var5, 1.0F+var5);
    }
    public boolean isOpaqueCube()
    {
            return false;
    }
    public boolean renderAsNormalBlock()
    {
            return false;
    }
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.attackEntityFrom(DamageSource.cactus, 3);
        //par5Entity.setInWeb();
    }
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST,  true) ||
               par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST,  true) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true) ||
               canPlacePikesOn(par1World, par2, par3 - 1, par4);
    }
    private boolean canPlacePikesOn(World par1World, int par2, int par3, int par4)
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
    private boolean dropPikesIfCantStay(World par1World, int par2, int par3, int par4)
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
        if (this.dropPikesIfCantStay(par1World, par2, par3, par4))
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);
            boolean var7 = false;

            if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true) && var6 == 1)
            {
                var7 = true;
            }

            if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true) && var6 == 2)
            {
                var7 = true;
            }

            if (!par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true) && var6 == 3)
            {
                var7 = true;
            }

            if (!par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true) && var6 == 4)
            {
                var7 = true;
            }

            if (!this.canPlacePikesOn(par1World, par2, par3 - 1, par4) && var6 == 5)
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
}
