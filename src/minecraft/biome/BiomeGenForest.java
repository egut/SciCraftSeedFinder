package minecraft.biome;

public class BiomeGenForest extends BiomeGenBase
{
    private int field_150632_aF;

    public BiomeGenForest(int p_i45377_1_, int p_i45377_2_)
    {
        super(p_i45377_1_);
        this.field_150632_aF = p_i45377_2_;

        this.setFillerBlockMetadata(5159473);
        this.setTemperatureRainfall(0.7F, 0.8F);

        if (this.field_150632_aF == 2)
        {
            this.field_150609_ah = 353825;
            this.color = 3175492;
            this.setTemperatureRainfall(0.6F, 0.6F);
        }
    }

    protected BiomeGenBase func_150557_a(int p_150557_1_, boolean p_150557_2_)
    {
        if (this.field_150632_aF == 2)
        {
            this.field_150609_ah = 353825;
            this.color = p_150557_1_;

            if (p_150557_2_)
            {
                this.field_150609_ah = (this.field_150609_ah & 16711422) >> 1;
            }

            return this;
        }
        else
        {
            return super.func_150557_a(p_150557_1_, p_150557_2_);
        }
    }
    
    protected BiomeGenBase createMutatedBiome(final int p_180277_1_)
    {
        if (this.biomeID == BiomeGenBase.forest.biomeID)
        {
            BiomeGenForest var2 = new BiomeGenForest(p_180277_1_, 1);
            var2.setHeight(new BiomeGenBase.Height(this.minHeight, this.maxHeight + 0.2F));
            var2.setBiomeName("Flower Forest");
            var2.func_150557_a(6976549, true);
            var2.setFillerBlockMetadata(8233509);
            return var2;
        }
        else
        {
            return new BiomeGenMutated(p_180277_1_, this);
        }
    }
}
