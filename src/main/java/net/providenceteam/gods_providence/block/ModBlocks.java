package net.providenceteam.gods_providence.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.providenceteam.gods_providence.GodsProvidence;
import net.providenceteam.gods_providence.fluid.ModFluids;
import net.providenceteam.gods_providence.item.ModItems;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GodsProvidence.MOD_ID);


    public static final RegistryObject<Block> TITANIUM_BLOCK = registryBlock("titanium_block",
            () -> new Block((BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK))));

    public static final RegistryObject<Block> ASH_SAND = registryBlock("ash_sand",
            () -> new Block((BlockBehaviour.Properties.copy(Blocks.SAND))));

    public static final RegistryObject<Block> GOLD_OAK_PLANKS = registryBlock("gold_oak_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> GOLD_OAK_STAIRS = registryBlock("gold_oak_stairs",
            () -> new StairBlock(() -> ModBlocks.GOLD_OAK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> GOLD_OAK_SLAB = registryBlock("gold_oak_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> GOLD_OAK_BUTTON = registryBlock("gold_oak_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> GOLD_OAK_PRESSURE_PLATE = registryBlock("gold_oak_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WOOD),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> GOLD_OAK_FENCE = registryBlock("gold_oak_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> GOLD_OAK_FENCE_GATE = registryBlock("gold_oak_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));

    public static final RegistryObject<Block> GOLD_OAK_DOOR = registryBlock("gold_oak_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> GOLD_OAK_TRAPDOOR = registryBlock("gold_oak_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion(), BlockSetType.IRON));


    public static final RegistryObject<LiquidBlock> DREAMS_WATER_BLOCK = BLOCKS.register("dreams_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_DREAMS_WATER, BlockBehaviour.Properties.copy(Blocks.LAVA)));





    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends  Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
