package me.rj45.xenonclient.mixin;

import me.rj45.xenonclient.client.XenonClient;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.Keyboard;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo info) {
        XenonClient.INSTANCE.onKeyPress(key, action);
    }
}
