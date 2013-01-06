package ru.ulmc.ulex;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockReinforcedConcrete extends Block
{
    public BlockReinforcedConcrete(int blockID)
    {
        super(blockID, Material.iron);
        blockIndexInTexture = 2;
        setHardness(10.0f);
        setResistance(1000.0f);
        setStepSound(soundStoneFootstep);
        setBlockName("Reinforced Concrete");
    }
    @Override
    public String getTextureFile()
    {
        return Params.TEXTURE_PATH_BLOCKS;
    }
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
    @Override
    public int getBlockTextureFromSide(int side)
    {
       switch (side)
       {
       case 0:
    	   return 3;
       case 1:
    	   return 3;
       }
        return blockIndexInTexture;
    }
}
