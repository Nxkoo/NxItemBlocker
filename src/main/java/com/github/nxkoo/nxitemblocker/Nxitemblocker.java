package com.github.nxkoo.nxitemblocker;

import net.fabricmc.api.ModInitializer;

public class Nxitemblocker implements ModInitializer {
    private final List<String> blockedItems = Arrays.asList(
            "minecraft:iron_sword",
            "minecraft:diamond_sword"
    );

    @Override
    public void onInitialize() {

    }
}
