package views.body;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import general.HandlerLanguage;
import views.ConstantsGUI;
import views.buttons.JButtonOptionsReports;

public class JPanelButtonsTablesReport extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButtonOptionsReports cultivesPerTown,cultivesPerYear,cultivesPerSpecie;
	
	public JPanelButtonsTablesReport(ActionListener actionListener) {
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		layout.setHgap(30);
		setLayout(layout);
		setOpaque(false);
		initComponents(actionListener);
		setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		addButtons(actionListener);
	}
	
	public void addButtons(ActionListener actionListener) {
		cultivesPerTown = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_EIGHT),'T');
		this.add(cultivesPerTown);
		cultivesPerYear = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_NINE),'T');
		this.add(cultivesPerYear);
		cultivesPerSpecie = new JButtonOptionsReports(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TEN),'T');
		this.add(cultivesPerSpecie);
	}
	
	public void changeLanguage() {
		cultivesPerTown.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_EIGHT));
		cultivesPerYear.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_NINE));
		cultivesPerSpecie.setNewText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TEXT_REPORT_GRAPHICS_TEN));
	}

}
