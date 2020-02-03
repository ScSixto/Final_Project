package views.title;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import views.ConstantsGUI;
import views.buttons.JButtonsMenuAndDialogs;

public class JPanelHeaderShowReports extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButtonsMenuAndDialogs buttonBack;
	
	public JPanelHeaderShowReports() {
		setLayout(new BorderLayout());
		setBackground(ConstantsGUI.COLOR_LINE);
		setOpaque(false);
		initComponents();
		setVisible(true);
	}
	
	private void initComponents() {
		
	}
	
	public void addButton() {
		buttonBack = new JButtonsMenuAndDialogs("resources/img/flecha.png",50,30);
		add(buttonBack,BorderLayout.WEST);
	}

}
