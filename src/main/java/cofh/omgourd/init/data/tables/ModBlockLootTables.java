package cofh.omgourd.init.data.tables;

import cofh.lib.init.data.loot.BlockLootSubProviderCoFH;

import static cofh.omgourd.OMGourd.*;

public class ModBlockLootTables extends BlockLootSubProviderCoFH {

    @Override
    protected void generate() {

        for (int i = MIN_PUMPKIN_IDX; i <= MAX_PUMPKIN_IDX; ++i) {
            add(BLOCKS.get("carved_pumpkin_" + i), getSimpleDropTable(BLOCKS.get("carved_pumpkin_" + i)));
            add(BLOCKS.get("jack_o_lantern_" + i), getSimpleDropTable(BLOCKS.get("jack_o_lantern_" + i)));
        }
    }

}
