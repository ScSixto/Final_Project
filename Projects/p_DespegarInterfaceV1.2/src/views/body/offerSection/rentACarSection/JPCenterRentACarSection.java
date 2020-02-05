package views.body.offerSection.rentACarSection;

import views.ConstantsGUI;
import views.JBRoundButton;
import views.JLabelFormat;
import views.body.offerSection.JMBSpecificOfferMenuBar;

import views.body.offerSection.JPSpecificOfferSection;

import java.awt.*;
import java.util.ArrayList;

public class JPCenterRentACarSection extends JPSpecificOfferSection {

	private static final long serialVersionUID = 1L;
	
        public static final String RENT_A_CAR_TITLE_TEXT = "RENT A CAR";

        public static final String RENT_A_CAR_SUBTITLE_TEXT_BOLD = "Renta de carros y camionetas";
        public static final String RENT_A_CAR_SUBTITLE_TEXT_PAIN = " para tus viajes";

        public static final String CAR_SECTION_NAME = "CARROS";
        public static final String FINAL_DAY_COST_TEXT = "Precio final por d"+ConstantsGUI.LOWERCASE_ACCENTED_I+"a";

        public static final String DRIVE_IN_SANTA_MARTA_ICON_PATH = "resources/img/ManejaEnSantaMarta.png";
        public static final String DRIVE_IN_SANTA_MARTA_PRODUCT_NAME = "<html>Maneja en Santa<br>Marta</html>";
        public static final double DRIVE_IN_SANTA_MARTA_COST = 98018;

        public static final String DRIVE_IN_CARTAGENA_ICON_PATH = "resources/img/ManejaEnCartagenaDeIndias.png";
        public static final String DRIVE_IN_CARTAGENA_PRODUCT_NAME = "<html>Maneja en Cartagena<br>de Indias</html>";
        public static final double DRIVE_IN_CARTAGENA_COST = 89992;

        public static final String DRIVE_IN_CANCUN_ICON_PATH = "resources/img/ManejaEnCancun.png";
        public static final String DRIVE_IN_CANCUN_PRODUCT_NAME = "Maneja en Canc"+ ConstantsGUI.LOWERCASE_ACCENTED_U +"n";
        public static final double DRIVE_IN_CANCUN_COST = 30166;
        public static final double DRIVE_IN_CANCUN_BEFORE_COST = 60332;
        public static final double DRIVE_IN_CANCUN_DISCOUNT_PERCENT = 100-(DRIVE_IN_CANCUN_COST*100/DRIVE_IN_CANCUN_BEFORE_COST);

        public static final String DRIVE_IN_ARUBA_ICON_PATH = "resources/img/ManejaEnAruba.png";
        public static final String DRIVE_IN_ARUBA_PRODUCT_NAME = "Maneja en Aruba";
        public static final double DRIVE_IN_ARUBA_COST = 142941;

        @Override
        protected void addSectionTitle(){
            JLabelFormat leavingFromYopalTitle = new JLabelFormat(RENT_A_CAR_TITLE_TEXT, TITLE_FONT, TITLE_FOREGROUND);
            JLabelFormat leavingFromYopalSubtitle1 = new JLabelFormat(RENT_A_CAR_SUBTITLE_TEXT_BOLD, SUBTITLE_FONT_BOLD, SUBTITLE_FOREGROUND);
            JLabelFormat leavingFromYopalSubtitle2 = new JLabelFormat(RENT_A_CAR_SUBTITLE_TEXT_PAIN, SUBTITLE_FONT_PLAIN, SUBTITLE_FOREGROUND);
            this.add(leavingFromYopalTitle,BorderLayout.NORTH);
            this.add(leavingFromYopalSubtitle1,BorderLayout.WEST);
            this.add(leavingFromYopalSubtitle2,BorderLayout.CENTER);
        }

        @Override
        protected void addSpecificOfferMenuBar(){
            JBRoundButton driveInSantaMartaPanel = this.getSpecificProductOffer(DRIVE_IN_SANTA_MARTA_ICON_PATH,CAR_SECTION_NAME,DRIVE_IN_SANTA_MARTA_PRODUCT_NAME,FINAL_DAY_COST_TEXT,DRIVE_IN_SANTA_MARTA_COST);
            JBRoundButton driveInCartagenaPanel = this.getSpecificProductOffer(DRIVE_IN_CARTAGENA_ICON_PATH,CAR_SECTION_NAME,DRIVE_IN_CARTAGENA_PRODUCT_NAME,FINAL_DAY_COST_TEXT,DRIVE_IN_CARTAGENA_COST);
            JBRoundButton driveInCancunPanel = this.getSpecificProductOffer(DRIVE_IN_CANCUN_ICON_PATH,CAR_SECTION_NAME,DRIVE_IN_CANCUN_PRODUCT_NAME,FINAL_DAY_COST_TEXT,DRIVE_IN_CANCUN_COST,DRIVE_IN_CANCUN_BEFORE_COST,DRIVE_IN_CANCUN_DISCOUNT_PERCENT);
            JBRoundButton driveInArubaPanel = this.getSpecificProductOffer(DRIVE_IN_ARUBA_ICON_PATH,CAR_SECTION_NAME,DRIVE_IN_ARUBA_PRODUCT_NAME,FINAL_DAY_COST_TEXT,DRIVE_IN_ARUBA_COST);

            ArrayList<JBRoundButton> specificOfferList = new ArrayList<>();
            specificOfferList.add(driveInSantaMartaPanel);
            specificOfferList.add(driveInCartagenaPanel);
            specificOfferList.add(driveInCancunPanel);
            specificOfferList.add(driveInArubaPanel);

            this.add(new JMBSpecificOfferMenuBar(specificOfferList),BorderLayout.SOUTH);
    }
}