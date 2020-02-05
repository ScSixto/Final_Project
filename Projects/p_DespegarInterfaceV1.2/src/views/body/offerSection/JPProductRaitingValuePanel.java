package views.body.offerSection;

import views.ConstantsGUI;
import views.JLabelFormat;

import javax.swing.*;
import java.awt.*;

public class JPProductRaitingValuePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    public static final int DEFAULT_BORDER_ANGLE = 10;
    public static final Font DEFAULT_RATING_TEXT_FONT = new Font("Arial",Font.PLAIN,12);
    public static final Color DEFAULT_RATING_TEXT_FOREGROUND = ConstantsGUI.COLOR_WHITE;

    public static final Dimension DEFAULT_RATING_PANEL_DIMENSION = new Dimension(30,15);

    public JPProductRaitingValuePanel(double productRaiting) {
        this.setBackground(ConstantsGUI.COLOR_DESPEGAR_CYAN);
        this.setOpaque(false);
        this.initComponents(productRaiting);
        this.setMaximumSize(DEFAULT_RATING_PANEL_DIMENSION);
    }

    private void initComponents(double productRaiting){
        JLabelFormat rating = new JLabelFormat(""+productRaiting, DEFAULT_RATING_TEXT_FONT, DEFAULT_RATING_TEXT_FOREGROUND);
        this.add(rating);
    }

    protected void paintComponent(Graphics g){
        Dimension arcs = new Dimension(DEFAULT_BORDER_ANGLE,DEFAULT_BORDER_ANGLE); //Border corners arcs {width,height}, change this to whatever you want
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded panel with borders.
        graphics.setColor(this.getBackground());

        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
        super.paintComponent(graphics);
    }
}
