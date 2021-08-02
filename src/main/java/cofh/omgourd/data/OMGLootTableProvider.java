package cofh.omgourd.data;

import cofh.lib.data.LootTableProviderCoFH;
import net.minecraft.data.DataGenerator;

import static cofh.omgourd.OMGourd.BLOCKS;

public class OMGLootTableProvider extends LootTableProviderCoFH {

    public OMGLootTableProvider(DataGenerator gen) {

        super(gen);
    }

    @Override
    public String getName() {

        return "OMGourd: Loot Tables";
    }

    @Override
    protected void addTables() {

        for (int i = 1; i <= 24; ++i) {
            blockLootTables.put(BLOCKS.get("carved_pumpkin_" + i), getSimpleDropTable(BLOCKS.get("carved_pumpkin_" + i)));
            blockLootTables.put(BLOCKS.get("jack_o_lantern_" + i), getSimpleDropTable(BLOCKS.get("jack_o_lantern_" + i)));
        }
    }

}
