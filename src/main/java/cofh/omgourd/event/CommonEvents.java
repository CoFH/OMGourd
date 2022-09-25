package cofh.omgourd.event;

import cofh.core.item.KnifeItem;
import cofh.lib.util.Utils;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.ModIds.ID_OMGOURD;

@Mod.EventBusSubscriber (modid = ID_OMGOURD)
public class CommonEvents {

    private static final Object2ObjectOpenHashMap<Block, Block> CARVE_PREV_MAP = new Object2ObjectOpenHashMap<>();
    private static final Object2ObjectOpenHashMap<Block, Block> CARVE_NEXT_MAP = new Object2ObjectOpenHashMap<>();

    private CommonEvents() {

    }

    public static boolean registerPrev(Block block, Block prevBlock) {

        if (block instanceof CarvedPumpkinBlock && prevBlock instanceof CarvedPumpkinBlock) {
            CARVE_PREV_MAP.put(block, prevBlock);
            return true;
        }
        return false;
    }

    public static boolean registerNext(Block block, Block nextBlock) {

        if (block instanceof CarvedPumpkinBlock && nextBlock instanceof CarvedPumpkinBlock) {
            CARVE_NEXT_MAP.put(block, nextBlock);
            return true;
        }
        return false;
    }

    @SubscribeEvent
    public static void handlePlayerRightClickEvent(PlayerInteractEvent.RightClickBlock event) {

        if (event.isCanceled()) {
            return;
        }
        Level world = event.getWorld();
        Direction face = event.getFace();
        if (face == null) {
            return;
        }
        Player player = event.getPlayer();
        BlockPos pos = event.getPos();
        Block block = world.getBlockState(pos).getBlock();

        ItemStack heldStack = player.getItemInHand(event.getHand());
        if (heldStack.getItem() instanceof ShearsItem || heldStack.getItem() instanceof KnifeItem) {
            Block newBlock = player.isSecondaryUseActive() ? CARVE_PREV_MAP.get(block) : CARVE_NEXT_MAP.get(block);
            if (newBlock != null) {
                if (Utils.isClientWorld(world)) {
                    player.swing(event.getHand());
                } else {
                    Direction newDir = face.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : face;
                    world.setBlock(pos, newBlock.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, newDir), 11);
                }
            }
        }
    }

}
