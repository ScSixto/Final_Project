package views;

import javax.swing.*;
import java.awt.*;

public class JBRoundButton extends JButton{

	private static final long serialVersionUID = 1L;
	
	public static final int DEFAULT_ANGLE_BORDER = 40;
    private Color borderColor;
    private int angleBorder;

    public JBRoundButton(String text, String iconPath, Dimension size,Font font,Color foreground,int horizontalTextAlign, int verticalTextAlign, Color borderColor){
        super(text);
        this.setVerticalTextPosition(verticalTextAlign);
        this.setHorizontalTextPosition(horizontalTextAlign);
        this.setFont(font);
        this.setFocusable(false);
        this.setForeground(foreground);

        this.angleBorder = DEFAULT_ANGLE_BORDER;

        this.setBackground(ConstantsGUI.COLOR_IMPOSSIBLE);
        this.setOpaque(false);

        this.setBorder(BorderFactory.createEmptyBorder(5,20,5,20));
        this.setBorderPainted(false);
        this.borderColor = borderColor;

        this.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance((int)size.getWidth(),(int)size.getHeight(),Image.SCALE_AREA_AVERAGING)));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    public JBRoundButton(String iconPath, Dimension size, Color borderColor){
    	this(iconPath,size);
        this.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        this.borderColor = borderColor;
    }
    
    public JBRoundButton(String iconPath, Dimension size){
        this.setBackground(ConstantsGUI.COLOR_IMPOSSIBLE);
        this.setOpaque(false);

        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.setBorderPainted(false);
        this.borderColor = ConstantsGUI.COLOR_IMPOSSIBLE;
        this.angleBorder = DEFAULT_ANGLE_BORDER;
        this.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance((int)size.getWidth(),(int)size.getHeight(),Image.SCALE_AREA_AVERAGING)));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public JBRoundButton(String text, String iconPath, Dimension size,Font font,Color foreground,int horizontalTextAlign, int verticalTextAlign,Color borderColor,int angleBorder){
        super(text);
        this.setVerticalTextPosition(verticalTextAlign);
        this.setHorizontalTextPosition(horizontalTextAlign);
        this.setFont(font);
        this.setForeground(foreground);

        this.setBackground(borderColor);
        this.setOpaque(false);
        this.angleBorder = angleBorder;
        this.setBorder(BorderFactory.createEmptyBorder(5,20,5,20));
        this.setBorderPainted(false);
        this.borderColor = borderColor;

        this.setIcon(new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance((int)size.getWidth(),(int)size.getHeight(),Image.SCALE_AREA_AVERAGING)));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    public JBRoundButton(String text,Font font,Color foreground,Color borderColor,int angleBorder){
        super(text);
        this.setFont(font);
        this.setFocusable(false);
        this.setForeground(foreground);

        this.angleBorder = angleBorder;

        this.setBackground(ConstantsGUI.COLOR_IMPOSSIBLE);
        this.setOpaque(false);

        this.setBorder(BorderFactory.createEmptyBorder(5,20,5,20));
        this.setBorderPainted(false);
        this.borderColor = borderColor;

        this.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    public JBRoundButton(JPanel panel, int angleBorder, Color background, Color borderColor){
        this.setBackground(background);
        this.setOpaque(false);

        this.borderColor = borderColor;
        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        this.add(panel);
        this.angleBorder = angleBorder;

        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    protected void paintComponent(Graphics g) {
        Dimension arcs = new Dimension(angleBorder, angleBorder); //Border corners arcs {width,height}, change this to whatever you want
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded panel with borders.
        if(!this.getBackground().equals(ConstantsGUI.COLOR_IMPOSSIBLE)){
            graphics.setColor(this.getBackground());
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
        }
        graphics.setColor(this.borderColor);//ConstantsGUI.COLOR_DESPEGAR_DARK_GRAY);
        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
        super.paintComponent(graphics);
    }
}