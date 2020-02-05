package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Util {

    public static LocalDate toLocalDate(String date){
        LocalDate localDate = null;
        if(!date.equals("")){
            String[] dateArray = date.split("-");
            localDate = LocalDate.of(Integer.parseInt(dateArray[0]),Integer.parseInt(dateArray[1]),Integer.parseInt(dateArray[2]));
        }
        return localDate;
    }

    public static int toInteger(String string){
        return (string.equals(""))?0:Integer.parseInt(string);
    }

    public static long toLong(String string){
        return (string.equals(""))?0:Long.parseLong(string);
    }

    public static double toDouble(String string){
        return (string.equals(""))?0:Double.parseDouble(string);
    }

    public static HashMap<TeamVariable, Object> getHeightReportFormat(double heightAverage, ArrayList<HashMap<TeamVariable, Object>> teamList){
        HashMap<TeamVariable, Object> heightReport = new HashMap<>();
        heightReport.put(TeamVariable.HEIGHT_AVERAGE, heightAverage);
        heightReport.put(TeamVariable.TEAM_LIST, teamList);
        return heightReport;
    }
}