package net.providenceteam.gods_providence.world.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.providenceteam.gods_providence.GodsProvidence;

public class ModDimensions {
    public static final ResourceKey<Level> GODSDIM_KEY = ResourceKey.create(Registries.DIMENSION,
            new ResourceLocation(GodsProvidence.MOD_ID, "godsdim"));
    public static final ResourceKey<DimensionType> GODSDIM_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE, GODSDIM_KEY.location());

    public static void register() {
        System.out.println("Registering ModDimensions for " + GodsProvidence.MOD_ID);
    }
}