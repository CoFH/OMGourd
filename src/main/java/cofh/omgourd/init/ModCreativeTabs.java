package cofh.omgourd.init;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

import static cofh.lib.util.constants.ModIds.ID_OMGOURD;
import static cofh.omgourd.OMGourd.*;

public class ModCreativeTabs {

    private ModCreativeTabs() {

    }

    public static void register() {

    }

    private static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register(ID_OMGOURD, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.omgourd"))
            .icon(() -> new ItemStack(ITEMS.get("carved_pumpkin_" + MIN_PUMPKIN_IDX)))
            .displayItems((parameters, output) -> ModBlocks.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get())))
            .build());

}
