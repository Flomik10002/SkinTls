package org.flomik.skintls;

import net.fabricmc.api.ClientModInitializer;

public class SkinTlsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.println("[SkinTLS] Initialized: forcing https for textures.minecraft.net");
    }
}
