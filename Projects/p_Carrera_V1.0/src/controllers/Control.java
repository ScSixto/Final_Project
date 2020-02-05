package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map.Entry;

import exceptions.BirthDateInvalid;
import exceptions.FileFormatInvalid;
import exceptions.InvalidSecondName;
import exceptions.RunnerNotFound;
import models.*;
import persistence.FileManager;
import persistence.RunnerFormat;
import views.*;

public class Control {
	public static final int SHOW_RUNNER_LIST_OPTION = 1;
	public static final int SHOW_RUNNER_TEAM_AVERAGE_OPTION = 2;
	public static final int SHOW_RUNNER_TEAM_AVERAGE_LIST_OPTION = 3;
	public static final int MODIFY_RUNNER_LIST_OPTION = 4;
	public static final int EXIT_OPTION = 0;

	public static final int ADD_RUNNER_OPTION = 1;
	public static final int MODIFY_RUNNER_ATTRIBUTE_OPTION = 2;
	public static final int REMOVE_RUNNER_OPTION = 3;

	public static final String RIDERS_FILE_PATH = "resources/Riders.info";
	public static final String DAMAGED_RIDERS_FILE_PATH = "resources/Damaged.info";
	public static final int MODIFY_FIRST_NAME_OPTION = 1;
	public static final int MODIFY_SECOND_NAME_OPTION = 2;
	public static final int MODIFY_LAST_NAME_OPTION = 3;
	public static final int MODIFY_BIRTHDATE_OPTION = 4;
	public static final int MODIFY_ROUTE_TIME_OPTION = 7;
	public static final int MODIFY_TEAM_OPTION = 6;
	public static final int MODIFY_GENDER_OPTION = 5;

	private FileManager file;
	private View view;
	private RunnerManager runnerManager;

	public Control() {
		view = new View();
		file = new FileManager();
		runnerManager = new RunnerManager();
		init();
	}

	public void init(){
		this.readFile();
		int op;
		try {
			do{
				op = view.getUserMenuOption();
				switch (op) {
					case SHOW_RUNNER_LIST_OPTION:
						this.showRunnerList();
						break;
					case SHOW_RUNNER_TEAM_AVERAGE_OPTION:
						this.showAverageByTeam();
						break;
					case SHOW_RUNNER_TEAM_AVERAGE_LIST_OPTION:
						this.showAverageByTeamList();
						break;
					case MODIFY_RUNNER_LIST_OPTION:
						this.modifyRunnerList();
						break;
					case EXIT_OPTION:
						break;
					default:
						view.showErrorMessage(ErrorMessage.INVALID_VALUE);
						break;
				}
			}while(op != EXIT_OPTION);
		}catch(InputMismatchException e){
			view.showErrorMessage(ErrorMessage.INVALID_VALUE);
		}
	}
	
	private void modifyRunnerList() {
		int op;
		do{
			op = view.getModifyRunnerListOption();;
			switch (op) {
			case ADD_RUNNER_OPTION:
				try {
					this.addRunner();
				} catch (DateTimeParseException | BirthDateInvalid e) {
					view.showErrorMessage(ErrorMessage.INVALID_DATE, e.getMessage());

				}
				break;
			case MODIFY_RUNNER_ATTRIBUTE_OPTION:
				this.modifyRunner();
				break;
			case REMOVE_RUNNER_OPTION:
				this.removeRunner();
				break;
			case EXIT_OPTION:
				break;
			default:
				view.showErrorMessage(ErrorMessage.INVALID_VALUE);
				break;
			}
		}while(op != EXIT_OPTION);
	}

	private void modifyRunner() {
		int op;
		do{
			op = view.getModifyAttributeOption();;
			switch (op) {
			case MODIFY_FIRST_NAME_OPTION:
				this.modifyFirstName();
				break;
			case MODIFY_SECOND_NAME_OPTION:
				this.modifySecondName();
				break;
			case MODIFY_LAST_NAME_OPTION:
				this.modifyLastName();
				break;
			case MODIFY_BIRTHDATE_OPTION:
				this.modifyBirthDate();
				break;
			case MODIFY_ROUTE_TIME_OPTION:
				this.modifyRouteTime();
				break;
			case MODIFY_TEAM_OPTION:
				this.modifyTeam();
				break;
			case MODIFY_GENDER_OPTION:
				this.modifyGender();
				break;
			case EXIT_OPTION:
				break;
			default:
				view.showErrorMessage(ErrorMessage.INVALID_VALUE);
				break;
			}
		}while(op != EXIT_OPTION);
		
	}

	private void modifyFirstName() {
		int id = view.getId();
		try{
			runnerManager.refactorFirstName(id,view.getName());
		}catch(RunnerNotFound e){
			view.showErrorMessage(ErrorMessage.INVALID_ID, e.getMessage());
		}
	}

