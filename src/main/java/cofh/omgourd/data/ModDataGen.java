package cofh.omgourd.data;

import cofh.omgourd.data.providers.ModItemModelProvider;
import cofh.omgourd.data.providers.ModLootTableProvider;
import cofh.omgourd.data.providers.ModRecipeProvider;
import cofh.omgourd.data.providers.ModTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.ModIds.ID_OMGOURD;

@Mod.EventBusSubscriber (bus = Mod.EventBusSubscriber.Bus.MOD, modid = ID_OMGOURD)
public class ModDataGen {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {

        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper exFileHelper = event.getExistingFileHelper();

        ModTagsProvider.Block blockTags = new ModTagsProvider.Block(output, event.getLookupProvider(), exFileHelper);
        gen.addProvider(event.includeServer(), blockTags);
        gen.addProvider(event.includeServer(), new ModTagsProvider.Item(output, event.getLookupProvider(), blockTags.contentsGetter(), exFileHelper));

        gen.addProvider(event.includeServer(), new ModLootTableProvider(output));
        gen.addProvider(event.includeServer(), new ModRecipeProvider(output));

        gen.addProvider(event.includeClient(), new ModItemModelProvider(output, exFileHelper));
    }

}
