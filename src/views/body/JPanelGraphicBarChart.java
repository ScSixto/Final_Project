package views.body;

import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.JPanel;

public class JPanelGraphicBarChart extends JPanel {

	private static final long serialVersionUID = 1L;

	JPanelGraphicBarChart(HashMap<String, Double> info){
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(new JPGraphicPanel(info));
	}
}
