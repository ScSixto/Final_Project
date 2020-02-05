package views;

import controllers.ActionCommands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JMBToolBar extends JMenuBar{

	private static final long serialVersionUID = 1L;

	public static final Color DEFAULT_BACKGROUND = ConstantsGUI.COLOR_BLUE;

	public static final String  ADD_RUNNER_OPTION_ICON_PATH = "resources/img/AddFile.png";
	public static final String  REMOVE_RUNNER_OPTION_ICON_PATH = "resources/img/DeleteFile.png";
	public static final String  MODIFY_RUNNER_OPTION_ICON_PATH = "resources/img/EditFile.png";
	public static final String  SHOW_RUNNER_LIST_OPTION_ICON_PATH = "resources/img/Files.png";

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
		this.addRunnerButton(act);
		this.removeRunnerButton(act);
		this.modifyRunnerButton(act);
		this.showRunnerListButton(act);
	}

	private void addRunnerButton(ActionListener act){
		JButtonFormat addRunner = new JButtonFormat(ADD_RUNNER_OPTION_ICON_PATH, DEFAULT_BUTTON_DIMENSION);
		addRunner.setActionCommand(ActionCommands.ADD_RUNNER.name());
		addRunner.addActionListener(act);
		this.add(addRunner);
	}
	private void removeRunnerButton(ActionListener act){
		JButtonFormat removeRunner = new JButtonFormat(REMOVE_RUNNER_OPTION_ICON_PATH, DEFAULT_BUTTON_DIMENSION);
		removeRunner.setActionCommand(ActionCommands.REMOVE_RUNNER.name());
		removeRunner.addActionListener(act);
		this.add(removeRunner);
	}
	private void modifyRunnerButton(ActionListener act){
		JButtonFormat modifyRunner = new JButtonFormat(MODIFY_RUNNER_OPTION_ICON_PATH, DEFAULT_BUTTON_DIMENSION);
		modifyRunner.setActionCommand(ActionCommands.MODIFY_RUNNER.name());
		modifyRunner.addActionListener(act);
		this.add(modifyRunner);
	}
	private void showRunnerListButton(ActionListener act){
		JButtonFormat showRunnerList = new JButtonFormat(SHOW_RUNNER_LIST_OPTION_ICON_PATH, DEFAULT_BUTTON_DIMENSION);
		showRunnerList.setActionCommand(ActionCommands.SHOW_RUNNER_LIST.name());
		showRunnerList.addActionListener(act);
		this.add(showRunnerList);
	}

}