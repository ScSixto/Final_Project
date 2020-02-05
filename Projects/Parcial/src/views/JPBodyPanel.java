package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPBodyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JPTablePanel tablePanel;


    public JPBodyPanel(ActionListener act){
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setLayout(new BorderLayout());

        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.initComponents(act);
    }

    private void initComponents(ActionListener act){
        this.tablePanel = new JPTablePanel();
        this.add(tablePanel);
    }

    public void showTable(ArrayList<Object[]> dataList, TableHeader tableHeader){
        this.tablePanel.setJTableComponents(tableHeader);
        this.tablePanel.addRowList(dataList);
    }
}