package inc.bbra.oldclickgui;

import inc.bbra.font.FontUtils;
import inc.bbra.exploit.Module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.io.IOException;

public class Button {
    public Minecraft mc = Minecraft.getMinecraft();

    public int x, y, width, height;
    public boolean binding;
    public Module module;

    public Button(int x, int y, int width, int height, Module module) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.module = module;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Gui.drawRect(x + 10, y, x + width - 10, y + height, new Color(0xCCE8AB45, true).hashCode());
        FontUtils.normal.drawString(!binding ? module.name : "< PRESS KEY >", x + width / 2 - FontUtils.normal.getStringWidth (!binding ? module.name : "< PRESS KEY >") / 2, y + height / 2 - 9 / 2, module.toggled && !binding ? new Color(0x8653E1).hashCode() : -1);
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (binding) {
            module.keyCode = keyCode;
            binding = false;

            if (keyCode == Keyboard.KEY_ESCAPE) {
                module.keyCode = 0;
            }
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (HoverUtils.hovered(mouseX, mouseY, x, y, x + width, y + height)) {
            if (mouseButton == 0) {
                module.toggle();
            } else if (mouseButton == 2) {
                binding = !binding;
            }
        }
    }

    protected void mouseReleased(int mouseX, int mouseY, int state) {
    }
}
