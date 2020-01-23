package views;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import general.HandlerLanguage;
import views.dialogs.JDialogLanguage;

public class JFramePrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanelPrincipal panelPpal;
	private JDialogLanguage dialogLanguage;
	
	public JFramePrincipal(ActionListener actionListener) {
		setMinimumSize(new Dimension(700, 400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon("resources/img/logo.png").getImage());
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.TITLE_PROGRAM));
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		panelPpal = new JPanelPrincipal(actionListener);
		this.add(panelPpal);
		dialogLanguage = new JDialogLanguage(this,actionListener);
	}
	
	public void changeLanguage() {
		setTitle(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.TITLE_PROGRAM));
		panelPpal.changeLanguage();
		dialogLanguage.changeLanguage();
	}
	
	public void openDialogLanguage() {
		dialogLanguage.setVisible(true);
	}
	
	public void showCardImage(String key){
		panelPpal.showCardImage(key);
	}
	
	public int showMessageConfirmationEndProgram() {
		return JOptionPaneMessages.showMessageConfirmationEndProgram();
	}
	
	public void showMessageEndProgram() {
		JOptionPaneMessages.showMessageEndProgram();
	}
	
	public int jOptionPaneYesOption() {
		return JOptionPaneMessages.jOptionPaneYesOption();
	}
	
	public void showTableCultives(HashMap<String, ArrayList<Object[]>> info) {
		panelPpal.showTableCultives(info);
	}

}
