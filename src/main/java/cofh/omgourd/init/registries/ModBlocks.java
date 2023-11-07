package cofh.omgourd.init.registries;

import cofh.core.common.block.CarvedPumpkinBlockCoFH;
import cofh.core.common.block.EquipableCarvedPumpkinBlockCoFH;
import cofh.core.common.item.BlockItemCoFH;
import cofh.lib.util.helpers.BlockHelper;
import com.google.common.collect.Sets;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

import static cofh.omgourd.OMGourd.*;
import static cofh.omgourd.common.event.CommonEvents.registerNext;
import static cofh.omgourd.common.event.CommonEvents.registerPrev;
import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.of;

public class ModBlocks {

    private ModBlocks() {

    }

    public static LinkedHashSet<RegistryObject<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

    public static RegistryObject<Item> registerWithTab(final String name, final Supplier<Item> supplier) {

        RegistryObject<Item> reg = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(reg);
        return reg;
    }

    public static void register() {

        for (int i = MIN_PUMPKIN_IDX; i <= MAX_PUMPKIN_IDX; ++i) {
            BLOCKS.register("carved_pumpkin_" + i, () -> new EquipableCarvedPumpkinBlockCoFH(of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.DIDGERIDOO).strength(1.0F).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)).setTranslationKey("block.minecraft.carved_pumpkin"));
            BLOCKS.register("jack_o_lantern_" + i, () -> new CarvedPumpkinBlockCoFH(of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.DIDGERIDOO).strength(1.0F).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY).lightLevel(BlockHelper.lightValue(15))).setTranslationKey("block.minecraft.jack_o_lantern"));

            final int j = i;
            registerWithTab("carved_pumpkin_" + j, () -> new BlockItemCoFH(BLOCKS.get("carved_pumpkin_" + j), new Item.Properties()));
            registerWithTab("jack_o_lantern_" + j, () -> new BlockItemCoFH(BLOCKS.get("jack_o_lantern_" + j), new Item.Properties()));
        }
        CarvedPumpkinBlockCoFH.updatePredicate();
    }

    public static void setup() {

        Block pumpkin;
        Block lantern;

        // NEXT
        for (int i = MIN_PUMPKIN_IDX + 1; i <= MAX_PUMPKIN_IDX - 1; ++i) {
            pumpkin = BLOCKS.get("carved_pumpkin_" + i);
            registerPrev(pumpkin, BLOCKS.get("carved_pumpkin_" + (i - 1)));
            registerNext(pumpkin, BLOCKS.get("carved_pumpkin_" + (i + 1)));

            lantern = BLOCKS.get("jack_o_lantern_" + i);
            registerPrev(lantern, BLOCKS.get("jack_o_lantern_" + (i - 1)));
            registerNext(lantern, BLOCKS.get("jack_o_lantern_" + (i + 1)));
        }
        // ENDS
        pumpkin = BLOCKS.get("carved_pumpkin_" + MIN_PUMPKIN_IDX);
        registerPrev(pumpkin, Blocks.CARVED_PUMPKIN);
        registerNext(pumpkin, BLOCKS.get("carved_pumpkin_" + (MIN_PUMPKIN_IDX + 1)));

        lantern = BLOCKS.get("jack_o_lantern_" + MIN_PUMPKIN_IDX);
        registerPrev(lantern, Blocks.JACK_O_LANTERN);
        registerNext(lantern, BLOCKS.get("jack_o_lantern_" + (MIN_PUMPKIN_IDX + 1)));

        pumpkin = BLOCKS.get("carved_pumpkin_" + MAX_PUMPKIN_IDX);
        registerPrev(pumpkin, BLOCKS.get("carved_pumpkin_" + (MAX_PUMPKIN_IDX - 1)));
        registerNext(pumpkin, Blocks.CARVED_PUMPKIN);

        lantern = BLOCKS.get("jack_o_lantern_" + MAX_PUMPKIN_IDX);
        registerPrev(lantern, BLOCKS.get("jack_o_lantern_" + (MAX_PUMPKIN_IDX - 1)));
        registerNext(lantern, Blocks.JACK_O_LANTERN);

        // VANILLA
        pumpkin = Blocks.CARVED_PUMPKIN;
        registerPrev(pumpkin, BLOCKS.get("carved_pumpkin_" + MAX_PUMPKIN_IDX));
        registerNext(pumpkin, BLOCKS.get("carved_pumpkin_" + MIN_PUMPKIN_IDX));

        lantern = Blocks.JACK_O_LANTERN;
        registerPrev(lantern, BLOCKS.get("jack_o_lantern_" + MAX_PUMPKIN_IDX));
        registerNext(lantern, BLOCKS.get("jack_o_lantern_" + MIN_PUMPKIN_IDX));
    }

    // TODO: Maybe Forge will improve this.

    //    private static class EquipableCarvedPumpkinBlockItem extends BlockItemCoFH {
    //
    //        public EquipableCarvedPumpkinBlockItem(Block blockIn, Properties builder) {
    //
    //            super(blockIn, builder);
    //        }
    //
    //        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
    //
    //            consumer.accept(new IClientItemExtensions() {
    //
    //                @Override
    //                public void renderHelmetOverlay(ItemStack stack, Player player, int width, int height, float partialTick) {
    //
    //                    renderTextureOverlay(guiGraphics, PUMPKIN_BLUR_LOCATION, 1.0F);
    //                }
    //            });
    //        }
    //
    //    }

}
