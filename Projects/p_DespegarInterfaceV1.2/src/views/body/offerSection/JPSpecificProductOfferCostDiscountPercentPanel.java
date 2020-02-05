package views.body.offerSection;

import views.ConstantsGUI;
import views.JLabelFormat;

import javax.swing.*;
import java.awt.*;

public class JPSpecificProductOfferCostDiscountPercentPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
    public static final Color DEFAULT_DISCOUNT_PERCENT_BACKGROUND = ConstantsGUI.COLOR_DESPEGAR_CYAN;
    public static final Color DEFAULT_DISCOUNT_PERCENT_FOREGROUND = ConstantsGUI.COLOR_WHITE;
    public static final Font DEFAULT_DISCOUNT_PERCENT_FONT = new Font("Arial", Font.BOLD,16);

    public static final int DEFAULT_BORDER_ANGLE = 30;
    public static final Dimension DEFAULT_DIMENSION = new Dimension(36,20);

    public JPSpecificProductOfferCostDiscountPercentPanel(double discount){
        this.setLayout(new BorderLayout());
        this.setBackground(DEFAULT_DISCOUNT_PERCENT_BACKGROUND);
        this.setOpaque(false);
        this.setMaximumSize(DEFAULT_DIMENSION);
        this.setMinimumSize(DEFAULT_DIMENSION);

        this.setBorder(BorderFactory.createEmptyBorder(0,10,1,0));
        this.initComponents(discount);
    }

    private void initComponents(double discount){
        JLabelFormat discountText = new JLabelFormat("- "+(int)discount+"%",DEFAULT_DISCOUNT_PERCENT_FONT,DEFAULT_DISCOUNT_PERCENT_FOREGROUND);
        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(this.getBackground());
        emptyPanel.setPreferredSize(new Dimension(20,getHeight()-1));
        this.add(discountText,BorderLayout.WEST);
        this.add(emptyPanel,BorderLayout.EAST);
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
