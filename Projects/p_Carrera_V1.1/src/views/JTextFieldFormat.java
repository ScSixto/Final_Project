package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTextFieldFormat extends JTextField {

	private static final long serialVersionUID = 1L;

	public static final String DEFAULT_TEXT_FIELD_TEXT = "";
	public static final Font DEFAULT_TEXT_FIELD_FONT = new Font("Arial",Font.PLAIN,14);
	public static final Color DEFAULT_TEXT_FIELD_FOREGROUND = ConstantsGUI.COLOR_DARK_GRAY;
	public static final Color DEFAULT_TEXT_FIELD_BACKGROUND = ConstantsGUI.COLOR_LIGHT_GRAY_4;

    public JTextFieldFormat(String text, Dimension size){
        super(text);
        this.setFont(DEFAULT_TEXT_FIELD_FONT);
        this.setForeground(DEFAULT_TEXT_FIELD_FOREGROUND);

        this.setPreferredSize(size);
        this.setBackground(DEFAULT_TEXT_FIELD_BACKGROUND);
        this.setOpaque(true);

        this.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
    }

    public void reset(){
        this.setText(DEFAULT_TEXT_FIELD_TEXT);
    }
}