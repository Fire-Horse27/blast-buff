package net.fire_horse27.blastbuff.datagen;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final List<ItemConvertible> COPPER = List.of(Items.RAW_COPPER_BLOCK);
    public static final List<ItemConvertible> GOLD = List.of(Items.RAW_GOLD_BLOCK);
    public static final List<ItemConvertible> IRON = List.of(Items.RAW_IRON_BLOCK);
    public static final List<ItemConvertible> GLASS = List.of(Items.SAND, Items.RED_SAND);

    @Override
    public void generate(RecipeExporter exporter) {
        offerBlasting(exporter, COPPER, RecipeCategory.BUILDING_BLOCKS, Blocks.COPPER_BLOCK,
                6.3f, 800, "copper_block");

        offerBlasting(exporter, GOLD, RecipeCategory.BUILDING_BLOCKS, Blocks.GOLD_BLOCK,
                9.0f, 800, "gold_block");

        offerBlasting(exporter, IRON, RecipeCategory.BUILDING_BLOCKS, Blocks.IRON_BLOCK,
                6.3f, 800, "iron_block");

        offerBlasting(exporter, GLASS, RecipeCategory.BUILDING_BLOCKS, Blocks.GLASS,
                0.1f, 100, "glass");
    }
}
