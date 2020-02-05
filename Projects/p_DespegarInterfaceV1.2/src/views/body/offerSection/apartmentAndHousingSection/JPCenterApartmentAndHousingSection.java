package views.body.offerSection.apartmentAndHousingSection;

import views.ConstantsGUI;
import views.JBRoundButton;
import views.JLabelFormat;
import views.body.offerSection.JMBSpecificOfferMenuBar;
import views.body.offerSection.JPSpecificOfferSection;

import java.awt.*;
import java.util.ArrayList;

public class JPCenterApartmentAndHousingSection extends JPSpecificOfferSection {

	private static final long serialVersionUID = 1L;
	
    public static final String APARTMENT_AND_HOUSING_TITLE_TEXT = "APARTAMENTOS Y ALOJAMIENTOS";

    public static final String APARTMENT_AND_HOUSING_SUBTITLE_TEXT_BOLD = "Hoteles Baratos";
    public static final String APARTMENT_AND_HOUSING_SUBTITLE_TEXT_PAIN = " reserva el mejor alojamiento";

    public static final String HOUSING_SECTION_NAME = "ALOJAMIENTOS";
    public static final String NIGTH_COST_WITH_TAXES_TEXT = "Precio por noche con impuestos desde";

    public static final String STAY_SAN_ANDRES_ICON_PATH = "resources/img/EstadiaEnSanAndres.png";
    public static final String STAY_SAN_ANDRES_PRODUCT_NAME = "<html>Estad"+ ConstantsGUI.LOWERCASE_ACCENTED_I +"a en San<br>Andr"+ ConstantsGUI.LOWERCASE_ACCENTED_E +"s</html>";
    public static final String STAY_SAN_ANDRES_LABEL_SERVICE_TEXT = "All inclusive";
    public static final double STAY_SAN_ANDRES_COST = 573628;
    public static final double STAY_SAN_ANDRES_BEFORE_COST = 796706;
    public static final double STAY_SAN_ANDRES_DISCOUNT_PERCENT = 100-(STAY_SAN_ANDRES_COST*100/STAY_SAN_ANDRES_BEFORE_COST);
    public static final double STAY_SAN_ANDRES_RATING_VALUE = 7.6;

    public static final String STAY_SANTA_MARTA_ICON_PATH = "resources/img/EstadiaEnSantaMarta.png";
    public static final String STAY_SANTA_MARTA_PRODUCT_NAME = "<html>Estad"+ ConstantsGUI.LOWERCASE_ACCENTED_I +"a en Santa<br>Marta</html>";
    public static final String STAY_SANTA_MARTA_LABEL_SERVICE_TEXT = "Desayuno buffet";
    public static final double STAY_SANTA_MARTA_COST = 269780;
    public static final double STAY_SANTA_MARTA_BEFORE_COST = 329000;
    public static final double STAY_SANTA_MARTA_DISCOUNT_PERCENT = 100-(STAY_SANTA_MARTA_COST*100/STAY_SANTA_MARTA_BEFORE_COST);
    public static final double STAY_SANTA_MARTA_RATING_VALUE = 8.7;

    public static final String STAY_CARTAGENA_ICON_PATH = "resources/img/EstadiaEnCartagenaDeIndias.png";
    public static final String STAY_CARTAGENA_PRODUCT_NAME = "<html>Estad"+ ConstantsGUI.LOWERCASE_ACCENTED_I +"a en<br>Cartagena de Indias</html>";
    public static final String STAY_CARTAGENA_LABEL_SERVICE_TEXT = "Desayuno buffet";
    public static final double STAY_CARTAGENA_COST = 362050;
    public static final double STAY_CARTAGENA_BEFORE_COST = 557000;
    public static final double STAY_CARTAGENA_DISCOUNT_PERCENT = 100-(STAY_CARTAGENA_COST*100/STAY_CARTAGENA_BEFORE_COST);
    public static final double STAY_CARTAGENA_RATING_VALUE = 8.7;

