package views.header;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import views.ConstantsGUI;


public class JPanelHeader extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Image backGraundImage;
	private JPanelMenu panelMenu;
	private JPanelLanguage panelLanguage;

	public JPanelHeader(ActionListener actionListener) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(60, 20, 60, 20));
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
		
	}
	
	private void initComponents(ActionListener actionListener) {
		setBackGraund();
		panelMenu = new JPanelMenu(actionListener);
		panelLanguage = new JPanelLanguage(actionListener);
		addPanelLogoAndMenu(actionListener);
	}
	
	public void changeLanguage() {
		panelMenu.changeLanguage();
		panelLanguage.changeLanguage();
	}
	
	private void setBackGraund() {
		backGraundImage = new ImageIcon("resources/img/fondoPeces.png").getImage();
	}
	
	public void addPanelLogoAndMenu(ActionListener actionListener) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel.setBackground(new Color(198,227,128,180));
//		panel.setBackground(Color.decode("#a0b56f"));
		panel.add(addLogo());
		panel.add(panelMenu);
		panel.add(panelLanguage);
		this.add(panel,BorderLayout.CENTER);
	}
	
	private JPanel addLogo() {
		JPanel panelMenu = new JPanel();
		panelMenu.setOpaque(false);
		JLabel labelLogo = new JLabel();
		labelLogo.setIcon(ConstantsGUI.convertToIcon("resources/img/logo.png",150,150));
		labelLogo.setOpaque(false);
		panelMenu.add(labelLogo);
		panelMenu.setVisible(true);
		return panelMenu;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(backGraundImage, 0, 0, getWidth(),getHeight(),this);
	}
}
