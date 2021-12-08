package cofh.omgourd.data;

import cofh.lib.util.references.BlockTagsCoFH;
import cofh.lib.util.references.ItemTagsCoFH;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static cofh.lib.util.constants.Constants.ID_OMGOURD;
import static cofh.omgourd.OMGourd.BLOCKS;

public class OMGTagsProvider {

    public static class Block extends BlockTagsProvider {

        public Block(DataGenerator gen, ExistingFileHelper existingFileHelper) {

            super(gen, ID_OMGOURD, existingFileHelper);
        }

        @Override
        public String getName() {

            return "Oh My Gourd: Block Tags";
        }

        @Override
        protected void addTags() {

            tag(BlockTagsCoFH.PUMPKINS_CARVED).add(
                    BLOCKS.get("carved_pumpkin_1"),
                    BLOCKS.get("carved_pumpkin_2"),
                    BLOCKS.get("carved_pumpkin_3"),
                    BLOCKS.get("carved_pumpkin_4"),
                    BLOCKS.get("carved_pumpkin_5"),
                    BLOCKS.get("carved_pumpkin_6"),
                    BLOCKS.get("carved_pumpkin_7"),
                    BLOCKS.get("carved_pumpkin_8"),
                    BLOCKS.get("carved_pumpkin_9"),
                    BLOCKS.get("carved_pumpkin_10"),
                    BLOCKS.get("carved_pumpkin_11"),
                    BLOCKS.get("carved_pumpkin_12"),
                    BLOCKS.get("carved_pumpkin_13"),
                    BLOCKS.get("carved_pumpkin_14"),
                    BLOCKS.get("carved_pumpkin_15"),
                    BLOCKS.get("carved_pumpkin_16"),
                    BLOCKS.get("carved_pumpkin_17"),
                    BLOCKS.get("carved_pumpkin_18"),
                    BLOCKS.get("carved_pumpkin_19"),
                    BLOCKS.get("carved_pumpkin_20"),
                    BLOCKS.get("carved_pumpkin_21"),
                    BLOCKS.get("carved_pumpkin_22"),
                    BLOCKS.get("carved_pumpkin_23"),
                    BLOCKS.get("carved_pumpkin_24")
            );
        }

    }

    public static class Item extends ItemTagsProvider {

        public Item(DataGenerator gen, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {

            super(gen, blockTagProvider, ID_OMGOURD, existingFileHelper);
        }

        @Override
        public String getName() {

            return "Oh My Gourd: Item Tags";
        }

        @Override
        protected void addTags() {

            copy(BlockTagsCoFH.PUMPKINS_CARVED, ItemTagsCoFH.PUMPKINS_CARVED);
        }

    }

}
