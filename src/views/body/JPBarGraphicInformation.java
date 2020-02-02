package views.body;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JPanel;

import views.ConstantsGUI;

public class JPBarGraphicInformation extends JPanel{

    private static final long serialVersionUID = 1L;

    private HashMap<String, Color> columnInformation;

    public JPBarGraphicInformation(HashMap<String, Color> columnInformation){
        this.setOpaque(false);
        this.columnInformation = columnInformation;
    }

    public void paint(final Graphics g){
        Iterator<Entry<String, Color>> it = this.columnInformation.entrySet().iterator();
        int y = 0;
        while(it.hasNext()){
            Entry<String, Color> entry = it.next();
            g.setColor(entry.getValue());
            g.fillRoundRect(0, y, ConstantsGUI.INFORMATION_CIRCLE_DIAMETER, ConstantsGUI.INFORMATION_CIRCLE_DIAMETER, ConstantsGUI.INFORMATION_CIRCLE_ANGLE, ConstantsGUI.INFORMATION_CIRCLE_ANGLE);
            g.setColor(ConstantsGUI.COLOR_BLACK);
            g.drawRoundRect(0, y, ConstantsGUI.INFORMATION_CIRCLE_DIAMETER, ConstantsGUI.INFORMATION_CIRCLE_DIAMETER, ConstantsGUI.INFORMATION_CIRCLE_ANGLE, ConstantsGUI.INFORMATION_CIRCLE_ANGLE);
            y += ConstantsGUI.INFORMATION_CIRCLE_DIAMETER + 10;
        }
        super.paint(g);
    }
}