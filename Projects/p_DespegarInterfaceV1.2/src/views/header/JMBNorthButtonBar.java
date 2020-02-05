package views.header;

import javax.swing.*;
import controllers.ActionCommands;
import views.ConstantsGUI;
import views.header.JBNorthMenuBarButton;

import java.awt.*;
import java.awt.event.ActionListener;

public class JMBNorthButtonBar extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
    public static final String HOUSING_ICON_PATH = "resources/img/Alojamiento.png";
    public static final String HOUSING_TEXT = "Alojamientos";
    public static final String TRAVELS_ICON_PATH = "resources/img/Vuelos.png";
    public static final String TRAVELS_TEXT = "Vuelos";
    public static final String PACKAGE_ICON_PATH = "resources/img/Paquetes.png";
    public static final String PACKAGE_TEXT = "Paquetes";
    public static final String UNBEATABLE_ICON_PATH = "resources/img/Imbatibles.png";
    public static final String UNBEATABLE_TEXT = "Imbatibles";
    public static final String SCAPE_ICON_PATH = "resources/img/Escapadas.png";
    public static final String SCAPE_TEXT = "Escapadas";
    public static final String ACTIVITIES_ICON_PATH = "resources/img/Actividades.png";
    public static final String ACTIVITIES_TEXT = "Actividades";
    public static final String CARS_ICON_PATH = "resources/img/Carros.png";
    public static final String CARS_TEXT = "Carros";
    public static final String DISNEY_ICON_PATH = "resources/img/Disney.png";
    public static final String DISNEY_TEXT = "Disney";
    public static final String INSURENCES_ICON_PATH = "resources/img/Seguros.png";
    public static final String INSURENCES_TEXT = "Seguros";
    public static final String TRANSFERS_ICON_PATH = "resources/img/Traslados.png";
    public static final String TRANSFERS_TEXT = "Traslados";
    public static final String CRUISERS_ICON_PATH = "resources/img/Cruceros.png";
    public static final String CRUISERS_TEXT = "Cruceros";

    public JMBNorthButtonBar(ActionListener act){
        this.setPreferredSize(new Dimension(1020,82));
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setOpaque(false);

        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder(20,40,0,0));

        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        layout.setHgap(30);
        this.setLayout(layout);

        this.initComponents(act);
    }

    public void initComponents(ActionListener act){
    	JBNorthMenuBarButton housingButton = new JBNorthMenuBarButton(HOUSING_TEXT,HOUSING_ICON_PATH);
    	housingButton.setActionCommand(ActionCommands.ADD_HOUSING.name());
    	housingButton.addActionListener(act);
    	housingButton.setToolTipText("Helloooouuu");
    	this.add(housingButton);
    	
    	JBNorthMenuBarButton travelsButton = new JBNorthMenuBarButton(TRAVELS_TEXT,TRAVELS_ICON_PATH); 
    	travelsButton.setActionCommand(ActionCommands.ADD_TRAVEL.name());
    	travelsButton.addActionListener(act);
    	travelsButton.setToolTipText("fiu fiu");
    	this.add(travelsButton);
    	
    	JBNorthMenuBarButton packageButton = new JBNorthMenuBarButton(PACKAGE_TEXT,PACKAGE_ICON_PATH); 
    	packageButton.setActionCommand(ActionCommands.ADD_PACKAGE.name());
    	packageButton.addActionListener(act);
    	packageButton.setToolTipText("aja aja aja aja");
    	this.add(packageButton);

        this.add(new JBNorthMenuBarButton(UNBEATABLE_TEXT,UNBEATABLE_ICON_PATH));
        this.add(new JBNorthMenuBarButton(SCAPE_TEXT,SCAPE_ICON_PATH));
        this.add(new JBNorthMenuBarButton(ACTIVITIES_TEXT,ACTIVITIES_ICON_PATH));
        this.add(new JBNorthMenuBarButton(CARS_TEXT,CARS_ICON_PATH));
        this.add(new JBNorthMenuBarButton(DISNEY_TEXT,DISNEY_ICON_PATH));
        this.add(new JBNorthMenuBarButton(INSURENCES_TEXT,INSURENCES_ICON_PATH));
        this.add(new JBNorthMenuBarButton(TRANSFERS_TEXT,TRANSFERS_ICON_PATH));
        this.add(new JBNorthMenuBarButton(CRUISERS_TEXT,CRUISERS_ICON_PATH));
    }
}