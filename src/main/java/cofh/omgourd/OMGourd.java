package cofh.omgourd;

import cofh.lib.util.DeferredRegisterCoFH;
import cofh.omgourd.init.OMGBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static cofh.lib.util.constants.ModIds.ID_OMGOURD;

@Mod (ID_OMGOURD)
public class OMGourd {

    public static final Logger LOG = LogManager.getLogger(ID_OMGOURD);
    // public static final ConfigManager CONFIG_MANAGER = new ConfigManager();

    public static final DeferredRegisterCoFH<Block> BLOCKS = DeferredRegisterCoFH.create(ForgeRegistries.BLOCKS, ID_OMGOURD);
    public static final DeferredRegisterCoFH<Item> ITEMS = DeferredRegisterCoFH.create(ForgeRegistries.ITEMS, ID_OMGOURD);

    public static final CreativeModeTab OMG_GROUP = new CreativeModeTab(-1, ID_OMGOURD) {

        @Override
        public ItemStack makeIcon() {

            return new ItemStack(ITEMS.get("carved_pumpkin_1"));
        }
    };

    public OMGourd() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);

        OMGBlocks.register();
    }

    // region INITIALIZATION
    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(OMGBlocks::setup);
    }
    // endregion
}
