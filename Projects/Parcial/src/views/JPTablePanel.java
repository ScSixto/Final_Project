package views;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPTablePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public static final Font DEFAULT_TABLE_FONT = new Font("Franklin Gothic Deml", Font.ITALIC,14);
	public static final Color DEFAULT_HEADERS_FOREGROUND = Color.white;
	public static final Color DEFAULT_HEADERS_BACKGROUND = Color.decode("#282E33");
	public static final Color DEFAULT_TABLE_BACKGROUND = Color.white;

    private DefaultTableModel dtmElements;
	private JTable jtElement;
	private JScrollPane jsTable;

	public JPTablePanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBackground(Color.decode("#30373D"));
		this.setOpaque(false);
        this.setMaximumSize(new Dimension(WIDTH,300));
//        this.setPreferredSize(new Dimension(WIDTH,200));
		this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.initComponents();
	}
	
	private void initComponents(){
	    this.setJTableComponents();
	}

	private void setJTableComponents(){
		dtmElements = new DefaultTableModel();
//	    this.setTableModel(DEFAULT_TABLE_HEADER);
		this.addTable();
//        this.setColsWidth(DEFAULT_TABLE_HEADER);
        this.addTableScroll();
    }

    public void setJTableComponents(TableHeader tableHeader){
	    this.removeAll();
        this.setTableModel(tableHeader);
        this.addTable();
        this.setColsWidth(tableHeader);
        this.addTableScroll();
    }

    private void setTableModel(TableHeader tableHeader){
        dtmElements = new DefaultTableModel();
        dtmElements.setColumnIdentifiers(tableHeader.getHeaderTextArray());
    }

    private void setColsWidth(TableHeader tableHeader){
        for(int i = 0; i < tableHeader.getHeaderColsWidthArray().length; i++){
            jtElement.getColumnModel().getColumn(i).setPreferredWidth(tableHeader.getHeaderColsWidthArray()[i]);
        }
    }

	private void addTable(){
        jtElement = new JTable();
        jtElement.setModel(dtmElements);
        jtElement.getTableHeader().setReorderingAllowed(true);
        jtElement.getTableHeader().setBackground(DEFAULT_HEADERS_BACKGROUND);
        jtElement.getTableHeader().setForeground(DEFAULT_HEADERS_FOREGROUND);
        jtElement.getTableHeader().setFont(DEFAULT_TABLE_FONT);
        jtElement.setBackground(DEFAULT_TABLE_BACKGROUND);
        jtElement.setFillsViewportHeight(true);
        jtElement.setBorder(BorderFactory.createEmptyBorder());
        jtElement.setEnabled(false);
        jtElement.setRowHeight(30);
        jtElement.setShowVerticalLines(false);
        this.add(jtElement);
    }

    private void addTableScroll(){
        jsTable = new JScrollPane(jtElement);
        jsTable.getVerticalScrollBar().setUI(new JScrollFormat());
        jsTable.getHorizontalScrollBar().setUI(new JScrollFormat());
        jsTable.setBorder(null);
        this.add(jsTable, BorderLayout.PAGE_END);
    }

	public void addRow(Object[] row){
		dtmElements.addRow(row);
	}

	public void addRowList(ArrayList<Object[]> rowList){
		for (Object[] row : rowList){
			this.addRow(row);
		}
	}
}