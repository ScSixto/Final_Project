package views.header;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;


public class JPanelMenu extends JPanel{

	private static final long serialVersionUID = 1L;
	public static final String SEPARATOR = " |";
	
	private JMenuBar menu;
	private JMenu cultive,export,reports;
	private JMenuItem add,delete,edit,invalidRunners,homePage,tables,graphics;
	
	public JPanelMenu(ActionListener actionListenner) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		setOpaque(false);
		menu = new JMenuBar();
		menu.setOpaque(false);
		menu.setBorderPainted(false);
		initComponents(actionListenner);
		add(menu);
		getComponents();
	}
	
	private void initComponents(ActionListener actionListenner) {
		addHomePageOptions(actionListenner);
		addCultiveOptions(actionListenner);
		addExportOptions(actionListenner);
		addTableOptions(actionListenner);
		
	}
	
//	private void addLogo() {
//		JPanel panelsito = new JPanel();
//		panelsito.setOpaque(false);
//		JLabel labelLogo = new JLabel();
//		labelLogo.setIcon(ConstantsGUI.convertToIcon("resources/img/logo.png",170,170));
//		labelLogo.setOpaque(false);
//		panelsito.add(labelLogo);
//		panelsito.setVisible(true);
//	}
	
	private void addCultiveOptions(ActionListener actionListenner) {
		cultive = createJMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CULTIVE));
		add = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_ADD));
//		add.addActionListener(actionListenner);
//		add.setActionCommand(Actions.ADD.toString());
		cultive.add(add);
		delete = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_DELETE));
//		delete.addActionListener(actionListenner);
//		delete.setActionCommand(Actions.DELETE.toString());
		cultive.add(delete);
		edit = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EDIT));
//		edit.addActionListener(actionListenner);
//		edit.setActionCommand(Actions.EDIT.toString());
		cultive.add(edit);
		menu.add(cultive);
	}
	
	
	private void addExportOptions(ActionListener actionListenner) {
		export = createJMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXPORT));
		invalidRunners = createJMenuItem("Corredores no validos");
//		invalidRunners.addActionListener(actionListenner);
//		invalidRunners.setActionCommand(Actions.EXPORT.toString());
		export.add(invalidRunners);
		menu.add(export);
	}
	
	private void addHomePageOptions(ActionListener actionListenner) {
		homePage = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_HOMEPAGE) + SEPARATOR);
		homePage.addActionListener(actionListenner);
		homePage.setActionCommand(Commands.PANEL_INITIAL.toString());
		homePage.setForeground(Color.WHITE);
		menu.add(homePage);
	}
	
	private void addTableOptions(ActionListener actionListenner) {
		reports = createJMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_REPORTS));
		tables = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TABLES));
		tables.addActionListener(actionListenner);
		tables.setActionCommand(Commands.TABLE_REPORTS.toString());
		reports.add(tables);
		graphics = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_GRAPHICS));
		graphics.addActionListener(actionListenner);
		graphics.setActionCommand(Commands.GRAPHIC_REPORTS.toString());
		reports.add(graphics);
		menu.add(reports);
	}
	
	public void changeLanguage() {
		cultive.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CULTIVE) + SEPARATOR);
		add.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_ADD));
		delete.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_DELETE));
		edit.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EDIT));
		export.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXPORT) + SEPARATOR);
		homePage.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_HOMEPAGE) + SEPARATOR);
		reports.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_REPORTS)+ SEPARATOR);
		tables.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TABLES));
	}
	
	private JMenu createJMenu(String text) {
		JMenu menuOptions = new JMenu(text + " |");
		menuOptions.setForeground(Color.WHITE);
		menuOptions.setOpaque(false);
		createFont(menuOptions);
		return menuOptions;
	}
	
	private JMenuItem createJMenuItem(String text) {
		JMenuItem item = new JMenuItem(text);
		item.setOpaque(false);
		createFont(item);
		return item;
	}
	
	private void createFont(Component component) {
		component.setFont((new Font("Roboto", Font.BOLD,20)));
	}
	
	

}
