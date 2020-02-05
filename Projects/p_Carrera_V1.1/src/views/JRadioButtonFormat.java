package views;

import javax.swing.*;
import java.awt.*;

public class JRadioButtonFormat extends JRadioButton{

    public static final Font DEFAULT_RADIO_BUTTON_FONT = new Font("Arial",Font.PLAIN,14);
    public static final Color DEFAULT_RADIO_BUTTON_FOREGROUND = ConstantsGUI.COLOR_DARK_GRAY;

    public JRadioButtonFormat(String text){
        super(text);
        this.setOpaque(false);
        this.setFont(DEFAULT_RADIO_BUTTON_FONT);
        this.setForeground(DEFAULT_RADIO_BUTTON_FOREGROUND);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
    }
}
