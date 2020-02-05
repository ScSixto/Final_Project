package views.body.offerSection;

import views.ConstantsGUI;
import views.JLabelFormat;

import javax.swing.*;
import java.awt.*;

public class JPSpecificProductOfferCostFormat extends JPanel{

	private static final long serialVersionUID = 1L;
	
    public static final Dimension DEFAULT_DIMENSION = new Dimension(295,75);

    public static final Font DEFAULT_TITLE_COST_FONT = new Font("Arial",Font.PLAIN,12);
    public static final Color DEFAULT_TITLE_COST_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY;

    public static final int INVALID_CODE = -1;

    public JPSpecificProductOfferCostFormat(String titleCost, double cost){
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));
        this.setLayout(new BorderLayout());
        this.initComponents(titleCost, cost);
        this.setPreferredSize(DEFAULT_DIMENSION);
        this.setMaximumSize(DEFAULT_DIMENSION);
    }

    public JPSpecificProductOfferCostFormat(String titleCost, double cost, double beforeCost, double discountPercent){
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(16,16,16,0));
        this.setLayout(new BorderLayout());
        this.initComponents(titleCost, cost, beforeCost, discountPercent);
        this.setMaximumSize(DEFAULT_DIMENSION);
    }

    private void initComponents(String titleCost, double cost){
        this.addTitleCost(titleCost);
        this.addCostValuePanel(cost,INVALID_CODE);
    }

    private void initComponents(String titleCost, double cost, double beforeCost, double discountPercent){
        this.addTitleCost(titleCost);
        this.addCostValuePanel(cost, beforeCost);
        this.addDiscountPercentPanel(discountPercent);
    }

    private void addTitleCost(String titleCost){
        JLabelFormat titleCostLabel = new JLabelFormat(titleCost,DEFAULT_TITLE_COST_FONT,DEFAULT_TITLE_COST_FOREGROUND);
        this.add(titleCostLabel,BorderLayout.NORTH);
    }

    private void addCostValuePanel(double cost, double beforeCost){
        this.add((beforeCost != INVALID_CODE)?new JPSpecificProductOfferCostValuePanel(cost,beforeCost):new JPSpecificProductOfferCostValuePanel(cost),BorderLayout.WEST);
    }

    private void addDiscountPercentPanel(double discountPercent){
        this.add(new JPSpecificProductOfferCostDiscountPercentPanel(discountPercent),BorderLayout.EAST);
    }
}