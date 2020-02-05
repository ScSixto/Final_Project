package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class JMBMainMenuBar extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JMBMainMenuBar(){
//		this.setBackground(Color.decode("#103144"));
		this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		this.setBorderPainted(false);
		setBackground(Color.decode("#FFFFFF"));
		this.setOpaque(true);
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		layout.setHgap(30);
		initComponents();
	}

	private void initComponents() {
//		ImageIcon originalImage = new ImageIcon("mama.png");//getClass().getResource("/mama.png"));
		this.add(new JButtonPpal("Alojamientos", "resources/img/Alojamiento.png","resources/img/AlojamientoUp.png"));
		this.add(new JButtonPpal("Vuelos","resources/img/Vuelos.png","resources/img/VuelosUp.png"));
		this.add(new JButtonPpal("Paquetes", "resources/img/Paquetes.png","resources/img/PaquetesUp.png"));
		this.add(new JButtonPpal("Imbatibles","resources/img/Imbatibles.png","resources/img/ImbatiblesUp.png"));
		this.add(new JButtonPpal("Escapadas",  "resources/img/Escapadas.png","resources/img/EscapadasUp.png"));
		this.add(new JButtonPpal("Actividades", "resources/img/Actividades.png","resources/img/ActividadesUp.png"));
		this.add(new JButtonPpal("Carros", "resources/img/Carros.png","resources/img/CarrosUp.png"));
		this.add(new JButtonPpal("Disney", "resources/img/Disney.png","resources/img/DisneyUp.png"));
		this.add(new JButtonPpal("Seguros", "resources/img/Seguros.png","resources/img/SegurosUp.png"));
		this.add(new JButtonPpal("Traslados", "resources/img/Traslados.png","resources/img/TrasladosUp.png"));
		this.add(new JButtonPpal("Cruceros", "resources/img/Cruceros.png","resources/img/CrucerosUp.png"));
		this.add(new JLabel("\t\t"));
		//this.add(new JButtonRound("Descubre y Viaja", "resources/img/DescubreYViaja.png", "resources/img/DescubreYViajaUp.png"));
		
		JButton button = new JButton("Descubre y Viaja");
		button.setIcon(new ImageIcon(new ImageIcon("resources/img/DescubreYViaja.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT)));
		button.setFont(new Font("Arial",Font.BOLD,14));
		button.setVerticalTextPosition(SwingConstants.CENTER);
		button.setHorizontalTextPosition(SwingConstants.RIGHT);
		button.setOpaque(true);
		button.setBorderPainted(true);
		button.setFocusable(false);
		button.setBackground(Color.WHITE);
		button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		button.setForeground(ConstantsGUI.DESPEGAR_LIGHT_GRAY);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.setBorder(new Border(){
			int radius = 40;
			@Override
			public Insets getBorderInsets(Component c) {
				return new Insets(5,25,5,25);
			}
			@Override
			public boolean isBorderOpaque() {
				return true;
			}

			@Override
			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
				g.drawRoundRect(x, y, width-1, height-1, radius, radius);				
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseEntered(MouseEvent arg0){
            	button.setIcon(new ImageIcon(new ImageIcon("resources/img/DescubreYViajaUp.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT)));
            	button.setForeground(ConstantsGUI.WHITE);
            	button.setBackground(ConstantsGUI.DESPEGAR_DARK_GRAY);
                //button.setBackground((Color.RED));
            }
            @Override
            public void mouseExited(MouseEvent e){
            	button.setIcon(new ImageIcon(new ImageIcon("resources/img/DescubreYViaja.png").getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT)));
            	button.setForeground(ConstantsGUI.DESPEGAR_LIGHT_GRAY);
                button.setBackground((ConstantsGUI.WHITE));
            }
        });
		this.add(button);
	}


}
