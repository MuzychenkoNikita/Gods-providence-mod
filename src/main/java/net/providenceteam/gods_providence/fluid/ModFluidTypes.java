package net.providenceteam.gods_providence.fluid;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.providenceteam.gods_providence.GodsProvidence;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation DREAMS_STILL_RL = new ResourceLocation(GodsProvidence.MOD_ID, "block/dream_water_still");
    public static final ResourceLocation DREAMS_FLOWING_RL = new ResourceLocation(GodsProvidence.MOD_ID, "block/dream_water_flow");
    public static final ResourceLocation DREAMS_OVERLAY_RL = new ResourceLocation(GodsProvidence.MOD_ID, "misc/in_dreams_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, GodsProvidence.MOD_ID);

    public static final RegistryObject<FluidType> DREAMS_WATER_FLUID_TYPE = register("dreams_water_fluid",
            FluidType.Properties.create().lightLevel(12).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));



    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(DREAMS_STILL_RL, DREAMS_FLOWING_RL, DREAMS_OVERLAY_RL,
                0xA52E53D6, new Vector3f(44f / 255f, 45f / 255f, 73f / 255f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}