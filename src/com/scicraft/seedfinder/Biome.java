package com.scicraft.seedfinder;

import java.util.HashMap;



public class Biome {
	public static final HashMap<String,Biome> biomeMap = new HashMap<String,Biome>();
	public static final BiomeType typeA = new BiomeType(0.1F, 0.2F);
	public static final BiomeType typeB = new BiomeType(-0.5F, 0.0F);
	public static final BiomeType typeC = new BiomeType(-1.0F, 0.1F);
	public static final BiomeType typeD = new BiomeType(-1.8F, 0.1F);
	public static final BiomeType typeE = new BiomeType(0.125F, 0.05F);
	public static final BiomeType typeF = new BiomeType(0.2F, 0.2F);
	public static final BiomeType typeG = new BiomeType(0.45F, 0.3F);
	public static final BiomeType typeH = new BiomeType(1.5F, 0.025F);
	public static final BiomeType typeI = new BiomeType(1.0F, 0.5F);
	public static final BiomeType typeJ = new BiomeType(0.0F, 0.025F);
	public static final BiomeType typeK = new BiomeType(0.1F, 0.8F);
	public static final BiomeType typeL = new BiomeType(0.2F, 0.3F);
	public static final BiomeType typeM = new BiomeType(-0.2F, 0.1F);
	
