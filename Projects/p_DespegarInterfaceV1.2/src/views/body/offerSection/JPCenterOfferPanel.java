package views.body.offerSection;

import views.ConstantsGUI;
import views.JBRoundButton;
import views.JLabelFormat;

import javax.swing.*;
import java.awt.*;

public class JPCenterOfferPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static final String CENTER_OFFER_PANEL = "Ofertas que no te pudes perder";
	public static final String OFFER_IMAGE_PATH_1 = "resources/img/DestinosVendidos.png";
	public static final String OFFER_IMAGE_PATH_2 = "resources/img/AhorraComprandoPaquetes.png";
	public static final String OFFER_IMAGE_PATH_3 = "resources/img/AlojamientosPreciosEspeciales.png";

	public JPCenterOfferPanel(){
        //this.setPreferredSize(new Dimension(WIDTH,392));
        this.setBackground(ConstantsGUI.COLOR_DESPEGAR_ULTRA_LIGHT_GRAY);
        this.setOpaque(true);

        BorderLayout layout = new BorderLayout();
        layout.setVgap(20);
        this.setLayout(layout);
        this.initComponents();
        this.setBorder(BorderFactory.createEmptyBorder(70, 70, 35, 70));
    }
	
	private void initComponents(){
		addPanelTitle();
		addOfferButtonPanel();
	}
	
	private void addPanelTitle(){
		JLabelFormat title = new JLabelFormat(CENTER_OFFER_PANEL, new Font("arial",Font.BOLD,24), ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_2);
		this.add(title,BorderLayout.WEST);
	}
	
	private void addOfferButtonPanel() {
		JPanel offerButtonPanel = new JPanel();
		FlowLayout flowLayaout = new FlowLayout(FlowLayout.LEFT);
		offerButtonPanel.setLayout(flowLayaout);
		flowLayaout.setHgap(34);

		offerButtonPanel.setBorder(BorderFactory.createEmptyBorder(0,-34,0,0));

		JBRoundButton offer1 = new JBRoundButton(OFFER_IMAGE_PATH_1,new Dimension(617,270));
		JBRoundButton offer2 = new JBRoundButton(OFFER_IMAGE_PATH_2,new Dimension(297,270));
		JBRoundButton offer3 = new JBRoundButton(OFFER_IMAGE_PATH_3,new Dimension(297,270));

		offerButtonPanel.add(offer1);
		offerButtonPanel.add(offer2);
		offerButtonPanel.add(offer3);
		this.add(offerButtonPanel,BorderLayout.SOUTH);
	}
}