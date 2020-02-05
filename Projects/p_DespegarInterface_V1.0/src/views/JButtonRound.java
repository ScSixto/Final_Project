package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JButtonRound extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon normalIcon;
	private ImageIcon upIcon;

	public JButtonRound(String text,String iconPath, String iconUpPath){
		super(text);
		normalIcon = new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_DEFAULT));
		upIcon = new ImageIcon(new ImageIcon(iconUpPath).getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_DEFAULT));
		setIcon(normalIcon);
		setMaximumSize(new Dimension());
		setFont(new Font("Arial",Font.BOLD,16));
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.RIGHT);
		setOpaque(false);
		setBorderPainted(false);
		setFocusable(false);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder(0,15,5,15));
		setForeground(ConstantsGUI.DESPEGAR_LIGHT_GRAY);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addEvents();
		
  	}
	
	protected void addEvents(){
		JButton button = this;
		super.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent e){
            	button.setIcon(upIcon);
            	button.setForeground(ConstantsGUI.DESPEGAR_DARK_PURPLE);
            	button.setBackground(ConstantsGUI.DESPEGAR_LIGHT_PURPLE);
//            	button.paint(button.getGraphics());
            }
            @Override
            public void mouseExited(MouseEvent e){
            	button.setIcon(normalIcon);
            	button.setForeground(ConstantsGUI.DESPEGAR_LIGHT_GRAY);
//            	button.paintComponent(button.getGraphics());

            }
        });
	}

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Dimension arcs = new Dimension(30,40); //Border corners arcs {width,height}, change this to whatever you want
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded panel with borders.
//        graphics.setColor(Color.black);
        
//        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
        	graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
//        graphics.setColor(ConstantsGUI.DESPEGAR_LIGHT_GRAY);
	}
	
}
