package views.body.offerSection;

import views.ConstantsGUI;

import javax.swing.*;
import java.awt.*;

public class JPSpecificProductOfferFormat extends JPanel{

	private static final long serialVersionUID = 1L;
	
    public static final int DEFAULT_ANGLE_BORDER = 20;
    public static final Color DEFAULT_BORDER_COLOR = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_4;
    public static final Dimension DEFAULT_ICON_SIZE = new Dimension(296,200);
    public static final Dimension DEFAULT_DIMENSION = new Dimension(297,470);

    public JPSpecificProductOfferFormat(String iconPath, JPSpecificProductOfferTextFormat textPanel, JPSpecificProductOfferCostFormat costPanel){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setOpaque(false);
        this.initComponents(iconPath, textPanel, costPanel);
        this.setPreferredSize(DEFAULT_DIMENSION);
    }

    private void initComponents(String iconPath, JPSpecificProductOfferTextFormat textPanel, JPSpecificProductOfferCostFormat costPanel){
        this.addImagePanel(iconPath);
        this.addOfferTextPanel(textPanel);
        this.addOfferCostPanel(costPanel);
    }

    private void addImagePanel(String iconPath){
        JPanel offerImagePanel = new JPanel();
        offerImagePanel.setBorder(BorderFactory.createEmptyBorder(-5,1,0,0));
        offerImagePanel.setBackground(Color.CYAN);
        offerImagePanel.setOpaque(false);
        offerImagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel offerImage = new JLabel();
        offerImage.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance((int)DEFAULT_ICON_SIZE.getWidth(),(int)DEFAULT_ICON_SIZE.getHeight(),Image.SCALE_AREA_AVERAGING)));
        offerImagePanel.setMaximumSize(new Dimension((int)DEFAULT_ICON_SIZE.getWidth(), (int)DEFAULT_ICON_SIZE.getHeight()));
        offerImagePanel.setMinimumSize(new Dimension((int)DEFAULT_ICON_SIZE.getWidth(), (int)DEFAULT_ICON_SIZE.getHeight()));
        offerImagePanel.add(offerImage);
        this.add(offerImagePanel,BorderLayout.NORTH);
    }

    private void addOfferTextPanel(JPSpecificProductOfferTextFormat textPanel){
        this.add(textPanel,BorderLayout.CENTER);
    }

    private void addOfferCostPanel(JPSpecificProductOfferCostFormat costPanel){
        this.add(costPanel,BorderLayout.SOUTH);
    }

//    protected void paintComponent(Graphics g) {
//        Dimension arcs = new Dimension(DEFAULT_ANGLE_BORDER, DEFAULT_ANGLE_BORDER); //Border corners arcs {width,height}, change this to whatever you want
//        int width = getWidth();
//        int height = getHeight();
//        Graphics2D graphics = (Graphics2D) g;
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        //Draws the rounded panel with borders.
////        graphics.setColor(this.getBackground());//ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY);
//        graphics.drawImage(new ImageIcon("resources/img/Fecha.png").getImage().getScaledInstance((int)DEFAULT_ICON_SIZE.getWidth(),(int)DEFAULT_ICON_SIZE.getHeight(),Image.SCALE_AREA_AVERAGING),0,0,null);
////        graphics.fillRoundRect(0, 4, width-1, height-5, arcs.width, arcs.height);//paint border
////        graphics.setColor(DEFAULT_BORDER_COLOR);//ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY);
////        graphics.drawRoundRect(0, 4, width-1, height-5, arcs.width, arcs.height);//paint border
//        super.paintComponent(graphics);
//    }
}