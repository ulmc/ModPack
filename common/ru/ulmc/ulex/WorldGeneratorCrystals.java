package ru.ulmc.ulex;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;

public class WorldGeneratorCrystals implements IWorldGenerator  
{
	 public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	 {
	  switch (world.provider.worldType)
	  {
	   case -1: generateNether(world, random, chunkX*16, chunkZ*16);
	   case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
	  }
	 }

	  

	  private void generateSurface(World world, Random random, int blockX, int blockZ) 
	 {
		  
	  int Xcoord = blockX + random.nextInt(16);
	  int Ycoord = 30 + random.nextInt(50);
	  int Zcoord = blockZ + random.nextInt(16);
	  
	  (new WorldGenMinable(UltimateExtender.blockSalt.blockID, 10)).generate(world, random, Xcoord, Ycoord, Zcoord);
	 }
	 
	 private void generateNether(World world, Random random, int blockX, int blockZ) 
	 {
	  
	 }
	}
