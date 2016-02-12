package com.scicraft.seedfinder;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class strongholdFinder {
	
	
	public static xzPair findValidLocation(int searchX, int searchY, int size, List<Biome> paramList, Random random, biomeGenerator generator) {
		// TODO: Find out if we should useQuarterResolutionMap or not
		int x1 = searchX - size >> 2;
		int y1 = searchY - size >> 2;
		int x2 = searchX + size >> 2;
		int y2 = searchY + size >> 2;
		
		int width = x2 - x1 + 1;
		int height = y2 - y1 + 1;
		int[] arrayOfInt = generator.getBiomeData(x1, y1, width, height, true);
		xzPair location = null;
		int numberOfValidFound = 0;
		for (int i = 0; i < width*height; i++) {
			int x = x1 + i % width << 2;
			int y = y1 + i / width << 2;
			if (arrayOfInt[i] > Biome.biomes.length)
				return null;
			Biome localBiome = Biome.biomes[arrayOfInt[i]];
			if ((!paramList.contains(localBiome)) || ((location != null) && (random.nextInt(numberOfValidFound + 1) != 0)))
				continue;
			location = new xzPair(x, y);
			numberOfValidFound++;
		}
		
		return location;
	}
	
	public xzPair[] findStrongholds(long seed, biomeGenerator generator) {
		xzPair[] strongholds = new xzPair[3];
		Random random = new Random();
		random.setSeed(seed);
		
		List<Biome> biomeArrayList = new ArrayList<Biome>();
		
		//TODO: don't be lazy and put them in a list
		for (int i = 0; i < Biome.biomes.length; i++) {
			if ((Biome.biomes[i] != null) && (Biome.biomes[i].type.value1 > 0f)) {
				biomeArrayList.add(Biome.biomes[i]);
			}
		}
		
		double angle = random.nextDouble() * 3.141592653589793D * 2.0D;
		for (int i = 0; i < 3; i++) {
			double distance = (1.25D + random.nextDouble()) * 32.0D;
			int x = (int)Math.round(Math.cos(angle) * distance);
			int z = (int)Math.round(Math.sin(angle) * distance);
			
			
			xzPair location = findValidLocation((x << 4) + 8, (z << 4) + 8, 112, biomeArrayList,random , generator);
			if(location != null){
				x = location.getX() >> 4;
				z = location.getZ() >> 4;
			}
			
			
			strongholds[i] = new xzPair((x << 4), (z << 4));
			angle += 6.283185307179586D / 3.0D;
		}
		return strongholds;
	}
}
