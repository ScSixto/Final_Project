package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class JPMainPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

	private static final int WIDTH = (int) SCREEN_SIZE.getWidth();
	private static final int HEIGHT = (int) SCREEN_SIZE.getHeight();
	private JPNorthPanel panelNorth;
	private JPCenterPanel panelCenter;
	
	public JPMainPanel(){
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
//		layout.setHgap(0);
//		layout.setVgap(0);
		setLayout(layout);

//		panelNorth = new JPNorthPanel();
//		panelNorth.setPreferredSize(new Dimension(WIDTH,(int)(HEIGHT*0.176)));
//		panelNorth.setBackground(ConstantsGUI.WHITE);
//		add(panelNorth);
		addNorthPanel();
//		panelCenter = new JPCenterPanel();
//		panelCenter.setPreferredSize(new Dimension(WIDTH,(int)(200)));
//		add(panelCenter);
//		addCenterPanel();
	}
	
	public void addNorthPanel() {
		panelNorth = new JPNorthPanel();
		panelNorth.setPreferredSize(new Dimension(WIDTH,(int)(HEIGHT*0.176)));
		panelNorth.setBackground(ConstantsGUI.WHITE);
		add(panelNorth);
		panelCenter = new JPCenterPanel();
		panelCenter.setPreferredSize(new Dimension(WIDTH,(int)(HEIGHT*0.4)));
		add(panelCenter);
	}

	public void addCenterPanel() {
		panelCenter = new JPCenterPanel();
		panelCenter.setPreferredSize(new Dimension(WIDTH,(int)(HEIGHT*0.176)));
		add(panelCenter);
	}
}