package cofh.omgourd.init.data.providers;

import cofh.lib.init.data.ItemModelProviderCoFH;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.lib.util.constants.ModIds.ID_OMGOURD;
import static cofh.omgourd.OMGourd.*;

public class ModItemModelProvider extends ItemModelProviderCoFH {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {

        super(output, ID_OMGOURD, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        for (int i = MIN_PUMPKIN_IDX; i <= MAX_PUMPKIN_IDX; ++i) {
            blockItem(BLOCKS.getSup("carved_pumpkin_" + i));
            blockItem(BLOCKS.getSup("jack_o_lantern_" + i));
        }
    }

}
