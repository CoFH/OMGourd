package cofh.omgourd.event;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;

import static cofh.lib.util.constants.Constants.ID_OMGOURD;

// @Mod.EventBusSubscriber(modid = ID_OMGOURD)
public class CommonEvents {

    private static Object2ObjectOpenHashMap<Block, Block> CARVE_PREV_MAP = new Object2ObjectOpenHashMap<>();
    private static Object2ObjectOpenHashMap<Block, Block> CARVE_NEXT_MAP = new Object2ObjectOpenHashMap<>();

    private CommonEvents() {

    }

    //    @SubscribeEvent
    //    public static void handlePlayerRightClickEvent(PlayerInteractEvent event) {
    //
    //        if (event.isCanceled()) {
    //            return;
    //        }
    //        if (!(event instanceof PlayerInteractEvent.RightClickItem || event instanceof PlayerInteractEvent.RightClickBlock)) {
    //            return;
    //        }
    //        PlayerEntity player = event.getPlayer();
    //        if (player.fishingBobber == null || Utils.isClientWorld(player.world)) {
    //            return;
    //        }
    //        FishingBobberEntity hook = player.fishingBobber;
    //        Entity entity = hook.func_234607_k_();
    //
    //        if (entity instanceof PlayerEntity && !PilferingEnchantment.allowPlayerStealing) {
    //            return;
    //        }
    //        int encPilfer = getHeldEnchantmentLevel(player, PILFERING);
    //        if (encPilfer > 0 && entity instanceof LivingEntity) {
    //            LivingEntity living = (LivingEntity) entity;
    //            ItemStack armor = stealArmor(living);
    //            if (armor.isEmpty()) {
    //                return;
    //            }
    //            ItemEntity armorEntity = new ItemEntity(living.world, living.getPosX(), living.getPosY() + 0.5D, living.getPosZ(), armor);
    //            armorEntity.setOwnerId(player.getUniqueID());
    //            armorEntity.setPickupDelay(5);
    //            armorEntity.world.addEntity(armorEntity);
    //            armorEntity.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());
    //        }
    //    }

}
