package views.body;

import views.ConstantsGUI;
import views.JBRoundButton;

import javax.swing.*;
import java.awt.*;

public class JPInstallmentsTripSection extends JPanel{

	private static final long serialVersionUID = 1L;
	
    public JPInstallmentsTripSection(){
        this.setBackground(ConstantsGUI.COLOR_DESPEGAR_ULTRA_LIGHT_GRAY);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(0);
        this.setLayout(flowLayout);
        this.setPreferredSize(new Dimension(WIDTH, (int) JPInstallmentsTripContainer.DEFAULT_DIMENSION.getHeight() + 35));
        this.setBorder(BorderFactory.createEmptyBorder(35, 70, 0, 70));
        this.add(new JBRoundButton(new JPInstallmentsTripContainer(),JPInstallmentsTripContainer.DEFAULT_ANGLE_BORDER,ConstantsGUI.COLOR_WHITE,JPInstallmentsTripContainer.DEFAULT_BORDER_COLOR));
    }
}
