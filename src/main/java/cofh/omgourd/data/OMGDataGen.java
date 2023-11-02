//package cofh.omgourd.data;
//
//import net.minecraft.data.DataGenerator;
//import net.minecraftforge.common.data.ExistingFileHelper;
//import net.minecraftforge.data.event.GatherDataEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import static cofh.lib.util.constants.ModIds.ID_OMGOURD;
//
//@Mod.EventBusSubscriber (bus = Mod.EventBusSubscriber.Bus.MOD, modid = ID_OMGOURD)
//public class OMGDataGen {
//
//    @SubscribeEvent
//    public static void gatherData(final GatherDataEvent event) {
//
//        DataGenerator gen = event.getGenerator();
//        ExistingFileHelper exFileHelper = event.getExistingFileHelper();
//
//        OMGTagsProvider.Block blockTags = new OMGTagsProvider.Block(gen, exFileHelper);
//
//        gen.addProvider(event.includeServer(), blockTags);
//        gen.addProvider(event.includeServer(), new OMGTagsProvider.Item(gen, blockTags, exFileHelper));
//
//        gen.addProvider(event.includeServer(), new OMGLootTableProvider(gen));
//        gen.addProvider(event.includeServer(), new OMGRecipeProvider(gen));
//
//        gen.addProvider(event.includeClient(), new OMGItemModelProvider(gen, exFileHelper));
//    }
//
//}
