package org.flomik.skintls.mixin;

import net.minecraft.client.texture.PlayerSkinTextureDownloader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.net.URI;

@Mixin(PlayerSkinTextureDownloader.class)
public abstract class PlayerSkinTextureDownloaderMixin {

    @ModifyVariable(
            method = "downloadAndRegisterTexture",
            at = @At("HEAD"),
            argsOnly = true,
            ordinal = 0,
            require = 0
    )
    private static String skintls$registerHead(String uri) {
        return rewrite(uri);
    }

    @ModifyVariable(
            method = "download",
            at = @At("HEAD"),
            argsOnly = true,
            ordinal = 0,
            require = 0
    )
    private static String skintls$downloadHead(String uri) {
        return rewrite(uri);
    }

    //save only
    @ModifyArg(
            method = "downloadAndRegisterTexture",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/texture/PlayerSkinTextureDownloader;download(Ljava/nio/file/Path;Ljava/lang/String;)Lnet/minecraft/client/texture/NativeImage;"
            ),
            index = 1,
            require = 0
    )
    private static String skintls$registerInvoke(String uri) {
        return rewrite(uri);
    }

    private static String rewrite(String uri) {
        try {
            if (uri == null) return null;
            URI u = URI.create(uri);
            if ("http".equalsIgnoreCase(u.getScheme())
                    && "textures.minecraft.net".equalsIgnoreCase(u.getHost())) {
                return new URI(
                        "https",
                        u.getUserInfo(),
                        u.getHost(),
                        -1,
                        u.getPath(),
                        u.getQuery(),
                        u.getFragment()
                ).toString();
            }
        } catch (Exception ignored) {}
        return uri;
    }
}
