package views.body;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import java.awt.Color;

import views.ConstantsGUI;

public class JPGraphicPanel extends JPanel {

    private static final long serialVersionUID = 1L;

	private GroupLayout layout;
	private JPYAxisBarGraphic yAxisPanel;
	private JPXAxisBarGraphic xAxisPanel;
	private JPanel graphicBarPanel;
	private JPBarGraphicInformation panelInformation;


    public JPGraphicPanel() {
        this.layout = new GroupLayout(this);
		this.setLayout(layout);
		this.setOpaque(false);
    }

    public JPGraphicPanel(HashMap<String, Double> cols){
		this();
		//this.setMaximumSize(new Dimension(ConstantsGUI.Y_AXIS_LABEL_WIDTH + ConstantsGUI.AXIS_LINE_WIDTH + (ConstantsGUI.MAX_PIXEL_COL_WIDTH_VALUE * UtilView.getHasMapValues(cols).size()) + ((ConstantsGUI.COL_SEPARATION -1) * UtilView.getHasMapValues(cols).size()),ConstantsGUI.MAX_PIXEL_COL_HEIGHT_VALUE + ConstantsGUI.AXIS_LINE_WIDTH));
		this.initComponents(cols);
		this.setVisible(true);
    }

	private void initComponents(HashMap<String, Double> cols){
        this.setYAxis(UtilView.getHasMapValues(cols));
        this.setXAxis(UtilView.getHasMapValues(cols).size());
        this.setGraphicBarPanel(cols);
        this.addPanelList();
    }

    private void addPanelList() {
		layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addGroup(layout.createSequentialGroup().addComponent(yAxisPanel).addComponent(graphicBarPanel)).addComponent(xAxisPanel)).addComponent(this.panelInformation));
		layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup().addComponent(yAxisPanel).addComponent(graphicBarPanel)).addComponent(xAxisPanel)).addComponent(this.panelInformation));
	}

	private void setYAxis(ArrayList<Double> values) {
        this.yAxisPanel = new JPYAxisBarGraphic(values);
    }

    private void setXAxis(int colsQuantity){
        this.xAxisPanel = new JPXAxisBarGraphic(colsQuantity);
    }

    private void setGraphicBarPanel(HashMap<String, Double> cols){
        JPanel graphicBarPanel = this.getGraphicBarPanelFormat();
		HashMap<String, Color> columnInformation = new HashMap<>();
		Iterator<Entry<String,Double>> it = UtilView.getPercentValues(cols).entrySet().iterator();
		Color color;
		while(it.hasNext()) {
			Entry<String,Double> column = it.next();
			color = UtilView.getRandomColor();
			columnInformation.put(column.getKey(), color);
            graphicBarPanel.add(new JPColumnPanel(column.getKey(), column.getValue(), color));
        }
		this.graphicBarPanel = graphicBarPanel;
		this.setPanelInformation(columnInformation);
	}
	
	private void setPanelInformation(HashMap<String, Color> columnInformation) {
		this.panelInformation = new JPBarGraphicInformation(columnInformation);
	}

	public JPanel getGraphicBarPanelFormat() {
		JPanel graphicBarPanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setHgap(ConstantsGUI.COL_SEPARATION);
        flowLayout.setVgap(0);
        graphicBarPanel.setLayout(flowLayout);
		graphicBarPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		graphicBarPanel.setOpaque(false);
		return graphicBarPanel;
	}
}