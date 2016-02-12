package com.scicraft.seedfinder;

import minecraft.layer.*;

public class biomeGenerator {
	public GenLayer biomeIndexLayer;
	public GenLayer biomeIndexLayerquarter;
	public biomeGenerator(long seed, int quarter)
	{
		if(quarter == 0)
			biomeIndexLayer = GenLayer.func_180781_a(seed, "")[1]; //1:1 resolution
		else if(quarter == 1)
			biomeIndexLayerquarter = GenLayer.func_180781_a(seed, "")[0]; // 1:4 fourth resolution less calculations
		else
		{
			biomeIndexLayer = GenLayer.func_180781_a(seed, null)[1];
			biomeIndexLayerquarter = GenLayer.func_180781_a(seed, "")[0]; // 1:4 fourth resolution less calculations
		}
			
	}
	
	public int getBiomeAt(int x, int y)
	{
		IntCache.resetIntCache();
		return biomeIndexLayer.getInts(x, y, 1, 1)[0];
	}
	
	public int[] getBiomeData(int x, int y, int width, int height, boolean quarter)
	{
		IntCache.resetIntCache();
		if(quarter)
			return biomeIndexLayerquarter.getInts(x, y, width, height);
		else
			return biomeIndexLayer.getInts(x, y, width, height);
	}
}
