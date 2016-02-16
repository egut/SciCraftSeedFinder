

import java.util.Random;

import com.scicraft.seedfinder.*;

public class HutandMonumentFinder {
	public final static int HUT = 0;
	public final static int MONUMNET = 1;
	public final static int TOPRIGHT = 0;
	public final static int BOTTOMRIGHT = 1;
	public final static int BOTTOMLEFT = 2;
	public final static int TOPLEFT = 3;
	public static Random rnd = new Random();
	public static int[] xpos = new int[4];
	public static int[] zpos = new int[4];
	public static int[] mxpos = new int[4];
	public static int[] mzpos = new int[4];
	public static int xmon, zmon;
	public static structureHut hut;
	public static structureMonument monument;
	public static bitIterator bitIt;
	public final static int monumnetLimit=22;
	public final static boolean debug=true;

	public static boolean allSwamp(int[] x, int[] z, biomeGenerator generate)
	{
		for(int i = 0; i < 4; i++)
		{
			if(generate.getBiomeAt(x[i] * 16 + 8, z[i] * 16 + 8) != 6)
				return false;
		}
		return true;
	}
	
	private static boolean checkForStructureBR(int x, int z, long seed) {
		if (checkForMonumnetinBR(x, z, seed) || checkForHutinBR(x,z,seed) ) {
			return true;
		}
		return false;
	}

	private static boolean checkForHutinBR(int x, int z, long seed) {
		xzPair coords = hut.structurePosInRegion(x, z, seed);		
		int xrand = coords.getX();
		int zrand = coords.getZ();
		xpos[TOPLEFT] = x  * 32 + xrand;
		zpos[TOPLEFT] = z  * 32 + zrand;
		
		
		return xrand >= 22 && zrand >= 22;
	}

	private static boolean checkForMonumnetinBR(int x, int z, long seed) {
		xzPair coords = monument.structurePosInRegion(x, z, seed);
		int xrand = coords.getX();
		int zrand = coords.getZ();
		mxpos[TOPLEFT] = x  * 32 + xrand;
		mzpos[TOPLEFT] = z  * 32 + zrand;

		return xrand >= monumnetLimit && zrand >= monumnetLimit;
	}



	private static boolean checkForStructureBL(int x, int z, long seed) {
		if (checkForMonumnetinBL(x, z, seed) || checkForHutinBL(x,z,seed) ) {
			return true;
		}
		return false;
	}

	private static boolean checkForHutinBL(int x, int z, long seed) {
		xzPair coords = hut.structurePosInRegion(x, z, seed);		
		int xrand = coords.getX();
		int zrand = coords.getZ();
		xpos[TOPRIGHT] = x  * 32 + xrand;
		zpos[TOPRIGHT] = z  * 32 + zrand;
	
		return xrand <=1 && zrand >= 22;
	}
	
	private static boolean checkForMonumnetinBL(int x, int z, long seed) {
		xzPair coords = monument.structurePosInRegion(x, z, seed);
		int xrand = coords.getX();
		int zrand = coords.getZ();
		mxpos[TOPRIGHT] = x  * 32 + xrand;
		mzpos[TOPRIGHT] = z  * 32 + zrand;

		return xrand <=1 && zrand >= monumnetLimit;
	}


	private static boolean checkForStructureTR(int x, int z, long seed) {
		if (checkForHutinTR(x, z, seed) || checkForMonumnetinTR(x,z,seed) ) {
			return true;
		}
		return false;
	}

	private static boolean checkForHutinTR(int x, int z, long seed) {
		xzPair coords = hut.structurePosInRegion(x, z, seed);		
		int xrand = coords.getX();
		int zrand = coords.getZ();
		xpos[BOTTOMLEFT] = x  * 32 + xrand;
		zpos[BOTTOMLEFT] = z  * 32 + zrand;
		
		return xrand >=22 && zrand <= 1;
	}

	private static boolean checkForMonumnetinTR(int x, int z, long seed) {
		xzPair coords = monument.structurePosInRegion(x, z, seed);
		int xrand = coords.getX();
		int zrand = coords.getZ();
		mxpos[BOTTOMLEFT] = x  * 32 + xrand;
		mzpos[BOTTOMLEFT] = z  * 32 + zrand;

		return xrand >= monumnetLimit && zrand <= 1;
	}


	private static boolean checkForStructureTL(int x, int z, long seed) {
		if (checkForHutinTL(x, z, seed)  || checkForMonumnetinTL(x,z,seed) ) {
			return true;
		}
		return false;
	}

	private static boolean checkForHutinTL(int x, int z, long seed) {
		xzPair coords = hut.structurePosInRegion(x, z, seed);		
		int xrand = coords.getX();
		int zrand = coords.getZ();
		xpos[BOTTOMRIGHT] = x  * 32 + xrand;
		zpos[BOTTOMRIGHT] = z  * 32 + zrand;
		
		return xrand <=1 && zrand <= 1;
	}
	
