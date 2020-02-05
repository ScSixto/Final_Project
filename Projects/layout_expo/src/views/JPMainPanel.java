package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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


    public void showNextCardImage(){
        panelBody.showNextCardImage();
    }

    public void showPreviousCardImage(){
        panelBody.showPreviousCardImage();
    }

    public void showCardImage(String key){
        panelBody.showCardImage(key);
    }
}