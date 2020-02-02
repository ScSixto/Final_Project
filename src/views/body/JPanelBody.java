package views.body;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import views.ConstantsGUI;


public class JPanelBody extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private CardLayout layout;
	private JPanelInitiation panelInitial;
	private JPanelTable table;
	private JPanelTableReports panelTableReports;
	private JPanelGraphicReports panelGraphicReports;
	private JPanel grafica;
	
	public JPanelBody(ActionListener actionListener) {
		this.layout = new CardLayout();
		setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		setLayout(layout);
        this.setOpaque(false);
        initComponents(actionListener);
        this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		panelInitial = new JPanelInitiation();
		this.add(panelInitial,ConstantsGUI.PANEL_INITIAL);
		table = new JPanelTable();
		this.add(table,ConstantsGUI.PANEL_TABLE);
		panelTableReports = new JPanelTableReports();
		this.add(panelTableReports,ConstantsGUI.PANEL_TABLE_REPORTS);
		panelGraphicReports = new JPanelGraphicReports();
		this.add(panelGraphicReports,ConstantsGUI.PANEL_GRAPHIC_REPORTS);
	}
	
	public void addGraphicPanel(HashMap<String, Double> cols){
		grafica = new JPanel();
		grafica.setLayout(new FlowLayout(FlowLayout.CENTER));
		grafica.add(new JPGraphicPanel(cols));
		this.add(grafica, ConstantsGUI.PANEL_GRAFICA);
	}
	
	public void changeLanguage(){
		panelPresentation.changeLanguage();
		table.changeLanguageTableCultives();
	}
	
	public void showTableCultives(HashMap<String, ArrayList<Object[]>> info) {
		panelInitial.showTableCultives(info);
	}
	
	public void showCardImage(String key){
        switch(key){
            case ConstantsGUI.PANEL_INITIAL:
                this.layout.show(this, ConstantsGUI.PANEL_INITIAL);
                break;
            case ConstantsGUI.PANEL_TABLE:
                this.layout.show(this, ConstantsGUI.PANEL_TABLE);
				break;
				case ConstantsGUI.PANEL_GRAFICA:
                this.layout.show(this, ConstantsGUI.PANEL_GRAFICA);
                break;
            case ConstantsGUI.PANEL_TABLE_REPORTS:
                this.layout.show(this, ConstantsGUI.PANEL_TABLE_REPORTS);
                break;
            case ConstantsGUI.PANEL_GRAPHIC_REPORTS:
                this.layout.show(this, ConstantsGUI.PANEL_GRAPHIC_REPORTS);
                break;
        }
    }

}
