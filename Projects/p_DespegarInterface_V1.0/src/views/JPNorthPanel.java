package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPNorthPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelContainerNorth;
	private JMBMainMenuBar panelMenu;
	private JButton menuLogo;

	public JPNorthPanel() {
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		setLayout(layout);
		layout.setHgap(10);
		layout.setVgap(1);
		setOpaque(true);
		addLogo();
		showMainMenu();
	}

	private void addLogo() {
		panelContainerNorth = new JPanel();
		panelContainerNorth.setOpaque(false);

		ImageIcon originalImage = new ImageIcon("resources/img/Despegar.png");// getClass().getResource("/mama.png"));
		ImageIcon scaleIcon = new ImageIcon(
				originalImage.getImage().getScaledInstance(65, 65, java.awt.Image.SCALE_DEFAULT));
		menuLogo = new JButton("despegar");
		menuLogo.setForeground(ConstantsGUI.DESPEGAR_DARK_PURPLE);
		menuLogo.setFont(new Font("Bahnschrift Light", Font.BOLD, 30));

		menuLogo.setBorderPainted(false);
		menuLogo.setFocusable(false);
		menuLogo.setIcon(scaleIcon);
		menuLogo.setVerticalTextPosition(SwingConstants.CENTER);
		menuLogo.setHorizontalTextPosition(SwingConstants.RIGHT);
		menuLogo.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		menuLogo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuLogo.setBackground(Color.WHITE);
		menuLogo.setOpaque(false);
		panelContainerNorth.add(menuLogo);

		add(panelContainerNorth);
	}

	private void showMainMenu() {
		panelContainerNorth = new JPanel();
		panelContainerNorth.setOpaque(false);

		panelMenu = new JMBMainMenuBar();
		panelContainerNorth.add(panelMenu);

		add(panelContainerNorth);
	}
}