	private void modifySecondName() {
		int id = view.getId();
		try{
			String secondName = this.getValidSecondName();
			if(Util.isValidSecondName(secondName))
				runnerManager.refactorSecondName(id,secondName);
			else
				view.showErrorMessage(ErrorMessage.INVALID_VALUE, secondName);
		}catch(RunnerNotFound e){
			view.showErrorMessage(ErrorMessage.INVALID_ID, e.getMessage());
		}catch(StringIndexOutOfBoundsException e){
			view.showErrorMessage(ErrorMessage.INVALID_SECOND_NAME);
		}catch (InvalidSecondName e) {
			view.showErrorMessage(ErrorMessage.INVALID_SECOND_NAME, e.getMessage());
		}
	}

	private void modifyLastName() {
		int id = view.getId();
		try{
			runnerManager.refactorLastName(id,view.getLastName());
		}catch(RunnerNotFound e){
			view.showErrorMessage(ErrorMessage.INVALID_ID, e.getMessage());
		}
	}

	private void modifyGender() {
		int id = view.getId();
		try{
			runnerManager.refactorGender(id,this.getGenderSelection());
		}catch(RunnerNotFound e){
			view.showErrorMessage(ErrorMessage.INVALID_ID, e.getMessage());
		}
	}

	private void modifyTeam() {
		int id = view.getId();
		try{
			runnerManager.refactorTeam(id,this.getTeamSelection());
		}catch(RunnerNotFound e){
			view.showErrorMessage(ErrorMessage.INVALID_ID, e.getMessage());
		}
	}

	private void modifyBirthDate() {
		int id = view.getId();
		try{
			runnerManager.refactorBirthDate(id,this.getValidBirthDate());
		}catch(RunnerNotFound e){
			view.showErrorMessage(ErrorMessage.INVALID_ID, e.getMessage());
		}catch(DateTimeParseException | BirthDateInvalid e){
			view.showErrorMessage(ErrorMessage.INVALID_DATE, e.getMessage());
		}
	}

	private void modifyRouteTime() {
		int id = view.getId();
		try{
			runnerManager.refactorRouteTime(id,this.getValidRouteTime());
		}catch(RunnerNotFound e){
			view.showErrorMessage(ErrorMessage.INVALID_ID, e.getMessage());
		}catch(DateTimeParseException e){
			view.showErrorMessage(ErrorMessage.INVALID_VALUE, e.getMessage());
		}
	}

	private LocalDate getValidBirthDate() throws DateTimeParseException, BirthDateInvalid {
		try {
			LocalDate birthDate = Util.toLocalDate(view.getBirthdate());
			if(Util.isValidBirthDate(birthDate))
				return birthDate;
			else{
				throw new BirthDateInvalid(birthDate.toString());
			}
		} catch (DateTimeParseException | BirthDateInvalid e) {
			throw e;
		}
	}

	private LocalTime getValidRouteTime() throws DateTimeParseException{
		try {
			return Util.toLocalTime(view.getBirthdate());
		} catch (DateTimeParseException e) {
			throw e;
		}
	}
	
	private String getValidSecondName() throws InvalidSecondName{
		String secondName = view.getName();
		try{
			if (Util.isValidSecondName(secondName)) {
				return secondName;
			}else{
				throw new InvalidSecondName(secondName);
			}
		}catch(StringIndexOutOfBoundsException e){
			throw new InvalidSecondName();
		}catch(InvalidSecondName e){
			throw new InvalidSecondName(e.getMessage());
		}
	}

	private void removeRunner() {
		int id = view.getId();
		if(runnerManager.searchRunner(id) != RunnerManager.VALUE_NOT_FOUND_CODE){
			runnerManager.removeRunner(id);
		}else{
			view.showErrorMessage(ErrorMessage.INVALID_ID, id+"");
		}
	}

	private void addRunner() throws DateTimeParseException, BirthDateInvalid {
		int id = view.getId();
		if(runnerManager.searchRunner(id) == RunnerManager.VALUE_NOT_FOUND_CODE){
			String firstName = view.getName();
			String secondName = view.getName();
				if(Util.isValidSecondName(secondName)){
					try {
						runnerManager.addRunner(runnerManager.createRunner(id, view.getName(), this.getValidSecondName(), view.getLastName(),this.getValidBirthDate(), this.getGenderSelection(), this.getTeamSelection(), this.getValidRouteTime()));
					} catch (InvalidSecondName e) {
						view.showErrorMessage(ErrorMessage.INVALID_SECOND_NAME, secondName);
					}
				}else
					view.showErrorMessage(ErrorMessage.INVALID_SECOND_NAME, secondName);
		}else{
			view.showErrorMessage(ErrorMessage.INVALID_ID);
		}
	}

