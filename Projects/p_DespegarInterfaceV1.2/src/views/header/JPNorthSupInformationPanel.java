package views.header;

import views.ConstantsGUI;
import views.JLabelFormat;

import javax.swing.*;
import java.awt.*;

public class JPNorthSupInformationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    public static final String CONTACT_INFORMATION_TEXT = "Para ventas";
    public static final String CONTACT_INFORMATION_NUMBER_TEXT = "01 800 011 3915";
    public static final String CONTACT_INFORMATION_ICON_PATH = "resources/img/ParaVentas.png";
    public static final String LOGIN_TEXT = "Iniciar Sesi"+ ConstantsGUI.LOWERCASE_ACCENTED_O +"n";
    public static final String LOGIN_ICON_PATH = "resources/img/Login.png";
    public static final String MY_TRAVELS_TEXT = "Mis Viajes";
    public static final String MY_TRAVELS_ICON_PATH = "resources/img/MisViajes.png";
    public static final String HELP_TEXT = "Ayuda";
    public static final String HELP_ICON_PATH = "resources/img/Ayuda.png";

    public JPNorthSupInformationPanel(){
        this.setPreferredSize(new Dimension(716,48));
        this.setBackground(ConstantsGUI.COLOR_DESPEGAR_ULTRA_LIGHT_GRAY);
        this.setOpaque(false);

        this.setBorder(BorderFactory.createEmptyBorder(0,0,1,0));
        BorderLayout layout = new BorderLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        this.setLayout(layout);
        this.initComponents();
    }

    public void initComponents(){
        this.addContactInformation();
        this.addLoginPanel();
        this.addEmptyPanel();
    }

    public void addEmptyPanel(){
        JPanel emptyPanel = new JPanel();
        emptyPanel.setOpaque(false);
        emptyPanel.setLayout(new BorderLayout());
        emptyPanel.setPreferredSize(new Dimension(16,HEIGHT));

        JPanel grayPanel = new JPanel();
        grayPanel.setOpaque(true);
        grayPanel.setPreferredSize(new Dimension(16,16));
        emptyPanel.add(grayPanel,BorderLayout.NORTH);
        this.add(emptyPanel,BorderLayout.WEST);
    }

    public void addContactInformation(){
        JPanel jPContactInformationPanel = new JPanel();
        jPContactInformationPanel.setBorder(BorderFactory.createEmptyBorder(0,4,0,0));
        jPContactInformationPanel.setBackground(this.getBackground());
        jPContactInformationPanel.setOpaque(true);
        jPContactInformationPanel.setPreferredSize(new Dimension(238,20));
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        layout.setHgap(3);
        layout.setVgap(12);
        jPContactInformationPanel.setLayout(layout);
        jPContactInformationPanel.add(new JBNorthSupButton(CONTACT_INFORMATION_TEXT,CONTACT_INFORMATION_ICON_PATH,new Dimension(20,20),ConstantsGUI.FONT_GENERAL_BUTTON,ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY));
        jPContactInformationPanel.add(new JLabelFormat(CONTACT_INFORMATION_NUMBER_TEXT,new Font("Arial",Font.BOLD,14),ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY));
        this.add(jPContactInformationPanel,BorderLayout.CENTER);
    }

    public void addLoginPanel(){
        JPanel jpLoginPanel = new JPanel();
        jpLoginPanel.setBackground(this.getBackground());
        jpLoginPanel.setOpaque(true);
        jpLoginPanel.setPreferredSize(new Dimension((716-238),20));
        jpLoginPanel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        layout.setHgap(20);
        layout.setVgap(12);
        jpLoginPanel.setLayout(layout);
        jpLoginPanel.add(new JBNorthSupButton(LOGIN_TEXT,LOGIN_ICON_PATH,new Dimension(20,20),ConstantsGUI.FONT_GENERAL_BUTTON,ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY));
        jpLoginPanel.add(new JBNorthSupButton(MY_TRAVELS_TEXT,MY_TRAVELS_ICON_PATH,new Dimension(20,20),ConstantsGUI.FONT_GENERAL_BUTTON,ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY));
        jpLoginPanel.add(new JBNorthSupButton(HELP_TEXT,HELP_ICON_PATH,new Dimension(20,20),ConstantsGUI.FONT_GENERAL_BUTTON,ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY));
        this.add(jpLoginPanel,BorderLayout.EAST);
    }

    protected void paintComponent(Graphics g){
        Dimension arcs = new Dimension(40,40); //Border corners arcs {width,height}, change this to whatever you want
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