package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPAnimePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public static final String NANATSU_NO_TAIZAI_TITLE = "<html>Nanatsu no<br>Taizai</html>";
    public static final String NANATSU_NO_TAIZAI_SUBTITLE = "Anime";
    public static final String NANATSU_NO_TAIZAI_IMAGE_PATH = "resources/img/NanatsuNoTaizaiVertical.png";
    public static final String NANATSU_NO_TAIZAI_ICON1_PATH = "resources/img/NanatsuNoTaizaiP1.png";
    public static final String NANATSU_NO_TAIZAI_ICON2_PATH = "resources/img/NanatsuNoTaizaiP2.png";

    public JPAnimePanel(ActionListener act) {
//        this.setPreferredSize(new Dimension((int) (WIDTH * 0.8), HEIGHT));
        this.setBackground(ConstantsGUI.COLOR_LIGHT_GRAY_4);
        this.setLayout(new FlowLayout());

        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        this.initComponents(act);
    }

    private void initComponents(ActionListener act) {
        this.add(new JPSpecificAnimePanel(NANATSU_NO_TAIZAI_IMAGE_PATH, NANATSU_NO_TAIZAI_TITLE, NANATSU_NO_TAIZAI_SUBTITLE, NANATSU_NO_TAIZAI_ICON1_PATH, NANATSU_NO_TAIZAI_ICON2_PATH));
        this.add(new JPGroupLayout(act));
    }
}
