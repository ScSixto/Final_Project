package views.body;

import views.ConstantsGUI;
import views.body.packageSection.JPCenterPackagePanel;

import javax.swing.*;
import java.awt.*;

public class JPCenterSelectionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    public JPCenterSelectionPanel(){
        this.setPreferredSize(new Dimension(WIDTH,231));
        this.setBackground(ConstantsGUI.COLOR_DESPEGAR_LIGHT_PURPLE);
        this.setOpaque(true);

        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        layout.setVgap(17);
        this.setLayout(layout);
        this.initComponents();
    }

    public void initComponents(){
        this.addPackagePanel();
    }

    public void addPackagePanel(){
        this.add(new JPCenterPackagePanel());
    }
}
