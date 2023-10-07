package net.providenceteam.gods_providence.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.providenceteam.gods_providence.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.ASH_SAND.get());
        this.dropSelf(ModBlocks.GOLD_OAK_PLANKS.get());
        this.dropSelf(ModBlocks.DREAMS_WATER_BLOCK.get());

        this.dropSelf(ModBlocks.GOLD_OAK_STAIRS.get());
        this.dropSelf(ModBlocks.GOLD_OAK_BUTTON.get());
        this.dropSelf(ModBlocks.GOLD_OAK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.GOLD_OAK_TRAPDOOR.get());
        this.dropSelf(ModBlocks.GOLD_OAK_FENCE.get());
        this.dropSelf(ModBlocks.GOLD_OAK_FENCE_GATE.get());

        this.add(ModBlocks.GOLD_OAK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GOLD_OAK_SLAB.get()));
        this.add(ModBlocks.GOLD_OAK_DOOR.get(),
                block -> createDoorTable(ModBlocks.GOLD_OAK_DOOR.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}