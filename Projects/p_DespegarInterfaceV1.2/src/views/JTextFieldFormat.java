package views;

import javax.swing.*;
import java.awt.*;

public class JTextFieldFormat extends JTextField {

	private static final long serialVersionUID = 1L;
	
    public JTextFieldFormat(JLabelFormat text,Dimension size){
        super(text.getText());
        this.setPreferredSize(size);
        this.setFont(text.getFont());
        this.setForeground(text.getForeground());
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
    }
}
