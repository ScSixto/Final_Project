package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenuItem;

public class JMIMenuItemFormat extends JMenuItem{

	private static final long serialVersionUID = 1L;

	public JMIMenuItemFormat(String itemText, Font font, Color foreground) {
		super(itemText);
		this.setFont(font);
		this.setForeground(foreground);
		this.setOpaque(false);
	}
}
