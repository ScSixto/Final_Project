package views.header;

import views.ConstantsGUI;
import views.JBRoundButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPNorthInfPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    public static final String WHERE_GOING_TEXT = ConstantsGUI.OPEN_QUESTION_CHARACTER + "A d"+ ConstantsGUI.LOWERCASE_ACCENTED_O +"nde vamos?";
    public static final String WHERE_GOING_ICON_PATH = "resources/img/DescubreYViaja.png";

    public JPNorthInfPanel(ActionListener act){
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.setOpaque(false);

        this.setLayout(new BorderLayout());
        this.initComponents(act);
    }

    public void initComponents(ActionListener act){
        this.add(new JMBNorthButtonBar(act),BorderLayout.WEST);
        this.addWhereGoingButton();
    }

    public void addWhereGoingButton(){
        JPanel whereGoingPanel = new JPanel();
        whereGoingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        whereGoingPanel.setBorder(BorderFactory.createEmptyBorder(28,0,0,0));
        whereGoingPanel.setOpaque(false);
        whereGoingPanel.add(new JBRoundButton(WHERE_GOING_TEXT,WHERE_GOING_ICON_PATH,new Dimension(24,24),new Font("Arial",Font.BOLD,14), ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY,SwingConstants.RIGHT,SwingConstants.CENTER,ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY));
        this.add(whereGoingPanel);
    }
}