package views;

import javax.swing.*;
import java.awt.*;

public class JLabelFormat extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
    public JLabelFormat(String text, Font font, Color foreground){
        super(text);
        this.setFont(font);
        this.setForeground(foreground);
    }

    public JLabelFormat(String text, Font font, Color foreground, ImageIcon icon, int horizontalTextAlign, int verticalTextAlign){
        this(text,font,foreground);
        this.setIcon(icon);
        this.setHorizontalTextPosition(horizontalTextAlign);
        this.setVerticalTextPosition(verticalTextAlign);
    }

    public JLabelFormat(ImageIcon icon){
        this.setIcon(icon);
    }
}
