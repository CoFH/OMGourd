package cofh.omgourd.data.providers;

import cofh.lib.data.RecipeProviderCoFH;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static cofh.lib.util.constants.ModIds.ID_OMGOURD;
import static cofh.omgourd.OMGourd.*;

public class ModRecipeProvider extends RecipeProviderCoFH {

    public ModRecipeProvider(PackOutput output) {

        super(output, ID_OMGOURD);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        for (int i = MIN_PUMPKIN_IDX; i <= MAX_PUMPKIN_IDX; ++i) {
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ITEMS.get("jack_o_lantern_" + i))
                    .define('A', ITEMS.get("carved_pumpkin_" + i))
                    .define('B', Items.TORCH)
                    .pattern("A")
                    .pattern("B")
                    .unlockedBy("has_carved_pumpkin", has(Items.CARVED_PUMPKIN))
                    .save(consumer);
        }
    }

}
