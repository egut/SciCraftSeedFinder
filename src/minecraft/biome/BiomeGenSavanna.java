package minecraft.biome;

public class BiomeGenSavanna extends BiomeGenBase
{
    protected BiomeGenSavanna(int p_i45383_1_)
    {
        super(p_i45383_1_);
    }

    protected BiomeGenBase createMutatedBiome(int p_180277_1_)
    {
        BiomeGenSavanna.Mutated var2 = new BiomeGenSavanna.Mutated(p_180277_1_, this);
        var2.temperature = (this.temperature + 1.0F) * 0.5F;
        var2.minHeight = this.minHeight * 0.5F + 0.3F;
        var2.maxHeight = this.maxHeight * 0.5F + 1.2F;
        return var2;
    }

    public static class Mutated extends BiomeGenMutated
    {
        public Mutated(int p_i45382_1_, BiomeGenBase p_i45382_2_)
        {
            super(p_i45382_1_, p_i45382_2_);
        }
    }
}
