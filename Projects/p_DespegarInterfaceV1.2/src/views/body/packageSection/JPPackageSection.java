package views.body.packageSection;

import views.JLabelFormat;

import javax.swing.*;
import java.awt.*;

public class JPPackageSection extends JPanel{

	private static final long serialVersionUID = 1L;
	
    public JPPackageSection(JLabelFormat titleSection, Dimension size, Component component){
        BorderLayout layout = new BorderLayout();
        this.setPreferredSize(size);
        layout.setVgap(8);
        this.setLayout(layout);
        this.setOpaque(false);
        this.add(titleSection,BorderLayout.WEST);
        this.add(component,BorderLayout.SOUTH);
    }
}
