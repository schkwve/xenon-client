package me.rj45.xenonclient.ui.screens.xenongui;

import me.rj45.xenonclient.module.ModuleManager;
import me.rj45.xenonclient.module.XenonModule;
import me.rj45.xenonclient.module.XenonModule.Category;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class Frame {
    public int x, y;
    public int dragX, dragY;
    public int width, height;
    public Category category;
    public boolean dragging;

    protected MinecraftClient mc = MinecraftClient.getInstance();
    protected TextRenderer textRenderer = mc.textRenderer;

    private List<ModuleButton> buttons;

    public Frame(Category category, int x, int y, int width, int height) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dragging = false;

        buttons = new ArrayList<>();

        int offset = height;
        for (XenonModule module : ModuleManager.INSTANCE.getModulesInCategory(category)) {
            buttons.add(new ModuleButton(module, this, offset));
            offset += height;
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(x, y, x + width, y + height, Color.red.getRGB());
        context.drawText(textRenderer, category.name, x + 2, y + 2, -1, false);

        for (ModuleButton button : buttons) {
            button.render(context, mouseX, mouseY, delta);
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY) && button == 0) {
            dragging = true;
            dragX = (int)mouseX - x;
            dragY = (int)mouseY - y;
        }

        for (ModuleButton modbutton : buttons) {
            modbutton.mouseClicked(mouseX, mouseY, button);
        }
    }

    public void mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0 && dragging == true) {
            dragging = false;
        }
    }

    public boolean isHovered(double mouseX, double mouseY) {
        return (mouseX > x && mouseX < x + width) &&
                (mouseY > y && mouseY < y + height);
    }

    public void updatePosition(double mouseX, double mouseY) {
        if (dragging) {
            x = (int)(mouseX - dragX);
            y = (int)(mouseY - dragY);
        }
    }
}
