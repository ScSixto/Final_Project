package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Util {

    public static final String DATE_FORMAT = "M/d/yyyy";
    public static final String TIME_FORMAT = "HH:mm:ss";
	public static final String TIME_STRING_FORMAT = "%02d:%02d:%02d";
	public static final String DATA_STRING_FORMAT = "%02d/%02d/%04d";
    public static final char FIELD_SEPARATOR = '?';
    public static final int MAX_REGEXP_QUANTITY = 5;
    public static final int MIN_REGEXP_QUANTITY = 1;


    public static String[] getFieldList(String register){
        return register.split("\\?+");
    }

    public static ArrayList<String[]> getFileInfo(ArrayList<String> fileReading){
        ArrayList<String[]> fileInfo = new ArrayList<>();
        for (String register : fileReading) {
            fileInfo.add(getFieldList(register));
        }
        return fileInfo;
    }

    public static boolean  isValidSecondName(String secondName){
        boolean isValidSecondName;
        if(!secondName.equals("")){
            isValidSecondName = (secondName.charAt(0) >= 65 && secondName.charAt(0) <= 90) || (secondName.charAt(0) >= 192 && secondName.charAt(0) <= 220);
        }else{
            isValidSecondName = true;
        }
        return isValidSecondName;
    }

    public static boolean isValidBirthDate(LocalDate birthDate){
        return (birthDate.isBefore(RunnerManager.MAX_BIRTH_DATE) && birthDate.isAfter(RunnerManager.MIN_BIRTH_DATE));
    }

    public static Gender toGender(String strGender){
        Gender gender = null;
        if(strGender.equalsIgnoreCase(Gender.MALE.getGender())){
            gender = Gender.MALE;
        }else if(strGender.equalsIgnoreCase(Gender.FEMALE.getGender())){
            gender = Gender.FEMALE;
        }
        return gender;
    }

    public static LocalDate toLocalDate(String strDate){
        return LocalDate.parse(strDate,DateTimeFormatter.ofPattern(DATE_FORMAT)); 
    }

    public static LocalTime toLocalTime(String strTime){
        return LocalTime.parse(strTime,DateTimeFormatter.ofPattern(TIME_FORMAT));
    }

    public static String getRegexSeparator(){
        String separator = "";
        int separatorQuantity = getRandomNumBetween(MIN_REGEXP_QUANTITY, MAX_REGEXP_QUANTITY);
        for(int i = MIN_REGEXP_QUANTITY; i <= separatorQuantity; i++) {
            separator += FIELD_SEPARATOR;
        }
        return separator;
    }

    public static String toRegister(String[] fieldArray){
        String register = "";
        for (int i = 0; i < (fieldArray.length - 1); i++) {
            register += fieldArray[i] + getRegexSeparator();
        }
        register += fieldArray[fieldArray.length - 1];
        return register;
    }

    public static String[] toFileInfo(ArrayList<String[]> registerList){
        String[] fileInfo = new String[registerList.size()];   
        for (int i = 0; i < registerList.size(); i++) {
            fileInfo[i] = toRegister(registerList.get(i));
        }
        return fileInfo;
    }
    
    public static int getRandomNumBetween(int minValue, int maxValue){
        return (int) (((Math.random() * (maxValue - minValue))) + minValue);
    }

    public static String formatLocalTime(LocalTime time){
        return String.format(TIME_STRING_FORMAT, time.getHour(), time.getMinute(), time.getSecond());
    }

    public static String formatLocalDate(LocalDate date){
        return String.format(DATA_STRING_FORMAT, date.getDayOfMonth(), date.getMonthValue(), date.getYear());
    }

    public static Team toTeamFormat(String teamName){
        Team teamToReturn = null;
        for (Team team : Team.values()) {
            if(teamName.equalsIgnoreCase(team.getName())){
                teamToReturn = team;
                break;
            }
        }
        return teamToReturn;
    }

    public static boolean isTeamFormat(String teamName){
        boolean isTeam = false;
        for(int i = 0; i < Team.values().length && !isTeam; i++) {
            isTeam = teamName.equalsIgnoreCase(Team.values()[i].getName());
        }
        return isTeam;
    }
}