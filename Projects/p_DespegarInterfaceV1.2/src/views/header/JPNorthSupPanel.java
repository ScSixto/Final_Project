package views.header;

import views.ConstantsGUI;

import javax.swing.*;
import java.awt.*;

public class JPNorthSupPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static final String DESPEGAR_TEXT = "despegar";
    public static final String DESPEGAR_ICON_PATH = "resources/img/Despegar.png";

    public JPNorthSupPanel(){
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setPreferredSize(new Dimension(WIDTH,48));
        this.setOpaque(true);

        this.setBorder(BorderFactory.createEmptyBorder(0,70,0,0));

        //FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        //layout.setHgap(0);
        BorderLayout layout = new BorderLayout();
        layout.setVgap(5);
        this.setLayout(layout);

        this.initComponents();
    }

    public void initComponents(){
        this.add(new JBNorthSupButton(DESPEGAR_TEXT,DESPEGAR_ICON_PATH,new Dimension(31,32),new Font("Arial",Font.BOLD,25),Color.decode("#550fed")/*ConstantsGUI.COLOR_DESPEGAR_DARK_PURPLE*/),BorderLayout.WEST);
        this.add(new JPNorthSupInformationPanel(),BorderLayout.EAST);
    }
}
