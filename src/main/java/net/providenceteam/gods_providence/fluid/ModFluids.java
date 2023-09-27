package net.providenceteam.gods_providence.fluid;


import net.providenceteam.gods_providence.block.ModBlocks;
import net.providenceteam.gods_providence.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.providenceteam.gods_providence.GodsProvidence;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, GodsProvidence.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_DREAMS_WATER = FLUIDS.register("dreams_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.DREAMS_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> DREAMS_WATER = FLUIDS.register("dreams_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.DREAMS_WATER_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties DREAMS_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.DREAMS_WATER_FLUID_TYPE, SOURCE_DREAMS_WATER, DREAMS_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.DREAMS_WATER_BLOCK)
            .bucket(ModItems.DREAMS_WATER_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}