package views.header;

import views.ConstantsGUI;

import javax.swing.*;
import java.awt.*;

public class JBNorthMenuBarButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	public static final Color DEFAULT_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY;
    public static final Dimension DEFAULT_ICON_DIMENSION = new Dimension(28, 29);

    public JBNorthMenuBarButton(String text, String iconPath) {
        super(text);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setFont(ConstantsGUI.FONT_GENERAL_BUTTON);
        this.setForeground(DEFAULT_FOREGROUND);
        
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.setBorderPainted(false);

        this.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance((int) DEFAULT_ICON_DIMENSION.getWidth(), (int) DEFAULT_ICON_DIMENSION.getHeight(), Image.SCALE_AREA_AVERAGING)));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }
}