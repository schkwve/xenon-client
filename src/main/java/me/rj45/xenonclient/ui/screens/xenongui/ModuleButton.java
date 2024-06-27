package me.rj45.xenonclient.ui.screens.xenongui;

import me.rj45.xenonclient.module.XenonModule;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import org.w3c.dom.Text;

import java.awt.*;

public class ModuleButton {
    public XenonModule module;
    public Frame parent;
    public int offset;

    public TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

    public ModuleButton(XenonModule module, Frame parent, int offset) {
        this.module = module;
        this.parent = parent;
        this.offset = offset;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height, new Color(0, 0, 0, 160).getRGB());
        if (isHovered(mouseX, mouseY)) {
            context.fill(parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height, new Color(0, 0, 0, 255).getRGB());
        }
        context.drawText(textRenderer, module.getName(), parent.x + 2, parent.y + offset + 2, -1, true);
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY)) {
            if (button == 0) {
                module.toggle();
            }
        }
    }

    public boolean isHovered(double mouseX, double mouseY) {
        return (mouseX > parent.x && mouseX < (parent.x + parent.width)) &&
                (mouseY > parent.y + offset && mouseY < (parent.y + offset + parent.height));
    }
}
