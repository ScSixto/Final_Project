package views;

import javax.swing.*;
import java.awt.*;

public class JCBCheckBoxFormat extends JCheckBox{

	private static final long serialVersionUID = 1L;

	public static final int ANGLE_BORDER = 20;

    public static final Dimension DEFAULT_BOX_BUTTON_ICON_DIMENSION = new Dimension(17,17);
    public static final String DEFAULT_BOX_BUTTON_ICON_PATH = "resources/img/Vuelos.png";

    public JCBCheckBoxFormat(JLabelFormat text){
        super(text.getText());
        this.setForeground(text.getForeground());
        this.setFont(text.getFont());
        this.setBackground(ConstantsGUI.COLOR_IMPOSSIBLE);
        this.setOpaque(false);
        this.setPressedIcon(new ImageIcon(new ImageIcon(DEFAULT_BOX_BUTTON_ICON_PATH).getImage().getScaledInstance((int)DEFAULT_BOX_BUTTON_ICON_DIMENSION.getWidth(),(int)DEFAULT_BOX_BUTTON_ICON_DIMENSION.getHeight(),Image.SCALE_AREA_AVERAGING)));

    }
}