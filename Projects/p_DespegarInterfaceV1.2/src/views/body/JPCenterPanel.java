package views.body;

import views.ConstantsGUI;
import views.body.offerSection.rentACarSection.JPCenterRentACarSection;
import views.body.offerSection.leavingFromYopalSection.JPCenterLeavingFromYopalSection;
import views.body.offerSection.apartmentAndHousingSection.JPCenterApartmentAndHousingSection;
import views.body.offerSection.JPCenterOfferPanel;

import javax.swing.*;

public class JPCenterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    public JPCenterPanel(){
        this.setBackground(ConstantsGUI.COLOR_DESPEGAR_ULTRA_LIGHT_GRAY);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.initComponents();
    }

    public void initComponents(){
        this.add(new JPCenterSelectionPanel());
        this.add(new JPCenterOfferPanel());
        this.add(new JPInstallmentsTripSection());
        this.add(new JPCenterLeavingFromYopalSection());
        this.add(new JPCenterApartmentAndHousingSection());
        this.add(new JPCenterRentACarSection());

    }
}
