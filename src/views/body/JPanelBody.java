package views.body;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import views.ConstantsGUI;


public class JPanelBody extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private CardLayout layout;
	private JPanelPresentation panelPresentation;
	private JPanelTable table;
	private JPanel grafica;
	
	public JPanelBody() {
		this.layout = new CardLayout();
		setLayout(layout);
        this.setOpaque(false);
        initComponents();
        this.setVisible(true);
	}
	
	private void initComponents() {
		panelPresentation = new JPanelPresentation();
		this.add(panelPresentation,ConstantsGUI.PANEL_PRESENTATION);
		table = new JPanelTable();
		this.add(table,ConstantsGUI.PANEL_TABLE);
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
		table.showTableCultives(info);
	}
	
	public void showCardImage(String key){
        switch(key){
            case ConstantsGUI.PANEL_PRESENTATION:
                this.layout.show(this, ConstantsGUI.PANEL_PRESENTATION);
                break;
            case ConstantsGUI.PANEL_TABLE:
                this.layout.show(this, ConstantsGUI.PANEL_TABLE);
				break;
				case ConstantsGUI.PANEL_GRAFICA:
                this.layout.show(this, ConstantsGUI.PANEL_GRAFICA);
                break;
            default:
                break;
        }
    }

}
