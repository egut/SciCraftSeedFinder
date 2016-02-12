package minecraft.biome;

public class BiomeGenMutated extends BiomeGenBase
{
    protected BiomeGenBase baseBiome;

    public BiomeGenMutated(int p_i45381_1_, BiomeGenBase p_i45381_2_)
    {
        super(p_i45381_1_);
        this.baseBiome = p_i45381_2_;
        this.func_150557_a(p_i45381_2_.color, true);
        this.biomeName = p_i45381_2_.biomeName + " M";
        this.fillerBlockMetadata = p_i45381_2_.fillerBlockMetadata;
        this.minHeight = p_i45381_2_.minHeight;
        this.maxHeight = p_i45381_2_.maxHeight;
        this.temperature = p_i45381_2_.temperature;
        this.rainfall = p_i45381_2_.rainfall;
        this.waterColorMultiplier = p_i45381_2_.waterColorMultiplier;
        this.enableSnow = p_i45381_2_.enableSnow;
        this.enableRain = p_i45381_2_.enableRain;
        this.temperature = p_i45381_2_.temperature;
        this.rainfall = p_i45381_2_.rainfall;
        this.minHeight = p_i45381_2_.minHeight + 0.1F;
        this.maxHeight = p_i45381_2_.maxHeight + 0.2F;
    }

    /**
     * returns the chance a creature has to spawn.
     */
    public float getSpawningChance()
    {
        return this.baseBiome.getSpawningChance();
    }

    /**
     * returns true if the biome specified is equal to this biome
     */
    public boolean isEqualTo(BiomeGenBase p_150569_1_)
    {
        return this.baseBiome.isEqualTo(p_150569_1_);
    }

    public BiomeGenBase.TempCategory getTempCategory()
    {
        return this.baseBiome.getTempCategory();
    }
}
