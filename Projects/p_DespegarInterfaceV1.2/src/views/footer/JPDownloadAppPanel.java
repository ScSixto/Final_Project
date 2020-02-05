package views.footer;

import views.ConstantsGUI;
import views.JLabelFormat;

import javax.swing.*;
import java.awt.*;

public class JPDownloadAppPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public static final Dimension DEFAULT_DIMENSION = new Dimension(627,230);
    public static final String DEFAULT_IMAGE_ICON_PATH = "resources/img/DescargaNuestraApp.png";
    public static final Dimension DEFAULT_IMAGE_ICON_SIZE = new Dimension(200,230);
    public static final Dimension APP_ICON_SIZE = new Dimension(142/*142*/,42);

    public static final String GOOGLE_PLAY_ICON_PATH = "resources/img/GooglePlay.png";
    public static final String APP_STORE_ICON_PATH = "resources/img/AppStore.png";

    public static final String INFORMATION_TEXT_1 = "NO TE PIERDAS DE NADA";
    public static final Font INFORMATION_TEXT_1_FONT = new Font("Arial",Font.PLAIN,12);
    public static final Color INFORMATION_TEXT_1_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY;

    public static final String INFORMATION_TEXT_2 = "Descarga gratis";
    public static final Font INFORMATION_TEXT_2_FONT = new Font("Arial",Font.BOLD,28);
    public static final Color INFORMATION_TEXT_2_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY;

    public static final String INFORMATION_TEXT_3 = "nuestra app";
    public static final Font INFORMATION_TEXT_3_FONT = new Font("Arial",Font.PLAIN,28);
    public static final Color INFORMATION_TEXT_3_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY;

    public JPDownloadAppPanel(){
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setOpaque(false);
        this.setMinimumSize(DEFAULT_DIMENSION);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(0);
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
        informationPanel.setPreferredSize(new Dimension(328,230));
        informationPanel.setOpaque(false);
        informationPanel.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
        informationPanel.setLayout(this.getLayout());

        informationPanel.add(this.getTextPanel());
        informationPanel.add(this.getAppIconPanel());
        this.add(informationPanel);
    }

    private JPanel getAppIconPanel(){
        JPanel appIconPanel = new JPanel();
        appIconPanel.setOpaque(false);
        appIconPanel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        appIconPanel.setLayout(this.getLayout());

        JLabelFormat googlePlayIcon = new JLabelFormat(new ImageIcon(new ImageIcon(GOOGLE_PLAY_ICON_PATH).getImage().getScaledInstance((int)APP_ICON_SIZE.getWidth(),(int)APP_ICON_SIZE.getHeight(),Image.SCALE_AREA_AVERAGING)));
        JLabelFormat appStoreIcon = new JLabelFormat(new ImageIcon(new ImageIcon(APP_STORE_ICON_PATH).getImage().getScaledInstance((int)APP_ICON_SIZE.getWidth(),(int)APP_ICON_SIZE.getHeight(),Image.SCALE_AREA_AVERAGING)));
        appIconPanel.add(googlePlayIcon);
        appIconPanel.add(appStoreIcon);
        return appIconPanel;
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

        JLabelFormat text3 = new JLabelFormat(INFORMATION_TEXT_3,INFORMATION_TEXT_3_FONT,INFORMATION_TEXT_3_FOREGROUND);
        textPanel.add(text3);
        return textPanel;
    }

    private void addImageIcon(){
        ImageIcon image = new ImageIcon(new ImageIcon(DEFAULT_IMAGE_ICON_PATH).getImage().getScaledInstance((int)DEFAULT_IMAGE_ICON_SIZE.getWidth(),(int)DEFAULT_IMAGE_ICON_SIZE.getHeight(),Image.SCALE_AREA_AVERAGING));
        JLabelFormat imageIcon = new JLabelFormat(image);
        this.add(imageIcon);
    }
}