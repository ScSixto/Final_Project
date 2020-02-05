package views;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JBBoxButton extends JButton{

	private static final long serialVersionUID = 1L;
	
	public static final Dimension DEFAULT_BOX_BUTTON_ICON_DIMENSION = new Dimension(17,17);
	public static final String DEFAULT_BOX_BUTTON_ICON_PATH = "resources/img/ArrowDown.png";
	public static final ImageIcon DEFAULT_BOX_BUTTON_ICON = new ImageIcon(new ImageIcon(DEFAULT_BOX_BUTTON_ICON_PATH).getImage().getScaledInstance((int)DEFAULT_BOX_BUTTON_ICON_DIMENSION.getWidth(),(int)DEFAULT_BOX_BUTTON_ICON_DIMENSION.getHeight(),Image.SCALE_AREA_AVERAGING));
	
	public JBBoxButton(String text){
		super(text);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.LEFT);
		this.setIcon(DEFAULT_BOX_BUTTON_ICON);
		this.setBackground(ConstantsGUI.COLOR_IMPOSSIBLE);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		this.setBorderPainted(false);
		this.setForeground(ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY);
		this.setFont(new Font("Arial",Font.PLAIN,14));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
