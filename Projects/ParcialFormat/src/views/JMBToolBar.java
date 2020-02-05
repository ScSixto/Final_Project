package views;

import controllers.ActionCommands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMBToolBar extends JMenuBar{

	private static final long serialVersionUID = 1L;

	public static final Color DEFAULT_BACKGROUND = ConstantsGUI.COLOR_BLUE;

	public static final String  SHOW_ALGO_LIST_OPTION_ICON_PATH = "resources/img/Files.png";
	public static final String  SHOW_ALGO_WINNER_LIST_OPTION_ICON_PATH = "resources/img/Files.png";

	public static final String  SHOW_ALGO_LIST_OPTION_TOOLTIP_TEXT = "Mostrar lista de Corredores";
	public static final String  SHOW_ALGO_WINNER_LIST_OPTION_TOOLTIP_TEXT = "Mostrar lista de Ganadores";


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
		this.showAlgoListButton(act);
		this.showAlgoWinnerListButton(act);
	}

	private void showAlgoListButton(ActionListener act){
		JButtonFormat showAlgoList = new JButtonFormat(SHOW_ALGO_LIST_OPTION_ICON_PATH, DEFAULT_BUTTON_DIMENSION);
		showAlgoList.setActionCommand(ActionCommands.SHOW_ALGO_LIST.name());
		showAlgoList.addActionListener(act);
		showAlgoList.setToolTipText(SHOW_ALGO_LIST_OPTION_TOOLTIP_TEXT);
		this.add(showAlgoList);
	}

	private void showAlgoWinnerListButton(ActionListener act){
		JButtonFormat showAlgoWinnerList = new JButtonFormat(SHOW_ALGO_WINNER_LIST_OPTION_ICON_PATH, DEFAULT_BUTTON_DIMENSION);
		showAlgoWinnerList.setActionCommand(ActionCommands.SHOW_ALGO_WINNER_LIST.name());
		showAlgoWinnerList.addActionListener(act);
		showAlgoWinnerList.setToolTipText(SHOW_ALGO_WINNER_LIST_OPTION_TOOLTIP_TEXT);
		this.add(showAlgoWinnerList);
	}
}