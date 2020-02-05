package views;

import controllers.ActionCommands;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JMBGeneralOptionsMenu extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
	public static final Font  MENU_OPTION_TEXT_FONT = new Font("Arial",Font.PLAIN,12);
	public static final Color  MENU_OPTION_TEXT_FOREGROUND = Color.black;
	
	public static final Font  MENU_ITEM_TEXT_FONT = new Font("Arial",Font.PLAIN,12);
	public static final Color  MENU_ITEM_TEXT_FOREGROUND = Color.black;
	
	public static final String  RUNNER_OPTION_TEXT = "Corredor";
	public static final String  RUNNER_ADD_RUNNER_OPTION_TEXT = "A"+ ConstantsGUI.LOWERCASE_ACCENTED_N +"adir Corredor";
	public static final String  RUNNER_REMOVE_RUNNER_OPTION_TEXT = "Remover Corredor";
	public static final String  RUNNER_MODIFY_RUNNER_OPTION_TEXT = "Modificar Corredor";
	
	public static final String  LIST_OPTION_TEXT = "Lista";
	public static final String  LIST_SHOW_RUNNER_LIST_OPTION_TEXT = "Mostrar lista de Corredores";
	
	public JMBGeneralOptionsMenu(ActionListener act){
		this.setBackground(ConstantsGUI.COLOR_LIGHT_GRAY_3);
		this.setOpaque(true);

		this.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
		this.setBorderPainted(false);
		this.setPreferredSize(new Dimension(WIDTH,30));
		
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		this.setLayout(layout);
		
		this.initComponents(act);
	}
	
	private void initComponents(ActionListener act){
		this.addRunnerMenu(act);
		this.addListMenu(act);
	}
	
	private void addRunnerMenu(ActionListener act) {
		JMenuFormat runnerMenu = new JMenuFormat(RUNNER_OPTION_TEXT, MENU_OPTION_TEXT_FONT, MENU_OPTION_TEXT_FOREGROUND);

		JMIMenuItemFormat addRunnerItem = new JMIMenuItemFormat(RUNNER_ADD_RUNNER_OPTION_TEXT,MENU_ITEM_TEXT_FONT,MENU_ITEM_TEXT_FOREGROUND);
		addRunnerItem.setActionCommand(ActionCommands.ADD_RUNNER.name());
		addRunnerItem.addActionListener(act);
		runnerMenu.add(addRunnerItem);

		JMIMenuItemFormat removeRunnerItem = new JMIMenuItemFormat(RUNNER_REMOVE_RUNNER_OPTION_TEXT,MENU_ITEM_TEXT_FONT,MENU_ITEM_TEXT_FOREGROUND);
		removeRunnerItem.setActionCommand(ActionCommands.REMOVE_RUNNER.name());
		removeRunnerItem.addActionListener(act);
		runnerMenu.add(removeRunnerItem);

		JMIMenuItemFormat modifyRunnerItem = new JMIMenuItemFormat(RUNNER_MODIFY_RUNNER_OPTION_TEXT,MENU_ITEM_TEXT_FONT,MENU_ITEM_TEXT_FOREGROUND);
		modifyRunnerItem.setActionCommand(ActionCommands.MODIFY_RUNNER.name());
		modifyRunnerItem.addActionListener(act);
		runnerMenu.add(modifyRunnerItem);
		this.add(runnerMenu);
	}
	
	private void addListMenu(ActionListener act) {
		JMenuFormat listMenu = new JMenuFormat(LIST_OPTION_TEXT, MENU_OPTION_TEXT_FONT, MENU_OPTION_TEXT_FOREGROUND);

		JMIMenuItemFormat addRunnerItem = new JMIMenuItemFormat(LIST_SHOW_RUNNER_LIST_OPTION_TEXT,MENU_ITEM_TEXT_FONT,MENU_ITEM_TEXT_FOREGROUND);
		addRunnerItem.setActionCommand(ActionCommands.SHOW_RUNNER_LIST.name());
		addRunnerItem.addActionListener(act);
		listMenu.add(addRunnerItem);

		this.add(listMenu);
	}
}