package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JComboBoxFormat extends JComboBox{
    public static final Color DEFAULT_DATE_CHOOSER_FOREGROUND = ConstantsGUI.COLOR_DARK_GRAY;
    public static final Font DEFAULT_DATE_CHOOSER_FONT = new Font("Arial",Font.PLAIN,14);

    public JComboBoxFormat(ArrayList<String> optionArray){
        super(optionArray.toArray());
        this.setForeground(DEFAULT_DATE_CHOOSER_FOREGROUND);
        this.setFont(DEFAULT_DATE_CHOOSER_FONT);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        this.setBackground(ConstantsGUI.COLOR_LIGHT_GRAY_4);
    }

    public String getSelection(){
        return (String)this.getSelectedItem();
    }

    public void reset(){
        this.setSelectedItem(null);
    }
}