	private void readFile() {
		try {
			ArrayList<String[]> damagedRunnerList = new ArrayList<>();
			ArrayList<String[]> runnerDataMatrix = Util.getFileInfo(file.readFile(RIDERS_FILE_PATH));
			for (String[] register : runnerDataMatrix){
				try{
					String secondName = register[RunnerFormat.SECOND_NAME.getFileFormatPosition()];
					LocalDate birthDate = Util.toLocalDate(register[RunnerFormat.BIRTH_DATE.getFileFormatPosition()]);
					if(Util.isValidSecondName(secondName) && Util.isValidBirthDate(birthDate) && runnerManager.searchRunner(Integer.parseInt(register[RunnerFormat.ID.getFileFormatPosition()])) == RunnerManager.VALUE_NOT_FOUND_CODE){	
						runnerManager.addRunner(this.createRunner(register));
					}else{
						damagedRunnerList.add(register);
					}
				}catch(DateTimeParseException e){
					System.out.println(1);
					damagedRunnerList.add(register);
				}
			}
			file.writeFile(DAMAGED_RIDERS_FILE_PATH, Util.toFileInfo(damagedRunnerList));
		}catch (IOException | FileFormatInvalid e) {
			view.showErrorMessage(ErrorMessage.INVALID_FILE,e.getMessage());
		}
	}

	private Runner createRunner(String[] register){
		int id = Integer.parseInt(register[RunnerFormat.ID.getFileFormatPosition()]);
		String secondName = register[RunnerFormat.SECOND_NAME.getFileFormatPosition()];
		LocalDate birthDate = Util.toLocalDate(register[RunnerFormat.BIRTH_DATE.getFileFormatPosition()]);
		String firstName = register[RunnerFormat.FIRST_NAME.getFileFormatPosition()];
		String lastName = register[RunnerFormat.LAST_NAME.getFileFormatPosition()];
		Gender gender = Util.toGender(register[RunnerFormat.GENDER.getFileFormatPosition()]);
		LocalTime routeTime = Util.toLocalTime(register[RunnerFormat.ROUTE_TIME.getFileFormatPosition()]);
		Team team = Util.toTeamFormat(register[RunnerFormat.TEAM.getFileFormatPosition()]);
		return runnerManager.createRunner(id, firstName, secondName, lastName, birthDate, gender, team, routeTime);
	}

	private void showRunnerList(){
		runnerManager.orderById();
		ArrayList<Object[]> runnerDataList = runnerManager.getRunnerDataList();
		if(runnerDataList.size() > 0){
			for (Object[] runner : runnerDataList) {
				runner[6] = ((Team)(runner[6])).getName();
				runner[5] = ((Gender)(runner[5])).getGender();
				runner[4] = Util.formatLocalDate((LocalDate)runner[4]);
				runner[7] = Util.formatLocalTime((LocalTime)runner[7]);
			}
			view.showRunnerList(runnerDataList);
		}else{
			view.showErrorMessage(ErrorMessage.RUNNER_LIST_EMPTY);
		}
	}

	private void showAverageByTeam(){
		try {
			Team team = this.getTeamSelection();
			view.showAverageByTeam(Util.formatLocalTime(runnerManager.calculateTimeAverageByTeam(team)),team.getName());
		} catch (ArithmeticException e) {
			view.showErrorMessage(ErrorMessage.RUNNER_LIST_EMPTY);
		}
	}
	
	private void showAverageByTeamList(){
		try{
			HashMap<String,String> averageByTeamList = new HashMap<>();
			Iterator<Entry<String,LocalTime>>  it = runnerManager.getTimeAverageByTeamList().entrySet().iterator();
			while(it.hasNext()){
				Entry<String,LocalTime> averageByTeam = it.next();
				averageByTeamList.put(averageByTeam.getKey(), Util.formatLocalTime(averageByTeam.getValue()));
			}
			view.showAverageByTeamList(averageByTeamList);
		}catch (ArithmeticException e) {
			view.showErrorMessage(ErrorMessage.RUNNER_LIST_EMPTY);
		}
	}
	
	private Team getTeamSelection(){
		Team teamToReturn = null;
		int op;
		do{
			op = view.getTeam();
			for(Team team : Team.values()) {
				if(op == team.getId()){
					teamToReturn = team;
					break;
				}
			}
		}while(teamToReturn == null && op != EXIT_OPTION);
		return teamToReturn;
	}

	private Gender getGenderSelection(){
		Gender genderToReturn = null;
		int op;
		do{
			op = view.getGender();
			for(Gender gender : Gender.values()) {
				if(op == gender.getId()){
					genderToReturn = gender;
					break;
				}
			}
		}while(genderToReturn == null && op != EXIT_OPTION);
		return genderToReturn;
	}
}