package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JFramePpal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int) SCREEN_SIZE.getWidth();
    public static final int HEIGHT = (int) SCREEN_SIZE.getHeight();

    public static final String ICON_PATH = "resources/img/RunnerIcon.png";
    public static final String FRAME_TITLE_TEXT = "Algo App";

    private JPMainPanel mainPanel;

    public JFramePpal(ActionListener act){
        super(FRAME_TITLE_TEXT);
        this.setMinimumSize(new Dimension(WIDTH/*1250*/,HEIGHT/*400*/));
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(ICON_PATH).getImage());
        this.initComponents(act);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initComponents(ActionListener act){
        this.mainPanel = new JPMainPanel(act);
        this.add(this.mainPanel);
        this.addScrollBar();
    }

    public void addScrollBar(){
        JScrollPane scrollPane = new JScrollPane(this.mainPanel);
        scrollPane.getVerticalScrollBar().setUI(new JScrollFormat());
        scrollPane.getHorizontalScrollBar().setUI(new JScrollFormat());
        this.add(scrollPane);
    }
    
    public void showTable(ArrayList<Object[]> dataList, TableHeader tableHeader){
    	this.mainPanel.showAlgoTable(dataList, tableHeader);
    }

    public void showErrorMessage(ErrorMessage error){
        JOptionMessage.showErrorMessage(error);
    }
}