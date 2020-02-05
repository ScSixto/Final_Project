package views.body.packageSection;

import views.*;
import views.body.JPTravelDatesPanel;
import views.body.JPTravelPlacesPanel;

import javax.swing.*;
import java.awt.*;

public class JPCenterPackagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    public static final String PACKAGE_PANEL_TITLE = "Paquetes turisticos";
    public static final String TRAVEL_AND_ONE_HOUSING_ICON_PATH = "resources/img/VueloYAlojamiento.png";
    public static final String TRAVEL_AND_TWO_HOUSING_ICON_PATH = "resources/img/VueloY2Alojamientos.png";
    public static final String TRAVEL_AND_ONE_CAR_ICON_PATH = "resources/img/VueloYCarro.png";
    public static final String PACKAGE_SEARCH_ICON_PATH = "resources/img/Buscar.png";
    public static final String PACKAGE_ROOM_ICON_PATH = "resources/img/Habitaciones.png";


    public static final String PACKAGE_ROOMS_TITLE = "HABITACIONES";
    public static final String ADVANCED_HOUSING_OPTION_TEXT = "Opciones avanzadas de alojamiento";
    public static final String HAVE_NOT_DECIDE_DATE_TEXT = "Todavia no he decidido la fecha";
    public static final String PACKAGE_SEARCH_TEXT = "Buscar";
    public static final String ROOMS_TEXT = " ";

    public JPCenterPackagePanel(){
        this.setPreferredSize(new Dimension(1063,199));
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setOpaque(false);

        this.setBorder(BorderFactory.createEmptyBorder(10,0,20,0));

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.initComponents();
    }

    public void initComponents(){
        this.addPackageNorthPanel();
        this.addPackageCenterPanel();
        this.addPackageSouthPanel();
    }

    public void addPackageNorthPanel(){
        JPanel packageNorthPanel = new JPanel();
        packageNorthPanel.setBackground(Color.CYAN);
        packageNorthPanel.setPreferredSize(new Dimension(WIDTH,50));
        packageNorthPanel.setOpaque(false);
        packageNorthPanel.setBorder(BorderFactory.createEmptyBorder(0,13,0,0));

        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        packageNorthPanel.setLayout(layout);
        packageNorthPanel.add(new JLabelFormat(PACKAGE_PANEL_TITLE,ConstantsGUI.SECTION_TITLE_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY));

        layout.setHgap(8);

        JPanel packageNorthButtonPanel = new JPanel();
        packageNorthButtonPanel.setLayout(layout);
        packageNorthButtonPanel.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
        packageNorthButtonPanel.setOpaque(false);
        packageNorthButtonPanel.add(new JBRoundButton(TRAVEL_AND_ONE_HOUSING_ICON_PATH,new Dimension(193,27),ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_3));
        packageNorthButtonPanel.add(new JBRoundButton(TRAVEL_AND_TWO_HOUSING_ICON_PATH,new Dimension(213,27),ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_3));
        packageNorthButtonPanel.add(new JBRoundButton(TRAVEL_AND_ONE_CAR_ICON_PATH,new Dimension(150,27),ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_3));

        packageNorthPanel.add(packageNorthButtonPanel);
        this.add(packageNorthPanel);
    }

    public void addPackageCenterPanel(){
        JPanel packageCenterPanel = new JPanel();
        packageCenterPanel.setOpaque(false);
        packageCenterPanel.setPreferredSize(new Dimension(WIDTH,80));
        packageCenterPanel.setBorder(BorderFactory.createEmptyBorder(0,11,0,0));

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(5);
        packageCenterPanel.setLayout(flowLayout);

        packageCenterPanel.add(new JPTravelPlacesPanel());
        packageCenterPanel.add(new JPTravelDatesPanel());
        packageCenterPanel.add(this.getPackagesRoomsPanel());
        packageCenterPanel.add(this.getSearchSection());
        //packageCenterPanel.add(this.getPackagesRoomsPanel());
        //packageCenterPanel.add(new JBRoundButton(PACKAGE_SEARCH_TEXT,PACKAGE_SEARCH_ICON_PATH,new Dimension(16,16),new Font("Arial",Font.PLAIN,16),ConstantsGUI.COLOR_WHITE,SwingConstants.RIGHT,SwingConstants.CENTER,ConstantsGUI.COLOR_DESPEGAR_DARK_PURPLE,ConstantsGUI.COLOR_DESPEGAR_DARK_PURPLE));

        this.add(packageCenterPanel);
    }

    private JPPackageSection getPackagesRoomsPanel(){
        JLabelFormat roomPanelTitle = new JLabelFormat(PACKAGE_ROOMS_TITLE,ConstantsGUI.SELECTION_SECTION_TITLE_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);
        JLabelFormat roomText = new JLabelFormat(ROOMS_TEXT,ConstantsGUI.TEXT_FIELD_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);;
        JPPackageSection packageRoomPanel = new JPPackageSection(roomPanelTitle,new Dimension(162,68),new JPTextFieldPanel(roomText,PACKAGE_ROOM_ICON_PATH, new Dimension(122,38),new Dimension(10,38)));
        packageRoomPanel.setBorder(BorderFactory.createEmptyBorder(0,3,0,0));
        return packageRoomPanel;
    }

    private JPPackageSection getSearchSection(){
        JLabelFormat roomPanelTitle = new JLabelFormat(" ",ConstantsGUI.SELECTION_SECTION_TITLE_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);
        JBRoundButton searchButton = new JBRoundButton(PACKAGE_SEARCH_TEXT, PACKAGE_SEARCH_ICON_PATH, new Dimension(16,16),new Font("Arial",Font.BOLD,16),ConstantsGUI.COLOR_WHITE,SwingConstants.RIGHT, SwingConstants.CENTER, ConstantsGUI.COLOR_DESPEGAR_DARK_PURPLE,45);
        searchButton.setBorder(BorderFactory.createEmptyBorder(14,20,14,20));
        JPPackageSection searchPanel = new JPPackageSection(roomPanelTitle,new Dimension(122,68),searchButton);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(0,7,0,0));
        return searchPanel;
    }
    
    private void addPackageSouthPanel(){
    	JPanel packageSouthPanel = new JPanel();
    	packageSouthPanel.setPreferredSize(new Dimension(WIDTH,17));
    	packageSouthPanel.setOpaque(false);
    	packageSouthPanel.setBorder(BorderFactory.createEmptyBorder(0,17,0,337));
    	
    	BorderLayout borderLayout = new BorderLayout();
    	packageSouthPanel.setLayout(borderLayout);
    	
    	packageSouthPanel.add(new JBBoxButton(ADVANCED_HOUSING_OPTION_TEXT),BorderLayout.WEST);

    	JLabelFormat checkBoxText = new JLabelFormat(HAVE_NOT_DECIDE_DATE_TEXT,new Font("Arial",Font.PLAIN,14),ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY);

    	packageSouthPanel.add(new JCBCheckBoxFormat(checkBoxText),BorderLayout.EAST);
    	this.add(packageSouthPanel);
    }

    protected void paintComponent(Graphics g){
        Dimension arcs = new Dimension(20,20); //Border corners arcs {width,height}, change this to whatever you want
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded panel with borders.
        graphics.setColor(this.getBackground());
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
//        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
//        graphics.setColor(ConstantsGUI.DESPEGAR_LIGHT_GRAY);
        super.paintComponent(graphics);
    }
}
