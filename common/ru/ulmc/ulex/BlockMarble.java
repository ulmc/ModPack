package ru.ulmc.ulex;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockMarble extends Block
{
    public BlockMarble(int blockID)
    {
        super(blockID, Material.rock);
        blockIndexInTexture = 4;
        setHardness(1.5f);
        setResistance(8.0f);
        setStepSound(soundStoneFootstep);
        setBlockName("Marble");
    }
    @Override
    public String getTextureFile()
    {
        return Params.TEXTURE_PATH_BLOCKS;
    }
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
}
