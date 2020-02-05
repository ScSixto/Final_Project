package views.body.offerSection;

import views.ConstantsGUI;
import views.JLabelFormat;
import views.JPRoundPanel;

import javax.swing.*;
import java.awt.*;

public class JPSpecificProductOfferTextFormat extends JPanel{

	private static final long serialVersionUID = 1L;
	
    public static final Dimension DEFAULT_DIMENSION = new Dimension(294,192);

    public static final Font DEFAULT_SECTION_TEXT_FONT = new Font("Arial",Font.BOLD,12);
    public static final Color DEFAULT_SECTION_TEXT_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY;

    public static final Font DEFAULT_PRODUCT_NAME_FONT = new Font("Arial",Font.BOLD,24);
    public static final Color DEFAULT_PRODUCT_NAME_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY;

    public static final Font DEFAULT_LABEL_SERVICE_FONT = new Font("Arial",Font.BOLD,12);
    public static final Color DEFAULT_LABEL_SERVICE_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY;
    public static final Color DEFAULT_LABEL_SERVICE_BORDER_COLOR = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_4;
    public static final int DEFAULT_LABEL_SERVICE_ANGLE = 10;

    public static final Font DEFAULT_SPECIFIC_INFORMATION_FONT = new Font("Arial",Font.BOLD,13);
    public static final Color DEFAULT_SPECIFIC_INFORMATION_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2;

    public static final double MAXIMUM_RAITING = 10;
    public static final double STAR_PERCENT_VALUE = 25;

    public static final String RATING_ICON_PATH = "resources/img/Star.png";
    public static final Dimension RATING_ICON_SIZE = new Dimension(20,20);
    public static final ImageIcon DEFAULT_RATING_ICON = new ImageIcon(new ImageIcon(RATING_ICON_PATH).getImage().getScaledInstance((int)RATING_ICON_SIZE.getWidth(),(int)RATING_ICON_SIZE.getHeight(),Image.SCALE_AREA_AVERAGING));

    public JPSpecificProductOfferTextFormat(String sectionText, String productName){
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        this.setMinimumSize(DEFAULT_DIMENSION);
        this.setMaximumSize(DEFAULT_DIMENSION);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(24,24,24,24));

        this.initComponents(sectionText, productName);
    }

    public JPSpecificProductOfferTextFormat(String sectionText, String productName, String specificInformation){
        this(sectionText,productName);
        this.addSpecificInformation(specificInformation);
    }

    public JPSpecificProductOfferTextFormat(String sectionText, String productName, String specificInformation, String labelServiceName){
        this(sectionText,productName);
        this.addSpecificInformation(specificInformation);
        this.addLabelService(labelServiceName);
    }

    public JPSpecificProductOfferTextFormat(String sectionText, String productName, double productRating){
        this(sectionText,productName);
        this.addProductRating(productRating);
    }

    private void initComponents(String sectionText,String productName){
        this.addTitlePanel(sectionText,productName);
    }

    private void addTitlePanel(String sectionText,String productName){
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setMaximumSize(new Dimension(247,72));
        titlePanel.setOpaque(false);

        JLabelFormat sectionTextJLabel = new JLabelFormat(sectionText,DEFAULT_SECTION_TEXT_FONT,DEFAULT_SECTION_TEXT_FOREGROUND);
        JLabelFormat productNameJLabel = new JLabelFormat(productName,DEFAULT_PRODUCT_NAME_FONT,DEFAULT_PRODUCT_NAME_FOREGROUND);
        titlePanel.add(sectionTextJLabel,BorderLayout.NORTH);
        titlePanel.add(productNameJLabel,BorderLayout.WEST);
        this.add(titlePanel);
    }

    public void addLabelService(String labelServiceName){
        JPanel labelPanel = new JPanel();
        labelPanel.setOpaque(false);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(0);
        flowLayout.setVgap(10);
        labelPanel.setLayout(flowLayout);
        labelPanel.setMaximumSize(new Dimension(247,35));
        JPRoundPanel labelService = new JPRoundPanel(new JLabelFormat(labelServiceName, DEFAULT_LABEL_SERVICE_FONT,DEFAULT_LABEL_SERVICE_FOREGROUND),DEFAULT_LABEL_SERVICE_ANGLE,DEFAULT_LABEL_SERVICE_BORDER_COLOR);
        labelPanel.add(labelService);
        this.add(labelPanel);
    }

    public void addProductRating(double productRaiting){
        JPanel ratingStarsPanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(3);
        ratingStarsPanel.setLayout(flowLayout);
        ratingStarsPanel.setOpaque(false);
        int ratingStarCount = (int)((productRaiting*100/MAXIMUM_RAITING)/STAR_PERCENT_VALUE);
        ratingStarsPanel.add(new JPProductRaitingValuePanel(productRaiting));
        for(int i = 0; i <= ratingStarCount; i++){
            ratingStarsPanel.add(new JLabelFormat(DEFAULT_RATING_ICON));
        }
        this.add(ratingStarsPanel);
    }

    public void addSpecificInformation(String information){
        JPanel specificInformationPanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(0);
        flowLayout.setVgap(10);
        specificInformationPanel.setLayout(flowLayout);
        specificInformationPanel.setMaximumSize(new Dimension(247,25));
        specificInformationPanel.setOpaque(false);

        specificInformationPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        JLabelFormat specificInformation = new JLabelFormat(information, DEFAULT_SPECIFIC_INFORMATION_FONT, DEFAULT_SPECIFIC_INFORMATION_FOREGROUND);
        specificInformation.setHorizontalTextPosition(SwingConstants.LEFT);
        specificInformationPanel.add(specificInformation);
        this.add(specificInformationPanel);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(DEFAULT_LABEL_SERVICE_BORDER_COLOR);
        g2.drawRect(-1,0,this.getWidth()+1,this.getHeight()-1);
        super.paintComponent(graphics);
    }
}