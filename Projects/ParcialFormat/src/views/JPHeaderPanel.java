package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPHeaderPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JMBGeneralOptionsMenu generalMenu;
    private JMBToolBar toolBar;

    public JPHeaderPanel(ActionListener act){
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.setLayout(new BorderLayout());
        this.initComponents(act);
    }

    private void initComponents(ActionListener act){
        this.generalMenu = new JMBGeneralOptionsMenu(act);
        this.add(generalMenu,BorderLayout.NORTH);
        this.toolBar = new JMBToolBar(act);
        this.add(toolBar,BorderLayout.SOUTH);
    }
}