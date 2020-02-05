package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPHeaderPanel extends JPanel{

	private static final long serialVersionUID = 1L;

    public static final String DEFAULT_TITLE_TEXT = "Expo Layouts";
    public static final String DEFAULT_TITLE_ICON_PATH = "resources/img/Layout.png";
    public static final Dimension DEFAULT_TITLE_ICON_DIMENSION = new Dimension(50,50);
    public static final Font DEFAULT_TITLE_FONT = new Font("Arial", Font.BOLD,50);
    public static final Color DEFAULT_TITLE_FOREGROUND = ConstantsGUI.COLOR_DARK_GRAY;

    public JPHeaderPanel(ActionListener act){
        this.setBackground(ConstantsGUI.COLOR_LIGHT_GRAY_4);
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.setLayout(new BorderLayout());
        this.initComponents(act);
    }

    private void initComponents(ActionListener act){
        this.add(new JLabelFormat(DEFAULT_TITLE_ICON_PATH, DEFAULT_TITLE_ICON_DIMENSION, DEFAULT_TITLE_TEXT, DEFAULT_TITLE_FONT, DEFAULT_TITLE_FOREGROUND));
    }
}