package views;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class JPMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPHeaderPanel panelHeader;
	private JPBodyPanel panelBody;
    private JPFooterPanel panelFooter;

    public JPMainPanel(ActionListener act){
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setLayout(new BorderLayout());
        this.initComponents(act);
    }

    public void initComponents(ActionListener act){
        this.panelHeader = new JPHeaderPanel(act);
        this.panelBody = new JPBodyPanel(act);
        this.panelFooter = new JPFooterPanel(act);
        this.add(panelHeader,BorderLayout.NORTH);
        this.add(panelBody,BorderLayout.CENTER);
        this.add(panelFooter, BorderLayout.SOUTH);
    }

    public void showRunnerTable(ArrayList<Object[]> runnerDataList) {
    	this.panelBody.showRunnerTable(runnerDataList);
    }

    public void showRunnerDataGetter(){
        panelBody.showRunnerDataGetter();
    }

    public HashMap<RunnerData, Object> getNewRunnerData(){
        return panelBody.getNewRunnerData();
    }


}