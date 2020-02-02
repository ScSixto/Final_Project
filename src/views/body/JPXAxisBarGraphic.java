package views.body;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import views.ConstantsGUI;

public class JPXAxisBarGraphic extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private  Color axisColor;
    private int axisWidth;

    public JPXAxisBarGraphic(int colsQuantity){
        this.setOpaque(false);
        this.axisWidth = colsQuantity * ConstantsGUI.MAX_PIXEL_COL_WIDTH_VALUE + ((colsQuantity+1) * ConstantsGUI.COL_SEPARATION);
        this.axisColor = ConstantsGUI.DEFAULT_AXIS_COLOR;
    }

    public JPXAxisBarGraphic(int colsQuantity, Color axisColor) {
        this(colsQuantity);
        this.axisColor = axisColor;
        this.setVisible(true);
    }

    public void paint(final Graphics g) {
        super.paint(g);
        g.setColor(this.axisColor);
        g.fillRect(ConstantsGUI.Y_AXIS_LABEL_WIDTH,0, this.axisWidth, ConstantsGUI.AXIS_LINE_WIDTH);
//        g.drawString(colName,0, (int) ((ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE * MAX_VALUE) - colHeight - this.layout.getVgap()));
    }
}