package views;

import controllers.ActionCommands;
import models.Gender;
import models.Team;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class JDAddRunner extends JDialog{

	private static final long serialVersionUID = 1L;

	public static final Dimension DEFAULT_ADD_RUNNER_DIALOG_DIMENSION = new Dimension(320, 440);

    public static final String ADD_RUNNER_TITLE_TEXT = "A"+ ConstantsGUI.LOWERCASE_ACCENTED_N +"adir corredor";
    public static final String ADD_ID_GETTER_TEXT = "Id:";
    public static final String ADD_FIRST_NAME_GETTER_TEXT = "";//"Ejemplo: Sofia";
    public static final String ADD_SECOND_NAME_GETTER_TEXT = "";//"Ejemplo: Carlos";
    public static final String ADD_LAST_NAME_GETTER_TEXT = "";//"Ejemplo: Marinez";
    public static final String ADD_GENDER_GETTER_TEXT = "";
    public static final String ADD_BIRTH_DATE_GETTER_TEXT = "";
    public static final String ADD_TEAM_GETTER_TEXT = "";
    public static final String ADD_ROUTE_TIME_GETTER_TEXT = "";
    public static final String ADD_ID_TEXT = "Id:";
    public static final String ADD_FIRST_NAME_TEXT = "Primer nombre";
    public static final String ADD_SECOND_NAME_TEXT = "Segundo nombre";
    public static final String ADD_LAST_NAME_TEXT = "Apellido";
    public static final String ADD_GENDER_TEXT = "G"+ ConstantsGUI.LOWERCASE_ACCENTED_E +"nero";
    public static final String ADD_BIRTH_DATE_TEXT = "Fecha de nacimiento";
    public static final String ADD_TEAM_TEXT = "Equipo";
    public static final String ADD_ROUTE_TIME_TEXT = "Tiempo de recorrido";

    public  static final String SAVE_INFORMATION_BUTTON_TEXT = "Guardar";
    public static final Dimension DEFAULT_SAVE_BUTTON_DIMENSION = new Dimension(40,20);
    public static final String DEFAULT_ADD_RUNNER_DIALOG_ICON_PATH = "resources/img/addRunner.png";

    private JPanel container = new JPanel();

    private JSpinnerFormat idGetter;
    private JTextFieldFormat firstNameGetter;
    private JTextFieldFormat secondNameGetter;
    private JTextFieldFormat lastNameGetter;
    private JPRadioButtonSelection genderGetter;
    private JDateChooserFormat birthDateGetter;
    private JComboBoxFormat teamGetter;
    private JTimeChooserFormat routeTimeGetter;

    public JDAddRunner(ActionListener act){
//    	this.setModal(true);
        this.setIconImage(new ImageIcon(DEFAULT_ADD_RUNNER_DIALOG_ICON_PATH).getImage());//.getImage().getScaledInstance((int)DEFAULT_ADD_RUNNER_DIALOG_ICON_DIMENSION.getWidth(), (int)DEFAULT_ADD_RUNNER_DIALOG_ICON_DIMENSION.getHeight(),Image.SCALE_AREA_AVERAGING)));
		this.setSize(DEFAULT_ADD_RUNNER_DIALOG_DIMENSION);
		this.setMinimumSize(this.getSize());
		this.setTitle(ADD_RUNNER_TITLE_TEXT);
		this.setLocationRelativeTo(null);
		this.initComponents(act);
		this.setAlwaysOnTop(true);
//		setVisible( true );
//        this.setPreferredSize(new Dimension(200,500));
//        this.initComponents(act);
    }

    public int getId(){
        return (int)this.idGetter.getValue();
    }

    public String getFirstName(){
        return this.firstNameGetter.getText();
    }

    public String getSecondName(){
        return this.secondNameGetter.getText();
    }

    public String getLastName(){
        return this.lastNameGetter.getText();
    }

    public Gender getGender() throws NullPointerException{
       try{
           Gender newGender = null;
           String genderKey = this.genderGetter.getSelection();
           for(Gender gender: Gender.values()){
                if(gender.name().equals(genderKey)){
                    newGender = gender;
                    break;
                }
           }
           return newGender;
       }catch(NullPointerException e){
            throw new NullPointerException("No ha seleccionado Genero");
       }
    }

    public LocalDate getBirthDate(){
        try {
            return this.birthDateGetter.getLocalDate();
        }catch (NullPointerException e){
            throw new NullPointerException("No ha ingresado Fecha de Nacimiento");
        }
    }

    public Team getTeam(){
        try{
            Team newTeam = null;
            String teamKey = this.teamGetter.getSelection();
            for(Team team: Team.values()){
                if(team.getName().equals(teamKey)){
                    newTeam = team;
                    break;
                }
            }
            return newTeam;
        }catch(NullPointerException e){
            throw new NullPointerException("No ha seleccionado Equipo");
        }
    }

    public LocalTime getRouteTime(){
        return this.routeTimeGetter.getTime();
    }

    private void initComponents(ActionListener act){
        this.addContainerPanel(act);
    }

    private void addContainerPanel(ActionListener act){
        this.container.setLayout(new BoxLayout(this.container,BoxLayout.PAGE_AXIS));
        this.container.setBackground(Color.WHITE);
        this.container.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        this.addIdAndTeamGetter();
        this.addCompleteNamePanel();
        this.addGenderAndRouteTimeGetter(act);
        this.addBirthDateGetter();
        this.addSaveButton(act);
        this.add(container);
    }

    private void addIdAndTeamGetter(){
        JPanel teamAndIdPanel = new JPanel();
        teamAndIdPanel.setOpaque(false);
        teamAndIdPanel.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));
        GridLayout layout = new GridLayout(1,2);
        layout.setHgap(10);
        teamAndIdPanel.setLayout(layout);

        teamAndIdPanel.add(this.getIdGetter());
        teamAndIdPanel.add(this.getTeamGetter());

        this.container.add(teamAndIdPanel);
    }

    private JPGetterSection getIdGetter(){
        this.idGetter = new JSpinnerFormat(JSpinnerFormat.POSITIVE_SPINNER);
        JPGetterSection idGetterSection = new JPGetterSection(ADD_ID_TEXT,idGetter,JPGetterSection.COMPONENT_RIGTH_ALIGN);
        idGetterSection.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        idGetterSection.setLayout(new FlowLayout(FlowLayout.LEFT));
        return idGetterSection;
    }

    private JPGetterSection getTeamGetter(){
        ArrayList<String> teamOptions = new ArrayList<>();
        for(Team team: Team.values()){
            teamOptions.add(team.getName());
        }
        this.teamGetter = new JComboBoxFormat(teamOptions);
        JPGetterSection teamGetterSection = new JPGetterSection(ADD_TEAM_TEXT, this.teamGetter);
        return teamGetterSection;
    }

    private JPanel getNamesPanel(){
        JPanel namesPanel = new JPanel();
        namesPanel.setOpaque(false);
        GridLayout layout = new GridLayout(1,2);
        layout.setHgap(10);
        namesPanel.setLayout(layout);

        namesPanel.add(this.getFirstNameGetter());
        namesPanel.add(this.getSecondNameGetter());

        return namesPanel;
    }

    private void addCompleteNamePanel(){
        JPanel completeNamePanel = new JPanel();
        completeNamePanel.setOpaque(false);
        BoxLayout layout = new BoxLayout(completeNamePanel, BoxLayout.Y_AXIS);
        completeNamePanel.setLayout(layout);

        completeNamePanel.add(this.getNamesPanel());
        completeNamePanel.add(this.getLastNameGetter());

        this.container.add(completeNamePanel);
    }

    private JPGetterSection getFirstNameGetter(){
        this.firstNameGetter = new JTextFieldFormat(ADD_FIRST_NAME_GETTER_TEXT, new Dimension((int)(this.getWidth() * 0.4),25));
        return new JPGetterSection(ADD_FIRST_NAME_TEXT, this.firstNameGetter);
    }

    private JPGetterSection getSecondNameGetter(){
        this.secondNameGetter = new JTextFieldFormat(ADD_SECOND_NAME_GETTER_TEXT, new Dimension((int)(this.getWidth() * 0.4),25));
        return new JPGetterSection(ADD_SECOND_NAME_TEXT, this.secondNameGetter);
    }

    private JPGetterSection getLastNameGetter(){
        this.lastNameGetter = new JTextFieldFormat(ADD_LAST_NAME_GETTER_TEXT, new Dimension(260,25));
        return new JPGetterSection(ADD_LAST_NAME_TEXT, this.lastNameGetter);
    }

    private void addGenderAndRouteTimeGetter(ActionListener act){
        JPanel genderAndRouteTimeGetter = new JPanel();
        genderAndRouteTimeGetter.setOpaque(false);
        genderAndRouteTimeGetter.setBorder(BorderFactory.createEmptyBorder(5,0,15,0));
        GridLayout layout = new GridLayout(1,2);
        layout.setHgap(5);
        genderAndRouteTimeGetter.setLayout(layout);

        genderAndRouteTimeGetter.add(this.getGenderGetter(act));
        genderAndRouteTimeGetter.add(this.getRouteTimeGetter());

        this.container.add(genderAndRouteTimeGetter);
    }

    private JPGetterSection getGenderGetter(ActionListener act){
        HashMap<String, String> radioButtonNames = new HashMap<>();
        for(Gender gender: Gender.values()){
            radioButtonNames.put(gender.name() ,gender.getGender());
        }
        this.genderGetter = new JPRadioButtonSelection(act, radioButtonNames);
        this.genderGetter.setLayout(new BoxLayout(this.genderGetter,BoxLayout.Y_AXIS));
        this.genderGetter.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
        JPGetterSection genderGetterSection = new JPGetterSection(ADD_GENDER_TEXT, this.genderGetter);

        this.genderGetter.getRadioButton(Gender.MALE.name()).setActionCommand(ActionCommands.SELECT_NEW_RUNNER_MALE_GENDER.name());
        this.genderGetter.getRadioButton(Gender.FEMALE.name()).setActionCommand(ActionCommands.SELECT_NEW_RUNNER_FEMALE_GENDER.name());

        return genderGetterSection;
    }

    private void addBirthDateGetter(){
    	birthDateGetter  = new JDateChooserFormat();
        this.container.add(new JPGetterSection(ADD_BIRTH_DATE_TEXT, birthDateGetter));
    }

    private JPGetterSection getRouteTimeGetter(){
        this.routeTimeGetter = new JTimeChooserFormat();
        JPGetterSection routeTimeGetterSection = new JPGetterSection(ADD_ROUTE_TIME_TEXT, routeTimeGetter);
        return routeTimeGetterSection;
    }

    private void addSaveButton(ActionListener act){
        JPanel saveButtonPanel = new JPanel();
        saveButtonPanel.setOpaque(false);
        saveButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        saveButtonPanel.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));

        JButtonFormat saveButton = new JButtonFormat(SAVE_INFORMATION_BUTTON_TEXT, DEFAULT_SAVE_BUTTON_DIMENSION, ConstantsGUI.COLOR_LIGHT_GRAY_4);
        saveButton.addActionListener(act);
        saveButton.setActionCommand(ActionCommands.SAVE_NEW_RUNNER.name());
        saveButtonPanel.add(saveButton, BorderLayout.EAST);
        this.container.add(saveButtonPanel);
    }

    public void reset(){
        this.setSize(DEFAULT_ADD_RUNNER_DIALOG_DIMENSION);
        this.setLocationRelativeTo(null);
        this.idGetter.reset();
        this.firstNameGetter.reset();
        this.secondNameGetter.reset();
        this.lastNameGetter.reset();
        this.genderGetter.resetComponents();
        this.birthDateGetter.reset();
        this.teamGetter.reset();
        this.routeTimeGetter.resetValues();
    }
}