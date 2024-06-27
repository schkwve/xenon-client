package me.rj45.xenonclient.client;

import me.rj45.xenonclient.module.XenonModule;
import me.rj45.xenonclient.module.ModuleManager;
import me.rj45.xenonclient.ui.screens.xenongui.XenonGUI;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import org.lwjgl.glfw.GLFW;

public class XenonClient implements ModInitializer {
    public static final XenonClient INSTANCE = new XenonClient();
    public static final Logger logger = LogManager.getLogger(XenonClient.class);

    private MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {
        logger.info("Locked and loaded!");
    }

    public void onKeyPress(int key, int action) {
        if (action == GLFW.GLFW_PRESS) {
            for (XenonModule module : ModuleManager.INSTANCE.getModules()) {
                if (module.getKey() == key) {
                    module.toggle();
                }
            }

            if (key == GLFW.GLFW_KEY_RIGHT_SHIFT) {
                mc.setScreen(XenonGUI.INSTANCE);
            }
        }
    }

    public void onTick() {
        if (mc.player != null) {
            for (XenonModule module : ModuleManager.INSTANCE.getEnabledModules()) {
                module.onTick();
            }
        }
    }
}
