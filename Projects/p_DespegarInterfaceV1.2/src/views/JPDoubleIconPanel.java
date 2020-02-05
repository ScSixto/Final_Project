package views;

import javax.swing.*;
import java.awt.*;

public class JPDoubleIconPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static final Dimension DEFAULT_ICON_DIMENSION = new Dimension(16,16);

    public JPDoubleIconPanel(String iconPath1, JLabelFormat text1, String iconPath2, JLabelFormat text2){
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImageIcon icon1 = new ImageIcon(new ImageIcon(iconPath1).getImage().getScaledInstance((int)DEFAULT_ICON_DIMENSION.getWidth(),(int)DEFAULT_ICON_DIMENSION.getHeight(),Image.SCALE_AREA_AVERAGING));
        ImageIcon icon2 = new ImageIcon(new ImageIcon(iconPath2).getImage().getScaledInstance((int)DEFAULT_ICON_DIMENSION.getWidth(),(int)DEFAULT_ICON_DIMENSION.getHeight(),Image.SCALE_AREA_AVERAGING));
        this.initComponents(icon1, text1, icon2, text2);
    }

    private void initComponents(ImageIcon icon1, JLabelFormat text1, ImageIcon icon2, JLabelFormat text2) {
        this.addComponent(icon1,text1);
        this.addComponent(icon2,text2);
    }

    private void addComponent(ImageIcon icon, JLabelFormat text){
        JLabel component = new JLabel(text.getText());
        component.setFont(text.getFont());
        component.setForeground(text.getForeground());
        component.setHorizontalTextPosition(SwingConstants.RIGHT);
        component.setVerticalTextPosition(SwingConstants.CENTER);
        component.setIcon(icon);

        this.add(component);
    }
}