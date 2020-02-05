package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPTourPackagePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public JPTourPackagePanel() {
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		layout.setHgap(20);
		layout.setVgap(7);
		setLayout(layout);
		setBackground(ConstantsGUI.WHITE);
		setOpaque(false);
		setTitle();
		addButtons();
		addReservationPanel();
	}
	
	private void addButtons(){
		this.add(new JButtonRound("Vuelo + Alojamiento","resources/img/Vuelos.png","resources/img/VuelosUp.png"));
		this.add(new JButtonRound("Vuelo + 2 Alojamientos","resources/img/Vuelos.png","resources/img/VuelosUp.png"));
		this.add(new JButtonRound("Vuelo + Carro","resources/img/Vuelos.png","resources/img/VuelosUp.png"));
	}
	
	private void setTitle(){
		JLabel title = new JLabel("Paquetes turísticos");
		title.setForeground(ConstantsGUI.DESPEGAR_LIGHT_GRAY);
		title.setFont(new Font("Arial",Font.BOLD,24));
		this.add(title);		
	}
	private void addReservationPanel(){
		JPReservation reservationPanel = new JPReservation();
		reservationPanel.setPreferredSize(new Dimension(1050,190));
		add(reservationPanel);
	}
	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Dimension arcs = new Dimension(30,30); //Border corners arcs {width,height}, change this to whatever you want
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
        graphics.setColor(getBackground());
        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
	  }
}