	private static boolean checkForMonumnetinTL(int x, int z, long seed) {
		xzPair coords = monument.structurePosInRegion(x, z, seed);
		int xrand = coords.getX();
		int zrand = coords.getZ();
		mxpos[BOTTOMRIGHT] = x  * 32 + xrand;
		mzpos[BOTTOMRIGHT] = z  * 32 + zrand;

		return xrand <=1 && zrand <= 1;
	}
	
	private static int printCorner(int corner, biomeGenerator generate) {
		int c = 0; 
		if (!(xpos[corner] == 0 && zpos[corner] == 0)) {
			if( hut.structureWillSpawn(0,0,xpos[corner], zpos[corner], generate)) {
				System.out.print(" hut: (" + (xpos[corner] * 16) + "," + (zpos[corner] * 16) +")");
				c++;
			}
		}
		if (!(mxpos[corner] == 0 && mzpos[corner] == 0)) {
			if (monument.structureWillSpawn(0,0,mxpos[corner], mzpos[corner], generate)) {	
				System.out.print(" monument: (" + (mxpos[corner] * 16) + "," + (mzpos[corner] * 16) +")");
				c++;
			}
		}
		return c;
	}

	private static int hutorMon(int corner) {
		if (!(xpos[corner] == 0 && zpos[corner] == 0)) {
			return HUT;
		} else if (!(mxpos[corner] == 0 && mzpos[corner] == 0)) {
			return MONUMNET;
		} else {
			System.out.println("err m: " + (mxpos[corner] * 16) + " " + (mzpos[corner] * 16));
			System.out.println("err h: " + (xpos[corner] * 16) + " " + (zpos[corner] * 16));
		}
		return 100;
	}

	private static boolean checkCorner(int corner, biomeGenerator generate) {
		boolean spawnHut = false;
		boolean spawnMon = false;
		//System.out.print(" " + corner + " " +xpos[corner]  +", " + zpos[corner] );
		//System.out.print(" " + corner + " " +mxpos[corner]  +", " + mzpos[corner] );
		if (!(xpos[corner] == 0 && zpos[corner] == 0)) {
			spawnHut =  hut.structureWillSpawn(0,0,xpos[corner], zpos[corner], generate);
		} 
		if (!(mxpos[corner] == 0 && mzpos[corner] == 0)) {
			spawnMon =  monument.structureWillSpawn(0,0,mxpos[corner], mzpos[corner], generate);
		}
		//System.out.println(" " + corner + " " +spawnHut +" " + spawnMon );
		return (spawnHut || spawnMon);
	}


	public static void checkIfValid(long seed) {
		long seedBit = seed & 281474976710655L;	//magic number
		bitIt = new bitIterator(seedBit);
		int structure = 0;

		System.out.println("checking hut and monumnet " + seed);
		for(int i = 0; i < 4; i++) {
			structure += hutorMon(i);
		}

		while(bitIt.hasNext()){
			long seedFull = bitIt.next();
			biomeGenerator generate = new biomeGenerator(seedFull, 2);
			if(checkCorner(BOTTOMRIGHT, generate) &&
			    checkCorner(TOPRIGHT, generate) &&
			    checkCorner(TOPLEFT, generate) &&
			    checkCorner(BOTTOMLEFT, generate)) {
			    System.out.print("Seed: " + seedFull);
			    int c = 0;
			    for(int i = 0; i < 4; i++) {
					c += printCorner(i, generate);
				}
				System.out.println(" structures: " + c);

			}
		}

	}


	public static void checkBits(long seed) {	
		long seedBit = seed & 281474976710655L;	//magic number
		bitIt = new bitIterator(seedBit);
		
		
		System.out.println("checking bits of base " + seedBit);
		System.out.println((xpos[0] * 16) + " " + (zpos[0] * 16));
		System.out.println((xpos[1] * 16) + " " + (zpos[1] * 16));
		System.out.println((xpos[2] * 16) + " " + (zpos[2] * 16));
		System.out.println((xpos[3] * 16) + " " + (zpos[3] * 16));
		
		while(bitIt.hasNext()){
			long seedFull = bitIt.next();
			biomeGenerator generate = new biomeGenerator(seedFull, 2);
			if(allSwamp(xpos, zpos, generate))		
				System.out.println(seedFull);
		}
		
	}
	
	
	public static void main(String[] args) {
		long startSeed = -281474976710658L; 
		while (startSeed < -281474976710656L || startSeed > 281470000000000L ) {
			startSeed = rnd.nextLong(); //Long.parseLong(args[0]);	
		} 
		if(debug) startSeed = 148372070833119L;
		if(debug) System.out.println("Seed:" + startSeed);
		long endSeed = 281474976710656L; //higher than 2^48 will be useless
		int radius = 4;
		long currentSeed;
		int xr, zr;
		hut = new structureHut();
		monument = new structureMonument();
		for(currentSeed = startSeed; currentSeed <= endSeed; currentSeed++){			
			
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
					for(int i = 0; i < 4; i++) {
						xpos[i] = 0;
						zpos[i] = 0;
						mxpos[i] = 0;
						mzpos[i] = 0;
					}
				}
			}
		}
	}	
}