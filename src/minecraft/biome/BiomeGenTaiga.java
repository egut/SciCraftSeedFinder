package minecraft.biome;

public class BiomeGenTaiga extends BiomeGenBase
{
    public BiomeGenTaiga(int p_i45385_1_, int p_i45385_2_)
    {
        super(p_i45385_1_);
    }
    
    protected BiomeGenBase createMutatedBiome(int p_180277_1_)
    {
        return this.biomeID == BiomeGenBase.megaTaiga.biomeID ? (new BiomeGenTaiga(p_180277_1_, 2)).func_150557_a(5858897, true).setBiomeName("Mega Spruce Taiga").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.25F, 0.8F).setHeight(new BiomeGenBase.Height(this.minHeight, this.maxHeight)) : super.createMutatedBiome(p_180277_1_);
    }
}
