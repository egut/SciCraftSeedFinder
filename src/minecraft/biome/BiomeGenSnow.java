package minecraft.biome;

public class BiomeGenSnow extends BiomeGenBase
{
    public BiomeGenSnow(int p_i45378_1_, boolean p_i45378_2_)
    {
        super(p_i45378_1_);
    }
    
    protected BiomeGenBase createMutatedBiome(int p_180277_1_)
    {
        BiomeGenBase var2 = (new BiomeGenSnow(p_180277_1_, true)).func_150557_a(13828095, true).setBiomeName(this.biomeName + " Spikes").setEnableSnow().setTemperatureRainfall(0.0F, 0.5F).setHeight(new BiomeGenBase.Height(this.minHeight + 0.1F, this.maxHeight + 0.1F));
        var2.minHeight = this.minHeight + 0.3F;
        var2.maxHeight = this.maxHeight + 0.4F;
        return var2;
    }
}
