package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    public JPMainPanel(ActionListener act){
//        this.addScrolling();
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setLayout(new BorderLayout());
        this.initComponents(act);
    }

    public void initComponents(ActionListener act){
    	this.add(new JPTablePanel());
//        this.addNorthPanel(act);
//        this.addCenterPanel();
//        this.addSouthPanel();
    }

//    public void addNorthPanel(ActionListener act){
//        this.add(new JPNorthPanel(act),BorderLayout.NORTH);
//    }
//
//    public void addCenterPanel(){
//        this.add(new JPCenterPanel(),BorderLayout.CENTER);
//    }
//
//    public void addSouthPanel(){
//        this.add(new JPSouthPanel(),BorderLayout.SOUTH);
//    }

//    public void addScrolling(){
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setBounds(50, 30, 300, 50);
//        this.add(new Scrollbar(Scrollbar.VERTICAL));
//    }
}