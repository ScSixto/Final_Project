package views;

import javax.swing.*;
import java.awt.*;

public class JButtonFormat extends JButton{

	private static final long serialVersionUID = 1L;

	public static final Font DEFAULT_BUTTON_FONT = new Font("Arial",Font.PLAIN,14);
    private static final Color DEFAULT_BUTTON_FOREGROUND = ConstantsGUI.COLOR_DARK_GRAY;

    public JButtonFormat(){
	    this.setBackground(ConstantsGUI.COLOR_IMPOSSIBLE);
	    this.setOpaque(false);
	    this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
	    this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

	public JButtonFormat(String iconPath, Dimension iconDimension){
        this();
        this.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance((int)iconDimension.getWidth(),(int)iconDimension.getHeight(),Image.SCALE_AREA_AVERAGING)));
    }

    public JButtonFormat(String text, Dimension buttonDimension, Color background){
        super(text);
        this.setFont(DEFAULT_BUTTON_FONT);
        this.setForeground(DEFAULT_BUTTON_FOREGROUND);

        this.setSize(buttonDimension);
	    this.setBackground(background);
        this.setOpaque(true);

        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	    this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}