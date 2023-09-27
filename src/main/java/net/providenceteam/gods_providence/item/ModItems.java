package net.providenceteam.gods_providence.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.providenceteam.gods_providence.GodsProvidence;
import net.providenceteam.gods_providence.fluid.ModFluids;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GodsProvidence.MOD_ID);

    public static final RegistryObject<Item> TITANIUM = ITEMS.register("titanium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DREAMS_WATER_BUCKET = ITEMS.register("dreams_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_DREAMS_WATER,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static void registers(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
