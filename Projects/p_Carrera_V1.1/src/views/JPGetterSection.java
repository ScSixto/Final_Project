package views;

import javax.swing.*;
import java.awt.*;

public class JPGetterSection extends JPanel{
    
	private static final long serialVersionUID = 1L;
	
	public static final Font DEFAULT_GETTER_TEXT_FONT = new Font("Arial", Font.PLAIN,14);
    public static final Color DEFAULT_GETTER_TEXT_FOREGROUND = ConstantsGUI.COLOR_DARK_GRAY;

    public static final int COMPONENT_RIGTH_ALIGN = SwingConstants.RIGHT;
    public static final int COMPONENT_BOTTOM_ALIGN = SwingConstants.BOTTOM;

    public JPGetterSection(){
        BorderLayout layout = new BorderLayout();
        layout.setVgap(3);
        this.setLayout(layout);
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setOpaque(false);

        this.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
    }

    public JPGetterSection(String getterText, Component getterComponent){
        this();
        this.initComponents(getterText,getterComponent);
    }

    public JPGetterSection(String getterText, Component getterComponent, int componentAlign) {
        this();
        this.initComponents(getterText, getterComponent, componentAlign);
    }

        private void initComponents(String getterText, Component getterComponent){
        this.addLabelGetter(getterText);
        this.addComponent(getterComponent, COMPONENT_BOTTOM_ALIGN);
    }

    private void initComponents(String getterText, Component getterComponent, int componentAlign){
        this.addLabelGetter(getterText);
        this.addComponent(getterComponent, componentAlign);
    }

    private void addLabelGetter(String getterText){
        this.add(new JLabelFormat(getterText, DEFAULT_GETTER_TEXT_FONT, DEFAULT_GETTER_TEXT_FOREGROUND), BorderLayout.WEST);
    }

    private void addComponent(Component getterComponent, int componentAlign){
        switch(componentAlign){
            case COMPONENT_RIGTH_ALIGN:
                this.add(getterComponent, BorderLayout.EAST);
                break;
            default:
                this.add(getterComponent, BorderLayout.SOUTH);
                break;
        }
    }
}
