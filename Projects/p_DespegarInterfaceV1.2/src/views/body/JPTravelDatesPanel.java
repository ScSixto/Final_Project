package views.body;

import views.ConstantsGUI;
import views.JLabelFormat;
import views.JPTextFieldPanel;
import views.body.packageSection.JPPackageSection;

import javax.swing.*;
import java.awt.*;

public class JPTravelDatesPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
    public static final String DATE_ICON_PATH = "resources/img/Fecha.png";
    public static final String DATES_TITLE = "FECHAS";
    public static final String DATE_GOING_TEXT = "Ida";
    public static final String DATES_RETURN_TEXT = "Vuelta";

    public JPTravelDatesPanel(){
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
        JLabelFormat originPlacePanelTitle = new JLabelFormat(DATES_TITLE, ConstantsGUI.SELECTION_SECTION_TITLE_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);
        JLabelFormat originPlaceText = new JLabelFormat(DATE_GOING_TEXT,ConstantsGUI.TEXT_FIELD_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);;
        JPPackageSection packageOriginPlacePanel = new JPPackageSection(originPlacePanelTitle,new Dimension(119,68),new JPTextFieldPanel(originPlaceText,DATE_ICON_PATH, new Dimension(24,24),new Dimension(68,38)));
        this.add(packageOriginPlacePanel);
    }

    private void addDestinationPanel(){
        JLabelFormat destinationPlacePanelTitle = new JLabelFormat(" ",ConstantsGUI.SELECTION_SECTION_TITLE_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);
        JLabelFormat destinationPlaceText = new JLabelFormat(DATES_RETURN_TEXT,ConstantsGUI.TEXT_FIELD_FONT,ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);;
        JPPackageSection packageDestinationPlacePanel = new JPPackageSection(destinationPlacePanelTitle,new Dimension(119,68),new JPTextFieldPanel(destinationPlaceText,DATE_ICON_PATH, new Dimension(24,24),new Dimension(68,38)));
        this.add(packageDestinationPlacePanel);
    }
}
