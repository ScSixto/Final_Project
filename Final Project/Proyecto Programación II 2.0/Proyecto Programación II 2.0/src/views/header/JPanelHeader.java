package views.header;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class JPanelHeader extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPanelMenu panelMenu;
	private JPanelMenuIcons panelMenuIcons;

	public JPanelHeader(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		panelMenu = new JPanelMenu(actionListener);
		add(panelMenu,BorderLayout.NORTH);
		panelMenuIcons = new JPanelMenuIcons(actionListener);
		add(panelMenuIcons,BorderLayout.SOUTH);
	}
	
	public void changeLanguage() {
		panelMenu.changeLanguage();
		panelMenuIcons.changeLanguage();
	}
}
