package net.fire_horse27.blastbuff.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.impl.datagen.TagAliasGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

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
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {
                // After running datagen, the category must be corrected in the recipe files
                // Also blast has only two categories, redstone and misc

                CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItem(Items.RAW_COPPER_BLOCK), RecipeCategory.MISC,
                        Blocks.COPPER_BLOCK, 6.3f, 800)
                        .group("copper_block")
                        .criterion(hasItem(Items.RAW_COPPER_BLOCK), conditionsFromItem(Items.RAW_COPPER_BLOCK))
                        .offerTo(exporter, "blastbuff:copper_block_from_blasting_raw_copper_block");

                CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItem(Items.RAW_GOLD_BLOCK), RecipeCategory.MISC,
                                Blocks.GOLD_BLOCK, 9.0f, 800)
                        .group("gold_block")
                        .criterion(hasItem(Items.RAW_GOLD_BLOCK), conditionsFromItem(Items.RAW_GOLD_BLOCK))
                        .offerTo(exporter, "blastbuff:gold_block_from_blasting_raw_gold_block");

                CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItem(Items.RAW_IRON_BLOCK), RecipeCategory.MISC,
                                Blocks.IRON_BLOCK, 6.3f, 800)
                        .group("iron_block")
                        .criterion(hasItem(Items.RAW_IRON_BLOCK), conditionsFromItem(Items.RAW_IRON_BLOCK))
                        .offerTo(exporter, "blastbuff:iron_block_from_blasting_raw_iron_block");

                CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(Items.SAND, Items.RED_SAND), RecipeCategory.MISC,
                                Blocks.GLASS, 0.1f, 100)
                        .group("glass_block")
                        .criterion(hasItem(Items.SAND), conditionsFromItem(Items.SAND))
                        .criterion(hasItem(Items.RED_SAND), conditionsFromItem(Items.RED_SAND))
                        .offerTo(exporter, "blastbuff:glass_from_blasting_sand");
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
