package views.body;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;

public class JPanelPresentation extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel labelMessage;
	
	public JPanelPresentation() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setOpaque(false);
		labelMessage = new JLabel("<html> <b>" + HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_PRESENTATION) + "</b></html>");
		labelMessage.setFont(new Font("Calibri", Font.ITALIC, 200));
		labelMessage.setForeground(Color.decode(ConstantsGUI.COLOR_PRESENTATION));
		add(labelMessage);
		setVisible(true);
	}
	
	public void changeLanguage() {
		labelMessage.setText("<html> <b>" + HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_PRESENTATION) + "</b></html>");
	}
	

}
