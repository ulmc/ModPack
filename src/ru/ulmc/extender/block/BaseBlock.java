package ru.ulmc.extender.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BaseBlock extends Block
{
    public BaseBlock(int blockID, Material material, String systemBlockName,  float hardness, float resistance, StepSound stepSound)
    {
        super(blockID, material);
        setTextureName("ulex:" + systemBlockName);
        setHardness(hardness);
        setResistance(resistance);
        setStepSound(stepSound);
        setUnlocalizedName(systemBlockName);
        setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
}
