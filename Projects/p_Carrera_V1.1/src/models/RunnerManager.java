package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import exceptions.RunnerNotFound;

public class RunnerManager {

    public static final LocalDate MAX_BIRTH_DATE = LocalDate.of(2008,6,20);
    public static final LocalDate MIN_BIRTH_DATE = LocalDate.of(1970,9,18);
	public static final int VALUE_NOT_FOUND_CODE = -1;
    
	private ArrayList<Runner> runnerList;

    public RunnerManager(){
        this.runnerList = new ArrayList<Runner>();
    }

    public ArrayList<Object[]> getRunnerDataList(){
    	ArrayList<Object[]> runnerListTemp = new ArrayList<>();
        for (Runner runner : runnerList) {
        	runnerListTemp.add(runner.toObjectArray());
        }
        return runnerListTemp;
    }

    public void setRunnerList(ArrayList<Runner> runnerList){
        this.runnerList = runnerList;
    }

    public Runner createRunner(int id, String firstName,String secondName,String lastName,LocalDate birthDate,Gender gender,Team team,LocalTime routeTime){
        return new Runner(id, firstName, secondName, lastName, birthDate, gender, team, routeTime);
    }

    public void addRunner(Runner runner){
        runnerList.add(runner);
    }
    
    public void removeRunner(int runnerId){
    	int position = this.searchRunner(runnerId);
    	if(position != VALUE_NOT_FOUND_CODE)
    		runnerList.remove(position);
    }

    public void orderByTeam(){
    	Collections.sort(runnerList, new Comparator<Runner>(){
			public int compare(Runner r1, Runner r2) {
				return r1.getTeam().getName().compareToIgnoreCase(r2.getTeam().getName());
			}
		});	
    }
   
    public void orderById(){
    	Collections.sort(runnerList, new Comparator<Runner>(){
			public int compare(Runner r1, Runner r2) {
				if (r1.getId() > r2.getId()) return 1;
				else if (r1.getId() < r2.getId()) return -1;
				else return 0;				
			}
		});	
    }
    
    public int searchRunner(int id){
    	this.orderById();
		int position = VALUE_NOT_FOUND_CODE;
		int half;
		int initialP = 0;
		int finalP = this.runnerList.size()-1;
		while(initialP <= finalP && position == VALUE_NOT_FOUND_CODE){
			half = (int)((finalP + initialP)/2);
			if(half >= 0 && half < this.runnerList.size())
				if(id > this.runnerList.get(half).getId())
					initialP = half + 1;
				else if(id < this.runnerList.get(half).getId())
					finalP = half - 1;
				else
					position = half;
		}
		return position;
    }
    
    public LocalTime calculateTimeAverageByTeam(Team team){
        int counter = 0;
        long secondsPlus = 0;
        for (Runner runner : runnerList) {
            if(runner.getTeam().equals(team)){
                secondsPlus += runner.getRouteTime().toSecondOfDay();
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

    public void refactorFirstName(int id,String firstName) throws RunnerNotFound{
        int position = searchRunner(id);
        if(position != VALUE_NOT_FOUND_CODE)
            runnerList.get(searchRunner(id)).setFirstName(firstName);
        else{
            throw new RunnerNotFound(id+"");
        }
    }

    public void refactorSecondName(int id,String secondName) throws RunnerNotFound{
        int position = searchRunner(id);
        if(position != VALUE_NOT_FOUND_CODE)
            runnerList.get(searchRunner(id)).setFirstName(secondName);
        else{
            throw new RunnerNotFound(id+"");
        }
    }

    public void refactorLastName(int id,String lastName) throws RunnerNotFound{
        int position = searchRunner(id);
        if(position != VALUE_NOT_FOUND_CODE)
            runnerList.get(searchRunner(id)).setFirstName(lastName);
        else{
            throw new RunnerNotFound(id+"");
        }
    }

    public void refactorBirthDate(int id,LocalDate birthDate) throws RunnerNotFound{
        int position = searchRunner(id);
        if(position != VALUE_NOT_FOUND_CODE)
            runnerList.get(searchRunner(id)).setBirthDate(birthDate);
        else{
            throw new RunnerNotFound(id+"");
        }
    }

    public void refactorGender(int id,Gender gender) throws RunnerNotFound{
        int position = searchRunner(id);
        if(position != VALUE_NOT_FOUND_CODE)
            runnerList.get(searchRunner(id)).setGender(gender);
        else{
            throw new RunnerNotFound(id+"");
        }
    }

    public void refactorRouteTime(int id,LocalTime routeTime) throws RunnerNotFound{
        int position = searchRunner(id);
        if(position != VALUE_NOT_FOUND_CODE)
            runnerList.get(searchRunner(id)).setRouteTime(routeTime);
        else{
            throw new RunnerNotFound(id+"");
        }
    }

    public void refactorTeam(int id,Team team) throws RunnerNotFound{
        int position = searchRunner(id);
        if(position != VALUE_NOT_FOUND_CODE)
            runnerList.get(searchRunner(id)).setTeam(team);
        else{
            throw new RunnerNotFound(id+"");
        }
    }
}