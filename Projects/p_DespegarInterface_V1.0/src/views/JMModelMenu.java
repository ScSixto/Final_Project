package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.border.EmptyBorder;

public class JMModelMenu extends JMenu{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JMModelMenu(String text, Color colorBackGround, Font font){
		setText(text);
		setBackground(colorBackGround);
		setBorderPainted(false);
		setBorder(new EmptyBorder(0,15,0,0));
		setFont(font);
		
	}
}
