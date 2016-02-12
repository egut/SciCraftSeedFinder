package com.scicraft.seedfinder;

import java.util.Random;;

public class structureHut extends structure{
	private Random rnd = new Random();
	
	/*
	 * return the chunk position in the region of the possible structure
	 */
	public xzPair structurePosInRegion(long x, long z, long seed){
		rnd.setSeed((long) x * 341873128712L + (long)z * 132897987541L + seed + 14357617);
		return new xzPair(rnd.nextInt(24), rnd.nextInt(24));
	}
	
	/*
	 * first check if the x pos is valid else return null
	 */
	public xzPair structurePosInRegionFast(long xPart, long zPart, long seed, int lowerThen, int higherThen){
		rnd.setSeed(xPart + zPart + seed + 14357617);
		int xRand = rnd.nextInt(24);
		if(xRand <= lowerThen || xRand >= higherThen)
			return new xzPair(xRand, rnd.nextInt(24));
		else
			return null;
	}
	/*
	 * checks if it will spawn
	 * @see com.scicraft.seedfinder.structure#structureWillSpawn(int xRegion, int zRegion, int xRandom, int zRandom, com.scicraft.seedfinder.biomeGenerator)
	 */
	public boolean structureWillSpawn(int xRegion, int zRegion, int xRandom, int zRandom, biomeGenerator generator){
		if(generator.getBiomeAt(xRegion * 512 + xRandom * 16 + 8, zRegion * 512 +zRandom * 16 + 8) == 6)
			return true;
		return false;
	}
	
}
