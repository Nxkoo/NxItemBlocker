package com.github.nxkoo.nxitemblocker;

import com.github.nxkoo.nxitemblocker.lib.SimpleConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;

import java.util.List;

public class NxItemBlocker implements ModInitializer {
    private final SimpleConfig CONFIG = SimpleConfig.of("nxitemblocker").provider(this::provider).request();
    private String provider(String pvd) {
        return "nxitemblocker";
    }
    private final List<String> blockedItems = CONFIG.getStringList("blockedItems");
    @Override
    public void onInitialize() {
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (entity instanceof ItemFrameEntity) {
                ItemStack itemStack = player.getStackInHand(hand);
                if (itemStack.isEmpty()) return ActionResult.PASS;
                if (blockedItems.contains(itemStack.getItem().toString())) return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
    }
}
