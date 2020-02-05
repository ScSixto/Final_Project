package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JFramePpal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int) SCREEN_SIZE.getWidth();
    public static final int HEIGHT = (int) SCREEN_SIZE.getHeight();

    public static final String DESPEGAR_ICON_PATH = "resources/img/Despegar.png";
    public static final String FRAME_TITLE_TEXT = "Despegar";

    private JPMainPanel mainPanel;

    public JFramePpal(ActionListener act){
        super(FRAME_TITLE_TEXT);
        this.setMinimumSize(new Dimension(1250/*1250*/,400/*400*/));
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(DESPEGAR_ICON_PATH).getImage());
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

//    public static void main(String[] args) {
//        new JFramePpal();
//    }
}