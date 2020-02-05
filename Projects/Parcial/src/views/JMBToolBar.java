package views;

import controllers.ActionCommands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMBToolBar extends JMenuBar{

	private static final long serialVersionUID = 1L;

	public static final Color DEFAULT_BACKGROUND = ConstantsGUI.COLOR_BLUE;

	public static final String  SHOW_EMPLOYEE_LIST_OPTION_ICON_PATH = "resources/img/Files.png";
	public static final String  SHOW_EMPLOYEE_WINNER_LIST_OPTION_ICON_PATH = "resources/img/Files.png";

	public static final String  SHOW_EMPLOYEE_LIST_OPTION_TOOLTIP_TEXT = "Mostrar lista de Empleados";
	public static final String  SHOW_EMPLOYEE_WINNER_LIST_OPTION_TOOLTIP_TEXT = "Mostrar lista de Ganadores";


	public static final Dimension DEFAULT_BUTTON_DIMENSION = new Dimension(50,50);

	public JMBToolBar(ActionListener act){
		this.setBackground(DEFAULT_BACKGROUND);
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.setPreferredSize(new Dimension(WIDTH,60));
		
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		layout.setHgap(20);
		this.setLayout(layout);
		
		this.initComponents(act);
	}
	
	private void initComponents(ActionListener act){
		this.showEmployeeListButton(act);
		this.showEmployeeWinnerListButton(act);
	}

	private void showEmployeeListButton(ActionListener act){
		JButtonFormat showEmployeeList = new JButtonFormat(SHOW_EMPLOYEE_LIST_OPTION_ICON_PATH, DEFAULT_BUTTON_DIMENSION);
		showEmployeeList.setActionCommand(ActionCommands.SHOW_EMPLOYEE_LIST.name());
		showEmployeeList.addActionListener(act);
		showEmployeeList.setToolTipText(SHOW_EMPLOYEE_LIST_OPTION_TOOLTIP_TEXT);
		this.add(showEmployeeList);
	}

	private void showEmployeeWinnerListButton(ActionListener act){
		JButtonFormat showEmployeeWinnerList = new JButtonFormat(SHOW_EMPLOYEE_WINNER_LIST_OPTION_ICON_PATH, DEFAULT_BUTTON_DIMENSION);
		showEmployeeWinnerList.setActionCommand(ActionCommands.SHOW_EMPLOYEE_WINNER_LIST.name());
		showEmployeeWinnerList.addActionListener(act);
		showEmployeeWinnerList.setToolTipText(SHOW_EMPLOYEE_WINNER_LIST_OPTION_TOOLTIP_TEXT);
		this.add(showEmployeeWinnerList);
	}
}