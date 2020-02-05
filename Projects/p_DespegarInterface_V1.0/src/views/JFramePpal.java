package views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFramePpal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JFramePpal(){
		setMinimumSize(new Dimension(1400,600));
		getContentPane().setBackground(Color.WHITE);
		initComponents();
		setIconImage(new ImageIcon("resources/img/DespegarIcono.png").getImage());
		setVisible(true);
	}
	
	public void initComponents() {
		JPMainPanel panel = new JPMainPanel();
		add(panel,BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new JFramePpal();
	}
}
