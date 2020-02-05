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
	
	public static final String  ALGO_OPTION_TEXT = "Corredor";
	public static final String  ALGO_ADD_ALGO_OPTION_TEXT = "A"+ ConstantsGUI.LOWERCASE_ACCENTED_N +"adir Corredor";
	public static final String  ALGO_REMOVE_ALGO_OPTION_TEXT = "Remover Corredor";
	public static final String  ALGO_MODIFY_ALGO_OPTION_TEXT = "Modificar Corredor";
	
	public static final String  LIST_OPTION_TEXT = "Listas";
	public static final String  LIST_SHOW_ALGO_LIST_OPTION_TEXT = "Mostrar lista de Corredores";
	public static final String  LIST_SHOW_ALGO_WINNER_LIST_OPTION_TEXT = "Mostrar lista de Ganadores";


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
		this.addListMenu(act);
	}
	
	private void addListMenu(ActionListener act) {
		JMenuFormat listMenu = new JMenuFormat(LIST_OPTION_TEXT, MENU_OPTION_TEXT_FONT, MENU_OPTION_TEXT_FOREGROUND);

		JMIMenuItemFormat showRunnerListItem = new JMIMenuItemFormat(LIST_SHOW_ALGO_LIST_OPTION_TEXT,MENU_ITEM_TEXT_FONT,MENU_ITEM_TEXT_FOREGROUND);
		showRunnerListItem.setActionCommand(ActionCommands.SHOW_ALGO_LIST.name());
		showRunnerListItem.addActionListener(act);
		listMenu.add(showRunnerListItem);

		JMIMenuItemFormat showWinnerListItem = new JMIMenuItemFormat(LIST_SHOW_ALGO_WINNER_LIST_OPTION_TEXT,MENU_ITEM_TEXT_FONT,MENU_ITEM_TEXT_FOREGROUND);
		showWinnerListItem.setActionCommand(ActionCommands.SHOW_ALGO_WINNER_LIST.name());
		showWinnerListItem.addActionListener(act);
		listMenu.add(showWinnerListItem);

		this.add(listMenu);
	}
}