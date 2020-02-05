package views;

import javax.swing.*;
import java.awt.*;

public class JPTextFieldPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
    private Dimension iconSize;
    private Dimension textFieldSize;
    private Icon icon;
    private JLabelFormat text;

    public JPTextFieldPanel(JLabelFormat text, String iconPath, Dimension iconSize,Dimension textFieldSize){
        this.setBackground(ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        layout.setHgap(10);
        this.setLayout(layout);
        this.setOpaque(false);

        this.textFieldSize = textFieldSize;
        this.text = text;
        this.iconSize = iconSize;
        this.icon = new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance((int)this.iconSize.getWidth(),(int)this.iconSize.getHeight(), Image.SCALE_AREA_AVERAGING));
        this.initComponents();
    }

    public void initComponents(){
        this.addIcon();
        this.addTextField();
    }

    public void addIcon2(){
        JButton button = new JButton();
        button.setBackground(ConstantsGUI.COLOR_WHITE);
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button.setIcon(icon);
        this.add(button);
    }
    
    public void addIcon(){
        JLabel icon = new JLabel();
        icon.setBackground(ConstantsGUI.COLOR_WHITE);
        icon.setOpaque(false);
        icon.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        icon.setIcon(this.icon);
        this.add(icon);
    }

    public void addTextField(){
        this.add(new JTextFieldFormat(this.text,this.textFieldSize));
    }

    protected void paintComponent(Graphics g){
        Dimension arcs = new Dimension(10,10); //Border corners arcs {width,height}, change this to whatever you want
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded panel with borders.
        graphics.setColor(ConstantsGUI.COLOR_DESPEGAR_LIGHT_GRAY_3);
//        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
//        graphics.setColor(ConstantsGUI.DESPEGAR_LIGHT_GRAY);
        super.paintComponent(graphics);
    }
}
