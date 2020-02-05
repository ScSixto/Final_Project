package views;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class JPFooterSection extends JPanel{

    private static final long serialVersionUID = 1L;

    public static final Font FOOTER_FONT = new Font("helvetica",Font.PLAIN,14);
    public static final Font FOOTER_TITLE_FONT = new Font("helvetica",Font.BOLD,16);
    public static final Color FOOTER_FOREGROUND = ConstantsGUI.COLOR_WHITE;


    public JPFooterSection(String title, ArrayList<String> footerSectionTextList) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.initComponents(title,footerSectionTextList);
    }

    private void initComponents(String title, ArrayList<String> footerSectionTextList) {
        JLabelFormat titleLabel = new JLabelFormat(title,FOOTER_TITLE_FONT,FOOTER_FOREGROUND);
        this.add(titleLabel);
        for(String sectionText: footerSectionTextList){
            JButtonFormat sectionButton = new JButtonFormat(sectionText);
            sectionButton.setBorder(BorderFactory.createEmptyBorder(15,0,0,0));
            this.add(sectionButton);
        }
    }
}