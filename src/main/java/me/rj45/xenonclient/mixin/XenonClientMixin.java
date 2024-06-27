package me.rj45.xenonclient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.rj45.xenonclient.client.XenonClient;
import net.minecraft.client.MinecraftClient;

@Mixin(MinecraftClient.class)
public class XenonClientMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void onTick(CallbackInfo info) {
        XenonClient.INSTANCE.onTick();
    }
}
