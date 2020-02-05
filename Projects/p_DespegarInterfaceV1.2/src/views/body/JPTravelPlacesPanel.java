package views.body;

import views.ConstantsGUI;
import views.JLabelFormat;
import views.JPTextFieldPanel;
import views.body.packageSection.JPPackageSection;

import javax.swing.*;
import java.awt.*;

public class JPTravelPlacesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    public static final String PACKAGE_ORIGIN_PLACE_ICON_PATH = "resources/img/Origen.png";
    public static final String PACKAGE_DESTINATION_PLACE_ICON_PATH = "resources/img/Destino.png";
    public static final String PACKAGE_ORIGIN_PLACE_TITLE = "ORIGEN";
    public static final String PACKAGE_DESTINATION_PLACE_TITLE = "DESTINO";
    public static final String PACKAGE_PLACE_TEXT = "Ingresa una ciudad";

    public JPTravelPlacesPanel(){
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(4);
        this.setLayout(flowLayout);
        this.setOpaque(false);
        this.initComponents();
    }

    private void initComponents(){
        this.addOriginPanel();
        this.addDestinationPanel();
    }

    private void addOriginPanel(){
        JLabelFormat originPlacePanelTitle = new JLabelFormat(PACKAGE_ORIGIN_PLACE_TITLE, ConstantsGUI.SELECTION_SECTION_TITLE_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);
        JLabelFormat originPlaceText = new JLabelFormat(PACKAGE_PLACE_TEXT,ConstantsGUI.TEXT_FIELD_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);;
        JPPackageSection packageOriginPlacePanel = new JPPackageSection(originPlacePanelTitle,new Dimension(233,68),new JPTextFieldPanel(originPlaceText,PACKAGE_ORIGIN_PLACE_ICON_PATH, new Dimension(24,24),new Dimension(179,38)));
        this.add(packageOriginPlacePanel);
    }

    private void addDestinationPanel(){
        JLabelFormat destinationPlacePanelTitle = new JLabelFormat(PACKAGE_DESTINATION_PLACE_TITLE,ConstantsGUI.SELECTION_SECTION_TITLE_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);
        JLabelFormat destinationPlaceText = new JLabelFormat(PACKAGE_PLACE_TEXT,ConstantsGUI.TEXT_FIELD_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);;
        JPPackageSection packageDestinationPlacePanel = new JPPackageSection(destinationPlacePanelTitle,new Dimension(233,68),new JPTextFieldPanel(destinationPlaceText,PACKAGE_DESTINATION_PLACE_ICON_PATH, new Dimension(24,24),new Dimension(179,38)));
        this.add(packageDestinationPlacePanel);
    }
}
