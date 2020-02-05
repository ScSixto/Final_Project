package views.footer;

import views.ConstantsGUI;

import javax.swing.*;

public class JPSouthPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    public JPSouthPanel(){
        this.setBackground(ConstantsGUI.COLOR_DESPEGAR_ULTRA_LIGHT_GRAY);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.initComponents();
    }

    private void initComponents() {
        //this.add(new JPTravelerExperiencePanel());
        this.add(new JPElectronicMediaPanel());
       // this.add(new JPEmailPanel());
    }
}
