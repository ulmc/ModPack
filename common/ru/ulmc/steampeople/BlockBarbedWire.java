package ru.ulmc.steampeople;

import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockBarbedWire extends BlockBreakable
{
    public BlockBarbedWire(int blockID)
    {
        super(blockID, 0, Material.cactus, false);
        blockIndexInTexture = 0;
        setHardness(2.5f);
        setResistance(10.0f);
        setLightOpacity(0);
        setStepSound(soundStoneFootstep);
        setBlockName("BarbedWire");
        this.setTickRandomly(true);
    }
    public int getRenderBlockPass()
    {
        return 1;
    }
	@Override
    public String getTextureFile()
    {
        return SteamPref.TEXTURE_PATH_BLOCKS;
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
        par5Entity.attackEntityFrom(DamageSource.cactus, 2);
        par5Entity.setInWeb();
    }
}
