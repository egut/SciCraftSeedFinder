

import java.util.Random;

import com.scicraft.seedfinder.*;

public class QuadHutMonFinder {
	public final static int TOPRIGHT = 0;
	public final static int BOTTOMRIGHT = 1;
	public final static int BOTTOMLEFT = 2;
	public final static int TOPLEFT = 3;
	public static Random rnd = new Random();
	public static int[] xpos = new int[4];
	public static int[] zpos = new int[4];
	public static int xmon, zmon;
	public static structureHut hut;
	public static structureMonument monument;
	public static bitIterator bitIt;
	public final static int monumnetLimitLo=16;
	public final static int monumnetLimitHi=24;

	public final static int xRegion = 0;
	public final static int zRegion = 0;
	
	public static boolean allSwamp(int[] x, int[] z, biomeGenerator generate)
	{
		for(int i = 0; i < 4; i++)
		{
			if(hut.structureWillSpawn(xRegion, zRegion, x[i], z[i], generate) == false) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkForStructureBR(int x, int z, long seed) {
		xzPair coords = hut.structurePosInRegion(x, z, seed);		
		int xrand = coords.getX();
		int zrand = coords.getZ();
		xpos[TOPLEFT] = x  * 32 + xrand;
		zpos[TOPLEFT] = z  * 32 + zrand;
		xmon = xrand;
		zmon = zrand;
		
		return xrand >= 22 && zrand >= 22;
	}

	private static void checkForMonumnetinBR(int x, int z, long seed, biomeGenerator generate) {
		xzPair coords = monument.structurePosInRegion(x, z, seed);
		if ( coords.getX() >= monumnetLimitHi && coords.getZ() >= monumnetLimitHi ) {
			int mxpos = x  * 32 + coords.getX();
			int mzpos = z  * 32 + coords.getZ();
			System.out.print(" Monument possible inside: @(" + coords.getX() + "," + coords.getZ() + ")");
			System.out.print(" possible: (" + (mxpos * 16) + "," + (mzpos * 16) +")");
			if (monument.structureWillSpawn(xRegion, zRegion, mxpos, mzpos, generate)) {
				System.out.print(" found MONUMNET: (" + (mxpos * 16) + "," + (mzpos * 16) +")");
			}
		} else if ( coords.getX() >= monumnetLimitLo && coords.getZ() >= monumnetLimitLo ) {
			int mxpos = x  * 32 + coords.getX();
			int mzpos = z  * 32 + coords.getZ();
			System.out.print("debug" + mxpos  + "," + mzpos + "," + coords.getX() + "," +coords.getZ() + "," +x+ ", " +z+ ", ");
			System.out.print(" Monument possible outside: @(" + coords.getX() + "," + coords.getZ() + ")");
			if (monument.structureWillSpawn(xRegion, zRegion, mxpos, mzpos, generate)) {
				System.out.print(" found monument: (" + (mxpos * 16) + "," + (mzpos * 16) +")");
			}
		} else {
			System.out.print(" Monument skip: @(" + coords.getX() + "," + coords.getZ() + ") < @(" + monumnetLimitLo + "," + monumnetLimitLo + ")");
			
		}
	}

	private static boolean checkForStructureBL(int x, int z, long seed) {
		xzPair coords = hut.structurePosInRegion(x, z, seed);		
		int xrand = coords.getX();
		int zrand = coords.getZ();
		xpos[TOPRIGHT] = x  * 32 + xrand;
		zpos[TOPRIGHT] = z  * 32 + zrand;
	
		return xrand <=1 && zrand >= 22;
	}
	
	private static boolean checkForStructureTR(int x, int z, long seed) {
		xzPair coords = hut.structurePosInRegion(x, z, seed);		
		int xrand = coords.getX();
		int zrand = coords.getZ();
		xpos[BOTTOMLEFT] = x  * 32 + xrand;
		zpos[BOTTOMLEFT] = z  * 32 + zrand;
		
		return xrand >=22 && zrand <= 1;
	}

	private static boolean checkForStructureTL(int x, int z, long seed) {
		xzPair coords = hut.structurePosInRegion(x, z, seed);		
		int xrand = coords.getX();
		int zrand = coords.getZ();
		xpos[BOTTOMRIGHT] = x  * 32 + xrand;
		zpos[BOTTOMRIGHT] = z  * 32 + zrand;
		
		return xrand <=1 && zrand <= 1;
	}
	

	private static int numberDiff(int x, int y) {
		int b=10000000;
		return Math.abs((x+b)-(y+b));
	}

	private static int dist(int x1, int x2, int y1, int y2) {
		return (int) Math.sqrt((double) numberDiff(x1,x2)*numberDiff(x1,x2) + numberDiff(y1,y2)*numberDiff(y1,y2));

	}	

	public static void printQuadHut() {
		int minX = xpos[0];
		int maxX = xpos[0];
		int minZ = zpos[0];
		int maxZ = zpos[0];

		for(int i = 1; i < 4; i++) {
			if (xpos[i] > maxX) {
				maxX = xpos[i];
			} else if (xpos[i] < minX) {
				minX = xpos[i];
			}

			if (zpos[i] > maxZ) {
				maxZ = zpos[i];
			} else if (zpos[i] < minZ) {
				minZ = zpos[i];
			}
		}

		//Middle
		int midX = minX * 16 + numberDiff(maxX * 16, minX * 16)/2;
		int midZ = minZ * 16+ numberDiff(maxZ * 16, minZ * 16)/2;

		System.out.print(" Quad, Origo: (" + midX + "," + midZ + ")");
		System.out.print(" hut: (" + (xpos[0] * 16) + "," + (zpos[0] * 16) + ") d:" + dist(midX, (xpos[0] * 16), midZ, (zpos[0] * 16)) + "");
		System.out.print(" hut: (" + (xpos[1] * 16) + "," + (zpos[1] * 16) + ") d:" + dist(midX, (xpos[1] * 16), midZ, (zpos[1] * 16)) + "");
		System.out.print(" hut: (" + (xpos[2] * 16) + "," + (zpos[2] * 16) + ") d:" + dist(midX, (xpos[2] * 16), midZ, (zpos[2] * 16)) + "");
		System.out.print(" hut: (" + (xpos[3] * 16) + "," + (zpos[3] * 16) + ") d:" + dist(midX, (xpos[3] * 16), midZ, (zpos[3] * 16)) + "");

	}

	
	/* This will will do check all seeds
	 * By first verify that it will spawn a quad witch hut, then if its valid check if a 
	 * monument will spawn inside. This is done by only check the top left region 
	 * As it has the most amount of chunks that are available. It will miss a few possible
	 * spots. The top left will with limits have up to 27 valid chunks for spawning. 

	*/
	public static void checkIfValid(long seed) {	
		long seedBit = seed & 281474976710655L;	//magic number
		bitIt = new bitIterator(seedBit);
		xzPair monCords = null;
		
		System.out.println("Right possible: " + seed);				
		while(bitIt.hasNext()){
			long seedFull = bitIt.next();
			biomeGenerator generate = new biomeGenerator(seedFull, 2);
			if(allSwamp(xpos, zpos, generate)){
				//Quad hut calc.	
				System.out.print("Seed: " + seedFull);
				printQuadHut();
				checkForMonumnetinBR(xmon, zmon, seed, generate);
				System.out.println();
			}

		}
		
	}
	
	
	public static void main(String[] args) {
		long startSeed = -281474976710658L; 
		while (startSeed < -281474976710656L || startSeed > 281470000000000L ) {
			startSeed = rnd.nextLong(); //Long.parseLong(args[0]);	
		} 
		startSeed = -96928167637521L;
		System.out.println(startSeed);
		long endSeed = 281474976710656L; //higher than 2^48 will be useless
		int radius = 4;
		long currentSeed;
		int xr, zr;
		long count = 0;
		hut = new structureHut();
		monument = new structureMonument();
		for(currentSeed = startSeed; currentSeed <= endSeed; currentSeed++){			
			count += 1;
			for(int x=-radius; x<radius - 1; x+=2) {	
				
				long xPart = hut.xPart(x);
				
				for(int z=-radius; z<radius - 1; z+=2) {
					
					long zPart = hut.zPart(z);
					xzPair coords = hut.structurePosInRegionFast(xPart, zPart, currentSeed, 1, 22);
					
					if(coords != null){
						xr = coords.getX();
						zr = coords.getZ();
						
						
						if (xr <= 1) {
							
							if( zr <= 1 ) {
								// candidate witch hut, is in the top left of the 32x32 chunk array
								// this means that to be in a quad it would be in bottom right of the quad
								
								// check the 32x32 chunk area neighbors to the left and above
								if ( checkForStructureTR(x-1, z, currentSeed) && 
									checkForStructureBR(x-1, z-1, currentSeed) &&
									checkForStructureBL(x, z-1, currentSeed)) {	
										xpos[BOTTOMRIGHT] =  x * 32 + xr;
										zpos[BOTTOMRIGHT] =  z * 32 + zr;
										checkIfValid(currentSeed);			
								}
								
							}
							else if( zr >= 22 ){
								// candidate witch hut, is in the bottom left of the 32x32 chunk array
								// this means that to be in a quad it would be in top right of the quad
								
								// check the 32x32 chunk area neighbors to the left and below
								if ( checkForStructureTL(x, z+1, currentSeed) && 
									checkForStructureTR(x-1, z+1, currentSeed) &&
									checkForStructureBR(x-1, z, currentSeed)) {
										xpos[TOPRIGHT] =  x  * 32 + xr;
										zpos[TOPRIGHT] =  z  * 32 + zr;
										checkIfValid(currentSeed);
								}
							}
		
						} else{							
							if( zr <= 1 ) {
								// candidate witch hut, is in the top right of the 32x32 chunk array
								// this means that to be in a quad it would be in bottom left of the quad
								
								// check the 32x32 chunk area neighbors to the right and above
								if ( checkForStructureBR(x, z-1, currentSeed) && 
									checkForStructureBL(x+1, z-1, currentSeed) && 
									checkForStructureTL(x+1, z, currentSeed)) {
										xpos[BOTTOMLEFT] =  x  * 32 + xr;
										zpos[BOTTOMLEFT] =  z  * 32 + zr;
										checkIfValid(currentSeed);

								}
							}
							else if( zr >= 22 ){						
								// candidate witch hut, is in the bottom right of the 32x32 chunk array
								// this means that to be in a quad it would be in top left of the quad
								
								// check the 32x32 chunk area neighbors to the right and below
								if ( checkForStructureBL(x+1, z, currentSeed) && 
									checkForStructureTL(x+1, z+1, currentSeed) && 
									checkForStructureTR(x, z+1, currentSeed)) {
										xpos[TOPLEFT] =  x  * 32 + xr;
										zpos[TOPLEFT] =  z  * 32 + zr;
										checkIfValid(currentSeed);									
								}	
							}
						}
					}
				}
			}
		}
		System.out.println("Checked: " + count + ", bye!");
	}	
}