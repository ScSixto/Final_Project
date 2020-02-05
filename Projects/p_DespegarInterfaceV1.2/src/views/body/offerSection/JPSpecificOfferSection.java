package views.body.offerSection;

import views.ConstantsGUI;
import views.JBRoundButton;

import javax.swing.*;
import java.awt.*;

public abstract class JPSpecificOfferSection extends JPanel{

	private static final long serialVersionUID = 1L;
	
    public static final Font TITLE_FONT = new Font("Arial", Font.BOLD,12);
    public static final Color TITLE_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY;

    public static final Font SUBTITLE_FONT_BOLD = new Font("Arial", Font.BOLD,32);
    public static final Font SUBTITLE_FONT_PLAIN = new Font("Arial", Font.PLAIN,32);
    public static final Color SUBTITLE_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY;


    public JPSpecificOfferSection(){
        this.setBorder(BorderFactory.createEmptyBorder(70,70,0,70));
        BorderLayout layout = new BorderLayout();
        layout.setVgap(20);
        this.setLayout(layout);
        this.setBackground(ConstantsGUI.COLOR_DESPEGAR_ULTRA_LIGHT_GRAY);
        this.initComponents();
    }

    protected void initComponents(){
        this.addSectionTitle();
        this.addSpecificOfferMenuBar();
    }

    protected abstract void addSectionTitle();
    protected abstract void addSpecificOfferMenuBar();

    protected JBRoundButton getSpecificProductOffer(String productIconPath, String sectionName, String productName, String titleCost, double productCost){
        JPSpecificProductOfferTextFormat productOfferText = new JPSpecificProductOfferTextFormat(sectionName,productName);
        JPSpecificProductOfferCostFormat productOfferCost = new JPSpecificProductOfferCostFormat(titleCost ,productCost);
        JPSpecificProductOfferFormat productOfferPanel = new JPSpecificProductOfferFormat(productIconPath, productOfferText,productOfferCost);
        return new JBRoundButton(productOfferPanel,JPSpecificProductOfferFormat.DEFAULT_ANGLE_BORDER,ConstantsGUI.COLOR_WHITE,JPSpecificProductOfferFormat.DEFAULT_BORDER_COLOR);
    }

    protected JBRoundButton getSpecificProductOffer(String productIconPath, String sectionName, String productName, String titleCost, double productCost, double productBeforeCost, double discountPercent){
        JPSpecificProductOfferTextFormat productOfferText = new JPSpecificProductOfferTextFormat(sectionName,productName);
        JPSpecificProductOfferCostFormat productOfferCost = new JPSpecificProductOfferCostFormat(titleCost , productCost, productBeforeCost, discountPercent);
        JPSpecificProductOfferFormat productOfferPanel = new JPSpecificProductOfferFormat(productIconPath, productOfferText,productOfferCost);
        return new JBRoundButton(productOfferPanel,JPSpecificProductOfferFormat.DEFAULT_ANGLE_BORDER, ConstantsGUI.COLOR_WHITE, JPSpecificProductOfferFormat.DEFAULT_BORDER_COLOR);
    }


    protected JBRoundButton getSpecificProductOffer(String productIconPath, String sectionName, String productName, String titleCost, String specificInformation,String labelServiceText,double productCost){
        JPSpecificProductOfferTextFormat productOfferText = new JPSpecificProductOfferTextFormat(sectionName,productName,specificInformation, labelServiceText);
        JPSpecificProductOfferCostFormat productOfferCost = new JPSpecificProductOfferCostFormat(titleCost , productCost);
        JPSpecificProductOfferFormat productOfferPanel = new JPSpecificProductOfferFormat(productIconPath, productOfferText,productOfferCost);
        return new JBRoundButton(productOfferPanel,JPSpecificProductOfferFormat.DEFAULT_ANGLE_BORDER, ConstantsGUI.COLOR_WHITE, JPSpecificProductOfferFormat.DEFAULT_BORDER_COLOR);
    }

    protected JBRoundButton getSpecificProductOffer(String productIconPath, String sectionName, String productName, String titleCost, String specificInformation,double productCost){
        JPSpecificProductOfferTextFormat productOfferText = new JPSpecificProductOfferTextFormat(sectionName,productName,specificInformation);
        JPSpecificProductOfferCostFormat productOfferCost = new JPSpecificProductOfferCostFormat(titleCost , productCost);
        JPSpecificProductOfferFormat productOfferPanel = new JPSpecificProductOfferFormat(productIconPath, productOfferText,productOfferCost);
        return new JBRoundButton(productOfferPanel,JPSpecificProductOfferFormat.DEFAULT_ANGLE_BORDER, ConstantsGUI.COLOR_WHITE, JPSpecificProductOfferFormat.DEFAULT_BORDER_COLOR);
    }

    protected JBRoundButton getSpecificProductOffer(String productIconPath, String sectionName, String productName, String titleCost,double productCost, String labelServiceText){
        JPSpecificProductOfferTextFormat productOfferText = new JPSpecificProductOfferTextFormat(sectionName,productName);
        productOfferText.addLabelService(labelServiceText);
        JPSpecificProductOfferCostFormat productOfferCost = new JPSpecificProductOfferCostFormat(titleCost , productCost);
        JPSpecificProductOfferFormat productOfferPanel = new JPSpecificProductOfferFormat(productIconPath, productOfferText,productOfferCost);
        return new JBRoundButton(productOfferPanel,JPSpecificProductOfferFormat.DEFAULT_ANGLE_BORDER, ConstantsGUI.COLOR_WHITE, JPSpecificProductOfferFormat.DEFAULT_BORDER_COLOR);
    }



    protected JBRoundButton getSpecificProductOffer(String productIconPath, String sectionName, String productName, String labelServiceText,double ratingValue, String titleCost,double productCost, double productBeforeCost, double discountPercent){
        JPSpecificProductOfferTextFormat productOfferText = new JPSpecificProductOfferTextFormat(sectionName,productName,ratingValue);
        productOfferText.addLabelService(labelServiceText);
        JPSpecificProductOfferCostFormat productOfferCost = new JPSpecificProductOfferCostFormat(titleCost , productCost, productBeforeCost, discountPercent);
        JPSpecificProductOfferFormat productOfferPanel = new JPSpecificProductOfferFormat(productIconPath, productOfferText,productOfferCost);
        return new JBRoundButton(productOfferPanel,JPSpecificProductOfferFormat.DEFAULT_ANGLE_BORDER, ConstantsGUI.COLOR_WHITE, JPSpecificProductOfferFormat.DEFAULT_BORDER_COLOR);
    }
}