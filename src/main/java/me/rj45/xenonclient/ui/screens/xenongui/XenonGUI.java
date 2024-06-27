package me.rj45.xenonclient.ui.screens.xenongui;

import me.rj45.xenonclient.module.XenonModule.Category;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class XenonGUI extends Screen {
    public static final XenonGUI INSTANCE = new XenonGUI();

    private List<Frame> frames;

    private XenonGUI() {
        super(Text.literal("XenonClient"));

        frames = new ArrayList<>();

        int offset = 20;
        for (Category category : Category.values()) {
            frames.add(new Frame(category, offset, 25, 100, 30));
            offset += 120;
        }
    }

    @Override
    protected void init() {
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.drawText(textRenderer, "Xenon Client", 5, 5, -1, true);

        for (Frame frame : frames) {
            frame.render(context, mouseX, mouseY, delta);
            frame.updatePosition(mouseX, mouseY);
        }
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (Frame frame : frames) {
            frame.mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        for (Frame frame : frames) {
            frame.mouseReleased(mouseX, mouseY, button);
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
