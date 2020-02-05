package views.body;

import views.ConstantsGUI;
import views.JLabelFormat;

import javax.swing.*;
import java.awt.*;

public class JPInstallmentsTripContainer extends JPanel{

	private static final long serialVersionUID = 1L;
	
    public static final Dimension DEFAULT_DIMENSION = new Dimension(1280,100);

    public static final int DEFAULT_ANGLE_BORDER = 20;
    public static final Color DEFAULT_BORDER_COLOR = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_4;
    public static final Font DEFAULT_SPECIFIC_PAYMENT_METHOD_FONT = new Font("Arial", Font.PLAIN, 12);
    public static final Color DEFAULT_SPECIFIC_PAYMENT_METHOD_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2;
    public static final Dimension DEFAULT_SPECIFIC_PAYMENT_METHOD_ICON_SIZE = new Dimension(60,35);

    public static final String TITLE_SECTION_TEXT = "Paga tu viaje en cuotas";
    public static final Font TITLE_SECTION_FONT = new Font("Arial",Font.BOLD,20);
    public static final Color TITLE_SECTION_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY;

    public static final String SUBTITLE_SECTION_TEXT = "Ver promociones bancarias";
    public static final Font SUBTITLE_SECTION_FONT = new Font("Arial",Font.PLAIN,14);
    public static final Color SUBTITLE_SECTION_FOREGROUND = ConstantsGUI.COLOR_DESPEGAR_DARK_PURPLE;

    public static final String BANCOLOMBIA_ICON_PATH = "resources/img/BancolombiaLogo.png";
    public static final String BANCOLOMBIA_TEXT = "0% inter"+ ConstantsGUI.LOWERCASE_ACCENTED_E +"s";

    public static final String BBVA_ICON_PATH = "resources/img/BBVALogo.png";
    public static final String BBVA_TEXT = "0% inter"+ ConstantsGUI.LOWERCASE_ACCENTED_E +"s";

    public static final String BANCO_POPULAR_ICON_PATH = "resources/img/BancoPopularLogo.png";
    public static final String BANCO_POPULAR_TEXT = "0% inter"+ ConstantsGUI.LOWERCASE_ACCENTED_E +"s";

    public static final String SU_RED_ICON_PATH = "resources/img/SuRedLogo.png";
    public static final String SU_RED_TEXT = "Efectivo*";

    public static final String VIA_BALOTO_ICON_PATH = "resources/img/ViaBalotoLogo.png";
    public static final String VIA_BALOTO_TEXT = "Efectivo*";

    public static final String CREDITO_FACIL_CODENSA_ICON_PATH = "resources/img/CreditoFacilCodensaLogo.png";
    public static final String CREDITO_FACIL_CODENSA_TEXT = ConstantsGUI.UPPERCASE_ACCENTED_U +"SALA!";

    public static final String PSE_ICON_PATH = "resources/img/PSELogo.png";
    public static final String PSE_TEXT = "D"+ ConstantsGUI.LOWERCASE_ACCENTED_E +"bito";

    public static final String EFECTY_ICON_PATH = "resources/img/EfectyLogo.png";
    public static final String EFECTY_TEXT = "Efectivo*";

    public static final String MASTERCARD_ICON_PATH = "resources/img/MastercardLogo.png";
    public static final String MASTERCARD_TEXT = "36 Cuotas";

    public static final String VISA_ICON_PATH = "resources/img/VISALogo.png";
    public static final String VISA_TEXT = "36 Cuotas";

    public static final String AMERICAN_EXPRESS_ICON_PATH = "resources/img/AmericanExpressLogo.png";
    public static final String AMERICAN_EXPRESS_TEXT = "36 Cuotas";

    public static final String DINERS_CLUB_ICON_PATH = "resources/img/DinersClubInternationalLogo.png";
    public static final String DINERS_CLUB_TEXT = "36 Cuotas";

