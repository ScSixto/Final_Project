package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import exceptions.AlgoNotFound;

public class ClaseManager {

    public static final LocalDate MAX_BIRTH_DATE = LocalDate.of(2008,6,20);
    public static final LocalDate MIN_BIRTH_DATE = LocalDate.of(1970,9,18);
	public static final int VALUE_NOT_FOUND_CODE = -1;
    
	private ArrayList<Algo> algoList;

    public ClaseManager(){
        this.algoList = new ArrayList<Algo>();
    }

    public ArrayList<Object[]> getAlgoDataList(){
    	ArrayList<Object[]> algoListTemp = new ArrayList<>();
        for (Algo algo : algoList) {
        	algoListTemp.add(algo.toObjectArray());
        }
        return algoListTemp;
    }

    public ArrayList<Object[]> getAlgoWinnerDataList(){
        ArrayList<Object[]> algoListTemp = new ArrayList<>();
        for (Algo algo : algoList) {
            Object[] algoObjectArray = new Object[]{algo.getId(),algo.getFirstName(),algo.getSecondName(), algo.getLastName()};
            algoListTemp.add(algoObjectArray);
        }
        return algoListTemp;
    }

    public Algo createAlgo(int id, String firstName,String secondName,String lastName,Team team,LocalTime routeTime){
        return new Algo(id, firstName, secondName, lastName, team, routeTime);
    }

    public void addAlgo(Algo algo){
        algoList.add(algo);
    }

    public void orderByTeam(){
    	Collections.sort(algoList, new Comparator<Algo>(){
			public int compare(Algo r1, Algo r2) {
				return r1.getTeam().getName().compareToIgnoreCase(r2.getTeam().getName());
			}
		});
    }

    public void orderById(){
    	Collections.sort(algoList, new Comparator<Algo>(){
			public int compare(Algo r1, Algo r2) {
				if (r1.getId() > r2.getId()) return 1;
				else if (r1.getId() < r2.getId()) return -1;
				else return 0;				
			}
		});	
    }
    
    public int searchAlgo(int id){
    	this.orderById();
		int position = VALUE_NOT_FOUND_CODE;
		int half;
		int initialP = 0;
		int finalP = this.algoList.size()-1;
		while(initialP <= finalP && position == VALUE_NOT_FOUND_CODE){
			half = (int)((finalP + initialP)/2);
			if(half >= 0 && half < this.algoList.size())
				if(id > this.algoList.get(half).getId())
					initialP = half + 1;
				else if(id < this.algoList.get(half).getId())
					finalP = half - 1;
				else
					position = half;
		}
		return position;
    }
    
    public LocalTime calculateTimeAverageByTeam(Team team){
        int counter = 0;
        long secondsPlus = 0;
        for (Algo algo : algoList) {
            if(algo.getTeam().equals(team)){
                secondsPlus += algo.getRouteTime().toSecondOfDay();
                counter++;
            }
        }
        return LocalTime.of(0,0,0).plusSeconds(secondsPlus/counter);
    }
    
    public HashMap<String,LocalTime> getTimeAverageByTeamList(){
    	HashMap<String,LocalTime> timeAverageByTeamList= new HashMap<String,LocalTime>();
    	for (Team team : Team.values()) {
    		timeAverageByTeamList.put(team.getName(), this.calculateTimeAverageByTeam(team));			
		}
    	return timeAverageByTeamList;
    }

}