package cofh.omgourd;

import cofh.core.client.event.CoreClientEvents;
import cofh.lib.util.DeferredRegisterCoFH;
import cofh.omgourd.init.registries.ModBlocks;
import cofh.omgourd.init.registries.ModCreativeTabs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import static cofh.lib.util.constants.ModIds.ID_OMGOURD;

@Mod (ID_OMGOURD)
public class OMGourd {

    public static final int MIN_PUMPKIN_IDX = 1;
    public static final int MAX_PUMPKIN_IDX = 24;

    // public static final Logger LOG = LogManager.getLogger(ID_OMGOURD);
    // public static final ConfigManager CONFIG_MANAGER = new ConfigManager();

    public static final DeferredRegisterCoFH<Block> BLOCKS = DeferredRegisterCoFH.create(BuiltInRegistries.BLOCK, ID_OMGOURD);
    public static final DeferredRegisterCoFH<Item> ITEMS = DeferredRegisterCoFH.create(BuiltInRegistries.ITEM, ID_OMGOURD);
    public static final DeferredRegisterCoFH<CreativeModeTab> CREATIVE_TABS = DeferredRegisterCoFH.create(BuiltInRegistries.CREATIVE_MODE_TAB, ID_OMGOURD);

    public OMGourd(ModContainer modContainer, IEventBus modEventBus) {

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        // modEventBus.addListener(this::creativeTabSetup);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_TABS.register(modEventBus);

        ModBlocks.register();
        ModCreativeTabs.register();
    }

    // region INITIALIZATION
    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(ModBlocks::setup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        event.enqueueWork(() -> CoreClientEvents.addNamespace(ID_OMGOURD));
    }

    private void creativeTabSetup(final BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {

            for (int i = MIN_PUMPKIN_IDX; i <= MAX_PUMPKIN_IDX; ++i) {
                event.accept(ITEMS.get("carved_pumpkin_" + i));
                event.accept(ITEMS.get("jack_o_lantern_" + i));
            }
        }
    }
    // endregion
}
