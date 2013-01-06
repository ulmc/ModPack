package ru.ulmc.ulex;

import java.util.Random;

import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenLightCrystals extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        for (int var6 = 0; var6 < 64; ++var6)
        {
            int var7 = par3 + par2Random.nextInt(16);
            int var8 = par4 + par2Random.nextInt(4);
            int var9 = par5 + par2Random.nextInt(8);

            par1World.setBlockAndMetadata(var7, var8, var9, UltimateExtender.blockWhiteCrystal.blockID, par2Random.nextInt(6));
           
        }

        return true;
    }
}