    public JPInstallmentsTripContainer(){
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setBackground(ConstantsGUI.COLOR_WHITE);

        this.setMaximumSize(DEFAULT_DIMENSION);
        this.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));

        this.initComponents();
    }

    private void initComponents(){
        this.addTextInformation();
        this.addPaymentMethodsMenuBar();
    }

    private void addTextInformation(){
        JPanel textInformationPanel = new JPanel();
        textInformationPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        textInformationPanel.setPreferredSize(new Dimension(282,50));
        textInformationPanel.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
        textInformationPanel.setOpaque(false);

        JLabelFormat title = new JLabelFormat(TITLE_SECTION_TEXT,TITLE_SECTION_FONT,TITLE_SECTION_FOREGROUND);
        JLabelFormat subtitle = new JLabelFormat(SUBTITLE_SECTION_TEXT,SUBTITLE_SECTION_FONT,SUBTITLE_SECTION_FOREGROUND);
        textInformationPanel.add(title);
        textInformationPanel.add(subtitle);
        this.add(textInformationPanel,BorderLayout.WEST);
    }

    private void addPaymentMethodsMenuBar(){
        JMenuBar paymentMethods = new JMenuBar();
        paymentMethods.setBorderPainted(false);
        paymentMethods.setOpaque(false);
        paymentMethods.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        paymentMethods.setMaximumSize(new Dimension(885,70));

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(20);
        paymentMethods.setLayout(flowLayout);

        paymentMethods.add(this.getSpecificPaymentMethod(BANCOLOMBIA_ICON_PATH, BANCOLOMBIA_TEXT));
        paymentMethods.add(this.getSpecificPaymentMethod(BBVA_ICON_PATH, BBVA_TEXT));
        paymentMethods.add(this.getSpecificPaymentMethod(BANCO_POPULAR_ICON_PATH, BANCO_POPULAR_TEXT));
        paymentMethods.add(this.getSpecificPaymentMethod(SU_RED_ICON_PATH, SU_RED_TEXT));
        paymentMethods.add(this.getSpecificPaymentMethod(VIA_BALOTO_ICON_PATH, VIA_BALOTO_TEXT));
        paymentMethods.add(this.getSpecificPaymentMethod(CREDITO_FACIL_CODENSA_ICON_PATH, CREDITO_FACIL_CODENSA_TEXT));
        paymentMethods.add(this.getSpecificPaymentMethod(PSE_ICON_PATH, PSE_TEXT));
        paymentMethods.add(this.getSpecificPaymentMethod(EFECTY_ICON_PATH, EFECTY_TEXT));
        paymentMethods.add(this.getSpecificPaymentMethod(MASTERCARD_ICON_PATH, MASTERCARD_TEXT));
        paymentMethods.add(this.getSpecificPaymentMethod(VISA_ICON_PATH, VISA_TEXT));
        paymentMethods.add(this.getSpecificPaymentMethod(AMERICAN_EXPRESS_ICON_PATH, AMERICAN_EXPRESS_TEXT));
        paymentMethods.add(this.getSpecificPaymentMethod(DINERS_CLUB_ICON_PATH, DINERS_CLUB_TEXT));

        this.add(paymentMethods,BorderLayout.EAST);
    }

    private JLabelFormat getSpecificPaymentMethod(String iconPath, String text){
        ImageIcon specificPaymentMethodIcon = new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance((int)DEFAULT_SPECIFIC_PAYMENT_METHOD_ICON_SIZE.getWidth(), (int)DEFAULT_SPECIFIC_PAYMENT_METHOD_ICON_SIZE.getHeight(),Image.SCALE_AREA_AVERAGING));
        JLabelFormat specificPaymentMethod = new JLabelFormat(text,DEFAULT_SPECIFIC_PAYMENT_METHOD_FONT,DEFAULT_SPECIFIC_PAYMENT_METHOD_FOREGROUND,specificPaymentMethodIcon,SwingConstants.CENTER,SwingConstants.BOTTOM);
        return specificPaymentMethod;
    }
}