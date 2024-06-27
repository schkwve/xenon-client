package me.rj45.xenonclient.module.movement;

import me.rj45.xenonclient.module.XenonModule;
import org.lwjgl.glfw.GLFW;

public class Sprint extends XenonModule {
    public Sprint() {
        super("Sprint", "Keeps you sprinting", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_V);
    }

    @Override
    public void onTick() {
        assert mc.player != null;
        mc.player.setSprinting(true);
        super.onTick();
    }

    @Override
    public void onDisable() {
        assert mc.player != null;
        mc.player.setSprinting(false);
    }
}
