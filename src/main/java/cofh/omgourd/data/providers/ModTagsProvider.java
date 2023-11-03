package cofh.omgourd.data.providers;

import cofh.lib.tags.BlockTagsCoFH;
import cofh.lib.tags.ItemTagsCoFH;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static cofh.lib.util.constants.ModIds.ID_OMGOURD;
import static cofh.omgourd.OMGourd.BLOCKS;

public class ModTagsProvider {

    public static class Block extends BlockTagsProvider {

        public Block(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {

            super(output, lookupProvider, ID_OMGOURD, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {

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

        public Item(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagsProvider.TagLookup<net.minecraft.world.level.block.Block>> pBlockTags, ExistingFileHelper existingFileHelper) {

            super(pOutput, pLookupProvider, pBlockTags, ID_OMGOURD, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider pProvider) {

            copy(BlockTagsCoFH.PUMPKINS_CARVED, ItemTagsCoFH.PUMPKINS_CARVED);
        }

    }

}
