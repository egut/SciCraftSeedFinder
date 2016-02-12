package minecraft.biome;

public class BiomeGenMesa extends BiomeGenBase
{
    private boolean field_150620_aI;

    public BiomeGenMesa(int p_i45380_1_, boolean p_i45380_2_, boolean p_i45380_3_)
    {
        super(p_i45380_1_);
        this.field_150620_aI = p_i45380_3_;
        this.setDisableRain();
        this.setTemperatureRainfall(2.0F, 0.0F);
    }

    protected BiomeGenBase createMutatedBiome(int p_180277_1_)
    {
        boolean var2 = this.biomeID == BiomeGenBase.mesa.biomeID;
        BiomeGenMesa var3 = new BiomeGenMesa(p_180277_1_, var2, this.field_150620_aI);

        if (!var2)
        {
            var3.setHeight(height_LowHills);
            var3.setBiomeName(this.biomeName + " M");
        }
        else
        {
            var3.setBiomeName(this.biomeName + " (Bryce)");
        }

        var3.func_150557_a(this.color, true);
        return var3;
    }
}
