package cofh.omgourd.init;

import cofh.core.block.CarvedPumpkinBlockCoFH;
import cofh.core.item.BlockItemCoFH;
import cofh.lib.util.helpers.BlockHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import static cofh.omgourd.OMGourd.*;
import static cofh.omgourd.event.CommonEvents.registerNext;
import static cofh.omgourd.event.CommonEvents.registerPrev;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;

public class OMGBlocks {

    private OMGBlocks() {

    }

    public static void register() {

        for (int i = 1; i <= 24; ++i) {
            BLOCKS.register("carved_pumpkin_" + i, () -> new CarvedPumpkinBlockCoFH(of(Material.VEGETABLE, MaterialColor.COLOR_ORANGE).strength(1.0F).sound(SoundType.WOOD)).setTranslationKey("block.minecraft.carved_pumpkin"));
            BLOCKS.register("jack_o_lantern_" + i, () -> new CarvedPumpkinBlockCoFH(of(Material.VEGETABLE, MaterialColor.COLOR_ORANGE).strength(1.0F).sound(SoundType.WOOD).lightLevel(BlockHelper.lightValue(15))).setTranslationKey("block.minecraft.jack_o_lantern"));

            int j = i;
            ITEMS.register("carved_pumpkin_" + j, () -> new BlockItemCoFH(BLOCKS.get("carved_pumpkin_" + j), new Item.Properties().tab(OMG_GROUP)));
            ITEMS.register("jack_o_lantern_" + j, () -> new BlockItemCoFH(BLOCKS.get("jack_o_lantern_" + j), new Item.Properties().tab(OMG_GROUP)));
        }
        CarvedPumpkinBlockCoFH.updatePredicate();
    }

    public static void setup() {

        Block pumpkin;
        Block lantern;

        // NEXT
        for (int i = 2; i <= 23; ++i) {
            pumpkin = BLOCKS.get("carved_pumpkin_" + i);
            registerPrev(pumpkin, BLOCKS.get("carved_pumpkin_" + (i - 1)));
            registerNext(pumpkin, BLOCKS.get("carved_pumpkin_" + (i + 1)));

            lantern = BLOCKS.get("jack_o_lantern_" + i);
            registerPrev(lantern, BLOCKS.get("jack_o_lantern_" + (i - 1)));
            registerNext(lantern, BLOCKS.get("jack_o_lantern_" + (i + 1)));
        }
        // ENDS
        pumpkin = BLOCKS.get("carved_pumpkin_" + 1);
        registerPrev(pumpkin, Blocks.CARVED_PUMPKIN);
        registerNext(pumpkin, BLOCKS.get("carved_pumpkin_" + 2));

        lantern = BLOCKS.get("jack_o_lantern_" + 1);
        registerPrev(lantern, Blocks.JACK_O_LANTERN);
        registerNext(lantern, BLOCKS.get("jack_o_lantern_" + 2));

        pumpkin = BLOCKS.get("carved_pumpkin_" + 24);
        registerPrev(pumpkin, BLOCKS.get("carved_pumpkin_" + 23));
        registerNext(pumpkin, Blocks.CARVED_PUMPKIN);

        lantern = BLOCKS.get("jack_o_lantern_" + 24);
        registerPrev(lantern, BLOCKS.get("jack_o_lantern_" + 23));
        registerNext(lantern, Blocks.JACK_O_LANTERN);

        // VANILLA
        pumpkin = Blocks.CARVED_PUMPKIN;
        registerPrev(pumpkin, BLOCKS.get("carved_pumpkin_" + 24));
        registerNext(pumpkin, BLOCKS.get("carved_pumpkin_" + 1));

        lantern = Blocks.JACK_O_LANTERN;
        registerPrev(lantern, BLOCKS.get("jack_o_lantern_" + 24));
        registerNext(lantern, BLOCKS.get("jack_o_lantern_" + 1));
    }

}
