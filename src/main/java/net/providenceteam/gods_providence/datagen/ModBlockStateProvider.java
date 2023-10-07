package net.providenceteam.gods_providence.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.providenceteam.gods_providence.GodsProvidence;
import net.providenceteam.gods_providence.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GodsProvidence.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TITANIUM_BLOCK);
        blockWithItem(ModBlocks.ASH_SAND);

        blockWithItem(ModBlocks.GOLD_OAK_PLANKS);

        stairsBlock(((StairBlock) ModBlocks.GOLD_OAK_STAIRS.get()), blockTexture(ModBlocks.GOLD_OAK_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.GOLD_OAK_SLAB.get()), blockTexture(ModBlocks.GOLD_OAK_PLANKS.get()), blockTexture(ModBlocks.GOLD_OAK_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.GOLD_OAK_BUTTON.get()), blockTexture(ModBlocks.GOLD_OAK_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.GOLD_OAK_PRESSURE_PLATE.get()), blockTexture(ModBlocks.GOLD_OAK_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.GOLD_OAK_FENCE.get()), blockTexture(ModBlocks.GOLD_OAK_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.GOLD_OAK_FENCE_GATE.get()), blockTexture(ModBlocks.GOLD_OAK_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.GOLD_OAK_DOOR.get()), modLoc("block/gold_oak_door_bottom"), modLoc("block/gold_oak_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.GOLD_OAK_TRAPDOOR.get()), modLoc("block/gold_oak_trapdoor"), true, "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}