    public static final String STAY_VILLA_DE_LEYVA_ICON_PATH = "resources/img/EstadiaEnVillaDeLeyva.png";
    public static final String STAY_VILLA_DE_LEYVA_PRODUCT_NAME = "<html>Estad"+ ConstantsGUI.LOWERCASE_ACCENTED_I +"a en Villa de<br>Leyva</html>";
    public static final String STAY_VILLA_DE_LEYVA_LABEL_SERVICE_TEXT = "Desayuno continental";
    public static final double STAY_VILLA_DE_LEYVA_COST = 151984;

    @Override
    protected void addSectionTitle(){
        JLabelFormat leavingFromYopalTitle = new JLabelFormat(APARTMENT_AND_HOUSING_TITLE_TEXT, TITLE_FONT, TITLE_FOREGROUND);
        JLabelFormat leavingFromYopalSubtitle1 = new JLabelFormat(APARTMENT_AND_HOUSING_SUBTITLE_TEXT_BOLD, SUBTITLE_FONT_BOLD, SUBTITLE_FOREGROUND);
        JLabelFormat leavingFromYopalSubtitle2 = new JLabelFormat(APARTMENT_AND_HOUSING_SUBTITLE_TEXT_PAIN, SUBTITLE_FONT_PLAIN, SUBTITLE_FOREGROUND);
        this.add(leavingFromYopalTitle,BorderLayout.NORTH);
        this.add(leavingFromYopalSubtitle1,BorderLayout.WEST);
        this.add(leavingFromYopalSubtitle2,BorderLayout.CENTER);
    }

    @Override
    protected void addSpecificOfferMenuBar(){
        JBRoundButton travelSanAndresPanel = this.getSpecificProductOffer(STAY_SAN_ANDRES_ICON_PATH,HOUSING_SECTION_NAME,STAY_SAN_ANDRES_PRODUCT_NAME,STAY_SAN_ANDRES_LABEL_SERVICE_TEXT,STAY_SAN_ANDRES_RATING_VALUE,NIGTH_COST_WITH_TAXES_TEXT,STAY_SAN_ANDRES_COST,STAY_SAN_ANDRES_BEFORE_COST,STAY_SAN_ANDRES_DISCOUNT_PERCENT);
        JBRoundButton travelSantaMartaPanel = this.getSpecificProductOffer(STAY_SANTA_MARTA_ICON_PATH,HOUSING_SECTION_NAME,STAY_SANTA_MARTA_PRODUCT_NAME,STAY_SANTA_MARTA_LABEL_SERVICE_TEXT,STAY_SANTA_MARTA_RATING_VALUE,NIGTH_COST_WITH_TAXES_TEXT,STAY_SANTA_MARTA_COST,STAY_SANTA_MARTA_BEFORE_COST,STAY_SANTA_MARTA_DISCOUNT_PERCENT);
        JBRoundButton travelCartagenaPanel = this.getSpecificProductOffer(STAY_CARTAGENA_ICON_PATH,HOUSING_SECTION_NAME,STAY_CARTAGENA_PRODUCT_NAME,STAY_CARTAGENA_LABEL_SERVICE_TEXT,STAY_CARTAGENA_RATING_VALUE,NIGTH_COST_WITH_TAXES_TEXT,STAY_CARTAGENA_COST, STAY_CARTAGENA_BEFORE_COST, STAY_CARTAGENA_DISCOUNT_PERCENT);
        JBRoundButton travelVillaDeLeyvaPanel = this.getSpecificProductOffer(STAY_VILLA_DE_LEYVA_ICON_PATH,HOUSING_SECTION_NAME,STAY_VILLA_DE_LEYVA_PRODUCT_NAME,NIGTH_COST_WITH_TAXES_TEXT,STAY_VILLA_DE_LEYVA_COST,STAY_VILLA_DE_LEYVA_LABEL_SERVICE_TEXT);

        ArrayList<JBRoundButton> specificOfferList = new ArrayList<JBRoundButton>();
        specificOfferList.add(travelSanAndresPanel);
        specificOfferList.add(travelSantaMartaPanel);
        specificOfferList.add(travelCartagenaPanel);
        specificOfferList.add(travelVillaDeLeyvaPanel);

        this.add(new JMBSpecificOfferMenuBar(specificOfferList),BorderLayout.SOUTH);
    }
}