package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPTablePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel dtmElements;
	private JTable jtElement;
	private JScrollPane jsTable;
	
	public JPTablePanel() {
		this.initComponents();
	}
	
	private void initComponents(){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBackground(Color.decode("#30373D"));
		String[] headers = {"CATEGORIA","CATEGORIA","CATEGORIA","CATEGORIA"};
		dtmElements = new DefaultTableModel();
		dtmElements.setColumnIdentifiers(headers);
		
		Font fontHeader = new Font("Franklin Gothic Deml", Font.ITALIC,14);
		
		jtElement = new JTable();
		jtElement.setModel(dtmElements);
		jtElement.getTableHeader().setReorderingAllowed(false);
		jtElement.getTableHeader().setBackground(Color.decode("#282E33"));
		jtElement.getTableHeader().setForeground(Color.white);
		jtElement.getTableHeader().setFont(fontHeader);
		jtElement.setBackground(Color.white);
		jtElement.setFillsViewportHeight(true);
		jtElement.setBorder(null);
		
		jsTable = new JScrollPane(jtElement);
		jsTable.setForeground(Color.white);
		jsTable.setBorder(null);
		jsTable.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(jsTable, BorderLayout.PAGE_END);
		this.setBorder(null);
	}
}
