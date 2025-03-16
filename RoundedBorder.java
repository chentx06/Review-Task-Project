package ICS3USummativeProjectCopy4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundedBorder implements Border{

	private int radius;
	
	RoundedBorder(int radius){
		this.radius = radius;
	}
	
	//decides the spaces to leave between the button center and edge lines
	public Insets getBorderInsets(Component c) {
		return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius+1);
	}
	
	//so anything beneath is visible
	public boolean isBorderOpaque() {
		return true;
	}

	//paints the border around this particular component, then colours it
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		//note that the alpha value changes the opacity
		g.setColor(new Color(255,0,166,50));
		g.drawRoundRect(x, y, width, height, width, height);
		g.fillRoundRect(x, y, width, height, width, height);
	}
}
