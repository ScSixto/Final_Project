package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class JPCenterPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JPTourPackagePanel tourPanel;

	public JPCenterPanel() {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		layout.setVgap(20);
		setBackground(ConstantsGUI.DESPEGAR_LIGHT_PURPLE);
		setLayout(layout);
		setOpaque(true);
		addTourPanel();
	}
	
	protected void addTourPanel(){
//		tourPanel = new JPTourPackagePanel();
//		System.out.println(this.getHeight());
//		tourPanel.setPreferredSize(new Dimension(1050,190));
//		add(tourPanel);
		PanelAlojamientosCentro accomodationPanel= new PanelAlojamientosCentro();
		accomodationPanel.setPreferredSize(new Dimension(1050,190));
		add(accomodationPanel);
	}
}
