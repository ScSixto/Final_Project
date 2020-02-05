package views;


import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPReservation extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPReservation() {
		GridLayout layout = new GridLayout(3,6,2,3);
		setLayout(layout);
		setBackground(ConstantsGUI.DESPEGAR_DARK_GRAY);
		setOpaque(false);
		addLabel("ORIGEN");
		addLabel("DESTINO");

	}
	protected void addLabel(String name){
		JLabel label = new JLabel(name);
		label.setFont(new Font("Arial",Font.BOLD,14));
		label.setForeground(ConstantsGUI.DESPEGAR_ULTRA_LIGHT_GRAY);
		add(label);
		
	}
}
