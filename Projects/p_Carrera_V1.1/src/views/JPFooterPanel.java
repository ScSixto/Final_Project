package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPFooterPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPFooterPanel(ActionListener act){
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setBorder(BorderFactory.createEmptyBorder(5,0,20,0));
        this.setLayout(new BorderLayout());
        this.initComponents(act);
    }

    private void initComponents(ActionListener act){

    }
}
