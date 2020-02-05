package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JButtonFormat extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 40;
	private static final int HEIGHT = 40;

	private JButton button;
	private ImageIcon normalIcon;
	private ImageIcon upIcon;
	
	
	public JButtonFormat(String text,String iconPath, String iconUpPath){
		super(text);
		setBorderPainted(false);
		setFocusable(false);
		normalIcon = new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_DEFAULT));
		setIcon(normalIcon);
		setOpaque(true);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		setForeground(ConstantsGUI.DESPEGAR_LIGHT_GRAY);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		button = this;
		upIcon = new ImageIcon(new ImageIcon(iconUpPath).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_DEFAULT));
		
//		JButton button = new JButton();
		super.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0){
            	button.setIcon(upIcon);
            	button.setForeground(ConstantsGUI.DESPEGAR_LIGHT_PURPLE);
                //button.setBackground((Color.RED));
            }
            @Override
            public void mouseExited(MouseEvent e){
            	button.setIcon(normalIcon);
            	button.setForeground(ConstantsGUI.DESPEGAR_LIGHT_GRAY);
                //button.setBackground((Color.BLUE));
            }
        });
  	}
}