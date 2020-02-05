package views;

import javax.swing.*;

import java.awt.event.ActionListener;

public class JPBodyPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JPCardLayout cardPanel;
	private JPSpringLayout springPanel;

    public JPBodyPanel(ActionListener act){
//        this.setPreferredSize(new Dimension((int)(WIDTH*0.8),HEIGHT));
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        this.initComponents(act);
    }

    private void initComponents(ActionListener act){
        this.cardPanel = new JPCardLayout(act);
        this.add(cardPanel);

        this.add(new JPAnimePanel(act));
    }

    public void showNextCardImage() {
        cardPanel.showNextCardImage();
    }

    public void showPreviousCardImage() {
        cardPanel.showPreviousCardImage();
    }

    public void showCardImage(String key){
        cardPanel.showCardImage(key);
    }

}