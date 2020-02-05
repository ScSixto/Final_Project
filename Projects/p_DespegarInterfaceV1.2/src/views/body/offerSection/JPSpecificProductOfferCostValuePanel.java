package views.body.offerSection;

import views.ConstantsGUI;
import views.JLabelFormat;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class JPSpecificProductOfferCostValuePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    public static final Dimension DEFAULT_DIMENSION = new Dimension(235,32);


    public static final Font DEFAULT_COST_VALUE_FONT = new Font("Century Gothic",Font.PLAIN,20);
    public static final Color DEFAULT_COST_VALUE_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY;

    public static final Font DEFAULT_BEFORE_COST_VALUE_FONT = new Font("Century Gothic",Font.PLAIN,14);
    public static final Color DEFAULT_BEFORE_COST_VALUE_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2;
    public static final String DEFAULT_BEFORE_COST_FORMAT = "<html><strike>"+"%s"+"</strike></html>";

    public static final Font DEFAULT_PESOS_CHAR_FONT = new Font("Arial",Font.PLAIN,16);
    public static final Color DEFAULT_PESOS_CHAR_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY;

    public static final DecimalFormat COST_FORMAT = new DecimalFormat("##,###.##");

    public static final char PESOS_CHARACTER = '$';


    public JPSpecificProductOfferCostValuePanel(double cost){
        this.setMinimumSize(DEFAULT_DIMENSION);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setOpaque(false);
        this.initComponents(cost);
    }

    public JPSpecificProductOfferCostValuePanel(double cost, double beforeCost){
        this.setPreferredSize(DEFAULT_DIMENSION);
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.initComponents(cost,beforeCost);
    }

    private void initComponents(double cost){
        this.addCostValue(cost);
    }

    private void addCostValue(double cost){
        JLabelFormat pesosChar = new JLabelFormat(""+PESOS_CHARACTER, DEFAULT_PESOS_CHAR_FONT, DEFAULT_PESOS_CHAR_FOREGROUND);
        pesosChar.setBorder(BorderFactory.createEmptyBorder(4,0,0,0));
        JLabelFormat costValue = new JLabelFormat(COST_FORMAT.format(cost),DEFAULT_COST_VALUE_FONT,DEFAULT_COST_VALUE_FOREGROUND);
        this.add(pesosChar);
        this.add(costValue);
    }

    private void addBeforeCostValue(double beforeCost){
        JLabelFormat beforeCostValue = new JLabelFormat(String.format(DEFAULT_BEFORE_COST_FORMAT,COST_FORMAT.format(beforeCost)),DEFAULT_BEFORE_COST_VALUE_FONT,DEFAULT_BEFORE_COST_VALUE_FOREGROUND);
        beforeCostValue.setBorder(BorderFactory.createEmptyBorder(6,0,0,0));
        this.add(beforeCostValue);
    }

    private void initComponents(double cost, double beforeCost){
        this.addCostValue(cost);
        this.addBeforeCostValue(beforeCost);
    }
}