package views;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPHeaderPanel panelHeader;
	private JPBodyPanel panelBody;

    public JPMainPanel(ActionListener act){
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setLayout(new BorderLayout());
        this.initComponents(act);
    }

    public void initComponents(ActionListener act){
        this.panelHeader = new JPHeaderPanel(act);
        this.panelBody = new JPBodyPanel(act);
        this.add(panelHeader,BorderLayout.NORTH);
        this.add(panelBody,BorderLayout.CENTER);
    }

    public void showAlgoTable(ArrayList<Object[]> algoDataList, TableHeader tableHeader) {
    	this.panelBody.showTable(algoDataList, tableHeader);
    }
}