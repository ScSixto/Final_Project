package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPFooterPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPFooterPanel(ActionListener act){
        this.setBackground(ConstantsGUI.COLOR_LIGHT_GRAY_2);
        this.setBorder(BorderFactory.createEmptyBorder(25,50,30,50));
        this.setLayout(new GridLayout(1,3));
        this.initComponents(act);
    }

    private void initComponents(ActionListener act){
        ArrayList<String> aboutWeb = new ArrayList<>();
        aboutWeb.add("Texto");
        aboutWeb.add("Mas Texto");
        aboutWeb.add("Deberia haber mas texto");
        aboutWeb.add("Claro, mas texto");
        aboutWeb.add("Cosas importantes.txt.");

        this.add(new JPFooterSection("Acerca de la Pagina", aboutWeb));

        ArrayList<String> sectionTwo = new ArrayList<>();
        sectionTwo.add("No se me ocurrio mucho");
        sectionTwo.add("Ahi vamos");
        sectionTwo.add("Texto de otra seccion");
        sectionTwo.add("Continuamos improvisando.");
        sectionTwo.add("Informacion de calidad.org");
        sectionTwo.add("Gracias cerebro");


        this.add(new JPFooterSection("Seccion dos", sectionTwo));

        ArrayList<String> sectionThree = new ArrayList<>();
        sectionThree.add("Por qu"+ ConstantsGUI.LOWERCASE_ACCENTED_E +" no una tercera");
        sectionThree.add("Contactanos");
        sectionThree.add("sebastian.sanchez02@uptc.edu.co");
        sectionThree.add("y sho");

        this.add(new JPFooterSection("Seccion tres", sectionThree));
    }
}
