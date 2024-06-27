package me.rj45.xenonclient.module.movement;

import me.rj45.xenonclient.module.XenonModule;
import org.lwjgl.glfw.GLFW;

public class Flight extends XenonModule {
    public Flight() {
        super("Flight", "Allows you to fly", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_G);
    }

    @Override
    public void onTick() {
        assert mc.player != null;
        mc.player.getAbilities().allowFlying = true;
        super.onTick();
    }

    @Override
    public void onDisable() {
        assert mc.player != null;
        mc.player.getAbilities().allowFlying = false;
    }
}
