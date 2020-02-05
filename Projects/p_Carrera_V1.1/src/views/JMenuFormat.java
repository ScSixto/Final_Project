package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenu;

public class JMenuFormat extends JMenu{

	private static final long serialVersionUID = 1L;

	public JMenuFormat(String menuTitle, Font font, Color foreground){
		super(menuTitle);
		this.setFont(font);
		this.setForeground(foreground);
		this.setOpaque(false);
	}
}