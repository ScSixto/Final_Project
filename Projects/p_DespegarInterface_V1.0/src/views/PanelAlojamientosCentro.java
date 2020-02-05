package views;


import javax.swing.*;
import java.awt.*;

public class PanelAlojamientosCentro extends JPanel {
    private JLabel alojamiento, destino, fechas, habitaciones;
    private JTextField ingresa, entrada, salida, iconos;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    public PanelAlojamientosCentro(){
        gbl = new GridBagLayout();
        this.setLayout(gbl);
        setBackground(ConstantsGUI.WHITE);
		setOpaque(false);
//        this.setBackground(Color.decode("#4300d2"));
        gbc = new GridBagConstraints();
        initComponents();
    }

    public void initComponents(){
        alojamiento = new JLabel("Alojamiento");
        alojamiento.setFont(new Font("rubik", 1, 20));
        gbc.insets = new Insets(0,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(alojamiento,gbc);

        destino = new JLabel("DESTINO");
        destino.setFont(new Font("Rubik, Arial, sans-serif", 1, 12));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;

        add(destino,gbc);

        fechas = new JLabel("FECHAS");
        fechas.setFont(new Font("Rubik, Arial, sans-serif", 1, 12));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(fechas,gbc);

        habitaciones = new JLabel("HABITACIONES");
        habitaciones.setFont(new Font("Rubik, Arial, sans-serif", 1, 12));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 1;
        add(habitaciones,gbc);


        ingresa = new JTextField("Ingresa el destino...");
        ingresa.setPreferredSize(new Dimension(200,50));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(ingresa,gbc);

        entrada = new JTextField("Entrada");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(entrada ,gbc);

        salida = new JTextField("Salida");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(salida ,gbc);

        iconos = new JTextField("equide");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 2;
        add(iconos ,gbc);
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Dimension arcs = new Dimension(30,30); //Border corners arcs {width,height}, change this to whatever you want
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
        graphics.setColor(getBackground());
        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
	  }
}
