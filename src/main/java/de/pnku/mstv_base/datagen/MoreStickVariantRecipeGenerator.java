package de.pnku.mstv_base.datagen;

import de.pnku.mstv_base.MoreStickVariants;
import de.pnku.mstv_base.item.MoreStickVariantItem;
import de.pnku.mstv_base.item.MoreStickVariantItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

public class MoreStickVariantRecipeGenerator extends FabricRecipeProvider {
    public MoreStickVariantRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        for (Item stickItem : MoreStickVariantItems.more_sticks) {
            String planksWood = ((MoreStickVariantItem) stickItem).mstvWoodType;
            Item stickPlanks = ((MoreStickVariantItem) stickItem).getPlanksItem(planksWood);
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, stickItem)
                    .group("sticks")
                    .unlockedBy("has_planks", has(stickPlanks))
                    .define('W', stickPlanks)
                    .pattern("W  ")
                    .pattern("W  ")
                    .save(exporter, MoreStickVariants.asId(planksWood + "_stick"));
        }
    }
}
