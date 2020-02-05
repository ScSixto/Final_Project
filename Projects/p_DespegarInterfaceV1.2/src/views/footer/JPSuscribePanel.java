package views.footer;

import views.ConstantsGUI;
import views.JLabelFormat;
import views.JPRoundPanel;

import javax.swing.*;
import java.awt.*;

public class JPSuscribePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    public static final Dimension DEFAULT_DIMENSION = new Dimension(627,230);
    public static final String DEFAULT_IMAGE_ICON_PATH = "resources/img/EncuentraOfertas.png";
    public static final Dimension DEFAULT_IMAGE_ICON_SIZE = new Dimension(200,230);

    public static final String INFORMATION_TEXT_1 = "DESCUENTOS EN VIAJES";
    public static final Font INFORMATION_TEXT_1_FONT = new Font("Arial",Font.PLAIN,12);
    public static final Color INFORMATION_TEXT_1_FOREGROUND = ConstantsGUI.COLOR_WHITE;

    public static final String INFORMATION_TEXT_2 = "<html><b>Encuentra Ofertas</b> para<br>tu pr"+ ConstantsGUI.LOWERCASE_ACCENTED_O +"ximo destino</html>";
    public static final Font INFORMATION_TEXT_2_FONT = new Font("Arial",Font.PLAIN,28);
    public static final Color INFORMATION_TEXT_2_FOREGROUND = ConstantsGUI.COLOR_WHITE;

    public static final String SUSCRIBE_BUTTON_TEXT = "Quiero suscribirme";
    public static final Font SUSCRIBE_BUTTON_TEXT_FONT = new Font("Arial",Font.BOLD,16);
    public static final Color SUSCRIBE_BUTTON_TEXT_FOREGROUND = ConstantsGUI.COLOR_WHITE;
    public static final int SUSCRIBE_BUTTON_ANGLE = 45;

    public JPSuscribePanel(){
        this.setBackground(ConstantsGUI.COLOR_DESPEGAR_BLUE);
        this.setOpaque(false);
        this.setMaximumSize(DEFAULT_DIMENSION);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(0);
//        flowLayout.setVgap(10);
        this.setLayout(flowLayout);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.initComponents();
    }

    private void initComponents(){
        this.addImageIcon();
        this.addInformationPanel();
    }

    private void addInformationPanel(){
        JPanel informationPanel = new JPanel();
        informationPanel.setPreferredSize(new Dimension(360,230));
        informationPanel.setOpaque(false);
        informationPanel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
        informationPanel.setLayout(this.getLayout());

        informationPanel.add(this.getTextPanel());
        informationPanel.add(this.getSuscribeButton());
        this.add(informationPanel);
    }

    private JPRoundPanel getSuscribeButton(){
        JLabelFormat suscribeText = new JLabelFormat(SUSCRIBE_BUTTON_TEXT,SUSCRIBE_BUTTON_TEXT_FONT,SUSCRIBE_BUTTON_TEXT_FOREGROUND);
        JPRoundPanel suscribeButton = new JPRoundPanel(suscribeText,SUSCRIBE_BUTTON_ANGLE,ConstantsGUI.COLOR_WHITE);
        suscribeButton.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));

        return suscribeButton;
    }

    private JPanel getTextPanel(){
        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.Y_AXIS));

        JLabelFormat text1 = new JLabelFormat(INFORMATION_TEXT_1,INFORMATION_TEXT_1_FONT,INFORMATION_TEXT_1_FOREGROUND);
        textPanel.add(text1);

        JLabelFormat text2 = new JLabelFormat(INFORMATION_TEXT_2,INFORMATION_TEXT_2_FONT,INFORMATION_TEXT_2_FOREGROUND);
        textPanel.add(text2);

        return textPanel;
    }

    private void addImageIcon(){
        ImageIcon image = new ImageIcon(new ImageIcon(DEFAULT_IMAGE_ICON_PATH).getImage().getScaledInstance((int)DEFAULT_IMAGE_ICON_SIZE.getWidth(),(int)DEFAULT_IMAGE_ICON_SIZE.getHeight(),Image.SCALE_AREA_AVERAGING));
        JLabelFormat imageIcon = new JLabelFormat(image);
        this.add(imageIcon);
    }
}