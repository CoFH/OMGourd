package cofh.omgourd.event;

import cofh.lib.util.Utils;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.Constants.ID_OMGOURD;

@Mod.EventBusSubscriber(modid = ID_OMGOURD)
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
    public static void handlePlayerRightClickEvent(PlayerInteractEvent event) {

        if (event.isCanceled()) {
            return;
        }
        if (!(event instanceof PlayerInteractEvent.RightClickBlock)) {
            return;
        }
        World world = event.getWorld();
        Direction face = event.getFace();
        if (face == null) {
            return;
        }
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();
        Block block = world.getBlockState(pos).getBlock();

        ItemStack heldStack = player.getItemInHand(event.getHand());
        if (heldStack.getItem() instanceof ShearsItem) {
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
