package views.header;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controllers.Commands;
import general.HandlerLanguage;
import views.ConstantsGUI;


public class JPanelMenu extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JMenuBar menu;
	private JMenu cultive,language,export,options,table;
	private JMenuItem add,delete,edit,spanishItem,englishItem,invalidRunners,leave,tableCultives;
	
	public JPanelMenu(ActionListener actionListenner) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(Color.WHITE);
		menu = new JMenuBar();
		menu.setOpaque(false);
		menu.setBorderPainted(false);
		initComponents(actionListenner);
		add(menu);
		getComponents();
	}
	
	private void initComponents(ActionListener actionListenner) {
		addCultiveOptions(actionListenner);
		addLanguageOptions(actionListenner);
		addExportOptions(actionListenner);
		addTableOptions(actionListenner);
		addLeaveOptions(actionListenner);
		
	}
	
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
	
	private void addLanguageOptions(ActionListener actionListenner) {
		language = createJMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_LANGUAGE));
		spanishItem = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.LANGUAGE_SPANISH));
		spanishItem.addActionListener(actionListenner);
		spanishItem.setActionCommand(Commands.CHANGE_SPANISH.toString());
		language.add(spanishItem);
		englishItem = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.LANGUAGE_ENGLISH));
		englishItem.addActionListener(actionListenner);
		englishItem.setActionCommand(Commands.CHANGE_ENGLISH.toString());
		language.add(englishItem);
		menu.add(language);
	}
	
	private void addExportOptions(ActionListener actionListenner) {
		export = createJMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXPORT));
		invalidRunners = createJMenuItem("Corredores no validos");
//		invalidRunners.addActionListener(actionListenner);
//		invalidRunners.setActionCommand(Actions.EXPORT.toString());
		export.add(invalidRunners);
		menu.add(export);
	}
	
	private void addLeaveOptions(ActionListener actionListenner) {
		options = createJMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_OPTIONS));
		leave = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXIT));
		leave.addActionListener(actionListenner);
		leave.setActionCommand(Commands.EXIT.toString());
		options.add(leave);
		menu.add(options);
	}
	
	private void addTableOptions(ActionListener actionListenner) {
		table = createJMenu(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TABLES));
		tableCultives = createJMenuItem(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TABLE_CULTIVES));
		tableCultives.addActionListener(actionListenner);
		tableCultives.setActionCommand(Commands.TABLE_CULTIVES.toString());
		table.add(tableCultives);
		menu.add(table);
	}
	
	public void changeLanguage() {
		cultive.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_CULTIVE));
		add.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_ADD));
		delete.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_DELETE));
		edit.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EDIT));
		language.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_LANGUAGE));
		spanishItem.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.LANGUAGE_SPANISH));
		englishItem.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.LANGUAGE_ENGLISH));
		export.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXPORT));
		options.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_OPTIONS));
		leave.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_EXIT));
		table.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TABLES));
		tableCultives.setText(HandlerLanguage.languageProperties.getProperty(ConstantsGUI.T_TABLE_CULTIVES));
	}
	
	private JMenu createJMenu(String text) {
		JMenu menuOptions = new JMenu(text);
		createFont(menuOptions);
		return menuOptions;
	}
	
	private JMenuItem createJMenuItem(String text) {
		JMenuItem item = new JMenuItem(text);
		createFont(item);
		return item;
	}
	
	private void createFont(Component component) {
		component.setFont((new Font("Calibri", Font.BOLD,17)));
	}
	
	

}
