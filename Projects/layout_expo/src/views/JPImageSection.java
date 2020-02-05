package views;

import controllers.ActionCommands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPImageSection extends JPanel{

    public static final String DEFAULT_PREVIOUS_ICON_PATH = "resources/img/ArrowLeft.png";
    public static final String DEFAULT_NEXT_ICON_PATH = "resources/img/ArrowRigth.png";
    public static final Dimension DEFAULT_MOVE_ICON_DIMENSION = new Dimension(50,50);

    private Image backgorundImage;


    public JPImageSection(ActionListener act, String backgorundImagePath, Dimension panelDimension){
        this.setLayout(new BorderLayout());
        this.backgorundImage = new ImageIcon(backgorundImagePath).getImage().getScaledInstance((int)panelDimension.getWidth(), (int)panelDimension.getHeight(), Image.SCALE_AREA_AVERAGING);
        this.setPreferredSize(panelDimension);
        this.setOpaque(false);
        this.initComponents(act);
    }

    private void initComponents(ActionListener act){
        JButtonFormat previousButton = new JButtonFormat(DEFAULT_PREVIOUS_ICON_PATH, DEFAULT_MOVE_ICON_DIMENSION);
        previousButton.setActionCommand(ActionCommands.PREVIOUS_IMAGE.name());
        previousButton.addActionListener(act);
        this.add(previousButton, BorderLayout.WEST);

        JButtonFormat nextButton = new JButtonFormat(DEFAULT_NEXT_ICON_PATH, DEFAULT_MOVE_ICON_DIMENSION);
        nextButton.setActionCommand(ActionCommands.NEXT_IMAGE.name());
        nextButton.addActionListener(act);
        this.add(nextButton, BorderLayout.EAST);
    }

    @Override
    protected void paintComponent(Graphics graphics){
        Graphics2D g2 = (Graphics2D) graphics;
        g2.drawImage(backgorundImage,0,0,this);
        super.paintComponent(g2);
    }
}