package views.body;

import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.JPanel;

public class JPanelGraphicReports extends JPanel {

	private static final long serialVersionUID = 1L;

	JPanelGraphicReports(HashMap<String, Double> info, String graphicTitle){
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setOpaque(false);
		this.add(new JPBarGraphicPanel(info, graphicTitle));
	}
}