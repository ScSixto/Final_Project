package views.body.offerSection;

import views.JBRoundButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JMBSpecificOfferMenuBar extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
    public JMBSpecificOfferMenuBar(ArrayList<JBRoundButton> specificOfferList){
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        layout.setHgap(20);
        this.setLayout(layout);
        this.setOpaque(false);

        this.setBorder(BorderFactory.createEmptyBorder(0,-20,0,0));
        this.initComponents(specificOfferList);
    }

    private void initComponents(ArrayList<JBRoundButton> specificOfferList){
        for(JBRoundButton specificOfferFormat: specificOfferList){
            this.add(specificOfferFormat);
        }
    }
}
