package views;

import javax.swing.*;
import java.awt.*;

public class JLabelFormat extends JLabel{

    public JLabelFormat(String backgorundImagePath, Dimension labelSize){
        this.setIcon(new ImageIcon(new ImageIcon(backgorundImagePath).getImage().getScaledInstance((int)labelSize.getWidth(),(int)labelSize.getHeight(),Image.SCALE_AREA_AVERAGING)));
        this.setSize(labelSize);
    }

    public JLabelFormat(String backgorundImagePath, Dimension labelSize, String text, Font font, Color foreground){
        super(text);
        this.setFont(font);
        this.setForeground(foreground);
        this.setHorizontalTextPosition(RIGHT);
        this.setIcon(new ImageIcon(new ImageIcon(backgorundImagePath).getImage().getScaledInstance((int)labelSize.getWidth(),(int)labelSize.getHeight(),Image.SCALE_AREA_AVERAGING)));
        this.setSize(labelSize);
    }

    public JLabelFormat(String text, Font font, Color foreground){
        super(text);
        this.setFont(font);
        this.setForeground(foreground);
    }
}
