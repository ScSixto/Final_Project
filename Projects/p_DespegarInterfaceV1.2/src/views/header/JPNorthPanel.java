package views.header;

import views.ConstantsGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPNorthPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
    public JPNorthPanel(ActionListener act){
        this.setPreferredSize(new Dimension(WIDTH,123));
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        //this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());


        this.initComponents(act);
    }

    public void initComponents(ActionListener act){
        this.add(new JPNorthSupPanel(),BorderLayout.NORTH);
        this.add(new JPNorthInfPanel(act),BorderLayout.SOUTH);
    }
}