package cofh.omgourd.data;

import cofh.lib.data.RecipeProviderCoFH;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

import static cofh.lib.util.constants.Constants.ID_OMGOURD;
import static cofh.omgourd.OMGourd.ITEMS;

public class OMGRecipeProvider extends RecipeProviderCoFH {

    public OMGRecipeProvider(DataGenerator generatorIn) {

        super(generatorIn, ID_OMGOURD);
    }

    @Override
    public String getName() {

        return "OMGourd: Recipes";
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

        for (int i = 1; i <= 24; ++i) {
            ShapedRecipeBuilder.shaped(ITEMS.get("jack_o_lantern_" + i))
                    .define('A', ITEMS.get("carved_pumpkin_" + i))
                    .define('B', Items.TORCH)
                    .pattern("A")
                    .pattern("B")
                    .unlockedBy("has_carved_pumpkin", has(Items.CARVED_PUMPKIN))
                    .save(consumer);
        }
    }

}
