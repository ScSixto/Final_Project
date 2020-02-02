package views.body;

import javax.swing.JPanel;

import views.ConstantsGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public class JPYAxisBarGraphic extends JPanel {

    private static final long serialVersionUID = 1L;

    private  Color axisColor;
    private int axisHeight;
    private double maxValue;

    public JPYAxisBarGraphic(ArrayList<Double> values){
        this.setOpaque(false);
        this.axisHeight = ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE;
        this.axisColor = ConstantsGUI.DEFAULT_AXIS_COLOR;
        this.maxValue = UtilView.getMaxValue(values);
        this.setPreferredSize(new Dimension(ConstantsGUI.AXIS_LINE_WIDTH + ConstantsGUI.Y_AXIS_LABEL_WIDTH, axisHeight));
    }
    
    public JPYAxisBarGraphic(ArrayList<Double> values, Color axisColor) {
        this(values);
        this.axisColor = axisColor;
        this.setVisible(true);
    }

    public void paint(final Graphics g) {
        super.paint(g);
        g.setColor(this.axisColor);
        g.fillRect(ConstantsGUI.Y_AXIS_LABEL_WIDTH,0, ConstantsGUI.AXIS_LINE_WIDTH, this.axisHeight);
        g.getFont().deriveFont(ConstantsGUI.DATA_LABEL_FONT.getStyle(), ConstantsGUI.DATA_LABEL_FONT.getSize());
        int y = ConstantsGUI.DATA_LABEL_FONT.getSize();
        for (int i = 0; i < ConstantsGUI.Y_AXIS_VALUE_QUANTITY; i++) {
            g.drawString(UtilView.getRoundedValue(this.maxValue - this.maxValue * i/ConstantsGUI.Y_AXIS_VALUE_QUANTITY), 0, y);
            y += ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE / ConstantsGUI.Y_AXIS_VALUE_QUANTITY;
        }
//        g.drawString(colName,0, (int) ((ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE * MAX_VALUE) - colHeight - this.layout.getVgap()));
    }
}