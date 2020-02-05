package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPCardLayout extends JPanel{

    public static final String DBZ_IMAGE_PATH = "resources/img/DragonBallZ.png";
    public static final String DBZ_KEY = "DragonBallZ";

    public static final String DEATH_NOTE_IMAGE_PATH = "resources/img/DeathNote.png";
    public static final String DEATH_NOTE_KEY = "DeathNote";

    public static final String NARUTO_IMAGE_PATH = "resources/img/Naruto.png";
    public static final String NARUTO_KEY = "Naruto";

    public static final String SHINGEKY_NO_KYOJIN_IMAGE_PATH = "resources/img/ShingekiNoKyojin.png";
    public static final String SHINGEKY_NO_KYOJIN_KEY = "ShingekyNoKyojin";

    public static final String ONE_PIECE_IMAGE_PATH = "resources/img/OnePiece.png";
    public static final String ONE_PIECE_KEY = "OnePiece";

    public static final String NANATSU_NO_TAIZAI_IMAGE_PATH = "resources/img/NanatsuNoTaizai.png";
    public static final String NANATSU_NO_TAIZAI_KEY = "NanatsuNoTaizai";

    public static final String ONE_PUNCH_MAN_IMAGE_PATH = "resources/img/OnePunchMan.png";
    public static final String ONE_PUNCH_MAN_KEY = "OnePunchMan";

    public static final Dimension DEFAULT_IMAGE_DIMENSION = new Dimension(700,500);
    private CardLayout layout;

    public JPCardLayout(ActionListener act){
        this.layout = new CardLayout();
        this.setLayout(this.layout);
        this.setBackground(ConstantsGUI.COLOR_BLUE);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(5,5,20,5));
        this.setMaximumSize(DEFAULT_IMAGE_DIMENSION);
        this.initComponents(act);
    }

    private void initComponents(ActionListener act){
        this.add(new JPImageSection(act, NANATSU_NO_TAIZAI_IMAGE_PATH, DEFAULT_IMAGE_DIMENSION),NANATSU_NO_TAIZAI_KEY);
        this.add(new JPImageSection(act, DBZ_IMAGE_PATH, DEFAULT_IMAGE_DIMENSION),DBZ_KEY);
        this.add(new JPImageSection(act, DEATH_NOTE_IMAGE_PATH, DEFAULT_IMAGE_DIMENSION),DEATH_NOTE_KEY);
        this.add(new JPImageSection(act, NARUTO_IMAGE_PATH, DEFAULT_IMAGE_DIMENSION),NARUTO_KEY);
        this.add(new JPImageSection(act, SHINGEKY_NO_KYOJIN_IMAGE_PATH, DEFAULT_IMAGE_DIMENSION),SHINGEKY_NO_KYOJIN_KEY);
        this.add(new JPImageSection(act, ONE_PIECE_IMAGE_PATH, DEFAULT_IMAGE_DIMENSION),ONE_PIECE_KEY);
        this.add(new JPImageSection(act, ONE_PUNCH_MAN_IMAGE_PATH, DEFAULT_IMAGE_DIMENSION),ONE_PUNCH_MAN_KEY);
    }

    public void showNextCardImage() {
        layout.next(this);
    }

    public void showPreviousCardImage() {
        layout.previous(this);
    }

    public void showCardImage(String key){
        switch(key){
            case DBZ_KEY:
                this.layout.show(this, DBZ_KEY);
                break;
            case DEATH_NOTE_KEY:
                this.layout.show(this, DEATH_NOTE_KEY);
                break;
            case NARUTO_KEY:
                this.layout.show(this, NARUTO_KEY);
                break;
            case SHINGEKY_NO_KYOJIN_KEY:
                this.layout.show(this, SHINGEKY_NO_KYOJIN_KEY);
                break;
            case ONE_PIECE_KEY:
                this.layout.show(this, ONE_PIECE_KEY);
                break;
            case NANATSU_NO_TAIZAI_KEY:
                this.layout.show(this, NANATSU_NO_TAIZAI_KEY);
                break;
            case ONE_PUNCH_MAN_KEY:
                this.layout.show(this, ONE_PUNCH_MAN_KEY);
                break;
            default:
                break;
        }
    }
}