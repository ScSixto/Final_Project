package views;

import javax.swing.*;
import java.awt.*;

public class JPRoundPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Color borderColor;
    private int angleBorder;

    public JPRoundPanel(JLabelFormat text, int angleBorder, Color borderColor){
        this.setOpaque(false);
        this.borderColor = borderColor;
        this.angleBorder = angleBorder;
        this.add(text);
    }

    protected void paintComponent(Graphics g) {
        Dimension arcs = new Dimension(angleBorder, angleBorder); //Border corners arcs {width,height}, change this to whatever you want
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded panel with borders.
        graphics.setColor(this.borderColor);//ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY);
        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
        super.paintComponent(graphics);
    }
}
