package views.body;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import views.ConstantsGUI;

public class JPColumnPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final double MAX_VALUE = 100;

    private String colName;
    private double percentValue;
    private Color barColor;

    public JPColumnPanel(String colName, double percentValue, Color barColor){
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(ConstantsGUI.MAX_PIXEL_COL_WIDTH_VALUE,ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE));
        this.initComponents(colName, percentValue, barColor);
        this.setVisible(true);
    }

	private void initComponents(String colName, double percentValue, Color barColor){
        this.colName = colName;
        this.percentValue = percentValue;
        this.barColor = barColor;
    }

    public void paint(final Graphics g){
        int colHeight = (int)(this.percentValue * ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE / MAX_VALUE);
        g.setColor(this.barColor);
        g.fillRect(0,(int) (ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE - colHeight), ConstantsGUI.MAX_PIXEL_COL_WIDTH_VALUE, colHeight);
        g.setColor(Color.black);
        g.drawString(this.colName,ConstantsGUI.COL_SEPARATION + 1, (int) (ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE - colHeight) + ConstantsGUI.DATA_LABEL_FONT.getSize() + 1);
        super.paint(g);
    }
}