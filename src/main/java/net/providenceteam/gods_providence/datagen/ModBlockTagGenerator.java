package net.providenceteam.gods_providence.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.providenceteam.gods_providence.GodsProvidence;
import net.providenceteam.gods_providence.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GodsProvidence.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.GOLD_OAK_PLANKS.get(),
                        ModBlocks.GOLD_OAK_STAIRS.get(),
                        ModBlocks.GOLD_OAK_SLAB.get(),
                        ModBlocks.GOLD_OAK_TRAPDOOR.get(),
                        ModBlocks.GOLD_OAK_FENCE_GATE.get(),
                        ModBlocks.GOLD_OAK_FENCE.get(),
                        ModBlocks.GOLD_OAK_BUTTON.get(),
                        ModBlocks.GOLD_OAK_PRESSURE_PLATE.get());


        this.tag(BlockTags.FENCES)
                .add(ModBlocks.GOLD_OAK_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.GOLD_OAK_FENCE_GATE.get());


    }
}