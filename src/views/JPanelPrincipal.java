package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import views.body.JPanelBody;
import views.header.JPanelHeader;

public class JPanelPrincipal extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPanelHeader panelHeader;
	private JPanelBody panelBody;
	
	
	public JPanelPrincipal(ActionListener actionListenner) {
		setBackground(Color.decode(ConstantsGUI.COLOR_BACKGRAUND));
		setLayout(new BorderLayout());
		initComponents(actionListenner);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListenner) {
		panelHeader = new JPanelHeader(actionListenner);
		add(panelHeader,BorderLayout.NORTH);
		panelBody = new JPanelBody();
		add(panelBody,BorderLayout.CENTER);
		
	}
	
	public void changeLanguage() {
		panelHeader.changeLanguage();
		panelBody.changeLanguage();
	}
	
	public void showCardImage(String key){
		panelBody.showCardImage(key);
	}
	
	public void showTableCultives(HashMap<String, ArrayList<Object[]>> info) {
		panelBody.showTableCultives(info);
	}

	public void showGrafica(HashMap<String, Double> earningsPerTown) {
		panelBody.addGraphicPanel(earningsPerTown);
	}
	
}