	public static final Biome[] biomes = new Biome[256];
	public static final Biome ocean				   = new Biome("Ocean",				     0,     typeC);
	public static final Biome plains			   = new Biome("Plains",				 1, 	typeA);
	public static final Biome desert			   = new Biome("Desert",				 2, 	typeE);
	public static final Biome extremeHills		   = new Biome("Extreme Hills",		     3, 	typeI);
	public static final Biome forest			   = new Biome("Forest",				 4, 	typeA);
	public static final Biome taiga			  	   = new Biome("Taiga",				     5, 	typeF);
	public static final Biome swampland			   = new Biome("Swampland",			     6, 	typeM);
	public static final Biome river				   = new Biome("River",				     7, 	typeB);
	public static final Biome hell				   = new Biome("Hell",				     8,     typeA);
	public static final Biome sky				   = new Biome("Sky",					 9,    	typeA);
	public static final Biome frozenOcean		   = new Biome("Frozen Ocean",		    10,    	typeC);
	public static final Biome frozenRiver		   = new Biome("Frozen River",		    11,    	typeB);
	public static final Biome icePlains			   = new Biome("Ice Plains",			12,    	typeE);
	public static final Biome iceMountains		   = new Biome("Ice Mountains",		    13,    	typeG);
	public static final Biome mushroomIsland	   = new Biome("Mushroom Island",	    14, 	typeL);
	public static final Biome mushroomIslandShore  = new Biome("Mushroom Island Shore", 15,  	typeJ);
	public static final Biome beach				   = new Biome("Beach",				    16, 	typeJ);
	public static final Biome desertHills		   = new Biome("Desert Hills",		    17, 	typeG);
	public static final Biome forestHills		   = new Biome("Forest Hills",		    18, 	typeG);
	public static final Biome taigaHills		   = new Biome("Taiga Hills",		    19, 	typeG);
	public static final Biome extremeHillsEdge	   = new Biome("Extreme Hills Edge",	20,     typeI.getExtreme());
	public static final Biome jungle			   = new Biome("Jungle",				21, 	typeA);
	public static final Biome jungleHills		   = new Biome("Jungle Hills",		    22, 	typeG);
	public static final Biome jungleEdge		   = new Biome("Jungle Edge",		    23, 	typeA);
	public static final Biome deepOcean			   = new Biome("Deep Ocean",			24, 	typeD);
	public static final Biome stoneBeach		   = new Biome("Stone Beach",		    25,    	typeK);
	public static final Biome coldBeach			   = new Biome("Cold Beach",			26,    	typeJ);
	public static final Biome birchForest		   = new Biome("Birch Forest",		    27, 	typeA);
	public static final Biome birchForestHills	   = new Biome("Birch Forest Hills",	28, 	typeG);
	public static final Biome roofedForest		   = new Biome("Roofed Forest",		    29, 	typeA);
	public static final Biome coldTaiga			   = new Biome("Cold Taiga",			30, 	typeF);
	public static final Biome coldTaigaHills	   = new Biome("Cold Taiga Hills",	    31, 	typeG);
	public static final Biome megaTaiga			   = new Biome("Mega Taiga",			32, 	typeF);
	public static final Biome megaTaigaHills	   = new Biome("Mega Taiga Hills",	    33, 	typeG);
	public static final Biome extremeHillsPlus	   = new Biome("Extreme Hills+",		34, 	typeI);
	public static final Biome savanna			   = new Biome("Savanna",			    35, 	typeE);
	public static final Biome savannaPlateau	   = new Biome("Savanna Plateau",	    36,    	typeH);
	public static final Biome mesa				   = new Biome("Mesa",				    37, 	typeA);
	public static final Biome mesaPlateauF		   = new Biome("Mesa Plateau F",		38,    	typeH);
	public static final Biome mesaPlateau		   = new Biome("Mesa Plateau",		    39,    	typeH);
	
	
	public static final Biome oceanM			   = new Biome("Ocean M",				   128);
	public static final Biome sunflowerPlains	   = new Biome("Sunflower Plains",		   129);
	public static final Biome desertM			   = new Biome("Desert M",				   130);
	public static final Biome extremeHillsM		   = new Biome("Extreme Hills M",		   131);
	public static final Biome flowerForest		   = new Biome("Flower Forest",			   132);
	public static final Biome taigaM			   = new Biome("Taiga M",				   133);
	public static final Biome swamplandM		   = new Biome("Swampland M",			   134);
	public static final Biome riverM			   = new Biome("River M",				   135);
	public static final Biome hellM				   = new Biome("Hell M",				   136);
	public static final Biome skyM				   = new Biome("Sky M",					   137);
	public static final Biome frozenOceanM		   = new Biome("Frozen Ocean M",		   138);
	public static final Biome frozenRiverM		   = new Biome("Frozen River M",		   139);
	public static final Biome icePlainsSpikes	   = new Biome("Ice Plains Spikes",		   140);
	public static final Biome iceMountainsM		   = new Biome("Ice Mountains M",		   141);
	public static final Biome mushroomIslandM	   = new Biome("Mushroom Island M",		   142);
	public static final Biome mushroomIslandShoreM = new Biome("Mushroom Island Shore M",  143);
	public static final Biome beachM			   = new Biome("Beach M",				   144);
	public static final Biome desertHillsM		   = new Biome("Desert Hills M",		   145);
	public static final Biome forestHillsM		   = new Biome("Forest Hills M",		   146);
	public static final Biome taigaHillsM		   = new Biome("Taiga Hills M",			   147);
	public static final Biome extremeHillsEdgeM	   = new Biome("Extreme Hills Edge M",	   148);
	public static final Biome jungleM			   = new Biome("Jungle M",				   149);
	public static final Biome jungleHillsM		   = new Biome("Jungle Hills M",		   150);
	public static final Biome jungleEdgeM		   = new Biome("Jungle Edge M",			   151);
	public static final Biome deepOceanM		   = new Biome("Deep Ocean M",			   152);
	public static final Biome stoneBeachM		   = new Biome("Stone Beach M",			   153);
	public static final Biome coldBeachM		   = new Biome("Cold Beach M",			   154);
	public static final Biome birchForestM		   = new Biome("Birch Forest M",		   155);
	public static final Biome birchForestHillsM	   = new Biome("Birch Forest Hills M",	   156);
	public static final Biome roofedForestM		   = new Biome("Roofed Forest M",		   157);
	public static final Biome coldTaigaM		   = new Biome("Cold Taiga M",			   158);
	public static final Biome coldTaigaHillsM	   = new Biome("Cold Taiga Hills M",	   159);
	public static final Biome megaSpruceTaiga	   = new Biome("Mega Spruce Taiga",		   160);
	public static final Biome megaSpurceTaigaHills = new Biome("Mega Spruce Taiga (Hills)",161);
	public static final Biome extremeHillsPlusM	   = new Biome("Extreme Hills+ M",		   162);
	public static final Biome savannaM			   = new Biome("Savanna M",				   163);
	public static final Biome savannaPlateauM	   = new Biome("Savanna Plateau M",		   164);
	public static final Biome mesaBryce			   = new Biome("Mesa (Bryce)",			   165);
	public static final Biome mesaPlateauFM		   = new Biome("Mesa Plateau F M",		   166);
	public static final Biome mesaPlateauM		   = new Biome("Mesa Plateau M",		   167);
	
	
	public String name;
	public int index;
	public int color;
	public BiomeType type;
	
	public Biome(String name, int index) {
		this(name, index, biomes[index - 128].type.getRare());
	}
	
	public Biome(String name, int index, BiomeType type) {
		biomes[index] = this;
		this.name = name;
		this.index = index;
		this.type = type;
		biomeMap.put(name, this);
	}
	
	public String toString() {
		return "Biome."+ name;
	}
	
	public static int indexFromName(String name) {
		Biome biome = biomeMap.get(name);
		if (biome != null)
			return biome.index;
		return -1;
	}
	  
	
	public static final class BiomeType { // TODO: Rename once we figure out what this actually is!
		public float value1, value2;
		public BiomeType(float value1, float value2) {
			this.value1 = value1;
			this.value2 = value2;
		}
		
		public BiomeType getExtreme() {
			return new BiomeType(value1 * 0.8F, value2 * 0.6F);
		}
		public BiomeType getRare(){ 
			return new BiomeType(value1 + 0.1F, value2 + 0.2F);
		}
	}
	
	

}
