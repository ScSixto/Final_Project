package views;

import javax.swing.*;
import java.awt.*;

public class JSpinnerFormat extends JSpinner{

    public static final Color DEFAULT_SPINNER_FOREGROUND = ConstantsGUI.COLOR_DARK_GRAY;
    public static final Font DEFAULT_SPINNER_FONT = new Font("Arial",Font.PLAIN,14);
    public static final int DEFAULT_SPINNER_VALUE = 0;

    public static final int POSITIVE_SPINNER = 1;
    public static final int NEGATIVE_SPINNER = 2;

    public JSpinnerFormat(){
        this.setForeground(DEFAULT_SPINNER_FOREGROUND);
        this.setFont(DEFAULT_SPINNER_FONT);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
        this.setOpaque(false);
        this.setModel(new SpinnerNumberModel(DEFAULT_SPINNER_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE,1));
        this.setPreferredSize(new Dimension(40,25));
    }

    public JSpinnerFormat(int spinnerType){
        this();
        switch(spinnerType){
            case POSITIVE_SPINNER:
                this.setModel(new SpinnerNumberModel(DEFAULT_SPINNER_VALUE, 0, Integer.MAX_VALUE,1));
                break;
            case NEGATIVE_SPINNER:
                this.setModel(new SpinnerNumberModel(DEFAULT_SPINNER_VALUE, Integer.MIN_VALUE, 0,1));
                break;
        }
    }

    public JSpinnerFormat(int minValue, int maxValue){
        this();
        this.setModel(new SpinnerNumberModel(minValue, minValue, maxValue,1));
    }

    public void reset(){
        this.setValue(DEFAULT_SPINNER_VALUE);
    }
}
