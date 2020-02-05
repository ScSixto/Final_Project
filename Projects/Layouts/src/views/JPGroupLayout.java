package views;

import controllers.ActionCommands;

import javax.swing.*;
import javax.xml.bind.annotation.XmlType;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPGroupLayout extends JPanel{


    public static final String DBZ_BUTTON_TEXT = "Dragon Ball Z";
    public static final String DEATH_NOTE_BUTTON_TEXT = "Death Note";
    public static final String NARUTO_BUTTON_TEXT = "Naruto";
    public static final String SHINGEKY_NO_KYOJIN_BUTTON_TEXT = "Shingeki No Kyojin";
    public static final String ONE_PIECE_BUTTON_TEXT = "One Piece";
    public static final String NANATSU_NO_TAIZAI_BUTTON_TEXT = "Nanatsu No Taizai";
    public static final String ONE_PUNCH_MAN_BUTTON_TEXT = "One Punch Man";
    public static final Dimension DEFAULT_BUTTON_DIMENSION = new Dimension(50,50);

    private GroupLayout layout;

    public JPGroupLayout(ActionListener act){
        this.layout = new GroupLayout(this);
        this.setLayout(layout);
        this.setBackground(ConstantsGUI.COLOR_LIGHT_GRAY);
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        this.initComponents(act);
    }

    private void initComponents(ActionListener act){
        JButtonFormat dragonBallZButton = addDragonBallZButton(act);
        JButtonFormat deathNoteButton = addDeathNoteButton(act);
        JButtonFormat narutoButton = addNarutoButton(act);
        JButtonFormat shingekiNoKyojinButton = addshingekiNoKyojinButton(act);
        JButtonFormat onePieceButton = addOnePieceButton(act);
        JButtonFormat nanatsuNoTaizaButton = addNanatsuNoTaizaButton(act);
        JButtonFormat onePunchManButton = addOnePunchManButton(act);

        GroupLayout.SequentialGroup grupo1 = layout.createSequentialGroup().addComponent(dragonBallZButton);
        GroupLayout.ParallelGroup grupo2 = layout.createParallelGroup().addComponent(deathNoteButton).addComponent(narutoButton);
        grupo1.addGroup(grupo2).addComponent(shingekiNoKyojinButton);

//        GroupLayout.ParallelGroup grupo3 = layout.createParallelGroup().addComponent(onePieceButton).addComponent(nanatsuNoTaizaButton);
//        GroupLayout.SequentialGroup grupo4 = layout.createSequentialGroup().addComponent(onePunchManButton).addGroup(grupo3);
//
//        grupo1.addGroup(grupo4);

        layout.setHorizontalGroup(grupo1);
        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(dragonBallZButton).addComponent(deathNoteButton).addComponent(narutoButton).addComponent(shingekiNoKyojinButton).addComponent(onePieceButton).addComponent(nanatsuNoTaizaButton).addComponent(onePunchManButton));
        layout.setAutoCreateGaps(true);
    }


    private JButtonFormat addDragonBallZButton(ActionListener act){
        JButtonFormat dragonBallZButton = new JButtonFormat(DBZ_BUTTON_TEXT, DEFAULT_BUTTON_DIMENSION, ConstantsGUI.COLOR_WHITE);
        dragonBallZButton.setActionCommand(ActionCommands.DBZ_IMAGE.name());
        dragonBallZButton.addActionListener(act);
        return dragonBallZButton;
    }

    private JButtonFormat addDeathNoteButton(ActionListener act){
        JButtonFormat deathNoteButton = new JButtonFormat(DEATH_NOTE_BUTTON_TEXT, DEFAULT_BUTTON_DIMENSION, ConstantsGUI.COLOR_WHITE);
        deathNoteButton.setActionCommand(ActionCommands.DEATH_NOTE_IMAGE.name());
        deathNoteButton.addActionListener(act);
        return deathNoteButton;
    }

    private JButtonFormat addNarutoButton(ActionListener act){
        JButtonFormat narutoButton = new JButtonFormat(NARUTO_BUTTON_TEXT, DEFAULT_BUTTON_DIMENSION, ConstantsGUI.COLOR_WHITE);
        narutoButton.setActionCommand(ActionCommands.NARUTO_IMAGE.name());
        narutoButton.addActionListener(act);
        return narutoButton;
    }

    private JButtonFormat addshingekiNoKyojinButton(ActionListener act){
        JButtonFormat shingekiNoKyojinButton = new JButtonFormat(SHINGEKY_NO_KYOJIN_BUTTON_TEXT, DEFAULT_BUTTON_DIMENSION, ConstantsGUI.COLOR_WHITE);
        shingekiNoKyojinButton.setActionCommand(ActionCommands.SHINGEKY_NO_KYOJIN_IMAGE.name());
        shingekiNoKyojinButton.addActionListener(act);
        return shingekiNoKyojinButton;
    }

    private JButtonFormat addOnePieceButton(ActionListener act){
        JButtonFormat onePieceButton = new JButtonFormat(ONE_PIECE_BUTTON_TEXT, DEFAULT_BUTTON_DIMENSION, ConstantsGUI.COLOR_WHITE);
        onePieceButton.setActionCommand(ActionCommands.ONE_PIECE_IMAGE.name());
        onePieceButton.addActionListener(act);
        return onePieceButton;
    }

    private JButtonFormat addNanatsuNoTaizaButton(ActionListener act){
        JButtonFormat nanatsuNoTaizaButton = new JButtonFormat(NANATSU_NO_TAIZAI_BUTTON_TEXT, DEFAULT_BUTTON_DIMENSION, ConstantsGUI.COLOR_WHITE);
        nanatsuNoTaizaButton.setActionCommand(ActionCommands.NANATSU_NO_TAIZAI_IMAGE.name());
        nanatsuNoTaizaButton.addActionListener(act);
        return nanatsuNoTaizaButton;
    }

    private JButtonFormat addOnePunchManButton(ActionListener act){
        JButtonFormat onePunchManButton = new JButtonFormat(ONE_PUNCH_MAN_BUTTON_TEXT, DEFAULT_BUTTON_DIMENSION, ConstantsGUI.COLOR_WHITE);
        onePunchManButton.setActionCommand(ActionCommands.ONE_PUNCH_MAN_IMAGE.name());
        onePunchManButton.addActionListener(act);
        return onePunchManButton;
    }

}