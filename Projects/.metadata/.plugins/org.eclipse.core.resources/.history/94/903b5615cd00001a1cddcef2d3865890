package views;

import javax.swing.*;
import java.awt.*;

public class JPSpecificAnimePanel extends JPanel {

    public static final Dimension DEFAULT_PPAL_IMAGE_DIMENSION = new Dimension(250,350);
    public static final Dimension DEFAULT_ICON_DIMENSION = new Dimension(140,120);

    public static final Font DEFAULT_TITLE_FONT = new Font("Arial", Font.BOLD,50);
    public static final Color DEFAULT_TITLE_FOREGROUND = ConstantsGUI.COLOR_DARK_GRAY;

    public static final Font DEFAULT_SUBTITLE_FONT = new Font("Arial", Font.PLAIN,14);
    public static final Color DEFAULT_SUBTITLE_FOREGROUND = ConstantsGUI.COLOR_DARK_GRAY;

    public static final String DEFAULT_EXTRA_INFORMATION_TEXT = "Aqui podria ir una descripcion";
    public static final Font DEFAULT_EXTRA_INFORMATION_FONT = new Font("Arial", Font.PLAIN,18);
    public static final Color DEFAULT_EXTRA_INFORMATION_FOREGROUND = ConstantsGUI.COLOR_DARK_GRAY;

    private GridBagConstraints constraints;
    private String ppalImage;
    private String icon1;
    private String icon2;
    private JLabelFormat titleLabel;
    private JLabelFormat subTitleLabel;

    public JPSpecificAnimePanel(String imagePath, String title, String subTitle, String iconPath1, String iconPath2){
        this.setBackground(ConstantsGUI.COLOR_WHITE);
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0,5,10,10));
        this.ppalImage = imagePath;//new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance((int)DEFAULT_PPAL_IMAGE_DIMENSION.getWidth(),(int)DEFAULT_PPAL_IMAGE_DIMENSION.getWidth(),Image.SCALE_AREA_AVERAGING));
        this.icon1 = iconPath1;//new ImageIcon(new ImageIcon(iconPath1).getImage().getScaledInstance((int)DEFAULT_ICON_DIMENSION.getWidth(),(int)DEFAULT_ICON_DIMENSION.getWidth(),Image.SCALE_AREA_AVERAGING));
        this.icon2 = iconPath2;//new ImageIcon(new ImageIcon(iconPath2).getImage().getScaledInstance((int)DEFAULT_ICON_DIMENSION.getWidth(),(int)DEFAULT_ICON_DIMENSION.getWidth(),Image.SCALE_AREA_AVERAGING));
        this.titleLabel = new JLabelFormat(title, DEFAULT_TITLE_FONT,DEFAULT_TITLE_FOREGROUND);
        this.subTitleLabel = new JLabelFormat(subTitle, DEFAULT_SUBTITLE_FONT, DEFAULT_SUBTITLE_FOREGROUND);
        this.constraints = new GridBagConstraints();
        constraints.ipadx = 10;
        constraints.ipady = 10;
        this.initComponents();
    }

    private void initComponents(){
        this.addPpalImage();
        this.addTitleLabel();
        this.addSubTitleLabel();
        this.addIcon1();
        this.addIcon2();
        this.addExtraInformation();
    }

    private void addPpalImage() {
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 2; // El área de texto ocupa dos columnas.
        constraints.gridheight = 4; // El área de texto ocupa 2 filas.
        this.add(new JLabelFormat(this.ppalImage, DEFAULT_PPAL_IMAGE_DIMENSION), this.constraints);
    }

    private void addTitleLabel() {
        constraints.gridx = 2; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 3; // El área de texto ocupa dos columnas.
        constraints.gridheight = 2; // El área de texto ocupa 2 filas.
        constraints.anchor = GridBagConstraints.WEST;
        this.add(this.titleLabel,this.constraints);

    }

    private void addSubTitleLabel(){
        constraints.gridx = 2; // El área de texto empieza en la columna cero.
        constraints.gridy = 2; // El área de texto empieza en la fila cero
        constraints.gridwidth = 2; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weighty = 1.0;
        this.add(this.subTitleLabel,this.constraints);
    }

    private void addIcon1() {
        constraints.gridx = 2; // El área de texto empieza en la columna cero.
        constraints.gridy = 3; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.SOUTH;
        this.add(new JLabelFormat(icon1, DEFAULT_ICON_DIMENSION), this.constraints);
    }

    private void addIcon2() {
        constraints.gridx = 4; // El área de texto empieza en la columna cero.
        constraints.gridy = 3; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        this.add(new JLabelFormat(icon2, DEFAULT_ICON_DIMENSION), this.constraints);
    }

    private void addExtraInformation() {
        this.constraints.gridx = 0; // El área de texto empieza en la columna cero.
        this.constraints.gridy = 4; // El área de texto empieza en la fila cero
        this.constraints.gridwidth = 5; // El área de texto ocupa dos columnas.
        this.constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipady = 20;
        this.add(new JLabelFormat(DEFAULT_EXTRA_INFORMATION_TEXT, DEFAULT_EXTRA_INFORMATION_FONT, DEFAULT_EXTRA_INFORMATION_FOREGROUND), this.constraints);
    }
}