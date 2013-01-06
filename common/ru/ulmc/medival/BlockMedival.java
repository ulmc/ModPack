package ru.ulmc.medival;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockMedival extends Block
{
    public BlockMedival(int blockID)
    {
        super(blockID, Material.rock);
        blockIndexInTexture = 4;
        setHardness(1.5f);
        setResistance(8.0f);
        setStepSound(soundStoneFootstep);
        setBlockName("ReservedMedival");
        
    }
    public BlockMedival(int blockReservedID, float f, float g, String string, int i) {
    	super(blockReservedID, Material.rock);
		// TODO Auto-generated constructor stub
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

}
