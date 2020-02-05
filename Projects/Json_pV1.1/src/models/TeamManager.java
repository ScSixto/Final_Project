package models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;

public class TeamManager{

    public static final int VALUE_NOT_FOUND_CODE = -1;
    public static final int MAX_PERCENT = 100;

    private ArrayList<Team> teamList;

    public TeamManager(){
        this.teamList = new ArrayList<>();
    }

    public ArrayList<Object[]> getTeamList(){
        ArrayList<Object[]> teamObjectList = new ArrayList<>();
        for(Team team: teamList){
            teamObjectList.add(team.toObjectArray());
        }
        return teamObjectList;
    }

    public ArrayList<HashMap<TeamVariable, Object>> toHashMapList(){
        ArrayList<HashMap<TeamVariable, Object>> teamManagerVariables = new ArrayList<>();
        for(Team team: teamList){
            teamManagerVariables.add(team.toHashMap());
        }
        return teamManagerVariables;
    }

    public void addTeam(Team team){
        teamList.add(team);
    }

    public void addPlayer(Player player, long teamId){
        int teamPosition = this.searchTeam(teamId);
        //System.out.println("Position: " + teamPosition);
        if(teamPosition != -1){
            this.teamList.get(teamPosition).addPlayer(player);
        }
    }

    public int searchTeam(long id){
        int position = VALUE_NOT_FOUND_CODE;
        int i = 0;
        while(i < teamList.size() && position == VALUE_NOT_FOUND_CODE){
            if(teamList.get(i).getId() == id){
                position = i;
            }
            i++;
        }
        return position;
    }

    public double getHeightAverage(){
        double heightPlus = 0;
        if(this.teamList.size() > 0){
            DecimalFormat decimalFormat = new DecimalFormat("#.000");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            for(Team team: teamList){
                heightPlus += Double.parseDouble(decimalFormat.format(team.getHeightAverage()));
            }
            heightPlus = Double.parseDouble(decimalFormat.format(heightPlus / this.teamList.size()));
        }
        return heightPlus;
    }

    public ArrayList<HashMap<TeamVariable, Object>> getPlayerListAboveHeightAverageByTeams(){
        ArrayList<HashMap<TeamVariable, Object>> heightReport = new ArrayList<>();
        for(Team team: this.teamList){
            heightReport.add(team.getPlayerListAboveAverage());
        }
        return heightReport;
    }

    public ArrayList<HashMap<TeamVariable, Object>> getPlayerListAboveHeightAverage(){
        ArrayList<HashMap<TeamVariable, Object>> heightReport = new ArrayList<>();
        for(Team team: this.teamList){
            heightReport.add(team.getPlayerListAboveAverage(this.getHeightAverage()));
        }
        return heightReport;
    }

    public ArrayList<HashMap<TeamVariable, Object>> getPlayerListAboveAge(int yearAge){
        ArrayList<HashMap<TeamVariable, Object>> ageReport = new ArrayList<>();
        for(Team team: this.teamList){
            ageReport.add(team.getPlayerListAboveAge(yearAge));
        }
        return ageReport;
    }

    /*
        public int searchTeam(long id){
            this.organizeEployeesByCode();
            int position = VALUE_NOT_FOUND_CODE;//this.valuePosition(id);
            int half;
            int initialP = 0;
            int finalP = this.teamList.size();
            while(initialP <= finalP && position == VALUE_NOT_FOUND_CODE){
                //System.out.println("m");
                half = (int)((finalP + initialP)/2);
                if(half >= 0 && half < this.teamList.size())
                    if(id > this.teamList.get(half).getId())
                        initialP = half + 1;
                    else if(id < this.teamList.get(half).getId())
                        finalP = half - 1;
                    else
                        position = half;
            }
            return position;
        }
    */
/*
    public void organizeEployeesByCode(){
        Team teamTempI;
        Team teamTempJ;
        Iterator<Team> i = this.teamList.iterator();
        Iterator<Team> j = this.teamList.iterator();
        while (i.hasNext()){
            teamTempI = i.next();
            while(j.hasNext()){
                teamTempJ = j.next();
                if(i.next().getId() > j.next().getId()){
                    this.teamList.set(this.teamList.indexOf(teamTempI), teamTempJ);
                    this.teamList.set(this.teamList.indexOf(teamTempJ), teamTempI);
                }
            }
        }
    }
*/
    public void showConsoleReport(){
        for(Team team: teamList){
            System.out.println(team.getName() + " (" + team.getId() + ")");
            for(Player player: team.getPlayerList()){
                System.out.println("\t" + player.getFirstName() + " (" + player.getTeamId() + ") ." + player.getPlayerId() + ".");
            }
        }
    }
}