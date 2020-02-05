package views.body.offerSection.leavingFromYopalSection;

import views.ConstantsGUI;
import views.JBRoundButton;
import views.JLabelFormat;
import views.body.offerSection.JMBSpecificOfferMenuBar;
import views.body.offerSection.JPSpecificOfferSection;

import java.awt.*;
import java.util.ArrayList;

public class JPCenterLeavingFromYopalSection extends JPSpecificOfferSection {

	private static final long serialVersionUID = 1L;
	
    public static final String LEAVING_FROM_YOPAL_TITLE_TEXT = "SALIENDO DESDE YOPAL";

    public static final String LEAVING_FROM_YOPAL_SUBTITLE_TEXT_BOLD = "Vuelos baratos";
    public static final String LEAVING_FROM_YOPAL_SUBTITLE_TEXT_PAIN = " con las mejores aereol"+ ConstantsGUI.LOWERCASE_ACCENTED_I +"neas";

    public static final String TRAVEL_SECTION_NAME = "VUELOS";
    public static final String ROUND_TRIP_FROM_TEXT = "Ida y vuelta desde";

    public static final String TRAVEL_SAN_ANDRES_ICON_PATH = "resources/img/ViajeASanAndres.png";
    public static final String TRAVEL_SAN_ANDRES_PRODUCT_NAME = "Viaja a San Andr"+ ConstantsGUI.LOWERCASE_ACCENTED_E +"s";
    public static final String TRAVEL_SAN_ANDRES_SPECIFIC_INFORMATION = "Con 1 escala por LATAM Colombia";
    public static final String TRAVEL_SAN_ANDRES_LABEL_SERVICE_TEXT = "Incluye equipaje en bodega";
    public static final double TRAVEL_SAN_ANDRES_COST = 634592;

    public static final String TRAVEL_SANTA_MARTA_ICON_PATH = "resources/img/ViajeASantaMarta.png";
    public static final String TRAVEL_SANTA_MARTA_PRODUCT_NAME = "Viaja a Santa Marta";
    public static final String TRAVEL_SANTA_MARTA_SPECIFIC_INFORMATION = "Con 1 escala por LATAM Colombia";
    public static final double TRAVEL_SANTA_MARTA_COST = 610771;

    public static final String TRAVEL_CARTAGENA_ICON_PATH = "resources/img/ViajeACartagenaDeIndias.png";
    public static final String TRAVEL_CARTAGENA_PRODUCT_NAME = "<html>Viaja a Cartagena de <br>Indias</html>";
    public static final String TRAVEL_CARTAGENA_SPECIFIC_INFORMATION = "Con 1 escala por Avianca";
    public static final String TRAVEL_CARTAGENA_LABEL_SERVICE_TEXT = "Incluye equipaje en bodega";
    public static final double TRAVEL_CARTAGENA_COST = 647138;

    public static final String TRAVEL_MEDELLIN_ICON_PATH = "resources/img/ViajeAMedellin.png";
    public static final String TRAVEL_MEDELLIN_PRODUCT_NAME = "Viaja a Medell"+ ConstantsGUI.LOWERCASE_ACCENTED_I +"n";
    public static final String TRAVEL_MEDELLIN_SPECIFIC_INFORMATION = "Con 1 escala por LATAM Colombia";
    public static final String TRAVEL_MEDELLIN_LABEL_SERVICE_TEXT = "Incluye equipaje de mano";
    public static final double TRAVEL_MEDELLIN_COST = 464944;

    @Override
    protected void addSectionTitle(){
        JLabelFormat leavingFromYopalTitle = new JLabelFormat(LEAVING_FROM_YOPAL_TITLE_TEXT, TITLE_FONT, TITLE_FOREGROUND);
        JLabelFormat leavingFromYopalSubtitle1 = new JLabelFormat(LEAVING_FROM_YOPAL_SUBTITLE_TEXT_BOLD, SUBTITLE_FONT_BOLD, SUBTITLE_FOREGROUND);
        JLabelFormat leavingFromYopalSubtitle2 = new JLabelFormat(LEAVING_FROM_YOPAL_SUBTITLE_TEXT_PAIN, SUBTITLE_FONT_PLAIN, SUBTITLE_FOREGROUND);
        this.add(leavingFromYopalTitle,BorderLayout.NORTH);
        this.add(leavingFromYopalSubtitle1,BorderLayout.WEST);
        this.add(leavingFromYopalSubtitle2,BorderLayout.CENTER);
    }

    @Override
    protected void addSpecificOfferMenuBar(){

        JBRoundButton travelSanAndresPanel = this.getSpecificProductOffer(TRAVEL_SAN_ANDRES_ICON_PATH,TRAVEL_SECTION_NAME,TRAVEL_SAN_ANDRES_PRODUCT_NAME,ROUND_TRIP_FROM_TEXT,TRAVEL_SAN_ANDRES_SPECIFIC_INFORMATION, TRAVEL_SAN_ANDRES_LABEL_SERVICE_TEXT, TRAVEL_SAN_ANDRES_COST);
        JBRoundButton travelSantaMartaPanel = this.getSpecificProductOffer(TRAVEL_SANTA_MARTA_ICON_PATH,TRAVEL_SECTION_NAME,TRAVEL_SANTA_MARTA_PRODUCT_NAME,ROUND_TRIP_FROM_TEXT,TRAVEL_SANTA_MARTA_SPECIFIC_INFORMATION,TRAVEL_SANTA_MARTA_COST);
        JBRoundButton travelCartagenaPanel = this.getSpecificProductOffer(TRAVEL_CARTAGENA_ICON_PATH,TRAVEL_SECTION_NAME,TRAVEL_CARTAGENA_PRODUCT_NAME,ROUND_TRIP_FROM_TEXT,TRAVEL_CARTAGENA_SPECIFIC_INFORMATION,TRAVEL_CARTAGENA_LABEL_SERVICE_TEXT,TRAVEL_CARTAGENA_COST);
        JBRoundButton travelMedellinPanel = this.getSpecificProductOffer(TRAVEL_MEDELLIN_ICON_PATH,TRAVEL_SECTION_NAME,TRAVEL_MEDELLIN_PRODUCT_NAME,ROUND_TRIP_FROM_TEXT,TRAVEL_MEDELLIN_SPECIFIC_INFORMATION,TRAVEL_MEDELLIN_LABEL_SERVICE_TEXT,TRAVEL_MEDELLIN_COST);

        ArrayList<JBRoundButton> specificOfferList = new ArrayList<>();
        specificOfferList.add(travelSanAndresPanel);
        specificOfferList.add(travelSantaMartaPanel);
        specificOfferList.add(travelCartagenaPanel);
        specificOfferList.add(travelMedellinPanel);

        this.add(new JMBSpecificOfferMenuBar(specificOfferList),BorderLayout.SOUTH);
    }
}