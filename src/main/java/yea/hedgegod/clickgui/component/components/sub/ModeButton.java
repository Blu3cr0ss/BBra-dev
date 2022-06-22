package yea.hedgegod.clickgui.component.components.sub;

import font.FontUtils;
import hedgegod.bbra.bbraexploit.Module.Module;
import hedgegod.bbra.bbraexploit.UI.Cols;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import yea.hedgegod.clickgui.Setting;
import yea.hedgegod.clickgui.component.Component;
import yea.hedgegod.clickgui.component.components.Button;

public class ModeButton extends Component {

	private boolean hovered;
	private Button parent;
	private Setting set;
	private int offset;
	private int x;
	private int y;
	private Module mod;
	private int modeIndex;
	
	public ModeButton(Setting set, Button button, Module mod, int offset) {
		this.set = set;
		this.parent = button;
		this.mod = mod;
		this.x = button.parent.getX() + button.parent.getWidth();
		this.y = button.parent.getY() + button.offset;
		this.offset = offset;
		this.modeIndex = 0;

		set.setValString(set.getOptions().get(0));
	}
	
	@Override
	public void setOff(int newOff) {
		offset = newOff;
	}
	
	@Override
	public void renderComponent() {
		Gui.drawRect(parent.parent.getX(), parent.parent.getY() + offset, parent.parent.getX() + (parent.parent.getWidth() * 1), parent.parent.getY() + offset + 12, this.hovered ? Cols.LightYellow : Cols.PurpleOpac);

		GL11.glPushMatrix();
		//GL11.glScalef(0.5f,0.5f, 0.5f);
		FontUtils.normal.drawString(set.getTitle()+": " + set.getOptions().get(modeIndex), (parent.parent.getX() + 7), (parent.parent.getY() + offset + 2) + 1, -1);
		GL11.glPopMatrix();
	}
	
	@Override
	public void updateComponent(int mouseX, int mouseY) {
		this.hovered = isMouseOnButton(mouseX, mouseY);
		this.y = parent.parent.getY() + offset;
		this.x = parent.parent.getX();
	}
	
	@Override
	public void mouseClicked(int mouseX, int mouseY, int button) {
		if(isMouseOnButton(mouseX, mouseY) && button == 0 && this.parent.open) {
			int maxIndex = set.getOptions().size();

			if(modeIndex + 1 >= maxIndex)
				modeIndex = 0;
			else
				modeIndex++;

			set.setValString(set.getOptions().get(modeIndex));
		}
	}
	
	public boolean isMouseOnButton(int x, int y) {
		if(x > this.x && x < this.x + 88 && y > this.y && y < this.y + 12) {
			return true;
		}
		return false;
	}
}
