package me.rj45.xenonclient.ui;

import me.rj45.xenonclient.module.ModuleManager;
import me.rj45.xenonclient.module.XenonModule;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

import java.util.List;
import java.util.Comparator;

public class Hud {
    private static MinecraftClient mc = MinecraftClient.getInstance();
    private static TextRenderer textRenderer = mc.textRenderer;

    public static void render(DrawContext context, RenderTickCounter tickCounter) {
        renderArrayList(context);
    }

    public static void renderArrayList(DrawContext context) {
        int index = 0;

        int sWidth = mc.getWindow().getScaledWidth();
        int sHeight = mc.getWindow().getScaledHeight();

        List<XenonModule> enabled = ModuleManager.INSTANCE.getEnabledModules();
        enabled.sort(Comparator.comparingInt(m -> mc.textRenderer.getWidth(((XenonModule)m).getDisplayName())).reversed());

        for (XenonModule module : enabled) {
            context.drawTextWithShadow(textRenderer, module.getDisplayName(), (sWidth  - 4) - mc.textRenderer.getWidth(module.getDisplayName()), 10 + (index * mc.textRenderer.fontHeight), -1);
            ++index;
        }
    }
}
