package minecraft.biome;

public class BiomeGenPlains extends BiomeGenBase
{
    protected boolean field_150628_aC;

    protected BiomeGenPlains(int p_i1986_1_)
    {
        super(p_i1986_1_);
        this.setTemperatureRainfall(0.8F, 0.4F);
        this.setHeight(height_LowPlains);
    }

    protected BiomeGenBase createMutatedBiome(int p_180277_1_)
    {
        BiomeGenPlains var2 = new BiomeGenPlains(p_180277_1_);
        var2.setBiomeName("Sunflower Plains");
        var2.field_150628_aC = true;
        var2.setColor(9286496);
        var2.field_150609_ah = 14273354;
        return var2;
    }
}
