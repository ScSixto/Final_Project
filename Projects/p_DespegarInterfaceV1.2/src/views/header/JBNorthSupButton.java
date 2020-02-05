package views.header;

import views.ConstantsGUI;

import javax.swing.*;
import java.awt.*;

public class JBNorthSupButton extends JButton {

	private static final long serialVersionUID = 1L;

    public JBNorthSupButton(String text, String iconPath, Dimension size,Font font,Color foreground){
        super(text);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.RIGHT);
        this.setFont(font);
        this.setForeground(foreground);

        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.setBorderPainted(false);

        this.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance((int)size.getWidth(),(int)size.getHeight(),Image.SCALE_AREA_AVERAGING)));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }
}