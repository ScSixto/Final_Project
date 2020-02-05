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

    public static LocalDate toLocalDate(String strDate){
        return LocalDate.parse(strDate,DateTimeFormatter.ofPattern(DATE_FORMAT)); 
    }

    public static LocalTime toLocalTime(String strTime){
        return LocalTime.parse(strTime,DateTimeFormatter.ofPattern(TIME_FORMAT));
    }

    public static long toLong(String string){
        return (string.equals(""))?0:Long.parseLong(string);
    }
    
    public static int toInteger(String string){
        return (string.equals(""))?0:Integer.parseInt(string);
    }

    public static double toDouble(String string){
        return (string.equals(""))?0:Double.parseDouble(string);
    }


    public static RankingCategory toRankingCategoryFormat(String rankingCategoryName){
        RankingCategory rankingCategoryToReturn = null;
        for (RankingCategory rankingCategory : RankingCategory.values()) {
            if(rankingCategoryName.equalsIgnoreCase(rankingCategory.getText())){
                rankingCategoryToReturn = rankingCategory;
                break;
            }
        }
        return rankingCategoryToReturn;
    }
    
    public static DocumentType toDocumentTypeFormat(String documentTypeName){
        DocumentType documentTypeToReturn = null;
        for (DocumentType documentType : DocumentType.values()) {
            if(documentTypeName.equalsIgnoreCase(documentType.getText())){
                documentTypeToReturn = documentType;
                break;
            }
        }
        return documentTypeToReturn;
    }
    
    public static BondingType toBondingTypeFormat(String bondingTypeName){
        BondingType bondingTypeToReturn = null;
        for (BondingType bondingType : BondingType.values()) {
            if(bondingTypeName.equalsIgnoreCase(bondingType.getText())){
                bondingTypeToReturn = bondingType;
                break;
            }
        }
        return bondingTypeToReturn;
    }
}