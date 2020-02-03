package views.body;

import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.JPanel;

public class JPanelGraphicBarChart extends JPanel {

	private static final long serialVersionUID = 1L;

	JPanelGraphicBarChart(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setOpaque(false);
	}

	JPanelGraphicBarChart(HashMap<String, Double> info, String name){
		this();
		this.add(new JPBarGraphicPanel(info, name));
	}

	public void addGraphic(HashMap<String, Double> info, String name){
		this.add(new JPBarGraphicPanel(info, name));
	}
}