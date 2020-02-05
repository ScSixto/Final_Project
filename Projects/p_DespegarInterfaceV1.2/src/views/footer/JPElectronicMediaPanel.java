package views.footer;

import views.ConstantsGUI;
import views.JBRoundButton;

import javax.swing.*;
import java.awt.*;

public class JPElectronicMediaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static final int DEFAULT_ANGLE_BORDER = 20;

    public JPElectronicMediaPanel(){
        this.setBackground(ConstantsGUI.COLOR_DESPEGAR_ULTRA_LIGHT_GRAY);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        flowLayout.setHgap(30);
        this.setLayout(flowLayout);
        this.setPreferredSize(new Dimension(WIDTH, 350));
        this.setBorder(BorderFactory.createEmptyBorder(35, 30, 0, 30));
        this.add(new JBRoundButton(new JPDownloadAppPanel(),DEFAULT_ANGLE_BORDER,ConstantsGUI.COLOR_WHITE,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_4));
        this.add(new JBRoundButton(new JPSuscribePanel(),DEFAULT_ANGLE_BORDER,ConstantsGUI.COLOR_DESPEGAR_BLUE,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_4));

    }
}